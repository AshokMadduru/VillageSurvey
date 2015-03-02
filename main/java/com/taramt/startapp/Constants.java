package com.taramt.startapp;

import com.google.api.server.spi.Constant;

/**
 * Contains the client IDs and scopes for allowed clients consuming your API.
 */
public class Constants {
	  public static final String WEB_CLIENT_ID = "1071410999509-l4fmrdueau693vd93reohssr07vflecm.apps.googleusercontent.com";
	  public static final String ANDROID_CLIENT_ID = "1071410999509-d5ts5bsgrga9a598dvr691fervpub13h.apps.googleusercontent.com";
	  public static final String IOS_CLIENT_ID = "replace this with your iOS client ID";
	  public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;
	  public static final String API_EXPLORER_CLIENT_ID = Constant.API_EXPLORER_CLIENT_ID;
	  public static final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
}
