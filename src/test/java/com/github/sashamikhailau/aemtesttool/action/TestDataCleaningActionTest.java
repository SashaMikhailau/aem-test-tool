package com.github.sashamikhailau.aemtesttool.action;

import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestDataCleaningActionTest extends BasePlatformTestCase {


    @Override
    @BeforeEach
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    @AfterEach
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Override
    protected String getTestDataPath() {
        return "src/test/testData";
    }

    @ParameterizedTest
    @CsvSource({"content.xml,content-after.xml", "content.json,content-after.json"})
    public void testCleanup(final String sourcePath, final String resultPath) {
        myFixture.configureByFile("/cleanAction/" + sourcePath);
        myFixture.performEditorAction("com.github.sashamikhailau.aemtesttool.action.TestDataCleaningAction");
        myFixture.checkResultByFile("/cleanAction/" + resultPath);
    }
}