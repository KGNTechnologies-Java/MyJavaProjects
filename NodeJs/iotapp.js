var http = require('https');

var host = 'iotmmsp1942294513trial.hanatrial.ondemand.com';
var device = '5a33967d-0c46-4c4c-9246-b177084a0bd6';
var oAuthToken = 'a58667d66fa974b86d1c1e3eac38e40';
var messageType = 'bab4c86103a42a5f0335';

var path = '/com.sap.iotservices.mms/v1/api/http/data/';

var options = {
	host: host,
	port: 443,
	path: path + device,
	agent: false,
	headers: {
		'Authorization': 'Bearer ' + oAuthToken,
		'Content-Type': 'application/json;charset=utf-8'
	},
	method: 'POST'     
};
options.agent = new http.Agent(options);
callback = function(response) {
	var body = '';
	response.on('data', function (data) {
		body += data;
		console.log(body);
	});
	response.on('end', function () {
		console.log("From MMS:", response.statusCode, body);
	});
	response.on('error', function(e) {
		console.error(e);
	});
}

var req = http.request(options, callback);

req.on('error', function(e) {
	console.error(e);
});

req.shouldKeepAlive = true;

var jsonData = {
	"mode": "sync",
	"messageType": messageType,
	"messages": [{
		"TIMESTAMP":"2017-05-08T16:15:57+00:00",
		"SENSOR1": "200",
		"SENSOR2": "230"
		
		}]
}
var strData = JSON.stringify(jsonData);

req.write(strData);
req.end();