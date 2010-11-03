package ua.t3hnar.plugins.cmdsupport.editor.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.{HighlighterColors, SyntaxHighlighterColors}
import ua.t3hnar.plugins.cmdsupport.lang.Cmd
import java.awt.{Font, Color}
import java.lang.String
import com.intellij.openapi.editor.markup.{EffectType, TextAttributes}

/**
 * @author Yaroslav Klymko aka t3hnar
 */

package object CmdTextAttributesKey {

	val comment = createAttributesKey("COMMENT", SyntaxHighlighterColors.JAVA_BLOCK_COMMENT.getDefaultAttributes)
	val string = createAttributesKey("STRING", SyntaxHighlighterColors.STRING.getDefaultAttributes)
	val variable = createAttributesKey("VARIABLE", createAttributes(new Color(0, 0, 0xff), null, null, null, Font.BOLD | Font.ITALIC))
	val environmentVariable = createAttributesKey("ENVIRONMENT_VARIABLE", createAttributes(new Color(0x66, 0xe, 0x7a), null, null, null, Font.BOLD | Font.ITALIC))
	val environmentVariableDefinition = createAttributesKey("ENVIRONMENT_VARIABLE_DEFINITION", new TextAttributes(new Color(0x66, 0xe, 0x7a), null, null, null, Font.BOLD))
	val label = createAttributesKey("LABEL", createAttributes(new Color(0x80, 0x80, 0), null, null, null, Font.BOLD))
	val labelReference = createAttributesKey("LABEL_REFERENCE", createAttributes(new Color(0x80, 0x80, 0), null, null, null, Font.BOLD | Font.ITALIC))
	val expression = createAttributesKey("EXPRESSION", createAttributes(new Color(0, 0, 0x80), null, null, null, 0))
	val number = createAttributesKey("NUMBER", SyntaxHighlighterColors.NUMBER.getDefaultAttributes)
	val operationSign = createAttributesKey("OPERATION_SIGN", SyntaxHighlighterColors.OPERATION_SIGN.getDefaultAttributes)
	val braces = createAttributesKey("BRACES", SyntaxHighlighterColors.BRACES.getDefaultAttributes)
	val brackets = createAttributesKey("BRACES", SyntaxHighlighterColors.BRACKETS.getDefaultAttributes)
	val parenths = createAttributesKey("PARENTHS", SyntaxHighlighterColors.PARENTHS.getDefaultAttributes)
	val keyword = createAttributesKey("KEYWORD", SyntaxHighlighterColors.KEYWORD.getDefaultAttributes)
	val badCharacter = HighlighterColors.BAD_CHARACTER

	private def createAttributesKey(name: String, defaultAttributes: TextAttributes): TextAttributesKey = {
		val externalName = Cmd.name + '.' + name
		TextAttributesKey.createTextAttributesKey(externalName, defaultAttributes)
	}

	private def createAttributes(foregroundColor: Color, backgroundColor: Color, effectColor: Color, effectType: EffectType, fontType: Int): TextAttributes = {
		new TextAttributes(foregroundColor, backgroundColor, effectColor, effectType, fontType)
	}
}