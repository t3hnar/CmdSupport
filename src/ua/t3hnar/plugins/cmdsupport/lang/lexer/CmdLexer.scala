package ua.t3hnar.plugins.cmdsupport.lang.lexer

import java.io.Reader
import com.intellij.lexer.FlexAdapter

/**
 * @author Yaroslav Klymko aka t3hnar
 */

class CmdLexer extends FlexAdapter(new _CmdLexer(null.asInstanceOf[Reader])) {
}