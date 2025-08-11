USE proyecciones;

DROP TABLE IF EXISTS person;

CREATE TABLE person(
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       first_name VARCHAR(255),
                       last_name VARCHAR(255)
);

DROP TABLE IF EXISTS address;
CREATE TABLE address(
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        person_id BIGINT,
                        state VARCHAR(255),
                        city VARCHAR(255),
                        street VARCHAR(255),
                        zip_code VARCHAR(255)
);
