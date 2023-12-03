-- Create author table
CREATE TABLE author (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

-- Create book table
CREATE TABLE book (
  id SERIAL PRIMARY KEY,
  title VARCHAR(225),
  author_id INT,
  quantity INT
);

-- Create foreign key relation with cascade
ALTER TABLE book
  ADD CONSTRAINT fk_author FOREIGN KEY (author_id)     
    REFERENCES author (id)
    ON DELETE NO ACTION    
    ON UPDATE NO ACTION;

-- Seed author table
INSERT INTO author (id, name) VALUES (1, 'J.K. Rowling');
INSERT INTO author (id, name) VALUES (2, 'Mark Manson');

-- Seed book table
INSERT INTO book (title, author_id, quantity) VALUES ('Harry Potter and The Globet of Fire', 1, 10);
INSERT INTO book (title, author_id, quantity) VALUES ('Harry Potter and The Prisoner of Azkaban', 1, 15);
INSERT INTO book (title, author_id, quantity) VALUES ('Harry Potter and The Deathly Hallows', 1, 20);
INSERT INTO book (title, author_id, quantity) VALUES ('Harry Potter and The Sorcerer Stone', 1, 5);
INSERT INTO book (title, author_id, quantity) VALUES ('Harry Potter and The Chamber of Secrets', 1, 7);
INSERT INTO book (title, author_id, quantity) VALUES ('Everything is Fucked', 2, 3);
INSERT INTO book (title, author_id, quantity) VALUES ('Subtle Art of Not Giving a Fuck', 1, 11);