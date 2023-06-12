package playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

public class Example {
	  public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		   // Start tracing before creating / navigating a page.
		      context.tracing().start(new Tracing.StartOptions()
		        .setScreenshots(true)
		        .setSnapshots(true)
		        .setSources(true));

		      
		      Page page = context.newPage();
		      page.navigate("https://www.google.com/");
		      
		      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).click();
		      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).fill("Naveen Autom");
		      page.getByText("naveen automationlabs", new Page.GetByTextOptions().setExact(true)).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Welcome to Naveen AutomationLabs - naveen automationlabs Naveen AutomationLabs https://naveenautomationlabs.com")).click();
		      page.navigate("https://www.google.com/search?q=naveen+automationlabs&source=hp&ei=9fCFZPSZN6-5seMPioerqAg&iflsig=AOEireoAAAAAZIX_BXpvmmG21xDgrleJHtAAzLRCAZw_&oq=Naveen+Autom&gs_lcp=Cgdnd3Mtd2l6EAEYADIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQ6EAgAEAMQjwEQ6gIQjAMQ5QI6EAguEAMQjwEQ6gIQjAMQ5QI6EQguEIAEELEDEIMBEMcBENEDOgsILhCABBCxAxCDAToLCAAQgAQQsQMQgwE6CAgAEIAEELEDOgsIABCKBRCxAxCDAToOCC4QgAQQsQMQgwEQ1AI6CAgAEIoFELEDOggILhCxAxCABDoFCC4QgAQ6CAguEIAEENQCUNEMWP0wYKlDaAFwAHgAgAF1iAGrB5IBBDExLjGYAQCgAQGwAQo&sclient=gws-wiz");
		      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).click();
		      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).fill("naveen automationlabs aca");
		      page.getByText("naveen automationlabs academy", new Page.GetByTextOptions().setExact(true)).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("NaveenAutomationLabs Naveen AutomationLabs https://academy.naveenautomationlabs.com")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Courses").setExact(true)).click();
		      Page page1 = page.waitForPopup(() -> {
		        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Demo Site")).click();
		      });
		      page1.close();
		      Page page2 = page.waitForPopup(() -> {
		        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("WebDriver APIs")).click();
		      });
		      page2.close();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Webinars")).click();
		      page.navigate("https://academy.naveenautomationlabs.com/s/store");
		      page.navigate("https://academy.naveenautomationlabs.com/");
		      
		      context.tracing().stop(new Tracing.StopOptions()
		    		  .setPath(Paths.get("trace.zip")));
		    }
		  }
		}
