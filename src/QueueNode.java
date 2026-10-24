import model.Song;
/*Kuyruktaki tek bir düğümü ,bir şarkıyı ve sıradaki düğümün refereansını tutar. */
public class QueueNode {
    Song song; // Bu düğümün tuttuğu şarkıdır.
    QueueNode next; // Bu kuyrukta sonraki düğüm içindir.

    public QueueNode(Song song){
        this.song = song;
        this.next = null;
    }
}
