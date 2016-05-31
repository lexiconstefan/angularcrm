/**
 * 
 */
myCrmApp.factory('CalenderService', [ '$http', '$q', function($http, $q) {
	
	return{
		getAllContactsName : function(){
			   return $http.get('http://localhost:8080/java-angular/crm/contacts/namelist');
		},
		saveActivity : function(){
			return $http.post('http://localhost:8080/java-angular/crm/activity/new');
		},
		getAllActivitysBetweenDates : function(startdate, enddate){
			return $http.get('http://localhost:8080/java-angular/crm/activity/list',{
				params : {
					startdate : startdate,
					enddate : enddate
				}
			});
			
		}
	}
}]);