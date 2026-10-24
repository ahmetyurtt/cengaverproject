import javax.swing.JFrame;

//Uygulamanın Ana Swing Ekranı

public class MainFrame extends JFrame{
    //Constructor
    public MainFrame(){
        setTitle("CENGaverler Müzik Uygulaması");//Başlık
        
        setSize(1200,800);//Ekran Büyüklüğü
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Kapatma Tuşu

        setLocationRelativeTo(null);//Ekranı ortalar

        setVisible(true);//Ekranın görünmesini sağlar
        

    }

   //Ana kod
   public static void main(String[] args){
    
    
   
new MainFrame();
}

}
