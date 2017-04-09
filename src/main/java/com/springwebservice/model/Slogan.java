package com.springwebservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slogan")
public class Slogan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sloganId;
    
    @Column
    private String sloganName;

    public Long getSloganId() {
        return sloganId;
    }

    public void setSloganId(Long sloganid) {
        this.sloganId = sloganid;
    }

    public String getSloganName() {
        return sloganName;
    }

    public void setSloganName(String sloganName) {
        this.sloganName = sloganName;
    }

}
