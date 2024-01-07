DROP TABLE IF EXISTS cosmetics;
CREATE TABLE cosmetics (
    id int unsigned AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    effect VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);
INSERT INTO cosmetics (name,effect) VALUES ("niacinamide","Wrinkle improvement");
INSERT INTO cosmetics (name,effect) VALUES ("tranexamic acid","Whitening");
INSERT INTO cosmetics (name,effect) VALUES ("panthenol","Activation of skin cells");
INSERT INTO cosmetics (name,effect) VALUES ("azelaic acid","Sebum control");
