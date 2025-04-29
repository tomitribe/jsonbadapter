package com.example;

import jakarta.json.bind.annotation.JsonbTypeAdapter;

import java.util.Objects;
import java.util.regex.Pattern;

@JsonbTypeAdapter(EmailAddressAdapter.class)
public class EmailAddress {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );

    private String value;

    public EmailAddress(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be null or empty");
        }
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email address format: " + value);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final EmailAddress that = (EmailAddress) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}