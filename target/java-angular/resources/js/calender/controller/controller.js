/**
 * 
 */
myCrmApp
		.controller(
				'calenderCtrl',
				function($scope, $http, CalenderService) {
					var monthNames = [ "January", "February", "March", "April",
							"May", "June", "July", "August", "September",
							"October", "November", "December" ];
					var days = [ 'Sunday', 'Monday', 'Tuesday', 'Wednesday',
							'Thursday', 'Friday', 'Saturday' ];
					var daysShort = [ 'Sön', 'Mån', 'Tis', 'Ons', 'Tors',
							'Fre', 'Lör' ];
					var weekArray = [];
					var activity_array = [];
					var date = new Date($.now());
					var table = '';
					var colCell = '';
					var startdate = '';
					var enddate = '';
					$scope.tbcalmonthshow = true;
					$scope.tbcalweekshow = false;
					$scope.tbcaldayshow = false;
					$scope.contacts = [ {
						firstName : 'Välj kontaktperson...',
						id : -1
					} ];
					$scope.activity = {};
					setMonthTable();
					setWeekTable();
					setDate();
					setStartAndEndate();
					if(activity_array.length === 0){
						CalenderService.getAllActivitysBetweenDates(startdate,
								enddate).then(function(response) {
									activity_array = response.data;
									setActitvitys(response.data);
								});
					}
					$scope.getToday = function() {
						date = new Date($.now());
						setDate();

						setMonthTable();

					};

					$scope.submit = function() {
						var test;
						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;'
							}
						};
						var data = $.param({
							activity : $scope.activity.activity,
							description : $scope.activity.description,
							contact_id : $scope.activity.contact.id,
							activity_date : $scope.activity.activity_date
						});

						$http
								.post(
										'http://localhost:8080/java-angular/crm/activity/new',
										data, config)
								.then(
										function(response) {
											console.log(response);
											colCell.target.innerHTML += '<span>'
													+ $scope.activity.activity
													+ '</span>';
											$scope.closePopup();
										});
					};
					$scope.initContactSelect = function() {
						if ($scope.contacts.length === 1) {
							CalenderService.getAllContactsName().then(
									function(response) {
										var data = response.data;
										for (var i = 0; i < data.length; i++) {
											$scope.contacts.push(data[i]);
										}
									});
						}
					};
					$scope.increaseDate = function() {
						if ($scope.tbcalmonthshow) {
							date.setMonth(date.getMonth() + 1);
							setDate();
							setMonthTable();
						} else if ($scope.tbcalweekshow) {
							date.setDate(date.getDate() + 7);
							setWeekTable();
							setDate();
						}

					};
					$scope.decreaseDate = function() {
						if ($scope.tbcalmonthshow) {
							date.setMonth(date.getMonth() - 1);
							setDate();
							setMonthTable();
						} else if ($scope.tbcalweekshow) {
							date.setDate(date.getDate() - 7);
							setWeekTable();
							setDate();
						}
					};
					$scope.closePopup = function() {
						document.getElementById('eventDiv').style.display = 'none';
					};
					$scope.setCalender = function(calender) {
						switch (calender) {
						case 'month':
							$scope.tbcalmonthshow = true;
							$scope.tbcalweekshow = false;
							$scope.tbcaldayshow = false;
							break;
						case 'day':
							$scope.tbcalmonthshow = false;
							$scope.tbcalweekshow = false;
							$scope.tbcaldayshow = true;
							break;
						case 'week':
							$scope.tbcalmonthshow = false;
							$scope.tbcalweekshow = true;
							$scope.tbcaldayshow = false;
							break;
						default:
							break;
						}
						setDate();
					};
					function setStartAndEndate() {
						if (table) {
							startdate = table.rows[1].cells[0].id;
							enddate = table.rows[5].cells[6].id;
						}

					}
					;
					function setActitvitys(dataArray){
						dataArray.forEach(function(obj){
							var date = obj.activity_date;
							var id = date[0]+'-'+date[1]+'-'+date[2];
							var e = new Elem();
							var span = e.createElement({
								element : 'span',
								id : obj.id,
								text : obj.activity,
								className : 'activity-span'
							});
							span.onclick = function(span){
								console.log(span);
							};
							document.getElementById(id).appendChild(span);
						});
					};
					function getDateFormat(date) {

						return date.getDate() + '/' + (date.getMonth() + 1)
								+ '/' + date.getFullYear();
					}
					;
					
					function createCalActivity(cell) {
						var popupDiv = document.getElementById('eventDiv');
						var year = date.getFullYear();
						var month = cell.target.month;
						var d = new Date(year, month, cell.target.day);
						colCell = cell;
						$scope.activity.activity_date = getDateFormat(d);
						popupDiv.getElementsByTagName('label')[0].innerHTML = 'När : '
								+ days[d.getDay()]
								+ ' den '
								+ cell.target.day
								+ ' ' + monthNames[month];
						popupDiv.style.left = (cell.clientX - 15) + 'px';
						popupDiv.style.top = (cell.clientY - 15) + 'px';
						popupDiv.style.display = 'block';
						// alert(cell.target.value);
					}
					;
					function setDate() {

						var monthName = monthNames[date.getMonth()];
						var yearDate = new Date(date);
						yearDate.setDate(date.getDate() + (6 - date.getDay()));
						var year = yearDate.getFullYear()
						if ($scope.tbcalmonthshow) {
							$scope.date = monthName + ' ' + year;
						} else if ($scope.tbcalweekshow) {
							var m = weekArray[6].split('/')[0];
							if (!isNaN(!m)) {
								monthName = monthNames[(parseInt(m) - 1)];
							}
							$scope.date = days[0] + ' den ' + weekArray[0]
									+ ' - ' + weekArray[6] + ' ' + monthName
									+ ' ' + year;
						} else if ($scope.tbcaldayshow) {

						}

					}
					function getWeekFirstDay(d) {
						d = new Date(d);
						var day = d.getDay(), diff = d.getDate() - day;// +
						// (day
						// == 0
						// ?
						// -6:1);
						// // adjust when day is
						// sunday
						return new Date(d.setDate(diff));
					}
					function daysInMonth(month, year) {
						return new Date(year, month, 0).getDate();
					}
					function getFirstDayINMonth() {
						var d = new Date(date);
						d.setDate(1);
						return d.getDay();
					}
					function createWeekArray() {

						var weekArray = [];
						var deacreseMonth = getWeekFirstDay(date).getMonth() < date
								.getMonth();
						var weekFirstDay = getWeekFirstDay(date).getDate();
						var nbrDaysINMonth = 0;

						var month;
						if (deacreseMonth) {
							month = getWeekFirstDay(date).getMonth() + 1;
							nbrDaysINMonth = daysInMonth(month, date
									.getFullYear())
						} else {
							month = date.getMonth() + 1;
							nbrDaysINMonth = daysInMonth(month, date
									.getFullYear());

						}

						// First day Sunday
						weekArray[0] = month + '/' + weekFirstDay;
						var day = 0;
						for (var i = 1; i < 7; i++) {
							if (deacreseMonth
									&& ((weekFirstDay + day) - nbrDaysINMonth) === 0) {
								month = date.getMonth() === 12 ? 1 : date
										.getMonth() + 1;
								weekFirstDay = 0
								day = 0;
							}
							if (nbrDaysINMonth <= (weekFirstDay + day)) {
								month = month === 12 ? 1 : month++;
								day = 0;
								weekFirstDay = 0;
							}
							day++;
							weekArray[i] = month + '/' + (weekFirstDay + day);

						}
						return weekArray;

					}
					function addDaysToTableRow(row, daysArray) {

						for (var i = 0; i < daysArray.length; i++) {
							row.cells[i + 1].innerHTML = daysShort[i] + ' '
									+ daysArray[i];
						}
					}
					function setWeekTable() {
						var table = document.getElementById("tbcalender_week");
						if (!table) {
							return;
						}
						// iterate through rows
						// rows would be accessed using the "row" variable
						// assigned in the
						// for loop
						weekArray = createWeekArray();
						addDaysToTableRow(table.rows[0], weekArray);
						var nbrDaysINMonth = daysInMonth(date.getMonth() + 1,
								date.getFullYear());

						for (var i = 0, row; row = table.rows[i]; i++) {

							if (i > 0) {
								row.cells[0].innerHTML = i < 11 ? '0' + (i - 1)
										+ ':00' : (i - 1) + ':00';
							}
							var day = 0;
							var weekFirstDay = getWeekFirstDay(date).getDate();
							for (var j = 0, col; col = row.cells[j]; j++) {

								if (j > 0 && i > 0) {
									col.innerHTML = ' ';
									if ((weekFirstDay + day) <= nbrDaysINMonth) {
										col.value = (weekFirstDay + day);
										col.month = date.getMonth();
									} else {
										col.value = 1;
										weekFirstDay = 1
										day = 0;
										col.month = (date.getMonth() + 1);
									}

									col.time = row.cells[0].innerHTML;
									day++;
									col.onclick = function(col) {
										createCalActivity(col)
									};
								}

							}

						}
					}
					function getMonthBeforeLastDays(nbrofdays) {
						var nbrDaysINMonth = daysInMonth(date.getMonth(), date
								.getFullYear());
						var arr = [];
						for (var i = 0; i < nbrofdays; i++) {
							arr.push(nbrDaysINMonth);
							nbrDaysINMonth--;
						}
						return arr;
					}
					;
					function setTableFirstRow(nbrofdays) {
						var dayArray = getMonthBeforeLastDays(nbrofdays);
						var index = dayArray.length - 1;
						var row = table.rows[1];
						var month = (date.getMonth() - 1);
						for (var i = 0; i < dayArray.length; i++) {
							var value = dayArray[index];
							var col = row.cells[i];
							var tdDate = new Date(date.getFullYear(), (date
									.getMonth() - 1), value);
							col.id = getDateFormat(tdDate);
							col.innerHTML = value;
							col.day = value;
							col.month = month;
							col.onclick = function(col) {
								createCalActivity(col)
							};
							index--;
						}
					}
					;
					
					function setTDDateID(col, day) {
						var tdDate = new Date(date.getFullYear(), date
								.getMonth(), day);
						col.id = tdDate.getFullYear() + '-' + (tdDate.getMonth()+1)+'-'+tdDate.getDate();
					}
					;
					function setMonthTable() {
						table = document.getElementById("tbcalender_month");
						if (!table) {
							return;

						}
						var e = new Elem();
						var nbrDaysINMonth = daysInMonth(date.getMonth() + 1,
								date.getFullYear());
						var tableDay = 1;
						var firstDayINMonth = getFirstDayINMonth(firstDayINMonth);
						var month = date.getMonth();
						for (var i = 0, row; row = table.rows[i]; i++) {
							// iterate through rows
							// rows would be accessed using the "row" variable
							// assigned in the
							// for loop
							if (i > 0) {
								for (var j = 0, col; col = row.cells[j]; j++) {
									// iterate through columns
									// columns would be accessed using the "col"
									// variable
									// assigned in the for loop
									var span = e.createElement({
										element : 'span',
										text : (j + 1)
									});
									setTDDateID(col, (j + 1));
									col.innerHTML = (j + 1);
									col.day = (j + 1);
									col.month = month;
									col.appendChild(span);
									span.onclick = function(col) {
										createCalActivity(col)
									};

									if (tableDay > nbrDaysINMonth) {
										tableDay = 1;
									}
									if (j >= firstDayINMonth) {
										setTDDateID(col, tableDay);
										col.innerHTML = tableDay;
										col.day = tableDay;
										var span = e.createElement({
											element : 'span',
											text : tableDay
										});
										col.appendChild(span);
										span.onclick = function(col) {
											createCalActivity(col)
										};
										tableDay++;
									} else if (tableDay > 1) {
										setTDDateID(col, tableDay);
										col.innerHTML = tableDay;
										col.day = tableDay;
										var span = e.createElement({
											element : 'span',
											text : tableDay
										});
										col.appendChild(span);
										span.onclick = function(col) {
											createCalActivity(col)
										};
										tableDay++;
									}

								}
							}
						}
						setTableFirstRow(firstDayINMonth);
					}

				});