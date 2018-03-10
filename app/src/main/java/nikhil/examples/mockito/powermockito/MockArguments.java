package nikhil.examples.mockito.powermockito;

import java.util.ArrayList;
import java.util.List;

public class MockArguments {

    JustAnotherClass justAnotherClass;
    int answer;

    /*
    This function calls justAnotherClass.aFunctionWithManyArguments()
    which accepts 4 arguments and returns a value.
    During testing, we must/may not be concerned with the arguments and/or
    the internal workings of the aFunctionWithManyArguments() and just
    concerned about the final answer which doSomethingIncredible() returns.

    Which is why we will use mock arguments.
     */
    public int doSomethingIncredible() {

        /*
        Just a random list
         */
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<100; i++)
            list.add(i+1);

        answer = justAnotherClass.aFunctionWithManyArguments(1, (float) 2.0, list, "hey");
        answer++;
        return answer;
    }

    public void setJustAnotherClass(JustAnotherClass justAnotherClass) {
        this.justAnotherClass = justAnotherClass;
    }

    // Bonus::TODO:: use of Mockito.any() on custom class


}
