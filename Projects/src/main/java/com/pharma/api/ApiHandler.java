package com.pharma.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pharma.blacklist.BlacklistHandler;
import com.pharma.buy.BuyMedicineHandler;
import com.pharma.medicine.AddMedicineHandler;
import com.pharma.medicine.SearchMedicineHandler;
import com.pharma.medicine.UpdateMedicineHandler;
import com.pharma.stats.BuyingHistoryHandler;
import com.pharma.stats.SoldStatsHandler;

@Path("api")
public class ApiHandler {
	BaseHandler handler = null;
	//TODO: request validation, authentication etc
	@POST
	@Path("/addMedicine")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addMedicine(String reqString) throws Exception {
		
		handler = new AddMedicineHandler();
		return handler.handleRequest(reqString);
		
    }
	
	@POST
	@Path("/updateMedicine")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateMedicine(String reqString) throws Exception {
		handler = new UpdateMedicineHandler();
		return handler.handleRequest(reqString);
		
    }
	
	@POST
	@Path("/buyMedicines")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String buyMedicines(String reqString) throws Exception {
		handler = new BuyMedicineHandler();
		return handler.handleRequest(reqString);
    }
	
	@POST
	@Path("/searchMedicines")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getMedicineDetails(String reqString) throws Exception {
		handler = new SearchMedicineHandler();
		return handler.handleRequest(reqString);
    }
	
	@GET
	@Path("/blacklist/{brand}")
    @Produces(MediaType.APPLICATION_JSON)
    public String blacklist(@PathParam("brand") String brand) throws Exception {
		handler = new BlacklistHandler();
		return handler.handleRequest(brand);
    }
	
	@GET
	@Path("/topSoldMedicines/{topNum}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTopSoldMedicines(@PathParam("topNum") String topNum) throws Exception {
		handler = new SoldStatsHandler();
		return handler.handleRequest(topNum);
    }
	
	@POST
	@Path("/customerBuyingHistory")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomerBuyingHistory(String reqString) throws Exception {
		handler = new BuyingHistoryHandler();
		return handler.handleRequest(reqString);
    }
}
