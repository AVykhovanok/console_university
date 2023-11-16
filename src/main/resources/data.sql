CREATE TABLE IF NOT EXISTS `degrees` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`))
ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `lectors` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `first_name` varchar(255) DEFAULT NULL,
    `last_name` varchar(255) DEFAULT NULL,
    `salary` double DEFAULT NULL,
    `degree_id` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKtixomq82oqnqu8l9xl6v8fptr` (`degree_id`),
    CONSTRAINT `FKtixomq82oqnqu8l9xl6v8fptr` FOREIGN KEY (`degree_id`) REFERENCES `degrees` (`id`))
ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `departments` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `name` varchar(255) DEFAULT NULL,
   `head_id` bigint DEFAULT NULL,
   `departments` bigint DEFAULT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `UK_rpbl99tstvgrcsdpfsx34iheb` (`head_id`),
   UNIQUE KEY `UK_3s1ek4kspsa51uln63t6mqviu` (`departments`),
   CONSTRAINT `FKhblbl10953pn144par4gd82xl` FOREIGN KEY (`departments`) REFERENCES `lectors` (`id`),
   CONSTRAINT `FKshva61vmov6yq03m72ngg1fub` FOREIGN KEY (`head_id`) REFERENCES `lectors` (`id`))
ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `degrees_lectors` (
     `degree_id` int NOT NULL,
     `lector_id` bigint NOT NULL,
     UNIQUE KEY `UK_a05e9ijj1ds2nxh74w2a66jpo` (`lector_id`),
     KEY `FKcdp6mhvqcylheq9jdrwdb0ryu` (`degree_id`),
     CONSTRAINT `FKcdp6mhvqcylheq9jdrwdb0ryu` FOREIGN KEY (`degree_id`) REFERENCES `degrees` (`id`),
     CONSTRAINT `FKtouxn8vw1mbkf71v14teal9v6` FOREIGN KEY (`lector_id`) REFERENCES `lectors` (`id`))
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `departments_lectors` (
    `department_id` bigint NOT NULL,
    `lector_id` bigint NOT NULL,
    PRIMARY KEY (`department_id`,`lector_id`),
    KEY `FK1xgankxbb4ev44nnspjg90eoq` (`lector_id`),
    CONSTRAINT `FK1xgankxbb4ev44nnspjg90eoq` FOREIGN KEY (`lector_id`) REFERENCES `lectors` (`id`),
    CONSTRAINT `FKa96v7ax2suq0c4y6s2kv0x7pl` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`))
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `` (`id`,`name`) VALUES (1,'assistant');
INSERT INTO `` (`id`,`name`) VALUES (2,'associate professor');
INSERT INTO `` (`id`,`name`) VALUES (3,'professor');

INSERT INTO `` (`id`,`first_name`,`last_name`,`salary`,`degree_id`) VALUES (1,'firstA','lastA',10000,1);
INSERT INTO `` (`id`,`first_name`,`last_name`,`salary`,`degree_id`) VALUES (2,'firstB','lastB',11000,1);
INSERT INTO `` (`id`,`first_name`,`last_name`,`salary`,`degree_id`) VALUES (3,'firstC','lastC',12000,2);
INSERT INTO `` (`id`,`first_name`,`last_name`,`salary`,`degree_id`) VALUES (4,'firstD','lastD',13000,2);
INSERT INTO `` (`id`,`first_name`,`last_name`,`salary`,`degree_id`) VALUES (5,'firstE','lastE',14000,3);
INSERT INTO `` (`id`,`first_name`,`last_name`,`salary`,`degree_id`) VALUES (6,'firstF','lastF',15000,3);
INSERT INTO `` (`id`,`first_name`,`last_name`,`salary`,`degree_id`) VALUES (7,'firstG','lastG',16000,1);
INSERT INTO `` (`id`,`first_name`,`last_name`,`salary`,`degree_id`) VALUES (8,'firstH','lastH',17000,2);

INSERT INTO `` (`id`,`name`,`head_id`,`departments`) VALUES (1,'departmentA',1,1);
INSERT INTO `` (`id`,`name`,`head_id`,`departments`) VALUES (2,'departmentB',2,2);
INSERT INTO `` (`id`,`name`,`head_id`,`departments`) VALUES (3,'departmentC',3,3);

INSERT INTO `` (`degree_id`,`lector_id`) VALUES (1,1);
INSERT INTO `` (`degree_id`,`lector_id`) VALUES (1,2);
INSERT INTO `` (`degree_id`,`lector_id`) VALUES (2,3);
INSERT INTO `` (`degree_id`,`lector_id`) VALUES (2,4);
INSERT INTO `` (`degree_id`,`lector_id`) VALUES (3,5);
INSERT INTO `` (`degree_id`,`lector_id`) VALUES (3,6);

INSERT INTO `` (`department_id`,`lector_id`) VALUES (1,1);
INSERT INTO `` (`department_id`,`lector_id`) VALUES (1,2);
INSERT INTO `` (`department_id`,`lector_id`) VALUES (1,3);
INSERT INTO `` (`department_id`,`lector_id`) VALUES (1,4);
INSERT INTO `` (`department_id`,`lector_id`) VALUES (2,5);
INSERT INTO `` (`department_id`,`lector_id`) VALUES (2,6);
INSERT INTO `` (`department_id`,`lector_id`) VALUES (2,7);
INSERT INTO `` (`department_id`,`lector_id`) VALUES (2,8);
