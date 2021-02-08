package step_definitions;

import java.util.Map;

import io.cucumber.java.DataTableType;
import pojos.UserInfo;

public class PojoTransformers {
	
	@DataTableType
	public UserInfo getUser (Map<String,String> user) {
			
		
		return new UserInfo(user.get("first"), 
						user.get("last"), 
						user.get("email"), 
						user.get("dateOfBirth"),
						user.get("SSN"),
						user.get("cellPhone"));
	}

}
