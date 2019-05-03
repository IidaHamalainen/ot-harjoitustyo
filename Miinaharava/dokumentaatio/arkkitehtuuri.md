# Arkkitehtuurikuvaus

## Rakenne
Ohjelma noudattaa neliosaista kerrosarkkitehtuuria:

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/kerrosarkkitehtuuri.png" width="300">

Pakkaus _miinaharava.ui_ sisältää graafisen käyttöliittymän, _miinaharava.logic_ sovelluslogiikan ja _miinaharava.model_ miinaharavan pelikentän ja yksittäisen ruudun koodin. _miinaharava.dao_ sisältää tiedon tallennuksesta vastaavan koodin.


## Käyttöliittymä
Käyttöliittymä sisältää kaksi näkymää, valikon ja pelinäkymän. Molemmat on toteutettu Scene-olioina jotka sijoitetaan stageen. Käyttöliittymä on rakennettu luokassa miinaharava.ui.MiinaharavaUi ja kutsuu MiinaharavaLogicin sovelluslogiikan metodeja.

Luokassa miinaharava.ui.Timer on rakennettu javafx animaatioita käyttävä sekuntikello, joka näkyy pelinäkymän oikeassa reunassa. MiinaharavaUi käyttää Timer-luokkaa kellon näyttämiseen.

## Sovelluslogiikka
Miinaharava-pelin toiminnallisuuden luovat miinaharava.domain luokat Tile ja Minefield. miinaharava.logic.MiinaharavaLogic luokka yhdistää Tilen ja Minefieldin toiminnallisuudet pelin logiikaksi. Luokka GameTime tallentaa Timer-olion tuottaman pelin päättymisajan sen tallentamista varten. TimeService-luokka vastaa ajan tallentamisen logiikasta ja yhdistää käyttöliittymästä saadut pelitiedot GameTime -olion avulla ajan tallentavaan miinaharava.dao pakkauksen luokkaan TimeDao. 

Luokka/pakkaukaavio:

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/luokkajapakkauskaavio.png" width="400">

## Tietojen pysyväistallennus
Pakkauksen miinaharava.dao luokka FileTimeDao tallentaa pelin päättymistiedot tiedostoon times.txt. Luokka noudattaa DAO-suunnittelumallia ja on rajapinnan TimeDao takana. Sovelluksen juureen on sijoitettu konfiguraatiotiedosto _config.properties_, joka määrittelee tiedoston nimen. Ajan eli sekuntien lisäksi tiedostoon tallennetaan pelin tulos ja vaikeustaso puolipisteellä erotettuna muodossa

`234; voitto; helppo`

`45; häviö; vaikea`

## Päätoiminnallisuudet
#### Uuden pelin aloittaminen

Kun käyttäjä klikkaa "Aloita" painiketta, käyttöliittymä luo uuden miinakentän drawMineField -metodilla. Metodi kutsuu logiikan kautta Minefield- luokan miinakentän palauttavaa getMinefield metodia. Minefield luokassa alustetaan uusi kenttä initField metodilla. Uusi kenttä näytetään pelinäkymässä stage.setScene(gameScene) metodin asettamana. Samalla sekuntikello käynnistyy gameTimer.start() metdilla.

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/sekvenssikaavio.png" width="600">


## Ohjelman rakenteeseen jääneet heikkoudet
Käyttöliittymän luova luokka MiinaharavaUi rakentui varsin laajaksi, ja näkymät olisi voinut jakaa omiksi luokikseen selkeyden lisäämikseksi. Pakkausrakenne on tällä hetkellä aika monimutkainen, joten sitä olisi ehkä pystynyt parantamaan.
