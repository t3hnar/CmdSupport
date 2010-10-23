package ua.t3hnar.plugins.cmdsupport.editor.highlighting

import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.project.Project

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class CmdSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
  def getSyntaxHighlighter(project: Project, virtualFile: VirtualFile) = {
    new CmdSyntaxHighlighter
  }
}