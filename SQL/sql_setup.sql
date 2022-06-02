CREATE DATABASE Airsupport
GO

DROP TABLE [Airsupport].[dbo].[Billet]
DROP TABLE [Airsupport].[dbo].[Tillægsprodukter]
DROP TABLE [Airsupport].[dbo].[NuværendeTillægsprodukter]
DROP TABLE [Airsupport].[dbo].[Fly]
DROP TABLE [Airsupport].[dbo].[Destination]


CREATE TABLE [Airsupport].[dbo].[Billet]
(BilletID int NOT NULL,
Navn varchar(100) NOT NULL,
Til varchar(100) NOT NULL,
Fly int NOT NULL,
Dato date NOT NULL,
Dato2 date,
afgang time(0) NOT NULL,
Afgang2 time(0),
tlf varchar(100) NOT NULL,
Email varchar(100) NOT NULL,
CVR int NOT NULL,
Endt Bit NOT NULL,
billetPris float NOT NULL,
CONSTRAINT PK_Billet_BilletID PRIMARY KEY CLUSTERED 
(BilletID)
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
Navn varchar(100) NOT NULL,
tillægsprodukt int NOT NULL,
BilletID int NOT NULL,
Pris float NOT NULL,
Antal int NOT NULL,
CONSTRAINT PK_nuværendeTillægsprodukter_NTID PRIMARY KEY CLUSTERED 
(NTID)
)

CREATE TABLE [Airsupport].[dbo].[Fly]
(FlyID int NOT NULL,
Navn varchar(100) NOT NULL,
Placering char(3) NOT NULL,
Pladser int NOT NULL,
Status Bit NOT NULL,
CONSTRAINT PK_Fly_FlyID PRIMARY KEY CLUSTERED 
(FlyID)
)

CREATE TABLE [Airsupport].[dbo].[Destination]
(DestinationID int NOT NULL,
Destination varchar(100) NOT NULL,
Abbreviation char(3) NOT NULL,
Tur float NOT NULL, 
Retur float NOT NULL,
CONSTRAINT PK_Destination_DestinationID PRIMARY KEY CLUSTERED 
(DestinationID)

)


INSERT INTO [Airsupport].[dbo].[Tillægsprodukter] (TillægsproduktID, Pris,Navn,Aktiv)
VALUES (1,40,'Allergi', 1), (2, 55, 'Glutenfri', 0),(3, 90, 'Diabetikeren', 1),(4, 250, 'Luksus', 0),
(5, 25, 'Sodavand', 1),(6, 125, 'Pinot Noir de France 2020', 1),(7, 500, 'Huber Eiswein 2016', 1),
(8, 350, 'Udsigt og information', 1),(9, 50, 'Is', 1),(10, 650, 'Fotografi', 1),
(11, 850, 'Speciel bagage håndtering', 1)

INSERT INTO [Airsupport].[dbo].[Fly] (FlyID, Navn, Pladser, Placering, Status)
VALUES (1, 'Cessna Citation V', 8, 'BLL', 1), (2, 'Cessna Citation V', 8, 'BLL', 1), (3, 'Cessna Citation V', 8, 'BLL', 1),
(4, 'Cessna Citation V', 8, 'BLL', 1), (5, 'Cessna Citation V', 8, 'STN', 0)



INSERT INTO [Airsupport].[dbo].[Billet] (BilletID, Navn, Til, Fly, Dato, Dato2, afgang, Afgang2, tlf, Email, CVR, Endt, billetPris)
VALUES (412,'Bo Hansen', 'CPH', 3, '2022-5-20', '2022-5-27', '18:00:00', '21:55:00', '89304820','ofbton@gmail.com',0,0,359.9)

INSERT INTO [Airsupport].[dbo].[Destination] (DestinationID, Destination, Abbreviation, Tur, Retur)
VALUES (1, 'London Stansted Airport', 'STN', 249.95, 349.95)

















