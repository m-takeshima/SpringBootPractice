package com.example.demo.form;

import java.io.Serializable;

import com.example.demo.entity.Contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContactForm implements Serializable {
    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 10, max = 11)
    private String phone;

    @NotBlank
    @Pattern(regexp = "[0-9]{3}[-]{0,1}[0-9]{4}")
    private String zipCode;

    @NotBlank
    private String address;

    @NotBlank
    private String buildingName;

    @NotEmpty
    private String contactType;

    @NotBlank
    private String body;

    // Contactオブジェクトを受け取るコンストラクタ
    public ContactForm(Contact contact) {
        this.lastName = contact.getLastName();
        this.firstName = contact.getFirstName();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
        this.zipCode = contact.getZipCode();
        this.address = contact.getAddress();
        this.buildingName = contact.getBuildingName();
        this.contactType = contact.getContactType();
        this.body = contact.getBody();
    }

    // デフォルトコンストラクタ
    public ContactForm() {
    }
}
