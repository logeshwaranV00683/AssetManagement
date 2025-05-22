package com.verinite.assetmangementtool.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_scraptable")
@Data
public class ScrapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scrapId;
    private String Assetname;
    private String SerialNo;
    private Date purchaseDate;
    private Date warrantyDate;
    private String users;
    private String status;
    private String type;
    private int assetId;

    public ScrapEntity() {

    }

    public ScrapEntity(int scrapId, String assetname, String serialNo, Date purchaseDate, Date warrantyDate,
                       String users, String status, String type, int assetId) {
        this.scrapId = scrapId;
        Assetname = assetname;
        SerialNo = serialNo;
        this.purchaseDate = purchaseDate;
        this.warrantyDate = warrantyDate;
        this.users = users;
        this.status = status;
        this.type = type;
        this.assetId = assetId;
    }

    @Override
    public String toString() {
        return "ScrapTable{" + "scrapId=" + scrapId + ", Assetname='" + Assetname + '\'' + ", SerialNo='" + SerialNo
                + '\'' + ", purchaseDate=" + purchaseDate + ", warrantyDate=" + warrantyDate + ", users='" + users
                + '\'' + ", status='" + status + '\'' + ", type='" + type + '\'' + ", assetId=" + assetId + '}';
    }

}
