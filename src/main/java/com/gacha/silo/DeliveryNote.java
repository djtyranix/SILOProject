/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;
import java.util.*;
/**
 *
 * @author micha
 */
public class DeliveryNote {
    
    private String invoiceNumber;
    private String deliveryNotesNumber;
    private String customerName;
    private String customerEmail;
    private String orderDate;
    private String deliveryDate;
    private int status;
    private String itemStr;
    
    public DeliveryNote(String invoiceNumber, String customerName, String customerEmail, String orderDate, String deliveryDate, String itemStr)
    {
        setInvoiceNumber(invoiceNumber);
        setCustomerName(customerName);
        setCustomerEmail(customerEmail);
        setOrderDate(orderDate);
        setDeliveryDate(deliveryDate);
        setItemStr(itemStr);
        setStatus(1);
    }
    
    //Complete constructor
    public DeliveryNote(String deliveryNotesNumber, String invoiceNumber, String customerName, String customerEmail, String orderDate, String deliveryDate, String itemStr, int status)
    {
        setDeliveryNotesNumber(deliveryNotesNumber);
        setInvoiceNumber(invoiceNumber);
        setCustomerName(customerName);
        setCustomerEmail(customerEmail);
        setOrderDate(orderDate);
        setDeliveryDate(deliveryDate);
        setItemStr(itemStr);
        setStatus(status);
    }
    
    public String getInvoiceNumber()
    {
        return this.invoiceNumber;
    }
    
    public String getDeliveryNotesNumber()
    {
        return this.deliveryNotesNumber;
    }
    
    public String getCustomerName()
    {
        return this.customerName;
    }
    
    public String getCustomerEmail()
    {
        return this.customerEmail;
    }
    
    public String getOrderDate()
    {
        return this.orderDate;
    }
    
    public String getDeliveryDate()
    {
        return this.deliveryDate;
    }
    
    public int getStatus()
    {
        return this.status;
    }
    
    public String getItemStr()
    {
        return this.itemStr;
    }
    
    public final void setInvoiceNumber(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }
    
    public final void setDeliveryNotesNumber(String deliveryNotesNumber)
    {
        this.deliveryNotesNumber = deliveryNotesNumber;
    }
    
    public final void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }
    
    public final void setCustomerEmail(String customerEmail)
    {
        this.customerEmail = customerEmail;
    }
    
    public final void setOrderDate(String orderDate)
    {
        this.orderDate = orderDate;
    }
    
    public final void setDeliveryDate(String deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }
    
    public final void setStatus(int status)
    {
        this.status = status;
    }
    
    public final void setItemStr(String itemStr)
    {
        this.itemStr = itemStr;
    }
}
