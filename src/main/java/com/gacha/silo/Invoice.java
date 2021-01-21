/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;

import java.util.*;

/**
 *
 * @author Kevin
 */
public class Invoice {
    private String id;
    private String poNumber;
    private String supplierName;
    private String orderDate;
    private String deliveryDate;
    private int status;

    public Invoice(String id, String poNumber, String supplierName, String orderDate, String deliveryDate) {
        setId(id);
        setPoNumber(poNumber);
        setSupplierName(supplierName);
        setOrderDate(orderDate);
        setDeliveryDate(deliveryDate);
        setStatus(1);
    }

    public Invoice(String poNumber, String supplierName, String orderDate, String deliveryDate) {
        setPoNumber(poNumber);
        setSupplierName(supplierName);
        setOrderDate(orderDate);
        setDeliveryDate(deliveryDate);
        setStatus(1);
    }

    public Invoice(String id, String poNumber, String supplierName, String orderDate, String deliveryDate, int status) {
        setId(id);
        setPoNumber(poNumber);
        setSupplierName(supplierName);
        setOrderDate(orderDate);
        setDeliveryDate(deliveryDate);
        setStatus(status);
    }

    public String getId() {
        return this.id;
    }

    public String getPoNumber() {
        return this.poNumber;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public String getDeliveryDate() {
        return this.deliveryDate;
    }

    public int getStatus() {
        return this.status;
    }

    public final void setId(String id) {
        this.id = id;
    }

    public final void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public final void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public final void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public final void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public final void setStatus(int status) {
        this.status = status;
    }
}
