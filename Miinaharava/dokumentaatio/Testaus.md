# Testausdokumentti

Testasin ohjelmaa manuaalisesti järjestemätasolla sovelluksen kehityksen ajan. 
Ohjelmaa on testattu myös JUnit yksikkötesteillä.

## Yksikkö- ja integraatiotestaus
### sovelluslogiikka

Sovelluslogiikkaa eli paketin model luokkia ja MiinaharavaLogic-luokkaa testaavat MiinaharavaTest luokan yksikkötestit.
Integraatiotesti TimeServiceTest testaa TimeService olion toiminnallisuuksia, eli pelin ajan tallentamista.
TimeServiceTest käyttää DAO-rajapinnan TimeDao muistitoteutusta

### DAO-luokat

Dao-luokkaa TimeDao testataan tilpäistä JUnit TemporaryFolder-rulea ja valekomponentteja hyödyntäen.

### Testikattavuus

Sovelluksen testauksen rivikattavuus on 96% ja haaraumakattavuus 90%.
Testaamatta jäi tilanteita, joissa metodin käsketään jossain tilanteessa jossa ehdot eivät täyty jatkaa.
<img src="https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kuvat/testikattavuus.png" width="600">


Sovellusta on testattu sekä niin että ajat tallentava tiedosto on ollut olemassa, että niin että sovellus on luonut sen itse.

### Sovelluksen laatuongelmat

Varsinkin asetuksella helppo (isot ruudut) hiiri on hiukan epätarkka, ja saattaa osoittaa eri ruutuun kuin tarkoitus.
