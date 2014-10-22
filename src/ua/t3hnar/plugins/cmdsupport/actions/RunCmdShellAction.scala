package ua.t3hnar.plugins.cmdsupport.actions

import ua.t3hnar.plugins.cmdsupport.CmdFileType
import ua.t3hnar.plugins.cmdsupport.lang.Cmd
import com.intellij.openapi.actionSystem.{CommonDataKeys, PlatformDataKeys, AnActionEvent, AnAction}
import com.intellij.openapi.vfs.VirtualFile
import java.io.File


class RunCmdShellAction extends AnAction("Run cmd shell", "Run cmd shell", CmdFileType.getIcon) {

  override def update(e: AnActionEvent) = {
    e.getPresentation.setVisible(Cmd.Enabled)
  }

  def actionPerformed(e: AnActionEvent) = {
    val file = CommonDataKeys.VIRTUAL_FILE.getData(e.getDataContext)
    val path =
      if (file == null) PlatformDataKeys.PROJECT_CONTEXT.getData(e.getDataContext).getBaseDir.getPath
      else if (file.isDirectory) file.getPath
      else file.getParent.getPath
    Runtime.getRuntime.exec(Array("cmd", "/c", "start"), null, new File(path))
  }
}