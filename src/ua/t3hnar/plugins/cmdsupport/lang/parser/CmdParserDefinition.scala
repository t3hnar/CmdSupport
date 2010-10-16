package ua.t3hnar.plugins.cmdsupport.lang.parser

import com.intellij.psi.FileViewProvider
import com.intellij.openapi.project.Project
import com.intellij.lang.{ASTNode, ParserDefinition}
import lexer.{CmdTokenType, CmdLexer}

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class CmdParserDefinition extends ParserDefinition {
	def getStringLiteralElements = null

	def getFileNodeType = CmdTokenType.FILE

	def createElement(node: ASTNode) = null

	def createParser(project: Project) = null

	def getWhitespaceTokens = CmdTokenType.WHITESPACE_SET

	def createLexer(project: Project) = new CmdLexer

	def getCommentTokens = CmdTokenType.COMMENTS

	def spaceExistanceTypeBetweenTokens(node1: ASTNode, node2: ASTNode) = null

	def createFile(provider: FileViewProvider) = null
}