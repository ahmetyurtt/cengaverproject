package datastructures;

import model.Song;

public class DynamicSongArray {
    //capacityyi şöyle düşünelim: Otobüsteki toplam koltuk sayısı. Size ise otobüste o an oturan yolcu sayısına denir.
  private Song[] songs; //Şarkıları arka planda tutan gerçek sabit dizimiz.
  private int size;
  private int capacity;
  public DynamicSongArray(){
      this.capacity=10; // Başta 10 kişilik bir yer ayıralım
      this.songs=new Song[capacity]; //Ramde 10 kutuluk dizi açtık (10 koltuk ekledik)
      this.size=0; //henüz hiç şarkı eklemedik (otobüste oturan kimse yok)
  }
  private void resize(){ //kapasite güncelleme işlemi fonksiyonu
      int yeniKapasite=capacity*2;
      Song[] yeniDizi=new Song[yeniKapasite];
      for(int i=0;i<size;i++){//Yeni açılan diziye önceki dizideki şarkıları tekrar ekleme işlemi.
          yeniDizi[i]=songs[i];
      }
              this.songs=yeniDizi;
              this.capacity=yeniKapasite;
  }
  public void add(Song song){// burda şarkı ekleme işlemini yapıyoruz ve bunun yanında resize yaparak kapasite dolarsa bunu arttırma işlemini de yapıyoruz.

      if(size==capacity){
          resize();
      }
      songs[size]=song;
      size++;
  }

    public int getSize() { // Şarkı sayısı kaça çıktı? kontrolü için bi getter ekleyelim
        return size;
    }

    public int getCapacity() { // kapasite kontrolü için de bir getter
        return capacity;
    }

    public void printAll() { //Dizideki tüm şarkıları alt alta görebilmek için bi fonksiyon.
        for (int i = 0; i < size; i++) {
            System.out.println(songs[i]);
        }
    }
        public boolean removeById ( int id){//İndekse göre veri silme işlemi için metod ekliyoruz.Veriyi sildikten sonra elemanları birer sola kaydırarak düzene koymamızda gerekiyor burda.
            for (int i = 0; i < size; i++) { //bu döngü arıyor bizim girdiğimiz değeri onu bulana kafar döner

                if (songs[i].getId() == id) {//bulduysan eğer.. demek
                    for (int j = i; j < size - 1; j++) {  //buradaki döngümüz ise boşluğu doldurmak. Yani bulup çıkarttığımız değerden sonra bir sola kaydırdı değerleri.

                        songs[j] = songs[j + 1];

                    }
                    songs[size - 1] = null;
                    size--;
                    return true;
                }

            }
            return false;

        }
        public boolean updateSong(int id,String newTitle,String newArtist,int newDurationInSeconds){//Burada yaptığımız şey tam olarak şu şarkının aktif kimliğini(ismini sanatçı adını vs) değiştirerek ona yeni bir kimlik yapmak.
      for(int i=0;i<size;i++){
          if(songs[i].getId()==id) {
              songs[i].setTitle(newTitle);
              songs[i].setArtist(newArtist);
              songs[i].setDurationInSeconds(newDurationInSeconds);
              return true;
          }
      }
      return false;
        }


      public Song searchByTitle(String title){ // başlığa göre şarkı arama metodu ekliyoruz.Tek tek tüm elemanları gezicek ve aradığını bulunca durucak bir metod yapıyoruz yani bu O(N) oluyor.
      for(int i=0;i<size;i++){
          if(songs[i].getTitle().equalsIgnoreCase(title)){ //equalsIgnoreCase büyük harfde olsa küçük harfde olsa o kelimeye eşit mi değil mi kontrolü yapıyor.
return songs[i]; //eğer varsa şarkıyı ver.
          }
      }
return null; // yoksa null ver dedik.
      }

     public Song binarySearchById(int targetId){ //Binary search(ikili arama):Sıralı dizideki her adımda ortadaki elemana bakar. Aranan değer ortadakinden küçükse eğer sola,büyükse sağa bakar.Böylece her adımda seçeneklerin yarısını eleyerek hızlıca istenen değeri bulur. ---->O(LogN)
      int low=0;
      int high=size-1;
      while(low<=high){ //baştan sona kadar devam et anlamında
   int mid=(low+high)/2;// başı ile ortası arasını aldık yani listenin yarısından katladık
      if(songs[mid].getId()==targetId){ //değer yarısındaysa return döndür.
          return songs[mid]; //bulduk işte
      }
      if(targetId<songs[mid].getId()){// aradığımız ID,ortadakinden daha mı küçük? o zaman soluna bak.
          high=mid-1;
      }
      else{//eğer aradığınız ıd daha  büyükse sağa bakalım.
          low=mid+1;
      }
      }
      return null; //eğer yoksa null döndür.Bulunamadı.
     }
    }
