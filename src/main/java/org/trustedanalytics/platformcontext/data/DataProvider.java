/**
 * Copyright (c) 2015 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.trustedanalytics.platformcontext.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataProvider {
       
    /*
     * get the value from cf.resource property - see also application.yml
     *
     * For unit testing this value is set in TestConfiguration
     *
     */
    @Value("${cf.resource}")
    private String apiEndpointUrl;

    public DataProvider() { };

    public PlatformContext getData() {
        return new PlatformContext(apiEndpointUrl);
    }

}
