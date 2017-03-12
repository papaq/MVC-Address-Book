package AddressBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class AddressBookController {

    private AddressBookView view;
    private AddressBookModel model;

    AddressBookController(AddressBookView view, AddressBookModel model) {

        this.view = view;
        this.model = model;

        ArrayList groupList = new ArrayList();
        for (AddressBookRecord.Groups group : AddressBookRecord.Groups.values())
            groupList.add(group);

        this.view.setGroupItems(groupList.toArray());
        this.view.setAddButtonListener(new AddNewRecord());
        this.view.setShowButtonListener(new ShowRecords());
    }

    private class AddNewRecord implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String fName = view.getFirstName().trim();
            String lName = view.getLastName().trim();
            String nName = view.getNickame().trim();
            String hNumber = view.getHomeNumber().trim().replaceAll("\\)|\\(|-|\\+", "");
            String mobile = view.getMobile().trim().replaceAll("\\)|\\(|-|\\+", "");
            String mobile2 = view.getMobile2().trim().replaceAll("\\)|\\(|-|\\+", "");
            String email = view.getEMail().trim();
            String skype = view.getSkype().trim();
            String index = view.getIndex().trim().replace("-", "");
            String city = view.getCity().trim();
            String street = view.getStreet().trim();
            String house = view.getHouse().trim();
            String apartment = view.getApartment().trim();
            String comment = view.getComment().trim();
            int group = view.getGroup();


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

            if (email.isEmpty() || !email.matches("[_a-zA-Z]\\w*@[a-zA-Z]+\\.[a-zA-Z]+")) {

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
                            index, city, street, house,
                            apartment.isEmpty() ? null : Integer.parseInt(apartment)),
                    comment, group);

            // Check if already exists
            /*
            if () {

                return;
            }
            */

            model.addNewRecord(record);

            view.setOutput(model.lastRecord());

            view.clearAllFields();
        }
    }

    private class ShowRecords implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
