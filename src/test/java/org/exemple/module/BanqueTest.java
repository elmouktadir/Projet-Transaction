package org.exemple.module;
import  com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BanqueTest {

    Banque banque = new Banque("001","France") ;

//    @BeforeEach
//    void setUp(){
//        banque = new Banque("001","France");
//    }

    @Test
    public void testConstructeur(){

        assertEquals("001",banque.getId());
        assertEquals("France",banque.getPays());
        assertNotNull(banque.getComptes());
        assertTrue(banque.getComptes().isEmpty());

    }

    @Test
    public void testSetId(){
        banque.setId("002");
        assertEquals("002",banque.getId());
    }

    @Test
    public void testSetPays(){
        banque.setPays("Morocco");
        assertEquals("Morocco",banque.getPays());
    }

    @Test
    public void testtoStrig(){
        String excepted = "Banque{id=001, pays='France'}";
        assertEquals(excepted,banque.toString());
    }

//    @Test
//    public void testtoJson(){
//        Gson gson = new Gson();
//        String excepted = gson.toJson(banque);
//        assertEquals(excepted,banque.toJson());
//    }

    @Test
    public void testToJson(){
        Banque banque = new Banque("1","UK");

        String json = banque.ToJson();
        assertNotNull(json);
        assertTrue(json.contains("UK"));
        assertTrue(json.contains("1"));
    }


}