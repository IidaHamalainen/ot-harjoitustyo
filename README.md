
# Miinaharava

## Dokumentaatio
[Vaatimusmaarittely](https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/arkkitehtuuri.md)

[Tuntikirjanpito](https://github.com/IidaHamalainen/ot-harjoitustyo/blob/master/Miinaharava/dokumentaatio/tuntikirjanpito.md)

## Releaset
[RELEASE1](https://github.com/IidaHamalainen/ot-harjoitustyo/releases)

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

saa generoitua hakemistoon target jar-tiedoston


### Checkstyle
Checkstyle tarkastukset suoritetaan komennolla 

`mvn jxr:jxr checkstyle:checkstyle`

Virheet saa näkyville elaimeen avaamalla tiedoston checkstyle.html target/site - hakemistosta.
