package domain;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import domain.util.CustomHomeSerializer;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Table(name="HOME")
@Entity
//implements Serializable
public class Home {
	
	private int homeId;
	private String homeName;
	private String homeType;
	private int homeSize;
	private int homeRoomCount;
	private List<Heater> homeHeaters;
	private Person homePerson;
	private List<ElecDevices> homeElecDevices;
		
	public Home (String homeName,String homeType,int homeSize,int homeRoomCount ) {
		super();
		this.homeName = homeName;
		this.homeType = homeType;
		this.homeSize = homeSize;
		this.homeRoomCount = homeRoomCount;
	}
	
	public Home(){
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column( name = "HOME_ID" )
	public int getHomeId() {
		return homeId;
	}

	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}
	
	@Column(name="HOME_NAME")
	public String getHomeName() {
		return homeName;
	}

	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	
	@Column(name="HOME_TYPE")
	public String getHomeType() {
		return homeType;
	}

	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}

	@Column(name="HOME_SIZE")
	public int getHomeSize() {
		return homeSize;
	}

	public void setHomeSize(int homeSize) {
		this.homeSize = homeSize;
	}
	
	@Column(name="HOME_ROOMCOUNT")
	public int getHomeRoomCount() {
		return homeRoomCount;
	}

	public void setHomeRoomCount(int homeRoomCount) {
		this.homeRoomCount = homeRoomCount;
	}
	
	@Column(nullable = true)
	@JsonManagedReference
	@OneToMany(mappedBy = "heaterHome",cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
	public List<Heater> getHomeHeaters() {
		return homeHeaters;
	}

	public void setHomeHeaters(List<Heater> homeHeaters) {
		this.homeHeaters = homeHeaters;
	}

	public void addHomeHeaters(Heater h){
		if (homeHeaters == null){
			homeHeaters = new ArrayList<Heater>();
		}
		homeHeaters.add(h);
		h.setHeaterHome(this);
	}
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	@JsonSerialize(using = CustomHomeSerializer.class)
	@JsonBackReference
	public Person getHomePerson() {
		return homePerson;
	}

	public void setHomePerson(Person homePerson) {
		this.homePerson = homePerson;
	}
	
	
	@OneToMany(mappedBy = "deviceHome",cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
	@Column(nullable = true)
    @JsonManagedReference
	public List<ElecDevices> getHomeElecDevices() {
		return homeElecDevices;
	}

	public void setHomeElecDevices(List<ElecDevices> homeElecDevices) {
		this.homeElecDevices = homeElecDevices;
	}
	
	public void addHomeElecDevices (ElecDevices d){
		if (homeElecDevices == null){
			homeElecDevices = new ArrayList<ElecDevices>();
			
		}
		homeElecDevices.add(d);
		d.setDeviceHome(this);
	}
	
}