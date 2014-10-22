package ua.t3hnar.plugins.cmdsupport.editor.highlighter

import com.intellij.openapi.fileTypes.{SyntaxHighlighterFactory, SyntaxHighlighterBase}
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType
import ua.t3hnar.plugins.cmdsupport.lang.lexer.CmdLexer
import ua.t3hnar.plugins.cmdsupport.lang.lexer.CmdTokenType._
import CmdTextAttributes._


class CmdSyntaxHighlighter extends SyntaxHighlighterBase {

  import CmdSyntaxHighlighter._

  def getTokenHighlights(elementType: IElementType) = Map.get(elementType).toArray

  def getHighlightingLexer = new CmdLexer
}

object CmdSyntaxHighlighter {
  lazy val Map: Map[IElementType, TextAttributesKey] = {
    List[(TextAttributesKey, Array[IElementType])](
      Comment -> Array(COMMENT),
      Braces -> BRACES,
      Brackets -> BRACKETS,
      Parenths -> PARENTHESES,
      OperationSign -> OPERATORS,
      Number -> Array(DIGIT),
      Variable -> Array(VARIABLE),
      EnvVariable -> Array(ENVIRONMENT_VARIABLE),
      EnvVariableDefinition -> Array(ENVIRONMENT_VARIABLE_DEFINITION),
      Label -> Array(LABEL),
      LabelReference -> Array(LABEL_REFERENCE),
      Expression -> Array(EXPRESSION, ECHO_OFF_MARKER, LABEL_MARKER),
      BadCharacter -> Array(BAD_CHARACTER),
      Comment -> Array(COMMENT),
      String -> Array(STRING_LITERAL),
      Keyword -> KEYWORDS).flatMap { case (v, ks) => ks.map(k => k -> v)}.toMap
  }
}

class CmdSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
  def getSyntaxHighlighter(project: Project, virtualFile: VirtualFile) = new CmdSyntaxHighlighter
}