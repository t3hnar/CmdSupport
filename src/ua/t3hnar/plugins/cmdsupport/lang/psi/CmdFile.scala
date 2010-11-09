package ua.t3hnar.plugins.cmdsupport.lang.psi

import com.intellij.extapi.psi.PsiFileBase
import ua.t3hnar.plugins.cmdsupport.file.CmdFileType
import com.intellij.psi.FileViewProvider
import ua.t3hnar.plugins.cmdsupport.lang.CmdLanguage

/**
 * @author Yaroslav Klymko aka t3hnar
 */

class CmdFile(viewProvider: FileViewProvider) extends PsiFileBase(viewProvider, CmdLanguage) {

	def getFileType = CmdFileType
}