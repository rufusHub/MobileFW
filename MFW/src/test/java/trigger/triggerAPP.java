package trigger;

import java.net.MalformedURLException;

import org.testing.Base.LaunchApplication;
import org.testing.testScripts.TC1_DragAndDropEvent_APPdemo;
import org.testing.testScripts.TC2_LongPressEvent_APPdemo;

public class triggerAPP extends LaunchApplication{
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		String apkName = "ApiDemo.apk"; 
		
//		LaunchApplication obj = new LaunchApplication();
//		obj.configuration(apkName);
		
//		DragAndDropEvent drag = new DragAndDropEvent();
//		drag.configuration(apkName);
//		drag.DragAndDrop_TC();
//		
		TC2_LongPressEvent_APPdemo lng = new TC2_LongPressEvent_APPdemo();
		lng.configuration(apkName);
		lng.LongPress();
		
		
		
	}

}
