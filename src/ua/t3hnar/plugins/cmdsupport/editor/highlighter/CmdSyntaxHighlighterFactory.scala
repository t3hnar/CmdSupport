package ua.t3hnar.plugins.cmdsupport.editor.highlighter

import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.project.Project



class CmdSyntaxHighlighterFactory extends SyntaxHighlighterFactory {

	def getSyntaxHighlighter(project: Project, virtualFile: VirtualFile) = {
		new CmdSyntaxHighlighter
	}
}