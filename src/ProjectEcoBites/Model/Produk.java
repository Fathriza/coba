package ProjectEcoBites.Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Produk {
    private String deskripsi;
    private int stok;
    private String nama;
    private String waktu;
    private String alamat;
    private String imagePath;
    
    
    
    public Produk(String nama, String deskripsi, String waktu, int stok, String alamat ){
        this.nama = nama;
        this.deskripsi= deskripsi;
        this.stok=stok;
        this.waktu=waktu;
        this.alamat=alamat;
   
    }
    
    public void setnama(String nama){
        this.nama=nama;
    }
     public void setdeskripsi(String deskripsi){
        this.deskripsi=deskripsi;
    }
     public void setstok(int stok){
        this.stok=stok;
    }
     public void setalamat(String alamat){
        this.alamat=alamat;
    }
    public void setwaktu(String waktu){
        this.waktu=waktu;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
 

    public String getnama(){
        return nama;
    }
    public String getdeskripsi(){
        return deskripsi;
    }
    public int getstok(){
        return stok;
    }
    public String getalamat(){
        return alamat;
    }
    public String getwaktu(){
        return waktu;
    }
     public String getImagePath() {
        return imagePath;
    }
    
    public String getImageBase64() {
        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            return base64Image;
        } catch (IOException e) {
            e.printStackTrace();
        }
         return null;
    }
}