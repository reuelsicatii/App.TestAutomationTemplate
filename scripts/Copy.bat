echo off
set MYDATE=%date:~6,4%%date:~3,2%%date:~0,2%
set CUR_HH=%time:~0,2%
if %CUR_HH% lss 10 (set CUR_HH=0%time:~1,1%)
set MYTIME=%CUR_HH%%time:~3,2%%time:~6,2%%time:~9,2%
set SUBFILENAME=%MYDATE%%MYTIME%

xcopy "D:\04. Test Automation\03 RemoteRepo\tlos_autotest\target\*.html" "C:\Jenkins\userContent\SeleniumReport\%SUBFILENAME%\"