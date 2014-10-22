package ua.t3hnar.plugins.cmdsupport

import com.intellij.openapi.fileTypes.{FileTypeConsumer, FileTypeFactory, LanguageFileType}
import com.intellij.openapi.util.IconLoader
import ua.t3hnar.plugins.cmdsupport.lang.CmdLanguage


object CmdFileType extends LanguageFileType(CmdLanguage) {
  lazy val getIcon = IconLoader.findIcon("/icons/cmd.png")

  def getDefaultExtension = "cmd"
  def getDescription = "Cmd scripts"
  def getName = "Cmd"
}

object BatFileType extends LanguageFileType(CmdLanguage) {
  lazy val getIcon = IconLoader.findIcon("/icons/bat.png")

  def getDefaultExtension = "bat"
  def getDescription = "Batch scripts"
  def getName = "Bat"
}

class CmdFileTypeFactory extends FileTypeFactory {
  def createFileTypes(consumer: FileTypeConsumer) = {
    consumer.consume(BatFileType, "bat")
    consumer.consume(CmdFileType, "cmd")
  }
}