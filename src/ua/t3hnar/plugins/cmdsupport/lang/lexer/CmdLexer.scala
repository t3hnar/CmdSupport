package ua.t3hnar.plugins.cmdsupport.lang.lexer

import java.io.Reader
import com.intellij.lexer.FlexAdapter



class CmdLexer extends FlexAdapter(new _CmdLexer(null.asInstanceOf[Reader]))