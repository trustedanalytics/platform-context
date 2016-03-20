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

import org.trustedanalytics.platformcontext.model.Service;
import org.trustedanalytics.platformcontext.rest.PlatformContextControllerHelpers;
import org.trustedanalytics.platformcontext.data.externaltools.ExternalTool;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CFDataProvider {

    private final PlatformContextControllerHelpers helpers;

    public static final String DATA_SCIENCE_TOOL_TAG_NAME = "data-science-tool";

    public CFDataProvider(PlatformContextControllerHelpers helpers) {
        this.helpers = helpers;
    }

    public List<ExternalTool> getExternalToolsData(UUID orgId) {
        List<Service> services = helpers.getServices(orgId);
        services = helpers.filterServicesByTag(services, CFDataProvider.DATA_SCIENCE_TOOL_TAG_NAME);
        List<ExternalTool> externalTools = services.stream()
                .map(s -> {
                    ExternalTool externalTool = new ExternalTool();
                    externalTool.setName(s.getLabel());
                    externalTool.setAvailable(true);
                    return externalTool;
                })
                .collect(Collectors.toList());
        return externalTools;
    }
}
