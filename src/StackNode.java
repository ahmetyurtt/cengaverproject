import model.Song;

public class StackNode {
    Song song;
    StackNode next;

//Constructor
    public StackNode(Song song){
        this.song=song; //Dışarıdan gelen şarkı buraya geliyor
        this.next=null; //ilk oluşturulduğunda sonrası boş
    }


}
