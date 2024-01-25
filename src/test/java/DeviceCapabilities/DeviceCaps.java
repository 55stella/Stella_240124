package DeviceCapabilities;

import BaseClasses.TestBase;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DeviceCaps  extends TestBase {


    public static void InfinixHot8() {
        caps = new DesiredCapabilities();
        String filePath =System.getProperty("user.dir") + "\\src\\test\\java\\MobileAutomation\\Resources\\QAtestbuild22ndJan.apk";
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Infinix HOT 8");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(MobileCapabilityType.APP, filePath);
        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("noReset", false);
    }

    public static void TecnoCamon19() {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TECNO CAMON 19");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.wemabank.alat.office.alat_qa_test");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "crc64157f0f34b4e613ce.GetStartedActivity");
        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("noReset", false);
    }


}
