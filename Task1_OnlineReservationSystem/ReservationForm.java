import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ReservationForm extends JFrame
        implements ActionListener {

    JTextField nameField, trainNoField,
            trainNameField, classField,
            dateField, sourceField, destField;

    JButton reserveBtn, cancelBtn;

    ReservationForm() {

        setTitle("Reservation Form");

        nameField = new JTextField();
        trainNoField = new JTextField();
        trainNameField = new JTextField();
        classField = new JTextField();
        dateField = new JTextField();
        sourceField = new JTextField();
        destField = new JTextField();

        reserveBtn = new JButton("Reserve");
        cancelBtn = new JButton("Cancel Ticket");

        nameField.setBounds(150,20,150,25);
        trainNoField.setBounds(150,50,150,25);
        trainNameField.setBounds(150,80,150,25);
        classField.setBounds(150,110,150,25);
        dateField.setBounds(150,140,150,25);
        sourceField.setBounds(150,170,150,25);
        destField.setBounds(150,200,150,25);

        reserveBtn.setBounds(70,250,100,30);
        cancelBtn.setBounds(200,250,120,30);

        add(nameField);
        add(trainNoField);
        add(trainNameField);
        add(classField);
        add(dateField);
        add(sourceField);
        add(destField);

        add(reserveBtn);
        add(cancelBtn);

        reserveBtn.addActionListener(this);

        cancelBtn.addActionListener(e -> {
            new CancellationForm();
        });

        setLayout(null);
        setSize(450,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "INSERT INTO reservation(passenger_name,train_no,train_name,class_type,journey_date,source_station,destination_station) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,nameField.getText());
            ps.setString(2,trainNoField.getText());
            ps.setString(3,trainNameField.getText());
            ps.setString(4,classField.getText());
            ps.setString(5,dateField.getText());
            ps.setString(6,sourceField.getText());
            ps.setString(7,destField.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Reservation Successful");

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}