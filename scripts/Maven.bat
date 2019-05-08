del /f target\CucumberReport.html
del /f target\CucumberReport_ReRun.html
del /f target\rerun.txt
del /f target\rerun1.txt
mvn -Dtest=CompassSmoke* test

