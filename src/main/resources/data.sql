INSERT INTO USERS (userid, username, salt, password, firstname, lastname) VALUES(10, 'user','salt', 'user', 'Mobeen', 'Zar');
INSERT INTO USERS (userid, username, salt, password, firstname, lastname) VALUES(20, 'admin','salt', 'admin', 'Naba', 'Zar');

INSERT INTO NOTES (noteid, notetitle, notedescription, userid) VALUES (10,'Title Mobeen', 'hello world', 10 );
INSERT INTO NOTES (noteid, notetitle, notedescription, userid) VALUES (20,'Title Mobeen 2', 'hello world 2', 10 );

INSERT INTO NOTES (noteid, notetitle, notedescription, userid) VALUES (30,'Title Naba', 'hello world', 20 );
INSERT INTO NOTES (noteid, notetitle, notedescription, userid) VALUES (40,'Title Naba 2', 'hello world 2', 20 );