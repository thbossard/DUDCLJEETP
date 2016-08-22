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
		home2.addHomeHeaters(h2);
		home2.addHomeHeaters(h3);
		home3.addHomeHeaters(h4);
		home3.addHomeHeaters(h5);
		
		HeaterDao.update(h1);
		HeaterDao.update(h2);
		HeaterDao.update(h3);
		HeaterDao.update(h4);
		HeaterDao.update(h5);
		
		home1.addHomeElecDevices(d1);
		home1.addHomeElecDevices(d2);
    	
		DeviceDao.update(d1);
		DeviceDao.update(d2);
		
		
		HomeDao.update(home1);
		HomeDao.update(home2);
		HomeDao.update(home3);
		
		DAOPerson persDao = new DAOPerson();
		Person p = persDao.createPerson("Dupond","Jean","jean.dupond@gmail.com");
		//p.setPersonLName("Durand");
		Person p1 = persDao.createPerson("Bossard","Thierry","th.bossard35@gmail.com");
		Person p2 = persDao.createPerson("Bossard","Thomas","thomas.bossard@gmail.com");
		Person p3 = persDao.createPerson("Durand","Alain","alain.Durand@gmail.com");
		Person p4 = persDao.createPerson("Bossard","G�rard","gs.bossard@orange.fr");
		
		p.addpersonHome(home1);
		p.addpersonHome(home2);
		p1.addpersonHome(home3);
		p.addMyFriends(p1);
		p.addMyFriends(p2);
		p.addMyFriends(p3);
		p.addMyFriends(p4);
				
		
		persDao.update(p);
		persDao.update(p1);
		persDao.update(p2);
		persDao.update(p3);
		persDao.update(p4);
		
		HomeDao.update(home1);
		HomeDao.update(home2);
		HomeDao.update(home3);
		
    }

}