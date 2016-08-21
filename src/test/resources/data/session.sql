DELETE FROM session_member;
DELETE FROM  session;

INSERT INTO session(id, material_id, date_start, date_finish) VALUE ('S01', 'M01', '2016-08-01', '2016-08-05');
INSERT INTO session(id, material_id, date_start, date_finish) VALUE ('S02', 'M01', '2016-08-06', '2016-08-10');
INSERT INTO session(id, material_id, date_start, date_finish) VALUE ('S03', 'M02', '2016-08-01', '2016-08-05');

INSERT INTO session_member(session_id, member_id) VALUE ('S01', '001');
INSERT INTO session_member(session_id, member_id) VALUE ('S01', '002');
INSERT INTO session_member(session_id, member_id) VALUE ('S01', '003');

INSERT INTO session_member(session_id, member_id) VALUE ('S02', '002');
INSERT INTO session_member(session_id, member_id) VALUE ('S02', '003');

INSERT INTO session_member(session_id, member_id) VALUE ('S03', '002');
