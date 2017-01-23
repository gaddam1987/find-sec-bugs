/**
 * Find Security Bugs
 * Copyright (c) Philippe Arteau, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */
package com.h3xstream.findsecbugs.password;

import com.h3xstream.findbugs.test.BaseDetectorTest;
import com.h3xstream.findbugs.test.EasyBugReporter;
import com.h3xstream.findsecbugs.FindSecBugsGlobalConfig;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class HardcodedPasswordEqualsDetectorTest extends BaseDetectorTest {

    @Test
    public void detectHardCodePasswordsWithEquals() throws Exception {
//        FindSecBugsGlobalConfig.getInstance().setDebugPrintInstructionVisited(true);
//        FindSecBugsGlobalConfig.getInstance().setDebugTaintState(true);


        String[] files = {
                getClassFilePath("testcode/password/EqualsPasswordField"),
                getClassFilePath("testcode/template/FreemarkerUsage")
        };

        EasyBugReporter reporter = spy(new BaseDetectorTest.SecurityReporter());
        analyze(files, reporter);

        for (Integer line : Arrays.asList(17, 26, 37)) {
            verify(reporter).doReportBug(
                    bugDefinition()
                            .bugType("HARD_CODE_PASSWORD")
                            .inClass("EqualsPasswordField").atLine(line)
                            .build()
            );
        }

        verify(reporter, times(3)).doReportBug(bugDefinition().bugType("HARD_CODE_PASSWORD").build());
    }
}
