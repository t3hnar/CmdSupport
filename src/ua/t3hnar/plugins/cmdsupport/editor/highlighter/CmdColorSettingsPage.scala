package ua.t3hnar.plugins.cmdsupport.editor.highlighter

import ua.t3hnar.plugins.cmdsupport.lang.Cmd
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import ua.t3hnar.plugins.cmdsupport.file.CmdFileType
import ua.t3hnar.plugins.cmdsupport.util.CmdIcon
import com.intellij.openapi.options.colors.{ColorSettingsPage, AttributesDescriptor}

/**
 * @author Yaroslav Klymko aka t3hnar
 */

protected class CmdColorSettingsPage extends ColorSettingsPage {

	def getAdditionalHighlightingTagToDescriptorMap = null

	def getDemoText = "@echo on\n" +
					"if not exist %JAVA_HOME% goto sethome\n" +
					"\n" +
					":sethome\n" +
					"    rem setting java home\n" +
					"    set JAVA_HOME=\"java home\"\n" +
					"    echo JAVA_HOME = %JAVA_HOME%"

	def getHighlighter = SyntaxHighlighter.PROVIDER.create(CmdFileType, null, null)

	def getColorDescriptors = Array.empty

	def getAttributeDescriptors = CmdColorSettingsPage.attributeDescriptors;

	def getIcon = CmdIcon.file;

	def getDisplayName = Cmd.languageName
}


protected object CmdColorSettingsPage {

	private def attributeDescriptors = Array(
		new AttributesDescriptor("Brackets", CmdTextAttributesKey.comment),
		new AttributesDescriptor("Braces", CmdTextAttributesKey.braces),
		new AttributesDescriptor("Parenthesis", CmdTextAttributesKey.parenths),
		new AttributesDescriptor("Comment", CmdTextAttributesKey.comment),
		new AttributesDescriptor("Operator", CmdTextAttributesKey.operationSign),
		new AttributesDescriptor("Keyword", CmdTextAttributesKey.keyword),
		new AttributesDescriptor("String", CmdTextAttributesKey.string),
		new AttributesDescriptor("Number", CmdTextAttributesKey.number),
		new AttributesDescriptor("Label", CmdTextAttributesKey.label),
		new AttributesDescriptor("Label Reference", CmdTextAttributesKey.labelReference),
		new AttributesDescriptor("Environment Variable", CmdTextAttributesKey.environmentVariable),
		new AttributesDescriptor("Environment Definition", CmdTextAttributesKey.environmentVariableDefinition),
		new AttributesDescriptor("Variable", CmdTextAttributesKey.variable),
		new AttributesDescriptor("Expression", CmdTextAttributesKey.expression))
}




