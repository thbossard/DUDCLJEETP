package domain;


//import domain.util.CustomDepartmentSerializer;
//import org.codehaus.jackson.map.annotate.JsonSerialize;

//import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;


import java.util.ArrayList;

@Table(name="PERSON")
@Entity
public class Person {
		
	private int personId;
	private String personLName;
	private String personFName;
	private String personMail;
	private List<Home> personHomes;
			
	public Person(){
		
	}

	public Person(String personLName, String personFName, String personMail) {
		super();
		this.personLName = personLName;
		this.personFName = personFName;
		this.personMail = personMail;
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PERSON_ID")
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	@Column(name="PERSON_LNAME")
	public String getPersonLName() {
		return personLName;
	}

	public void setPersonLName(String personLName) {
		this.personLName = personLName;
	}
	
	@Column(name="PERSON_FNAME")
	public String getPersonFname() {
		return personFName;
	}

	public void setPersonFname(String personFName) {
		this.personFName = personFName;
	}
	
	@Column(name="PERSON_MAIL")
	public String getPersonMail() {
		return personMail;
	}

	public void setPersonMail(String personMail) {
		this.personMail = personMail;
	}

	@OneToMany(mappedBy = "homePerson",cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.LAZY)
	public List<Home> getPersonHomes() {
		return personHomes;
	}

	public void setPersonHomes(List<Home> personHomes) {
		this.personHomes = personHomes;
	}
	
	public void addpersonHome(Home ph){
		if (personHomes == null){
			personHomes = new ArrayList<Home>();
		}
		personHomes.add(ph);
		ph.setHomePerson(this);
	}

	

}
