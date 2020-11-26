package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;

public class ContactController
{
    private Contact contact;

    public ContactController(Contact contact)
    {
        this.contact = contact;
    }

    public void setId()
    {
        contact.setId();
    }

    public String getId()
    {
        return contact.getId();
    }

    public void updateId(String id)
    {
        contact.updateId(id);
    }

    public void setUsername(String userName)
    {
        contact.setUsername(userName);
    }

    public String getUserName()
    {
        return contact.getUsername();
    }

    public void setEmail(String email)
    {
        contact.setEmail(email);
    }

    public String getEmail()
    {
        return contact.getEmail();
    }
}
