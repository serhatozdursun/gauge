hepsiburada Login Senaryoları
==========================

This is an executable specification file. This file follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.
To execute this specification, use `mvn test`
   |userName                |userPassword |user         |
   |------------------------|-------------|-------------|
   |gaugesenaryo@hubopss.com|gauge1Q2w3e4r|Gauge Senaryo|


Başarılı Giriş Senaryosu
-----------
Tags: SuccessLogin
* hepsiburada girişe tıkladı
* giriş sayfası açıldı
* "4" saniye bekle
* kullanıcı adı kısmına <userName> girildi
* şifre <userPassword> girildi
* giriş yap tıklandı
* <user> ile giriş yapıldı

