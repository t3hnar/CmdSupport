package ua.t3hnar.plugins.cmdsupport.actions

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.actionSystem.{CommonDataKeys, AnActionEvent, AnAction}
import com.intellij.openapi.fileEditor.FileDocumentManager
import collection.mutable.ListBuffer
import ua.t3hnar.plugins.cmdsupport.lang.Cmd
import ua.t3hnar.plugins.cmdsupport.util.CmdIcon
import ua.t3hnar.plugins.cmdsupport.file.CmdFileType
import java.io.File



class RunCmdScriptAction extends AnAction("Run Cmd Script", "Run Cmd Script", CmdIcon.file) {

	private val log = Logger.getInstance(classOf[RunCmdScriptAction].getName)

	def actionPerformed(e: AnActionEvent) = {
		val files = getCompatibleFiles(e)
		log.debug("files: " + files)

		def saveAndRun(file: VirtualFile): Unit = {
			val documentManager = FileDocumentManager.getInstance()
			documentManager.saveDocument(documentManager.getDocument(file))
			val path = file.getPath
			log.info("path: " + path)
			Runtime.getRuntime.exec(Array("cmd", "/c", "start", path), null, new File(file.getParent.getPath))
		}

		files.foreach(file => saveAndRun(file))
	}

	override def update(e: AnActionEvent) = {
		val enabled = Cmd.canRun && getCompatibleFiles(e).nonEmpty
		e.getPresentation.setEnabled(enabled)
	}

	private def getCompatibleFiles(files: Array[VirtualFile]): List[VirtualFile] = {
		val compatibleFiles = new ListBuffer[VirtualFile]
    for (file <- files) {
			val extension: String = file.getExtension
			if (extension != null && CmdFileType.extensions.contains(extension.toLowerCase)) {
				compatibleFiles += file
			}
		}
		compatibleFiles.toList
	}

	private def getCompatibleFiles(e: AnActionEvent): List[VirtualFile] = {
		val files: Array[VirtualFile] = CommonDataKeys.VIRTUAL_FILE_ARRAY.getData(e.getDataContext)
		if (files == null || files.isEmpty) {
			List.empty[VirtualFile]
		}
		else {
			getCompatibleFiles(files)
		}
	}
}