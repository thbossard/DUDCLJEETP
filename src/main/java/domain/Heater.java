package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;



@Table(name="HEATER")
@Entity
public class Heater implements Serializable{
		
	private static final long serialVersionUID = -5879255673979479641L;
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