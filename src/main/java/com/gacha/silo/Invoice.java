/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;
import java.util.*;
import java.text.ParseException;
/**
 *
 * @author Kevin
 */
public class Invoice {
    private String invoiceNumber;
    private String poNumber;
    private String supplierName;
    private String orderDate;
    private String deliveryDate;
    private String status;
    
    public Invoice(String invoiceNumber, String poNumber, String supplierName, String orderDate, String deliveryDate) throws ParseException
    {
        setInvoiceNumber(invoiceNumber);
        setPoNumber(poNumber);
        setSupplierName(supplierName);
        setOrderDate(orderDate);
        setStatus("new");
    }
    
    public String getInvoiceNumber()
    {
        return this.invoiceNumber;
    }
    
    public String getPoNumber()
    {
        return this.poNumber;
    }
    
    public String getSupplierName()
    {
        return this.supplierName;
    }
    
    public String getOrderDate()
    {
        return this.orderDate;
    }
    
    public String getDeliveryDate()
    {
        return this.deliveryDate;
    }
    
    public String getStatus()
    {
        return this.status;
    }
    
    public final void setInvoiceNumber(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }
    
    public final void setPoNumber(String poNumber)
    {
        this.poNumber = poNumber;
    }
    
    public final void setSupplierName(String supplierName)
    {
        this.supplierName = supplierName;
    }
    
    public final void setOrderDate(String orderDate)
    {
        this.orderDate = orderDate;
    }
    
    public final void setDeliveryDate(String deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }
    
    public final void setStatus(String status)
    {
        this.status = status;
    }
}
