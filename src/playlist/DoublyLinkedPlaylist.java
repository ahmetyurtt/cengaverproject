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

    public void removeSong(Song song){
        PlaylistNode temp = head;

        while (temp != null){
            if(temp.song.getTitle().equals(song.getTitle())){
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





}