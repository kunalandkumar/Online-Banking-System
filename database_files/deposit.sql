--  SQLINES DEMO *** ------------------------------------
-- SQLINES DEMO *** uesday-November-21-2017   
--  SQLINES DEMO *** ------------------------------------
--  SQLINES DEMO *** ------------------------------------
-- SQLINES DEMO *** POSIT
--  SQLINES DEMO *** ------------------------------------

  CREATE TABLE `PIAL`.`DEPOSIT` 
   (	`ID` VARCHAR(10), 
	`YEAR` DECIMAL(38,0), 
	`INTEREST` DECIMAL(38,0), 
	`AMOUNT` DECIMAL(38,0), 
	`DEPOSIT_DATE` VARCHAR(30)
   ) 
  ;
-- INSERTING into PIAL.DEPOSIT
/* SET DEFINE OFF; */
Insert into PIAL.DEPOSIT (ID,YEAR,INTEREST,AMOUNT,DEPOSIT_DATE) values ('PiSa532991',1,8,100000,'2017/04/20 04:19:56');
