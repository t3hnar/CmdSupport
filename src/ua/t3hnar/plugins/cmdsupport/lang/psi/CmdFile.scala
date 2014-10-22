package ua.t3hnar.plugins.cmdsupport.lang.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import ua.t3hnar.plugins.cmdsupport.CmdFileType
import ua.t3hnar.plugins.cmdsupport.lang.CmdLanguage


class CmdFile(viewProvider: FileViewProvider) extends PsiFileBase(viewProvider, CmdLanguage) {
	def getFileType = CmdFileType
}