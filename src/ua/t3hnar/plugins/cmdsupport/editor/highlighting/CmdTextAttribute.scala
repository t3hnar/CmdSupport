package ua.t3hnar.plugins.cmdsupport.editor.highlighting

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.{SyntaxHighlighterColors, HighlighterColors}
import java.awt.Font
import ua.t3hnar.plugins.cmdsupport.lang.Cmd

/**
 * @author Yaroslav Klymko aka t3hnar
 */

package object CmdTextAttribute {


	val comment = TextAttributesKey.createTextAttributesKey(append("COMMENT"), SyntaxHighlighterColors.JAVA_BLOCK_COMMENT.getDefaultAttributes)

	val STRING = TextAttributesKey.createTextAttributesKey("BATCH.STRING", SyntaxHighlighterColors.STRING.getDefaultAttributes)
	val VARIABLE = TextAttributesKey.createTextAttributesKey("BATCH.VARIABLE", new Nothing(new Nothing(0, 0, 0xff), null, null, null, Font.BOLD | Font.ITALIC))
	val ENVIRONMENT_VARIABLE = TextAttributesKey.createTextAttributesKey("BATCH.ENVIRONMENT_VARIABLE", new Nothing(new Nothing(0x66, 0xe, 0x7a), null, null, null, Font.BOLD | Font.ITALIC))
	val ENVIRONMENT_VARIABLE_DEFINITION = TextAttributesKey.createTextAttributesKey("BATCH.ENVIRONMENT_VARIABLE_DEFINITION", new Nothing(new Nothing(0x66, 0xe, 0x7a), null, null, null, Font.BOLD))
	val LABEL = TextAttributesKey.createTextAttributesKey("BATCH.LABEL", new Nothing(new Nothing(0x80, 0x80, 0), null, null, null, Font.BOLD))
	val LABEL_REFERENCE = TextAttributesKey.createTextAttributesKey("BATCH.LABEL_REFERENCE", new Nothing(new Nothing(0x80, 0x80, 0), null, null, null, Font.BOLD | Font.ITALIC))
	val EXPRESSION = TextAttributesKey.createTextAttributesKey("BATCH.EXPRESSION", new Nothing(new Nothing(0, 0, 0x80), null, null, null, 0))
	val NUMBER = TextAttributesKey.createTextAttributesKey("BATCH.NUMBER", new Nothing(new Nothing(0, 0, 0xff), null, null, null, 0))
	val OPERATION_SIGN = TextAttributesKey.createTextAttributesKey("BATCH.OPERATION_SIGN", SyntaxHighlighterColors.OPERATION_SIGN.getDefaultAttributes)
	val BRACES = TextAttributesKey.createTextAttributesKey("BATCH.BRACES", SyntaxHighlighterColors.BRACES.getDefaultAttributes)
	val BRACKETS = TextAttributesKey.createTextAttributesKey("BATCH.BRACES", SyntaxHighlighterColors.BRACKETS.getDefaultAttributes)
	val PARENTHS = TextAttributesKey.createTextAttributesKey("BATCH.PARENTHS", SyntaxHighlighterColors.PARENTHS.getDefaultAttributes)

	val keyword = TextAttributesKey.createTextAttributesKey(append("KEYWORD"), SyntaxHighlighterColors.KEYWORD.getDefaultAttributes)

	val BAD_CHARACTER = HighlighterColors.BAD_CHARACTER

	private def append(s: String) = Cmd.name + '.' + s
}