--  SQLINES DEMO *** ------------------------------------
-- SQLINES DEMO *** uesday-November-21-2017   
--  SQLINES DEMO *** ------------------------------------
--  SQLINES DEMO *** ------------------------------------
-- SQLINES DEMO *** COUNT
--  SQLINES DEMO *** ------------------------------------

  CREATE TABLE `PIAL`.`ACCOUNT` 
   (	`ID` VARCHAR(10), 
	`F_NAME` VARCHAR(20), 
	`L_NAME` VARCHAR(20), 
	`ADDRESS` VARCHAR(60), 
	`CITY` VARCHAR(15), 
	`BRANCH` VARCHAR(15), 
	`ZIP` VARCHAR(8), 
	`USERNAME` VARCHAR(20), 
	`PASSWORD` VARCHAR(30), 
	`PHONE` VARCHAR(15), 
	`EMAIL` VARCHAR(30), 
	`ACCOUNT_TYPE` VARCHAR(15), 
	`REG_DATE` VARCHAR(15)
   ) 
  ;
-- INSERTING into PIAL.ACCOUNT
/* SET DEFINE OFF; */
Insert into PIAL.ACCOUNT (ID,F_NAME,L_NAME,ADDRESS,CITY,BRANCH,ZIP,USERNAME,PASSWORD,PHONE,EMAIL,ACCOUNT_TYPE,REG_DATE) values ('PiSa532991','Pial Kanti','Samadder','Keranigonj,Dhaka','Dhaka','Dhaka','1304','PialKanti','1234','01676277976','pialkanti2012@gmail.com','Current Account','15/04/2017');
Insert into PIAL.ACCOUNT (ID,F_NAME,L_NAME,ADDRESS,CITY,BRANCH,ZIP,USERNAME,PASSWORD,PHONE,EMAIL,ACCOUNT_TYPE,REG_DATE) values ('RaBh863299','Rajesh','Bhartia','Mymensingh','Mymensingh','Mymensingh','2210','rkBhartia','1234','01455699554','rbhartiamuk@gmail.com','Saving Account','16/04/2017');
Insert into PIAL.ACCOUNT (ID,F_NAME,L_NAME,ADDRESS,CITY,BRANCH,ZIP,USERNAME,PASSWORD,PHONE,EMAIL,ACCOUNT_TYPE,REG_DATE) values ('GrBa240230','Green','Bank','KUET','Khulna','Khulna','1540','admin','admin','13234558','admin@greenbank.com','Saving Account','23/04/2017');
