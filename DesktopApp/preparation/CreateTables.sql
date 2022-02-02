.tables
/* create the TABLES */
CREATE TABLE IF NOT EXISTS kunde (
    id INTEGER PRIMARY KEY,
    nachname VARCHAR,
    vorname VARCHAR
);

CREATE TABLE IF NOT EXISTS adresse (
    id INTEGER PRIMARY KEY,
    strasse VARCHAR,
    h_nr VARCHAR(10),
    ort VARCHAR,
    plz INTEGER(5)
);

CREATE TABLE IF NOT EXISTS adressart (
    id INTEGER PRIMARY KEY,
    art VARCHAR
);

CREATE TABLE IF NOT EXISTS kundenadresse (
    k_id INT,
    a_id INT,
    PRIMARY KEY (k_id, a_id),
    FOREIGN KEY(k_id) REFERENCES kunde(id),
    FOREIGN KEY(a_id) REFERENCES adresse(id)
);

CREATE TABLE IF NOT EXISTS adresse_art (
    adresse_id INT,
    art_id INT,
    PRIMARY KEY (adresse_id, art_id),
    FOREIGN KEY(art_id) REFERENCES adressart(id),
    FOREIGN KEY(adresse_id) REFERENCES adresse(id)
);

CREATE TABLE IF NOT EXISTS rechnung (
    id INTEGER PRIMARY KEY,
    datum DATE,
    gesamtbetrag DECIMAL(7,2),
    kunde_id INTEGER,
    FOREIGN KEY(kunde_id) REFERENCES kunde(id)
);

CREATE TABLE IF NOT EXISTS rechnungsadresse (
    r_id INT,
    a_id INT,
    PRIMARY KEY (r_id, a_id),
    FOREIGN KEY(r_id) REFERENCES rechnung(id),
    FOREIGN KEY(a_id) REFERENCES adresse(id)
);

CREATE TABLE IF NOT EXISTS rechnung (
    id INTEGER PRIMARY KEY,
    datum DATE,
    gesamtbetrag DECIMAL(7,2),
    kunde_id INTEGER,
    FOREIGN KEY(kunde_id) REFERENCES kunde(id)
);

CREATE TABLE IF NOT EXISTS position (
    id INTEGER PRIMARY KEY,
    menge INTEGER,
    preis DECIMAL(7,2),
    rechnung_id INTEGER,
    artikel_id INTEGER,
    FOREIGN KEY(rechnung_id) REFERENCES rechnung(id),
    FOREIGN KEY(artikel_id) REFERENCES artikel(id)
);

CREATE TABLE IF NOT EXISTS artikel (
    id INTEGER PRIMARY KEY,
    preis DECIMAL(7,2),
    beschreibung VARCHAR
);

CREATE TABLE IF NOT EXISTS bild (
    id INTEGER PRIMARY KEY,
    bild VARBINARY,
    artikel_id INTEGER,
    FOREIGN KEY(artikel_id) REFERENCES artikel(id)
);

CREATE TABLE IF NOT EXISTS kategorie (
    id INTEGER PRIMARY KEY,
    bezeichnung VARCHAR
);

CREATE TABLE IF NOT EXISTS artikelkategorie (
    a_id INT,
    k_id INT,
    PRIMARY KEY (a_id, k_id),
    FOREIGN KEY(k_id) REFERENCES kategorie(id),
    FOREIGN KEY(a_id) REFERENCES artikel(id)
);

CREATE TABLE IF NOT EXISTS interpret (
    id INTEGER PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE IF NOT EXISTS artikelinterpret (
    a_id INT,
    i_id INT,
    PRIMARY KEY (a_id, i_id),
    FOREIGN KEY(i_id) REFERENCES interpret(id),
    FOREIGN KEY(a_id) REFERENCES artikel(id)
);

.tables