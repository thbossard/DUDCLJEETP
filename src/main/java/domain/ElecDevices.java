package domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import domain.Home;

@Table(name="ELECDEVICES")
@Entity
public class ElecDevices implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int deviceId;
	private String deviceName;
	private int deviceAvConso;
	private Home deviceHome;
		
	public ElecDevices(){
		
	}
	
	public ElecDevices(String deviceName, int deviceAvConso){
		this.deviceName = deviceName;
		this.deviceAvConso = deviceAvConso;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ELECDEVICES_ID")
	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	
	@Column(name="ELECDEVICES_NAME")
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	@Column(name="ELECDEVICES_AVCONSO")
	public int getdeviceAvConso() {
		return deviceAvConso;
	}

	public void setdeviceAvConso(int deviceAvConso) {
		this.deviceAvConso = deviceAvConso;
	}
	
	@ManyToOne
	@JoinColumn(name="HOME_ID")
	public Home getDeviceHome() {
		return deviceHome;
	}

	public void setDeviceHome(Home deviceHome) {
		this.deviceHome = deviceHome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deviceAvConso;
		result = prime * result + deviceId;
		result = prime * result + ((deviceName == null) ? 0 : deviceName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElecDevices other = (ElecDevices) obj;
		if (deviceAvConso != other.deviceAvConso)
			return false;
		if (deviceId != other.deviceId)
			return false;
		if (deviceName == null) {
			if (other.deviceName != null)
				return false;
		} else if (!deviceName.equals(other.deviceName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ElecDevices [deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceAvConso=" + deviceAvConso
				+ "]";
	}

	
	
	
	
}
