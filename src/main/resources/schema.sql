CREATE TABLE author (
    author_id INT PRIMARY KEY AUTO_INCREMENT,
    name_author VARCHAR(50)
);

CREATE TABLE genre (
    genre_id INT PRIMARY KEY AUTO_INCREMENT,
    name_genre VARCHAR(50)
);

CREATE TABLE book (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),
    author_id INT NOT NULL,
    genre_id INT,
    price INT,
    amount INT,
    FOREIGN KEY (author_id)  REFERENCES author (author_id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id)  REFERENCES genre (genre_id) ON DELETE SET NULL
);

CREATE TABLE author_log (
    author_log_id INT PRIMARY KEY AUTO_INCREMENT,
    time VARCHAR(50)
);

CREATE TABLE genre_log (
    genre_log_id INT PRIMARY KEY AUTO_INCREMENT,
    time VARCHAR(50)
);

CREATE TABLE book_log (
    book_log_id INT PRIMARY KEY AUTO_INCREMENT,
    time VARCHAR(50)
);