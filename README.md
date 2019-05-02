
# Miinaharava

## Dokumentaatio

[Käyttöohje](https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/Testaus.md)

[Tuntikirjanpito](https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/tuntikirjanpito.md)

## Releaset
[viikko5](https://github.com/IidaHamalainen/ot-harjoitustyo/releases)

[viikko6](https://github.com/IidaHamalainen/ot-harjoitustyo/releases/tag/viikko6)

[loppupalautus](https://github.com/IidaHamalainen/ot-harjoitustyo/releases/tag/loppupalautus)

## Komentorivitoiminnot
### Testaus
Testit suoritetaan komennolla 

`mvn test`

Kattavuusraportti luodaan komennolla 

`mvn test jacoco:report`

Raporttia pääsee tarkastelemaan selaimeen avaamalla tiedoton index.html target/site/jacoco -hakemistosta

### Suoritettavan jarin generointi
Komennolla 

`mvn packega`

saa generoitua hakemistoon target jar-tiedoston Miinaharava-1.0-SNAPSHOT.jar


### Checkstyle
Checkstyle tarkastukset suoritetaan komennolla 

`mvn jxr:jxr checkstyle:checkstyle`

Virheet saa näkyville selaimeen avaamalla tiedoston checkstyle.html target/site - hakemistosta.

### JavaDoc
JavaDocin saa generoitua komennolla 

`mvn javadoc:javadoc`

JavaDocia voi tarkastella avaamalla selaimessa tiedoston target/site/apidocs/index.html
