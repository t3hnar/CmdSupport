package ua.t3hnar.plugins.cmdsupport.editor.highlighter

import com.intellij.openapi.options.colors.{ColorSettingsPage, AttributesDescriptor}
import ua.t3hnar.plugins.cmdsupport.CmdFileType


class CmdColorSettingsPage extends ColorSettingsPage {

	def getAdditionalHighlightingTagToDescriptorMap = null

	def getDemoText = """
    |@echo off
    |call :power 2 4
    |echo %result%
    |rem Prints 16, determined as 2 * 2 * 2 * 2
    |goto :eof
    |
    |rem __Function power______________________
    |rem Arguments: %1 and %2
    |:power
    |setlocal
    |set counter=%2
    |set interim_product=%1
    |:power_loop
    |if %counter% gtr 1 (
    |  set /A interim_product = %interim_product% * %1
    |  set /A counter = %counter% - 1
    |  goto :power_loop
    |)
    |endlocal & set result=%interim_product%
    |goto :eof
  """.stripMargin

  def getHighlighter = new CmdSyntaxHighlighter

	def getColorDescriptors = Array.empty

  def getIcon = CmdFileType.getIcon

  def getDisplayName = "Cmd"

  def getAttributeDescriptors = Array(
    new AttributesDescriptor("Brackets", CmdTextAttributes.Comment),
    new AttributesDescriptor("Braces", CmdTextAttributes.Braces),
    new AttributesDescriptor("Parenthesis", CmdTextAttributes.Parenths),
    new AttributesDescriptor("Comment", CmdTextAttributes.Comment),
    new AttributesDescriptor("Operator", CmdTextAttributes.OperationSign),
    new AttributesDescriptor("Keyword", CmdTextAttributes.Keyword),
    new AttributesDescriptor("String", CmdTextAttributes.String),
    new AttributesDescriptor("Number", CmdTextAttributes.Number),
    new AttributesDescriptor("Label", CmdTextAttributes.Label),
    new AttributesDescriptor("Label Reference", CmdTextAttributes.LabelReference),
    new AttributesDescriptor("Environment Variable", CmdTextAttributes.EnvVariable),
    new AttributesDescriptor("Environment Definition", CmdTextAttributes.EnvVariableDefinition),
    new AttributesDescriptor("Variable", CmdTextAttributes.Variable),
    new AttributesDescriptor("Expression", CmdTextAttributes.Expression))
}