
-- Insert student data
INSERT INTO student (firstname, lastname, address, phone_number, dob, balance, login_id) VALUES
  ('John', 'Doe', '123 Main St', '123-456-7899', '01-01-1998', 0.0, 1),
  ('Jane', 'Doe', '456 Elm St', '345-123-3478', '02-02-1999', 0.0, 2);

 -- Insert login data
 INSERT INTO login (email, password, user_type, status, student_id) VALUES
   ('john.doe@example.com', 'password', 'student', 'active', 1),
   ('jane.doe@example.com', 'password', 'student', 'active', 2);
   --(3, 'educator@example.com', 'password', 'educator', 'active');

-- Insert gradebook data
INSERT INTO gradebook (student_id, teacher_id, grades) VALUES
  (1, 3, 80),
  (2, 3, 90),
  (1, 1, 85),
  (1, 1, 95),
  (1, 1, 90),
  (1, 1, 92),
  (1, 1, 88),
  (1, 1, 91),
  (1, 1, 87),
  (1, 1, 89),
  (1, 1, 86),
  (1, 1, 93),
  (2, 1, 82),
  (2, 1, 88),
  (2, 1, 94),
  (2, 1, 86),
  (2, 1, 91),
  (2, 1, 85),
  (2, 1, 89),
  (2, 1, 87),
  (2, 1, 90),
  (2, 1, 92),
  (1, 2, 85),
  (1, 2, 87),
  (1, 2, 90),
  (1, 2, 92),
  (1, 2, 88),
  (1, 2, 91),
  (1, 2, 87),
  (1, 2, 89),
  (1, 2, 86),
  (1, 2, 93),
  (2, 2, 82),
  (2, 2, 88),
  (2, 2, 94),
  (2, 2, 86),
  (2, 2, 91),
  (2, 2, 85),
  (2, 2, 89),
  (2, 2, 87),
  (2, 2, 90),
  (2, 2, 92);


-- Insert forum post data
INSERT INTO forum (course_id, user_id, text_body, created_at) VALUES
  (1, 1, 'Hi everyone, I am excited to learn computer science!', '2023-04-13 15:30:00'),
  (1, 2, 'I am struggling with the programming assignments, any tips?', '2023-04-14 10:15:00'),
  (2, 1, 'I really enjoyed the data structures lectures, thanks!', '2023-04-15 11:00:00'),
  (1, 3, 'Has anyone found a good study group for this course?', '2023-04-16 14:20:00'),
  (1, 4, 'I found the programming assignments easier after breaking them down into smaller steps.', '2023-04-17 09:45:00'),
  (1, 2, 'I also struggled with the programming assignments at first, but found the office hours really helpful.', '2023-04-18 16:30:00'),
  (1, 5, 'I am having trouble with the midterm review, any tips?', '2023-04-19 08:00:00'),
  (1, 1, 'Has anyone tried the extra practice problems? Are they worth doing?', '2023-04-20 12:00:00'),
  (1, 4, 'I am finding the lectures really confusing, is anyone else feeling the same way?', '2023-04-21 10:30:00'),
  (1, 3, 'I found the sample code really helpful for the programming assignments.', '2023-04-22 11:45:00'),
  (1, 2, 'I am having trouble with time management, any tips?', '2023-04-23 09:00:00'),
  (1, 5, 'I am really enjoying the guest lectures, they are so interesting!', '2023-04-24 14:15:00'),
  (1, 3, 'I am feeling overwhelmed by the amount of material we need to know for the final, any advice?', '2023-04-25 11:30:00'),
  (1, 1, 'I found the TA office hours really helpful for the programming assignments.', '2023-04-26 16:00:00'),
  (1, 4, 'I am finding the textbook really confusing, any recommendations for alternative resources?', '2023-04-27 08:45:00'),
  (1, 2, 'I am really impressed by the organization of the course material, it makes studying much easier!', '2023-04-28 13:30:00'),
  (1, 5, 'I am struggling with the final project, any tips?', '2023-04-29 10:15:00'),
  (1, 1, 'I found the quizzes really helpful for testing my understanding of the material.', '2023-04-30 12:30:00'),
  (1, 4, 'I am really struggling to keep up with the lectures and assignments, any advice?', '2023-05-01 09:00:00'),
  (1, 3, 'I am finding the course material really challenging, but also very rewarding!', '2023-05-02 14:00:00');

