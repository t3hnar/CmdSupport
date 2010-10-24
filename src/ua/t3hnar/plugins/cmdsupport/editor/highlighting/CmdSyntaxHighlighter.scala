package ua.t3hnar.plugins.cmdsupport.editor.highlighting

import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.markup.TextAttributes
import java.awt.Color
import ua.t3hnar.plugins.cmdsupport.lang.lexer.CmdLexer
import com.intellij.openapi.diagnostic.Logger

/**
 * @author Yaroslav Klymko aka t3hnar
 */

class CmdSyntaxHighlighter extends SyntaxHighlighterBase {

	private val log = Logger.getInstance(classOf[CmdSyntaxHighlighter].getName)
	private val lexer = new CmdLexer

	def getTokenHighlights(elementType: IElementType) = {
		log.info("elementType: " + elementType)

		val key: TextAttributesKey = TextAttributesKey.createTextAttributesKey("call", new TextAttributes(Color.RED, null, null, null, 0))
		Array(key)
	}

	def getHighlightingLexer = lexer;
}