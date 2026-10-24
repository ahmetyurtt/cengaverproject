import model.Song;
public class Main {
    public static void main(String[] args) {
        //Bir şarkı nesnesi üretelim
        Song sarki1=new Song(1,"Benim Yerimede Sev","Sezen Aksu",316);
        System.out.println("Oluşturulan şarkı: "+sarki1);
        System.out.println("Şarkının adı (Getter ile): "+sarki1.getTitle());
        sarki1.setTitle("Begonvil");
        System.out.println("Güncellenmiş hali (Setter sonrası) :"+sarki1);
    }
}