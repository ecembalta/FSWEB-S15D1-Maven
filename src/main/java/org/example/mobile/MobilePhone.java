package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact){
        if(contact == null || contact.getName() == null || contact.getPhoneNumber()==null){
            return false;
        }
        if(findContact(contact.getName()) >= 0 || findContactNumber(contact.getPhoneNumber()) >= 0){
            return false;
        }
            return this.myContacts.add(contact);
    }

    public boolean updateContact(Contact pastContact, Contact newContact){
        int index = findContact(pastContact);

        if(index != -1){
            myContacts.set(index, newContact);
            return true;
        }else{
            return false;
        }
    }

    public boolean removeContact(Contact contact){
        return myContacts.remove(contact);
    }

    public int findContact(Contact contact){
        int index = myContacts.indexOf(contact);
        return index;
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public int findContactNumber(String phoneNumber) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name){
        for (Contact contact: myContacts){
            if(contact.getName().equalsIgnoreCase(name)){
                return contact;
            }
        }
        return null;
    }

    public void printContact(){
        System.out.println("Contact List:");
        for(int i = 0; i < myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            System.out.println((i+1)+"."+contact.getName()+"->"+contact.getPhoneNumber());
        }
    }

}
