package com.example.sharingapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Add a new contact
 */
public class AddContactActivity extends AppCompatActivity {

    private ContactList contact_list = new ContactList();
    ContactListController contactListController = new ContactListController(contact_list);
    private Context context;

    private EditText username;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        context = getApplicationContext();
        contactListController.loadContacts(context);
    }

    public void saveContact(View view) {

        String username_str = username.getText().toString();
        String email_str = email.getText().toString();

        if (!validateInput(username_str, email_str))
        {
            return;
        }

        if (username_str.equals("")) {
            username.setError("Empty field!");
            return;
        }

        Contact contact = new Contact(username_str, email_str, null);

        boolean isContactAdded = contactListController.addContact(contact_list, contact, context);
        if (!isContactAdded)
            return;

        // End AddContactActivity
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

        if (!contactListController.isUserNameAvailable(username_str)){
            username.setError("Username already taken!");
            return isValidInput;
        }

        return !isValidInput;
    }
}
