# Vaatimusmäärittely

## Sovelluksen tarkoitus
Sovellus on miinaharava-tyyppinen peli, jossa pelaaja klikkaamalla ruutuja yrittää selviytyä kentästä osumatta pommiin. 
Jos klikatussa ruudussa ei ole pommia, ruutu merkitään avatuksi ja ruudun ympärillä olevissa ruuduissa näytetään, 
kuinka monessa ympäröivässä ruudussa on pommi. Jos pelaaja klikkaa ruutua jonka alta paljastuu pommi, peli päättyy. 
Pelin voittaakseen pelaajan on avattava kaikki ne ruudut, joissa ei ole pommia.

## Käyttöliittymä
Pelissä on graafinen käyttöliittymä. Käyttöliittymä koostuu kahdesta eri näkymästä, joista ensimmäinen (valikko) näytetään sovelluksen avautuessa. Valikosta pääsee nappia painamalla valitsemaan pelin vaikeustason, ja ALoita-napista siirrytään pelinäkymään.

## Perusversion tarjoamat toiminnallisuudet
#### Valikko
* Sovelluksen käynnistyessä näytetään valikko, jonka toiminnot ovat vaikeustason valitseminen (helppo-normaali-vaikea) sekä "Aloita"-nappi joka käynnistää pelin.
  * Lisäksi on listaus edellisten pelien kestoista, lopputuloksesta (voitto/häviö) ja vaikeustasosta.
* Pelin loppuessa pommiin osumiseen näytetään viesti, jolla kerrotaan että pelaaja hävisi.
* Vastaavasti jos pelaaja onnistuu avaamaan kaikki ruudut joissa ei ole pommia, 
  ilmoitetaan pelaajan voittaneen. 
  * Sivulla on "Palaa valikkoon" nappi, josta pääsee takaisin valikkonäkymään.
  
#### Pelin aikana
* Ruudun klikkaaminen vasemmalla hiiren painikkeella joko muuttaa ruudun värin valkoiseksi (ruutu on avattu), 
  tai jos ruudussa on pommi, avaa pelin loppumisesta kertovan viestin ja koko kentän.
* Ensimmäisen ruudun klikkaaminen avaa pienen turvallisten ruutujen alueen, jota pelaaja lähtee laajentamaan.
* Mahdollisuus merkitä pommeiksi epäillyt ruudut eri värillä hiiren oikealla painikkeella klikkaamalla.
* Avatun ruudun ympärillä oleviin ruutuihin ilmestyy näkyviin numero, 
  joka kertoo kuinka monta pommia kyseisen ruudun ympärillä eli sitä koskettavissa ruuduissa on.
* Ajastin, joka mittaa pelin keston. Kun peli on hävitty tai voitettu, ajastin pysäsähtyy ja aika tallennetaan tiedostoon ja näkyy valikon listassa.
  
## Jatkokehitysideoita
Toteuttamatta jääneitä kehitysideoita:
* Pommien määrästä kertovien numeroiden eri värit.
* Isompien avattujen alueiden paljastuminen pelin aikana. Tämä toimii osittain, mutta tarkoituksena oli alun perin että numeroa nolla ei näytettäisi, vaan sen sijaan aukeaisi isompi alue.
* Pommien ja lippujen korvaaminen sopivilla kuvilla
