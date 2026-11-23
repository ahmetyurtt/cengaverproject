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
    }
}
