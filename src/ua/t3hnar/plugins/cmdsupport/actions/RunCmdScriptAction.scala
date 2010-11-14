package ua.t3hnar.plugins.cmdsupport.actions

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.vfs.VirtualFile
import collection.mutable.ListBuffer
import ua.t3hnar.plugins.cmdsupport.file.CmdFileType
import com.intellij.openapi.actionSystem.{PlatformDataKeys, AnActionEvent, AnAction}
import com.intellij.openapi.fileEditor.FileDocumentManager
import ua.t3hnar.plugins.cmdsupport.lang.Cmd
import ua.t3hnar.plugins.cmdsupport.util.CmdIcon
import java.lang.String

/**
 * @author Yaroslav Klymko aka t3hnar
 */

class RunCmdScriptAction extends AnAction("Run Cmd Script", "Run Cmd Script", CmdIcon.file) {

	private val log = Logger.getInstance(classOf[RunCmdScriptAction].getName)

	def actionPerformed(e: AnActionEvent) = {
		val files = getCompatibleFiles(e)
		log.debug("files: " + files)

		def saveAndRun(file: VirtualFile): Unit = {
			val documentManager = FileDocumentManager.getInstance()
			documentManager.saveDocument(documentManager.getDocument(file))
			Runtime.getRuntime.exec("cmd /c start " + file.getPath)
		}

		files.foreach(file => saveAndRun(file))
	}

	override def update(e: AnActionEvent) = {
		val enabled = Cmd.canRun && !getCompatibleFiles(e).isEmpty
		e.getPresentation.setEnabled(enabled)
	}

	private def getCompatibleFiles(files: Array[VirtualFile]): List[VirtualFile] = {
		val compatibleFiles = new ListBuffer[VirtualFile];
		for (file <- files) {
			val extension: String = file.getExtension
			if (extension != null && CmdFileType.extensions.contains(extension.toLowerCase)) {
				compatibleFiles += file
			}
		}
		compatibleFiles.toList
	}

	private def getCompatibleFiles(e: AnActionEvent): List[VirtualFile] = {
		val files: Array[VirtualFile] = PlatformDataKeys.VIRTUAL_FILE_ARRAY.getData(e.getDataContext)
		if (files.isEmpty) {
			List.empty[VirtualFile]
		}
		else {
			getCompatibleFiles(files)
		}
	}
}