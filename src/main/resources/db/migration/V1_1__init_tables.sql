---------------------------------------------------
-- Table `_user`
---------------------------------------------------

CREATE TABLE  IF NOT EXISTS  public._user
(
    id bigserial not null
        constraint _user_pkey
            primary key,
    email varchar(255) not null
            constraint uk_k11y3pdtsrjgy8w9b6q4bjwrx
                unique,
    password varchar(255) not null
    );

alter table _user owner to "scryfall-user";

---------------------------------------------------
-- Table `set`
---------------------------------------------------

CREATE TABLE IF NOT EXISTS public.set (
    id bigserial not null
        constraint set_pkey
            primary key,
    name text not null
        constraint name_unique
            unique,
    user_id bigserial REFERENCES _user(id)
);

---------------------------------------------------
-- Table `card`
---------------------------------------------------

CREATE TABLE IF NOT EXISTS public.card (
    id bigserial not null
        constraint card_pkey
            primary key,
    oracle_id UUID,
    multiverse_ids INTEGER[],
    mtgo_id INTEGER,
    mtgo_foil_id INTEGER,
    tcgplayer_id INTEGER,
    cardmarket_id INTEGER,
    name TEXT,
    lang TEXT,
    released_at DATE,
    uri TEXT,
    scryfall_uri TEXT,
    layout TEXT,
    highres_image BOOLEAN,
    image_status TEXT,
    mana_cost TEXT,
    cmc INTEGER,
    type_line TEXT,
    oracle_text TEXT,
    colors TEXT[],
    color_identity TEXT[],
    keywords TEXT[],
    legalities JSONB,
    games TEXT[],
    reserved BOOLEAN,
    foil BOOLEAN,
    nonfoil BOOLEAN,
    finishes TEXT[],
    oversized BOOLEAN,
    promo BOOLEAN,
    reprint BOOLEAN,
    variation BOOLEAN,
    set_id bigserial REFERENCES set(id),
    set_name TEXT,
    set_type TEXT,
    set_uri TEXT,
    set_search_uri TEXT,
    scryfall_set_uri TEXT,
    rulings_uri TEXT,
    prints_search_uri TEXT,
    collector_number TEXT,
    digital BOOLEAN,
    rarity TEXT,
    flavor_text TEXT,
    card_back_id UUID,
    artist TEXT,
    artist_ids TEXT[],
    illustration_id UUID,
    border_color TEXT,
    frame TEXT,
    full_art BOOLEAN,
    textless BOOLEAN,
    booster BOOLEAN,
    story_spotlight BOOLEAN,
    edhrec_rank INTEGER,
    penny_rank INTEGER,
    prices JSONB,
    related_uris JSONB,
    purchase_uris JSONB
);