# Setup

To run project, Java 17 and PostgreSQL required.

## PostgreSQL setup

```
DB user and db init:
CREATE DATABASE 'scryfall'
CREATE USER scryfall-user WITH password 'scryfall';
GRANT ALL ON DATABASE "scryfall" TO scryfall-user;
```

You can also set up database and user with pgAdmin where you also need to give user the 'Can login' option

Dabase migrations are located inside in resources/db folder, and they run automatically with starting of application,
new migrations will bi applied. This all is handled by flyway library.

## Project setup

# Set up test data

```
INSERT INTO public._user (email, password) VALUES ('test@test.com', '$2a$10$IktVOIWenAjTnuDGX2Pe4.M.Vkp/FuaBmiejMPci3vW2/1ef901TO'); 
```