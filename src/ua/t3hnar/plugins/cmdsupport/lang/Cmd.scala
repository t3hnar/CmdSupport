package ua.t3hnar.plugins.cmdsupport.lang

import com.intellij.openapi.util.SystemInfo

/**
 * @author Yaroslav Klymko aka t3hnar
 */

object Cmd {

	val name = "Cmd"
	val languageName = "Cmd"
	val languageDescription = "Command shell"
	val canRun = SystemInfo.isWindows
}
