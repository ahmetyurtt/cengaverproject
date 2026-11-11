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

            System.out.println("UYARI : Kuyruk boş , cikarilacak sarki yok!");
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
    /*Kuyruğun ortasındaki (veya herhangi bir yerdeki) isteği id'sine göre iptal eder
    iptal edilen şarkıyı döndürür : bulamazsa uyarı verip null döndürür. */
    public Song cancel(int songId){
        if(isEmpty()){
            System.out.println("Uyarı : Kuyruk bos , iptal edilecek istek yok!");
            return null;
        }

        //Durum 1 : İptal edilecek şarkıyı kuyruğun başındaysa dequene ile aynı işitir.
        if(front.song.getId() == songId){
            return dequeue();
        }

        // Durum 2 : Şarkı ortada veya sonda. Silinecek düğümün bir öncekini buluruz.
        QueueNode current = front;
        while(current.next != null && current.next.song.getId() != songId){
            current = current.next;
        }

        //Listenin sonuna geldik ve şarkıyı bulamadık
        if(current.next == null){
            System.out.println("UYARI : "+ songId +" numarali istek kuyrukta bulunamadi!");

            return null;
        }

        QueueNode removedNode = current.next;

        //Silinen düğüm son düğümse rear'ı bir geriye çekmeliyiz.

        if(removedNode == rear){
            rear = current;
        }
        //Düğümü atla : önceki düğüm artık silinenin sonrakini gösterir.
        current.next = removedNode.next;
        return removedNode.song;
   }
   // Boş kuyrukta güvenli çıkarma , boşsa uyarı verip null döndürür

   public Song safeDequeue(){
    if(isEmpty()){
        System.out.println("UYARI : Kuyruk bos , cikarilacak sarki yok!");
        return null;
    }
     return dequeue();
   }

 

    //Test için rear şu an null mu? tek eleman çıkınca true olmalı.

    public boolean isRearNull(){
        return rear == null;
    }
 
}
