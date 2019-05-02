# Arkkitehtuurikuvaus

## Rakenne
Ohjelma noudattaa neliosaista kerrosarkkitehtuuria:

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/kerrosarkkitehtuuri.png" width="300">

Pakkaus _miinaharava.ui_ sisältää graafisen käyttöliittymän, _miinaharava.logic_ sovelluslogiikan ja _miinaharava.model_ miinaharavan pelikentän ja yksittäisen ruudun koodin. Miinaharava.dao sisältää tiedon tallennuksesta vastaavan koodin.


## Käyttöliittymä
Käyttöliittymä sisältää kaksi eri näkymää, valikon ja pelinäkymän. Molemmat on toteutettu Scene-olioina jotka sijoitetaan stageen. Käyttöliittymä on rakennettu luokassa miinaharava.ui.MiinaharavaUi. ja kutsuu MiinaharavaLogicin sovelluslogiikan metodeja.

Luokassa miinaharava.ui.Timer on rakennettu javafx animaatioita käyttävä sekuntikello, joka näkyy pelinäkymän oikeassa reunassa.

## Sovelluslogiikka
Miinaharava-pelin toiminnallisuuden luovat miinaharava.domain luokat Tile ja Minefield. miinaharava.logic.MiinaharavaLogic luokka yhdistää Tilen ja Minefieldin toiminnallisuudet pelin logiikaksi. Luokka GameTime tallentaa Timer-olion tuottaman pelin päättymisajan tallentamista varten.

Luokka/pakkaukaavio:

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/luokkajapakkauskaavio.png" width="400">

## Tietojen tallennus
Pakkauksen miinaharava.dao luokka FileTimeDao tallentaa pelin päättymisajan tiedostoon times.txt. Luokka noudattaa DAO-suunnittelumallia. Sovelluksen juureen on sijoitettu konfiguraatiotiedosto config.properties, joka määrittelee tiedoston nimen.

## Päätoiminnallisuudet
#### Uuden pelin aloittaminen

Kun käyttäjä klikkaa "Aloita" painiketta, käyttöliittymä luo uuden miinakentän drawMineField -metodilla. Metodi kutsuu logiikan kautta Minefield- luokan miinakentän palauttavaa getMinefield metodia. Minefield luokassa alustetaan uusi kenttä initField metodilla. Uusi kenttä näytetään pelinäkymässä stage.setScene(gameScene) metodin asettamana. Samalla sekuntikello käynnistyy gameTimer.start() metdilla.

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/sekvenssikaavio.png" width="600">
