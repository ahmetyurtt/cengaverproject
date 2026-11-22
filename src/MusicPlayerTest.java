import model.Song;
import playlist.DoublyLinkedPlaylist;



//istek akışı gösterimi : önce istekler çalar, bitince çalma lisesine dönülür.
public class MusicPlayerTest {public static void main(String[] args) {
    DoublyLinkedPlaylist liste = new DoublyLinkedPlaylist("Test Listesi");

    liste.addLast(new Song(1, "Liste Sarki 1", "Sanatci A", 200));
    liste.addLast(new Song(2, "Liste Sarki 2", "Sanatci B", 210));
    liste.addLast(new Song(2, "Liste Sarki 3", "Sanatci C", 220));
    
    MusicPlayer player = new MusicPlayer(liste);

    System.out.println(" ====== Normal Liste ======");
    player.playNext();   //Liste 1 

    System.out.println("\n=== 3 İstek Geldi ===");
    player.addRequest(new Song(1, "Istek 1", "Sanatci 1", 180));
    player.addRequest(new Song(2, "Istek 2", "Sanatci 2", 190));
    player.addRequest(new Song(3, "Istek 3", "Sanatci 3", 200));
    
player.cancelRequest(11); //ortadaki istek iptal

System.out.println("\n Istekler bitene kadar");
player.playNext(); //istek 1
player.playNext(); //istek 3

System.out.println("\n Listeye donus ");
player.playNext(); //istek 2
player.playNext(); //istek 3

System.out.println("\n Her sey bitti");
player.playNext(); //uyarı
}
}
