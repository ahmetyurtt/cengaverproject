package model;

public class Song {
    private int id; //Şarkıya bir kimlik kazandırmak için
    private String title; //Şarkı adı
    private String artist; //Şarkıyı söyleyen
    private int durationInSeconds; //(Saniye cinsinden şarkının süresi örneğin:3 dk 20 sny=200sny
    public Song(int id,String title,String artist,int durationInSeconds){
        this.id=id;
        this.title=title;
        this.artist=artist;
        this.durationInSeconds=durationInSeconds;
    }
    // Getter: Dışarıdan birisi "Bu şarkının adı ne?" diye sorduğunda bilgiyi güvenle okuyup vermek için
    // Setter: Şarkının adını dışarıdan gelen yeni bilgiyle değiştirmek yada güncellemek için.
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String  getArtist(){
        return artist;
    }
    public void setArtist(String artist){
        this.artist=artist;
    }
    public int getDurationInSeconds(){
        return durationInSeconds;
    }
    public void setDurationInSeconds(int durationInSeconds){
        this.durationInSeconds=durationInSeconds;
    }
    @Override
    public String toString(){
        return "Song [ID="+id+ " ,Adı="+ title+ " ,Sanatcı adı: "+artist+", Süresi: "+durationInSeconds+"sn]";
    }
}
