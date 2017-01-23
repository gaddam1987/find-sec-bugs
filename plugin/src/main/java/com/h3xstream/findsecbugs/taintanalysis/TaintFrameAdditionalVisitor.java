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
package com.h3xstream.findsecbugs.taintanalysis;

import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InvokeInstruction;
import org.apache.bcel.generic.LoadInstruction;
import org.apache.bcel.generic.MethodGen;

public interface TaintFrameAdditionalVisitor {

    /**
     * Called each time a method invocation is seen by the taint analysis
     *
     * @param invoke
     * @param cpg
     * @param methodGen
     * @param frameType
     */
    void visitInvoke(InvokeInstruction invoke, ConstantPoolGen cpg, MethodGen methodGen, TaintFrame frameType);

    /**
     * Called each time a load instruction is seen by the taint analysis
     *
     * @param load
     * @param cpg
     * @param methodGen
     * @param frameType
     * @param numProduced
     */
    void visitLoad(LoadInstruction load, ConstantPoolGen cpg, MethodGen methodGen, TaintFrame frameType, int numProduced);

}
