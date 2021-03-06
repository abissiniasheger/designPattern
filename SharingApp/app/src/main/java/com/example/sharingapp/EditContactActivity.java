package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Editing a pre-existing contact consists of deleting the old contact and adding a new contact with the old
 * contact's id.
 * Note: You will not be able contacts which are "active" borrowers
 */
public class EditContactActivity extends AppCompatActivity implements Observer {

    private ContactList contact_list = new ContactList();
    private Contact contact;
    private EditText email;
    private EditText username;
    private Context context;
    private ContactController contactController = new ContactController(contact);
    private ContactListController contactListController = new ContactListController(contact_list);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        context = getApplicationContext();
        contactListController.loadContacts(context);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("position", 0);

        contact = contactListController.getContact(pos);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        username.setText(contactController.getUserName());
        email.setText(contactController.getEmail());
    }

    public void saveContact(View view) {

        String email_str = email.getText().toString();
        String username_str = username.getText().toString();

        if (!validateInput(username_str, email_str))
        {
            return;
        }

        String id = contactController.getId(); // Reuse the contact id
        Contact updated_contact = new Contact(username_str, email_str, id);
        boolean isOldContactDeleted = contactListController.deleteContact(contact_list, contact, context);
        boolean isNewContactAdded = contactListController.addContact(contact_list, updated_contact, context);
        boolean isContactEdited = isOldContactDeleted && isNewContactAdded;
        if (!isContactEdited)
            return;
        // End EditContactActivity
        finish();
    }

    public boolean validateInput(String username_str, String email_str)
    {
        boolean isValidInput = false;
        if (email_str.equals("")) {
            email.setError("Empty field!");
            return isValidInput;
        }

        if (!email_str.contains("@")){
            email.setError("Must be an email address!");
            return isValidInput;
        }
        // Check that username is unique AND username is changed (Note: if username was not changed
        // then this should be fine, because it was already unique.)
        if (!contactListController.isUserNameAvailable(username_str) &&
                !(contactController.getUserName().equals(username_str))) {
            username.setError("Username already taken!");
            return isValidInput;
        }
        return !isValidInput;
    }

    public void deleteContact(View view) {
        boolean isContactDeleted = contactListController.deleteContact(contact_list, contact, context);
        if (!isContactDeleted)
            return;
        // End EditContactActivity
        finish();
    }

    @Override
    public void update(Observable observable, Object arg)
    {
        displayContacts(((ContactList) observable).getContacts());
    }

    public void displayContacts(ArrayList<Contact> contacts)
    {
        for (Contact contact : contacts)
        {
            System.out.println("User Name" + contact.getUsername() + "\tEmail" + contact.getEmail());
        }

    }
}
