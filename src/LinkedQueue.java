import model.Song;

public class LinkedQueue {
    private QueueNode front;
    private QueueNode rear;

    public LinkedQueue(){
        front = null;
        rear = null;
    }

    public boolean isEmpty(){
        return front == null;
    }
    public void enqueue(Song song){
        QueueNode newNode = new QueueNode(song);

        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
    }
    public Song dequeue(){
        if(isEmpty()){
            return null;
        }
        Song removedSong = front.song;
        front = front.next;

        if(front == null){
            rear = null;
        }
        return removedSong;
    }

    public Song peek(){
        if(isEmpty()){
            return null;
        }
        return front.song;
    }
}
