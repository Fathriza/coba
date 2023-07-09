package ProjectEcoBites.Model;

public class Konsumen {
    private String nama;
    private String email;
    private String password;
    private ArrayList<Produk> orderan;
    private boolean pilih;
    
    public Konsumen(String nama, String email, String password ){
        this.nama = nama;
        this.email= email;
        this.password=password;
    }
    
    public void setnama(String nama){
        this.nama=nama;
    }
     public void setemail(String email){
        this.email=email;
    }
     public void setpassword(String password){
        this.password=password;
    }
     public void setorderan(ArrayList<Produk> orderan){
        this.orderan=orderan;
    }
    public void setpilih(boolean pilih){
        this.pilih = pilih;
    }


    public ArrayList<Produk> getorderan(){
        return orderan;
    }
    public String getnama(){
        return nama;
    }
    public String getemail(){
        return email;
    }
    public String getpassword(){
        return password;
    }
    public boolean getpilih(){
        return  pilih ;
    }
}

