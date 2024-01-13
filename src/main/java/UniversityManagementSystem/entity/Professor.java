package UniversityManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class Professor {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String firstName;
	    private String lastName;
	    private String employeeId;
        public String getfirstName() {
        	return firstName;
        }
        public void setfirstName(String firstName) {
        	this.firstName=firstName;
        }
        public String getlastName(){
        	return lastName;
        }
        public void setlastName(String lastName) {
        	this.lastName=lastName;
        }
	    // getters and setters
		public String getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
	}

