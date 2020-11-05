package seleniumWinAppDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import io.appium.java_client.windows.WindowsDriver;



public class Main {
	public static final String PATH = "C:\\Program Files\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", PATH);
		
		WebDriver ieDriver = new InternetExplorerDriver();
		
		final String URL = "http://egg.nttdata.co.jp/dataegg/";
		ieDriver.get(URL);
		
		ieDriver.findElement(By.name("loginId")).sendKeys("3255474");
		ieDriver.findElement(By.name("password")).sendKeys("passWORD01");
//		ieDriver.findElement(By.name("btnOk")).click();
		
		// sikulixのAPIを利用
		Screen s = new Screen();
		try {
			ImagePath.setBundlePath("C:\\workspace\\seleniumWinAppDriver\\src\\main\\resources\\images");
			s.click("login.png");
//			s.write("cmd");
		} catch (FindFailed e) {
			
		}

//		try {
//			ProcessBuilder pb = new ProcessBuilder();
//			pb.command("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe");
//			pb.start();
//			Runtime runtime = Runtime.getRuntime();			
//			runtime.exec("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe");
//		} catch(IOException e) {
//			
//		}
//		
//		String winAppDriverProcess = "WinAppDriver.exe";
//        if (processIsRun(winAppDriverProcess)) {
//        	System.out.println("起動中");
//        	
//        	try {
//            	//デスクトップ操作用ドライバインスタンスを生成
//        		DesiredCapabilities winAppCapability = new DesiredCapabilities();
//                winAppCapability.setCapability("app", "Root");
//                WindowsDriver desktopDriver = new WindowsDriver(new URL("http://127.0.0.1:4723"), winAppCapability);
//                
//
//                //Webブラウザのハンドルを取得
//                WebElement webBrowserWindow = desktopDriver.findElementByClassName("IEFrame");                
//                String webBrowserHandle = webBrowserWindow.getAttribute("NativeWindowHandle");
//                webBrowserHandle = Integer.toHexString(Integer.valueOf(webBrowserHandle));
//                
//                //Webブラウザ操作用ドライバインスタンスを生成
//                DesiredCapabilities webBrowserCapabilities = new DesiredCapabilities();
//                webBrowserCapabilities.setCapability("appTopLevelWindow",webBrowserHandle);
//                WindowsDriver webBrowserDriver = new WindowsDriver(new URL("http://127.0.0.1:4723"), webBrowserCapabilities);
//                
//                List<WebElement> elements = webBrowserDriver.findElementsByXPath("//Text[@Name=\"ログイン\"]");
//                if ((elements.isEmpty())) {
//                	elements = webBrowserDriver.findElementsByXPath("//Button[@Name=\"ログイン\"]");
//                }
//                WebElement element = elements.get(0);
//                element.click();
//                
//        	} catch(MalformedURLException e) {
//        		
//        	}  
//        }
		
		ieDriver.close();
	}
	
	public static boolean processIsRun(String process) {
        try {
            Process pro = new ProcessBuilder("tasklist").start();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    pro.getInputStream()));
            try {
                while (true) {
                    String line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.startsWith(process)) {
                        return true;
                    }
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return false;
    }

}
