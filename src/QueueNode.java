import model.Song;
public class QueueNode {
    Song song;
    QueueNode next;

    public QueueNode(Song song){
        this.song = song;
        this.next = null;
    }
}
