CREATE TABLE IF NOT EXISTS set_icon
(
    id        SERIAL PRIMARY KEY,
    name      TEXT,
    icon_path TEXT
);

INSERT INTO set_icon(name, icon_path)
VALUES ('40k', 'assets/icon/set-logo/40k.svg');
INSERT INTO set_icon(name, icon_path)
VALUES ('Cmm', 'assets/icon/set-logo/cmm.svg');
INSERT INTO set_icon(name, icon_path)
VALUES ('Ha1', 'assets/icon/set-logo/ha1.svg');
INSERT INTO set_icon(name, icon_path)
VALUES ('Ltc', 'assets/icon/set-logo/ltc.svg');
INSERT INTO set_icon(name, icon_path)
VALUES ('Ltr', 'assets/icon/set-logo/ltr.svg');
INSERT INTO set_icon(name, icon_path)
VALUES ('Mom', 'assets/icon/set-logo/mom.svg');
INSERT INTO set_icon(name, icon_path)
VALUES ('Mul', 'assets/icon/set-logo/mul.svg');
INSERT INTO set_icon(name, icon_path)
VALUES ('One', 'assets/icon/set-logo/one.svg');
INSERT INTO set_icon(name, icon_path)
VALUES ('Star', 'assets/icon/set-logo/star.svg');