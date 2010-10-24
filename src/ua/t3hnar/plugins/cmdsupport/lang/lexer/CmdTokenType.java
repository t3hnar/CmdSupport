/*
 * Copyright 2010 Yaroslav Klymko aka t3hnar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ua.t3hnar.plugins.cmdsupport.lang.lexer;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import ua.t3hnar.plugins.cmdsupport.lang.parser.CmdElementType;

/**
 * @author Yaroslav Klymko aka t3hnar
 */
public interface CmdTokenType {
// ------------------------------ FIELDS ------------------------------

	IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;
	IElementType WHITE_SPACE = TokenType.WHITE_SPACE;

	IElementType STRING_LITERAL = new CmdElementType("STRING_LITERAL");
	IElementType IDENTIFIER = new CmdElementType("IDENTIFIER");
	IElementType VARIABLE = new CmdElementType("VARIABLE");
	IElementType ENVIRONMENT_VARIABLE = new CmdElementType("ENVIRONMENT_VARIABLE");
	IElementType ENVIRONMENT_VARIABLE_DEFINITION = new CmdElementType("ENVIRONMENT_VARIABLE_DEFINITION");
	IElementType EXPRESSION = new CmdElementType("EXPRESSION");
	IElementType DIGIT = new CmdElementType("DIGIT");
	IElementType LABEL = new CmdElementType("LABEL");
	IElementType LABEL_REFERENCE = new CmdElementType("LABEL_REFERENCE");

	IElementType COMMENT = new CmdElementType("COMMENT");

	IElementType ECHO_OFF_MARKER = new CmdElementType("ECHO_OFF_MARKER");
	IElementType LABEL_MARKER = new CmdElementType("LABEL_MARKER");

	IElementType EQUAL_OPERATOR = new CmdElementType("EQUAL_OPERATOR");
	IElementType OR_OPERATOR = new CmdElementType("OR_OPERATOR");
	IElementType AND_OPERATOR = new CmdElementType("AND_OPERATOR");
	IElementType APPEND_OPERATOR = new CmdElementType("APPEND_OPERATOR");
	IElementType PUT_OPERATOR = new CmdElementType("PUT_OPERATOR");
	IElementType GET_OPERATOR = new CmdElementType("GET_OPERATOR");
	IElementType PIPE_OPERATOR = new CmdElementType("PIPE_OPERATOR");

	IElementType ECHO_KEYWORD = new CmdElementType("ECHO_KEYWORD");
	IElementType GOTO_KEYWORD = new CmdElementType("GOTO_KEYWORD");
	IElementType CALL_KEYWORD = new CmdElementType("CALL_KEYWORD");
	IElementType IF_KEYWORD = new CmdElementType("IF_KEYWORD");
	IElementType EXIST_KEYWORD = new CmdElementType("EXIST_KEYWORD");
	IElementType NOT_KEYWORD = new CmdElementType("NOT_KEYWORD");
	IElementType DEFINED_KEYWORD = new CmdElementType("DEFINED_KEYWORD");
	IElementType FOR_KEYWORD = new CmdElementType("FOR_KEYWORD");
	IElementType IN_KEYWORD = new CmdElementType("FOR_KEYWORD");
	IElementType DO_KEYWORD = new CmdElementType("DO_KEYWORD");
	IElementType ERRORLEVEL_KEYWORD = new CmdElementType("ERRORLEVEL_KEYWORD");
	IElementType ON_KEYWORD = new CmdElementType("ON_KEYWORD");
	IElementType OFF_KEYWORD = new CmdElementType("OFF_KEYWORD");
	IElementType ELSE_KEYWORD = new CmdElementType("ELSE_KEYWORD");
	IElementType SET_KEYWORD = new CmdElementType("SET_KEYWORD");
	IElementType CMDEXTVERSION_KEYWORD = new CmdElementType("CMDEXTVERSION_KEYWORD");

	IElementType LEFT_BRACE = new CmdElementType("LEFT_BRACE");
	IElementType RIGHT_BRACE = new CmdElementType("RIGHT_BRACE");
	IElementType RIGHT_BRACKET = new CmdElementType("RIGHT_BRACKET");
	IElementType LEFT_BRACKET = new CmdElementType("LEFT_BRACKET");
	IElementType RIGHT_PARENTHESIS = new CmdElementType("RIGHT_PARENTHESIS");
	IElementType LEFT_PARENTHESIS = new CmdElementType("LEFT_PARENTHESIS");

	IElementType[] KEYWORDS = {
			ECHO_KEYWORD,
			GOTO_KEYWORD,
			CALL_KEYWORD,
			IF_KEYWORD,
			EXIST_KEYWORD,
			NOT_KEYWORD,
			DEFINED_KEYWORD,
			FOR_KEYWORD,
			IN_KEYWORD,
			DO_KEYWORD,
			ERRORLEVEL_KEYWORD,
			ON_KEYWORD,
			OFF_KEYWORD,
			ELSE_KEYWORD,
			SET_KEYWORD,
			CMDEXTVERSION_KEYWORD
	};

	IElementType[] OPERATORS = {
			EQUAL_OPERATOR,
			OR_OPERATOR,
			AND_OPERATOR,
			PIPE_OPERATOR,
			APPEND_OPERATOR,
			PUT_OPERATOR,
			GET_OPERATOR
	};

	IElementType[] BRACES = {
			LEFT_BRACE,
			RIGHT_BRACE
	};

	IElementType[] BRACKETS = {
			LEFT_BRACKET,
			RIGHT_BRACKET
	};

	IElementType[] PARENTHESES = {
			LEFT_PARENTHESIS,
			RIGHT_PARENTHESIS
	};
}
