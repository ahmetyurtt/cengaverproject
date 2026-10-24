package playlist;

import model.Song;

public class PlaylistNode{
    public Song song;
    public PlaylistNode prev;
    public PlaylistNode next;
    //vagonun içindeki şarkı,önceki ve sonraki tanımlandı
    public PlaylistNode(Song song){
        this.song = song;
        this.prev = null;
        this.next = null;
    }//şuanlık şarkılar boş sonradan eklenecek

}