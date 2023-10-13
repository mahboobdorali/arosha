CREATE TABLE course (
                        id serial PRIMARY KEY,
                        course_name VARCHAR(255) NOT NULL,
                        description TEXT
);
CREATE TABLE person_test (
                        id SERIAL PRIMARY KEY,
                        first_name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL
);
CREATE TABLE course_person (
                               course_id BIGINT NOT NULL,
                               person_id BIGINT NOT NULL,
                               PRIMARY KEY (course_id, person_id)
);