package PizhAir.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    BaseFunk baseFunk;

    public HomePage(BaseFunk baseFunk) {
        this.baseFunk = baseFunk;
    }

    public void setAirport(By locator, String airport) {
        Select depDropdown = new Select(baseFunk.getElement(locator));
        depDropdown.selectByVisibleText(airport);
    }

    public RegistrationPage goToRegistrationPage (By locator) {
        baseFunk.getElement(locator).click();
        return new RegistrationPage(baseFunk);
    }


}


