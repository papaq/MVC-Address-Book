package AddressBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class AddressBookView extends JFrame{

    private JPanel inputs = new JPanel();

    private JTextField firstName = new JTextField(10);
    private JTextField lastName = new JTextField(10);
    private JTextField nickName = new JTextField(10);

    private JTextField homeNumber = new JTextField(10);
    private JTextField mobile = new JTextField(12);
    private JTextField mobile2 = new JTextField(12);
    private JTextField email = new JTextField(15);
    private JTextField skype = new JTextField(10);

    private JTextField index = new JTextField(5);
    private JTextField city = new JTextField(10);
    private JTextField street = new JTextField(10);
    private JTextField house = new JTextField(3);
    private JTextField apartment = new JTextField(4);

    private JTextArea output = new JTextArea();


    private JTextArea comment = new JTextArea(5, 20);

    private JComboBox group = new JComboBox();

    private JButton buttonAddRecord = new JButton("Add");
    private JButton buttonShowRecords = new JButton("Show");

    AddressBookView() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setSize(650,500);
        this.setMinimumSize(new Dimension(650, 500));
        this.setTitle("Address book");

        inputs.setBackground(new Color(200,200,200));

        inputs.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.fill = GridBagConstraints.NONE;
        inputs.add(new JLabel("First name *"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Last name *"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Nickname"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Home number"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Mobile"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Mobile2"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("E-mail *"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Skype"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Index *"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("City *"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Street *"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("House *"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Apartment"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Group *"), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Comment"), gbc);

        gbc.gridy++;
        inputs.add(buttonAddRecord, gbc);
        gbc.gridx++;
        inputs.add(buttonShowRecords, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputs.add(firstName, gbc);
        gbc.gridy++;
        inputs.add(lastName, gbc);
        gbc.gridy++;
        inputs.add(nickName, gbc);
        gbc.gridy++;
        inputs.add(homeNumber, gbc);
        gbc.gridy++;
        inputs.add(mobile, gbc);
        gbc.gridy++;
        inputs.add(mobile2, gbc);
        gbc.gridy++;
        inputs.add(email, gbc);
        gbc.gridy++;
        inputs.add(skype, gbc);
        gbc.gridy++;
        inputs.add(index, gbc);
        gbc.gridy++;
        inputs.add(city, gbc);
        gbc.gridy++;
        inputs.add(street, gbc);
        gbc.gridy++;
        inputs.add(house, gbc);
        gbc.gridy++;
        inputs.add(apartment, gbc);
        gbc.gridy++;
        inputs.add(group, gbc);
        gbc.gridy++;
        inputs.add(new JScrollPane(comment), gbc);





        output.setEditable(false);

        JPanel wholeWindow = new JPanel(new GridLayout(1,2));

        wholeWindow.add(inputs);
        wholeWindow.add(new JScrollPane(output));


        this.add(wholeWindow);
    }

    String getFirstName() {

        return firstName.getText();
    }

    String getLastName() {

        return lastName.getText();
    }

    String getNickame() {

        return nickName.getText();
    }

    String getHomeNumber() {

        return homeNumber.getText();
    }

    String getMobile() {

        return mobile.getText();
    }

    String getMobile2() {

        return mobile2.getText();
    }

    String getEMail() {

        return email.getText();
    }

    String getSkype() {

        return skype.getText();
    }

    String getIndex() {

        return index.getText();
    }

    String getCity() {

        return city.getText();
    }

    String getStreet() {

        return street.getText();
    }

    String getHouse() {

        return house.getText();
    }

    String getApartment() {

        return apartment.getText();
    }

    int getGroup() {

        return group.getSelectedIndex();
    }

    String getComment() {

        return comment.getText();
    }

    void setAddButtonListener(ActionListener listener) {

        buttonAddRecord.addActionListener(listener);
    }

    void setShowButtonListener(ActionListener listener) {

        buttonShowRecords.addActionListener(listener);
    }

    void setGroupItems(Object[] items) {

        for (Object item : items)
            group.addItem(item.toString());

        group.setSelectedIndex(group.getItemCount() - 1);
    }

    void setOutput(String text) {

        output.setText(text);
    }

    void showErrorMessage(String message) {

        JOptionPane.showMessageDialog(this, message,"Error!", 0);
    }

    void showMessage(String message, String title) {

        JOptionPane.showMessageDialog(this, message, title, 0);
    }

    void clearAllFields() {

        for (Component tf : inputs.getComponents()) {
            if (tf.getClass().toString().equals("class javax.swing.JTextField"))
                ((JTextField) tf).setText("");

            if (tf.getClass().toString().equals("class javax.swing.JTextArea"))
                ((JTextArea) tf).setText("");
        }
    }
}
