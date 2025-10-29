package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest {

    @Test
    public void verifyMath() {
        int result = 2 + 2;
        Assert.assertEquals(result, 4, "Math check");
    }
}