-- Insert course data
INSERT INTO courses (educator_id, name, keywords, category, course_level, description, cost) VALUES
  (3, 'Introduction to Computer Science', 'programming, computer science, basics', 'Computer Science', 101, 'Introduction to the major areas of computer science including operating systems, machine architecture, programming languages, data representation and storage, and algorithm development. Includes major emphasis in problem solving and simple programming concepts.', 250.00),
  (3, 'Principles of Cybersecurity', 'cybersecurity, computer science', 'Computer Science', 121, 'An introduction to the basics of modern cybersecurity at the individual and organizational level.', 250.00),
  (3, 'Algorithm Design and Implementation I', 'algorithm, programming, problem solving', 'Computer Science', 161, 'Basic concepts of computer programming, problem solving, algorithm development, and program coding using a high-level, block-structured language.', 250),
  (3, 'Fundamentals of Information Technologies and Systems', 'information technology, computer technology, technology', 'Computer Science', 204,'Coverage of the fundamentals of information system and information technology concepts, strategies and skills.', 250),
  (3, 'An Introduction to Applications of Database Management Systems', 'relational database, database, sql, mysql', 'Computer Science', 234, 'A course covering relational database basic structure, method of design, implementation and manipulation. Student will design and implement a major database project using a production version database management system.', 250),
  (3, 'Software Engineering', 'design, implemetation, testing software development', 'Computer Science', 385, 'Introduction of the methods used for specifying,designing, implementing, and testing medium and large-scale software systems; methods for organizing and managing software development projects.', 250),
  (3, 'Advanced Data Structures', 'data structures, algorithms, programming', 'Computer Science', 401, 'A course covering advanced data structures and algorithms in computer science.', 250.00);
--INSERT INTO courses (educatorId, name, keywords, category, courseLevel, description, cost) VALUES
--(1, 'CSC 100 - Intro to Computer', 'computer systems, simple programming', 'Computer Science',100, 'Provides an insight into the problem-solving/software/social/ethical/legal issues that underlie computer systems; includes databases, spread sheets and simple programming.', 2500)
--(3, 'CSC 101 - Computer Science I', 'algorithm, programming', 'Computer Science',100, 'Problem-solving, algorithm development, computer programming, overview of computer science.', 2500)
--(4, 'CSC 203 - Introduction to Computer Systems','architecture, assembler language', 'Computer Science', 200, 'Computer systems and architecture, assembler language programming.', 2500)

INSERT INTO quiz (quiz_name, question, answer1, answer2, answer3, answer4, answer, course_id) VALUES
('Introduction to Computer Science Quiz 1', 'What is a computer?', 'A) A device that performs arithmetic operations', 'B) A device that can receive, store, process, and output data', 'C) A device that can only perform logical operations', 'D) A device that can only perform calculations', 'B', '1'),
('Introduction to Computer Science Quiz 1', 'What is a programming language?', 'A) A set of instructions that a computer can understand', 'B) A program that translates natural language into machine code', 'C) A type of computer', 'D) A set of hardware components', 'A', '1'),
('Introduction to Computer Science Quiz 1', 'What is an algorithm?', 'A) A set of instructions for a computer program', 'B) A device that performs arithmetic operations', 'C) A program that translates natural language into machine code', 'D) A type of computer', 'A', '1'),
('Introduction to Computer Science Quiz 1', 'What is a variable in programming?', 'A) A reserved word in a programming language', 'B) A value that can be changed during the execution of a program', 'C) A data structure used to store data in memory', 'D) A hardware component', 'B', '1'),
('Introduction to Computer Science Quiz 1', 'What is a loop in programming?', 'A) A type of data structure', 'B) A control structure that allows repeated execution of a block of code', 'C) A reserved word in a programming language', 'D) A hardware component', 'B', '1');

INSERT INTO quiz (quiz_name, question, answer1, answer2, answer3, answer4, answer, course_id) VALUES
('Principles of Cyber Security Quiz 1', 'What is the CIA triad in Cyber Security?', 'A) Confidentiality, Integrity, Availability', 'B) Cybersecurity, Information security, Network security', 'C) Firewall, Intrusion Detection System, Intrusion Prevention System', 'D) Phishing, Malware, Ransomware', 'A', '2'),
('Principles of Cyber Security Quiz 1', 'What is encryption?', 'A) The process of converting plaintext into ciphertext', 'B) The process of converting ciphertext into plaintext', 'C) The process of destroying data', 'D) The process of creating fake data', 'A', '2'),
('Principles of Cyber Security Quiz 1', 'What is a firewall?', 'A) A device that detects and prevents unauthorized access to a network', 'B) A type of malware that encrypts files and demands payment for their release', 'C) A type of phishing attack that targets specific individuals', 'D) A type of software that protects against spam emails', 'A', '2'),
('Principles of Cyber Security Quiz 1', 'What is a vulnerability in Cyber Security?', 'A) A weakness in a system that can be exploited by attackers', 'B) A type of malware that replicates itself and spreads to other computers', 'C) A type of attack that floods a network with traffic to disrupt its normal operation', 'D) A type of malware that intercepts user input and sends it to a third party', 'A', '2'),
('Principles of Cyber Security Quiz 1', 'What is two-factor authentication?', 'A) A type of encryption that requires two keys to decrypt data', 'B) A type of firewall that uses two layers of protection', 'C) A type of access control that requires two forms of authentication', 'D) A type of intrusion detection system that detects two types of attacks', 'C', '2');

