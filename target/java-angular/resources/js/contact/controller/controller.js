/**
 * 
 */
myCrmApp.controller('contactCtrl', ['$scope','ContactService',function($scope, ContactService) {
			
			if ($scope.$resolve && $scope.$resolve.async) {
				//if length list of contacts
				if($scope.$resolve.async.length){
					$scope.contacts = $scope.$resolve.async;
				}else{ // edit contact
					$scope.contact = $scope.$resolve.async;
				}

			}

			function closeAdress(me) {
				var popupDiv = document.getElementById('popupadress');
				if (popupDiv) {
					popupDiv.parentElement.removeChild(popupDiv);
				}
			};
			
			function removeFromDom(domObject) {
				if (domObject) {
					domObject.parentElement.removeChild(domObject);
				}
			};
		
			$scope.status = [{
		        value: 1, display: 'Aktiv'
		    }, {
		        value: 2,
		        display:'Slutat'
		    }, {
		        value: 3,
		        display:'Annat'
		    }];
			
			$scope.submitContact=function()
			{

				ContactService.editContact($scope.contact);
			}
			$scope.showAdress = function(event, adress) {
				var t = adress;
				var e = new Elem();
				// container
				var parentDiv = document.getElementById('contact_list_div');

				var popupDiv = e.createElement({
					element : 'div',
					id : 'popupadress',
					className : 'popup-div',
					style : 'left:' + event.clientX + 'px;top:' + event.clientY
							+ 'px'
				});

				// close image
				var closeImg = e.createElement({
					element : 'img',
					src : './resources/images/Shutdown-52.png',
					className : 'close',
					style : 'height:16px;width:16px'
				});
				closeImg.onclick = function(popupDiv) {
					closeAdress(popupDiv);
				};
				var formDiv = e.createElement({
					element : 'div',
					className : 'form-group'
				});
				formDiv.appendChild(closeImg);
				popupDiv.appendChild(formDiv);

				// Country
				formDiv = e.createElement({
					element : 'div',
					className : 'form-group'
				});

				var label = e.createElement({
					element : 'label',
					text : 'Land'
				});
				var input = e.createElement({
					element : 'input',
					type : 'text',
					className : 'form-control',
					readOnly : true,
					value : adress.country || ''
				});

				formDiv.appendChild(label);
				formDiv.appendChild(input);

				popupDiv.appendChild(formDiv);

				// County
				formDiv = e.createElement({
					element : 'div',
					className : 'form-group'
				});

				var label = e.createElement({
					element : 'label',
					text : 'Län'
				});
				var input = e.createElement({
					element : 'input',
					type : 'text',
					className : 'form-control',
					readOnly : true,
					value : adress.county || ''
				});

				formDiv.appendChild(label);
				formDiv.appendChild(input);

				popupDiv.appendChild(formDiv);

				// municipality
				formDiv = e.createElement({
					element : 'div',
					className : 'form-group'
				});

				var label = e.createElement({
					element : 'label',
					text : 'Kommun'
				});
				var input = e.createElement({
					element : 'input',
					type : 'text',
					className : 'form-control',
					readOnly : true,
					value : adress.municipality || ''
				});

				formDiv.appendChild(label);
				formDiv.appendChild(input);

				popupDiv.appendChild(formDiv);

				// Adress
				formDiv = e.createElement({
					element : 'div',
					className : 'form-group'
				});

				var label = e.createElement({
					element : 'label',
					text : 'Adress'
				});
				var input = e.createElement({
					element : 'input',
					type : 'text',
					className : 'form-control',
					readOnly : true,
					value : adress.adress || ''
				});

				formDiv.appendChild(label);
				formDiv.appendChild(input);

				popupDiv.appendChild(formDiv);

				// postnummer
				formDiv = e.createElement({
					element : 'div',
					className : 'form-group'
				});

				var label = e.createElement({
					element : 'label',
					text : 'Postnummer'
				});
				var input = e.createElement({
					element : 'input',
					type : 'text',
					className : 'form-control',
					readOnly : true,
					value : adress.zip || ''
				});
				formDiv.appendChild(label);
				formDiv.appendChild(input);

				popupDiv.appendChild(formDiv);

				// add to dom
				parentDiv.appendChild(popupDiv);
			};
			$scope.addPhone = function() {
				var e = new Elem();
				var phoneContainer = document.getElementById('cophdiv');
				var formDiv = e.createElement({
					element : 'div',
					className : 'form-group form-inline'
				});

				var arrOptions = [ 'Hem', 'Arbete', 'Mobil' ];
				var arrOptionsValue = [ 'home', 'work', 'mobil' ];
				var selectInput = e.createElement({
					element : 'select',
					className : 'form-control',
					options : [ 'Hem', 'Arbete', 'Mobil' ],
					value : [ 'home', 'work', 'mobil' ]
				});

				var input = e.createElement({
					element : 'input',
					type : 'text',
					className : 'form-control'
				});

				var img = e.createElement({
					element : 'img',
					src : './resources/images/deletephone.png',
					style : 'height:16px;width:16px'
				});
				img.onclick = function() {
					removeFromDom(formDiv);
				}
				if (selectInput) {
					formDiv.appendChild(selectInput);
				}
				if (input) {
					formDiv.appendChild(input);
				}
				if (img) {
					formDiv.appendChild(img);
				}
				if (formDiv) {
					phoneContainer.appendChild(formDiv);
				}

			};
			$scope.addMail = function() {
				var e = new Elem();
				var mailContainer = document.getElementById('coemdiv');
				var formDiv = e.createElement({
					element : 'div',
					className : 'form-group form-inline'
				});

				var input = e.createElement({
					element : 'input',
					className : 'form-control',
				});
				var img = e.createElement({
					element : 'img',
					src : './resources/images/Delete.png',
					style : 'height:16px;width:16px'
				});

				if (input) {
					formDiv.appendChild(input);
				}
				if (img) {
					img.onclick = function() {
						removeFromDom(formDiv);
					};
					formDiv.appendChild(img);
				}
				if (formDiv) {
					mailContainer.appendChild(formDiv);
				}
			};

			$scope.editContact = function() {
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
						request : JSON.stringify(request)
					}
				}, function(res) {

					console.log(res);
				});
			};
			$scope.submit = function(ID) {
				var url, method;
				if (ID) {
					if (ID === 'divredcon') {
						method = 'POST';
						url = 'crm/contacts/edit';
					}
					var params;
					if (method === 'POST') {
						params = getFormDivValues(ID);
					}
					ajaxrequest({
						url : url,
						params : params,
						method : method

					}, function(res) {

					}, function(fail) {

					});
				}
			};

		} ]);

myCrmApp.controller('contactEditCtrl', [ '$scope', function($scope) {

	if ($scope.$resolve && $scope.$resolve.async) {
		$scope.contact = $scope.$resolve.async;
	}

} ]);