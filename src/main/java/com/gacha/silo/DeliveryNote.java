/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;
import java.util.*;
import java.text.*;
/**
 *
 * @author micha
 */
public class DeliveryNote {
    
    private String invoiceNumber;
    private String deliveryNotesNumber;
    private String customerName;
    private String customerEmail;
    private Date orderDate;
    private Date deliveryDate;
    private String status;
    private SimpleDateFormat formatter;
    
    public DeliveryNote(String invoiceNumber, String deliveryNotesNumber, String customerName, String customerEmail, Date orderDate, Date deliveryDate, String status) throws ParseException
    {
        setInvoiceNumber(invoiceNumber);
        setDeliveryNotesNumber(deliveryNotesNumber);
        setCustomerName(customerName);
        setCustomerEmail(customerEmail);
        setOrderDate(orderDate);
        setStatus(status);
        formatter = new SimpleDateFormat("dd-MMM-yyyy");
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
        return formatter.format(this.orderDate);
    }
    
    public String getDeliveryDate()
    {
        return formatter.format(this.deliveryDate);
    }
    
    public String getStatus()
    {
        return this.status;
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
    
    public final void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
    }
    
    public final void setDeliveryDate(Date deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }
    
    public final void setStatus(String status)
    {
        this.status = status;
    }
}
