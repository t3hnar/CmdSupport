package ua.t3hnar.plugins.cmdsupport.editor.highlighter

import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.editor.colors.TextAttributesKey
import ua.t3hnar.plugins.cmdsupport.lang.lexer.{CmdTokenType, CmdLexer}
import com.intellij.psi.tree.IElementType
import scala.collection.mutable.Map

/**
 * @author Yaroslav Klymko aka t3hnar
 */

class CmdSyntaxHighlighter extends SyntaxHighlighterBase {

	private val log = Logger.getInstance(classOf[CmdSyntaxHighlighter].getName)
	private val lexer = new CmdLexer
	private val map: Map[IElementType, TextAttributesKey] = {
		val map = Map[IElementType, TextAttributesKey]()
		append(map, CmdTokenType.COMMENT, CmdTextAttributesKey.comment)
		append(map, CmdTokenType.BRACES, CmdTextAttributesKey.braces)
		append(map, CmdTokenType.BRACKETS, CmdTextAttributesKey.brackets)
		append(map, CmdTokenType.PARENTHESES, CmdTextAttributesKey.parenths)
		append(map, CmdTokenType.OPERATORS, CmdTextAttributesKey.operationSign)
		append(map, CmdTokenType.DIGIT, CmdTextAttributesKey.number)
		append(map, CmdTokenType.VARIABLE, CmdTextAttributesKey.variable)
		append(map, CmdTokenType.ENVIRONMENT_VARIABLE, CmdTextAttributesKey.environmentVariable)
		append(map, CmdTokenType.ENVIRONMENT_VARIABLE_DEFINITION, CmdTextAttributesKey.environmentVariableDefinition)
		append(map, CmdTokenType.LABEL, CmdTextAttributesKey.label)
		append(map, CmdTokenType.LABEL_REFERENCE, CmdTextAttributesKey.labelReference)
		append(map, CmdTokenType.LABEL_MARKER, CmdTextAttributesKey.expression)
		append(map, CmdTokenType.ECHO_OFF_MARKER, CmdTextAttributesKey.expression)
		append(map, CmdTokenType.EXPRESSION, CmdTextAttributesKey.expression)
		append(map, CmdTokenType.BAD_CHARACTER, CmdTextAttributesKey.badCharacter)
		append(map, CmdTokenType.COMMENT, CmdTextAttributesKey.comment)
		append(map, CmdTokenType.STRING_LITERAL, CmdTextAttributesKey.string)
		append(map, CmdTokenType.KEYWORDS, CmdTextAttributesKey.keyword)
		map
	}

	def getTokenHighlights(elementType: IElementType) = {
		log.info("elementType: " + elementType)

		if (map.contains(elementType))
			Array(map(elementType))
		else
			Array.empty[TextAttributesKey]
	}

	def getHighlightingLexer = lexer;


	private def append(map: Map[IElementType, TextAttributesKey], elementTypes: Array[IElementType], value: TextAttributesKey) {
		elementTypes.foreach(elementType => map += (elementType -> value))
	}

	private def append(map: Map[IElementType, TextAttributesKey], elementType: IElementType, value: TextAttributesKey) {
		map += (elementType -> value)
	}
}