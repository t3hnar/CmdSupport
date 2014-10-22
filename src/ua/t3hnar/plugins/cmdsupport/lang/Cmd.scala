package ua.t3hnar.plugins.cmdsupport.lang

import com.intellij.openapi.util.SystemInfo


object Cmd {
  val Enabled: Boolean = SystemInfo.isWindows
  val Extensions = Set("cmd", "bat")
}
