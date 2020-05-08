
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ProsesEdit extends JFrame {
     JLabel lTitle, lNegara, lKonfirmasi, lSembuh, lMeninggal,lWaktu,lId,lNote;
    JTextField fNegara, fKonfirmasi, fSembuh, fMeninggal,fWaktu,fId;
    JButton bSave, bBack;
    Statement statement;

    public ProsesEdit() {

        setTitle("EDIT DATA");
        lTitle = new JLabel("Edit Berdasarkan ID");
        lTitle.setFont(new Font("Regular", Font.PLAIN, 20));
        lTitle.setForeground(new Color(247, 252, 255));
        
        lId = new JLabel("ID ");
        lId.setFont(new Font("Regular", Font.PLAIN, 18));
        lId.setForeground(new Color(247, 252, 255));
        fId = new JTextField();
        fId.setFont(new Font("Regular", Font.PLAIN, 16));
        fId.setForeground(new Color(0, 0, 255));
        fId.setBackground(new Color(247, 252, 255));
        
        lNegara = new JLabel("Negara ");
        lNegara.setFont(new Font("Regular", Font.PLAIN, 18));
        lNegara.setForeground(new Color(247, 252, 255));
        fNegara = new JTextField();
        fNegara.setFont(new Font("Regular", Font.PLAIN, 16));
        fNegara.setForeground(new Color(0, 0, 255));
        fNegara.setBackground(new Color(247, 252, 255));
        
        lKonfirmasi = new JLabel("Konfirmasi ");
        lKonfirmasi.setFont(new Font("Regular", Font.PLAIN, 18));
        lKonfirmasi.setForeground(new Color(247, 252, 255));
        fKonfirmasi = new JTextField();
        fKonfirmasi.setFont(new Font("Regular", Font.PLAIN, 16));
        fKonfirmasi.setForeground(new Color(0, 0, 255));
        fKonfirmasi.setBackground(new Color(247, 252, 255));
        
        lSembuh = new JLabel("Sembuh ");
        lSembuh.setFont(new Font("Regular", Font.PLAIN, 18));
        lSembuh.setForeground(new Color(247, 252, 255));
        fSembuh = new JTextField();
        fSembuh.setFont(new Font("Regular", Font.PLAIN, 16));
        fSembuh.setForeground(new Color(0, 0, 255));
        fSembuh.setBackground(new Color(247, 252, 255));
        
        lMeninggal = new JLabel("Meninggal ");
        lMeninggal.setFont(new Font("Regular", Font.PLAIN, 18));
        lMeninggal.setForeground(new Color(247, 252, 255));
        fMeninggal = new JTextField();
        fMeninggal.setFont(new Font("Regular", Font.PLAIN, 16));
        fMeninggal.setForeground(new Color(0, 0, 255));
        fMeninggal.setBackground(new Color(247, 252, 255));
        
        lWaktu = new JLabel("Waktu ");
        lWaktu.setFont(new Font("Regular", Font.PLAIN, 18));
        lWaktu.setForeground(new Color(247, 252, 255));
        fWaktu = new JTextField();
        fWaktu.setFont(new Font("Regular", Font.PLAIN, 16));
        fWaktu.setForeground(new Color(0, 0, 255));
        fWaktu.setBackground(new Color(247, 252, 255));
        
        lNote=new JLabel ("*Masukkan ID yang akan diedit");
        lNote.setFont(new Font("Regular", Font.PLAIN, 9));
        lNote.setForeground(new Color(247, 252, 255));
        bSave = new JButton("Simpan");
        bSave.setFont(new Font("Regular",Font.PLAIN, 14));
        bSave.setBackground(new Color(247, 252, 255));
        bBack = new JButton("Kembali");
        bBack.setFont(new Font("Regular",Font.PLAIN, 14));
        bBack.setBackground(new Color(247, 252, 255));
        
        
        
        getContentPane().setBackground(new Color(47, 79, 79));

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
        add(lNote);
        add(bSave);
        add(bBack);

        lTitle.setBounds(120, 20, 250, 30);
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
        lNote.setBounds(30, 310, 270, 25);
        bSave.setBounds(120, 350, 90, 30);
        bBack.setBounds(220, 350, 90,30);

        setSize(440, 450);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                btnUpdateactionListener();
            }

            private void btnUpdateactionListener() {
                Koneksi connec = new Koneksi();
                try {
                    statement = connec.getConnection().createStatement();
                    statement.executeUpdate("UPDATE pasien SET  waktu='" +
                            fWaktu.getText() + "'," + "negara='" + fNegara.getText() + "'," + "konfirmasi='" + fKonfirmasi.getText() + "'," + "sembuh='" + fSembuh.getText() + "'," + "meninggal='" + fMeninggal.getText() + "'    WHERE id='" + fId.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Data berhasil di Update!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
                    statement.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Data gagal diupdate!", "Hasil", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        bBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                try {
                    new Edit();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ProsesEdit.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ProsesEdit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
