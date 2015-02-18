

/**
 * After the client library has loaded, this init() function is called.
 * The init() function loads the admin,survey API.
 */

function init() {
	
	// pass the root path when loading  API
	// otherwise calls to execute the API run into a problem
	
	// rootpath will evaulate to either of these, depending on where the app is running:


	var rootpath = "//" + window.location.host + "/_ah/api";
	
	// Load the admin,survey API
	// If loading completes successfully, call loadCallback function
	gapi.client.load('admin', 'v1', loadCallback, rootpath);
	gapi.client.load('survey', 'v2', loadCallback, rootpath);
}

/*
 * When admin,survey API has loaded, this callback is called.
 * 
 * We need to wait until the admin,survey API has loaded to
 * enable the actions for the buttons in index.html,
 * because the buttons call functions in the admin,survey API
 */
function loadCallback () {	
	// Enable the button actions
	enableButtons ();
}

function enableButtons () {


	btn = document.getElementById("save_admin_profile");
	btn.onclick= function(){saveAdminProfile();};
	btn.value="Save Admin Profile";

	
	btn = document.getElementById("input_greet_generically");
	btn.onclick= function(){opennewPage();};
	btn.value="open new page";
}
function opennewPage () {
	var customURL = '/partials/adminprofile.html';
	window.location.href = customURL;
	window.location.assign(customURL);

	// Current page won't get saved in the history:
	window.location.replace(customURL); 

}

function saveAdminProfile () {
	var name = document.getElementById("name").value;
	var userName = document.getElementById("userName").value;
	var phoneNo = document.getElementById("phoneNo").value;
	var password = document.getElementById("password").value;
	var rePassword = document.getElementById("rePassword").value;

	var request = gapi.client.admin.saveAdminProfile({'name' : name, 'userName' : userName,'phoneNo' : phoneNo, 
		'password' : password, 'rePassword' : rePassword});
	request.execute();
}

function print (messsage) {
	  var element = document.createElement('div');
	  element.classList.add('row');
	  element.innerHTML = message;
	  document.getElementById('outputLog').appendChild(element);
	};

// Process the JSON response
// In this case, just show an alert dialog box
// displaying the value of the message field in the response
function checkFirstTimee (response) {
	/*var customURL = 'https://www.facebook.com/';
	if (response.message.equals("true")) {
		customURL = 'https://www.google.co.in/';
	}
	
	window.location.href = customURL;
	window.location.assign(customURL);
	// Current page won't get saved in the history:
	window.location.replace(customURL); */
	alert(response.message)
}


