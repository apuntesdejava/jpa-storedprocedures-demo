/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apuntesdejava.jpa.storedprocedures.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author dsilva
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("demojpaPU");;
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        StoredProcedureQuery storedProcedure=em.createStoredProcedureQuery("p");
        
        storedProcedure.registerStoredProcedureParameter("p1", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("inc", Integer.class, ParameterMode.INOUT);
        storedProcedure.setParameter("inc", 100);
        
        storedProcedure.execute();
        
        Integer inc=(Integer)storedProcedure.getOutputParameterValue("inc");
        String version=(String)storedProcedure.getOutputParameterValue("p1");
        
        System.out.println("version:"+version);
        System.out.println("inc:"+inc);
        
        em.getTransaction().commit();
        em.close();
    }
    
}
