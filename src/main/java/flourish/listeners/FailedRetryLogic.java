package flourish.listeners;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import flourish.testbase.AndroidTestBase;

public class FailedRetryLogic extends AndroidTestBase implements IRetryAnalyzer {
	
	public Logger logger = Logger.getLogger(FailedRetryLogic.class);

	int max_Count=2;
	int count=1;
	
	public boolean retry(ITestResult result) {
		
		if(count <= max_Count)
		{
			if(count==1)
			{
				logger.info("Executing "+result.getName()+" for first time due to previous execution failure");
			}
			else if(count==2)
			{
				logger.info("Executing "+result.getName()+" for second time due to previous execution failure");
			}
			else if(count==3)
			{
				logger.info("Executing "+result.getName()+" for third time due to previous execution failure");
			}
			else if(count==4)
			{
				logger.info("Executing "+result.getName()+" for fourth time due to previous execution failure");
			}
			else 
			{
				logger.info("Count not matched");
			}
			
			count++;
			return true;
		}
		
		return false;
	}
	
	

}
