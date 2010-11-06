package ua.t3hnar.plugins.cmdsupport.editor.highlighter

import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.tree.IElementType
import scala.collection.mutable.Map
import ua.t3hnar.plugins.cmdsupport.editor.highlighter.CmdTextAttributesKey._
import com.intellij.openapi.editor.colors.TextAttributesKey
import ua.t3hnar.plugins.cmdsupport.lang.lexer.CmdLexer
import ua.t3hnar.plugins.cmdsupport.lang.lexer.CmdTokenType._

/**
 * @author Yaroslav Klymko aka t3hnar
 */

class CmdSyntaxHighlighter extends SyntaxHighlighterBase {

	private val log = Logger.getInstance(classOf[CmdSyntaxHighlighter].getName)
	private val lexer = new CmdLexer
	private val map: Map[IElementType, TextAttributesKey] = {
		val map = Map[IElementType, TextAttributesKey]()
		append(map, COMMENT, comment)
		append(map, BRACES, braces)
		append(map, BRACKETS, brackets)
		append(map, PARENTHESES, parenths)
		append(map, OPERATORS, operationSign)
		append(map, DIGIT, number)
		append(map, VARIABLE, variable)
		append(map, ENVIRONMENT_VARIABLE, environmentVariable)
		append(map, ENVIRONMENT_VARIABLE_DEFINITION, environmentVariableDefinition)
		append(map, LABEL, label)
		append(map, LABEL_REFERENCE, labelReference)
		append(map, LABEL_MARKER, expression)
		append(map, ECHO_OFF_MARKER, expression)
		append(map, EXPRESSION, expression)
		append(map, BAD_CHARACTER, badCharacter)
		append(map, COMMENT, comment)
		append(map, STRING_LITERAL, string)
		append(map, KEYWORDS, keyword)
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