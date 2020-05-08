
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class CreateData extends JFrame{
    JLabel lTitle, lNegara, lKonfirmasi, lSembuh, lMeninggal,lWaktu,lId;
    JTextField fNegara, fKonfirmasi, fSembuh, fMeninggal,fWaktu,fId;
    JButton bSave, bBack;
    Statement statement;
    String negara,waktu ;
    int konfirmasi, meninggal,sembuh,id;

    public CreateData(){
        setTitle("INPUT DATA");
        lTitle = new JLabel("Input Data");
        lTitle.setFont(new Font("Regular", Font.BOLD, 18));
        lTitle.setForeground(new Color(0, 0, 0));
        
        lId = new JLabel("ID ");
        lId.setFont(new Font("Regular", Font.PLAIN, 18));
        lId.setForeground(new Color(0, 0, 0));
        fId = new JTextField();
        fId.setFont(new Font("Regular", Font.PLAIN, 16));
        fId.setForeground(new Color(0, 0, 0));
        fId.setBackground(new Color(255, 255, 240));
        
        lNegara = new JLabel("Negara ");
        lNegara.setFont(new Font("Regular", Font.PLAIN, 18));
        lNegara.setForeground(new Color(0, 0, 0));
        fNegara = new JTextField();
        fNegara.setFont(new Font("Regular", Font.PLAIN, 16));
        fNegara.setForeground(new Color(0, 0, 0));
        fNegara.setBackground(new Color(247, 252, 255));
        
        lWaktu = new JLabel("Waktu ");
        lWaktu.setFont(new Font("Regular", Font.PLAIN, 18));
        lWaktu.setForeground(new Color(0, 0, 0));
        fWaktu = new JTextField();
        fWaktu.setFont(new Font("Regular", Font.PLAIN, 16));
        fWaktu.setForeground(new Color(0, 0, 0));
        fWaktu.setBackground(new Color(247, 252, 255));
        
        lKonfirmasi = new JLabel("Konfirmasi ");
        lKonfirmasi.setFont(new Font("Regular", Font.PLAIN, 18));
        lKonfirmasi.setForeground(new Color(0, 0, 0));
        fKonfirmasi = new JTextField();
        fKonfirmasi.setFont(new Font("Regular", Font.PLAIN, 16));
        fKonfirmasi.setForeground(new Color(0, 0, 0));
        fKonfirmasi.setBackground(new Color(247, 252, 255));
        
        lSembuh = new JLabel("Sembuh ");
        lSembuh.setFont(new Font("Regular", Font.PLAIN, 18));
        lSembuh.setForeground(new Color(0, 0, 0));
        fSembuh = new JTextField();
        fSembuh.setFont(new Font("Regular", Font.PLAIN, 16));
        fSembuh.setForeground(new Color(0, 0, 0));
        fSembuh.setBackground(new Color(247, 252, 255));
        
        lMeninggal = new JLabel("Meninggal ");
        lMeninggal.setFont(new Font("Regular", Font.PLAIN, 18));
        lMeninggal.setForeground(new Color(0, 0, 0));
        fMeninggal = new JTextField();
        fMeninggal.setFont(new Font("Regular", Font.PLAIN, 16));
        fMeninggal.setForeground(new Color(0, 0, 0));
        fMeninggal.setBackground(new Color(247, 252, 255));
        
        

        bSave = new JButton("Input");
        bSave.setFont(new Font("Regular",Font.PLAIN, 14));
        bSave.setBackground(new Color(247, 252, 255));
        bBack = new JButton("Kembali");
        bBack.setFont(new Font("Regular",Font.PLAIN, 14));
        bBack.setBackground(new Color(247, 252, 255));

        getContentPane().setBackground(new Color(245, 245, 245));

        setLayout(null);
        add(lTitle);
        add(lId);
        add(fId);
        add(lNegara);
        add(fNegara);
        add(lKonfirmasi);
        add(fKonfirmasi);
        add(lSembuh);
        add(fSembuh);
        add(lMeninggal);
        add(fMeninggal);
        add(lWaktu);
        add(fWaktu);
        add(bSave);
        add(bBack);

        lTitle.setBounds(30, 20, 250, 30);
        lId.setBounds(30, 70, 120, 30);
        fId.setBounds(130, 73,270,25);
        lNegara.setBounds(30, 110, 120, 30);
        fNegara.setBounds(130, 110, 270, 30);
        lKonfirmasi.setBounds(30, 150, 120, 30);
        fKonfirmasi.setBounds(130, 153, 270, 25);
        lSembuh.setBounds(30, 190, 120, 30);
        fSembuh.setBounds(130, 193, 270, 25);
        lMeninggal.setBounds(30, 230, 120, 30);
        fMeninggal.setBounds(130, 233, 270, 25);
        lWaktu.setBounds(30, 270, 120, 30);
        fWaktu.setBounds(130, 273, 270, 25);
        bSave.setBounds(130, 300, 90, 30);
        bBack.setBounds(230, 300, 90,30);

        setSize(440, 450);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    id = Integer.parseInt(fId.getText());
                    negara = fNegara.getText();
                    konfirmasi = Integer.parseInt(fKonfirmasi.getText());
                    sembuh = Integer.parseInt(fSembuh.getText());
                    meninggal = Integer.parseInt(fMeninggal.getText());
                    waktu=fWaktu.getText();

                    Data data = new Data(id,negara,  konfirmasi ,sembuh, meninggal,waktu);

                    Koneksi connect = new Koneksi();
                    try {
                        statement = connect.getConnection().createStatement();
                        statement.executeUpdate("INSERT INTO pasien VALUES('" + data.getId() + "','" +  data.getNegara() + "','" + data.getWaktu() + "','" + data.getKonfirmasi() + "','" + data.getSembuh() + "','" + data.getMeninggal() + "')");
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan");
                    } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(CreateData.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(CreateData.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
                }catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
                }

                setVisible(false);
            }
        });

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });
    }
}
