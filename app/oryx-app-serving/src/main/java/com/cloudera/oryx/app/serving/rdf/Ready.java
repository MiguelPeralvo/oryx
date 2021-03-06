/*
 * Copyright (c) 2015, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */

package com.cloudera.oryx.app.serving.rdf;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.cloudera.oryx.app.serving.OryxServingException;

/**
 * <p>Responds to a HEAD or GET request to {@code /ready}
 * and returns {@link Response.Status#OK}
 * or {@link Response.Status#SERVICE_UNAVAILABLE} status depending or whether the model is
 * available or not.</p>
 */
@Singleton
@Path("/ready")
public final class Ready extends AbstractRDFResource {

  @HEAD
  public Response head() throws OryxServingException {
    return get();
  }

  @GET
  public Response get() throws OryxServingException {
    getRDFServingModel(); // Make sure it doesn't error
    return Response.ok().build();
  }
}

