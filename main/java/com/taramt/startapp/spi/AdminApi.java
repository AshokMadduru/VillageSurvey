package com.taramt.startapp.spi;

import static com.taramt.startapp.Services.OfyService.ofy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonMethod;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ObjectMapper;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import com.taramt.startapp.Constants;
import com.taramt.startapp.Services.HelloClass;
import com.taramt.startapp.domain.AdminProfile;

@Api(
		name = "admin",
		version = "v1",
		clientIds = { Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
				Constants.API_EXPLORER_CLIENT_ID},
		audiences = {Constants.ANDROID_AUDIENCE},
		description = "Admin profile details who creats and maintanace surveys"
		)
public class AdminApi implements Serializable{
	private static final Logger LOG = Logger.getLogger(SurveyAPI.class.getName());

	@ApiMethod(name = "saveAdminProfile", path = "saveAdminProfile", httpMethod = "post")
	public AdminProfile saveAdminProfile( @Named ("name") String name, @Named ("userName") String userName,
			@Named ("phoneNo") String phoneNo, @Named ("password") String password,
			@Named ("rePassword") String rePassword, @Named ("address1") String address1,
			@Named ("address2") String address2, @Named ("city") String city,
			@Named ("zip") String zip) {
		if (password.equals(rePassword)) {
			AdminProfile adminProfile = new AdminProfile(userName,name,userName,
					phoneNo, password, address1, address2, city, zip);
			ofy().save().entity(adminProfile).now();
			return adminProfile;
		}

		return null;
	}

	@ApiMethod(name = "updateAdminProfile", path = "updateAdminProfile", httpMethod = "post")
	public AdminProfile updateAdminProfile(	@Named ("userName") String userId, 
			@Nullable @Named ("phoneNo") String phoneNo,@Nullable @Named ("password") String password,
			@Nullable @Named ("rePassword") String rePassword, @Named ("address1") String address1,
			@Named ("address2") String address2, @Named ("city") String city,
			@Named ("zip") String zip){

		AdminProfile adminProfile 	=  ofy().load().key(Key.create(AdminProfile.class, userId)).now();
		adminProfile.update(phoneNo, password, rePassword, address1, address2, city, zip);
		ofy().save().entity(adminProfile).now();

		return adminProfile;
	}

	@ApiMethod(name = "getAdminProfile",path = "getAdminProfile", httpMethod = "post")
	public AdminProfile getAdminProfile(@Named ("userName") String userName, @Named ("password") String password) {
		Query<AdminProfile> query = ofy().load().type(AdminProfile.class);
		query = query.filter("userName = ",userName);
		query = query.filter("password = ", password);
		query = query.order("userName");
		AdminProfile adminProfile = query.list().get(0);
		return adminProfile;
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
	/*	@ApiMethod(name = "checkSession", path = "checkSession", httpMethod = "post")
		public HelloClass checkSession() {
			HttpServletRequest request = this.getThreadLocalRequest();

			HttpSession session = request.getSession();

		//	HttpServletRequest req = getThreadLocalRequest();
			HttpSession session = this.getThreadLocalRequest().getSession();
			String name = (String) session.getAttribute("name");
			return new HelloClass(name);
		}*/
	@ApiMethod(name = "setUser", path = "setUser", httpMethod = "post")
	public HelloClass setUser( HttpServletRequest servletReq) {
		ObjectMapper myObjectMapper = new ObjectMapper();
		myObjectMapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
		HttpSession session = servletReq.getSession();
		session.setAttribute("userName", "Dummy");
	//	List<String> userName = new ArrayList<String>();
		

		return new HelloClass((String)session.getAttribute("userName"));
	}
	@ApiMethod(name = "getUser", path = "getUser", httpMethod = "post")
	public List<String> getUser( HttpServletRequest servletReq) {
		ObjectMapper myObjectMapper = new ObjectMapper();
		myObjectMapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
		HttpSession session = servletReq.getSession(false);
		List<String> userName = new ArrayList<String>();
		if(session == null) {
			userName.add("no UserName");
		} else {
			userName.add("yes userName " + session.getAttributeNames().hasMoreElements());
			userName.add((String)session.getAttribute("userName"));
		}

		return userName;
	}
}
