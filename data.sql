CREATE SCHEMA IF NOT EXISTS "public";

CREATE  TABLE "public".employe ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(20)  NOT NULL  ,
	prenom               varchar(20)  NOT NULL  ,
	CONSTRAINT pk_employe PRIMARY KEY ( id )
 );

