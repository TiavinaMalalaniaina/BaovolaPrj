CREATE SCHEMA IF NOT EXISTS "public";

CREATE  TABLE "public".etudiant ( 
	id_etudiant          serial  NOT NULL  ,
	nom                  varchar(20)  NOT NULL  ,
	prenom               varchar(20)  NOT NULL  ,
	CONSTRAINT pk_etudiant PRIMARY KEY ( id_etudiant )
 );

