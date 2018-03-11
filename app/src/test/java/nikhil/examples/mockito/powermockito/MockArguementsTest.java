package nikhil.examples.mockito.powermockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MockArguementsTest {

    MockArguments mockArguments;
    /*
    To test doSomethingIncredible, we would need to mock JustAnotherClass,
    and also mock the arguments which aFunctionWithManyArguments() accepts
     */
    @Test
    public void testDoSomethingIncredible() {

        mockArguments = new MockArguments();
        /*
        Step 1
            Mock JustAnotherClass
         */
        JustAnotherClass justAnotherClassMock = Mockito.mock(JustAnotherClass.class);

        /*
        Step 2
            Mock the behaviour of function justAnotherClass.aFunctionWithManyArguments().
            Now, we use mock arguments, since we do not care about what arguments get in,
            we just use Mockito.anyInt() / anyList() blaaah blaah.
         */
        Mockito.when(justAnotherClassMock
                .aFunctionWithManyArguments(Mockito.anyInt(), Mockito.anyFloat()
                        , Mockito.anyList(), Mockito.anyString())).thenReturn(5);

        /*
        Step 3
            Set justAnotherClassMock
         */
        mockArguments.setJustAnotherClass(justAnotherClassMock);

        /*
        Step 4:
            Call the function to be tested
         */
        int answer = mockArguments.doSomethingIncredible();

        /*
        Step 5
            Verify the result. Since we are also doing answer++ in the function,
            the returned value will be mocked return (which is 5) + 1 which is 6
         */
        Assert.assertEquals(answer, 6);
    }

    /*
    To test doSomethingAmazing, we will have to mock
        justAnotherClass.aFunctionWithManyArguments()
        which accepts an object of ExtraClass.
        If we want to mock this function, we would also have to mock the argument,
        which is an object of ExtraClass.

        We do this by using Argument Matcher  Mockito.any()
     */
    @Test
    public void testDoSomethingAmazing() {

        mockArguments = new MockArguments();

        /*
        Step 1
            Mock JustAnotherClass
         */
        JustAnotherClass justAnotherClassMock = Mockito.mock(JustAnotherClass.class);

        /*
        Step 2
            Mock the behaviour of function justAnotherClass.aFunctionWithCustomClassArgument,
            To mock the argument of ExtraClass, we use Mockito.any() instead of Mockito.anyInt,
            Mockito.anyString blaah blaah.

            BUT., Mockito.any() needs to know what class the argument belongs to, so we
            pass the class as argument to Mockito.any()
         */
        Mockito.when(justAnotherClassMock
                .aFunctionWithCustomClassArgument(
                        Mockito.any(ExtraClass.class))).thenReturn(10);


        /*
        Step 3
            Set justAnotherClassMock
         */
        mockArguments.setJustAnotherClass(justAnotherClassMock);

        /*
        Step 4:
            Call the function to be tested
         */
        int answer = mockArguments.doSomethingAmazing();

        /*
        Step 5
            Verify the result. Since we are also doing answer++ in the function,
            the returned value will be mocked return (which is 10) + 1 which is 11
         */
        Assert.assertEquals(answer, 11);
    }
}
