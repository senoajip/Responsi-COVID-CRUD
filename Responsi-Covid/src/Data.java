/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class Data {
    private int id;
    private String negara;
    private String waktu;
    private int konfirmasi;
    private int sembuh;
    private int meninggal;
    

    public Data(int id, String negara, int konfirmasi, int sembuh, int meninggal, String waktu){
        this.id = id;
        this.negara = negara;
        this.konfirmasi = konfirmasi;
        this.sembuh = sembuh;
        this.meninggal = meninggal;
        this.waktu=waktu;
    }

    public int getId(){
        return id;
    }
    
    public String getNegara() {
        return negara;
    }
    
    public String getWaktu() {
        return waktu;
    }

    public int getKonfirmasi() {
        return konfirmasi;
    }

    public int getSembuh() {
        return sembuh;
    }

    public int getMeninggal() {
        return meninggal;
    }

}

