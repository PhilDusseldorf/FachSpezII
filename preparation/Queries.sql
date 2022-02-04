/* Query for finding all adresses of all kunden
SELECT kunde.nachname, kunde.vorname, adresse.ort, adresse.strasse, adresse.h_nr FROM kunde
JOIN kundenadresse ON kunde.id = kundenadresse.k_id
JOIN adresse ON kundenadresse.a_id = adresse.id
ORDER BY ort, strasse, h_nr;
*/

/* Query for finding all unique customers from Musterstadt
SELECT DISTINCT kunde.id, kunde.vorname, kunde.nachname FROM kunde
JOIN kundenadresse ON kunde.id = kundenadresse.k_id
JOIN adresse ON kundenadresse.a_id = adresse.id
WHERE ort = "Musterstadt"
ORDER BY nachname;
*/

/* Query for finding all articles (with name, interpreter)
SELECT interpret.name AS Künstler, artikel.name AS Album FROM artikel
JOIN artikelinterpret ON artikel.id = artikelinterpret.a_id
JOIN interpret ON interpret.id = artikelinterpret.i_id
ORDER BY interpret.name;
*/

/* Select the price of an article
*/
