package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public abstract class TextSelector {

	public static void main(String[] args) {

	    try (Playwright playwright = Playwright.create()) {
	        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	          .setHeadless(false));
	        BrowserContext context = browser.newContext();
	        Page page = context.newPage();
	        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	        page.getByPlaceholder("Username").click();
	        page.getByPlaceholder("Username").fill("Admin");
	        page.getByPlaceholder("Username").press("Tab");
	        page.getByPlaceholder("Password").fill("admin123");
	        page.getByPlaceholder("Password").press("Tab");
	        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
	        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
	        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
	        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin")).click();
	        
	        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PIM")).click();
	        
	        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Leave")).click();
	        
	        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time")).click();
	        
	        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Recruitment")).click();
	        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Vacancies")).click();
	        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Info")).click();
	        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Performance")).click();
	        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();
	        page.getByText("(14) Leave Requests to Approve").click();
	        page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Paul Collings")).locator("i").click();
	        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Logout")).click();

		
	    }
	}

}
