import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
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
        
        setLayout(new BorderLayout());

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

        //Alt oynatma paneli
        JPanel playerPanel = new JPanel(new BorderLayout());
        playerPanel.setBackground(new Color(15,23,42));//Ekranın altındaki çubuk
        

        //Çalan şarkı bilgisi sol tarafta
        JLabel nowPlayingLabel=new JLabel("Şuan çalan şarkı :");
        nowPlayingLabel.setForeground(accentColor);//rengini fontunu falan ayarlıyoruz
        nowPlayingLabel.setFont(new Font("SanSerif",Font.BOLD,14));
        playerPanel.add(nowPlayingLabel,BorderLayout.WEST);

        //orta taraf kontrol butonları
        JPanel controlsPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,15,10));
        controlsPanel.setBackground(new Color(15,23,42));

        //Butonlar
        JButton btnPrev=new JButton("<-- Önceki");
        JButton btnPlay=new JButton("|> Oynat");
        JButton btnNext=new JButton("Sonraki -->");

        //Buton tasarımları
        styleButton(btnPrev, panelDark, textColor);
        styleButton(btnPlay, accentColor, bgDark); // Oynat butonu belirgin mavi
        styleButton(btnNext, panelDark, textColor);

        controlsPanel.add(btnPrev);
        controlsPanel.add(btnPlay);
        controlsPanel.add(btnNext);
        playerPanel.add(controlsPanel, BorderLayout.CENTER);

        add(playerPanel,BorderLayout.SOUTH);


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
//style metodumuz
private void styleButton(JButton btn, Color bgColor, Color fgColor) {
    btn.setBackground(bgColor);
    btn.setForeground(fgColor);
    btn.setFont(new Font("SansSerif", Font.BOLD, 13));
    btn.setFocusPainted(false);
}

   //Ana kod
   public static void main(String[] args){
    
    
   
new MainFrame();
}

}
