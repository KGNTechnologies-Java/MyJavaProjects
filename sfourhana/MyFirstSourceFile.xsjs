//var jsondata = $.request.parameters.get('inputData[0][MATNR]');
var jsondatalength = $.request.parameters.get('jsonDataLength');
var record = [];

var output = {};
output.data = [];
var conn = $.db.getConnection();
conn.prepareStatement("SET SCHEMA \"NETWORKDB\"").execute();
var stDL = conn.prepareStatement("Delete from HANAMARATBL");
stDL.execute();
conn.commit();
for(var k=0; k<jsondatalength; ++k){
var MATNR = $.request.parameters.get('results['+k+'][Matnr]');
var MBRSH = $.request.parameters.get('results['+k+'][Mbrsh]');
var MATKL = $.request.parameters.get('results['+k+'][Matkl]');
var MTART = $.request.parameters.get('results['+k+'][Mtart]');
var AENAM = $.request.parameters.get('results['+k+'][Aenam]');
var st = conn.prepareStatement("INSERT INTO \"HANAMARATBL\" values(?,?,?,?,?)");
st.setString(1,MATNR);
st.setString(2,MBRSH);
st.setString(3,MATKL);
st.setString(4,MTART);
st.setString(5,AENAM);

st.execute();
conn.commit();

record.push(MATNR);
record.push(MBRSH);
record.push(MATKL);
record.push(MTART);
record.push(AENAM);

output.data.push(record);

 
}
conn.close();
$.response.contentType = "text/json";

$.response.setBody(JSON.stringify(output));
