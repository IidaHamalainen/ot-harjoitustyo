# Käyttöohje

### Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

`java -jar miinaharava.jar`

Sovellus aukeaa aloitusvalikkoon. Valikossa voi valita haluamansa vaikeusasteen eli 
miinakentän koon painamalla nappia, tällöin teksti nappien yläpuolella kertoo mikä 
vaikeustaso on valittuna.

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/aloitus1.png" width="400">

Oikeassa reunassa on tulosten listaus, josta näkee edellisten pelien keston ja 
voitettiinko vai hävittiinkö peli.

Peli aloitetaan Aloita- nappia painamalla. Näkymä siirtyy pelitilaan, 
josta pääsee takaisin valikkoon Palaa valikkoon- nappia painamalla.


### Pelaaminen
Peli aloitetaan klikkaamalla hiiren vasemmalla painikkeella jotain ruuduista. 
Ruutu ja sen ympärillä olevat ruudut aukeavat ja näyttävät vihjenumeron. 

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/peli1.png" width="400">


Numero kertoo, kuinka monta miinaa ruudun naapurissa on. Epäillyn miinan voi merkitä 
punaisella klikkaamalla ruutua hiiren oikealla painikkeella. Jos pelaaja klikkaa auki ruudun, 
jossa on miina, pelaaja häviää ja kentän yläpuolelle tulee teksti Hävisit! 
Pelikenttä myös aukeaa paljastaen miinojen sijainnit. 
Jos pelaaja onnistuu avaamaan kaikki ruudut joissa ei ole miinaa, peli on voitettu,
ja yläpuolelle tulee voitosta kertova teksti. Pelikentän oikeassa reunassa näkyy sekunteja laskeva ajastin.

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/peliloppu1.png" width="400">

Uuden pelin pääsee aloittamaan palaamalla valikkoon ja valitsemalla haluamansa vaikeustason.
