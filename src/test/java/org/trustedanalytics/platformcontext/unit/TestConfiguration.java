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
package org.trustedanalytics.platformcontext.unit;

import java.util.ArrayList;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.trustedanalytics.platformcontext.data.DataProvider;
import org.trustedanalytics.platformcontext.data.externaltools.ExternalTools;

@Configuration
public class TestConfiguration {
    
    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setIgnoreResourceNotFound(true);
        final Properties properties = new Properties();
        properties.setProperty("cf.resource", ApiControllerTest.CF_RESOURCE);
        properties.setProperty("cf.cli.version", "");
        properties.setProperty("cf.cli.url", "");
        properties.setProperty("platform.version", "0.1");
        properties.setProperty("platform.coreorg", "coreOrg");
        ppc.setProperties(properties);
     
        return ppc;
    }
    
    @Bean
    public DataProvider getSomeClass() {
        return new DataProvider();
    }

    @Bean
    public ExternalTools externalTools() {
        return new ExternalTools(new ArrayList<>());
    }
}
