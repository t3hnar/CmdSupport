package ua.t3hnar.plugins.cmdsupport.editor.highlighter

import com.intellij.openapi.options.colors.ColorSettingsPage
import ua.t3hnar.plugins.cmdsupport.lang.Cmd
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import ua.t3hnar.plugins.cmdsupport.file.CmdFileType
import ua.t3hnar.plugins.cmdsupport.util.CmdIcon

/**
 * @author Yaroslav Klymko aka t3hnar
 */

protected class CmdColorSettingsPage extends ColorSettingsPage {

	def getAdditionalHighlightingTagToDescriptorMap = null

	def getDemoText = "Demo text"

	def getHighlighter = SyntaxHighlighter.PROVIDER.create(CmdFileType, null, null)

	def getColorDescriptors = Array.empty

	def getAttributeDescriptors = Array.empty

	def getIcon = CmdIcon.FILE;

	def getDisplayName = Cmd.languageName
}