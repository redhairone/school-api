insert into SCHOOL_ENTITY(id, name, hour_price) values (1, 'Public School Number: 1', 10);
insert into SCHOOL_ENTITY(id, name, hour_price) values (2, 'Public School Number: 2', 20);
insert into SCHOOL_ENTITY(id, name, hour_price) values (3, 'Public School Number: 3', 30);
insert into PARENT_ENTITY(id, first_name, last_name) values (1, 'Aubrey', 'Stokes');
insert into PARENT_ENTITY(id, first_name, last_name) values (2, 'Bernard', 'Monroe');
insert into PARENT_ENTITY(id, first_name, last_name) values (3, 'Celina', 'Carr');
insert into PARENT_ENTITY(id, first_name, last_name) values (4, 'Dominik', 'Baird');
insert into PARENT_ENTITY(id, first_name, last_name) values (5, 'Ewa', 'Douglas');
insert into PARENT_ENTITY(id, first_name, last_name) values (6, 'Frank', 'Sellers');
insert into PARENT_ENTITY(id, first_name, last_name) values (7, 'Greg', 'Compton');
insert into PARENT_ENTITY(id, first_name, last_name) values (8, 'Hanna', 'Rocha');
insert into PARENT_ENTITY(id, first_name, last_name) values (9, 'Ian', 'Hall');
insert into PARENT_ENTITY(id, first_name, last_name) values (10, 'Jake', 'Serton');
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (1, 'Greg_junior', 'Monroe', 2, 2);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (2, 'Celina_junior', 'Carr', 3, 3);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (3, 'Hanna_junior', 'Baird', 4, 1);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (4, 'Ewa_junior', 'Douglas', 5, 2);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (5, 'Jake_junior', 'Sellers', 6, 3);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (6, 'Ewa_junior', 'Compton', 7, 1);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (7, 'Hanna_junior', 'Stokes', 1, 2);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (8, 'Aubrey_junior', 'Monroe', 2, 3);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (9, 'Bernard_junior', 'Carr', 3, 1);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (10, 'Jake_junior', 'Baird', 4, 2);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (1, '2024-02-17T01:39:33.267078500', '2024-02-17T04:39:33.268074900', 2);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (2, '2024-02-17T02:39:33.268074900', '2024-02-17T05:39:33.268074900', 3);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (3, '2024-02-17T03:39:33.269046500', '2024-02-17T06:39:33.269046500', 4);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (4, '2024-02-17T04:39:33.269046500', '2024-02-17T07:39:33.269046500', 5);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (5, '2024-02-17T05:39:33.270058600', '2024-02-17T08:39:33.270058600', 6);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (6, '2024-02-17T06:39:33.270058600', '2024-02-17T09:39:33.270058600', 7);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (7, '2024-02-17T07:39:33.271041900', '2024-02-17T10:39:33.271041900', 8);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (8, '2024-02-17T08:39:33.271041900', '2024-02-17T11:39:33.271041900', 9);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (9, '2024-02-17T09:39:33.272035600', '2024-02-17T12:39:33.272035600', 1);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (10, '2024-02-17T10:39:33.272035600', '2024-02-17T13:39:33.272035600', 2);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (11, '2024-02-17T11:39:33.272035600', '2024-02-17T14:39:33.272035600', 3);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (12, '2024-02-17T12:39:33.273035800', '2024-02-17T15:39:33.273035800', 4);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (13, '2024-02-17T13:39:33.274031400', '2024-02-17T16:39:33.274031400', 5);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (14, '2024-02-17T14:39:33.274031400', '2024-02-17T17:39:33.274031400', 6);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (15, '2024-02-17T15:39:33.275028900', '2024-02-17T18:39:33.275028900', 7);
