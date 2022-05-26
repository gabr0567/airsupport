CREATE DATABASE Airsupport
GO

DROP TABLE [Airsupport].[dbo].[Billet]
DROP TABLE [Airsupport].[dbo].[Faktura]
DROP TABLE [Airsupport].[dbo].[Tillægsprodukter]
DROP TABLE [Airsupport].[dbo].[NuværendeTillægsprodukter]
DROP TABLE [Airsupport].[dbo].[Kunde]
DROP TABLE [Airsupport].[dbo].[Fly]


CREATE TABLE [Airsupport].[dbo].[Billet]
(BilletID int NOT NULL,
Navn varchar(100) NOT NULL,
Til varchar(100) NOT NULL,
Fly int NOT NULL,
Dato date NOT NULL,
afgang time(7) NOT NULL,
tlf varchar(100) NOT NULL,
Email varchar(100) NOT NULL,
CVR int NOT NULL,
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

CREATE TABLE [Airsupport].[dbo].[Tillægsprodukter]
(TillægsproduktID int NOT NULL,
Pris float NOT NULL,
Navn varchar(100) NOT NULL,
Aktiv Bit NOT NULL,
CONSTRAINT PK_Tillægsprodukter_tillægsproduktID PRIMARY KEY CLUSTERED 
(tillægsproduktID)
)

CREATE TABLE [Airsupport].[dbo].[NuværendeTillægsprodukter]
(NTID int NOT NULL,
tillægsprodukt int NOT NULL,
BilletID int NOT NULL,
Pris float NOT NULL,
UnderFlyvning Bit NOT NULL,
CONSTRAINT PK_nuværendeTillægsprodukter_NTID PRIMARY KEY CLUSTERED 
(NTID)
)

--CREATE TABLE [Airsupport].[dbo].[Kunde]
--(KundeID int NOT NULL,
--Navn varchar(100) NOT NULL,
--tlf int NOT NULL,
--Email varchar(100) NOT NULL,
--CONSTRAINT PK_Kunde_KundeID PRIMARY KEY CLUSTERED 
--(KundeID)
--)

CREATE TABLE [Airsupport].[dbo].[Fly]
(FlyID int NOT NULL,
Navn varchar(100) NOT NULL,
Placering char(3) NOT NULL,
Pladser int NOT NULL,
Status Bit NOT NULL,
CONSTRAINT PK_Fly_FlyID PRIMARY KEY CLUSTERED 
(FlyID)
)

INSERT INTO [Airsupport].[dbo].[Tillægsprodukter] (TillægsproduktID, Pris,Navn,Aktiv)
VALUES (1,40,'Allergi', 1), (2, 55, 'Glutenfri', 0),(3, 90, 'Diabetikeren', 1),(4, 250, 'Luksus', 0),
(5, 25, 'Sodavand', 1),(6, 125, 'Pinot Noir de France 2020', 1),(7, 500, 'Huber Eiswein 2016', 1),
(8, 350, 'Udsigt og information', 1),(9, 50, 'Is', 1),(10, 650, 'Fotografi', 1),
(11, 850, 'Speciel bagage håndtering', 1)

INSERT INTO [Airsupport].[dbo].[Fly] (FlyID, Navn, Pladser, Placering, Status)
VALUES (1, 'Cessna Citation V', 8, 'BLL', 1), (2, 'Cessna Citation V', 8, 'BLL', 1), (3, 'Cessna Citation V', 8, 'BLL', 1),
(4, 'Cessna Citation V', 8, 'BLL', 1), (5, 'Cessna Citation V', 8, 'STN', 0)



INSERT INTO [Airsupport].[dbo].[Billet] (BilletID, Navn, Til, Fly, Dato, afgang, tlf, Email, CVR)
VALUES (412,'John', 'CPH', 3, '2022-5-20','18:00:00', '89304820','JohnJohnson@live.dk',0)
















