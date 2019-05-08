Const ForReading = 1
Const ForWriting = 2
strFile = Wscript.Arguments.Item(0)
Set objFSO = CreateObject("Scripting.FileSystemObject")
Set objFile = objFSO.OpenTextFile(StrFile, ForReading)
strText = objFile.ReadAll
objFile.Close
Set myRegExp = New RegExp
myRegExp.IgnoreCase = True
myRegExp.Global = True
myRegExp.Pattern = "<entry key = "& Chr(34) & "BrowserType"& Chr(34)&">.*</entry>"
strNewText = myRegExp.Replace(strText, "<entry key = "& Chr(34) & "BrowserType"& Chr(34)&">MOBIWEB</entry>")

Set objFile = objFSO.OpenTextFile(StrFile, ForWriting)
objFile.WriteLine strNewText
objFile.Close

WScript.Sleep(60000)