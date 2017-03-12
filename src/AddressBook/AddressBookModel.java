package AddressBook;


import java.util.ArrayList;

class AddressBookModel {

    private ArrayList<AddressBookRecord> addressBookList;



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

    String lastRecord() {

        int lastIndex = addressBookList.size();
        return "Record " + lastIndex +
                ":\n" + addressBookList.get(lastIndex - 1).toString() + "\n";
    }
}


