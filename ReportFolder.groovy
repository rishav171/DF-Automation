import jenkins.model.*;
import hudson.model.*;
def folderName = "TestRun_2016-04-25_14-17-26-PM";
def pa = new ParametersAction([
new StringParameterValue("FOLDERNAME_QA_JOB", folderName)
])
Thread.currentThread().executable.addAction(pa);