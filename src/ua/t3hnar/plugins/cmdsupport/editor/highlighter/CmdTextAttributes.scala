package ua.t3hnar.plugins.cmdsupport.editor.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey.{createTextAttributesKey => create}
import com.intellij.openapi.editor.{DefaultLanguageHighlighterColors => DC, HighlighterColors => HC}


object CmdTextAttributes {
  val Comment               = create("CMD_COMMENT",                 DC.LINE_COMMENT)
  val String                = create("CMD_STRING",                  DC.STRING)
  val Variable              = create("CMD_VARIABLE",                DC.LOCAL_VARIABLE)
  val EnvVariable           = create("CMD_ENV_VARIABLE",            DC.INSTANCE_FIELD)
  val EnvVariableDefinition = create("CMD_ENV_VARIABLE_DEFINITION", DC.INSTANCE_FIELD)
  val Label                 = create("CMD_LABEL",                   DC.FUNCTION_DECLARATION)
  val LabelReference        = create("CMD_LABEL_REFERENCE",         DC.FUNCTION_CALL)
  val Expression            = create("CMD_EXPRESSION",              DC.FUNCTION_CALL)
  val Number                = create("CMD_NUMBER",                  DC.NUMBER)
  val OperationSign         = create("CMD_OPERATION_SIGN",          DC.OPERATION_SIGN)
  val Braces                = create("CMD_BRACES",                  DC.BRACES)
  val Brackets              = create("CMD_BRACKETS",                DC.BRACKETS)
  val Parenths              = create("CMD_PARENTHS",                DC.PARENTHESES)
  val Keyword               = create("CMD_KEYWORD",                 DC.KEYWORD)
  val BadCharacter          = create("CMD_BAD_CHARACTER",           HC.BAD_CHARACTER)
}