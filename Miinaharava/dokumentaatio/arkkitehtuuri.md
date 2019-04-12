# Arkkitehtuurikuvaus

## Rakenne
Ohjelma noudattaa komiosaista kerrosarkkitehtuuria:

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/miinaharavarakenne.png" width="300">

Pakkaus _miinaharava.ui_ sisältää graafisen käyttöliittymän, _miinaharava.logic_ sovelluslogiikan ja _miinaharava.model_ miinaharavan pelikentän ja yksittäisen ruudun koodin.

Luokka/pakkaukaavio:

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/luokka-pakkauskaavio.png" width="400">

## Päätoiminnallisuudet
#### Uuden pelin aloittaminen

Kun käyttäjä klikkaa "Aloita" painiketta, käyttöliittymä luo uuden miinakentän drawMineField -metodilla. Metodi kutsuu logiikan kautta Minefield- luokan miinakentän palauttavaa getMinefield metodia. Minefield luokassa alustetaan uusi kenttä initField metodilla. Uusi kenttä näytetään pelinäkymässä stage.setScene(gameScene) metodin asettamana.

<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/sekvenssikaavio.png" width="600">
