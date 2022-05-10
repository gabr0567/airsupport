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
afgang Timestamp,
CONSTRAINT PK_Billet_BilletID PRIMARY KEY CLUSTERED 
(BilletID)
)

CREATE TABLE Faktura
(FakturaID int,
KundeID int,
ExMoms float,
InklMoms float,
Destination char,
CVR int,
CONSTRAINT PK_Faktura_FakturaID PRIMARY KEY CLUSTERED 
(FakturaID)
)

CREATE TABLE Tillægsprodukter
(TillægsproduktID int,
Pris float,
Navn char,
CONSTRAINT PK_Tillægsprodukter_tillægsproduktID PRIMARY KEY CLUSTERED 
(tillægsproduktID)
)

CREATE TABLE NuværendeTillægsprodukter
(NTID int,
tillægsprodukt int,
FakturaID int,
Pris float,
UnderFlyvning Bit,
CONSTRAINT PK_nuværendeTillægsprodukter_NTID PRIMARY KEY CLUSTERED 
(NTID)
)

CREATE TABLE Kunde 
(KundeID int,
Navn char,
tlf int,
Email char,
CONSTRAINT PK_Kunde_KundeID PRIMARY KEY CLUSTERED 
(KundeID)
)











