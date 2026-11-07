import model.Song;

public class SongHistoryStack {
    private StackNode top; // Stackin en üstündeki düğümü temsil ediyor
    private int size; //Şarkı sayısı
    private final int MAX_CAPACİTY=30;//Maksimum kapasite 30 oldu
//Constructor 
public SongHistoryStack(){
    this.top=null; //stack boş
    this.size=0;   //stack boyutu 0
}
//Çalan şarkıyı geçmişin en tepesine ekler
public void push(Song song){
    if(song==null)
        return;
    if(size>=MAX_CAPACİTY){
        removeBottomNode();//Max kapasiteye çıkınca en alttaki şarkıyı siler
    }
    StackNode newNode=new StackNode(song);
    newNode.next=top;//Mevcut olanın üstüne yenisini koyduk
    top=newNode;     //yeni tepe bu oldu
    size++;
}
//Önceki şarkıya dönüldüğünde şarkıyı getirir
public Song pop(){
if(isEmpty()){ //geçmiş boşsa hataya düşmesin diye boş verir
    System.out.println("Dinleme geçmişi boş.");
    return null;
}
Song poppedSong=top.song;
top=top.next;
size--;

return poppedSong;
}

//Kapasite dolunca en alttaki veriyi kaldıran metod
private void removeBottomNode(){
    if(top==null||top.next==null){
        top=null;
        size=0;
        return;
    }
    StackNode current=top;
    while(current.next.next!=null){
        current=current.next;
    }
    current.next=null;//En alttaki düğümü kaldırır
    size--;
}


//Boşmu dolumu kontrol eder
public boolean isEmpty(){
    return top==null;
}
//Geçmişteki şarkı sayısını söyler
public int getSize(){
    return size;
}
//Geçmişteki şarkıları yazdırıcı
public void printStack(){
    if(isEmpty()){
        System.out.println("Dinleme geçmişi boş");
        return;
    }
    System.out.println("  DİNLEME GEÇMİŞİ   ");
    StackNode current=top;
    while(current != null){
        System.out.println("---"+current.song.toString());
        current=current.next;//bir sonrakine geçirir
    }
}
}
