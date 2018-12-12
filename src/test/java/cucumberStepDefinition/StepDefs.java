package cucumberStepDefinition;

import cucumber.api.java.en.Given;

public class StepDefs {

    @Given("Print test anotation (.*)")

    public void print_test_anotation (String annotation){

     System.out.println(annotation);

    }
}
