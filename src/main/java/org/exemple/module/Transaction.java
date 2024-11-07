package org.exemple.module;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import  com.google.gson.Gson;


public class Transaction {

    public enum Type{
        VIRINI,
        VIREST,
        VIRMULTA,
        VIRCHAC;
    }

    private Type type;
    private Date timestump;
    private String reference;
    private List<Compte> comptes;

    public Transaction(){}

    public Transaction(Type type, Date timestump, String reference, List<Compte> comptes) {
        this.type = type;
        this.timestump = timestump;
        this.reference = reference;
        this.comptes = comptes;
    }

    public Transaction(List<Compte> comptes) {
        this.timestump = new Date();
        this.reference = genererReference();
        this.comptes = new ArrayList<>();
        addcomptes(comptes);
        this.type = typetransaction();
    }

    private String genererReference(){
        return UUID.randomUUID().toString();
    }

    public void addCompte(Compte compte){
        this.comptes.add(compte);
    }
    public void addcomptes( List<Compte> comptes){
        for (Compte compte : comptes) {
            addCompte(compte);
        }
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getTimestump() {
        return timestump;
    }

    public void setTimestump(Date timestump) {
        this.timestump = timestump;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", timestump=" + timestump +
                ", reference='" + reference + '\'' +
                '}';
    }

//    public String toJson(){
//        Gson gson = new Gson();
//        return gson.toJson(this);
//    }

    private Boolean MemeBanque(Banque banque1, Banque banque2){
        if (banque1.getId().equals(banque2.getId())) {
            return true;
        }else{
            return false;
        }
    }

    private Boolean MemePaysBanque(Banque banque1, Banque banque2){
        if (banque1.getPays().equals(banque2.getPays())) {
            return true;
        }else{
            return false;
        }
    }

    public Type typetransaction(){
        final int COMPTE_NBR = this.comptes.size();
        if (COMPTE_NBR == 2) {

            for (int i = 0; i < COMPTE_NBR - 1 ; i++) {
                //if (this.comptes.get(i).getBanque().getId().equals(this.comptes.get(i+1).getBanque().getId()))
                if (MemeBanque(this.comptes.get(i).getBanque(),this.comptes.get(i+1).getBanque())){

                    return  Type.VIRINI;
                }else if (MemePaysBanque(this.comptes.get(i).getBanque(),this.comptes.get(i+1).getBanque()))
                {

                    return  Type.VIREST;

                } else if (!MemeBanque(this.comptes.get(i).getBanque(),this.comptes.get(i+1).getBanque())
                        && !MemePaysBanque(this.comptes.get(i).getBanque(),this.comptes.get(i+1).getBanque())
                ) {

                    return  Type.VIRCHAC;

                }else{
                    return null;
                }
            }
        }else if (COMPTE_NBR > 2 ){

            return  Type.VIRMULTA;

        }else{
            return null;
        }
            return null;
    }

    public TransactionBuilder build(){
        return new TransactionBuilder();
    }


    public String ToJson(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(this);
            return json;
        } catch (JacksonException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Transaction FromJson(String Json){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(Json, Transaction.class);
        } catch (JacksonException e) {
            e.printStackTrace();
        }
        return null;
    }

}
