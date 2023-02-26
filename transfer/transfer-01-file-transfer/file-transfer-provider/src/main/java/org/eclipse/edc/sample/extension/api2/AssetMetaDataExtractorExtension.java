/*
 *  Copyright (c) 2021 Microsoft Corporation
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Microsoft Corporation - Initial implementation
 *
 */

package org.eclipse.edc.sample.extension.api2;

import org.eclipse.edc.runtime.metamodel.annotation.Inject;
import org.eclipse.edc.spi.system.ServiceExtension;
import org.eclipse.edc.spi.system.ServiceExtensionContext;
import org.eclipse.edc.web.spi.WebService;

public class AssetMetaDataExtractorExtension implements ServiceExtension {

    @Inject
    WebService webService;

    private static final String LOG_PREFEX_SETTING = "edc.samples.test.logprefix";

    @Override
    public void initialize(ServiceExtensionContext context) {
        var logPrefix = context.getSetting(LOG_PREFEX_SETTING, "default_prefix");
        context.getMonitor().info("===================inside extensions===================");
        webService.registerResource(new MetaDataExtractorController(context, logPrefix));
    }
}
