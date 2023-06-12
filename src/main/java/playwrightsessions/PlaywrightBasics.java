package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright pl = Playwright.create();
		
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		Browser browser = pl.chromium().launch(lp);
		/*
		 * Browser browser = pl.webkit().launch(new
		 * BrowserType.LaunchOptions().setHeadless(false));
		 */
		Page page = browser.newPage();
		page.navigate("https://www.amazon.com");
		
		String title = page.title();
		System.out.println("page title is " + title);
		
		String url = page.url();
		System.out.println("page url is " + url);
		
		browser.close();
		pl.close();

	}

}
