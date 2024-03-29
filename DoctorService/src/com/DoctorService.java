package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Doctor;

@Path("/Doctors")
public class DoctorService {
	
	Doctor doc = new Doctor();
	
/**	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String addDocs(@FormParam("dName") String name,
						  @FormParam("dSpecialization") String specialization,
						  @FormParam("dAddress") String address,
						  @FormParam("dEmail") String email,
						  @FormParam("dFee") String fee,
						  @FormParam("dWHospital") String wHospital)
	{
		//String id, String name, String specialization, String address, String email, String fee, String wHospital
		String output = doc.addDoctors(name, specialization, address, email, fee, wHospital);
		return output;
	}
	**/
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addDoctor(String docData)
	{
		JsonObject docObject = new JsonParser().parse(docData).getAsJsonObject();
		
		String name = docObject.get("dName").getAsString();
		String specialization = docObject.get("dSpecialization").getAsString();
		String address = docObject.get("dAddress").getAsString();
		String email = docObject.get("dEmail").getAsString();
		String fee = docObject.get("dFee").getAsString();
		String hospital = docObject.get("dWHospital").getAsString();
		
		String output = doc.addDoctors(name, specialization, address, email, fee, hospital);
		
		return output;
	}
	
	@GET
	@Path("/readDoctors")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctors()
	{
		return doc.readDoctors();
	}

	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctor(String docData)
	{
		JsonObject docObject = new JsonParser().parse(docData).getAsJsonObject();
				//JsonParser().parse(docData).getAsJsonObject();
	
		String id = docObject.get("ID").getAsString();
		String name = docObject.get("dName").getAsString();
		String specialization = docObject.get("dSpecialization").getAsString();
		String address = docObject.get("dAddress").getAsString();
		String email = docObject.get("dEmail").getAsString();
		String fee = docObject.get("dFee").getAsString();
		String hospital = docObject.get("dWHospital").getAsString();
		
		String output = doc.updateDoctor(id, name, specialization, address, email, fee, hospital);
		return output;
		
	}
	
/**
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctor(String docData)
	{
		//Document document = Jsoup.parse(docData, "", Parser.xmlParser());
		org.jsoup.nodes.Document docu = Jsoup.parse(docData, "", Parser.xmlParser()); 
		//docData, "", Parser.xmlParser()
		
		String id = docu.select("ID").text();
		String output = doc.deleteDoctor(id);
		
		return output;
	}
	**/
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctor(String docData)
	{
		JsonObject jsonObject = new JsonParser().parse(docData).getAsJsonObject();
		
		String id = jsonObject.get("ID").getAsString();
		
		String output = doc.deleteDoctor(id);
		
		return output;
	}
	
	@GET
	@Path("/searchDoc/{dName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String searchDoc(String docData)
	{
		JsonObject jsonObject = new JsonParser().parse(docData).getAsJsonObject();
		
		String id = jsonObject.get("dName").getAsString();
		
		String output = doc.searchDoctors(id);
		
		return output;
	}
	
}
