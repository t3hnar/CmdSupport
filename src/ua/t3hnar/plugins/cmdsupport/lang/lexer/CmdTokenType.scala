package ua.t3hnar.plugins.cmdsupport.lang.lexer

import com.intellij.psi.TokenType
import com.intellij.psi.tree.{IFileElementType, IElementType, TokenSet}
import ua.t3hnar.plugins.cmdsupport.lang.parser.CmdElementType
import ua.t3hnar.plugins.cmdsupport.lang.CmdLanguage

/**
 * @author Yaroslav Klymko aka t3hnar
 */
object CmdTokenType {
	val FILE = new IFileElementType(CmdLanguage)

	val REM: IElementType = new CmdElementType("rem")
	val COMMENTS = TokenSet.create(REM);

	val WHITESPACE: IElementType = TokenType.WHITE_SPACE
	val WHITESPACE_SET = TokenSet.create(TokenType.WHITE_SPACE)

	val CALL = new CmdElementType("call")

}
