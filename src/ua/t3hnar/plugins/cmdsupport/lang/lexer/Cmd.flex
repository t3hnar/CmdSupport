package ua.t3hnar.plugins.cmdsupport.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
%%

%class JCmdLexer
%implements FlexLexer
%final
%ignorecase
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

WhiteSpace = [ \t]
LineTerminator = \r\n|[\r\n\u2028\u2029\u000B\u000C\u0085]
StringLiteral = \" ( \\\" | [^\"\n\r] )* \"
Exp = [^ \t\f\n\r\:\;\,\|\&\<\>]+
CommandTerminator = "|""|"? | "&""&"? | "<""<"? | ">"">"?
EscapeCharacter = "^".

%state NEXT_SYM, CALL, ECHO, ECHO_SYM, FOR, FOR_IN, GOTO, IF, IF_EXIST, IF_DIGIT, IF_VARIABLE, IF_EQUAL, REM, SET, SET_VALUE, COMMAND, LABEL

%%
<YYINITIAL> {
    {WhiteSpace}+       { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    "@"{Exp}            { yybegin(YYINITIAL); yypushback(yylength() - 1); return CmdTokenType.ECHO_OFF_MARKER; }
    {Exp}               { yybegin(COMMAND); yypushback(yylength()); }
    {EscapeCharacter}   { yybegin(YYINITIAL); return CmdTokenType.EXPRESSION;}
    {StringLiteral}     { yybegin(YYINITIAL); return CmdTokenType.STRING_LITERAL;}
    "::"                { yybegin(REM); yypushback(yylength()); }
    ":"                 { yybegin(LABEL); return CmdTokenType.LABEL_MARKER; }
    "&"                 { yybegin(YYINITIAL); return CmdTokenType.APPEND_OPERATOR; }
    "|"                 { yybegin(YYINITIAL); return CmdTokenType.PIPE_OPERATOR; }
    "&&"                { yybegin(YYINITIAL); return CmdTokenType.AND_OPERATOR; }
    "||"                { yybegin(YYINITIAL); return CmdTokenType.OR_OPERATOR; }
    "<""<"?             { yybegin(YYINITIAL); return CmdTokenType.GET_OPERATOR; }
    ">"">"?             { yybegin(YYINITIAL); return CmdTokenType.PUT_OPERATOR; }
    .                   { yybegin(NEXT_SYM); yypushback(yylength()); }
}

<LABEL> {
    {WhiteSpace}+       { yybegin(LABEL); return CmdTokenType.WHITE_SPACE; }
    {Exp}               { yybegin(REM);  return CmdTokenType.LABEL; }
    {LineTerminator}+   { return CmdTokenType.BAD_CHARACTER; }
    .                   { yybegin(REM); yypushback(yylength()); }
}

<NEXT_SYM> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(NEXT_SYM); return CmdTokenType.WHITE_SPACE; }
    {Exp}               { yybegin(COMMAND); yypushback(yylength()); }
    {EscapeCharacter}   { yybegin(NEXT_SYM); return CmdTokenType.EXPRESSION;}
    {StringLiteral}     { yybegin(NEXT_SYM); return CmdTokenType.STRING_LITERAL;}
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    .                   { yybegin(NEXT_SYM); return CmdTokenType.EXPRESSION; }
}

<COMMAND> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    "call"              { yybegin(CALL); return CmdTokenType.CALL_KEYWORD; }
    "goto"              { yybegin(GOTO); return CmdTokenType.GOTO_KEYWORD; }
    "echo"              { yybegin(ECHO); return CmdTokenType.ECHO_KEYWORD; }
    "for"               { yybegin(FOR); return CmdTokenType.FOR_KEYWORD; }
    "if"                { yybegin(IF); return CmdTokenType.IF_KEYWORD; }
    "else"              { yybegin(COMMAND); return CmdTokenType.ELSE_KEYWORD; }
    "rem"               { yybegin(REM); yypushback(yylength()); }
    "set"               { yybegin(SET); return CmdTokenType.SET_KEYWORD; }

    {WhiteSpace}+       { yybegin(COMMAND); return CmdTokenType.WHITE_SPACE; }
    {StringLiteral}     { yybegin(COMMAND); return CmdTokenType.STRING_LITERAL;}
    {EscapeCharacter}   { yybegin(COMMAND); return CmdTokenType.EXPRESSION;}
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    {Exp}               { yybegin(COMMAND); return CmdTokenType.EXPRESSION; }
    .                   { yybegin(COMMAND); return CmdTokenType.EXPRESSION; }
}

<CALL> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(CALL); return CmdTokenType.WHITE_SPACE; }
    {StringLiteral}     { yybegin(CALL); return CmdTokenType.STRING_LITERAL;}
    {EscapeCharacter}   { yybegin(CALL); return CmdTokenType.EXPRESSION;}
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    ":"{Exp}            { yybegin(CALL); return CmdTokenType.LABEL_REFERENCE; }
    {Exp}               { yybegin(CALL); return CmdTokenType.EXPRESSION; }
    .                   { yybegin(CALL); return CmdTokenType.BAD_CHARACTER; }
}

<GOTO> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(GOTO); return CmdTokenType.WHITE_SPACE; }
    "/?"                { yybegin(GOTO); return CmdTokenType.EXPRESSION; }
    ":"{Exp}            { yybegin(GOTO); return CmdTokenType.LABEL_REFERENCE;}
    {Exp}               { yybegin(GOTO); return CmdTokenType.LABEL_REFERENCE;}
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    .                   { yybegin(GOTO); return CmdTokenType.BAD_CHARACTER; }
}

