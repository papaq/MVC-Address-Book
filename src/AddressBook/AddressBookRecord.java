package AddressBook;

import java.time.LocalDateTime;

class AddressBookRecord {

    enum Groups {
        Friends,
        Family,
        Mates,
        Coworkers,
        Others
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
                "\nE-mail: " + email +
                (!skype.isEmpty() ? ("\nSkype: " + skype) : "") +
                "\nAddress: " + address +
                "\nCreated: " + dateCreated +
                "\nChanged: " + dateChanged;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;

        if (!Address.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        AddressBookRecord other = (AddressBookRecord)obj;

        if (obj == this) return true;

        if (this.firstName == null ? other.firstName != null : !this.firstName.equals(other.firstName))
            return false;

        if (this.lastName == null ? other.lastName != null : !this.lastName.equals(other.lastName))
            return false;

        if (this.nickName == null ? other.nickName != null : !this.nickName.equals(other.nickName))
            return false;

        if (this.homeNumber == null ? other.homeNumber != null : !this.homeNumber.equals(other.homeNumber))
            return false;

        if (this.mobile == null ? other.mobile != null : !this.mobile.equals(other.mobile))
            return false;

        if (this.mobile2 == null ? other.mobile2 != null : !this.mobile2.equals(other.mobile2))
            return false;

        if (this.email == null ? other.email != null : !this.email.equals(other.email))
            return false;

        if (this.skype == null ? other.skype != null : !this.skype.equals(other.skype))
            return false;

        if (this.address == null ? other.address != null : !this.address.equals(other.address))
            return false;

        if (this.dateCreated == null ? other.dateCreated != null : !this.dateCreated.equals(other.dateCreated))
            return false;

        if (this.dateChanged == null ? other.dateChanged != null : !this.dateChanged.equals(other.dateChanged))
            return false;

        if (this.group == null ? other.group != null : !this.group.equals(other.group))
            return false;

        if (this.comment == null ? other.comment != null : !this.comment.equals(other.comment))
            return false;

        return true;
    }
}

class Address {

    private String index;
    private String city;
    private String street;
    private String house;
    private Integer apartment;

    Address(String index, String city, String street, String house, Integer apartment) {

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
                (apartment != null ? (", apartment: " + apartment) : ".");
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;

        if (!Address.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        Address other = (Address)obj;

        if (obj == this) return true;

        if (this.index == null ? other.index != null : !this.index.equals(other.index))
            return false;

        if (this.city == null ? other.city != null : !this.city.equals(other.city))
            return false;

        if (this.street == null ? other.street != null : !this.street.equals(other.street))
            return false;

        if (this.house == null ? other.house != null : !this.house.equals(other.house))
            return false;

        if (this.apartment == null ? other.apartment != null : !this.apartment.equals(other.apartment))
            return false;

        return true;
    }
}
