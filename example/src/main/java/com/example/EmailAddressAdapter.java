package com.example;

import jakarta.json.bind.adapter.JsonbAdapter;

public class EmailAddressAdapter implements JsonbAdapter<EmailAddress, String> {

    @Override
    public String adaptToJson(EmailAddress obj) {
        return obj.getValue();
    }

    @Override
    public EmailAddress adaptFromJson(String obj) {
        return new EmailAddress(obj);
    }
}