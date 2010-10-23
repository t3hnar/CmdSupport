package ua.t3hnar.plugins.cmdsupport.editor.highlighting

import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import ua.t3hnar.plugins.cmdsupport.lang.lexer.CmdLexer
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.markup.TextAttributes
import java.awt.Color

/**
 * @author Yaroslav Klymko aka t3hnar
 */

class CmdSyntaxHighlighter extends SyntaxHighlighterBase {
  val LOG = Logger.getInstance("CmdSyntaxHighlighter");

  def getTokenHighlights(elementType: IElementType) = {
    val key: TextAttributesKey = TextAttributesKey.createTextAttributesKey("call", new TextAttributes(Color.RED, Color.RED, null, null, 0))
    Array(key)
  }

  def getHighlightingLexer = new CmdLexer
}