<ECHO> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(ECHO); return CmdTokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    "on"                { yybegin(YYINITIAL); return CmdTokenType.ON_KEYWORD; }
    "off"               { yybegin(YYINITIAL); return CmdTokenType.OFF_KEYWORD; }

    {StringLiteral}     { yybegin(ECHO_SYM); return CmdTokenType.STRING_LITERAL;}
    {EscapeCharacter}   { yybegin(ECHO_SYM); return CmdTokenType.STRING_LITERAL;}
    {Exp}               { yybegin(ECHO_SYM); return CmdTokenType.STRING_LITERAL;}
    .                   { yybegin(ECHO_SYM); return CmdTokenType.STRING_LITERAL; }
}

<ECHO_SYM> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(ECHO_SYM); return CmdTokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    {StringLiteral}     { yybegin(ECHO_SYM); return CmdTokenType.STRING_LITERAL;}
    {EscapeCharacter}   { yybegin(ECHO_SYM); return CmdTokenType.STRING_LITERAL;}
    {Exp}               { yybegin(ECHO_SYM); return CmdTokenType.STRING_LITERAL;}
    .                   { yybegin(ECHO_SYM); return CmdTokenType.STRING_LITERAL; }
}

<FOR> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(FOR); return CmdTokenType.WHITE_SPACE; }
    "in"                { yybegin(FOR_IN); return CmdTokenType.IN_KEYWORD; }
    "do"                { yybegin(YYINITIAL); return CmdTokenType.DO_KEYWORD; }
    .                   { yybegin(FOR); return CmdTokenType.EXPRESSION; }
}

<FOR_IN> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(FOR_IN); return CmdTokenType.WHITE_SPACE; }
    "("                 { yybegin(FOR_IN); return CmdTokenType.LEFT_PARENTHESIS; }
    ")"                 { yybegin(FOR); return CmdTokenType.RIGHT_PARENTHESIS; }
    .                   { yybegin(FOR_IN); return CmdTokenType.EXPRESSION; }
}

<IF> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(IF); return CmdTokenType.WHITE_SPACE; }
    "not"               { yybegin(IF); return CmdTokenType.NOT_KEYWORD; }
    "exist"             { yybegin(IF_EXIST); return CmdTokenType.EXIST_KEYWORD; }
    "errorlevel"        { yybegin(IF_DIGIT); return CmdTokenType.ERRORLEVEL_KEYWORD; }
    "cmdextversion"     { yybegin(IF_DIGIT); return CmdTokenType.CMDEXTVERSION_KEYWORD; }
    "defined"           { yybegin(IF_VARIABLE); return CmdTokenType.DEFINED_KEYWORD; }
    {StringLiteral}     { yybegin(IF); return CmdTokenType.STRING_LITERAL;}
    "=="                { yybegin(IF_EQUAL); return CmdTokenType.EQUAL_OPERATOR; }
    .                   { yybegin(IF); return CmdTokenType.EXPRESSION; }
}

<IF_EQUAL> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(IF_EQUAL); return CmdTokenType.WHITE_SPACE; }
    {StringLiteral}     { yybegin(YYINITIAL); return CmdTokenType.STRING_LITERAL;}
    {Exp}               { yybegin(YYINITIAL); yypushback(yylength()); }
    .                   { yybegin(IF_EQUAL); return CmdTokenType.BAD_CHARACTER; }
}

<IF_EXIST> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(IF_EXIST); return CmdTokenType.WHITE_SPACE; }
    {StringLiteral}     { yybegin(IF_EXIST); return CmdTokenType.STRING_LITERAL;}
    {EscapeCharacter}   { yybegin(IF_EXIST); return CmdTokenType.EXPRESSION;}
    {Exp}               { yybegin(YYINITIAL); yypushback(yylength()); }
    .                   { yybegin(IF_EXIST); return CmdTokenType.BAD_CHARACTER; }
}

<IF_DIGIT> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(IF_DIGIT); return CmdTokenType.WHITE_SPACE; }
    [:digit:]+          { yybegin(YYINITIAL); return CmdTokenType.DIGIT;}
    .                   { yybegin(IF_DIGIT); return CmdTokenType.BAD_CHARACTER; }
}

<IF_VARIABLE> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(IF_VARIABLE); return CmdTokenType.WHITE_SPACE; }
    .                   { yybegin(IF_VARIABLE); return CmdTokenType.BAD_CHARACTER; }
}

<REM> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    .                   { yybegin(REM); return CmdTokenType.COMMENT; }
}

<SET> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(SET); return CmdTokenType.WHITE_SPACE; }
    "="[ \t]*{Exp}      { yybegin(SET_VALUE); yypushback(yylength() - 1); return CmdTokenType.EQUAL_OPERATOR; }
    {Exp}[ \t]*"="      { yybegin(SET); yypushback(1); return CmdTokenType.ENVIRONMENT_VARIABLE_DEFINITION;}
    "="                 { yybegin(SET_VALUE); return CmdTokenType.EQUAL_OPERATOR; }
    .                   { yybegin(SET); return CmdTokenType.BAD_CHARACTER; }
}

<SET_VALUE> {
    {LineTerminator}+   { yybegin(YYINITIAL); return CmdTokenType.WHITE_SPACE; }
    {WhiteSpace}+       { yybegin(SET_VALUE); return CmdTokenType.WHITE_SPACE; }
    {StringLiteral}     { yybegin(SET_VALUE); return CmdTokenType.STRING_LITERAL;}
    .                   { yybegin(SET_VALUE); return CmdTokenType.EXPRESSION; }
}

