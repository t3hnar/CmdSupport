package ua.t3hnar.plugins.cmdsupport.file

import com.intellij.openapi.fileTypes.{FileTypeConsumer, FileTypeFactory}


/**
 * @author Yaroslav Klymko aka t3hnar
 */
class CmdFileTypeFactory extends FileTypeFactory {
	def createFileTypes(consumer: FileTypeConsumer) = {
		consumer.consume(CmdFileType, CmdFileType.CMD_EXTENSION)
		consumer.consume(CmdFileType, CmdFileType.BAT_EXTENSION)
	}
}
