import model.Song;
/* Bağlı liste tabanlı kuyruk yapısıdır. İlk giren ilk çıkar mantığı ile çalışır. */
public class LinkedQueue {
    private QueueNode front; // kuyruğun başı yani ilk çalacak olan şarkıyı temsil eder.
    private QueueNode rear; // kuyruğun sonunu yani son çalıcak olan şarkıyı ekler .

    /*Boş bir kuyruk oluşturur */
    public LinkedQueue(){
        front = null;
        rear = null;
    }
    //kuyruğun boş olup olmadığını kontrol eder.
    public boolean isEmpty(){
        return front == null;
    }
    /* şarkıyı kuyruğun en arkasına ekler.*/
    public void enqueue(Song song){
        QueueNode newNode = new QueueNode(song);

        if(isEmpty()){
            //kuyruk boşsa yeni düğüm hem baş  hemde son olur.
            front = newNode;
            rear = newNode;
        }
        else{
            //değilse mevcut son düğümün arkasına bağla , rear'ı güncelle.
            rear.next = newNode;
            rear = newNode;
        }
    }
    //sıradaki şarkıyı çalmayı sağlar , eğer şarkı yoksa boş döndür.
    public Song dequeue(){
        if(isEmpty()){
            return null;
        }
        Song removedSong = front.song;
        front = front.next;// başı sonraki düğüme kaydır.

        if(front == null){
            rear = null; // kuyruk boş kaldı , rear da sıfırlanmalı.
        }
        return removedSong;
    }
    //Baştaki şarkıya bakar ama kuyruktan çıkarmaz , baştaki şarkı dönmezse boş döndürür.
    public Song peek(){
        if(isEmpty()){
            return null;
        }
        return front.song;
    }
}
