import model.Song;

public class LinkedQueueTest {
    public static void main(String[] args){
        LinkedQueue q = new LinkedQueue();
        q.enqueue(new Song(1,"Beyaz","Ebru Gündes",250));
        q.enqueue(new Song(2,"Kill The Pain","Accept",290));

        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());

        // Konsola 3 istek göndereceğiz ve sıraya çıkacak - ilk giren ilk çıkar mantığı

        System.out.println("FIFO Gosterimi");
        Song s1 = new Song(1, "Beyaz", "Ebru Gündes", 250);
        Song s2 = new Song(2, "Cehennemde Bi Gölge", "Kayra", 154);
        Song s3 = new Song(3, "Gönlüm Hos Degil", "Muhlis Akarsu", 198);

        q.enqueue(s1);
        q.enqueue(s2);
        q.enqueue(s3);

        //Beklenen çıkış sırası 1 - 2 - 3

        System.out.println("Cikan " + q.dequeue());
        System.out.println("Cikan " + q.dequeue());
        System.out.println("Cikan " + q.dequeue());

        // Boş kuyrukta dequeue güvenli uyarı vermeli , program çökmemeli

        System.out.println("Bos kuyruk testi");
        System.out.println("Sonuc: "+ q.safeDequeue());

        // Tek eleman varken çıkarınca rear null olmalı

        System.out.println("Tek eleman testi");
        q.enqueue(s1);
        q.dequeue();
        System.out.println("rear null mu? "+ q.isRearNull());

        //Aradaki bir isteği iptal et

        System.out.println("İptal testi");
        q.enqueue(s1);
        q.enqueue(s2);
        q.enqueue(s3);

        System.out.println("İptal edilen :" + q.cancel(2));

        System.out.println("Siradaki :" + q.dequeue());

        System.out.println("Siradaki :" + q.dequeue());

        q.enqueue(s1);
        q.cancel(99);

        q.dequeue();
    }
}
