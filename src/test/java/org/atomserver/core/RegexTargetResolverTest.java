/* Copyright (c) 2007 HomeAway, Inc.
 *  All rights reserved.  http://www.atomserver.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.atomserver.core;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.apache.abdera.protocol.server.TargetType;


public class RegexTargetResolverTest extends URITargetTestCase {

    public static Test suite()
    { return new TestSuite( RegexTargetResolverTest.class ); }

    public void setUp() throws Exception
    { super.setUp(); }
    
    protected void tearDown() throws Exception
    { super.tearDown(); }
    
    //----------------------------
    //          Tests 
    //----------------------------
    public void testService() throws Exception {
        checkTarget( "/" + servletMapping + "/",  TargetType.TYPE_SERVICE );
        checkTarget( "/" + servletMapping + "/widgets",  TargetType.TYPE_SERVICE );
        checkTarget( "/" + servletMapping + "/widgets/",  TargetType.TYPE_SERVICE );
    }

    public void testCollection() throws Exception {
        checkTarget( "/" + servletMapping + "/widgets/acme",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme/",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme?xyz=foo&abc=bar",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme?updated-min=2007-10-09T22:42:26.000Z&locale=en",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme?xyz=foo&abc=bar&lmn=goop",  TargetType.TYPE_COLLECTION );

        checkTarget( "/" + servletMapping + "/widgets/acme/-/cat1/cat2",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme/-/cat1",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme/-/cat1?xyz=foo&abc=bar&lmn=goop",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme/-/cat1?updated-min=2007-10-09T22:42:26.000Z&locale=en",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme/-/cat1/cat2/cat3",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme/-/cat1/cat2/cat3?xyz=foo&abc=bar&lmn=goop",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme/-/cat1/cat2/cat3?updated-min=2007-10-09T22:42:26.000Z&locale=en",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme/-/(urn:widgets.foo)test2",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme/-/(urn:widgets.foo)test0/(urn:widgets.foo)boo0",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme/-/(urn:widgets.foo)test2/(urn:widgets.foo)boo1/(urn:widgets.foo)ugh1",  TargetType.TYPE_COLLECTION );
        checkTarget( "/" + servletMapping + "/widgets/acme/-/(urn:widgets.foo)test2/(urn:widgets.foo)boo1/(urn:widgets.foo)ugh1/(urn:widgets.foo)oops",  TargetType.TYPE_COLLECTION );
    }

    public void testEntry() throws Exception {
        checkTarget( "/" + servletMapping + "/widgets/acme/123.en.xml",  TargetType.TYPE_ENTRY );
        checkTarget( "/" + servletMapping + "/widgets/acme/123",  TargetType.TYPE_ENTRY );
        checkTarget( "/" + servletMapping + "/widgets/acme/123?xyz=foo&abc=bar",  TargetType.TYPE_ENTRY );
        checkTarget( "/" + servletMapping + "/widgets/acme/123?xyz=foo&abc=bar&lmn=goop",  TargetType.TYPE_ENTRY );
        checkTarget( "/" + servletMapping + "/widgets/acme/123/3",  TargetType.TYPE_ENTRY );
        checkTarget( "/" + servletMapping + "/widgets/acme/123/3?xyz=p1&abc=p2&mno=p3",  TargetType.TYPE_ENTRY );
        checkTarget( "/" + servletMapping + "/widgets/acme/123/3?updated-min=2007-10-09T22:42:26.000Z&locale=en",  TargetType.TYPE_ENTRY );
        checkTarget( "/" + servletMapping + "/widgets/acme/123.en.xml/3",  TargetType.TYPE_ENTRY );
        checkTarget( "/" + servletMapping + "/widgets/acme/123.en.xml/3?xyz=p1&abc=p2&mno=p3",  TargetType.TYPE_ENTRY );
        checkTarget( "/" + servletMapping + "/widgets/acme/123.en.xml/3?updated-min=2007-10-09T22:42:26.000Z&locale=en",  TargetType.TYPE_ENTRY );
    }

    
}
