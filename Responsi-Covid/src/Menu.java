
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class Menu extends JFrame{
    JLabel lTittle;
    JButton bCreate, bRead, bUpdate, bDelete, bExit;

    public void displayMenu(){
        setTitle("DATA COVID-19");
        lTittle = new JLabel("DATA COVID-19");
        lTittle.setFont(new Font("Regular", Font.BOLD, 18));
        //lTittle.setForeground(new Color(247, 252, 255));
        bCreate = new JButton("Input ");
        bCreate.setFont(new Font("Regular",Font.PLAIN, 16));
        bCreate.setBackground(new Color(247, 252, 255));
        bRead = new JButton("Tampil ");
        bRead.setFont(new Font("Regular",Font.PLAIN, 16));
        bRead.setBackground(new Color(247, 252, 255));
        bUpdate = new JButton("Edit ");
        bUpdate.setFont(new Font("Regular",Font.PLAIN, 16));
        bUpdate.setBackground(new Color(247, 252, 255));
        bDelete = new JButton("Hapus ");
        bDelete.setFont(new Font("Regular",Font.PLAIN, 16));
        bDelete.setBackground(new Color(247, 252, 255));
        bExit = new JButton("Exit ");
        bExit.setFont(new Font("Regular",Font.PLAIN, 16));
        bExit.setBackground(new Color(158, 158, 230));

        //getContentPane().setBackground(new Color(12, 164, 255));

        setLayout(null);
        add(lTittle);
        add(bCreate);
        add(bRead);
        add(bUpdate);
        add(bDelete);
        add(bExit);

        lTittle.setBounds(127,30,180,30);
        bCreate.setBounds(100, 80, 220, 30);
        bRead.setBounds(100, 120, 220, 30);
        bUpdate.setBounds(100, 160, 220, 30);
        bDelete.setBounds(100, 200, 220, 30);
        bExit.setBounds(100, 240, 220, 30);

        setSize(430, 370);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateData();
            }
        });
        bRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Read();
            }
        });
        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Delete();
                }catch (ClassNotFoundException classError){
                    classError.printStackTrace();
                }catch (SQLException sqlError){
                    sqlError.printStackTrace();
                }
            }
        });
        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Edit();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
