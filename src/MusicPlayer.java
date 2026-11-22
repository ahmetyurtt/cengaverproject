import model.Song;
import playlist.DoublyLinkedPlaylist;

/*şarkı çalma mantığını yönetir. İstek kuyruğunda şarkı varsa önce o çalar. 
İstekler bitince çalma listesinde kaldığı yerden devam eder */

public class MusicPlayer{
    private LinkedQueue requestQueue;
    //istek kuyruğu
    private DoublyLinkedPlaylist playlist;
    //normal çalma listesi
    private boolean playlistStarted;
    //çalma listesi başlatıldı mı?

public MusicPlayer(DoublyLinkedPlaylist playlist){
    this.requestQueue = new LinkedQueue();
    this.playlist = playlist;
    this.playlistStarted = false;
}

// kullanıcı istek gönderdiğinde kuyruğun sonuna eklenir.
public void addRequest(Song song){
    requestQueue.enqueue(song);
}

//istek iptali - kuyruktaki şarkıyı id'sine göre çıkarır.
public Song cancelRequest(int songId){
    return requestQueue.cancel(songId);
}

//Kuyruktaki istek varken çalma listesi yerine istek şarkısı çalar
//İstekler bitince normal çakma listesine döner.

public Song playNext() {

if(!requestQueue.isEmpty()){
    Song requested = requestQueue.dequeue();
    System.out.println("[ISTEK] Caliyor: " + requested );

    return requested;
}

Song song;

if(!playlistStarted){
    song = playlist.playFirst();
    //baştan başla
    playlistStarted = true;
}
else{
  song = playlist.nextSong();
  //kaldığı yerden devam
}

if(song != null){
    System.out.println("[LISTE] Caliyor :" + song);

    return song;
}

System.out.println("UYARI : Calinacak sarki kalmadi!");
return null;

}
}
