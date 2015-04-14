# Setup
* After creating a new Java project and importing the source.  Change line 12 of log4j.properties to match the location of where you'd like the log4j's output to be stored.  Then export the project as a JAR.
* Next, place the newly created JAR as well as the log4j library in a folder named "Resources" in your BIRT project
* Then from your report design > property editor > resources > add jar.  Point eclipse to the two jars you've added to your "Resources" folder

# Usage
BIRTLogger has two constructors

* BIRTLogger()
* BIRTLogger(String methodName, String reportName)

If you choose to use the constructor with no paramters, you will need to use the setters for methodName and reportName.

To use BIRTLogger you would then use some script like this in any method of your BIRT report

```
importPackage(Packages.com.opentext.birt.logger);
logger = new BIRTLogger("initialize", "BIRT Logging Example.rptdesign");

try {
	addalert("something");
}catch(ex){
	logger.logError(ex);
}
```

Note the second line of this example tells the logger that we're running "BIRT Logging Example.rptdesign" and any errors it catches is coming form the initialize() method.

The resulting output will look like this

```
2015-04-14 14:17:08 ERROR BIRTLogger:42 - BIRT Logging Example.rptdesign in initialize(): ReferenceError: "addalert" is not defined.
2015-04-14 14:17:09 ERROR BIRTLogger:42 - BIRT Logging Example.rptdesign in initialize(): ReferenceError: "addalert" is not defined.
```

Because some methods are executed more than once by the BIRT engine, you may end up with duplicate enteries like above.

# All BIRTLogger methods
* public BIRTLogger();
* public BIRTLogger(String methodName, String reportName);
* public void setReportName(String reportName);
* public void setMethodName(String methodName);
* public String getReportName();
* public String getMethodName();
* public void logError(String exception);
* public void logWarning(String warning);
* public void logInfo(String info);
* public void logDebug(String debug);
* public void logFatal(String fatal);
