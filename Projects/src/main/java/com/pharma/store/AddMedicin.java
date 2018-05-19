package com.pharma.store;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/addMedicin")
public class AddMedicin {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addMedicin(String jsonReqStr) {
		return "Medicine Adde\n"+jsonReqStr;
	}
}

/*
@Override
@POST
@Path("/device/{device_id:.*}")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public String updateDeviceInfo(@Context HttpHeaders headers, @Context HttpServletRequest request,
		@Context HttpServletResponse response, @PathParam("device_id") String device_id, String jsonReqStr) {

	logger.info("Request URI for updateDeviceInfo : [" + request.getRequestURI() + "] Request Json : [" + jsonReqStr + "]");
	
	return deviceidUpdateReqHandler.updateDeviceInfo(appResources, request, response, device_id, jsonReqStr);
}
*/