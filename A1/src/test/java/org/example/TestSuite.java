package org.example;


import org.junit.runner.RunWith;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;

@RunWith(JUnitPlatform.class)
@SelectPackages(value = {"org.example"})
public class TestSuite {
}
