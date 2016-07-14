package jpa;

import repository.DAOPerson;
import repository.DAOHome;
import repository.DAOHeater;
import repository.DAOElecDevices;
import domain.*;

public class App 
{
    public static void main( String[] args )
    {
    	DAOHeater HeaterDao = new DAOHeater();
    	Heater h1 = HeaterDao.createHeater("chaudiere gaz",150);
    	Heater h2 = HeaterDao.createHeater("chauffage electrique",100);
    	Heater h3 = HeaterDao.createHeater("chaudiere fioul",150);
    	Heater h4 = HeaterDao.createHeater("chauffage sol electrique",60);
    	Heater h5 = HeaterDao.createHeater("Rayonnant",50);
    	
    	
    	DAOElecDevices DeviceDao = new DAOElecDevices();
    	ElecDevices d1 = DeviceDao.createElecDevices("ordi PC", 150);
		ElecDevices d2 = DeviceDao.createElecDevices("television",70);
		
		DAOHome HomeDao = new DAOHome();
		Home home1 = HomeDao.createHome("Mon logement 1","appart",250,7);
		Home home2 = HomeDao.createHome("Mon logement 2","Maison",1120,14);
		Home home3 = HomeDao.createHome("Mon Logement 4","Villa",2000,20);
				
		home1.addHomeHeaters(h1);
		home1.addHomeHeaters(h2);
		
		HeaterDao.update(h1);
		HeaterDao.update(h2);
		
		home1.addHomeElecDevices(d1);
		home1.addHomeElecDevices(d2);
    	
		DeviceDao.update(d1);
		DeviceDao.update(d2);
		
		HomeDao.update(home1);
		
		DAOPerson persDao = new DAOPerson();
		Person p = persDao.createPerson("Dupond","Jean","jean.dupond@gmail.com");
		p.setPersonLName("Durand");
				
		p.addpersonHome(home1);
		p.addpersonHome(home2);
		persDao.update(p);
	
		HomeDao.update(home1);
		HomeDao.update(home2);
		
		
    }

}