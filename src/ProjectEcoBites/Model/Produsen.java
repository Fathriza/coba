package ProjectEcoBites.Model;

public class Produsen {
    private String nama;
    private String email;
    private String password;
    
    public Produsen(String nama, String email, String password ){
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

    public String getnama(){
        return nama;
    }
    public String getemail(){
        return email;
    }
    public String getpassword(){
        return password;
    }
}