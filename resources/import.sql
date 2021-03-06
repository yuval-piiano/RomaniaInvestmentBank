use RomaniaInvestmentBank;
INSERT INTO Client(id, firstName, lastName, cnp, email, phoneNumber, Address_No, bankAccount_ID, customerAdvisors_No, ClientPassword_No) values("30s60","Suciu","Laurentiu","1870214106069","suciu.lau@gmail.com","0706190058",1,1,1,1)
INSERT INTO Client(id, firstName, lastName, cnp, email, phoneNumber, Address_No) values("t3ayy","Antonescu","Iancu","1941118327494","iancu_antonescu10@yahoo.com","0702060769",2)
INSERT INTO Client(id, firstName, lastName, cnp, email, phoneNumber, Address_No) values("pgzen","Stoica","Vladimir","5000112356574","stoicavladimir@yahoo.com","0706683324",3)
INSERT INTO Client(id, firstName, lastName, cnp, email, phoneNumber, Address_No) values("xkwmp","Gusa","Costache","1950310198829","costi_gusa5@gmail.com","0702053921",4)
INSERT INTO Client(id, firstName, lastName, cnp, email, phoneNumber, Address_No) values("7zxt5","Selymes","Skender","1880814359051","selymes.ske@gmail.com","0780088080",5)
INSERT INTO Client(id, firstName, lastName, cnp, email, phoneNumber, Address_No) values("3jyfj","Milosovici","Carol","1991224188035","carolmilosovici@yahoo.com","0702080818",6)
INSERT INTO Client(id, firstName, lastName, cnp, email, phoneNumber, Address_No) values("hpr1g","Tanase","Mihai","1700915136866","mihai.tanase10@gmail.com","0790528592",7)
INSERT INTO Client(id, firstName, lastName, cnp, email, phoneNumber, Address_No, bankAccount_ID) values("hnurb","Proca","Daria","2800417016563","dariaaa_proca7@yahoo.com","0702040669", 8, 2)
INSERT INTO Client(id, firstName, lastName, cnp, email, phoneNumber, Address_No) values("mzdqm","Bogoescu","Cristina","2750501186493","bogoescu.cristinutza69@yahoo.com","0711376404",9)

INSERT INTO bankAccount(username, password, Deposit_ID) values("abc", 123, 1)
INSERT INTO bankAccount(username, password, Deposit_ID) values("def", 987, null)

INSERT INTO Customer_Advisors(FirstName, LastName, CNP, PhoneNumber, bankAgency_No,Address_No, CustomerAdvisorsPassword_No) values("Dan","Aurel","4321091239781","0781267832",1, 10,1)

INSERT INTO bankAgency(id, phoneBankNumber, operatingMorningHours, operatingAfternoonHours, lunchBreak,Address_No) values("fk39z", "0256302014", "09:15-13:00","13:30-17:00", "13:00-13:30", 11)
INSERT INTO bankAgency(id, phoneBankNumber, operatingMorningHours, operatingAfternoonHours, lunchBreak,Address_No) values("pz6g1", "0374477294", "09:15-13:00","13:30-17:00", "13:00-13:30", 12)
INSERT INTO bankAgency(id, phoneBankNumber, operatingMorningHours, operatingAfternoonHours, lunchBreak,Address_No) values("daq13", "0256244582", "09:15-13:00","13:30-16:45", "13:00-13:30", 13)
INSERT INTO bankAgency(id, phoneBankNumber, operatingMorningHours, operatingAfternoonHours, lunchBreak,Address_No) values("9h3ad","0269202530", "08:30-12:30","13:00-16:15", "12:30-13:00", 14)
INSERT INTO bankAgency(id, phoneBankNumber, operatingMorningHours, operatingAfternoonHours, lunchBreak,Address_No) values("yz89a", "0269252033", "09:30-12:30","13:00-17:15", "12:30-13:00",15)

--Adrese clienti
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment,Street) values ("Buzau","Buzau","12",null,null,"Bulevardul Industriei")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber, Apartment, Street) values ("Sibiu","Sibiu",null,"C1", "17","Doljului")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values ("Timisoara","Timis","56",null,null,"Libertatii")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values ("Miercurea-Ciuc","Harghita","31D",null,null,"Iancu de Hunedoara")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values ("Lugoj","Timis","159",null,null,"Closca")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values ("Targu-Jiu","Gorj","65A",null,null,"Republicii")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values ("Constanta","Constanta","11",null,null,"Bulevardul Ferdinand")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values ( "Alba Iulia","Alba","328",null,null,"Nicolae Balcescu")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values ("Targu-Jiu","Gorj","86",null,null,"Prahovei")

--Adrese consilieri clienti
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values("Galati","Galati","32",null,null,"Florilor")

--Adrese agentii bancare
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values("Timisoara","Timis","1",null,null,"Socrate")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values("Timisoara","Timis","71",null,null,"16 Decembrie 1989")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values("Timisoara","Timis","8",null,null,"Zborului")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values("Sibiu","Sibiu","39",null,null,"Nicolae Balcescu")
INSERT INTO Address (City, County, HouseNumber, BlockOfFlatsNumber,Apartment, Street) values("Sibiu","Sibiu",null,"137",2,"Calea Dumbravei")

--Depozite clienti
INSERT INTO Deposit (Deposit_RON, Deposit_EUR, Deposit_USD, Deposit_GBP) values (12000, 5000,100, NULL)

--Parole angajati banca
INSERT INTO CustomerAdvisorsPassword(password) values (1234)
INSERT INTO CustomerAdvisorsPassword(password) values (7777)
INSERT INTO CustomerAdvisorsPassword(password) values (9123)
INSERT INTO CustomerAdvisorsPassword(password) values (0321)
INSERT INTO CustomerAdvisorsPassword(password) values (5483)
INSERT INTO CustomerAdvisorsPassword(password) values (9822)
INSERT INTO CustomerAdvisorsPassword(password) values (8743)
INSERT INTO CustomerAdvisorsPassword(password) values (1177)
INSERT INTO CustomerAdvisorsPassword(password) values (8754)
INSERT INTO CustomerAdvisorsPassword(password) values (3963)

--Parole clienti banca
INSERT INTO ClientPassword(password) values (1515)