package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import domain.util.CustomHeaterSerializer;

@Table(name="HEATER")
@Entity
public class Heater{
		
	private int heaterId;
	private String heaterName = null;
	private int heaterConso;
	private Home heaterHome;
		
	public Heater() {
		
	}
		
	public Heater(String heaterName, int heaterConso ){
		this.heaterName = heaterName;
		this.heaterConso = heaterConso;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="HEATER_ID")
	public int getHeaterId() {
		return heaterId;
	}
	
	public void setHeaterId(int heaterId) {
		this.heaterId = heaterId;
	}
	
	@Column(name="HEATER_NAME")
	public String getHeaterName() {
		return heaterName;
	}
		
	public void setHeaterName(String heaterName) {
		this.heaterName = heaterName;
	}

	@Column(name="HEATER_CONSO")
	public int getHeaterConso() {
		return heaterConso;
	}

	public void setHeaterConso(int heaterConso) {
		this.heaterConso = heaterConso;
	}

	@ManyToOne
	@JoinColumn(name="HOME_ID")
	@JsonBackReference
	@JsonSerialize(using = CustomHeaterSerializer.class)
	public Home getHeaterHome(){
		return heaterHome;
	}
	
	public void setHeaterHome(Home h) {
		heaterHome = h;
	}
	
	
	@Override
	public String toString() {
		return "Heater [heaterId=" + heaterId + ", heaterName=" + heaterName + ", heaterConso=" + heaterConso + "]";
	}


}