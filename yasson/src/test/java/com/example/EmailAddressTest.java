package com.example;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmailAddressTest {

    @Test
    public void testRoundTrip() {
        final EmailAddress original = new EmailAddress("user@example.com");
        final Jsonb jsonb = JsonbBuilder.create();

        final String json = jsonb.toJson(original);
        assertEquals("\"user@example.com\"", json);

        final EmailAddress copy = jsonb.fromJson(json, EmailAddress.class);
        assertEquals(original, copy);
    }

    @Test
    public void testWriteOnly() {
        final EmailAddress email = new EmailAddress("test@domain.com");
        final Jsonb jsonb = JsonbBuilder.create();

        final String json = jsonb.toJson(email);
        assertEquals("\"test@domain.com\"", json);
    }

    @Test
    public void testReadOnly() {
        final String json = "\"admin@example.com\"";
        final Jsonb jsonb = JsonbBuilder.create();

        final EmailAddress email = jsonb.fromJson(json, EmailAddress.class);
        assertEquals("admin@example.com", email.getValue());
    }
}