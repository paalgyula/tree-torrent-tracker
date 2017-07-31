INSERT INTO USERS (DOWNLOADED, EMAIL, LASTLOGIN, PASSWORD, POINTS, REGISTRED, TITLE, UPLOADED, USERNAME, ID) VALUES
  (5236121, 'paalgyula@paalgyula.com', NULL, '$2a$10$pvXodcDhJIVi3x5DBw6dB.z3ykBUsghQ/F.S1SIODEUCHAIJAebCy', 512, NULL,
   'Administrator', 123512135, 'goofyx', 0);

INSERT INTO TRACKER_ROLE (ID, ROLE) VALUES (1, 'ROLE_USER');
INSERT INTO TRACKER_ROLE (ID, ROLE) VALUES (2, 'ROLE_MODERATOR');
INSERT INTO TRACKER_ROLE (ID, ROLE) VALUES (3, 'ROLE_ADMIN');

INSERT INTO USER_ROLES (USER_ID, ROLE_ID) VALUES (0, 1);
--INSERT INTO USER_ROLES (USER_ID, ROLE_ID) VALUES (0, 2);
--INSERT INTO USER_ROLES (USER_ID, ROLE_ID) VALUES (0, 3);

INSERT INTO CATEGORY (ID, CATEGORY, IMAGE) VALUES (0, 'DVD Film', 'dvd');
INSERT INTO CATEGORY (ID, CATEGORY, IMAGE) VALUES (1, 'DVD-9 Film', 'dvd9');

--insert into torrents (category_id, checked, description, downloaded, info_hash, leechers, name, seeders, size, uploaded, uploader, id) values (0, FALSE , '', 100, '', 3, 'Teszt 1', 12, 51251251, {ts '2016-11-05 09:24:00.00'}, 0, 0);
--insert into torrents (category_id, checked, description, downloaded, info_hash, leechers, name, seeders, size, uploaded, uploader, id) values (0, FALSE , '', 101, '', 3, 'Teszt 2', 12, 5125125, {ts '2016-11-05 10:24:00.00'}, 0, 1);
--insert into torrents (category_id, checked, description, downloaded, info_hash, leechers, name, seeders, size, uploaded, uploader, id) values (0, FALSE , '', 102, '', 3, 'Teszt 3', 12, 512512, {ts '2016-11-05 11:24:00.00'}, 0, 2);
--insert into torrents (category_id, checked, description, downloaded, info_hash, leechers, name, seeders, size, uploaded, uploader, id) values (0, FALSE , '', 103, '', 3, 'Teszt 4', 12, 51251, {ts '2016-11-05 13:24:00.00'}, 0, 3);

