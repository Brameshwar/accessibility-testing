package com;

import com.deque.html.axecore.results.Rule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import pages.DequeUniversityHomePage;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class homePageStepdefinations {

    DequeUniversityHomePage dequeUniversityHomePage = new DequeUniversityHomePage();

    @Then("Ensure the main-nav \\(CSS selector) has been loaded")
    public void ensure_the_main_nav_css_selector_has_been_loaded() {
        Assert.assertEquals(true,dequeUniversityHomePage.getMainNav().isDisplayed());
    }
    @And("Ensure the number of radio buttons under “Let the Adventure Begin” is {int}")
    public void ensure_the_number_of_radio_buttons_under_let_the_adventure_begin_is(Integer int1) {
        Assert.assertEquals(5,dequeUniversityHomePage.getListRadioButton().size());
    }
    @And("Ensure that clicking “add a traveler” adds another select to the page")
    public void ensure_that_clicking_add_a_traveler_adds_another_select_to_the_page() {
        Assert.assertTrue(dequeUniversityHomePage.clickOnAddTraveller());
        Assert.assertEquals(3,dequeUniversityHomePage.getListTraveller().size());
    }


    @Then("validate the accessiblity Testing the Deque")
    public void validate_the_accessiblity_testing_the_deque() {

        List<Rule> critial = new ArrayList<>();
        for(Rule rule: dequeUniversityHomePage.analyzePage())
        {
            System.out.println("Impact of Voilation : "+rule.getImpact());
            if(rule.getImpact().equalsIgnoreCase("critical")){
                critial.add(rule);
            }
        }

        Assert.assertEquals(0,critial.size());
    }

    @Then("Ensure that when clicking the arrows under the video, the heading changes")
    public void ensure_that_when_clicking_the_arrows_under_the_video_the_heading_changes() {
        Assert.assertTrue(dequeUniversityHomePage.clickOnRightNavForVideo());
        Assert.assertEquals("Why Mars died",dequeUniversityHomePage.getVideoText());
    }


}
