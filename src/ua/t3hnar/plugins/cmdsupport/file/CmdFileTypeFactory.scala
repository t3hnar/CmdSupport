package ua.t3hnar.plugins.cmdsupport.file

import com.intellij.openapi.fileTypes.{FileTypeConsumer, FileTypeFactory}



class CmdFileTypeFactory extends FileTypeFactory {
	def createFileTypes(consumer: FileTypeConsumer) = {
		consumer.consume(CmdFileType, CmdFileType.cmdExtension)
		consumer.consume(CmdFileType, CmdFileType.batExtension)
	}
}
