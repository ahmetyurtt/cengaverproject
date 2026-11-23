import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import model.Song;
//Uygulamanın Ana Swing Ekranı

public class MainFrame extends JFrame{

//veri yapımız ve arayüz listeleme modeli
private SongHistoryStack songHistoryStack;
private DefaultListModel<String> historyListModel;
private JLabel nowPlayingLabel;
private Song currentSong;
private int testSongCounter=1;//test için şarkı sayacı 

    //Constructor
    public MainFrame(){
        songHistoryStack = new SongHistoryStack();
        historyListModel=new DefaultListModel<>();
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
        
        //dinleme geçmişi liste paneli
        
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


        //butonlara tıklama yeteneği veren kodlar:
        btnPrev.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
                Song previousSong=songHistoryStack.pop();
                if(previousSong!=null){
                    currentSong=previousSong;
                    nowPlayingLabel.setText(" Şuan çalan:"+currentSong.toString());
                    refreshHistoryList();

                }else{
                    JOptionPane.showMessageDialog(MainFrame.this,"Dinleme geçmişi boş!", "Uyarı", JOptionPane.WARNING_MESSAGE );
                }
            }});
        

        btnPlay.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
                if(btnPlay.getText().contains(("oynat"))){
                    btnPlay.setText("Duraklat");

                }else{
                    btnPlay.setText("Oynat");
                }
            }
        });

        btnNext.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
                if(currentSong !=null){
                    songHistoryStack.push(currentSong);
                }
              currentSong = new Song(testSongCounter, "Örnek Şarkı #" + testSongCounter, "CENGaverler", 164);
                testSongCounter++;
                nowPlayingLabel.setText(" Şu An Çalan: " + currentSong.toString());
                refreshHistoryList();

            }
        });
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



private void refreshHistoryList() {
    historyListModel.clear(); // 1. Ekrandaki eski listeyi temizle
    StackNode current = songHistoryStack.getTop(); // 2. Yığının en tepesindeki şarkıyı al
    int index = 1;
    while (current != null) { // 3. Yığının sonuna kadar in
        historyListModel.addElement(index + ". " + current.song.toString()); // Ekrana ekle
        current = current.next;
        index++;
    }
}
   //Ana kod
   public static void main(String[] args){
    
    
   
new MainFrame();
}

}
