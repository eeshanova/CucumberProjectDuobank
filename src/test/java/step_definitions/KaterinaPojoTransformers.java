package step_definitions;

import java.util.Map;

import io.cucumber.java.DataTableType;
import pojos.EmployerKaterina;


public class KaterinaPojoTransformers {
	
	@DataTableType
	public EmployerKaterina getEmployer (Map<String,String> employer) {
			
		
		return new EmployerKaterina(employer.get("employer"), 
				employer.get("position"),
				employer.get("city"),
				employer.get("state"),
				employer.get("startDate"),
				employer.get("monthlyIncome"));
	}

}
