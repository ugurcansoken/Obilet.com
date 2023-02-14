Odeme Senaryolari
=====================
Created by ugurcan on 9.08.2022

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Sepeti Onayladiktan Sonra Teslimat Adresi Ekleme
--------
tags: sepetiOnayladiktanSonraTeslimatAdresiEkleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* "sepetimdenGeriDonmeButonuSPT" li element varsa tek tıkla
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve adres bilgileri temizlenir
* Cikis yapilir

Sepeti Onayladiktan Sonra Teslimat Adresi Guncelleme
-------
tags: sepetiOnayladiktanSonraTeslimatAdresiGuncelleme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* "teslimatAdresiEkleButonuOD" li element varsa tek tıkla
* Kayitli adres secilir, duzenleme yapilir ve kaydedilir
* "sepetimdenGeriDonmeButonuSPT" li element varsa tek tıkla
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve adres bilgileri temizlenir
* Cikis yapilir

Teslimat Adresinde Adres Degisikligi Yapma Kontrolu
------
tags: teslimatAdresindeAdresDegisikligiYapmaKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Bellekte kaydedilen liste ve mapleri temizle
* "2" saniye bekle
* Adres ekleme sayfasina gidilir
* "İş yeri", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Bellekte kaydedilen liste ve mapleri temizle
* geri butonuna bas
* Adres basligi bir dizine atilir, adres degistirilir ve yeni adresin degistigi kontrol edilir
* "sepetimdenGeriDonmeButonuSPT" li element varsa tek tıkla
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve birden fazla adres bilgisi temizlenir
* Cikis yapilir

Faturami Ayni Adrese Gonder Checkbox Kontrolu
------
tags: faturamiAyniAdreseGonderCheckboxKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* "adresBilgileriSayfasindanGeriDonButonuOD" li element varsa tek tıkla
* "teslimatAdresiEkleButonuOD" li element varsa tek tıkla
* Adresin kaydedildigi dogrulanir
* Faturami ayni adrese gonder checkboxindaki isaret kaldirilir ve Fatura adresi basliginin geldigi kontrol edilir
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve adres bilgileri temizlenir
* Cikis yapilir

Fatura Adresini Degistir Butonundan Farkli Adres Secerek Faturayi Farkli Adrese Gonderme
------
tags: faturaAdresiniDegistirButonundanFarkliAdresSecerekFaturayiFarkliAdreseGonderme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Bellekte kaydedilen liste ve mapleri temizle
* "2" saniye bekle
* Adres ekleme sayfasina gidilir
* "İş yeri", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Bellekte kaydedilen liste ve mapleri temizle
* Faturami ayni adrese gonder checkboxindaki isaret kaldirilir ve Fatura adresi basliginin geldigi kontrol edilir
* Fatura adresi degistir butonuna tiklanir ve farkli bir adres secilir
* Teslimat adresi ile fatura adresi karsilastirilir
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve birden fazla adres bilgisi temizlenir
* Cikis yapilir

Faturayi Teslimat Adresinden Farkli Olarak Yeni Kaydedilen Adrese Gonderme
------
tags: faturayiTeslimatAdresindenFarkliOlarakYeniKaydedilenAdreseGonderme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Bellekte kaydedilen liste ve mapleri temizle
* "2" saniye bekle
* Adres ekleme sayfasina gidilir
* "İş yeri", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Bellekte kaydedilen liste ve mapleri temizle
* Faturami ayni adrese gonder checkboxindaki isaret kaldirilir ve Fatura adresi basliginin geldigi kontrol edilir
* Adres basligi bir dizine atilir
* geri butonuna bas
* Fatura adresini degistir butonuna tiklanir ve son eklenen fatura adresi secilir
* Fatura adresinin en son eklenen adres secildigi dogrulanir
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve birden fazla adres bilgisi temizlenir
* Cikis yapilir

Kart Bilgileri Sekmesinden Kart Değiştirme
------
tags: KartBilgileriSekmesindenKartDeğiştirme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Kart ekleme sayfasina yonlendirilir
* "Kredi Kartı", "Uğurcan Söken", "07/27" bilgileri girilerek kart bilgileri doldurulur
* "kartBilgileriSayfasindanGeriDonButonuOD" li element varsa tek tıkla
* Guvenli odeme sayfasinda Baska kart sec butonuna tiklanir
* Kart bilgileri sayfasindan Kart Ekle butonuna tiklanir
* "Banka Kartı", "Uğurcan Söken", "07/27" bilgileri girilerek kart bilgileri doldurulur
* "kartBilgileriSayfasindanGeriDonButonuOD" li element varsa tek tıkla
* Kart secimi degistirilir ve kontrol edilir
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve birden fazla kart bilgileri temizlenir
* Cikis yapilir

