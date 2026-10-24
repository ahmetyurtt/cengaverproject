import model.Song;

public class SongHistoryStack {
    private StackNode top; // Stackin en üstündeki düğümü temsil ediyor
    private int size; //Şarkı sayısı

//Constructor 
public SongHistoryStack(){
    this.top=null; //stack boş
    this.size=0;   //stack boyutu 0
}
//Çalan şarkıyı geçmişin en tepesine ekler
public void push(Song song){
    if(song==null)
        return;

    StackNode newNode=new StackNode(song);
    newNode.next=top;//Mevcut olanın üstüne yenisini koyduk
    top=newNode;     //yeni tepe bu oldu
    size++;
}
//Önceki şarkıya dönüldüğünde şarkıyı getirir
public Song pop(){
if(isEmpty()){ //geçmiş boşsa hataya düşmesin diye boş verir
    return null;
}
Song poppedSong=top.song;
top=top.next;
size--;

return poppedSong;
}
//Boşmu dolumu kontrol eder
public boolean isEmpty(){
    return top==null;
}
//Geçmişteki şarkı sayısını söyler
public int getSize(){
    return size;
}
}
