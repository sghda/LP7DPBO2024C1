# LP7DPBO2024C1
# Janji
Saya Salma Ghaida dengan NIM 2207186 mengerjakan Latihan Praktikum 7 dalam mata kuliah Desain Pemrograman Berbasis Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin...

# Penjelasan Program
## Penjelasan Kelas
1. Kelas App:
      Kelas ini merupakan kelas utama yang digunakan untuk menjalankan program Flappy Bird.
      Bertanggung jawab untuk menampilkan splash screen dan memulai permainan saat tombol "Start Game" ditekan.
2. Kelas FlappyBird:
      Kelas ini adalah inti dari permainan Flappy Bird.
      Mengontrol logika permainan, seperti pergerakan burung, penempatan pipa, deteksi tabrakan, dan perhitungan skor.
      Menangani input dari pengguna, seperti tombol yang ditekan untuk membuat burung melompat.
      Menyediakan metode paintComponent untuk menggambar elemen-elemen permainan di panel.
3. Kelas Player:
      Merepresentasikan karakter utama dalam permainan, yaitu burung Flappy.
      Menyimpan atribut seperti posisi, ukuran, dan gambar burung.
      Memiliki metode untuk mengatur pergerakan burung, seperti melompat ke atas saat tombol ditekan.
4. Kelas Pipe:
      Merepresentasikan rintangan (pipa) dalam permainan.
      Menyimpan atribut seperti posisi, ukuran, dan gambar pipa.
      Bertanggung jawab untuk pergerakan pipa dari kanan ke kiri layar.
      Memiliki atribut passed untuk menandai apakah burung telah berhasil melewati pipa tersebut.

Apa saja yang di tambahkan di LP7 
- Game Over, permainan berakhir saat player menabrak/menyentuh pipa atau terjatuh ke batas bawah JFrame
    Membuat atribut boolean gameover yang awalnya di set false, lalu pada saat menabrak pipa atau keluar dari frame gameover di set true dan gam berhenti.
    Lalu menambahkan pesan game over dan info untuk restart menggunakan fungsi draw 
- Restart game dengan menekan tombol R
    Menggunakan key listener key pressed, apabila R di tekan maka posisi player, velocity player, score di set jadi awal lagi, pipes di clear lalu di start kembali begitu pula boolean game over yg di set false kembali lalu gameloop di start 
- Label Score
    Menggunakan fungsi draw, score ditampilkan di sisi kiri atas
- GUI Form sebelum memulai game
    Pada class apps sebelum ke frame game, ditampilkan splash frame terlebih dahulu jika button start game nya di tekan barulah frame game ditampilkan

# Screen Record saat di Run


https://github.com/sghda/LP7DPBO2024C1/assets/123555756/086bee52-c4cc-42ed-8fdc-c380f6a5ae38



