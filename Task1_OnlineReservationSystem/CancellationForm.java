import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CancellationForm extends JFrame
        implements ActionListener {

    JTextField pnrField;
    JButton cancelBtn;

    CancellationForm() {

        setTitle("Cancel Ticket");

        pnrField = new JTextField();
        cancelBtn = new JButton("Cancel");

        pnrField.setBounds(100,50,150,30);
        cancelBtn.setBounds(120,100,100,30);

        add(pnrField);
        add(cancelBtn);

        cancelBtn.addActionListener(this);

        setLayout(null);
        setSize(350,250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "DELETE FROM reservation WHERE pnr=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1,
                    Integer.parseInt(
                            pnrField.getText()));

            int row = ps.executeUpdate();

            if(row > 0) {
                JOptionPane.showMessageDialog(this,
                        "Ticket Cancelled");
            } else {
                JOptionPane.showMessageDialog(this,
                        "PNR Not Found");
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}