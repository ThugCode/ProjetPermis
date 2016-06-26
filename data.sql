INSERT INTO `action` (`id`, `name`) VALUES
(1, 'Conduire doucement'),
(2, 'Accélérer'),
(3, 'Freiner'),
(4, 'S''arrêter avant la ligne'),
(5, 'Fermer les portes'),
(6, 'Éviter un obstacle'),
(7, 'Éviter un avion'),
(8, 'Éviter les pietons'),
(9, 'Éviter les valises'),
(10, 'Répondre aux voyageurs'),
(11, 'Regarder le rétroviseur'),
(12, 'Suivre les lignes'),
(13, 'Se garer'),
(14, 'Faire une marche arrière'),
(15, 'Anticiper'),
(16, 'Respecter les signaux'),
(17, 'Respecter les panneaux'),
(18, 'Lire les informations'),
(19, 'Utilise les clignotants');

INSERT INTO `goal` (`id`, `name`) VALUES
(1, 'Conduire sans risque'), -- 8, 11, 12, 15, 17, 19
(2, 'Conduire doucement'), -- 1, 3, 15
(3, 'Savoir faire les contrôles appropriés'), -- 16, 17
(4, 'Savoir contrôler son bus'), -- 2, 3, 4, 5, 13
(5, 'S''approprier la piste'), -- 16, 18, 12
(6, 'Savoir éviter tout obstacle'),
(7, 'Prendre toute l''information disponible'), -- 11, 16, 17, 18
(8, 'Être agréable'), -- 8, 15, 10
(9, 'Transporter les voyageurs'), -- 5
(10, 'Réagir en cas d''incident'); 

INSERT INTO `action_goal` (`id_action`, `id_goal`) VALUES
(8, 1),
(11, 1),
(12, 1),
(15, 1),
(17, 1),
(19, 1),
(1, 2),
(3, 2),
(15, 2),
(16, 3),
(17, 3),
(2, 4),
(3, 4),
(4, 4),
(5, 4),
(13, 4),
(12, 5),
(16, 5),
(18, 5),
(6, 6),
(7, 6),
(8, 6),
(9, 6),
(11, 7),
(16, 7),
(17, 7),
(18, 7),
(8, 8),
(10, 8),
(15, 8),
(5, 9);

INSERT INTO `mission` (`id`, `title`) VALUES
(1, 'Initiation'),
(2, 'Secteurs'),
(3, 'Points de repère'),
(4, 'Rôles inhérents'),
(5, 'Découverte des postes'),
(6, 'Dispositifs EOV'),
(7, 'Environnement'),
(8, 'Conduite'),
(9, 'Dépôt'),
(10, 'Réseaux de pistes'),
(11, 'Electronique'),
(12, 'Mecanique'),
(13, 'Atelier'),
(14, 'Master');

INSERT INTO `mission_goal` (`id_mission`, `id_goal`) VALUES
(3, 1),
(13, 1),
(14, 1),
(3, 2),
(13, 2),
(4, 3),
(14, 3),
(4, 4),
(14, 4),
(4, 6),
(13, 6);

INSERT INTO `game` (`id`, `name`, `image`) VALUES
(1, 'Prise en main', 'pem.png'),
(2, 'Conduite de piste', 'cdp.png'),
(3, 'Vérification des contrôles', 'vdc.png'),
(4, 'Test blanc', 'tb.png');

INSERT INTO `game_mission` (`id_game`, `id_mission`) VALUES
(2, 1),
(2, 2),
(1, 7),
(2, 13);

INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Léo", "Letourneur", "letourneur.leo@gmail.com", "50f216a0d4b0df52d4b7dbb9a6b17ed15d2e91d8061972559520395eb37b8d0c", 1, 1);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Perry","Reed","turpis.nec.mauris@adipiscing.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Steel","Shepard","ante.Maecenas.mi@eu.com","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Gannon","Haley","nascetur.ridiculus.mus@ornarelectus.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Lucius","Kemp","pede.nonummy@varius.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Timothy","Frazier","vitae@egetipsum.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Castor","House","montes.nascetur.ridiculus@adipiscingligula.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Sloane","Alston","velit@ipsumDonecsollicitudin.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Cassady","William","ut.nulla@Sedeunibh.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Josiah","Fletcher","ligula.elit.pretium@ipsumCurabitur.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Jamalia","Langley","luctus@Nuncmaurissapien.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Christen","Edwards","Quisque.fringilla.euismod@bibendumullamcorperDuis.com","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Darius","Rich","sodales.at@nascetur.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Clayton","Sloan","fringilla.porttitor@ligulaNullamenim.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Emmanuel","Pickett","erat@inmolestie.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Stone","Hendrix","odio@torquent.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Adele","Mcleod","Maecenas@Mauris.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Cheyenne","Haley","Donec.egestas@fermentumfermentum.com","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Lynn","Gray","erat.vitae@tincidunt.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Isadora","King","elementum@Namconsequat.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Xerxes","Monroe","volutpat@pedesagittisaugue.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Xandra","Osborne","nec@ipsumprimisin.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Michelle","Dean","convallis@pharetrafeliseget.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Diana","Foster","dolor.Donec@sed.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Jacob","Duffy","adipiscing.elit@blandit.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Carissa","Decker","magna.Nam.ligula@hendrerita.com","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Cairo","Burris","egestas@id.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Noble","Sparks","non.luctus.sit@cursusnon.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Rebecca","Grimes","inceptos.hymenaeos.Mauris@in.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Lesley","Golden","Donec@malesuadavelvenenatis.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Slade","Perez","iaculis@magnaseddui.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Kristen","Robbins","tincidunt@venenatislacusEtiam.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Chanda","Austin","imperdiet.nec.leo@utcursus.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Rosalyn","Becker","semper.erat.in@atlibero.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Cade","Duran","a.aliquet@ut.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Jenette","York","In.lorem@dolorvitae.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Cole","Dixon","hendrerit.neque.In@etrutrum.com","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Maisie","Leonard","ut.molestie.in@nunc.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("McKenzie","Barber","lorem@posuerecubiliaCurae.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Regan","Eaton","nibh.vulputate.mauris@consectetueradipiscing.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Nathan","Rutledge","Mauris.molestie@Cumsociis.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Howard","Romero","Proin@iaculisquispede.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Shay","Powers","luctus@euismodenimEtiam.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Emi","Ball","ut.odio.vel@Cras.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Drake","Kelly","ultrices@feugiatmetussit.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Coby","Avery","hymenaeos@tincidunt.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Sheila","Lloyd","lacus@nisi.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Jillian","Trujillo","semper@porttitor.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Veronica","Noel","adipiscing.elit@risus.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Felicia","Lawson","sem.ut.cursus@mauriseu.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Harlan","Zamora","pede.Praesent.eu@semelit.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Colton","Scott","turpis.Aliquam.adipiscing@malesuadaaugueut.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Darryl","Wells","auctor.Mauris.vel@insodales.com","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Ruth","Odonnell","orci.Phasellus.dapibus@incursus.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Heather","Cline","congue.In.scelerisque@vitae.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Yvonne","Chen","amet.metus.Aliquam@nequeNullamut.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Xenos","Morrison","Aliquam@volutpatornarefacilisis.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Ivana","Wheeler","velit.Cras.lorem@nuncnullavulputate.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Bernard","Hays","egestas.nunc.sed@Infaucibus.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Vivian","Dennis","molestie.sodales@tellus.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Brooke","Nixon","dictum.eu.placerat@nonquamPellentesque.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Nash","Pacheco","nisi.nibh@semperdui.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Aretha","Roberson","lorem.semper@lobortistellusjusto.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Jade","Hansen","semper.egestas@tristique.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Kamal","Drake","Mauris@Naminterdumenim.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Leigh","Alford","at@vitae.com","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Nicholas","Goff","condimentum.eget@utpharetra.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Jason","William","bibendum.Donec@loremvitaeodio.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Darrel","Cannon","neque@elementumsemvitae.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Clark","Griffin","in.faucibus@Phaselluslibero.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Nelle","Glenn","rutrum.lorem.ac@ullamcorperDuis.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Melanie","Barnes","eu@elit.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Mercedes","Owens","ornare.facilisis.eget@egetvariusultrices.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Sarah","Roman","nec.mauris@facilisislorem.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Ezra","Carroll","vel.nisl.Quisque@sedestNunc.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Lisandra","Sparks","vulputate@eratSed.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Tamara","Rosales","ornare@Namconsequat.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Brock","Baker","euismod.in.dolor@enim.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Demetrius","Leach","nec@parturient.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Melanie","Carter","lobortis.augue@cursuset.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Tasha","Molina","mi.pede@et.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Thaddeus","Mann","Phasellus.dapibus.quam@Sednulla.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Dean","Gallegos","tincidunt.nunc@Sedeget.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Dara","Cardenas","parturient@at.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Cain","Holt","adipiscing@antedictummi.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Marshall","Jefferson","montes.nascetur.ridiculus@ornaresagittisfelis.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Patience","Mack","vel.sapien@leoCrasvehicula.edu","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Owen","Harvey","velit.justo@nuncsedpede.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Yardley","Morrison","arcu.Vestibulum.ante@Suspendisse.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Jin","Terrell","vel.turpis@liberoettristique.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Dylan","Bryan","cursus@parturientmontesnascetur.org","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Amaya","Lindsay","nec.euismod.in@vehicula.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Chaim","Oliver","Duis.elementum.dui@laciniavitaesodales.co.uk","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Noble","Leon","morbi.tristique@elitEtiam.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Seth","Harding","lectus.sit.amet@enimmi.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Tiger","Kerr","lectus.rutrum.urna@vulputate.com","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Athena","Bates","eget.volutpat@ipsum.ca","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("India","Robinson","orci.Donec@Aliquam.com","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Tiger","Hale","In@enimEtiam.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Rachel","Hodges","Vestibulum.ante.ipsum@estvitaesodales.net","",1,0);
INSERT INTO `student`( `lastname`, `firstname`, `mail`, `password`, `is_enabled`, `is_admin`) VALUES ("Keith","Woodward","lectus.quis@cursusdiam.org","",1,0);

