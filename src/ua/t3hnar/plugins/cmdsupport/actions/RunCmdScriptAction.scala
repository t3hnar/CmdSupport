package ua.t3hnar.plugins.cmdsupport.actions

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.actionSystem.{CommonDataKeys, AnActionEvent, AnAction}
import com.intellij.openapi.fileEditor.FileDocumentManager
import ua.t3hnar.plugins.cmdsupport.lang.Cmd
import ua.t3hnar.plugins.cmdsupport.CmdFileType
import java.io.File


class RunCmdScriptAction extends AnAction("Run cmd script", "Run cmd script", CmdFileType.getIcon) {
  def actionPerformed(e: AnActionEvent) = {
    val files = compatibleFiles(e)

    def saveAndRun(file: VirtualFile): Unit = {
      val documentManager = FileDocumentManager.getInstance()
      documentManager.saveDocument(documentManager.getDocument(file))
      val path = file.getPath
      Runtime.getRuntime.exec(Array("cmd", "/c", "start", "Run cmd script", path), null, new File(file.getParent.getPath))
    }

    files.foreach(file => saveAndRun(file))
  }

  override def update(e: AnActionEvent) = {
    for {project <- Option(e.getData(CommonDataKeys.PROJECT)) if !project.isDefault} {
      e.getPresentation.setVisible(Cmd.Enabled)
      e.getPresentation.setEnabled(compatibleFiles(e).nonEmpty)
    }
  }

  private def compatibleFiles(e: AnActionEvent): Array[VirtualFile] = {
    val files = CommonDataKeys.VIRTUAL_FILE_ARRAY.getData(e.getDataContext)
    (Option(files.asInstanceOf[Array[Any]]) getOrElse Array.empty)
      .collect { case file: VirtualFile => file}
      .filter { file =>
      file.getExtension match {
        case null => false
        case ext => Cmd.Extensions contains ext.toLowerCase
      }
    }
  }
}