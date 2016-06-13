/**
 * 
 */
myCrmApp.factory('NewContactService', [ '$http', '$q', function($http, $q) {
	return{
		newContact:function(contact){
			return  $http.post('http://localhost:8080/java-angular/crm/contacts/new',contact);
		}
	};
}]);