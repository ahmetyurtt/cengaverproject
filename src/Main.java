import model.Song;
import playlist.DoublyLinkedPlaylist;
import playlist.PlaylistNode;

public class Main {
    public static void main(String[] args) {
        //Bir şarkı nesnesi üretelim
        Song sarki1=new Song(1,"Benim Yerimede Sev","Sezen Aksu",316);
        System.out.println("Oluşturulan şarkı: "+sarki1);
        System.out.println("Şarkının adı (Getter ile): "+sarki1.getTitle());
        sarki1.setTitle("Begonvil");
        System.out.println("Güncellenmiş hali (Setter sonrası) :"+sarki1);

        System.out.println("AHMET ÇALMA LİSTESİ TEST");

        DoublyLinkedPlaylist calmalistem=new DoublyLinkedPlaylist("Ahmet'in favorileri");
        System.out.println("Liste adı: "+ calmalistem.getName());
        System.out.println("Listedeki şarkı sayısı: "+calmalistem.getSize());
        //çalma listesi oluşturuldu adı ve içindeki şarkı sayısı ekrana basıldı
        Song sarki2=new Song(2,"KTS","manifest",250);

        PlaylistNode vagon1 = new PlaylistNode(sarki1);
        PlaylistNode vagon2 = new PlaylistNode(sarki2);
        //şarkılar yerleştirildi oynatma listesine
        vagon1.next = vagon2;
        vagon2.prev = vagon1;
        //birbirlerine bağladık
        System.out.println("1. vagondaki şarkı: "+vagon1.song.getTitle());
        System.out.println("1. vagondan next e basılınca: "+ vagon1.next.song.getTitle());
        System.out.println("2. vagonda prev e basılırsa: "+ vagon2.prev.song.getTitle());
    }
}