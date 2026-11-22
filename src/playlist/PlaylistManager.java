package playlist;

import model.Song;

public class PlaylistManager {
    private DoublyLinkedPlaylist[] playlists;
    private int size;
    private int capacity;

    public PlaylistManager (){
        this.capacity = 5;
        this.playlists = new DoublyLinkedPlaylist[capacity];
        this.size = 0;
    } //toplam playlistler için belli kapasiteli bir liste açtık eğer yetmezse resize metodu devreye girecek

    private void resize() {
        int yeniKapasite = capacity*2;
        DoublyLinkedPlaylist[] yenidizi = new DoublyLinkedPlaylist[yeniKapasite];
        for (int i=0 ; i < size ; i++){
            yenidizi[i] = playlists[i];
        }
        this.playlists = yenidizi;
        this.capacity = yeniKapasite;
    }//öncekinin iki katı boyunda bi playlistler listesi oluşur

    public void addPlaylist(DoublyLinkedPlaylist playlist){
        if(playlist == null){
            return;
        }
        if(size == capacity){//yer dolmuşsa resize
            resize();
        }
        playlists[size] = playlist;
        size++;
    }

    //playlist adına göre arama
    public DoublyLinkedPlaylist findPlaylistByName(String name){
        if(name == null){
            return null;
        }
        for (int i =0;i < size ; i++){
            if (playlists[i].getName().equalsIgnoreCase(name)){
                return playlists[i];
            }
        }
        return null;
    }

    //içeren çalma listelerini gösterir
    public DoublyLinkedPlaylist[] findPlaylistsContainingSong(Song song){
        if (song == null){
            return new DoublyLinkedPlaylist[0];
        }

        //kaç listede var sayalım
        int bulunansayi = 0;
        for (int i =0; i < size; i++){
            if (playlists[i].containsSong(song)){
                bulunansayi++;
            }
        }

        //içeren playlistleri bir listeye alıyoruz
        DoublyLinkedPlaylist[] sonuc = new DoublyLinkedPlaylist[bulunansayi];
        int index = 0;
        for (int i = 0; i< size; i++){
            if (playlists[i].containsSong(song)){
                sonuc[index] = playlists[i];
                index++;
            }
        }
        return sonuc;
    }





}