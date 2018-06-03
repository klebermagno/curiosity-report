//earth_date=2015-09-30
function getMarsReport() {

	var earthDate = $.urlParam('earth_date') ;

	$.ajax({
		method : "GET",
		traditional: true,
		url : "http://localhost:8080/api/mars/reportByEarthDate",
		data: jQuery.param({ earthdate: earthDate}) 

	}).done(
			function(data) {
				marsStatus = data;
				document.getElementById("weather-atmo-opacity").textContent = marsStatus.weatherReport.atmo_opacity;
				document.getElementById("weather-max-temp").textContent = marsStatus.weatherReport.max_temp;
				document.getElementById("weather-min-temp").textContent = marsStatus.weatherReport.min_temp;
				document.getElementById("weather-wind-speed").textContent = marsStatus.weatherReport.wind_speed;
				document.getElementById("weather-terrestrial-date").textContent = marsStatus.weatherReport.earthTime;
				document.getElementById("mars-image").textContent = marsStatus.photoElement.img_src;

			}).fail(
					function(data) {
						alert("Could not retrieve Mars report." + data);
					});

}

$.urlParam = function(name){
	var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	if(results != null)
	return results[1] || 0;
}

$(document).ready(function() {
	
	getMarsReport();

});
