import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
//Uygulamanın Ana Swing Ekranı

public class MainFrame extends JFrame{
    //Constructor
    public MainFrame(){
        setTitle("CENGaverler Müzik Uygulaması");//Başlık
        
        setSize(900,600);//Ekran Büyüklüğü
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Kapatma Tuşu

        setLocationRelativeTo(null);//Ekranı ortalar

        //Arayüz renkleri değiştirmek için gerkli kodlar
        Color bgDark = new Color(11, 16, 31);       //  Arka Plan
        Color panelDark = new Color(21, 29, 51);    // Panel İçi 
        Color textColor = new Color(241, 245, 249);  // Beyaz Yazı
        Color accentColor = new Color(56, 189, 248); // Açık Mavi Vurgu

        getContentPane().setBackground(bgDark);

        JTabbedPane tabbedPane=new JTabbedPane();
        tabbedPane.setBackground(panelDark);
        tabbedPane.setForeground(textColor);
        tabbedPane.setFont(new Font("SansSerif",Font.BOLD,14));

        JPanel catalogPanel = createStyledPanel("Şarkı Kataloğu Paneli", panelDark, accentColor);//Katalog paneli (Eren)

        JPanel playlistPanel = createStyledPanel(" Çalma Listeleri Paneli", panelDark, accentColor);//Çalmalistesi paneli(Ahmet)

        JPanel queuePanel = createStyledPanel("İstek Kuyruğu Paneli", panelDark, accentColor); //istek sırası paneli(Yusuf)

        JPanel historyJPanel = createStyledPanel(" Dinleme Geçmişi Paneli", panelDark, accentColor);//Dinleme geçmişi paneli(Yunus)

    

        //sekmeler
        tabbedPane.addTab("Sarkı Katalogu", catalogPanel);
        tabbedPane.addTab("Calma Liseleri", playlistPanel);
        tabbedPane.addTab("İstek Kuyrugu", queuePanel);
        tabbedPane.addTab("Dinleme Geçmişi", historyJPanel);

        //sekmeleri ana ekrana ekler
        add(tabbedPane);
        
        setVisible(true);//Ekranın görünmesini sağlar
        

    }
private JPanel createStyledPanel(String titleText,Color bgColor, Color accentColor){
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBackground(bgColor);

    JLabel label = new JLabel(titleText, SwingConstants.CENTER);
    label.setForeground(accentColor);
    label.setFont(new Font("SansSerif",Font.BOLD,22));
    panel.add(label,BorderLayout.CENTER);
    return panel;

}

   //Ana kod
   public static void main(String[] args){
    
    
   
new MainFrame();
}

}
