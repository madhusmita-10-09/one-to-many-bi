package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveHospitalBranch {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Hospital hospital=new Hospital();
		hospital.setName("ramaya");
		hospital.setWeb("www.ramaya.com");

		
		Branch branch1=new Branch();
		branch1.setName("cardiology");
		branch1.setAddress("basavagudi");
		branch1.setPhone(84646464664l);
		
		Branch branch2=new Branch();
		branch2.setName("dermatilogy");
		branch2.setAddress("marathali");
		branch2.setPhone(84464664l);
		
		Branch branch3=new Branch();
		branch3.setName("cardiology");
		branch3.setAddress("basavagudi");
		branch3.setPhone(84646464664l);
		
		List<Branch>branchs=new ArrayList<Branch>();
		branchs.add(branch1);
		branchs.add(branch2);
		branchs.add(branch3);
		
		hospital.setBranch(branchs);
		branch1.setHospital(hospital);
		branch2.setHospital(hospital);
		branch3.setHospital(hospital);
		
		entityTransaction.begin();
	    entityManager.persist(hospital);
	    entityManager.persist(branch1);
	    entityManager.persist(branch2);
	    entityManager.persist(branch3);
	    
		entityTransaction.commit();
		
	}

}
