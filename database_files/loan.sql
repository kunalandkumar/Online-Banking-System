--  SQLINES DEMO *** ------------------------------------
-- SQLINES DEMO *** uesday-November-21-2017   
--  SQLINES DEMO *** ------------------------------------
--  SQLINES DEMO *** ------------------------------------
--  DDL for Table LOAN
--  SQLINES DEMO *** ------------------------------------

  CREATE TABLE `PIAL`.`LOAN` 
   (	`ID` VARCHAR(10), 
	`AMOUNT` DECIMAL(38,0), 
	`STATUS` VARCHAR(8), 
	`FIRST_NAME` VARCHAR(20), 
	`LAST_NAME` VARCHAR(20), 
	`ADDRESS` VARCHAR(60), 
	`EMAIL` VARCHAR(30)
   ) 
  ;
-- INSERTING into PIAL.LOAN
/* SET DEFINE OFF; */
Insert into PIAL.LOAN (ID,AMOUNT,STATUS,FIRST_NAME,LAST_NAME,ADDRESS,EMAIL) values ('RaBh863299',200000,'pending','Rajesh','Bhartia','Mymensingh','rbhartiamuk@gmail.com');
Insert into PIAL.LOAN (ID,AMOUNT,STATUS,FIRST_NAME,LAST_NAME,ADDRESS,EMAIL) values ('PiSa532991',100000,'pending','Pial Kanti','Samadder','Keranigonj,Dhaka','pialkanti2012@gmail.com');
Insert into PIAL.LOAN (ID,AMOUNT,STATUS,FIRST_NAME,LAST_NAME,ADDRESS,EMAIL) values ('PiSa532991',20000,'success','Pial Kanti','Samadder','Keranigonj,Dhaka','pialkanti2012@gmail.com');
