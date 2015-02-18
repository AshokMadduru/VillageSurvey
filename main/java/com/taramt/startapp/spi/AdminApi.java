package com.taramt.startapp.spi;

import static com.taramt.startapp.Services.OfyService.ofy;

import java.math.BigInteger;
import java.net.PasswordAuthentication;
import java.security.SecureRandom;
import java.util.logging.Logger;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Nullable;
import com.googlecode.objectify.cmd.Query;
import com.taramt.startapp.Constants;
import com.taramt.startapp.Services.HelloClass;
import com.taramt.startapp.domain.AdminProfile;
import com.taramt.startapp.domain.SarpanchProfile;
import com.taramt.startapp.forms.AdminProfileForm;

@Api(
		name = "admin",
		version = "v1",
		clientIds = { Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
				Constants.API_EXPLORER_CLIENT_ID},
				audiences = {Constants.ANDROID_AUDIENCE},
				description = "Admin profile details who creats and maintanace surveys"
		)
public class AdminApi {
	private static final Logger LOG = Logger.getLogger(SurveyAPI.class.getName());
	
	@ApiMethod(name = "saveAdminProfile", httpMethod = "post")
	public AdminProfile saveAdminProfile( @Named ("name") String name, @Named ("userName") String userName,
			@Named ("phoneNo") String phoneNo, @Named ("password") String password,@Named ("rePassword") String rePassword) {
		
		AdminProfile adminProfile = new AdminProfile(userName,name,userName,
				phoneNo, password);
		ofy().save().entity(adminProfile).now();
		return adminProfile;
	}
	
		@ApiMethod(name = "getAdminProfile", httpMethod = "post")
		public AdminProfile getAdminProfile(@Named ("userName") String userName, @Named ("password") String password) {
			Query<AdminProfile> query = ofy().load().type(AdminProfile.class);
			query = query.filter("userName = ",userName);
			query = query.filter("password = ", password);
			query = query.order("userName");
			AdminProfile adminProfile = query.list().get(0);
			return adminProfile;
			//    return result;
		}
		@ApiMethod(name = "checkFirstTime", path = "checkFirstTime", httpMethod = "post")
		public HelloClass checkFirstTime() {
			Query<AdminProfile> query = ofy().load().type(AdminProfile.class);
			if (query.list().size() == 0) {
				return new HelloClass("true");
			}
			return new HelloClass("false");
			//    return result;
		}
}
