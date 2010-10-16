package ua.t3hnar.plugins.cmdsupport.lang.lexer

import com.intellij.lexer.LexerBase
import com.intellij.openapi.diagnostic.Logger

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class CmdLexer extends LexerBase {
	val LOG = Logger.getInstance("#CmdLexer")

	def getBufferEnd = {
		LOG.debug("getBufferEnd")
		0
	}

	def getBufferSequence = {
		LOG.debug("getBufferSequence")
		""
	}

	def advance = {
		LOG.debug("advance")
	}

	def getTokenEnd = {
		LOG.warn("getTokenEnd")
		0
	}

	def getTokenStart = {
		LOG.warn("getTokenStart")
		0
	}

	def getTokenType = {
		LOG.warn("getTokenType")
		null
	}

	def getState = {
		LOG.warn("getState")
		0
	}

	def start(p1: CharSequence, p2: Int, p3: Int, p4: Int) = {
		LOG.warn("start")
	}
}