package org.exemple.module;

import com.google.gson.Gson;
import org.junit.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class CompteTest {

    Client client = new Client();
    Banque banque = new Banque();
    Compte compte = new Compte(1,1200,client,banque);

    @Test
    public void testconstructeur(){
        assertEquals(1,compte.getNumCompte());
        assertEquals(1200,compte.getDevise());
        assertEquals(client,compte.getClient());
        assertEquals(banque,compte.getBanque());
        assertNotNull(compte.getTransactions());
        assertTrue(compte.getTransactions().isEmpty());

    }
    @Test
    public void testsetNumCompte(){
        compte.setNumCompte(2);
        assertEquals(2,compte.getNumCompte());

    }
    @Test
    public void testsetDevice(){
        compte.setDevise(1300);
        assertEquals(1300,compte.getDevise());

    }
    @Test
    public void testsetClient(){
        Client client1 = new Client();
        compte.setClient(client1);
        assertEquals(client1,compte.getClient());

    }
    @Test
    public void testsetBanque(){
        Banque banque1 = new Banque();
        compte.setBanque(banque1);
        assertEquals(banque1,compte.getBanque());

    }

    @Test
    public void testtoStrig(){
        String excepted = "Compte{" +
                "numCompte=" + compte.getNumCompte() +
                ", dateCreation=" + compte.getDateCreation() +
                ", dateUp=" + compte.getDateUp() +
                ", devise=" + compte.getDevise() +
                '}';
        assertEquals(excepted,compte.toString());
    }

//    @Test
//    public void testtoJson(){
//        Gson gson = new Gson();
//        String excepted = gson.toJson(compte);
//        assertEquals(excepted,compte.toJson());
//    }

    @Test
    public void testToJson(){
        String json = compte.ToJson();
        assertNotNull(json);
        assertEquals(1,compte.getNumCompte());
        assertEquals(1200,compte.getDevise());
    }

}