package org.otus.hw03;


import org.otus.hw03.testframework.annotations.After;
import org.otus.hw03.testframework.annotations.Before;
import org.otus.hw03.testframework.annotations.Test;

@Test
public class ClassTest {

    @After
    public void testAfter(){
        System.out.println("testAfter");
    }

    @Before
    public void testBefore(){
        System.out.println("testBefore");
    }

    @Test
    public void testMethod1(){
        System.out.println("testMethod1");
    }

    @Test
    public void testMethod2() throws Exception {
        System.out.println("testMethod2");
        throw new Exception("Test Error");
    }

    @Test
    public void testMethod3(){
        System.out.println("testMethod3");
    }
}
