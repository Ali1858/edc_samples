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
import org.eclipse.edc.spi.asset.AssetIndex;
import org.eclipse.edc.spi.monitor.Monitor;
import org.eclipse.edc.spi.system.ServiceExtensionContext;
// import org.eclipse.edc.spi.types.domain.DataAddress;
// import org.eclipse.edc.spi.types.domain.asset.Asset;

// import java.nio.file.Path;

public class MetaDataExtractor {


    private static final String EDC_ASSET_PATH = "edc.samples.transfer.01.asset.path";
    private final Monitor monitor;
    private final ServiceExtensionContext context;
    @Inject
    private AssetIndex assetIndex;

    public MetaDataExtractor(ServiceExtensionContext context, Monitor monitor) {
        this.context = context;
        this.monitor = monitor;
    }
    
    public void registerAndExtract() {
        // var assetPathSetting = context.getSetting(EDC_ASSET_PATH, "/Users/ali/Desktop/test-document.txt");
        // var assetPath = Path.of(assetPathSetting);

        // var dataAddress = DataAddress.Builder.newInstance()
        //         .property("type", "File")
        //         .property("path", assetPath.getParent().toString())
        //         .property("filename", assetPath.getFileName().toString())
        //         .build();

        // var assetId = "test-document";
        // var asset = Asset.Builder.newInstance().id(assetId).build();
        // assetIndex.accept(asset, dataAddress);

        var asset2 = assetIndex.findById("test-document");
        monitor.info(asset2.toString());
    }
}


package org.eclipse.edc.sample.extension.api;

import org.eclipse.edc.policy.model.Action;
import org.eclipse.edc.policy.model.Permission;;
