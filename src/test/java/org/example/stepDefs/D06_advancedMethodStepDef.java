package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.Pages.P06_advancedMethod;
import org.example.utilities.BrowserUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;



public class D06_advancedMethodStepDef {
    P06_advancedMethod hoverCategories = new P06_advancedMethod();
    String category;

    @When("user hover category and select subcategory")
    public void user_hover_category(){

        int categoriesCount = hoverCategories.Categories().size();
        int categoryNum = BrowserUtils.randomNum(0, categoriesCount-1);
        System.out.println(categoryNum);

        Actions action = new Actions(Hooks.driver);
        action.moveToElement(hoverCategories.Categories().get(categoryNum)).perform();

        if(!hoverCategories.subCategories(categoryNum).isEmpty())
        {
            int subCategories = hoverCategories.subCategories(categoryNum).size();
            int subCategoriesNum = BrowserUtils.randomNum(0, subCategories-1);
            this.category = hoverCategories.subCategories(categoryNum).get(subCategoriesNum).getText().trim();
            System.out.println("Sub categories: "+this.category);
            hoverCategories.subCategories(categoryNum).get(subCategoriesNum).click();

        }
        else
        {
            this.category = hoverCategories.Categories().get(categoryNum).getText().trim();
            System.out.println("Main category: "+this.category);
            hoverCategories.Categories().get(categoryNum).click();

        }

    }

    @And("category page is displayed")
    public void category_page_displayed(){
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(hoverCategories.category_page().isDisplayed());
        soft.assertTrue(hoverCategories.page_title().getText().contains(this.category));
        soft.assertAll();

    }

}
