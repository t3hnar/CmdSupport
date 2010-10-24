package ua.t3hnar.plugins.cmdsupport.lang.parser

import com.intellij.psi.FileViewProvider
import com.intellij.openapi.project.Project
import com.intellij.lang.{ASTNode, ParserDefinition}
/**
 * @author Yaroslav Klymko aka t3hnar
 */

class CmdParserDefinition extends ParserDefinition {

	def getStringLiteralElements = null

	def getFileNodeType = null

	def createElement(node: ASTNode) = null

	def createParser(project: Project) = null

	def getWhitespaceTokens = null

	def createLexer(project: Project) = null

	def getCommentTokens = null

	def spaceExistanceTypeBetweenTokens(node1: ASTNode, node2: ASTNode) = null

	def createFile(provider: FileViewProvider) = null
}