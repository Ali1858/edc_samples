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


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.edc.spi.monitor.Monitor;
import org.eclipse.edc.spi.system.ServiceExtensionContext;

import static java.lang.String.format;

@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("/")
public class MetaDataExtractorController {

    
    private final Monitor monitor;
    private final String logPrefix;
    private final ServiceExtensionContext context;

    public MetaDataExtractorController(ServiceExtensionContext context, String logPrefix) {
        this.monitor = context.getMonitor();
        this.logPrefix = logPrefix;
        this.context = context;
        monitor.info(format("%s :: up and running", logPrefix));
    }

    @GET
    @Path("getmetadata")
    public String getmetadata() {
        monitor.info(format("%s :: Received a request", logPrefix));
        return "{\"response\":\"I don't have metadata. Please try again!\"}";
    }

    @POST
    @Path("getmetadata")
    public String getmetadata(String payload) {
        monitor.info(format("%s :: Received a request", logPrefix));
        monitor.info(format("%s :: Received a payload", payload.toString()));
        var extractor = new MetaDataExtractor(context, monitor);
        extractor.registerAndExtract();
        return "{\"response\":\"Something happened\"}";
    }
}
