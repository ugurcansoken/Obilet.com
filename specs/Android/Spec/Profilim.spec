Profilim Senaryolari
=====================
Created by ugurcan on 5.08.2022

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Giris Yapmayan Kullanicinin Profilim Sayfasini Goruntulemesi
----------------
tags: GirisYapmayanKullanicininProfilimSayfasiniGoruntulemesi

* Uygulamanin acildigi kontrol edilir
* Elementine tıkla "ProfilimMenuButonuPS"
* "GirisYapmayanKullanicininProfilSayfasiMesajiPS" elementinin görünürlüğü kontrol edilir

Profilim Sayfasi Kontrolu
----------------
tags: ProfilimSayfasiKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Elementine tıkla "ProfilimMenuButonuPS"
* "ProfilSayfasiKontroluPS" elementinin "text" attirbute degeri "ugurcanyayinci" iceriyor mu
* Cikis yapilir

Takip Ettiklerim Sayfasi Kontrolu
----------
tags: TakipEttiklerimSayfasiKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Elementine tıkla "ProfilimMenuButonuPS"
* Elementine tıkla "TakipEttiklerimSayfasiButonuPS"
* Cikis yapilir

Takip Ettiklerim Sayisi Kontrolu
------
tags: TakipEttiklerimSayisiKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasina gidilir ve takip edilenler sayisi bir dizine atilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Magaza profiline girilir
* Magaza profilinden magaza takip edilir ve geri anasayfaya donulur
* Profil sayfasina gidilir ve takip edilenler sayisi bir dizine atilir
* "2". Kaydedilen deger "1". kaydedilen degerden "büyük" mu?
* Takip ettiklerim sayfasina gidilir ve takip edilen magazayi takipten cikilir
* Cikis yapilir

Takip Ettiklerim Sayfasi Uzerinden Kullaniciyi Takipten Cikma
-------
tags: TakipEttiklerimSayfasiUzerindenKullaniciyiTakiptenCikma
* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Urunler sayfasina gidilir ve random bir urun secilir
* Magaza profiline girilir
* Magaza profilinden magaza takip edilir ve geri anasayfaya donulur
* Takip ettiklerim sayfasina gidilir ve takip edilen magazayi takipten cikilir


Siparislerim Sayfasi Kontrolu
------
tags: siparislerimSayfasiKontrolu

* Uygulamanin acildigi kontrol edilir
* Test2 Kullanicisi ile Login Olunur
* Siparislerim sayfasina yonlendirilir
* "siparisiOlmayanKullanicininKontrolTextiPS" elementinin "text" attirbute degeri "Henüz verilmiş bir siparişin yok" iceriyor mu
* Cikis yapilir

Siparislerim Detay Kontrolu
------
tags: siparisDetayKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Siparislerim sayfasina yonlendirilir
* Siparis detayi goruntulenir
* Cikis yapilir


Siparis Iptali Olusturma
-------------
tags: siparisIptaliOlusturma

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Magaza profiline girilir
* Magaza detayindan random urun secilir ve Sepete eklenir
* Urun detayindan sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Kart ekleme sayfasina yonlendirilir
* "Kredi Kartı", "Uğurcan Söken", "07/27" bilgileri girilerek kart bilgileri doldurulur
* "kartBilgileriSayfasindanGeriDonButonuOD" li element varsa tek tıkla
* Sozlesmeyi kabul edip alisverisi "201409" dogrulama kodu ile siparisi tamamlama
* Siparisin alindigi dogrulanir
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve kart bilgileri temizlenir
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve adres bilgileri temizlenir
* Siparislerim sayfasina yonlendirilir
* Son siparisin detayina gidilir ve siparis iptal edilir
* Cikis yapilir


Hesap Bilgilerim Sayfasi Kontrolu
-------
tags: hesapBilgilerimSayfasiKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan hesap bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Cikis yapilir


Ad Soyad Alanini Bos Birakarak Guncelleme Yapma
---------
tags: adSoyadAlaniniBosBirakarakGuncellemeYapma

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan hesap bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Ad Soyad alani bos birakilir ve kaydet butonuna tiklanir
* Cikis yapilir

// HATA ALMASI GEREKEN SENARYO PASS GECİYOR

Ad Soyad Alanini Alfanumerik Olmayan Karakter ile Guncelleme Yapma
---------
tags: adSoyadAlaniniAlfanumerikOlmayanKarakterileGuncellemeYapma

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan hesap bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Ad Soyad alanina alfanumerik olmayan karakter girilir, kaydet butonuna tiklanir ve hata kontrol edilir
* Cikis yapilir

// HATA ALMASI GEREKEN MESAJ DEGİSMELİ


Kullanici Adi Alanini Bos Birakarak Guncelleme Yapma
----------
tags: kullaniciAdiAlaniniBosBirakarakGuncellemeYapma

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan hesap bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Kullanici adi bos birakilir ve kaydet butonuna tiklanir
* Cikis yapilir

// HATA ALMASI GEREKEN SENARYO PASS GECİYOR


Kullanici Adi Alanini Alfanumerik Olmayan Karakter ile Guncelleme
---------
tags: kullaniciAdiAlaniniAlfanumerikOlmayanKarakterileGuncelleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan hesap bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Kullanici adi alanina alfanumerik olmayan karakter girilir, kaydet butonuna tiklanir ve hata kontrol edilir
* Cikis yapilir

// HATA ALMASI GEREKEN MESAJ DEGİSMELİ


Cep Telefonu Alani Kontrolu
----------
tags: cepTelefonuAlaniKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan hesap bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Cep telefonu alaninda cep telefonu numarasinin gozuktugu kontrol edilir
* Cikis yapilir

