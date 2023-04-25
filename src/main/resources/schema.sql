
-- Table for student information
CREATE TABLE student (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  firstname VARCHAR,
  lastname VARCHAR,
  address VARCHAR,
  phone_number VARCHAR,
  dob VARCHAR,
  balance FLOAT,
  login_id INTEGER
);

CREATE TABLE login (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR,
  password VARCHAR,
  user_type VARCHAR,
  status VARCHAR,
  student_id INTEGER REFERENCES student(id)
);

-- Table for courses
CREATE TABLE courses (
  course_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  educator_id INTEGER,
  name VARCHAR,
  keywords VARCHAR,
  category VARCHAR,
  course_level INTEGER,
  description LONGTEXT,
  cost DOUBLE
);


CREATE TABLE students_courses (
  course_id INT NOT NULL,
  student_id INT NOT NULL,
  PRIMARY KEY (course_id, student_id),
  FOREIGN KEY (course_id) REFERENCES courses(course_id),
  FOREIGN KEY (student_id) REFERENCES student(id)
);

CREATE TABLE quiz (
  quiz_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  quiz_name VARCHAR(100) NOT NULL,
  question VARCHAR(255) NOT NULL,
  answer1 VARCHAR(255) NOT NULL,
  answer2 VARCHAR(255) NOT NULL,
  answer3 VARCHAR(255) NOT NULL,
  answer4 VARCHAR(255) NOT NULL,
  answer CHAR(1) NOT NULL,
  course_id INTEGER NOT NULL
);

-- Table for gradebook
CREATE TABLE gradebook (
  grade_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  quiz_name VARCHAR(255),
  student_id INTEGER,
  grades INTEGER
);


-- Table for forum posts
CREATE TABLE forum (
  post_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  course_id INTEGER ,
  user_id INTEGER ,
  text_body LONGTEXT,
  created_at TIMESTAMP,
  Foreign KEY (Course_id) references courses(course_id)
);
