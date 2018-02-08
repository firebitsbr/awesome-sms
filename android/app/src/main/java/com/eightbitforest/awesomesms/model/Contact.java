package com.eightbitforest.awesomesms.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class houses all the information needed for a contact. This class only supports a contact
 * name, photo, and phone number, as that is the only relevant information to a messaging app.
 *
 * @author Forrest Jones
 */
public class Contact {

    private int id;
    private String name;
    private ArrayList<Phone> phones;
    private byte[] photo;

    /**
     * Constructs a Contact.
     *
     * @param id     The id of the contact.
     * @param name   The first and last name of the contact.
     * @param phones List of all the phones this contact has.
     * @param photo  Raw thumbnail photo data.
     */
    public Contact(int id, String name, ArrayList<Phone> phones, byte[] photo) {
        this.id = id;
        this.name = name;
        this.phones = phones;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }

    /**
     * Helper class to store a contact's phone information.
     */
    public static class Phone {

        private String number;
        private int type;

        /**
         * Constructs a phone.
         *
         * @param number The phone number.
         * @param type   The type of phone number as decided in ContactsContract.CommonDataKinds.Phone.
         */
        public Phone(String number, int type) {
            this.number = number;
            this.type = type;
        }

        public String getNumber() {
            return number;
        }

        public int getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "number='" + number + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
}