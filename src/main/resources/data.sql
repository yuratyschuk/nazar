INSERT INTO FILM(id, name, trailer_url)
VALUES (1, 'Gucci house', 'https://www.youtube.com/watch?v=eGNnpVKxV6s'),
       (2, 'Die Hard', 'https://www.youtube.com/watch?v=dqk4ZB0HfYk');

INSERT INTO film_session(id, date, film_id)
VALUES (1, CURRENT_TIMESTAMP, 1),
       (2, CURRENT_TIMESTAMP, 2);

INSERT INTO user(id, role, money)
VALUES (1, 'USER', 200000),
       (2, 'ADMIN', 200000);

INSERT INTO place(id, available, cinema_hall, number_of_the_place, number_of_the_row, price, film_session_id, user_id)
VALUES (1, true, '<script>window.alert()</script>', 1, 1, 200, 1, 1),
       (2, true, 'First hall', 2, 1, 200, 1, null),
       (3, true, 'First hall', 3, 1, 200, 1, null),
       (4, false, 'First hall', 4, 1, 200, 1, null),
       (5, true, 'First hall', 1, 2, 200, 1, null),
       (6, false, 'First hall', 2, 2, 200, 1, null),
       (7, true, 'First hall', 3, 2, 200, 1, null),
       (8, true, 'First hall', 4, 2, 200, 1, null),
       (9, true, 'Second hall', 1, 1, 300, 2, null),
       (10, true, 'Second hall', 2, 1, 300, 2, null),
       (11, false, 'Second hall', 3, 1, 300, 2, null),
       (12, true, 'Second hall', 1, 2, 300, 2, null),
       (13, false, 'Second hall', 2, 2, 300, 2, null),
       (14, true, 'Second hall', 3, 2, 300, 2, 1);