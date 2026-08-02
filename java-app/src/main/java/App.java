package com.dev3l.hello_world.test;

import org.junit.Assert;
import org.junit.Test;

public class App
{
    public static void main(String[] args)
    {
        System.out.println("Java ppplication started.");
        System.out.println("Build executed successfully from Jenkins.");
        System.out.println("Java application version: "+System.getProperty("java.version"));
    }
}

class ExampleTest
{
    @Testpublic void exampleTest()
    {
        Assert.assertTrue(true);
    }
}