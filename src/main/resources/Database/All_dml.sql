USE nmr;
INSERT INTO accessory (available, name, price, rented_out, total_stock)
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
       ('Nayeem','Hossain','Nayeem.Hossain@gmail.com','63547894','Roskildevej 32','Frederiksberg','Sales Assistent',FALSE),
       ('Admin','Admin','Admin@admin.com','11111111','Adminstreet','Admincity','Owner',TRUE);



INSERT INTO motorhome_type (type)
VALUES ('Urban Plus Motorhomes'),
       ('Compact Plus Motorhomes'),
       ('Family Plus Motorhomes'),
       ('Premium Plus Motorhomes'),
       ('Urban Luxury Motorhomes'),
       ('Compact Luxury Motorhomes'),
       ('Family Luxury Motorhomes'),
       ('Premium Luxury Motorhomes');


INSERT INTO motorhome (type, brand, model, beds, price)
VALUES (1,'Sunlight ','Cliff 600',2,1382.24),
       (1,'Toyota ','Hiace',2,1382.24),
       (1,'ChassisMercedes','Venturer',2,1382.24),
       (1,'Mercedes-Benz Vito','Apollo',4,1382.24),
       (1,'Mercedes-Benz X-Class',' X-Terrain',4,1382.24),

       (2,'Sunlight ', 'V60',2,2418.58),
       (2,'Dethleffs', 'Pulse T 7051 DBL',2,2418.58),
       (2,'Fiat', 'Ducato MH2',3,2418.58),
       (2,'Ford','C19',4,2418.58),

       (3,'Sunlight', 'A68', 6,2764.12),
       (3,'Ford','C25',5,2764.12),
       (3,'Fiat', 'Ducato 130',4,2764.12),
       (3,'Volkswagen', 'Marling',4,2764.12),

       (4,'Bavaria', 'A65', 4,2764.12),
       (4,'Fiat', 'Bürstner',5,2764.12),
       (4,'Fiat', 'Moovéo C 707',6,2764.12),
       (4,'Mercedes Benz', 'Sprinter 616' ,6 ,2764.12),

       (5,'Volkswagen','T6',2,691.14),
       (5,'Volkswagen','T6',4,691.14),
       (5,'Mercedes', 'Marco Polo',2,691.14),
       (5,'Mercedes', 'Marco Polo',4,691.14),
       (5,'Mercedes', 'Marco Polo',4,691.14),

       (6,'Sunlight', 'I67S',2,2418.58),
       (6,'Dethleffs', 'Pulse Classic 90 T 7051 EB',4,2418.58),
       (6,'Mercedes Benz','Discovery',4,2418.58),
       (6,'Tiffin','WAYFARER', 5,2418.58),

       (7,'Sunlight', 'T67', 4,2764.12),
       (7,'Adria', 'Matrix Axess',5,2764.12),
       (7,'Ford','MA33',6,2764.12),
       (7,'Volkswagen','River',6,2764.12),

       (8,'Bailey', 'Autograph 81-6', 6,3110.04),
       (8,'Adria', 'Coral XL 670', 6,3110.04);

/*INSERT INTO user (email, password, username, emp_email)
VALUES ('Admin@admin.com', '1234', 'admin');*/








