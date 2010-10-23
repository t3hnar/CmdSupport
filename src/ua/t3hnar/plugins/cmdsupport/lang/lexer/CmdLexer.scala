package ua.t3hnar.plugins.cmdsupport.lang.lexer

import com.intellij.lexer.LexerBase
import com.intellij.openapi.diagnostic.Logger
import java.lang.StringBuilder

/**
 * @author Yaroslav Klymko aka t3hnar
 */

class CmdLexer extends LexerBase {
  private val LOG = Logger.getInstance("#CmdLexer")
  private var buffer: CharSequence = new StringBuilder(0);
  private var bufferEnd = 0;
  private var bufferStart = 0;
  private var state = 0;
  private var tokenStart = 0;
  private var tokenEnd = 0;


  def getBufferEnd = {
    this.bufferEnd
  }

  def getBufferSequence = {
    this.buffer;
  }

  def advance = {
    if (tokenStart == bufferEnd) {
      tokenStart = -1;
    } else {
      tokenStart += 1;
    }
  }

  def getTokenEnd = {
    this.tokenStart;
  }

  def getTokenStart = {
    this.tokenStart;
  }

  def getTokenType = {
    if (tokenStart >= 0) {
      CmdTokenType.CALL
    }
    null
  }

  def getState = {
    this.state;
  }


  def start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) = {
    this.buffer = buffer;
    this.bufferStart = startOffset;
    this.bufferEnd = endOffset;
    this.state = initialState;
    this.tokenStart = startOffset;
  }
}