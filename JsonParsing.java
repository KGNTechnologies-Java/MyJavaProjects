package com.kgn;
/* json-simple-1.1.jar file required to execute below JWT Parser*/
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParsing {

	public static void main(String[] args) throws ParseException, Exception {
		JsonParsing jp = new JsonParsing();
		String jwt = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiI0ZDFmYjk1Mi0zOWMyLTQ1NGYtYjNkNy1hNDA4NGYxNjFmMGIiLCJzdWIiOiI1NzZiY2Y4NC0zNmZkLTRmYjItYTUyNS1lYmVkYjg5MjRiZDAiLCJzY29wZSI6WyJTcHJpbmdNVkNTZWN1cml0eUFwcC1DNTI1MTU1NS5VcGRhdGUiLCJvcGVuaWQiLCJTcHJpbmdNVkNTZWN1cml0eUFwcC1DNTI1MTU1NS5EaXNwbGF5Il0sImNsaWVudF9pZCI6InNiLVNwcmluZ01WQ1NlY3VyaXR5QXBwLUM1MjUxNTU1IiwiY2lkIjoic2ItU3ByaW5nTVZDU2VjdXJpdHlBcHAtQzUyNTE1NTUiLCJhenAiOiJzYi1TcHJpbmdNVkNTZWN1cml0eUFwcC1DNTI1MTU1NSIsImdyYW50X3R5cGUiOiJhdXRob3JpemF0aW9uX2NvZGUiLCJ1c2VyX2lkIjoiNTc2YmNmODQtMzZmZC00ZmIyLWE1MjUtZWJlZGI4OTI0YmQwIiwidXNlcl9uYW1lIjoibmFnYXJhanUua290dGFAc2FwLmNvbSIsImVtYWlsIjoibmFnYXJhanUua290dGFAc2FwLmNvbSIsImdpdmVuX25hbWUiOiJuYWdhcmFqdS5rb3R0YSIsImZhbWlseV9uYW1lIjoic2FwLmNvbSIsImlhdCI6MTQ5NTYxMzM5MSwiZXhwIjoxNDk1NjU2NTkxLCJpc3MiOiJodHRwOi8vaXNvaWxyZWZhcmNoMS1wYWFzLmxvY2FsaG9zdDo4MDgwL3VhYS9vYXV0aC90b2tlbiIsInppZCI6Imlzb2lscmVmYXJjaDEtcGFhcyIsInhzLnVzZXIuYXR0cmlidXRlcyI6e30sInhzLnN5c3RlbS5hdHRyaWJ1dGVzIjp7InhzLnNhbWwuZ3JvdXBzIjpbIlhTX0FVVEhPUklaQVRJT05fQURNSU4iLCJpc29pbHJlZmFyY2gxLXBhYXMtdXNlcmFkbWluIiwiQWRtaW5Vc2VyR3JvdXAiXSwieHMucm9sZWNvbGxlY3Rpb25zIjpbIlhTX0FVVEhPUklaQVRJT05fQURNSU4iLCJYU19NT05JVE9SX0FETUlOIiwiQWRtaW5Vc2VyIl19LCJhdWQiOlsiU3ByaW5nTVZDU2VjdXJpdHlBcHAtQzUyNTE1NTUiLCJvcGVuaWQiLCJzYi1TcHJpbmdNVkNTZWN1cml0eUFwcC1DNTI1MTU1NSJdfQ.qk_oJbbNHgcGSRHtdwJcaCJ5xeMaRyCNrGLziOXho6v_ezXVoVptyjPPr1Cg8sI9paHtxcGVplCQToxiLZjXlnVVqsimUfmbxY6AWn-RUW9v1GMRMHLxo1cgWB8Y_BY0thjvdxUh2yc3L0ZPS2WffjQnEvnl-xe2VVdxP6Ew5fecKFGkVK8u5CkHZkMM3IyksjVtOFoAl9No0dcX--C_12UT9TeyWs6GMgtU85VAUL4jUupVK2n1lEtcWhCWbvIz0UAZpsYbaLXn3VtF80Y9Je7C8jvpLuFyWNFDVWBewJ-pplHCbet023r86vN_A2eVkMDGyc2TDxbj1o2v4MYuTg";
		jwt=jwt.substring(7, jwt.length());
	//	System.out.println(jwt);
		String jwtString = jp.getDecodedJwt(jwt);		
	//	System.out.println(jwtString);
		JSONParser parser = new JSONParser();
		JSONObject jObj = (JSONObject) parser.parse(jwtString);
		String email = (String) jObj.get("email");
		String userName = (String) jObj.get("given_name");
		userName = userName.toUpperCase().replace(".", " ");
		System.out.println(userName);
		Object obj = jObj.get("xs.system.attributes");
		JSONObject jObj1 = (JSONObject) parser.parse(obj.toString());		
		JSONArray jArray = (JSONArray) jObj1.get("xs.rolecollections");
		List list = new ArrayList();
		for(int k=0;k<jArray.size();++k){
			list.add(jArray.get(k));
		}
		System.out.println(list);
		
	}

	public String getDecodedJwt(String jwt) {
		String result = "";		
		String[] parts = jwt.split("[.]");
		try {
			int index = 0;
			for (String part : parts) {

				if (index >= 2)
					break;
				index++;
				byte[] partAsBytes = part.getBytes("UTF-8");

				String decodedPart = new String(java.util.Base64.getUrlDecoder().decode(partAsBytes), "UTF-8");
				result = decodedPart;			
			}
		} catch (Exception e) {
			throw new RuntimeException("Couldnt decode jwt", e);
		}
		return result;
	}
}
