CREATE TABLE users (
    username         VARCHAR(100) NOT NULL,
    password         VARCHAR(100) NOT NULL,
    name             VARCHAR(100) NOT NULL,
    token            VARCHAR(100) UNIQUE,
    token_expired_at BIGINT,
    PRIMARY KEY (username)
);

CREATE TABLE contacts (
    id         UUID NOT NULL,
    username   VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100),
    phone      VARCHAR(100),
    email      VARCHAR(100),
    PRIMARY KEY (id),
    CONSTRAINT fk_users_contacts FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE
);

CREATE TABLE addresses (
    id          UUID NOT NULL,
    contact_id  UUID NOT NULL,
    street      VARCHAR(200),
    city        VARCHAR(100),
    province    VARCHAR(100),
    country     VARCHAR(100) NOT NULL,
    postal_code VARCHAR(10),
    PRIMARY KEY (id),
    CONSTRAINT fk_contacts_addresses FOREIGN KEY (contact_id) REFERENCES contacts (id) ON DELETE CASCADE
);
