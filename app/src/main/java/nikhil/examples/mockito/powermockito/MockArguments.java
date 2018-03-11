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

    /*
     Okay so now,
        The below function calls justAnotherClass.aFunctionWithManyArguments()
        which accepts an object of ExtraClass.
        If we want to mock this function, we would also have to mock the argument,
        which is an object of ExtraClass.
        But how do we do that?

        To mock an object of a custom class, we will use Mockito.any() in the test function.
      */
    public int doSomethingAmazing() {

        justAnotherClass =  new JustAnotherClass();

        ExtraClass extraClass = new ExtraClass();
        extraClass.setValueToBeShared(10);

        int answer = justAnotherClass.aFunctionWithCustomClassArgument(extraClass);
        return  answer;
    }


}
