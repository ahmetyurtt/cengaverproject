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

    //çalma listesinin adı ve toplam şarkı sayısı private olduğundan bunlar ile döner

    public void addLast(Song song){

        PlaylistNode yeniVagon = new PlaylistNode(song);

        if(head == null){
            head=yeniVagon;
            tail=yeniVagon;
            //ilk ise son şarkı da ilk şarkı da o
        }else{
            tail.next = yeniVagon;
            yeniVagon.prev = tail;
            tail = yeniVagon;
        }
        size++;
    }

    public Song playFirst(){
        current = head;
        return (current != null) ? current.song : null;
    }

    public Song nextSong(){
        if(current != null && current.next != null){
            current = current.next;
            return current.song;
        }
        return null;
    }

    public Song prevSong(){
        if(current != null && current.prev != null){
            current = current.prev;
            return current.song;
        }
        return null;
    }

    public Song getCurrentSong(){
        return(current != null) ? current.song : null;
    }

    public void removeSong(Song song){
        PlaylistNode temp = head;

        while (temp != null){
            if(temp.song.getTitle().equals(song.getTitle())){


                if(temp == current){
                    if(temp.next != null){
                        current = current.next;
                    }else if(temp.prev != null){
                        current = current.prev;
                    }else{
                        current = null;
                    }
                }


                if(temp == head){//zaten tek bir şarkı varsa
                    head=temp.next;
                    if(head != null){
                        head.prev=null;
                    }else {
                        tail = null;
                    }

                }else if(temp == tail){
                    tail = temp.prev;
                    tail.next = null;

                }else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;

                }
                size--;
                break;

            }
            temp = temp.next;

        }
    }

    public void clear(){
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    public void testMethod(){
        PlaylistNode temp = tail;
        System.out.println("--TERSTEN--");
        while (temp != null){

            System.out.println(temp.song.getTitle());
            temp = temp.prev;
            //tersten şarkıların adını yazma
        }
        temp = head;
        System.out.println("--NORMAL--");
        while (temp != null){

            System.out.println(temp.song.getTitle());
            temp = temp.next;
            //baştan şarkı adları yazma
        }

    }

    public void moveUp(Song song){
        PlaylistNode temp = head;


        while (temp != null && !temp.song.getTitle().equals(song.getTitle())){
            temp = temp.next;
        }

        if(temp == null || temp.prev == null){
            return;
        }

        PlaylistNode ustteki = temp.prev;

        //üst tarafı bağlıyoruz
        if(ustteki.prev != null){
            ustteki.prev.next = temp;
        }else {
            head = temp;
        }
        temp.prev = ustteki.prev;

        //alt tarafı bağlıyoruz
        ustteki.next = temp.next;
        if(temp.next != null){
            temp.next.prev = ustteki;
        }else {
            tail = ustteki;
        }

        //en son bağlıyoruz
        temp.next = ustteki;
        ustteki.prev = temp;

    }

    public void moveDown(Song song){
        PlaylistNode temp = head;

        while (temp != null && !temp.song.getTitle().equals(song.getTitle())){
            temp = temp.next;
        }

        if(temp == null || temp.next == null){
            return;
        }

        PlaylistNode alttaki = temp.next;

        //üst tarafı bağla
        if(temp.prev == null){
            head = alttaki;
        }else {
            temp.prev.next = alttaki;
        }
        alttaki.prev = temp.prev;

        //alt tarafı bağla
        temp.next = alttaki.next;
        if(temp.next == null){
            tail = temp;
        }else {
            alttaki.next.prev = temp;
        }

        //ikisini bağla
        alttaki.next = temp;
        temp.prev = alttaki;

    }

    public boolean containsSong(Song song){
        if (song == null){
            return false;
        }

        PlaylistNode temp = head;

        while (temp != null){
            if(temp.song.getTitle().equals(song.getTitle())){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }





}