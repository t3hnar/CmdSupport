package ua.t3hnar.plugins.cmdsupport.lang.parser

import com.intellij.psi.tree.IElementType
import com.intellij.lang.{PsiBuilder, PsiParser}
import com.intellij.openapi.diagnostic.Logger


class CmdParser extends PsiParser {

	val log = Logger.getInstance(classOf[PsiParser].getName)

	def parse(root: IElementType, builder: PsiBuilder) = {
		log.debug("root: " + root)
		null
	}
}