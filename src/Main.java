import datastructures.DynamicSongArray;
import model.Song;
public class Main {
    public static void main(String[] args) {
        DynamicSongArray katalog=new DynamicSongArray();
        System.out.println("Başlangıç kapasitesi: "+katalog.getCapacity());// burada başlangıç kapasitesini yazdırıyoruz
        System.out.println("Başlangıç boyutu: "+katalog.getSize());
        for(int i=1;i<=12;i++){
            katalog.add(new Song(i,"Şarkı Adı","Sanatçı",200));//burada ise tam 12 tane yeni şarkı nesnesi ekliyoruz
        }
        System.out.println("Yeni kapasite: "+katalog.getCapacity()); // burda ise kapasiteyi görüyoruz.
        System.out.println("Şarkı sayısı: "+katalog.getSize()); //burada aktif şarkı sayısı
        katalog.printAll(); //tüm şarkı nesnelerini yazdırıyoruz
    }
}