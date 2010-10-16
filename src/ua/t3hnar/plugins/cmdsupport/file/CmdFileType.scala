package ua.t3hnar.plugins.cmdsupport.file

import com.intellij.openapi.fileTypes.LanguageFileType
import ua.t3hnar.plugins.cmdsupport.lang.{Cmd, CmdLanguage}
import ua.t3hnar.plugins.cmdsupport.util.Icon

/**
 * @author Yaroslav Klymko aka t3hnar
 */
object CmdFileType extends LanguageFileType(CmdLanguage) {
	val CMD_EXTENSION = "cmd"
	val BAT_EXTENSION = "bat"

	def getIcon = Icon.FILE

	def getDefaultExtension = CMD_EXTENSION

	def getDescription = Cmd.LANGUAGE_DESCRIPTION

	def getName = Cmd.LANGUAGE_NAME
}