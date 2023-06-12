package playwrightsessions;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class LocatorConcept {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext browsercontext = browser.newContext();
		Page page = browsercontext.newPage();
		page.navigate("https://www.orangehrm.com");

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept Cookies")).click();
		//page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contact Sales")).click();
		
	    Locator companyOptions = page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Company$")));
	    System.out.println(companyOptions.count());
	    
	    for(int i = 0; i<companyOptions.count(); i++) {
	    	String text = companyOptions.nth(i).textContent();
	    }
	    

	      
	      
	      



		browser.close();
		playwright.close();
	}

}
