package ua.t3hnar.plugins.cmdsupport.file

import com.intellij.openapi.fileTypes.LanguageFileType
import ua.t3hnar.plugins.cmdsupport.lang.{Cmd, CmdLanguage}
import ua.t3hnar.plugins.cmdsupport.util.CmdIcon

/**
 * @author Yaroslav Klymko aka t3hnar
 */
object CmdFileType extends LanguageFileType(CmdLanguage) {
	val CMD_EXTENSION = "cmd"
	val BAT_EXTENSION = "bat"

	def getIcon = CmdIcon.FILE

	def getDefaultExtension = CMD_EXTENSION

	def getDescription = Cmd.languageDescription

	def getName = Cmd.languageName
}