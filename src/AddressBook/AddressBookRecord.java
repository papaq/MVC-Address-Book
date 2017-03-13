package AddressBook;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
        dateChanged = dateCreated;
    }

    LocalDateTime getDateCreated() {

        return dateCreated;
    }

    void setDateCreated(LocalDateTime date) {

        dateCreated = date;
    }

    boolean match(AddressBookRecord recordTemplate) {

        return this.firstName.toLowerCase().matches(recordTemplate.firstName) &&
                this.lastName.toLowerCase().matches(recordTemplate.lastName) &&
                this.email.toLowerCase().matches(recordTemplate.email);
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

        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }

        AddressBookRecord other = (AddressBookRecord)obj;

        return new EqualsBuilder()
                .append(firstName, other.firstName)
                .append(lastName, other.lastName)
                .append(email, other.email)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 87).
                append(firstName).
                append(lastName).
                append(nickName).
                append(homeNumber).
                append(mobile).
                append(mobile2).
                append(email).
                append(skype).
                append(address).
                append(group).
                append(comment).
                toHashCode();
    }
}

class Address  {

    private String index;
    private String city;
    private String street;
    private String house;
    private String apartment;

    Address(String index, String city, String street, String house, String apartment) {

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

        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }

        Address other = (Address)obj;

        return new EqualsBuilder()
                .append(index, other.index)
                .append(city, other.city)
                .append(street, other.street)
                .append(house, other.house)
                .append(apartment, other.apartment)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(23, 47).
                append(index).
                append(city).
                append(street).
                append(house).
                append(apartment).
                toHashCode();
    }
}
