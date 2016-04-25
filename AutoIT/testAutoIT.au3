#include <Excel.au3>
#include <array.au3>    


Global $Paused  
HotKeySet("{PAUSE}", "TogglePause")  
HotKeySet("{ESC}", "Terminate") 
 $scriptName = StringLeft(@ScriptName, StringLen(@ScriptName) - 4)  
 $iniLocation = @ScriptDir & '\' & $scriptName & '.ini'  
  If not(FileExists($iniLocation)) Then  
MsgBox(0, "Exception", "The configuration file could not be found: " & $iniLocation)  
exit  
EndIf

$puttyLocation = IniRead($iniLocation, "common", "puttyLocation", "NotFound")  
$puttyUsername = IniRead($iniLocation, "common", "puttyUsername", "NotFound")  
$puttyPassword = IniRead($iniLocation, "common", "puttyPassword", "NotFound")  
$defaultCommands = IniRead($iniLocation, "common", "defaultCommands", "NotFound")  
$commandEnter = IniRead($iniLocation, "common", "commandEnter", "NotFound")  
$inputInterval = IniRead($iniLocation, "common", "inputInterval", "NotFound")  
$sendKeyDelay = IniRead($iniLocation, "common", "sendKeyDelay", "NotFound")  
$commanddelimiter = IniRead($iniLocation, "common", "commanddelimiter", "NotFound")  
$puttyWindowTitle = IniRead($iniLocation, "common", "puttyWindowTitle", "NotFound")  
$puttyWindowCheckTimeout = IniRead($iniLocation, "common", "puttyWindowCheckTimeout", "NotFound")  
  
$selectedSessions = _arraycreate("","","","","","","","","","","")  
$selectedSessionCommands = _arraycreate("","","","","","","","","","","")  
$commands = _arraycreate("","","","","","","","","","","")  
$selectedEnvironments = IniRead($iniLocation, "launch", "selectedEnvironments", "NotFound")  
$selectedSessions = _getsessions($selectedEnvironments)  
$selectedSessionCommands = _getSelectedSessionCommands($selectedSessions)  
$commands = _getCommands($selectedSessions)    
Opt("SendKeyDelay", $sendKeyDelay)  



; ------------------------------------------------------------------------------ 
; MAIN 
; ------------------------------------------------------------------------------  

$sFilePath1 = "C:\WMS\Homer_Release3.2\Homer\AutoIT\AutoIT.xls"
$oExcel = _ExcelBookOpen($sFilePath1)
;Local $sCellValue="TC_01"
Local $sCellValue=$CmdLine[1]
;MsgBox(0, "", "The Java: " & @CRLF & $CmdLine[1]) 
Sleep(2000)
 _ExcelSheetActivate($oExcel, "TestSheet")
   $nb_columns = $oExcel.ActiveSheet.UsedRange.Columns.Count   
   $nb_rows = $oExcel.ActiveSheet.UsedRange.Rows.Count
   Local $array_data_excel[$nb_rows][2]
   Local $idxcl
   Local $idx
   Local $EndTest
   For $idxcl=1 to $nb_columns
	   
	if $sCellValue = $oExcel.Activesheet.Cells(1,$idxcl).Value Then
		
		For $idxrw = 2 To $nb_rows		
			$FuncCellValue = $oExcel.Activesheet.Cells($idxrw,$idxcl).Value	
			$DataCellValue = $oExcel.Activesheet.Cells($idxrw,$idxcl+1).Value	
			 Select
			 Case $FuncCellValue ="puttySessionLogin"				 
					puttySessionLogin()			
									
			 Case $FuncCellValue ="waitLoadPuttyScreen"
					waitLoadPuttyScreen($DataCellValue)
					
			 Case $FuncCellValue ="waitLoadwithScreenText"
					waitLoadwithScreenText($DataCellValue)	
								
			 Case $FuncCellValue ="SendkeyPuttyScreen"
					SendkeyPuttyScreen($DataCellValue)
					
			 Case $FuncCellValue ="SendenterPutty"
					SendenterPutty()
					
			 Case $FuncCellValue ="ClipGetPuttyScreen"					
					ClipGetPuttyScreen()
			 Case $FuncCellValue ="Terminate"					
					Terminate()
					
			 Case $FuncCellValue ="SendkeyJavaArgument"		
				     $InputParam=$CmdLine[$DataCellValue] 					 
					 SendkeyJavaArgument($InputParam)			 
					
			 Case $FuncCellValue ="ENDTEST"
					;MsgBox(0, "", "The Java: " & @CRLF & $FuncCellValue) 
					_ExcelBookClose($oExcel, 0)
					$EndTest=1					
					ExitLoop
			 Case Else 					
			EndSelect								
		Next
	EndIf
	if $EndTest=1 Then
		ExitLoop
	EndIf
 Next







 


; ------------------------------------------------------------------------------ 
; FUNCTIONS 
; ------------------------------------------------------------------------------  
Func puttySessionLogin() 	   
for $i = 1 to UBound($selectedSessionCommands) - 1  
Run($puttyLocation, "", @SW_MAXIMIZE)  
if not (FileExists($puttyLocation)) Then  
msgbox(0,"","The putty exe could not be found at location " & $puttyLocation)  
Exit  
EndIf  
  
if WinWaitActive($puttyWindowTitle, "", $puttyWindowCheckTimeout) then  
sleep(1000)  
send ($defaultCommands)  
Send ($selectedSessionCommands[$i])  
send($commandEnter)  
  
