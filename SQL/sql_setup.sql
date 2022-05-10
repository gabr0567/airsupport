CREATE TABLE Billet
(BilletID int,
KundeID int,
Navn char,
Til char,
Fra char,
Fly int,
Dato date,
Sæde int,
Gate char,
afgang Timestamp 
)

CREATE TABLE Faktura
(FakturaID int,
KundeID int,
ExMoms float,
InklMoms float,
Destination char,
CVR int
)

CREATE TABLE Tillægsprodukter
(TillægsproduktID int,
Pris float,
Navn char
)

CREATE TABLE NuværendeTillægsprodukter
(NTID int,
tillægsprodukt int,
FakturaID int,
Pris float,
UnderFlyvning Bit
)

CREATE TABLE Kunde 
(KundeID int,
Navn char,
tlf int,
Email char
)










