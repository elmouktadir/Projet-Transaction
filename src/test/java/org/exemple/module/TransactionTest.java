package org.exemple.module;

import org.exemple.module.Transaction.Type;
import com.google.gson.Gson;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.exemple.module.Transaction.Type.VIRMULTA;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    List<Compte> comptes = new ArrayList<>();
    Transaction transaction = new Transaction(comptes);

    @Test
    public void testGenererReference() {
        String reference = transaction.getReference();
        assertNotNull(reference);
        assertFalse(reference.isEmpty());
    }

    @Test
    public void addCompte(){
        Banque banque1 = new Banque("1","UK");
        Client client1 = new Client(1,"nom1","prenom1","addresse1","phone1","email1");
        Compte compte = new Compte(1,1200,client1,banque1);
        transaction.addCompte(compte);
        assertEquals(1,transaction.getComptes().size());
        assertTrue(transaction.getComptes().contains(compte));
    }

    @Test
    public void testTransactionVIRINI(){
        List<Compte> comptes = new ArrayList<>();
        Banque banque1 = new Banque("1","UK");
        Banque banque2 = new Banque("1","USA");
        Client client1 = new Client(1,"nom1","prenom1","addresse1","phone1","email1");
        Client client2 = new Client(2,"nom2","prenom2","addresse2","phone2","email2");
        Compte compte1 = new Compte(1,1200,client1,banque1);
        Compte compte2 = new Compte(2,1500,client2,banque2);
        comptes.add(compte1);
        comptes.add(compte2);
        Transaction transaction = new Transaction(comptes);
        assertEquals(Type.VIRINI,transaction.getType());
    }

    @Test
    public void testTransactionVIREST(){
        List<Compte> comptes = new ArrayList<>();
        Banque banque1 = new Banque("1","UK");
        Banque banque2 = new Banque("2","UK");
        Client client1 = new Client(1,"nom1","prenom1","addresse1","phone1","email1");
        Client client2 = new Client(2,"nom2","prenom2","addresse2","phone2","email2");
        Compte compte1 = new Compte(1,1200,client1,banque1);
        Compte compte2 = new Compte(2,1500,client2,banque2);
        comptes.add(compte1);
        comptes.add(compte2);
        Transaction transaction = new Transaction(comptes);
        assertEquals(Type.VIREST,transaction.getType());
    }

    @Test
    public void testTransactionVICHAC(){
        List<Compte> comptes = new ArrayList<>();
        Banque banque1 = new Banque("1","UK");
        Banque banque2 = new Banque("2","USA");
        Client client1 = new Client(1,"nom1","prenom1","addresse1","phone1","email1");
        Client client2 = new Client(2,"nom2","prenom2","addresse2","phone2","email2");
        Compte compte1 = new Compte(1,1200,client1,banque1);
        Compte compte2 = new Compte(2,1500,client2,banque2);
        comptes.add(compte1);
        comptes.add(compte2);
        Transaction transaction = new Transaction(comptes);
        assertEquals(Type.VIRCHAC,transaction.getType());
    }
    @Test
    public void testTransactionVIMULTA(){
        List<Compte> comptes = new ArrayList<>();
        Banque banque1 = new Banque("1","UK");
        Banque banque2 = new Banque("2","USA");
        Client client1 = new Client(1,"nom1","prenom1","addresse1","phone1","email1");
        Client client2 = new Client(2,"nom2","prenom2","addresse2","phone2","email2");
        Client client3 = new Client(3,"nom3","prenom3","addresse3","phone3","email3");
        Compte compte1 = new Compte(1,1200,client1,banque1);
        Compte compte2 = new Compte(2,1500,client2,banque1);
        Compte compte3 = new Compte(2,1500,client3,banque2);
        comptes.add(compte1);
        comptes.add(compte2);
        comptes.add(compte3);
        Transaction transaction = new Transaction(comptes);
        assertEquals(Type.VIRMULTA,transaction.getType());
    }

    @Test
    public void testtoStrig(){
        String excepted = "Transaction{" +
                "type=" + transaction.getType() +
                ", timestump=" + transaction.getTimestump() +
                ", reference='" + transaction.getReference() + '\'' +
                '}';
        assertEquals(excepted,transaction.toString());
    }

//    @Test
//    public void testtoJson(){
//        Gson gson = new Gson();
//        String excepted = gson.toJson(transaction);
//        assertEquals(excepted,transaction.toJson());
//    }

    @Test
    public void testToJson(){
        //les banques
        Banque banque1 = new Banque("1","Beni Mellal");
        Banque banque2 = new Banque("2","FQUIH BEN SALAH");

        //les client
        Client client1 = new Client(1,"nom1","prenom1","addresse1","phone1","email1");
        Client client2 = new Client(2,"nom2","prenom2","addresse2","phone2","email2");
        Client client3 = new Client(3,"nom3","prenom3","addresse3","phone3","email3");
        //les comptes
        Compte compte1 = new Compte(1,1200,client1,banque1);
        Compte compte2 = new Compte(2,1500,client2,banque2);
        Compte compte3 = new Compte(3,1900,client3,banque2);
        List<Compte> comptes = new ArrayList<>();
        comptes.add(compte1);
        comptes.add(compte2);
        comptes.add(compte3);
        //objet transaction
        Transaction transaction = new Transaction(comptes);
        String json = transaction.ToJson();
        assertNotNull(json);
        assertTrue(json.contains("VIRMULTA"));
        assertTrue(json.contains(transaction.getReference()));
    }



}