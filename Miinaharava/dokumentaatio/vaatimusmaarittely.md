# Vaatimusmäärittely

## Soveluksen tarkoitus
Sovellus on miinaharava-tyyppinen peli, jossa pelaaja klikkaamalla ruutuja yrittää selviytyä kentästä osumatta pommiin. 
Jos klikatussa ruudussa ei ole pommia, ruutu merkitään avatuksi ja ruudun ympärillä olevissa ruuduissa näytetään, 
kuinka monessa ympäröivässä ruudussa on pommi. Jos pelaaja klikkaa ruutua jonka alta paljastuu pommi, peli päättyy. 
Pelin voittaakseen pelaajan on avattava kaikki ne ruudut, joissa ei ole pommia.

## Käyttöliittymä
Pelissä on graafinen käyttöliittymä. 

## Perusversion tarjoama toiminnallisuus
#### Valikko
* Sovelluksen käynnistyessä näytetään valikko, jonka toiminnot ovat "Aloita peli" joka käynnistää pelin, 
  ja "Lopeta", mikä sulkee sovelluksen. 
  * Lisäksi on listaus edellisten läpäistyjen pelien kestoista- mahdollisesti viisi edellistä näkyy.
* Pelin loppuessa pommiin osumiseen näytetään sivu, jolla kerrotaan että pelaaja hävisi. 
  * Sivulta pääsee takaisin valikkonäkymään "Palaa valikkoon" napin kautta. 
* Vastaavasti jos pelaaja onnistuu avaamaan kaikki ruudut joissa ei ole pommia, 
  ilmoitetaan pelaajan voittaneen. 
  * Sivulla on vastaava "Palaa valikkoon" nappi.
  
#### Pelin aikana
* Ruudun klikkaaminen joko muuttaa ruudun värin (ruutu on avattu), 
  tai jos ruudussa on pommi, avaa pelin loppumisesta kertovan sivun.
* Ensimmäisen ruudun klikkaaminen avaa pienen turvallisten ruutujen alueen, jota pelaaja lähtee laajentamaan.
* Mahdollisuus merkitä pommeiksi epäillyt ruudut eri värillä.
* Avatun ruudun ympärillä oleviin ruutuihin ilmestyy näkyviin numero, 
  joka kertoo kuinka monta pommia kyseisen ruudun ympärillä eli sitä koskettavissa ruuduissa on.
* Ajastin, joka mittaa pelin keston.
  
## Jatkokehitysideoita
* Pommien määrästä kertovien numeroiden eri värit.
* Valikkoon mahdollisuus valita minkä kokoisen ruudukon haluaa pelattavaksi , eli valita vaikeustaso.
* Isompien avattujen alueiden paljastuminen pelin aikana.
