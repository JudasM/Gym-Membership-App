        
package za.ac.tut;

import das.moh.Member;
import das.moh.MemberDB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class calculator extends JFrame{
    
    private final JPanel mainPnl;
    private final JPanel clientPnl;
    private final JPanel contractPnl;
    private JPanel textAreaPnl;
    private JLabel textAreaLbl;
    private JTextArea comments;
    private JPanel buttonsPnl;
    private final JLabel headingLbl;
    private final JPanel headingPnl;
    private final JPanel namePnl;
    private final JPanel surnamePnl;
    private final JPanel idNoPnl;
    private final JPanel genderPnl;
    private final JPanel typeContractPnl;
    private final JLabel nameLbl;
    private final JLabel surnameLbl;
    private final JLabel idNoLbl;
    private final JLabel gender;
    private final JTextField nameTxtfld;
    private final JTextField surnameTxtfld;
    private final JTextField idNoTxtfld;
    private final JComboBox chooseGender;
    private final JLabel typeOfContractLbl;
    private final JRadioButton halfYearly;
    private final JRadioButton perMonth;
    private final JRadioButton yearly;
    private final ButtonGroup group;
    private final JPanel personlPnl;
    private final JLabel trainerLbl;
    private final JCheckBox personlCheck;
    private final JButton apply;
    private final JButton clear;
    private final JButton exit;
    private final JButton displayALL;
    
    private final JPanel nextPnl;
    private File file;
    
   
    
    public calculator()
    {
        showInformation click = new showInformation();
       // String[] arraygender = {"Male,Female,BiSexual,Gay,Lesbian,TransGender"};
        headingPnl = new JPanel(new FlowLayout());
        headingLbl = new JLabel("Membership Form");
        headingLbl.setBorder(new BevelBorder(BevelBorder.RAISED));
        headingLbl.setFont(new Font("Arial",Font.ITALIC,23));
        headingLbl.setForeground(Color.BLUE);
        headingPnl.add(headingLbl);
        
        mainPnl = new JPanel(new BorderLayout());
        clientPnl = new JPanel(new GridLayout(4, 1, 1, 1));
        clientPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1), "Client details"));
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idNoPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        //Contract OptionsPanel
        contractPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contractPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Contract Options"));
        typeContractPnl = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        typeOfContractLbl = new JLabel("Type of Contract: ");
       
        
        perMonth = new JRadioButton("Month-to-Month");
      //  perMonth.addActionListener(click);
        halfYearly = new JRadioButton("Six-Months");
      //  halfYearly.addActionListener(click);
        yearly = new JRadioButton("Annual");
      //  yearly.addActionListener(click);
        
        group = new ButtonGroup();
        group.add(perMonth);
        group.add(halfYearly);
        group.add(yearly);
        
        typeContractPnl.add(perMonth);
        typeContractPnl.add(halfYearly);
        typeContractPnl.add(yearly);
        
        personlPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        trainerLbl = new JLabel("Select the checkbox if you need a personal trainer: ");
        personlCheck = new JCheckBox("yes", false);
        
        personlPnl.add(trainerLbl);
        personlPnl.add(personlCheck);
        
        //nextPanel
        nextPnl = new JPanel(new GridLayout(4, 1));
        nextPnl.setBackground(Color.BLUE);
        nextPnl.setVisible(false);
        
        //contracts option main panel
        contractPnl.add(typeOfContractLbl);
        contractPnl.add(typeContractPnl);
        contractPnl.add(personlPnl);
        
        //textArea Panel
        
        textAreaPnl = new JPanel(new BorderLayout());
        textAreaPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"Comments"));
        comments = new JTextArea(13,10);
        comments.setEditable(false);
        textAreaPnl.add(comments);
        
        
        //buttons
        
        clearBtn wipe = new clearBtn();
        exitBtn Exit = new exitBtn();
        nextBtn page1 =  new nextBtn();
        buttonsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        apply = new JButton("Apply");
        apply.addActionListener(click);
        
        exit = new JButton("Exit");
        exit.addActionListener(Exit);
        displayALL = new JButton("Display");
        displayALL.addActionListener(page1);
        
        
        
        clear = new JButton("Clear");
        clear.addActionListener(wipe);
        
        buttonsPnl.add(apply);
        buttonsPnl.add(clear);
        buttonsPnl.add(displayALL);
        buttonsPnl.add(exit);
        
        //lables
        nameLbl = new JLabel("Name:      ");
        surnameLbl = new JLabel("Surname: ");
        idNoLbl = new JLabel("Id no:       ");
        gender = new JLabel("Gender:     ");
        
        //checkBox
        chooseGender = new JComboBox();
        chooseGender.addItem("Male");
        chooseGender.addItem("Female");
        chooseGender.addItem("BiSexual");
        chooseGender.addItem("Gay");
       
       
        
        //textFlds
        nameTxtfld = new JTextField(15);
        surnameTxtfld =new JTextField(15);
        idNoTxtfld = new JTextField(15);
        
        //labels to panels
        namePnl.add(nameLbl);
        namePnl.add(nameTxtfld);
        surnamePnl.add(surnameLbl);
        surnamePnl.add(surnameTxtfld);
        idNoPnl.add(idNoLbl);
        idNoPnl.add(idNoTxtfld);
        genderPnl.add(gender);
        genderPnl.add(chooseGender);
        
        
        
        clientPnl.add(namePnl);
        clientPnl.add(surnamePnl);
        clientPnl.add(idNoPnl);
        clientPnl.add(genderPnl);
        
        
        mainPnl.add(clientPnl,BorderLayout.NORTH);
        mainPnl.add(contractPnl,BorderLayout.CENTER);
        mainPnl.add(textAreaPnl,BorderLayout.SOUTH);
        
        //creating a file
        file = new File("Details.txt");
        try {
            file.createNewFile();
            
        } catch (IOException ex) {
            Logger.getLogger(calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            
        
        add(mainPnl);
        add(headingPnl,BorderLayout.NORTH);
        add(buttonsPnl,BorderLayout.SOUTH);
        setSize(500,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setResizable(false);
        pack();
        setVisible(true);
        
    }
    
    private class showInformation implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //instead of Writing to a file,we will try to save it to a database;
                /*
                String name = nameTxtfld.getText();
                String surname = surnameTxtfld.getText();
                String  idNon = idNoTxtfld.getText();
                String gender = (String)chooseGender.getSelectedItem();
                
                String message =name +" \n"+ surname +"   \n"+ idNon + " \n"+gender +"/n";
                
                //trying to write to a file
                try {
                String choice = " ";
                BufferedWriter br = new BufferedWriter(new FileWriter(file, true));
                
                if (halfYearly.isSelected()) {
                choice =  "Halfyear";
                }else if(perMonth.isSelected())
                {
                choice += "perMonth";
                }
                else if(yearly.isSelected())
                {
                choice += "Yearly";
                }
                
                String information = name +" "+surname+" "+idNon +" "+ gender + " "+choice;
                br.write(information);
                br.newLine();
                br.close();
                
                //displaying the file to the JTextArea
                comments.setText(information);
                
                // set the fields to zero.
                nameTxtfld.setText("");
                surnameTxtfld.setText("");
                idNoTxtfld.setText("");
                group.clearSelection();
                personlCheck.setSelected(false);
                
                //set focus to the nametextFild;
                
                nameTxtfld.requestFocus();
                
                
                
                } catch (IOException ex) {
                Logger.getLogger(calculator.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                /*  System.out.print("THE CHOICE IS "+choice);
                //.setText();
                JOptionPane.showMessageDialog(null, message);
                */
                
                MemberDB db = new MemberDB("jdbc:derby://localhost:1527/MembershipDB", "app", "123");
                Member member;
                member = addMember();
                db.add(member);
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(calculator.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
    
        }

        private Member addMember() {
            String name = nameTxtfld.getText();
            String surname =surnameTxtfld.getText();
            int Id = Integer.valueOf(idNoTxtfld.getText());
            String gen =(String)chooseGender.getSelectedItem();
            char gender = gen.charAt(0);
            String contract = "" ;
            if(halfYearly.isSelected())
            {
              contract = "Half-yearly";
            }
            else if(perMonth.isSelected())
            {
                contract = "Per-Month";
            }
            else if(yearly.isSelected())
            {
               contract = "Yearly";
            }
            Boolean trainer = false;
            if(personlCheck.isSelected())
            {
              trainer = true;
            }
            
            Calendar calendar = Calendar.getInstance();
            Timestamp timestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            
            Member member = new Member(name, surname, Id, gender, contract, trainer, timestamp);
          
            
            return member;
            
        }
            
    
    }
    
    private class clearBtn implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            nameTxtfld.setText("");
            surnameTxtfld.setText(" ");
            idNoTxtfld.setText(" ");
            chooseGender.setSelectedIndex(0);
            
        }
    
    }
    private class nextBtn implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            String results = " ", data;
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(file));
                 while((data = br.readLine()) != null)
            {
                 results += data + "\n";
            }
            
            } catch (FileNotFoundException ex) {
                Logger.getLogger(calculator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(calculator.class.getName()).log(Level.SEVERE, null, ex);
            }
           
          comments.setText(results);
        }
      
    }
    private class exitBtn implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);        }
       
    }
    
}