MasterCard Logusunun Gorunurluk Kontrolu
-------
tags: masterCardlogusununGorunurlukKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Kart ekleme sayfasina yonlendirilir
* MasterCard logosunun gorunurlugu kontrol edilir
* Cikis yapilir

Visa Logusunun Gorunurluk Kontrolu
-------
tags: visaogusununGorunurlukKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Kart ekleme sayfasina yonlendirilir
* Visa logosunun gorunurlugu kontrol edilir
* Cikis yapilir

Amex Logusunun Gorunurluk Kontrolu
-------
tags: amexogusununGorunurlukKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Kart ekleme sayfasina yonlendirilir
* Amex logosunun gorunurlugu kontrol edilir
* Cikis yapilir

Troy Logusunun Gorunurluk Kontrolu
-------
tags: troyogusununGorunurlukKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Kart ekleme sayfasina yonlendirilir
* Troy logosunun gorunurlugu kontrol edilir
* Cikis yapilir

On Bilgilendirme Kosullarini Kabul Etmeden Alisverisi Tamamlama
-------
tags: onBilgilendirmeKosullariniKabulEtmedenAlisverisiTamamlama

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Kart ekleme sayfasina yonlendirilir
* "Kredi Kartı", "Uğurcan Söken", "07/27" bilgileri girilerek kart bilgileri doldurulur
* "kartBilgileriSayfasindanGeriDonButonuOD" li element varsa tek tıkla
* Sozlesmeyi kabul etmeden alisverisi tamamla butonuna tiklanir ve hata dogrulanir
* Cikis yapilir

SSL Secured Logosu Kontrolu
------
tags: SSLSecuredLogosuKontrolu

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* SSL Secured logosunun gorunurlugu kontrol edilir
* Cikis yapilir

Alisverisi Tamamlama
-------
tags: alisverisiTamamlama

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Kart ekleme sayfasina yonlendirilir
* "Kredi Kartı", "Uğurcan Söken", "07/27" bilgileri girilerek kart bilgileri doldurulur
* "kartBilgileriSayfasindanGeriDonButonuOD" li element varsa tek tıkla
* Sozlesmeyi kabul edip alisverisi "201409" dogrulama kodu ile siparisi tamamlama
* "siparisinizAlindiSayfasindanCikisButonuPS" li element varsa tek tıkla
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve kart bilgileri temizlenir
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve adres bilgileri temizlenir
* Cikis yapilir

3D Odeme Sayfasinda Basarisiz Odeme
--------
tags: 3dOdemeSayfasindaBasarisizOdeme

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Kart ekleme sayfasina yonlendirilir
* "Kredi Kartı", "Uğurcan Söken", "07/27" bilgileri girilerek kart bilgileri doldurulur
* "kartBilgileriSayfasindanGeriDonButonuOD" li element varsa tek tıkla
* Sozlesmeyi kabul edip alisverisi "201400" dogrulama kodu ile siparisi tamamlama
* 3D hatasi kontrol edilir
* Elementine tıkla "3dHataMesajiTamamButonuSPT"
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve kart bilgileri temizlenir
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve adres bilgileri temizlenir
* Cikis yapilir

Kart Alanini Bos Birakarak Alısverisi Tamamlama
------
tags: kartAlaniniBosBirakarakAlısverisiTamamlama

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Adres ekleme sayfasina gidilir
* "Ev", "Uğurcan Söken", "05448415144" bilgileri doldurulur ve adres bilgileri secilir
* Adresin kaydedildigi dogrulanir
* Kart bilgisi eksik hata mesaji kontrol edilir
* Profil sayfasindan adres bilgilerim sayfasina gidilir ve adres bilgileri temizlenir

Adres Alanini Bos Birakarak Alısverisi Tamamlama
------
tags: adresAlaniniBosBirakarakAlısverisiTamamlama

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Kart ekleme sayfasina yonlendirilir
* "Kredi Kartı", "Uğurcan Söken", "07/27" bilgileri girilerek kart bilgileri doldurulur
* "kartBilgileriSayfasindanGeriDonButonuOD" li element varsa tek tıkla
* Adres bilgisi eksik hata mesaji kontrol edilir
* Profil sayfasindan kart bilgilerim sayfasina gidilir ve kart bilgileri temizlenir

Adres Alanini ve Kart Bilgisini Bos Birakarak Alısverisi Tamamlama
------
tags: adresAlaniniveKartBilgisiniBosBirakarakAlısverisiTamamlama

* Uygulamanin acildigi kontrol edilir
* Test Kullanicisi ile Login Olunur
* Sepetin bos oldugu kontrol edilir ve bos degilse sepet bosaltilir
* Urunler sayfasina gidilir ve random bir urun secilir
* Secilen urun sepete eklenir
* Sepete gidilir
* Sepet onaylanir ve isleme devam edilir
* Kart bilgisi eksik hata mesaji kontrol edilir