package com.taramt.startapp.spi;

import static com.taramt.startapp.Services.OfyService.ofy;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import com.taramt.startapp.Constants;
import com.taramt.startapp.domain.SarpanchProfile;

/**
 * Add your first API methods in this class, or you may create another class. In that case, please
 * update your web.xml accordingly.
 **/

@Api(
		name = "survey",
		version = "v2",
		clientIds = { Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
				Constants.API_EXPLORER_CLIENT_ID},
				audiences = {Constants.ANDROID_AUDIENCE},
				description = "Survey the village Sarpanch about the village"
		)
public class SurveyAPI {

	private static final Logger LOG = Logger.getLogger(SurveyAPI.class.getName());

	@ApiMethod(name = "savesarpanchprofile", httpMethod = "post")
	public SarpanchProfile saveSarpanchProfile() {
		SarpanchProfile sarpanchProfile = new SarpanchProfile("niranjanann12345",
				"9676067709","Bhaskar","password", "Uyyuru", "Karnool", "Karnool", "AndhraPradesh");
		ofy().save().entity(sarpanchProfile).now();
		return sarpanchProfile;
	}

	@ApiMethod(name = "getsarpanchprofile", httpMethod = "post")
	public SarpanchProfile getSarpanchProfile() {
		Query<SarpanchProfile> query = ofy().load().type(SarpanchProfile.class);
		query = query.filter("password = ","1234");
		query = query.filter("Name = ", "Niranjan");
		query = query.order("Name");
		SarpanchProfile sarpanchProfile = query.list().get(0);
		return sarpanchProfile;
		//    return result;
	}



/*	 public String createuserId() {
		  SecureRandom random = new SecureRandom();
		  return new BigInteger(130, random).toString(32);
	 }*/
}
