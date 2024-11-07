package org.exemple.module;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    Client client = new Client(1,"nom1","prenom1","adresse1","phone1","email1");

    @Test
    public void testconstructeur(){
        assertEquals(1,client.getNumClient());
        assertEquals("nom1",client.getNom());
        assertEquals("prenom1",client.getPrenom());
        assertEquals("adresse1",client.getAdresse());
        assertEquals("phone1",client.getPhone());
        assertEquals("email1",client.getEmail());
        assertNotNull(client.getComptes());
        assertTrue(client.getComptes().isEmpty());
    }

    @Test
    public void testaddcompte(){
        Compte compte =new Compte();
        client.addCompte(compte);
        assertFalse(client.getComptes().isEmpty());
    }

    @Test
    public void testsetNumClient(){
        client.setNumClient(2);
        assertEquals(2,client.getNumClient());
    }

    @Test
    public void testsetNom(){
        client.setNom("nom2");
        assertEquals("nom2",client.getNom());
    }
    @Test
    public void testsetPrenom(){
        client.setPrenom("prenom2");
        assertEquals("prenom2",client.getPrenom());
    }
    @Test
    public void testsetAdresse(){
        client.setAdresse("Adresse2");
        assertEquals("Adresse2",client.getAdresse());
    }
    @Test
    public void testsetPhone(){
        client.setPhone("phone2");
        assertEquals("phone2",client.getPhone());
    }
    @Test
    public void testsetEmail(){
        client.setEmail("email2");
        assertEquals("email2",client.getEmail());
    }

    @Test
    public void testsetcomptes(){
        List<Compte>  comptes = new ArrayList<>();
        Compte compte1 = new Compte();
        Compte compte2 = new Compte();
        comptes.add(compte1);
        comptes.add(compte2);
        client.setComptes(comptes);
        assertEquals(comptes.get(0),client.getComptes().get(0));
        assertEquals(comptes.get(1),client.getComptes().get(1));
    }

    @Test
    public void testtoStrig(){
        String excepted = "Client{" +
                "numClient=" + client.getNumClient() +
                ", nom='" + client.getNom() + '\'' +
                ", prenom='" + client.getPrenom() + '\'' +
                ", adresse='" + client.getAdresse() + '\'' +
                ", phone='" + client.getPhone() + '\'' +
                ", email='" + client.getEmail() + '\'' +
                '}';
        assertEquals(excepted,client.toString());
    }

//    @Test
//    public void testtoJson(){
//        Gson gson = new Gson();
//        String excepted = gson.toJson(client);
//        assertEquals(excepted,client.toJson());
//    }

    @Test
    public void testToJson(){


        String json = client.ToJson();
        assertNotNull(json);
        assertTrue(json.contains(client.getNom()));
        assertTrue(json.contains(client.getPrenom()));
        assertTrue(json.contains(client.getPhone()));
        assertTrue(json.contains(client.getAdresse()));
        assertTrue(json.contains(client.getEmail()));
        assertEquals(1,client.getNumClient());

    }


}