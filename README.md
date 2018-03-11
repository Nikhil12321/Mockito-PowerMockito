# Mockito and PowerMockito. How do they work

## Let's start with Mockito

---

### Why use it?

1. Let's say you are writing unit test cases for a class A and it contains a method funcA which calls a method, say funcB, of another class B. 

2. FuncB takes 5 seconds to execute and you really don't care what output it produces because you are testing class A and not class B. So, what to do? You can't afford to wait 5 seconds for funcB to finish its work beause you really don't care about it.

3. Mockito to the rescueeeee!! 
With mockito, you can mock the behaviour of funcB and NOT ACTUALLY call funcB when it is called. Instead, return anything you want whenever funcB is encountered. This saves time and also saves you the headache of handling transitive dependencies.

**Lets look at a simple example**
_Lets say you have a function in a class like this_

```java
 public int doHeavyProcessing() throws InterruptedException {

        anotherNormalVariable = justAnotherClass.doSomethingComplex();
        return anotherNormalVariable;
    }
```

This function calls ```justAnotherClass.doSomethingComplex()``` which a long time to execute. To test ```doHeavyProcessing``` function, lets mock ```doSomethingComplex()```.

```java
Mockito.when(justAnotherClassMock.doSomethingComplex()).thenReturn(1);
```
This makes sure that whenever doSomethingComples is called, it returns one.

You can have a look at the entire class [here](https://github.com/Nikhil12321/Mockito-PowerMockito/blob/master/app/src/main/java/nikhil/examples/mockito/powermockito/SimpleMockito.java) and the test class [here](https://github.com/Nikhil12321/Mockito-PowerMockito/blob/master/app/src/test/java/nikhil/examples/mockito/powermockito/SimpleMockitoTest.java)
