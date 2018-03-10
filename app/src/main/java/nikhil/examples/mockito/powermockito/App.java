package nikhil.examples.mockito.powermockito;

/**
 * Hello world!
 *
 */
public class App 
{
    private int aNormalVariable;
    private int anotherNormalVariable;

    private JustAnotherClass justAnotherClass;

    /*
    No use of any mocking. This is an easy to test function
     */
    public void simpleMethod(int someValue) {

        System.out.println("Hey! Lets change the value of the variable to test this function");
        aNormalVariable = someValue;
    }

    /*
    A very simple mockito example.
    This function calls another function of class JustAnotherClass
    which does some heavy processing which takes time.
    Since we do not want to waste time in unit testing, we use mockito while testing
    to mock the 'doSomethingComplex' function call.
     */
    public int doHeavyProcessing() throws InterruptedException {

        anotherNormalVariable = justAnotherClass.doSomethingComplex(aNormalVariable);
        return anotherNormalVariable;
    }

    public int getaNormalVariable() {
        return aNormalVariable;
    }

    public void setaNormalVariable(int aNormalVariable) {
        this.aNormalVariable = aNormalVariable;
    }

    public void setJustAnotherClass(JustAnotherClass justAnotherClass) {
        this.justAnotherClass = justAnotherClass;
    }
}
