package ProjectEcoBites;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author andhika
 */
public class OpenScene {
    private Pane halaman;
    
    public Pane getPane(String fileName){
        try{
            URL fileHalaman=Main.class.getResource("/ProjectEcoBites/View"+fileName+".fxml");
            
            if(fileHalaman==null){
                throw new java.io.FileNotFoundException("Halaman tidak ditemukan");
            }
            
            halaman=new FXMLLoader().load(fileHalaman);
            
        }catch (Exception e){
       
            System.out.println("Tidak ditemukan halaman tersebut");
        }
        
        return halaman;
    }
}
