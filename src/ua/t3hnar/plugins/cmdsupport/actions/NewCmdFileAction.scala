package ua.t3hnar.plugins.cmdsupport.actions

import com.intellij.ide.actions.CreateElementActionBase
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.ui.Messages
import com.intellij.CommonBundle
import com.intellij.psi.{PsiFile, PsiFileFactory, PsiDirectory}
import ua.t3hnar.plugins.cmdsupport.util.CmdIcon
import ua.t3hnar.plugins.cmdsupport.file.CmdFileType


class NewCmdFileAction extends CreateElementActionBase("Create Cmd file", "Creates a new Cmd file", CmdIcon.file) {

	private val log = Logger.getInstance(classOf[NewCmdFileAction].getName)

	def getActionName(directory: PsiDirectory, newName: String) = "Create Cmd file"

	def getCommandName = "Cmd file"

	def getErrorTitle = CommonBundle.getErrorTitle()

  def getFinalName(newName: String) = {
		val extension: String = FileUtil.getExtension(newName)
		log.debug("extension: " + extension)

		val contains = CmdFileType.extensions.contains(extension.toLowerCase)
		log.debug("contains: " + contains)

		if (contains)
			newName
		else
			newName + '.' + CmdFileType.getDefaultExtension
	}

	def create(newName: String, directory: PsiDirectory) = {
		log.debug("newName: " + newName)

		val finalName = getFinalName(newName)
		log.debug("finalName: " + finalName)

		val project = directory.getProject
		log.debug("project: " + project)

		val factory = PsiFileFactory.getInstance(project)

		val file = factory.createFileFromText(finalName, CmdFileType, "")
		Array(directory.add(file).asInstanceOf[PsiFile])
	}

	def checkBeforeCreate(newName: String, directory: PsiDirectory) = {
		val finalName = getFinalName(newName)
		log.debug("finalName: " + finalName)
		directory.checkCreateFile(finalName)
	}

	def invokeDialog(project: Project, directory: PsiDirectory) = {
		val validator = new MyInputValidator(project, directory)
		Messages.showInputDialog(project, "Enter a new Cmd file name", "New Cmd File", Messages.getQuestionIcon, "", validator)
		val elements = validator.getCreatedElements
		log.debug("elements: " + elements)
		elements
	}
}