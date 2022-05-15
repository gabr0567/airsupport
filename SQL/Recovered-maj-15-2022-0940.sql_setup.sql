DROP TABLE [Airsupport].[dbo].[Billet]
DROP TABLE [Airsupport].[dbo].[Faktura]
DROP TABLE [Airsupport].[dbo].[Tillægsprodukter]
DROP TABLE [Airsupport].[dbo].[NuværendeTillægsprodukter]
DROP TABLE [Airsupport].[dbo].[Kunde]



CREATE TABLE Billet
(BilletID int NOT NULL,
KundeID int NOT NULL,
Navn varchar(100) NOT NULL,
Til varchar(100) NOT NULL,
Fra varchar(100) NOT NULL,
Fly int NOT NULL,
Dato date NOT NULL,
Sæde int NOT NULL,
Gate varchar(100) NOT NULL,
afgang Timestamp NOT NULL,
CONSTRAINT PK_Billet_BilletID PRIMARY KEY CLUSTERED 
(BilletID)
)

CREATE TABLE Faktura
(FakturaID int NOT NULL,
KundeID int NOT NULL,
ExMoms float NOT NULL,
InklMoms float NOT NULL,
Destination varchar(100) NOT NULL,
CVR int,
CONSTRAINT PK_Faktura_FakturaID PRIMARY KEY CLUSTERED 
(FakturaID)
)

CREATE TABLE Tillægsprodukter
(TillægsproduktID int NOT NULL,
Pris float NOT NULL,
Navn varchar(100) NOT NULL,
CONSTRAINT PK_Tillægsprodukter_tillægsproduktID PRIMARY KEY CLUSTERED 
(tillægsproduktID)
)

CREATE TABLE NuværendeTillægsprodukter
(NTID int NOT NULL,
tillægsprodukt int NOT NULL,
FakturaID int NOT NULL,
Pris float NOT NULL,
UnderFlyvning Bit NOT NULL,
CONSTRAINT PK_nuværendeTillægsprodukter_NTID PRIMARY KEY CLUSTERED 
(NTID)
)

CREATE TABLE Kunde 
(KundeID int NOT NULL,
Navn varchar(100) NOT NULL,
tlf int NOT NULL,
Email varchar(100) NOT NULL,
CONSTRAINT PK_Kunde_KundeID PRIMARY KEY CLUSTERED 
(KundeID)
)











