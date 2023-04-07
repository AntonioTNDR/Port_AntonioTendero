package Port_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface implements ActionListener {
    Container container = new Container();
    private String[] countriesList = {"Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France","Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Romania", "Slovenia", "Spain", "Sweden"};
    private ButtonGroup bg;
    private JComboBox countries;
    private JComboBox countries2;
    private JTextField IDfield;
    private JTextField Weightfield;
    private JTextArea Description;
    private JTextField textRemitent;
    private JTextField textReciver;
    private JButton Pile;
    private JButton unPile;
    private JTextField Col_num;
    private JTextField containerNum;
    private JButton showDescription;
    private JTextArea buttShowDesc;
    private JButton numContainers;
    private JRadioButton priority1;
    private JRadioButton priority2;
    private JRadioButton priority3;
    private JCheckBox customs;
    public Interface() {
        JPanel panel = new JPanel(); // generate new panel
        JFrame frame = new JFrame(); // generate new frame
        frame.setSize(960,720); // resolution/size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close when you press "close" on windows
        frame.setTitle("Port Manager"); // top-left title
        frame.add(panel); // adding the panel to the frame

        panel.setLayout(null);

        JLabel IDlabel = new JLabel("ID number"); // generate ID label + coordinates
        IDlabel.setBounds(10,20,80,25);
        panel.add(IDlabel);

        IDfield = new JTextField(20); // generate ID field + coordinates
        IDfield.setBounds(100,20,300,25);
        IDfield.addActionListener(this);
        panel.add(IDfield);

        JLabel Weightlabel = new JLabel("Weight (tons)"); // generate weight label + coordinates
        Weightlabel.setBounds(10,80,80,25);
        panel.add(Weightlabel);

        Weightfield = new JTextField(20); // generate weight field + coordinates
        Weightfield.addActionListener(this);
        Weightfield.setBounds(100,80,300,25);
        panel.add(Weightfield);

        JLabel textDescription = new JLabel("Description"); // label for description
        textDescription.setBounds(10, 210,80,25);
        panel.add(textDescription);

        Description = new JTextArea();
        Description.setBounds(100,120,300,250); // area where the description will be
        panel.add(Description);

        JLabel Remitent = new JLabel("Remitent company"); // Remitent label
        Remitent.setBounds(10,390,80,25);
        panel.add(Remitent);

        textRemitent = new JTextField(); // field for Remitent
        textRemitent.setBounds(100,390,300,25);
        panel.add(textRemitent);

        JLabel Reciver = new JLabel("Reciver company"); // Reciver label
        Reciver.setBounds(10,420,80,25);
        panel.add(Reciver);

        textReciver = new JTextField(); // field for Reciver
        textReciver.setBounds(100,420,300,25);
        panel.add(textReciver);

        Pile = new JButton("Pile"); // button for "pile"
        Pile.setBounds(100,450,150,30);
        Pile.setFocusable(false);
        panel.add(Pile);

        unPile = new JButton("Un-pile"); // button for "un-pile"
        unPile.setBounds(100,485,150,30);
        unPile.setFocusable(false);
        panel.add(unPile);

        Col_num = new JTextField("Column number"); // field for the column number
        Col_num.setBounds(260,485,150,30);
        panel.add(Col_num);

        showDescription = new JButton("Show description"); // button for "Show description"
        showDescription.setBounds(100,525,150,30);
        showDescription.setFocusable(false);
        panel.add(showDescription);

        buttShowDesc = new JTextArea("Show description here"); // area for the description
        buttShowDesc.setBounds(260,520,150,45);
        buttShowDesc.setEditable(false);
        panel.add(buttShowDesc);

        numContainers = new JButton("Number of containers"); // button for "Number of containers"
        numContainers.setBounds(100,570,150,30);
        numContainers.setFocusable(false);
        panel.add(numContainers);


        countries = new JComboBox(countriesList); // selectable list with all the countries
        countries.setBounds(260,570,150,30);
        countries.setFocusable(false);
        countries.addActionListener(this);
        panel.add(countries);

        JLabel country = new JLabel("Country"); // Country Label
        country.setBounds(450,20,80,25);
        panel.add(country);

        countries2 = new JComboBox(countriesList); // again the same list with all the countries
        countries2.setBounds(550,20,150,30);
        countries2.setFocusable(false);
        panel.add(countries2);

        containerNum = new JTextField("Put number here"); // Field for entering a number
        containerNum.setBounds(415, 572, 150,25);
        panel.add(containerNum);

        JLabel priority = new JLabel("Priority"); // priority label
        priority.setBounds(450,80,80,25);
        panel.add(priority);

        bg = new ButtonGroup(); // Button Group to avoid having problems with the Radio Buttons
        priority1 = new JRadioButton("1"); // radio button "priority 1"
        priority1.setBounds(550,80,50,25);
        priority1.addActionListener(this); // logic (to be implemented)
        priority1.setFocusable(false);
        panel.add(priority1);
        bg.add(priority1); // element added to the button group

        priority2 = new JRadioButton("2"); // radio button "priority 2"
        priority2.setBounds(600,80,50,25);
        priority2.addActionListener(this); // logic (to be implemented)
        priority2.setFocusable(false);
        panel.add(priority2);
        bg.add(priority2); // element added to the button group

        priority3 = new JRadioButton("3"); // radio button "priority 3"
        priority3.setBounds(650,80,50,25);
        priority3.addActionListener(this); // logic (to be implemented)
        priority3.setFocusable(false);
        panel.add(priority3);
        bg.add(priority3); // element added to the button group

        JLabel stateHP = new JLabel("State (hub plan)"); // State (hub plan) label
        stateHP.setBounds(450,210,80,25);
        panel.add(stateHP);

        JTextArea hubPlan = new JTextArea(); // Text area for "State (hub plan)"
        hubPlan.setBounds(550,120,150,100);
        panel.add(hubPlan);

        JTextArea hub2 = new JTextArea();
        hub2.setBounds(550,230,150,100);
        panel.add(hub2);

        JTextArea hub3 = new JTextArea();
        hub3.setBounds(550,340,150,100);
        panel.add(hub3);

        JLabel customsInspection = new JLabel("Customs inspection"); // Customs inspection label
        customsInspection.setBounds(450,450,80,25);
        panel.add(customsInspection);

        customs = new JCheckBox(); // Customs inspection checkbox
        customs.setBounds(550,450,50,25);
        customs.setFocusable(false);
        panel.add(customs);

        frame.setVisible(true); // Set the GUI (graphical user interface) visible

    }

    // Logic method (NOT IMPLEMENTED YET)
    @Override
    public void actionPerformed(ActionEvent e) {
        int ID = Integer.parseInt(IDfield.getText());
        container.setId(ID);

        int weight = Integer.parseInt(Weightfield.getText());
        container.setWeight(weight);

        String country = countries2.getSelectedItem().toString();
        container.setCountryOfOrigin(country);



        if(e.getSource() == priority1){
            container.setPriority(1);
            System.out.println("1");
        }
        else if(e.getSource() == priority2){
            container.setPriority(2);
            System.out.println("2");
        }
        else if(e.getSource() == priority3){
            container.setPriority(3);
            System.out.println("3");
        }


    }

}
