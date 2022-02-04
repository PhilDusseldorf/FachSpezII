
/* fill tables with test data */

-- KUNDEN
DROP TABLE IF EXISTS kunde;
CREATE TABLE IF NOT EXISTS kunde (
    id INTEGER PRIMARY KEY,
    nachname VARCHAR,
    vorname VARCHAR
);
INSERT INTO kunde (nachname, vorname) VALUES ("Müller", "Peter"),
                                            ("Littchen", "Donna"),
                                            ("Rilke", "Rainer"),
                                            ("Briest", "Effi"),
                                            ("Aluhut", "Alois")
;
SELECT * FROM kunde;

-- ADRESSEN
DROP TABLE IF EXISTS adresse;
CREATE TABLE IF NOT EXISTS adresse (
    id INTEGER PRIMARY KEY,
    strasse VARCHAR,
    h_nr VARCHAR(10),
    ort VARCHAR,
    plz INTEGER(5)
);
INSERT INTO adresse (strasse, h_nr, ort, plz) 
VALUES 
    ("Schlossallee", "12 b", "Musterstadt", 99111),
    ("Schlossallee", "129", "Musterstadt", 99111),
    ("Goethestrasse", "47", "Musterstadt", 99122),
    ("Goethestrasse", "1212", "Neustadt", 90110),
    ("Fleigenweg", "10 q", "Neustadt", 90771),
    ("Gurkenweg", "7", "Einmachstadt", 34567),
    ("Zwiebelweg", "542", "Einmachstadt", 34567),
    ("Charlottenallee", "129", "Trauerheim", 56732)
;
SELECT * FROM adresse;

-- ADRESSARTEN
DROP TABLE IF EXISTS adressart;
CREATE TABLE IF NOT EXISTS adressart (
    id INTEGER PRIMARY KEY,
    art VARCHAR
);
INSERT INTO adressart VALUES (0, "Lieferadresse"),
                            (1, "Rechnungsadresse")
;
SELECT * FROM adressart;

-- ZWISCHENTABELLE: KUNDENADRESSEN
DROP TABLE IF EXISTS kundenadresse;
CREATE TABLE IF NOT EXISTS kundenadresse (
    k_id INT,
    a_id INT,
    PRIMARY KEY (k_id, a_id),
    FOREIGN KEY(k_id) REFERENCES kunde(id),
    FOREIGN KEY(a_id) REFERENCES adresse(id)
);
INSERT INTO kundenadresse VALUES
    (5,3),
    (5,1),
    (3,1),
    (1,4),
    (2,5),
    (2,2),
    (3,6),
    (4,7)
;
SELECT * FROM kundenadresse;

-- ZWISCHENTABELLE: ADRESSE/ART
DROP TABLE IF EXISTS adresse_art;
CREATE TABLE IF NOT EXISTS adresse_art (
    adresse_id INT,
    art_id INT,
    PRIMARY KEY (adresse_id, art_id),
    FOREIGN KEY(art_id) REFERENCES adressart(id),
    FOREIGN KEY(adresse_id) REFERENCES adresse(id)
);
INSERT INTO adresse_art VALUES
    (1,0),
    (3,0),
    (4,0),
    (5,0),
    (6,0),
    (7,0),
    (8,0),
    (1,1),
    (2,1),
    (4,1),
    (5,1),
    (6,1),
    (7,1),
    (8,1);
SELECT * FROM adresse_art;

-- RECHNUNGEN
DROP TABLE IF EXISTS rechnung;
CREATE TABLE IF NOT EXISTS rechnung (
    id INTEGER PRIMARY KEY,
    datum DATE,
    gesamtbetrag DECIMAL(7,2),
    kunde_id INTEGER,
    FOREIGN KEY(kunde_id) REFERENCES kunde(id)
);
INSERT INTO rechnung VALUES
    (1, '2021-10-06', '12,99', 5),
    (2, '2021-07-01', '64,99', 4),
    (3, '2021-10-31', '763,99', 3),
    (4, '2021-09-27', '11,99', 2),
    (5, '2022-01-31', '9,99', 1),
    (6, '2022-01-17', '123,99', 4);
SELECT * FROM rechnung;

-- ZWISCHENTABELLE: RECHNUNGSADRESSEN
DROP TABLE rechnungsadresse;
CREATE TABLE IF NOT EXISTS rechnungsadresse (
    r_id INT,
    a_id INT,
    PRIMARY KEY (r_id, a_id),
    FOREIGN KEY(r_id) REFERENCES rechnung(id),
    FOREIGN KEY(a_id) REFERENCES adresse(id)
);
INSERT INTO rechnungsadresse VALUES
    (1,1),
    (2,7),
    (3,6),
    (4,2),
    (5,4),
    (6,7)
;
SELECT * FROM rechnungsadresse;

