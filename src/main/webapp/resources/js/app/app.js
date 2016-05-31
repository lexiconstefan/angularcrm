/**
 * 
 */

function testPost() {
	
	var p = getFormDivValues('contact_redigera');
	var request = {
	  request :{
	  	id : p.id,
			firstName : p.firstName,
			lastName : p.lastName,
			title : p.title,
			comments : p.comments,
			adress : {
				country : p.country,
				county : p.county,
				adress : p.adress,
				municipality : p.municipality,
				zip : p.zip
			}
	  }
	}
	 
	$.ajax({
	 type: "POST",
	 url: "crm/contacts/edit",
	  data: JSON.stringify(request),
	  contentType: 'application/json;charset:utf-8',
	  contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
	 dataType : 'json',
	 success: function(data) {
	   if(data.status == 'OK') alert('Person has been added');
	   else alert('Failed adding person: ' + data.status + ', ' + data.errorMessage);
	 }
	});
	
	var p = getFormDivValues('contact_redigera');
	var request = {
		id : p.id,
		firstName : p.firstName,
		lastName : p.lastName,
		title : p.title,
		comments : p.comments,
		adress : {
			country : p.country,
			county : p.county,
			adress : p.adress,
			municipality : p.municipality,
			zip : p.zip
		}

	};

	ajaxrequest({
		method : 'POST',
		url : 'crm/contacts/edit',
		params : {
			request : JSON.stringify(p)
		}
	}, function(res) {

		console.log(res);
	});
	ajaxrequest({
		method : 'POST',
		url : 'crm/contacts/edit',
		params : {
			firstName : 'Stefan',
			lastName : 'Fest',
			title : 'title 1',
			comments : 'comments 1',
			id : 3
		}
	}, function(res) {

		console.log(res);
	});
	ajaxrequest({
		method : 'POST',
		url : 'crm/contacts/edit',
		params : {
			firstName : 'Stefan',
			lastName : 'Fest',
			title : 'title 1',
			comments : 'comments 1',
			adress : {
				zip : '29538',
				municipality : 'bromölla',
				adress : 'Granstigen 6',
				county : 'skåne',
				coyntry : 'se'
			}
		}
	}, function(res) {

		console.log(res);
	});
};

// ajax request with success and failure function
window.ajaxrequest = function(config, successfunc, failfunc) {
	var url, method, params, strParams = '';
	if (config && config.url) {
		url = config.url;
		if (config.method) {
			method = config.method;
		} else {
			method = 'GET';
		}
		if (config.params) {
			params = config.params;

			var i = 0;
			for ( var k in params) {
				if (params[k]) {
					if (i === 0) {
						strParams += k + '=' + params[k];
					} else {
						strParams += '&' + k + '=' + params[k];
					}

				}
				i++;
			}

		}

		var xmlhttp;
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {
			// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			var fn = successfunc;
			if (xmlhttp.readyState == XMLHttpRequest.DONE) {
				if (xmlhttp.status == 200) {
					fn(xmlhttp);
				} else if (xmlhttp.status == 400) {
					alert('There was an error 400')
				} else {
					alert('something else other than 200 was returned')
				}
			}
		}
		xmlhttp.open(method, url, true);
		if (method === 'POST') {
			//xmlhttp.setRequestHeader("Content-type","Content-type=application/json");
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded;");
			xmlhttp.send(strParams);
		} else {
			xmlhttp.send();
		}

	}
};
window.getFormDivValues = function(div) {

	var params = {};
	var conDiv = document.getElementById(div || ' ');
	if (conDiv) {

		var firstname, lastname, title;

		var eArray = conDiv.getElementsByClassName('form-control');
		for (var i = 0; i < eArray.length; i++) {
			if (eArray[i].name) {
				params[eArray[i].name] = eArray[i].value;
			}
		}
	}
	return params
};

var myCrmApp = angular.module('routingCrmApp', [ 'ngRoute' ]);
myCrmApp
		.config([
				'$routeProvider',
				function($routeProvider) {
					$routeProvider
							.when('/crm/calender', {
								templateUrl : 'crm/calender',
								controller : 'calenderCtrl'
							})
							.when('/crm/contact', {
								templateUrl : 'crm/contact',
								controller : 'contactCtrl'
							})
							.when(
									'/crm/contact/list',
									{
										templateUrl : 'crm/contact/list',
										controller : 'contactCtrl',
										resolve : {
											async : [
													'ContactService',
													function(ContactService) {
														return ContactService
																.getAllContacts();
													} ]
										}
									})
							.when('/crm/contact', {
								templateUrl : 'crm/contact',
								controller : 'contactCtrl'
							})
							.when(
									'/crm/contact/redigera/:id',
									{
										templateUrl : 'crm/contact/redigera',
										controller : 'contactEditCtrl',
										resolve : {
											async : [
													'ContactService',
													'$route',
													function(ContactService,
															$route) {
														return ContactService
																.fetchEditItem($route.current.params.id);
													} ]
										}
									}).when('/printers', {
								template : 'This is the printers Route'
							}).otherwise({
								redirectTo : '/'
							});
				} ]);