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

    boolean contains(AddressBookRecord newRecord) {

        for (AddressBookRecord record : addressBookList) {
            if (record.equals(newRecord)) return true;
        }

        return false;
    }

    AddressBookRecord update(AddressBookRecord newRecord) {

        for (AddressBookRecord record : addressBookList) {
            if (record.equals(newRecord)) {

                newRecord.setDateCreated(record.getDateCreated());
                record = newRecord;
                return record;
            }
        }

        return null;
    }

    ArrayList getAllMatches(AddressBookRecord recordTemplate) {

        ArrayList listOfRecords = new ArrayList();

        for (AddressBookRecord record : addressBookList) {

            if (record.match(recordTemplate)) {

                listOfRecords.add(record.toString());
            }
        }

        return listOfRecords;
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


