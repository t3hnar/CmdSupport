package ua.t3hnar.plugins.cmdsupport.actions

import ua.t3hnar.plugins.cmdsupport.lang.Cmd
import ua.t3hnar.plugins.cmdsupport.util.CmdIcon
import com.intellij.openapi.actionSystem.{CommonDataKeys, PlatformDataKeys, AnActionEvent, AnAction}
import com.intellij.openapi.vfs.VirtualFile
import java.io.File

/**
 * @author Yaroslav Klymko aka t3hnar
 */

class RunCmdShellAction extends AnAction("Run Cmd Shell", "Run Cmd Shell", CmdIcon.file) {

	override def update(e: AnActionEvent) = {
		e.getPresentation.setEnabled(Cmd.canRun)
	}

	def actionPerformed(e: AnActionEvent) = {
		val file: VirtualFile = CommonDataKeys.VIRTUAL_FILE.getData(e.getDataContext)

		val path = {
			if (file != null) {
				if (file.isDirectory) {
					file.getPath
				} else {
					file.getParent.getPath
				}
			} else {
				val project = PlatformDataKeys.PROJECT_CONTEXT.getData(e.getDataContext)
				project.getBaseDir.getPath
			}
		}

		Runtime.getRuntime.exec(Array("cmd", "/c", "start"), null, new File(path));
	}
}