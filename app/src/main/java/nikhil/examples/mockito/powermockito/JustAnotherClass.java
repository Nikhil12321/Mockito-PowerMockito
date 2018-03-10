package nikhil.examples.mockito.powermockito;

import java.util.List;

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
    public int doSomethingComplex() throws InterruptedException {

        int someVariable = 10123;
        someVariable += 1;
        someVariable = (int) Math.log(someVariable);
        someVariable = (int) Math.tan(someVariable);
        Thread.sleep(2000);
        return someVariable;
    }

    public int aFunctionWithManyArguments(int a, float b, List<Integer> c, String d){

        return a + (int)b + c.size() + d.length();
    }
}
