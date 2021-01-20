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
    
    public DeliveryNote(String invoiceNumber, String customerName, String customerEmail, String orderDate, String deliveryDate)
    {
        setInvoiceNumber(invoiceNumber);
        setCustomerName(customerName);
        setCustomerEmail(customerEmail);
        setOrderDate(orderDate);
        setStatus(1);
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
    
    public final void setInvoiceNumber(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
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
}
