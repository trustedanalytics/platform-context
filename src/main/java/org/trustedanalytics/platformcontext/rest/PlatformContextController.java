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
package org.trustedanalytics.platformcontext.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.RequestParam;
import org.trustedanalytics.platformcontext.data.CFDataProvider;
import org.trustedanalytics.platformcontext.data.PlatformContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.trustedanalytics.platformcontext.data.DataProvider;
import org.trustedanalytics.platformcontext.data.externaltools.ExternalTool;

import java.util.List;
import java.util.UUID;

import io.swagger.annotations.ApiOperation;

@RestController
public class PlatformContextController {
    public static final String GET_PLATFORM_CONTEXT_URL = "/rest/platform_context";
    public static final String GET_EXTERNAL_TOOLS_URL = "/rest/external_tools";

    private final DataProvider dataProvider;
    private final CFDataProvider cfDataProvider;

    @Autowired
    public PlatformContextController(DataProvider dataProvider, CFDataProvider cfDataProvider) {
        this.dataProvider = dataProvider;
        this.cfDataProvider = cfDataProvider;
    }

    @ApiOperation("Exposing platform specific information")
    @RequestMapping(value = GET_PLATFORM_CONTEXT_URL, method = GET, produces = APPLICATION_JSON_VALUE)
    public PlatformContext getPlatformContext() {
        return dataProvider.getData();
    }

    @ApiOperation("Exposing information about external tools installed in platform")
    @RequestMapping(value = GET_EXTERNAL_TOOLS_URL, method = GET, produces = APPLICATION_JSON_VALUE)
    public List<ExternalTool> getExternalTools(@RequestParam("space") UUID spaceId,
                                               @RequestParam(value = "service_keys", required = false) boolean fetchKeys) {
        return cfDataProvider.getExternalToolsData(spaceId, fetchKeys);
    }
}
