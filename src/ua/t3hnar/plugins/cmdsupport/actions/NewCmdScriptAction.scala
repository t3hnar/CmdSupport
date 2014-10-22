package ua.t3hnar.plugins.cmdsupport.actions

import com.intellij.ide.actions.CreateElementActionBase
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.io.FileUtilRt
import com.intellij.openapi.ui.Messages
import com.intellij.CommonBundle
import com.intellij.psi.{PsiFileFactory, PsiDirectory}
import ua.t3hnar.plugins.cmdsupport.CmdFileType


class NewCmdScriptAction extends CreateElementActionBase("Cmd script", "Creates a new cmd script", CmdFileType.getIcon) {
  def getActionName(directory: PsiDirectory, newName: String) = "Create cmd script"

  def getCommandName = "New cmd script"

  def getErrorTitle = CommonBundle.getErrorTitle

  def create(newName: String, directory: PsiDirectory) = {
    def fixExtension: String = FileUtilRt.getExtension(newName).toLowerCase match {
      case "cmd" | "bat" => newName
      case _ => s"$newName.cmd"
    }

    def create(newName: String) = {
      val project = directory.getProject
      val factory = PsiFileFactory.getInstance(project)
      val file = factory.createFileFromText(newName, CmdFileType, "")
      Array(directory.add(file))
    }

    create(fixExtension)
  }

  def invokeDialog(project: Project, directory: PsiDirectory) = {
    val validator = new MyInputValidator(project, directory)
    Messages.showInputDialog(
      project,
      "Enter a new cmd script name",
      "New cmd script",
      Messages.getQuestionIcon,
      "",
      validator)
    validator.getCreatedElements
  }
}