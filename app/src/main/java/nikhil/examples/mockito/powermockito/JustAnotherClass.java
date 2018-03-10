package nikhil.examples.mockito.powermockito;

public class JustAnotherClass {

    private int var1;
    private int var2;

    public JustAnotherClass(){

        var1 = var2 = 0;
    }

    /*
    This function does something complex, takes time and returns some value.
    DO NOT go into the details of what it does
     */
    public int doSomethingComplex(int someVariable) throws InterruptedException {

        someVariable += 1;
        someVariable = (int) Math.log(someVariable);
        someVariable = (int) Math.tan(someVariable);
        Thread.sleep(2000);
        return someVariable;
    }
}
