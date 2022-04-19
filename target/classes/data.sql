INSERT INTO author (name_author)
VALUES ('Mark Twain'), ('Charles Dickens'), ('George Orwell'), ('Stephen King'), ('Joanne Rowling');

INSERT INTO genre (name_genre)
VALUES ('Adventure'), ('Classics'), ('Fantasy');

INSERT INTO book (title, author_id, genre_id, price, amount)
VALUES
    ('Adventures of Tow Sawyer',1,1,1000,50),
    ('Adventures of Huckleberry Finn',1,1,1000,30),
    ('Oliver Twist',2,1,1000,20),
    ('1984',3,2,1500,25),
    ('Animal Farm',3,2,1000,15),
    ('Homage to Catalonia',3,2,1500,10),
    ('The Shining',4,3,1500,15),
    ('The Stand',4,3,1500,20),
    ('Misery',4,1,2000,30),
    ('Harry Potter and the Philosophers Stone',5,3,2000,40),
    ('Harry Potter and the Chamber of Secrets',5,3,2000,35),
    ('Harry Potter and the Prisoner of Azkaban',5,3,2000,30),
    ('Harry Potter and the Goblet of Fire',5,3,2000,30),
    ('Harry Potter and the Order of the Phoenix',5,3,2000,30),
    ('Harry Potter and the Half-Blood Prince',5,3,2000,30),
    ('Harry Potter and the Deathly Hallows',5,3,2000,30);