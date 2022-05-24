DROP TABLE [Airsupport].[dbo].[Billet]
DROP TABLE [Airsupport].[dbo].[Faktura]
DROP TABLE [Airsupport].[dbo].[Till�gsprodukter]
DROP TABLE [Airsupport].[dbo].[Nuv�rendeTill�gsprodukter]
DROP TABLE [Airsupport].[dbo].[Kunde]
DROP TABLE [Airsupport].[dbo].[Fly]


CREATE TABLE [Airsupport].[dbo].[Billet]
(BilletID int NOT NULL,
KundeID int NOT NULL,
Navn varchar(100) NOT NULL,
Til varchar(100) NOT NULL,
Fly int NOT NULL,
Dato date NOT NULL,
S�de int NOT NULL,
Gate varchar(100) NOT NULL,
afgang time(7) NOT NULL,
CONSTRAINT PK_Billet_BilletID PRIMARY KEY CLUSTERED 
(BilletID)
)

CREATE TABLE [Airsupport].[dbo].[Faktura]
(FakturaID int NOT NULL,
KundeID int NOT NULL,
ExMoms float NOT NULL,
InklMoms float NOT NULL,
Destination varchar(100) NOT NULL,
CVR int,
CONSTRAINT PK_Faktura_FakturaID PRIMARY KEY CLUSTERED 
(FakturaID)
)

CREATE TABLE [Airsupport].[dbo].[Till�gsprodukter]
(Till�gsproduktID int NOT NULL,
Pris float NOT NULL,
Navn varchar(100) NOT NULL,
Aktiv Bit NOT NULL,
CONSTRAINT PK_Till�gsprodukter_till�gsproduktID PRIMARY KEY CLUSTERED 
(till�gsproduktID)
)

CREATE TABLE [Airsupport].[dbo].[Nuv�rendeTill�gsprodukter]
(NTID int NOT NULL,
till�gsprodukt int NOT NULL,
FakturaID int NOT NULL,
Pris float NOT NULL,
UnderFlyvning Bit NOT NULL,
CONSTRAINT PK_nuv�rendeTill�gsprodukter_NTID PRIMARY KEY CLUSTERED 
(NTID)
)

CREATE TABLE [Airsupport].[dbo].[Kunde]
(KundeID int NOT NULL,
Navn varchar(100) NOT NULL,
tlf int NOT NULL,
Email varchar(100) NOT NULL,
CONSTRAINT PK_Kunde_KundeID PRIMARY KEY CLUSTERED 
(KundeID)
)

CREATE TABLE [Airsupport].[dbo].[Fly]
(FlyID int NOT NULL,
Navn varchar(100) NOT NULL,
Placering char(3) NOT NULL,
Pladser int NOT NULL,
CONSTRAINT PK_Fly_FlyID PRIMARY KEY CLUSTERED 
(FlyID)
)

INSERT INTO [Airsupport].[dbo].[Till�gsprodukter] (Till�gsproduktID, Pris,Navn,Aktiv)
VALUES (1,40,'Allergi', 1), (2, 55, 'Glutenfri', 0),(3, 90, 'Diabetikeren', 1),(4, 250, 'Luksus', 0),
(5, 25, 'Sodavand', 1),(6, 125, 'Pinot Noir de France 2020', 1),(7, 500, 'Huber Eiswein 2016', 1),
(8, 350, 'Udsigt og information', 1),(9, 50, 'Is', 1),(10, 650, 'Fotografi', 1),
(11, 850, 'Speciel bagage h�ndtering', 1)

INSERT INTO [Airsupport].[dbo].[Fly] (FlyID, Navn, Pladser, Placering)
VALUES (1, 'Cessna Citation V', 8, 'BLL'), (2, 'Cessna Citation V', 8, 'BLL'), (3, 'Cessna Citation V', 8, 'BLL'),
(4, 'Cessna Citation V', 8, 'BLL'), (5, 'Cessna Citation V', 8, 'STN')

INSERT INTO [Airsupport].[dbo].[Billet] (BilletID, KundeID, Navn, Til, Fly, Dato, S�de, Gate, afgang)
VALUES (412,124,'John', 'CPH', 3, '2022-5-20', 4, '3B', '18:00:00')

