INSERT INTO quiz (quiz_name, question, answer1, answer2, answer3, answer4, answer, course_id) VALUES
('Algorithm Design Quiz 1', 'Which of the following is NOT a sorting algorithm?', 'A) Quicksort', 'B) Heapsort', 'C) Depth-First Search', 'D) Mergesort', 'C', '3'),
('Algorithm Design Quiz 1', 'Which of the following data structures uses LIFO (Last In First Out) principle?', 'A) Stack', 'B) Queue', 'C) Heap', 'D) Linked List', 'A', '3'),
('Algorithm Design Quiz 1', 'What is the worst case time complexity of the bubble sort algorithm?', 'A) O(1)', 'B) O(log n)', 'C) O(n)', 'D) O(n^2)', 'D', '3'),
('Algorithm Design Quiz 1', 'Which of the following is NOT an example of a divide and conquer algorithm?', 'A) Merge sort', 'B) Binary search', 'C) Quick sort', 'D) Bubble sort', 'D', '3'),
('Algorithm Design Quiz 1', 'What is the time complexity of the binary search algorithm?', 'A) O(1)', 'B) O(log n)', 'C) O(n)', 'D) O(n^2)', 'B', '3');

INSERT INTO quiz (quiz_name, question, answer1, answer2, answer3, answer4, answer, course_id) VALUES
('Algorithm Design Quiz 2', 'Which of the following is NOT a characteristic of a greedy algorithm?', 'A) It makes the locally optimal choice', 'B) It never reconsiders past decisions', 'C) It always produces the optimal solution', 'D) It may not always produce the globally optimal solution', 'C', '3'),
('Algorithm Design Quiz 2', 'Which of the following data structures uses the FIFO (First In First Out) principle?', 'A) Stack', 'B) Queue', 'C) Heap', 'D) Linked List', 'B', '3'),
('Algorithm Design Quiz 2', 'What is the worst case time complexity of the selection sort algorithm?', 'A) O(1)', 'B) O(log n)', 'C) O(n)', 'D) O(n^2)', 'D', '3'),
('Algorithm Design Quiz 2', 'What is the space complexity of the merge sort algorithm?', 'A) O(1)', 'B) O(log n)', 'C) O(n)', 'D) O(n log n)', 'D', '3'),
('Algorithm Design Quiz 2', 'Which of the following is NOT an example of a dynamic programming algorithm?', 'A) Knapsack problem', 'B) Longest common subsequence problem', 'C) Dijkstra algorithm', 'D) Fibonacci sequence', 'C', '3');

INSERT INTO quiz (quiz_name, question, answer1, answer2, answer3, answer4, answer, course_id) VALUES
('Fundamentals of IT Quiz 1', 'What is an operating system?', 'A) A program that manages computer hardware resources', 'B) A program that helps users create documents and presentations', 'C) A program that connects computers to the internet', 'D) A program that protects against malware', 'A', '4'),
('Fundamentals of IT Quiz 1', 'What is a file system?', 'A) The way files are named and organized on a storage device', 'B) A type of software that detects and removes malware', 'C) The way files are transmitted over a network', 'D) The way files are displayed on a computer screen', 'A', '4'),
('Fundamentals of IT Quiz 1', 'What is a network?', 'A) A group of computers and other devices connected together', 'B) A type of software that performs a specific task', 'C) A type of computer hardware', 'D) A type of malware', 'A', '4'),
('Fundamentals of IT Quiz 1', 'What is a protocol?', 'A) A set of rules for communication between devices', 'B) A type of computer hardware', 'C) A type of software that performs a specific task', 'D) A type of malware', 'A', '4'),
('Fundamentals of IT Quiz 1', 'What is a database?', 'A) A collection of data organized in a specific way', 'B) A type of computer hardware', 'C) A type of software that performs a specific task', 'D) A type of malware', 'A', '4');

INSERT INTO quiz (quiz_name, question, answer1, answer2, answer3, answer4, answer, course_id) VALUES
('Fundamentals of IT Quiz 2', 'What is a CPU?', 'A) The part of a computer that displays images on a screen', 'B) The part of a computer that stores data', 'C) The part of a computer that performs calculations and controls other hardware', 'D) The part of a computer that connects to the internet', 'C', '4'),
('Fundamentals of IT Quiz 2', 'What is RAM?', 'A) A type of computer hardware', 'B) The part of a computer that stores data', 'C) The part of a computer that performs calculations and controls other hardware', 'D) The part of a computer that connects to the internet', 'B', '4'),
('Fundamentals of IT Quiz 2', 'What is a web browser?', 'A) A type of software that creates and edits documents', 'B) A type of software that connects to the internet', 'C) A type of computer hardware', 'D) A type of software that protects against malware', 'B', '4'),
('Fundamentals of IT Quiz 2', 'What is cloud computing?', 'A) A type of computer hardware', 'B) A type of software that connects to the internet', 'C) A way of delivering computing resources over the internet', 'D) A type of malware', 'C', '4'),
('Fundamentals of IT Quiz 2', 'What is a router?', 'A) A device that connects computers to the internet', 'B) A type of software that performs a specific task', 'C) A type of computer hardware', 'D) A type of malware', 'A', '4');