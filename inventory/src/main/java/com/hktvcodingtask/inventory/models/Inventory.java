package com.hktvcodingtask.inventory.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 255, message = "! Name must not be empty !")
    private String name;

    @Size(min = 1, max = 8, message = "! Code must between 1 to 8 char !")
    private String code;

    @Size(min = 1, message = "! weight must be larger than zero !")
    private int weight;

    @Min(0)
    private int TKO;
    @Min(0)
    private int CWB;
    @Min(0)
    private int TSW;

    public Inventory(String name, String code, int weight, int TKO, int CWB, int TSW) {
        this.name = name;
        this.code = code;
        this.weight = weight;
        this.TKO = TKO;
        this.CWB = CWB;
        this.TSW = TSW;
    }

    public int getTKO() {
        return this.TKO;
    }

    public void setTKO(int TKO) {
        this.TKO = TKO;
    }

    public int getCWB() {
        return this.CWB;
    }

    public void setCWB(int CWB) {
        this.CWB = CWB;
    }

    public int getTSW() {
        return this.TSW;
    }

    public void setTSW(int TSW) {
        this.TSW = TSW;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date updatedAt;

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory() {

    }
}
