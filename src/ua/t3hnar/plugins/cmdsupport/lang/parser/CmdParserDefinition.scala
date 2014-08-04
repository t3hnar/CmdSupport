package ua.t3hnar.plugins.cmdsupport.lang.parser

import com.intellij.psi.FileViewProvider
import com.intellij.openapi.project.Project
import com.intellij.lang.{ASTNode, ParserDefinition}
import ua.t3hnar.plugins.cmdsupport.lang.lexer.{CmdTokenType, CmdLexer}
import com.intellij.psi.tree.IFileElementType
import ua.t3hnar.plugins.cmdsupport.lang.CmdLanguage
import com.intellij.psi.util.PsiUtilCore
import ua.t3hnar.plugins.cmdsupport.lang.psi.CmdFile

/**
 * @author Yaroslav Klymko aka t3hnar
 */

class CmdParserDefinition extends ParserDefinition {

	def getStringLiteralElements = CmdTokenType.STRING_LITERALS

	def getFileNodeType = CmdParserDefinition.FILE

	def createElement(node: ASTNode) = PsiUtilCore.NULL_PSI_ELEMENT

	def createParser(project: Project) = new CmdParser

	def getWhitespaceTokens = CmdTokenType.WHITE_SPACES

	def createLexer(project: Project) = new CmdLexer

	def getCommentTokens = CmdTokenType.COMMENTS

	def spaceExistanceTypeBetweenTokens(node1: ASTNode, node2: ASTNode) = null

	def createFile(provider: FileViewProvider) = new CmdFile(provider)
}

private object CmdParserDefinition {

	val FILE = new IFileElementType(CmdLanguage)
}