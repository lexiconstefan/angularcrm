/**
 * 
 */
myCrmApp.factory('ContactService', [ '$http', '$q', function($http, $q) {
    var contacts = {};
    return {

        getAllContacts : function() {
            return $http.get('http://localhost:8080/java-angular/crm/contacts/list').then(function(response) {
                contacts.data = response.data;
                return response.data;
            }, function(errResponse) {
                console.error('Error while fetching Items');
                return $q.reject(errResponse);
            });
        },
        fetchEditItem: function(id) {
            return $http.get('http://localhost:8080/java-angular/crm/contacts/redigera/'+id)
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while fetching specific Item');
                                return $q.reject(errResponse);
                            }
                    );
        },
        getAllContactsData : function(){
            return test;
        }
    };

} ]);