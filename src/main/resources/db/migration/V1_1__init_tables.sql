---------------------------------------------------
-- Table `_user`
---------------------------------------------------

CREATE TABLE IF NOT EXISTS public._user
(
    id       bigserial    not null
        constraint _user_pkey
            primary key,
    email    varchar(255) not null
        constraint uk_k11y3pdtsrjgy8w9b6q4bjwrx
            unique,
    password varchar(255) not null
);

alter table _user
    owner to "scryfall-user";

---------------------------------------------------
-- Table `set`
---------------------------------------------------
CREATE TABLE IF NOT EXISTS set
(
    set_id       SERIAL PRIMARY KEY,
    object       VARCHAR(255),
    id           VARCHAR(255),
    code         VARCHAR(255),
    name         VARCHAR(255),
    tcgplayer_id VARCHAR(255),
    scryfall_uri VARCHAR(255),
    search_uri   VARCHAR(255),
    released_at  VARCHAR(255),
    set_type     VARCHAR(255),
    card_count   VARCHAR(255),
    digital      VARCHAR(255),
    nonfoil_only VARCHAR(255),
    foil_only    VARCHAR(255),
    icon_svg_uri VARCHAR(255)
);
---------------------------------------------------
-- Table `card`
---------------------------------------------------
CREATE TABLE IF NOT EXISTS card
(
    card_id SERIAL PRIMARY KEY,
    id      VARCHAR(255) NOT NULL
);

---------------------------------------------------
-- Table `card_set_list` many2many
---------------------------------------------------
CREATE TABLE IF NOT EXISTS card_set_list
(
    card_id BIGINT REFERENCES card (card_id) ON DELETE CASCADE,
    set_id  BIGINT REFERENCES set (set_id) ON DELETE CASCADE,
    PRIMARY KEY (card_id, set_id)
);
