package ua.t3hnar.plugins.cmdsupport.actions

import com.intellij.openapi.actionSystem.{AnActionEvent, AnAction}
import ua.t3hnar.plugins.cmdsupport.lang.Cmd
import ua.t3hnar.plugins.cmdsupport.util.CmdIcon

/**
 * @author Yaroslav Klymko aka t3hnar
 */

class RunCmdShellAction extends AnAction("Run Cmd Shell", "Run Cmd Shell", CmdIcon.file) {

	override def update(e: AnActionEvent) = {
		e.getPresentation.setEnabled(Cmd.canRun)
	}

	def actionPerformed(e: AnActionEvent) = {
		Runtime.getRuntime.exec("cmd /c start")
	}
}