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
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (1, 'Ian_junior', 'Monroe', 2, 2);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (2, 'Hanna_junior', 'Carr', 3, 3);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (3, 'Greg_junior', 'Baird', 4, 1);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (4, 'Greg_junior', 'Douglas', 5, 2);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (5, 'Frank_junior', 'Sellers', 6, 3);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (6, 'Aubrey_junior', 'Compton', 7, 1);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (7, 'Ian_junior', 'Stokes', 1, 2);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (8, 'Frank_junior', 'Monroe', 2, 3);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (9, 'Dominik_junior', 'Carr', 3, 1);
insert into CHILD_ENTITY(id, first_name, last_name, parent_id, school_id) values (10, 'Hanna_junior', 'Baird', 4, 2);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (1, '2024-02-14T13:17:17.814212100', '2024-02-15T13:17:17.815213200', 2);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (2, '2024-02-13T13:17:17.815213200', '2024-02-14T13:17:17.815213200', 3);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (3, '2024-02-12T13:17:17.815213200', '2024-02-13T13:17:17.815213200', 4);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (4, '2024-02-11T13:17:17.815213200', '2024-02-12T13:17:17.815213200', 5);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (5, '2024-02-10T13:17:17.815213200', '2024-02-11T13:17:17.815213200', 6);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (6, '2024-02-09T13:17:17.815213200', '2024-02-10T13:17:17.815213200', 7);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (7, '2024-02-08T13:17:17.815213200', '2024-02-09T13:17:17.815213200', 8);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (8, '2024-02-07T13:17:17.816214', '2024-02-08T13:17:17.816214', 9);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (9, '2024-02-06T13:17:17.816214', '2024-02-07T13:17:17.816214', 1);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (10, '2024-02-05T13:17:17.816214', '2024-02-06T13:17:17.816214', 2);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (11, '2024-02-04T13:17:17.816214', '2024-02-05T13:17:17.816214', 3);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (12, '2024-02-03T13:17:17.816214', '2024-02-04T13:17:17.816214', 4);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (13, '2024-02-02T13:17:17.816214', '2024-02-03T13:17:17.816214', 5);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (14, '2024-02-01T13:17:17.816214', '2024-02-02T13:17:17.817215', 6);
insert into ATTENDANCE_ENTITY(id, entry_date, exit_date, child_id) values (15, '2024-01-31T13:17:17.817215', '2024-02-01T13:17:17.817215', 7);
