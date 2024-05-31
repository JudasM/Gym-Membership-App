/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package das.moh;

import java.sql.Timestamp;

/**
 *
 * @author Judas
 */
public class Member {
    private String name;
    private String surname;
    private Integer idNum;
    private Character Gender;
    private String contractType;
    private Boolean trainer;
    private Timestamp timestamp;

    public Member() {
    }

    public Member(String name, String surname, Integer idNum, Character Gender, String contractType, Boolean trainer, Timestamp timestamp) {
        this.name = name;
        this.surname = surname;
        this.idNum = idNum;
        this.Gender = Gender;
        this.contractType = contractType;
        this.trainer = trainer;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getIdNum() {
        return idNum;
    }

    public void setIdNum(Integer idNum) {
        this.idNum = idNum;
    }

    public Character getGender() {
        return Gender;
    }

    public void setGender(Character Gender) {
        this.Gender = Gender;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Boolean getTrainer() {
        return trainer;
    }

    public void setTrainer(Boolean trainer) {
        this.trainer = trainer;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Member{" + "name=" + name + ", surname=" + surname + ", idNum=" + idNum + ", Gender=" + Gender + ", contractType=" + contractType + ", trainer=" + trainer + ", timestamp=" + timestamp + '}';
    }
    
    
    
}
