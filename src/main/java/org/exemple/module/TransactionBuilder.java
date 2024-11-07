package org.exemple.module;

import java.util.Date;
import java.util.List;

public class TransactionBuilder {
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

    public TransactionBuilder type(Type type){
        this.type =  type;
        return this;
    }

    public TransactionBuilder timestump(Date timestump){
        this.timestump = timestump;
        return this;
    }

    public TransactionBuilder reference(String reference){
        this.reference = reference;
        return this;
    }

    public TransactionBuilder comptes(List<Compte> comptes){
        this.comptes = comptes;
        return this;
    }

    public Transaction build(){
        //return new Transaction(this.type,this.timestump,this.reference,this.comptes);
        return null;
    }

}
