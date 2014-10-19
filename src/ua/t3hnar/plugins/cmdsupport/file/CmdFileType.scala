package ua.t3hnar.plugins.cmdsupport.file

import com.intellij.openapi.fileTypes.LanguageFileType
import ua.t3hnar.plugins.cmdsupport.lang.{Cmd, CmdLanguage}
import ua.t3hnar.plugins.cmdsupport.util.CmdIcon



object CmdFileType extends LanguageFileType(CmdLanguage) {

	val cmdExtension = "cmd"
	val batExtension = "bat"
	val extensions = Array(cmdExtension, batExtension)

	def getIcon = CmdIcon.file

	def getDefaultExtension = cmdExtension

	def getDescription = Cmd.languageDescription

	def getName = Cmd.languageName
}