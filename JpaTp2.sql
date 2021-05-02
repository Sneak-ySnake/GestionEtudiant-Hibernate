create table deuxiemetpjpa.etudiant
(
id_etudiant serial not null,
nom varchar(30) not null,
prenom varchar(30) not null,
datenaissance date not null,
id_groupe integer not null
);

alter table deuxiemetpjpa.etudiant
add constraint PK_ETUDIANT primary key (id_etudiant); 

alter table deuxiemetpjpa.etudiant
owner to gestionnaire;

create table deuxiemetpjpa.groupe_td
(
id_groupe serial not null,
id_salle integer not null
);

alter table deuxiemetpjpa.groupe_td
add constraint PK_GROUPE primary key (id_groupe); 

alter table deuxiemetpjpa.groupe_td
    owner to gestionnaire;
	
	
create table deuxiemetpjpa.salle
(
id_salle serial not null,
nombre_pc integer not null,
nombre_place integer not null,
videoprojecteur boolean not null
);

alter table deuxiemetpjpa.salle
add constraint PK_SALLE primary key (id_salle); 

alter table deuxiemetpjpa.salle
owner to gestionnaire;


alter table deuxiemetpjpa.etudiant
add constraint FK_ETUDIANT foreign key (id_groupe)
references deuxiemetpjpa.groupe_td (id_groupe);

alter table deuxiemetpjpa.groupe_td
add constraint FK_GROUPE foreign key (id_salle)
references deuxiemetpjpa.salle (id_salle);

commit;