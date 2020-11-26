package com.example.sharingapp;

import android.content.Context;

public class AddContactCommand extends Command {
    private ContactList contactList;
    private Contact contact;
    private Context context;

    public AddContactCommand(ContactList contactList, Contact contact, Context context)
    {
        this.contact = contact;
        this.contactList = contactList;
        this.context = context;
    }

    public void execute()
    {
        contactList.addContact(contact);
        setIsExecuted(contactList.saveContacts(context));
    }
}
