package com.kafein.moviemanager.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ServiceLog {

    public ServiceLog() {
        this.inDate = new Date();
    }

    public ServiceLog(Date inDate) {
        this.inDate = inDate;
    }

    public ServiceLog(Date inDate, String serviceName) {
        this.inDate = new Date();
        this.serviceName = serviceName;
    }

    public ServiceLog(Date inDate, String serviceName, String serviceOperation) {
        this.inDate = new Date();
        this.serviceName = serviceName;
        this.serviceOperation = serviceOperation;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String headerApplication;

    private String serviceName;

    private String serviceOperation;

    private String resultCode;

    private String resultDesc;

    private Date inDate;

    @Lob
    private String inParameters;

    private Date outDate;

    @Lob
    private String outParameters;

}
