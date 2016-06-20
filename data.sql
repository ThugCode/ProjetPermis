INSERT INTO `action` (`id`, `name`) VALUES
(1, 'Conduire doucement'),
(2, 'Accélérer'),
(3, 'Freiner'),
(4, 'S''arrêter avant la ligne'),
(5, 'Fermer les portes'),
(6, 'Eviter un obstacle'),
(7, 'Eviter un avion'),
(8, 'Eviter les pietons'),
(9, 'Eviter les valises'),
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
(1, 'Conduire sans risque'), 8, 11, 12, 15, 17, 19
(2, 'Conduire doucement'), 1, 3, 15
(3, 'Savoir faire les contrôles appropriés'), 16, 17
(4, 'Savoir contrôler son bus'), 2,3,4,5,13
(5, 'S''approprier la piste'), 16,18,12
(6, 'Savoir éviter tout obstacle'),
(7, 'Prendre toute l''information disponible'), 11,16,17,18
(8, 'Être agréable'), 8,15,10
(9, 'Transporter les voyageurs'), 5
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