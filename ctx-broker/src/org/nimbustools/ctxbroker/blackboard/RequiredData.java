/*
 * Copyright 1999-2008 University of Chicago
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.nimbustools.ctxbroker.blackboard;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class RequiredData {

    // -------------------------------------------------------------------------
    // INSTANCE VARIABLES
    // -------------------------------------------------------------------------

    private final String name;
    
    private final List<DataPair> values = new ArrayList<DataPair>();

    
    // -------------------------------------------------------------------------
    // CONSTRUCTOR
    // -------------------------------------------------------------------------

    RequiredData(String dataname) {
        if (dataname == null) {
            throw new IllegalArgumentException("dataname may not be null");
        }
        this.name = dataname;
    }


    // -------------------------------------------------------------------------
    // MUTATE
    // -------------------------------------------------------------------------

    void addNewValue(String value) {
        if (value == null || value.trim().length() == 0) {
            value = "";
        }
        this.values.add(new DataPair(this.name, value));
    }


    // -------------------------------------------------------------------------
    // ACCESS
    // -------------------------------------------------------------------------

    int numValues() {
        return this.values.size();
    }

    // never returns null
    List<DataPair> getDataList() {
        return this.values;
    }

    // never returns null
    List<DataPair> getAllData() {
        return Collections.unmodifiableList(values);
    }
    
}
