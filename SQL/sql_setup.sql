CREATE TABLE Billet
(BilletID int,
KundeID int,
Navn char,
Til char,
Fra char,
Fly int,
Dato date,
S�de int,
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

CREATE TABLE Till�gsprodukter
(Till�gsproduktID int,
Pris float,
Navn char,
CONSTRAINT PK_Till�gsprodukter_till�gsproduktID PRIMARY KEY CLUSTERED 
(till�gsproduktID)
)

CREATE TABLE Nuv�rendeTill�gsprodukter
(NTID int,
till�gsprodukt int,
FakturaID int,
Pris float,
UnderFlyvning Bit,
CONSTRAINT PK_nuv�rendeTill�gsprodukter_NTID PRIMARY KEY CLUSTERED 
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











