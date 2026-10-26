VY-033 Müzik Arşivi ve Çalma Listesi
Veri Yapıları dersi dönem projesi. Java ve Swing ile geliştirilen bir müzik arşivi uygulaması. Şarkı kataloğu, çalma listeleri, istek kuyruğu ve dinleme geçmişi yönetilir.
Kural: ArrayList, LinkedList, Queue, Stack gibi hazır Java koleksiyonları kullanılmaz. Tüm veri yapıları sıfırdan elle yazılır.

Ekip ve Sorumluluklar:
Muhammad Eren Bilgiç @erenblgc : Şarkı kataloğu, dinamik dizi, sıralama, arama
Ahmet Yurt @ahmetyurtt : Çalma listeleri, çift yönlü bağlı liste
Yusuf Berke Yıldırım @yusufberkeyildirim : İstek kuyruğu (Queue, FIFO)
Yunus Emre Bayhan @YunusEmreBayhan44 : Dinleme geçmişi (Stack, LIFO), dosya kaydı, MainFrame

Teknoloji:
Java (JDK 17+)
Swing (JFrame, JTable, JTabbedPane)
Git / GitHub

Klasör Yapısı:
src/ model (Song), catalog (SongArray), playlist (PlaylistNode, Playlist), queue (QueueNode, SongQueue), history (StackNode, SongStack), io (sarkilar.txt), ui (Paneller ve MainFrame)
test/ (Her veri yapısı için test sınıfları)
docs/ (UML diyagramı, rapor)
README.md

Temel İşlevler ve Veri Yapıları:
Ana şarkı kataloğu (ekle, sil, ara): Dinamik dizi (Song[]) kullanılır. İndeksle O(1) erişim sağlar ve JTable satır indeksiyle doğal uyum verir.
Çalma listeleri (ileri/geri, taşıma): Çift yönlü bağlı liste kullanılır. Ortadan silme ve yer değiştirme O(1) yapılır, kaydırma gerekmez.
İstek kuyruğu (Sıraya ekle): Kuyruk (FIFO) kullanılır. İlk istek atan ilk çalmalıdır, enqueue ve dequeue O(1) çalışır.
Dinleme geçmişi (Geri dön): Yığın (LIFO) kullanılır. En son çalınan şarkıya geri dönülür, push ve pop O(1) çalışır.
Kalıcılık: Metin dosyası kullanılır. Program kapanıp açılınca katalog ve listeler korunur.

Sınıf ve Düğüm Taslağı:
Song: id, title, artist
SongArray: Song[] data (Song içerir)
PlaylistNode: prev, next, Song referansı
Playlist: head, tail (PlaylistNode içerir)
QueueNode: next, Song referansı
SongQueue: front, rear (QueueNode içerir)
StackNode: next, Song referansı
SongStack: top (StackNode içerir)
MainFrame: SongArray, Playlist, SongQueue ve SongStack yapılarını bağlar.

İş Bölümü Detayı:

Muhammad Eren Bilgiç:
Song sınıfı ve elle yazılmış dinamik dizi (SongArray)
Şarkı ekleme, silme, güncelleme, sıralama ve arama
Swing: CatalogPanel arayüzü

Ahmet Yurt:
PlaylistNode ve Playlist (çift yönlü bağlı liste)
Listeye şarkı ekleme, taşıma, silme ve listeler arası geçiş
Swing: PlaylistPanel arayüzü

Yusuf Berke Yıldırım:
QueueNode ve SongQueue (front/rear)
enqueue, dequeue işlemleri ve kuyruk bitince listeden devam etme mantığı
Swing: QueuePanel arayüzü

Yunus Emre Bayhan:
StackNode ve SongStack (push, pop)
Önceki şarkıya dön mekanizması ve sarkilar.txt kayıt/yükleme
MainFrame sekmeli arayüzü

Çalıştırma:
javac -d out $(find src -name "*.java")
java -cp out ui.MainFrame
