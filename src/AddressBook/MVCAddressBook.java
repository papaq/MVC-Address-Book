package AddressBook;

public class MVCAddressBook {

    public static void main(String[] args) {

        AddressBookView theView = new AddressBookView();
        AddressBookModel theModel = new AddressBookModel();
        AddressBookController theController = new AddressBookController(theView, theModel);

        theView.setVisible(true);
    }
}
