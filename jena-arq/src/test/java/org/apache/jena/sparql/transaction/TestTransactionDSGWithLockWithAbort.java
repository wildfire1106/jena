/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jena.sparql.transaction;

import org.apache.jena.query.Dataset ;
import org.apache.jena.query.DatasetFactory ;
import org.apache.jena.sparql.core.DatasetGraph ;
import org.apache.jena.sparql.core.DatasetGraphFactory ;
import org.apache.jena.sparql.core.DatasetGraphWithLock ;

/** Version with abortImplemented == true */
public class TestTransactionDSGWithLockWithAbort extends AbstractTestTransactionLifecycle
{
    @Override
    protected Dataset create() { 
        // The tests don't actuall add/delete data.
        DatasetGraph dsg = DatasetGraphFactory.create() ;
        DatasetGraphWithLock dsgl = new  DatasetGraphWithLock(dsg) {
            @Override
            protected boolean abortImplemented() { return true ; }
        } ;
        return DatasetFactory.wrap(dsgl) ;
    }
 }

