package AddressBook;

import java.time.LocalDateTime;

public class AddressBookRecord {

    enum Groups {
        Friends,
        Family,
        Mates,
        Coworkers,
        Others
    }

    class Address {

        private String index;
        private String city;
        private String street;
        private int house;
        private Integer apartment;

        Address(String index, String city, String street, int house, Integer apartment) {

            this.index = index;
            this.city = city;
            this.street = street;
            this.house = house;
            this.apartment = apartment;
        }

        @Override
        public String toString() {
            return "Index: " + index + ", city: " + city +
                    ", street: " + street + ", house: " + house +
                    apartment != null ? (", apartment: " + apartment) : ".";
        }

    }

    private String firstName;
    private String lastName;
    private String nickName;

    private String comment;
    private Groups group;

    private String homeNumber;
    private String mobile;
    private String mobile2;
    private String email;
    private String skype;

    private Address address;
    private LocalDateTime dateCreated;
    private LocalDateTime dateChanged;

    AddressBookRecord(String firstName, String lastName, String nickName,
                      String homeNumber, String mobile, String mobile2,
                      String email, String skype, Address address,
                      String comment, int group) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.homeNumber = homeNumber;
        this.mobile = mobile;
        this.mobile2 = mobile2;
        this.email = email;
        this.skype = skype;
        this.address = address;
        this.comment = comment;
        this.group = Groups.values()[group];
        dateCreated = LocalDateTime.now();
        dateChanged = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nNickname: " + nickName +
                "\nGroup: " + group +
                (!homeNumber.isEmpty() ? ("\nHome number: " + homeNumber) : "") +
                (!mobile.isEmpty() ? ("\nMobile: " + mobile) : "") +
                (!mobile2.isEmpty() ? ("\nMobile: " + mobile2) : "") +
                "\nAddress: " + address +
                "\nCreated: " + dateCreated +
                "\nChanged: " + dateChanged;
    }
}
