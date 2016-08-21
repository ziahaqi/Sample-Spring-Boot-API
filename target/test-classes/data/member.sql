DELETE FROM session_member;
DELETE FROM member;
INSERT INTO member(id, name, email, birth_day) VALUE ("001", "sample name1", "sample1@mail.com", "2010-01-01");
INSERT INTO member(id, name, email, birth_day) VALUE ("002", "sample name2", "sample2@mail.com", "2010-01-02");
INSERT INTO member(id, name, email, birth_day) VALUE ("003", "sample name3", "sample3@mail.com", "2010-01-03");