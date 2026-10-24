package playlist;

import model.Song;

public class DoublyLinkedPlaylist{
    private String name;
    private PlaylistNode head;
    private PlaylistNode tail;
    private PlaylistNode current;
    private int size;
    //çalma listesinin genel dinamikleri tanımlandı

    public DoublyLinkedPlaylist(String name){
        this.name = name;
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0; //şarkı eklendikçe artacak
    }// ilk son ve anlık çalınan gibi değişkenler eklenmedi

    public String getName(){
        return name;
    }

    public int getSize(){
        return size;
    }
    //çalma listesinin adı ve toplam şarkı sayısı
    //private olduğundan bunlar ile döner
}