package AddressBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

class AddressBookController {

    private AddressBookView view;
    private AddressBookModel model;

    AddressBookController(AddressBookView view, AddressBookModel model) {

        this.view = view;
        this.model = model;

        ArrayList groupList = new ArrayList();
        Collections.addAll(groupList, AddressBookRecord.Groups.values());

        this.view.setGroupItems(groupList.toArray());

        this.view.setAddButtonListener(new AddNewRecord());
        this.view.setShowButtonListener(new ShowRecords());
    }

    private abstract class ButtonBase implements ActionListener {

        String fName;
        String lName;
        String nName;
        String hNumber;
        String mobile;
        String mobile2;
        String email;
        String skype;
        String index;
        String city;
        String street;
        String house;
        String apartment;
        String comment;
        int group;

        @Override
        public abstract void actionPerformed(ActionEvent e);

        void getTextFields() {

            fName = view.getFirstName().trim();
            lName = view.getLastName().trim();
            nName = view.getNickame().trim();
            hNumber = view.getHomeNumber().trim().replaceAll("\\)|\\(|-|\\+", "");
            mobile = view.getMobile().trim().replaceAll("\\)|\\(|-|\\+", "");
            mobile2 = view.getMobile2().trim().replaceAll("\\)|\\(|-|\\+", "");
            email = view.getEMail().trim().toLowerCase();
            skype = view.getSkype().trim();
            index = view.getIndex().trim().replace("-", "");
            city = view.getCity().trim();
            street = view.getStreet().trim();
            house = view.getHouse().trim();
            apartment = view.getApartment().trim();
            comment = view.getComment().trim();
            group = view.getGroup();
        }

    }

    private class AddNewRecord extends ButtonBase {

        @Override
        public void actionPerformed(ActionEvent e) {

            getTextFields();


            if (fName.isEmpty() || !fName.matches("[A-Z]([a-z]*-[A-Z]+)*[a-z]*")) {

                view.showErrorMessage("There is a mistake in First name!");
                return;
            }

            if (lName.isEmpty() || !lName.matches("[A-Z]([a-z]*-[A-Z]+)*[a-z]*")) {

                view.showErrorMessage("There is a mistake in Last name!");
                return;
            }

            if (!nName.isEmpty() && !nName.matches("[_a-zA-Z]\\w*")) {

                view.showErrorMessage("There is a mistake in Nickname!");
                return;
            }

            if (!hNumber.isEmpty() && !hNumber.matches("\\d+")) {

                view.showErrorMessage("There is a mistake in Home number!");
                return;
            }

            if (!mobile.isEmpty() && !mobile.matches("\\d+")) {

                view.showErrorMessage("There is a mistake in Mobile!");
                return;
            }

            if (!mobile2.isEmpty() && !mobile2.matches("\\d+")) {

                view.showErrorMessage("There is a mistake in Mobile2!");
                return;
            }

            if (email.isEmpty() || !email.matches("[_a-z]([a-z]*|_[a-z]|\\.[a-z])*@[a-z]+\\.[a-z]+")) {

                view.showErrorMessage("There is a mistake in E-mail!");
                return;
            }

            if (!skype.isEmpty() && !skype.matches("[_a-zA-Z](\\w|\\.\\w)*")) {

                view.showErrorMessage("There is a mistake in Skype!");
                return;
            }

            if (index.isEmpty() || !index.matches("[0-9a-zA-Z]+")) {

                view.showErrorMessage("There is a mistake in Index!");
                return;
            }

            if (city.isEmpty() || !city.matches("[A-Z][a-z]*")) {

                view.showErrorMessage("There is a mistake in City!");
                return;
            }

            if (street.isEmpty() || !street.matches("([A-Za-z]|[A-Za-z]\\.? ?)+")) {

                view.showErrorMessage("There is a mistake in Street!");
                return;
            }

            if (house.isEmpty() || !house.matches("\\d+[a-zA-Z]?")) {

                view.showErrorMessage("There is a mistake in House!");
                return;
            }

            if (!apartment.isEmpty() && !apartment.matches("\\d+[a-zA-Z]?")) {

                view.showErrorMessage("There is a mistake in Apartment!");
                return;
            }

            if (nName.isEmpty()) nName = fName;

            AddressBookRecord record = new AddressBookRecord(
                    fName, lName, nName, hNumber, mobile, mobile2, email, skype,
                    new Address(
                            index, city, street, house, apartment),
                    comment, group);

            // Check if already exists
            if (model.contains(record)) {

                AddressBookRecord updatedRecord = model.update(record);
                view.setOutput(updatedRecord.toString());

                view.showMessage("Record was successfully updated!", "Attention!");
                return;
            }

            model.addNewRecord(record);

            view.setOutput(record.toString());

            //view.clearAllFields();
        }
    }

    private class ShowRecords extends ButtonBase {


        @Override
        public void actionPerformed(ActionEvent e) {

            getTextFields();

            String templateAll = ".*";

            AddressBookRecord recordTemplate = new AddressBookRecord(
                    fName.concat(templateAll), lName.concat(templateAll),
                    nName.concat(templateAll), hNumber.concat(templateAll),
                    mobile.concat(templateAll), mobile2.concat(templateAll),
                    email.concat(templateAll), skype.concat(templateAll),
                    new Address(
                            index.concat(templateAll), city.concat(templateAll),
                            street.concat(templateAll), house.concat(templateAll),
                            apartment),
                    comment.concat(templateAll), group);

            ArrayList listOfMatches = model.getAllMatches(recordTemplate);

            StringBuilder outStr = new StringBuilder("");
            int i = 0;

            for (Object record : listOfMatches) {

                i++;
                outStr.append("Match ").append(i).append(":\n").append(record).append("\n\n");
            }

            view.showMessage("Found " + i + " matches!", "Attention!");

            view.setOutput(outStr.toString());
        }
    }

}