sleep($inputInterval)  
if not($puttyUsername) = "" Then  
Send ($puttyUsername)  
send ($commandEnter)  
sleep($inputInterval)  
EndIf    

sleep($inputInterval)  
if not($puttyPassword) = "" Then  
Send ($puttyPassword)  
send ($commandEnter)  
sleep($inputInterval)  
EndIf    

$commandArray = $commands[$i]  
for $commandId = 1 to Ubound($commandArray) - 1  
send($commandArray[$commandId])
sleep($inputInterval) 
send($commandEnter) 
sleep($inputInterval) 
Next  
Else  
msgbox(0,"","The putty window with title " & $puttyWindowTitle & " could not be find within the foreseen timeframe")  
Exit  
EndIf  
Next 
EndFunc  

Func waitLoadPuttyScreen($DataCellValue)
	sleep($DataCellValue) 
	;sleep(7000) 
EndFunc

Func waitLoadwithScreenText($DataCellValue)
	$array = StringSplit($DataCellValue, '-')
	for $iter = 1 to 20  
	WinActivate("[REGEXPTITLE:PuTTY.*]", "")
    Local $aPos = WinGetPos("[REGEXPTITLE:PuTTY.*]", "")
    MouseClick("left", $aPos[0]+15, $aPos[1]+15, 1, 1)
    Send("{DOWN 13}{Enter}")    	 
	Local $vClip = ClipGet()
	Local $var = StringRight($vClip,Number($array[2]))	
	$result = StringInStr($var, $array[1])	
    if $result >1 Then 		
       ExitLoop
   EndIf    
   Next
   
   if $iter=21 Then
	   Exit
    EndIf	   
EndFunc

Func SendkeyPuttyScreen($DataCellValue)
	;MsgBox(0, "", "The following data is stored in the clipboard: " & @CRLF & $DataCellValue)
	send($DataCellValue) 
EndFunc

Func SendkeyJavaArgument($InputParam)
	;MsgBox(0, "", "The following data is stored in the clipboard: " & @CRLF & $CmdLine[$DataCellValue])
	send($InputParam) 
EndFunc

  
Func SendenterPutty()
	send($commandEnter) 
EndFunc

Func ClipGetPuttyScreen()
WinActivate("[REGEXPTITLE:PuTTY.*]", "")
Local $aPos = WinGetPos("[REGEXPTITLE:PuTTY.*]", "")
MouseClick("left", $aPos[0]+15, $aPos[1]+15, 1, 1)
Send("{DOWN 13}{Enter}")
Local $vClip = ClipGet()
ConsoleWrite($vClip & @LF)
EndFunc




Func _getSelectedSessionCommands($selectedSessions)  
redim $selectedSessionCommands [ubound($selectedSessions)]  
$selectedSessionCommands[0] = ubound($selectedSessions)  
  
for $i = 1 to ubound($selectedSessions) - 1  
$session = $selectedSessions[$i]  
$selectedSessionCommands[$i] = IniRead($iniLocation, "sessions", $session[0], "NotFound")  
  
if $selectedSessionCommands[$i] == "NotFound" Then  
MsgBox(0, "Exception", "Could not find session " & $selectedSessionCommands[$i] & " in the configuration file")  
exit  
EndIf  
  
Next  
return $selectedSessionCommands  
EndFunc  
  
Func _getsessions($selectedEnvironments)  
$selectedEnvironments =  StringSplit($selectedEnvironments, ",")  
$sessionNumber = 0  
  
for $i = 1 to ubound($selectedEnvironments) - 1  
$tempSessions = IniRead($iniLocation, "environments", $selectedEnvironments[$i], "NotFound")  
if $tempSessions == "NotFound" Then  
MsgBox(0, "Exception", "Could not find environment " & $selectedEnvironments[$i] & " in the configuration file")  
exit  
EndIf  
  
$tempSessions = StringSplit($tempSessions, ",")  
  
for $j = 1 to ubound($tempSessions) - 1  
$sessionNumber = $sessionNumber + 1  
$selectedSessions[$sessionNumber] = _arraycreate($tempSessions[$j],$selectedEnvironments[$i])  
next  
  
Next  
  
redim $selectedSessions [$sessionNumber + 1]  
$selectedSessions[0] = ubound($selectedSessions)  
return $selectedSessions  
  
EndFunc  
  
  
Func _getCommands($selectedSessions)  
redim $commands [ubound($selectedSessions)]  
$commands[0] = ubound($selectedSessions)  
  
for $i = 1 to ubound($selectedSessions) - 1  
$session = $selectedSessions[$i]  
$commandString = IniRead($iniLocation, "commands", $session[1], "NotFound")  
$commands[$i] = stringsplit($commandString, $commanddelimiter)  
  
if $selectedSessionCommands[$i] == "NotFound" Then  
MsgBox(0, "Exception", "Could not find command " & $commands[$i] & " in the configuration file")  
exit  
EndIf  
  
Next  
return $commands  
EndFunc  
  
Func TogglePause()  
$Paused = NOT $Paused  
While $Paused  
sleep(100)  
ToolTip('Script is "Paused"',0,0)  
WEnd  
ToolTip("")  
EndFunc  
  
Func Terminate()  
WinClose("[REGEXPTITLE:PuTTY.*]", "")
EndFunc  
