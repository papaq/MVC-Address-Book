package AddressBook;


import java.util.ArrayList;

class AddressBookModel {

    ArrayList<AddressBookRecord> addressBookList;



    AddressBookModel() {

        addressBookList = new ArrayList<>();
    }

    void addNewRecord(AddressBookRecord record) {

        addressBookList.add(record);
    }

    @Override
    public String toString() {

        String returnStr = "";
        int number = 1;

        for(AddressBookRecord record : addressBookList) {
            returnStr += "Record " + number++ +
                    ":\n" + record.toString() + "\n";
        }

        return returnStr;
    }
}


