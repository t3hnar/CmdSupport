package ua.t3hnar.plugins.cmdsupport.editor.highlighting

import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import ua.t3hnar.plugins.cmdsupport.lang.lexer.CmdLexer
import com.intellij.openapi.diagnostic.Logger

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class CmdSyntaxHighlighter extends SyntaxHighlighterBase {
	val LOG = Logger.getInstance("CmdSyntaxHighlighter");
	def getTokenHighlights(elementType: IElementType) = {
		LOG.debug("getTokenHighlights")
		null
	}

	def getHighlightingLexer = new CmdLexer
}