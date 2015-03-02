

/**
 * After the client library has loaded, this init() function is called.
 * The init() function loads the admin,survey API.
 */

var userName;
var password;

function init() {

	// pass the root path when loading  API
	// otherwise calls to execute the API run into a problem

	// rootpath will evaulate to either of these, depending on where the app is running:
	var rootpath = "//" + window.location.host + "/_ah/api";

	// Load the admin,survey API
	// If loading completes successfully, call loadCallback function
	gapi.client.load('admin', 'v1', checkFirstTime, rootpath);
	gapi.client.load('survey', 'v2', null, rootpath);
	console.log("apis loaded");
}

function init1() {
	var rootpath = "//" + window.location.host + "/_ah/api";

	// Load the admin,survey API
	// If loading completes successfully, call loadCallback function
	console.log("intializing");
	gapi.client.load('admin', 'v1', null, rootpath);
	gapi.client.load('survey', 'v2', null, rootpath);
	console.log("apis loaded");
}

function checkUserSession () {
	document.location.href = '/ProfileServlet';
//	var userName = '<%= Session["userName"]%>';
//	console.log(userName);
}
/*
 * When admin,survey API has loaded, this callback is called.
 * 
 * We need to wait until the admin,survey API has loaded to
 * enable the actions for the buttons in index.html,
 * because the buttons call functions in the admin,survey API
 */

function checkFirstTime () {
	var request = gapi.client.admin.checkFirstTime();
	request.execute(openPage)
}

function validateDefaultPassword () {

	var password = document.getElementById("dpassword").value;
	console.log(password);
	if (password == "password123") {
		console.log("correct");
		window.location.replace('/partials/adminprofile.jsp');
	} else {
		console.log("invalid credentials");
		showMessage("* Wrong Password", "red");
	}
}

function validateCredentials () {
	// get the profile based on username and password
	// if credentials are correct
	// create a session and use throughout the process
	// if not alert that wrong credentials
	userName = document.getElementById("userName").value;
	password = document.getElementById("password").value;
	console.log (userName +"  " + password);
	var request = gapi.client.admin.getAdminProfile({'userName' : userName,'password' : password});
	request.execute(createSession);
//	console.log(request.responseText());
}

function createSession (response) {
	if (response.error == null) {
		console.log("no error u can open LoginServlet" + userName + " " + password);
		var request=new XMLHttpRequest();
		/*  request.open("POST", "https://village-survey-trial.appspot.com/LoginServlet?userName="+userName 
				  + "& password=" + password , true);*/
		userName = response.userName;
		document.location.href = '/LoginServlet?userName='+response.userName 
		+ '&name=' + response.name;
	} else {
		console.log("invalide credentials");
	}
}
function openPage (response) {

	var customURL = '/partials/login.jsp'
		if (response.message == "true") {
			customURL = '/partials/defaultpass.jsp';
		} 
	window.location.href = customURL;
	window.location.assign(customURL);
	// Current page won't get saved in the history:
	//window.location.replace(customURL); 
	window.history.pushState("Login", "Login", customURL);
	console.log(response)
}
function createAdminProfile () {
	var name = document.getElementById("name").value;
	var userName = document.getElementById("userName").value;
	var phoneNo = document.getElementById("phoneNo").value;
	var password = document.getElementById("password").value;
	var rePassword = document.getElementById("rePassword").value;
	var address1 = document.getElementById("address1").value;
	var address2 = document.getElementById("address2").value;
	var city = document.getElementById("city").value;
	var zip = document.getElementById("zipcode").value;
	console.log("before");
	console.log("address :" + address1 + address2 + city + zip);
	if(name != "" && password != "" && userName != "" && rePassword != "" && phoneNo != "") {
	if (password == rePassword) {
		var request = gapi.client.admin.saveAdminProfile({'name' : name, 'userName' : userName,'phoneNo' : phoneNo, 
			'password' : password, 'rePassword' : rePassword, 'address1' : address1, 'address2' : address2,
			'city' : city, 'zip' : zip});
		console.log("after");
		request.execute(giveResponse);
		console.log("after execute");
	} else {
		showMessage(" * Passwords doesn't match!", "red");
	} 
	} else {
		showMessage(" * Please fill up all details " , "red")
	}

}

function showMessage(message, color) {
	var element = document.getElementById("message");
	element.innerHTML = message;
	element.style.color = color;
	element.style.fontWeight = 'bold';
	element.style.fontSize = "20px";
}
function updateAdminProfile () {
	var userNamee  = document.getElementById("userName").value;
	var phoneNo = document.getElementById("phoneNo").value;
	var password = document.getElementById("password").value;
	var rePassword = document.getElementById("rePassword").value;
	var address1 = document.getElementById("address1").value;
	var address2 = document.getElementById("address2").value;
	var city = document.getElementById("city").value;
	var zip = document.getElementById("zipcode").value;
	console.log("before");
	/*if (password != "" || phoneNo != "") {*/
	if (password == rePassword) {
	var request = gapi.client.admin.updateAdminProfile({'userName' : userNamee, 'phoneNo' : phoneNo, 
		'password' : password, 'rePassword' : rePassword, 'address1' : address1, 'address2' : address2,
		'city' : city, 'zip' : zip});

	console.log("after");

	request.execute(checkIfUpdated);
	console.log("after execute");
	} else {
		showMessage(" * Passwords doesn't match!", "red");
	}
/*	} else {
		showMessage(" Nothing to update", "green");
	}*/
}

function checkIfUpdated(response) {
	if (response.error == null) {
		showMessage("Successfully Updated", "green");
	} else {
		showMessage("* Something went Wrong " + userName, "red");
	}
}
function print (messsage) {
	var element = document.createElement('div');
	element.classList.add('row');
	element.innerHTML = message;
	document.getElementById('outputLog').appendChild(element);
};

//Process the JSON response
//In this case, just show an alert dialog box
//displaying the value of the message field in the response
function giveResponse (response) {
	if (response.error != null) {
		showMessage(" * Please fill up all details " , "red");
	} else {
		showMessage("Successfully created Admin Profile", "green");
	}
	//alert(response)
	console.log(response);
}

function logout() {
	document.location.href = '/LogoutServlet';
}
