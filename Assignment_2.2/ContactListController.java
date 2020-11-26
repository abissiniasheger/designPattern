package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;

public class ContactListController
{
    private ContactList contactList;

    public ContactListController(ContactList contactList)
    {
        this.contactList = contactList;
    }

    public void setContacts(ArrayList<Contact> contact_List)
    {
        contactList.setContacts(contact_List);
    }

    public ArrayList<Contact> getContacts()
    {
        return contactList.getContacts();
    }

    public ArrayList<String> getAllUserNames()
    {
        return contactList.getAllUsernames();
    }

    public boolean addContact(ContactList contactList, Contact contact, Context context)
    {
        AddContactCommand addContactCommand =
                new AddContactCommand(contactList, contact, context);
        addContactCommand.execute();
        boolean isContactAdded = addContactCommand.isExecuted();
        return isContactAdded;
    }

    public boolean deleteContact(ContactList contactList, Contact contact, Context context)
    {
        DeleteContactCommand deleteContactCommand =
                new DeleteContactCommand(contactList, contact, context);
        deleteContactCommand.execute();
        boolean isContactDeleted = deleteContactCommand.isExecuted();
        return isContactDeleted;
    }

    public Contact getContact(int index)
    {
        return contactList.getContact(index);
    }

    public int getSize()
    {
        return contactList.getSize();
    }

    public Contact getContactByUserName(String userName)
    {
        return contactList.getContactByUsername(userName);
    }

    public boolean hasContact(Contact contact)
    {
        return contactList.hasContact(contact);
    }

    public int getIndex(Contact contact)
    {
        return contactList.getIndex(contact);
    }

    public boolean isUserNameAvailable(String userName)
    {
        return contactList.isUsernameAvailable(userName);
    }

    public void loadContacts(Context context)
    {
        contactList.loadContacts(context);
    }

    public void saveContacts(Context context)
    {
        contactList.loadContacts(context);
    }
}
