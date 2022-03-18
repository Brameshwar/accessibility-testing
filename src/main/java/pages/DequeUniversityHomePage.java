package pages;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import core.BaseTest;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
@Setter
public class DequeUniversityHomePage extends BaseTest {

   WebDriver driver;
    public DequeUniversityHomePage() {
        driver = BaseTest.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "main-nav")
    private WebElement mainNav;

    @FindBy(xpath = "//h3[contains(text(),'Let the Adventure Begin')]/../form/fieldset//input")
    private List<WebElement> listRadioButton;

    @FindBy(xpath = "//span[@class=\"traveler-label\"]")
    private List<WebElement> listTraveller;

    @FindBy(xpath = "//a[@class=\"add-traveler\"]")
    private WebElement addTraveller;

    @FindBy(xpath = "//i[@class='vid-next icon-video-right-arrow']")
    private WebElement rightNavForVideo;

    @FindBy(id="video-text")
    private WebElement videoText;

    public boolean clickOnAddTraveller(){
        try{
            addTraveller.isDisplayed();
            addTraveller.click();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean clickOnRightNavForVideo(){
        try{
            rightNavForVideo.isDisplayed();
            rightNavForVideo.click();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public String getVideoText(){
        try{
            videoText.isDisplayed();
            return videoText.getText();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Rule> analyzePage() {

        AxeBuilder builder = new AxeBuilder();
        Results results = builder.analyze(driver);
        return results.getViolations();

    }

}