-- POSITIONEN
DROP TABLE IF EXISTS position;
CREATE TABLE IF NOT EXISTS position (
    id INTEGER PRIMARY KEY,
    menge INTEGER,
    preis DECIMAL(7,2),
    rechnung_id INTEGER,
    artikel_id INTEGER,
    FOREIGN KEY(rechnung_id) REFERENCES rechnung(id),
    FOREIGN KEY(artikel_id) REFERENCES artikel(id)
);
INSERT INTO position(menge, rechnung_id, artikel_id) VALUES
(1, 1, 1),
(1, 1, 2),
(1, 1, 3),
(1, 1, 4),
(2, 2, 4),
(1, 2, 6),
(10, 3, 8),
(1, 4, 4),
(1, 4, 2),
(1, 5, 6),
(3, 6, 6),
(4, 6, 7)
;

-- ARTIKEL IM SHOP
DROP TABLE IF EXISTS artikel;
CREATE TABLE IF NOT EXISTS artikel (
    id INTEGER PRIMARY KEY,
    name VARCHAR,
    preis DECIMAL(7,2),
    beschreibung VARCHAR
);
INSERT INTO artikel VALUES
    (1, "19", '6,99', "Einfach nur bezaubernd. Eine Woge der guten Energien."),
    (2, "21", '8,99', "Da war sie 21 Jahre alt. So viel Kraft und Schönheit."),
    (3, "25", '9,99', "Nicht mehr so stark, aber trotzdem ein Teil ihrer arstistischen Reise. Danke Adele!"),
    (4, "30", '19,99', "Was? Jetzt ist sie dünn? Nee, gar nicht mehr meine Musik! Und der Preis? Unverschämt!"),
    (5, "Greatest Hits", '19,94', "War als Kind gerne auf seinen Konzerten. Wurde leider nie von ihm eingeladen. Trotzdem tolle Musik."),
    (6, "Hin und Weg", '5,99', "Titel kann auch auf seine geistige Verfassung bezogen werden. Erst hin zu den Spinnern und jetzt ist die Karriere weg. Tolle Musik!"),
    (7, "Nicht von dieser Welt", '8,49', "Echt nicht von dieser Welt, der Mann! Wie kann man nur so viel Kappes glauben?"),
    (8, "Mama hört noch CD!", '0,99', "Hab für meine Mama ein Mixtape gemacht. Schöne Lieder! Sehr zu empfehlen für die Generation 60+!")
;
SELECT * FROM artikel;

-- BILDER
DROP TABLE IF EXISTS bild;
CREATE TABLE IF NOT EXISTS bild (
    id INTEGER PRIMARY KEY,
    bild TEXT,
    artikel_id INTEGER,
    FOREIGN KEY(artikel_id) REFERENCES artikel(id)
);
INSERT INTO bild VALUES
    (1, "19Adele", 1),
    (2, "21Adele", 2),
    (3, "25Adele", 3),
    (4, "30Adele", 4),
    (5, "MickJackson", 5),
    (6, "HuWXN", 6),
    (7, "NvdWXN", 7),
    (8, "MhnCD", 8)
;
SELECT * FROM bild;

-- KATEGORIEN
DROP TABLE IF EXISTS kategorie;
CREATE TABLE IF NOT EXISTS kategorie (
    id INTEGER PRIMARY KEY,
    bezeichnung VARCHAR
);
INSERT INTO kategorie VALUES
    (1, "Popmusik"),
    (2, "englischsprachig"),
    (3, "deutschsprachig"),
    (4, "Kompilation")

;
SELECT * FROM kategorie;

-- Kategorien nach Artikeln
DROP TABLE IF EXISTS artikelkategorie;
CREATE TABLE IF NOT EXISTS artikelkategorie (
    a_id INT,
    k_id INT,
    PRIMARY KEY (a_id, k_id),
    FOREIGN KEY(k_id) REFERENCES kategorie(id),
    FOREIGN KEY(a_id) REFERENCES artikel(id)
);
INSERT INTO artikelkategorie VALUES
    (1,1),
    (2,1),
    (3,1),
    (4,1),
    (5,1),
    (6,1),
    (7,1),
    (8,1),
    (1,2),
    (2,2),
    (3,2),
    (4,2),
    (5,2),
    (8,2),
    (6,3),
    (7,3),
    (8,3),
    (8,4)
;
SELECT * FROM artikelkategorie;

-- INTERPRETEN
DROP TABLE IF EXISTS interpret;
CREATE TABLE IF NOT EXISTS interpret (
    id INTEGER PRIMARY KEY,
    name VARCHAR
);
INSERT INTO interpret VALUES
(0, "Various"),
(1, "Adele"),
(2, "Michael Jackson"),
(3, "Xavier Naidoo")
;
SELECT * FROM interpret;

-- Interpreten nach Artikeln
DROP TABLE IF EXISTS artikelinterpret;
CREATE TABLE IF NOT EXISTS artikelinterpret (
    a_id INT,
    i_id INT,
    PRIMARY KEY (a_id, i_id),
    FOREIGN KEY(i_id) REFERENCES interpret(id),
    FOREIGN KEY(a_id) REFERENCES artikel(id)
);
INSERT INTO artikelinterpret VALUES
    (1,1),
    (2,1),
    (3,1),
    (4,1),
    (5,2),
    (6,3),
    (7,3),
    (8,0)
;
SELECT * FROM artikelinterpret;