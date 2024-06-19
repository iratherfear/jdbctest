CREATE TABLE course (
    course_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(80) NOT NULL,         -- Course Title
    description VARCHAR(500) NOT NULL,  -- Course Description
    link VARCHAR(255) NOT NULL,         -- Course landing page link
    PRIMARY KEY (course_id)
);