Eposta Adresi Alanini Bos Birakarak Guncelleme Yapma
---------
tags: epostaAdresiAlaniniBosBirakarakGuncellemeYapma

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan hesap bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Eposta alani bos birakilir ve kaydet butonuna tiklanir
* Cikis yapilir

Adres Ekleme
---------
tags: adresEkleme

* Uygulamanin acildigi kontrol edilir
/* Test Kullanicisi ile Login Olunur
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve adres bilgileri temizlenir
* Cikis yapilir


Adres Basligi Bilgisi Girmeden Adres Ekleme
-------
tags: adresBasligiBilgisiGirmedenAdresEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Adres ekleme sayfasina gidilir
* Adres basligi bilgisi girmeden adres eklenir ve hata mesaji dogrulanir
* Cikis yapilir

Ad Soyad Bilgisi Girmeden Adres Ekleme
------------
tags: adSoyadBilgisiGirmedenAdresEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Adres ekleme sayfasina gidilir
* Ad soyad bilgisi girmeden adres eklenir ve hata mesaji dogrulanir
* Cikis yapilir

Cep Telefonu Bilgisi Girmeden Adres Ekleme
------------
tags: cepTelefonuBilgisiGirmedenAdresEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Adres ekleme sayfasina gidilir
* Cep telefonu bilgisi girmeden adres eklenir ve hata mesaji dogrulanir
* Cikis yapilir

Eksik Cep Telefon Bilgisi Girerek Adres Ekleme
-------------
tags: eksikCepTelefonBilgisiGirerekAdresEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Adres ekleme sayfasina gidilir
* Eksik cep telefonu bilgisi ile adres eklenir ve hata mesaji dogrulanir
* Cikis yapilir

Il Bilgisi Girmeden Adres Ekleme
-------
tags: ilBilgisiGirmedenAdresEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Adres ekleme sayfasina gidilir
* il bilgisi girmeden adres eklenir ve hata mesaji dogrulanir
* Cikis yapilir


Ilce Bilgisi Girmeden Adres Ekleme
--------
tags: ilceBilgisiGirmedenAdresEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Adres ekleme sayfasina gidilir
* ilce bilgisi olmadan adres eklenir ve hata mesaji dogrulanir
* Cikis yapilir

Mahalle Bilgisi Girmeden Adres Ekleme
-----------
tags: mahalleBilgisiGirmedenAdresEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Adres ekleme sayfasina gidilir
* Mahalle bilgisi girmeden adres eklenir ve hata mesaji dogrulanir
* Cikis yapilir

Adres Bilgisi Girmeden Adres Ekleme
---------
tags: adresBilgisiGirmedenAdresEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Adres ekleme sayfasina gidilir
* Adres bilgisi girmeden adres eklenir ve hata mesaji dogrulanir
* Cikis yapilir

Adres Silme
-----------
tags: adresSilme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve adres bilgileri temizlenir
* Cikis yapilir


Kart Ekleme
-----------
tags: kartEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Kart bilgilerim sayfasindan kart ekleme sayfasina gidilir
* "Kredi Kartım", "Uğurcan", "12/22" bilgileri girilerek kart bilgileri doldurulur
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve kart bilgileri temizlenir
* Cikis yapilir

Kart İsmi Girmeden Kart Ekleme
---------
tags: kartIsmiGirmedenKartEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Kart bilgilerim sayfasindan kart ekleme sayfasina gidilir
* Kart ismi girmeden kart eklenir ve hata mesajı dogrulanir
* Cikis yapilir

Kart Üzerindeki Isim Girmeden Kart Ekleme
----------
tags: kartÜzerindekiIsimGirmedenKartEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Kart bilgilerim sayfasindan kart ekleme sayfasina gidilir
* Kart uzerindeki ismi girmeden kart eklenir ve hata mesajı dogrulanir
* Cikis yapilir


Kart Numarasi Girmeden Kart Ekleme
-----------
tags: kartNumarasiGirmedenKartEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Kart bilgilerim sayfasindan kart ekleme sayfasina gidilir
* Kart numarasi girmeden kart eklenir ve hata mesajı dogrulanir
* Cikis yapilir

Son Kullanma Tarihi Girmeden Kart Ekleme
-----------
tags: sonKullanmaTarihiGirmedenKartEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Kart bilgilerim sayfasindan kart ekleme sayfasina gidilir
* Son kullanma tarihi girmeden kart eklenir ve hata mesajı dogrulanir
* Cikis yapilir

Kart Silme
----------
tags: kartSilme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve sayfa kontrol edilir
* Kart bilgilerim sayfasindan kart ekleme sayfasina gidilir
* "Kredi Kartım", "Uğurcan", "12/22" bilgileri girilerek kart bilgileri doldurulur
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve kart bilgileri temizlenir
* Cikis yapilir


Sikca Sorulan Sorular Sayfasi Kontrolu
--------
tags: sikcaSorulanSorularSayfasiKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Profil sayfasindan sikca sorulan sorular sayfasina gidilir ve sayfa kontrol edilir
* Sikca sorulan sorular accordions kontrol edilir
* Cikis yapilir


Canli Destek Sayfasi Kontrolu
--------
tags: canliDestekSayfasiKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Canli destek sayfasina gidilir ve sayfa kontrol edilir


Canli Destege Baglanirken Bilgilerin Otomatik Doldurulmasi Kontrolu
--------
tags: canliDestegeBaglanirkenBilgilerinOtomatikDoldurulmasiKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Canli destek sayfasina gidilir ve sayfa kontrol edilir
* Canli destek sayfasindan sohbet baslatilir ve bilgilerin otomatik dolduruldugu kontrol edilir






















