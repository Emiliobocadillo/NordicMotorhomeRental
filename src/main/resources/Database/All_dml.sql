USE nmr;
INSERT INTO accessory (available, name, price_per_day, rented_out, total_stock)
VALUES ('20', 'Large BBQ', '30', '0', '32'),
       ('20', 'Small BBQ', '25', '0', '32'),
       ('20', 'Child seat', '20', '0', '32'),
       ('20', 'Baby seat', '20', '0', '32'),
       ('50', 'Foldable Chair', '10', '0', '50'),
       ('32', 'Table', '40', '20', '32'),
       ('25', 'Bicycle', '50', '0', '25'),
       ('15', 'Paddleboard', '40', '0', '32'),
       ('32', 'Kayak', '40', '0', '32'),
       ('32', 'Bedding kit', '20', '0', '32');

INSERT INTO employee (firstname, lastname, email, phone_nr, address, city, job_title, admin)
VALUES ('Douglas','Beaver','douglas.beaver@gmail.com','52525252','falkoner alle 86 st. tv','Frederiksberg','owner',TRUE),
       ('Hanna','Beaver','Hanna.beaver@gmail.com','41414141','falkoner alle 86 st. tv','Frederiksberg','owner',TRUE),
       ('Emil','Høeg Engelbrechtsen','Emil.Engelbrechtsen@gmail.com','63541245','Ny Carlsberg Vej 40','København V','Bookkeeper',FALSE),
       ('sarah','Hansen','Sarah.Hansen@gmail.com','51423654','skolesiden 17','Brønshøj','Cleaning Staff',FALSE),
       ('Brian','Sørensen','Brian.Sørensen@gmail.com','45678945','nørre farimagsgade 25','København K','Cleaning Staff',FALSE),
       ('Anders','knudsen','Anders.Knudsen@gmail.com','15647895','Vigerslev Allé  21','Valby','Auto Mechanic',FALSE),
       ('Simone','Jensen','Simone.Jensen@gmail.com','63548951','øster farimagsgade 25','København K','Sales Assistent',FALSE),
       ('Kim','Keiser','Kim.Keiser@gmail.com','6578945','Skelbækgade 3','København','Sales Assistent',FALSE),
       ('Martin','Hansen','Martin.Hansen@gmail.com','52404922','Smedetoften 20','København NV','Sales Assistent',FALSE),
       ('Nayeem','Hossain','Nayeem.Hossain@gmail.com','63547894','Roskildevej 32','Frederiksberg','Sales Assistent',FALSE);


INSERT INTO motorhome_type (type, price)
VALUES ('Urban Plus Motorhomes', 1382),
       ('Compact Plus Motorhomes',2419),
       ('Family Plus Motorhomes', 2764),
       ('Premium Plus Motorhomes', 2764),
       ('Urban Luxury Motorhomes', 691),
       ('Compact Luxury Motorhomes', 2419),
       ('Family Luxury Motorhomes', 2764),
       ('Premium Luxury Motorhomes', 3110);


INSERT INTO motorhome (type, brand, model, beds)
VALUES (1,'Sunlight ','Cliff 600',2),
       (1,'Toyota ','Hiace',2),
       (1,'ChassisMercedes','Venturer',2),
       (1,'Mercedes-Benz Vito','Apollo',4),
       (1,'Mercedes-Benz X-Class',' X-Terrain',4),

       (2,'Sunlight ', 'V60',2),
       (2,'Dethleffs', 'Pulse T 7051 DBL',2),
       (2,'Fiat', 'Ducato MH2',3),
       (2,'Ford','C19',4),

       (3,'Sunlight', 'A68', 6),
       (3,'Ford','C25',5),
       (3,'Fiat', 'Ducato 130',4),
       (3,'Volkswagen', 'Marling',4),

       (4,'Bavaria', 'A65', 4),
       (4,'Fiat', 'Bürstner',5),
       (4,'Fiat', 'Moovéo C 707',6),
       (4,'Mercedes Benz', 'Sprinter 616' ,6),

       (5,'Volkswagen','T6',2),
       (5,'Volkswagen','T6',4),
       (5,'Mercedes', 'Marco Polo',2),
       (5,'Mercedes', 'Marco Polo',4),
       (5,'Mercedes', 'Marco Polo',4),

       (6,'Sunlight', 'I67S',2),
       (6,'Dethleffs', 'Pulse Classic 90 T 7051 EB',4),
       (6,'Mercedes Benz','Discovery',4),
       (6,'Tiffin','WAYFARER', 5),

       (7,'Sunlight', 'T67', 4),
       (7,'Adria', 'Matrix Axess',5),
       (7,'Ford','MA33',6),
       (7,'Volkswagen','River',6),

       (8,'Bailey', 'Autograph 81-6', 6),
       (8,'Adria', 'Coral XL 670', 6);








