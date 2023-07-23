ALTER TABLE set
    ADD CONSTRAINT fk_user_set FOREIGN KEY (user_id) REFERENCES _user (id);