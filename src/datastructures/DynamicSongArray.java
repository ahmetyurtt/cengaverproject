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
        for (int i = 0; i < size; i++){
            System.out.println(songs[i]);
        }

    }
}
