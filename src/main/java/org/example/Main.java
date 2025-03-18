package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone("1234568", new ArrayList<>());
        mobilePhone.addNewContact(new Contact("ecem" , "13242342"));
        mobilePhone.addNewContact(new Contact("soner" , "13242342"));

        mobilePhone.printContact();
    }
}
