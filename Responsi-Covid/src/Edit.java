
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class Edit extends JFrame {

    Statement statement;
    ResultSet resultSet;
    JButton bUpdate, bBack;
    JLabel lTitle;
    String[][] datas = new String[500][6];
    String[] column = {"ID","Negara", "Waktu",  "Konfirmasi", "Sembuh","Meninggal"};
    JTable tTable;
    JScrollPane scrollPane;

    public Edit() throws ClassNotFoundException, SQLException {
        setTitle("EDIT DATA");
        lTitle = new JLabel ("Data COVID-19");
        lTitle.setFont(new Font("Regular", Font.BOLD, 18));
        lTitle.setForeground(new Color(158, 158, 230));
        bUpdate = new JButton ("Edit");
        bUpdate.setFont(new Font("Regular", Font.PLAIN, 14));
        bUpdate.setBackground(new Color(158, 158, 230));
        bBack = new JButton ("Kembali");
        bBack.setFont(new Font("Regular", Font.PLAIN, 14));
        bBack.setBackground(new Color(158, 158, 230));
        tTable = new JTable(datas, column);
        tTable.setBackground(new Color(158, 158, 230));
        scrollPane = new JScrollPane(tTable);
        scrollPane.setBackground(new Color(158, 158, 230));

        getContentPane().setBackground(new Color(245, 245, 245));

        
        setSize (570,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(null);
        add(lTitle);
        add(bUpdate);
        add(bBack);
        add(scrollPane);

        lTitle.setBounds(185, 30, 300, 30);
        scrollPane.setBounds(70, 70, 400, 400);
        bUpdate.setBounds(170, 490, 90, 25);
        bBack.setBounds(280, 490, 90, 25);

        Koneksi connec = new Koneksi();
        statement = connec.getConnection().createStatement();
        String sql = "SELECT *FROM pasien";
        resultSet = statement.executeQuery(sql);
        int row = 0;
        while (resultSet.next()){
                datas[row][0] = resultSet.getString("id");
                datas[row][1] = resultSet.getString("negara");
                datas[row][2] = resultSet.getString("waktu");
                datas[row][3] = resultSet.getString("konfirmasi");
                datas[row][4] = resultSet.getString("sembuh");
                datas[row][5] = resultSet.getString("meninggal");
            row++;
        }
        statement.close();
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });
        bUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new ProsesEdit();
            }
        });


    }

}
