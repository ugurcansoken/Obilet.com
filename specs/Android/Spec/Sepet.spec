Sepet Senaryolari
=====================
Created by ugurcan on 8.08.2022

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Sepete Urun Ekleme
----------------
tags: sepeteUrunEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urunun adi bir dizine atilir ve urun sepete eklenir
* Sepete gidilir ve sepetteki urun adi bir dizine atilir
* Kaydedilen 2 urun adi karsilastirilir ve sepete dogru urun eklendigi kontrol edilir
* Cikis yapilir

Farkli Magazalardan Sepete Urun Ekleme
/--------
/ tags: farkliMagazalardanSepeteUrunEkleme

/* Uygulamanin acildigi kontrol edilir
/* Test Kullanicisi ile Login Olunur
/* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
/* Anasayfadan markalar basligina scroll edilir ve rastgele marka secilir
/* Magaza detayindan random urun secilir urun adi bir dizine atilir ve sepete eklenir
/* Elementine tıkla "urunDetayindanGeriDonmeButonuSPT"
/* Elementine tıkla "GeriDonButonuPS"
/* "458","353" coordinatından "472","976" coordinatına "3" kere swipe et
/* Anasayfadan markalar basligina scroll edilir ve tekrar rastgele marka secilir
/* Magaza detayindan random urun secilir urun adi bir dizine atilir ve sepete eklenir
/* Urun detayindan sepete gidilir
/* Sepetteki satici isimleri karsilastirilir
/* Cikis yapilir

Sepetteki Urun Adetini Arttirma
--------
tags: sepettekiUrunAdetiniArttirma

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepetteki urunun sayisi arttirilir ve kontrol edilir
* Cikis yapilir

Sepetteki Urun Adetini Azaltma
-------
tags: sepettekiUrunAdetiniAzaltma

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepetteki urunun sayisi azaltilir ve kontrol edilir
* Cikis yapilir

Sepette Birden Fazla Farkli Urun Varken Herhangi Bir Urunden Tik İsaretini Kaldirip Sepeti Onaylama
------
tags: SepetteBirdenFazlaFarkliUrunVarkenHerhangiBirUrundenTikİsaretiniKaldiripSepetiOnaylama

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Elementine tıkla "urunDetayindanGeriDonmeButonuSPT"
* Urunler sayfasinda giyim kategorisine gidilir
* Giyim kategorisinden urun detayina gidilir
* Urun detayindan random renk ve random beden secilir, sepete eklenir
* Urun detayindan sepete gidilir
* 1 Adet urunden tik isareti kaldirilir
* Odenecek tutar ile secili olan urunun fiyati karsilastirilir ve secili olan urunle isleme devam edilir
* "sepetimdenGeriDonmeButonuSPT" li element varsa tek tıkla
* Cikis yapilir

Sepete Bir Urunu 2 Adetten Fazla Ekleme
-------
tags: sepeteBirUrunu2AdettenFazlaEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepetteki urunun sayisi 3 adet yapilir ve hata mesaji kontrol edilir
* Cikis yapilir

Indirim Kodu Ekleme
------
tags: indirimKoduEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* "CLICKME25T" indirim kodu girilir
* Cikis yapilir

Hatali Indirim Kodu ile İndirim Tanimlama
-------
tags: hataliIndirimKoduileİndirimTanimlama

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* "12345" indirim kodu girilir ve hata mesajı goruntulenir
* Cikis yapilir

Login Olmadan Sepete Urun Ekleme
--------
tags: loginOlmadanSepeteUrunEkleme

* Uygulamanin acildigi kontrol edilir
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete urunu ekleyemedigi ve Giris yap sayfasina yonlendirdigi kontrol edilir

Sepetteki Urunden Urun Detayina Gidilip Geri Don Butonu ile Geri Gelinmesi
--------
tags: sepettekiUrundenUrunDetayinaGidilipGeriDonButonuileGeriGelinmesi

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Elementine tıkla "sepeteEklenenUrunAdiSepettekiAdiSPT"
* Elementine tıkla "urunDetayindanGeriDonmeButonuSPT"
* "sepeteEklenenUrunAdiSepettekiAdiSPT" elementinin görünürlüğü kontrol edilir
* Cikis yapilir

Odenecek Tutar ile Toplam Tutar Fiyatlarinin Karsilastirma Yapilmasi
--------
tags: odenecekTutarileToplamTutarFiyatlarininKarsilastirmaYapilmasi

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Odenecek tutar ile toplam tutar bir dizine atilir ve karsilastirilir
* Cikis yapilir

Urunun Detayindaki Fiyati ile Sepete Eklendiginde Gosterilen Fiyatinin Karsilastirilmasi
-------------
tags: UrununDetayindakiFiyatiileSepeteEklendigindeGosterilenFiyatininKarsilastirilmasi

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Urun detay sayfasindaki urun fiyati bir dizine atilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Urunun sepetteki fiyati bir dizine atilir ve urun detay sayfasindaki fiyati ile karsilastirilir
* Cikis yapilir

Urunun Detayindaki Satici Ismi ile Sepete Eklendiginde Gosterilen Satici Isminin Karsilastirilmasi
-------
tags: urununDetayindakiSaticiIsmiileSepeteEklendigindeGosterilenSaticiIsmininKarsilastirilmasi

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Urun detay sayfasindaki urunun satici ismi bir dizine atilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Urunun sepetteki satici ismi bir dizine atilir ve urun detay sayfasindaki satici ismi ile karsilastirilir
* Cikis yapilir

Urunun Detayinda Gosterilen Urun Ismi ile Sepete Eklendiginde Gosterilen Urun Isminin Karsilastirilmasi
-------
tags: urununDetayindaGosterilenUrunIsmiileSepeteEklendigindeGosterilenUrunIsmininKarsilastirilmasi

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Urun detay sayfasindaki urunun ismi bir dizine atilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Urunun sepetteki ismi bir dizine atilir ve urun detay sayfasindaki urun ismi ile karsilastirilir
* Cikis yapilir

/Urunun Detayinda Secilen Renk ile Sepete Eklendiginde Gosterilen Rengin Karsilastirilmasi
/-------
/tags: urununDetayindaSecilenRenkileSepeteEklendigindeGosterilenRenginKarsilastirilmasi

/* Uygulamanin acildigi kontrol edilir
/* Test Kullanicisi ile Login Olunur
/* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
/* Urunler sayfasina gidilir
/* Urunler sayfasinda giyim kategorisine gidilir
/* Giyim kategorisinden urun detayina gidilir
/* Urunun rengi bir dizine atilir ve sepete eklenir
/* Urun detayindan sepete gidilir
/* Urun detayinda secilen renk ile sepette gosterilen urun rengi karsilastirilir
/* Cikis yapilir

Urunun Detayinda Secilen Beden ile Sepete Eklendibinde Gosterilen Bedenin Karsilastirilmasi
-----
tags: urununDetayindaSecilenBedenileSepeteEklendibindeGosterilenBedeninKarsilastirilmasi

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir
* Urunler sayfasinda giyim kategorisine gidilir
* Giyim kategorisinden urun detayina gidilir
* Urunun bedeni bir dizine atilir ve sepete eklenir
* Urun detayindan sepete gidilir
* Urun detayinda secilen beden ile sepette gosterilen urunun bedeni karsilastirilir
* Cikis yapilir

Urun Adetini Arttirdigimizda Urun Fiyati Degisimi Kontrolu
------
tags: urunAdetiniArttirdigimizdaUrunFiyatiDegisimiKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Urun fiyati bir dizine atilir, urun adeti arttirilir ve yeni fiyat ile karsilastirilir
* Cikis yapilir

Urune Indirim Uygulandigindaki Fiyat Degisikligi Kontrolu
------
tags: uruneIndirimUygulandigindakiFiyatDegisikligiKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* "CLICKME25T" indirim kodu girilir
* Cikis yapilir

