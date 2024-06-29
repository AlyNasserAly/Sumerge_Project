package Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base_Page {
    protected static EdgeDriver driver;

    public Base_Page(EdgeDriver driver){this.driver = driver;}

    public Base_Page()
    {}
}
