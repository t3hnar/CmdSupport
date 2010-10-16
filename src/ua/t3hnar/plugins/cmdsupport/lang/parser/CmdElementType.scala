package ua.t3hnar.plugins.cmdsupport.lang.parser

import com.intellij.psi.tree.IElementType
import ua.t3hnar.plugins.cmdsupport.lang.CmdLanguage

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class CmdElementType(debugName: String) extends IElementType(debugName, CmdLanguage) {
	override def toString = "[" + getLanguage + "]" + super.toString
}