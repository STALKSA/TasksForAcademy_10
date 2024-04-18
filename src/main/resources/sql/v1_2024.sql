

CREATE TABLE notebooks (
Id SERIAL PRIMARY KEY,
brand VARCHAR(50) NOT NULL,
name VARCHAR(20) NOT NULL,
pageAmount INT NOT NULL CHECK (pageAmount > 4),
cover VARCHAR(20) NOT NULL CHECK (cover = 'soft' OR cover = 'hard'),
country VARCHAR(50) NOT NULL,
pageType VARCHAR(20) NOT NULL CHECK (pageType = 'lined' OR pageType = 'squared' OR pageType = 'bold')
);

INSERT INTO notebooks (Id, brand, name, pageAmount, cover, country, pageType) VALUES
(1, 'Moleskine', 'Classic', 96, 'soft', 'Italy', 'squared'),
                                                                                  (2, 'Moleskine', 'Classic', 96, 'hard', 'Italy', 'squared'),
                                                                                  (3, 'Moleskine', 'Cashier', 48, 'soft', 'Italy', 'lined'),
                                                                                  (4, 'Moleskine', 'Hello-Kitty', 18, 'soft', 'Italy', 'squared'),
                                                                                  (5, 'Moleskine', 'ART', 48, 'soft', 'Italy', 'bold'),
                                                                                  (6, 'Moleskine', 'PRO', 96, 'hard', 'Italy', 'squared'),
                                                                                  (7, 'Rhodia', 'Rhodiarama', 80, 'hard', 'France', 'bold'),
                                                                                  (8, 'Rhodia', 'Heritage escher', 32, 'soft', 'France', 'squared'),
                                                                                  (9, 'Rhodia', 'Business', 90, 'soft', 'France', 'bold'),
                                                                                  (10, 'Rhodia', 'Rhodiactive', 80, 'soft', 'France', 'squared'),
                                                                                  (11, 'Rhodia', 'Webnotebook', 96, 'hard', 'France', 'lined'),
                                                                                  (12, 'Rhodia', 'Heritage moucheture', 32, 'hard', 'France', 'squared'),
                                                                                  (13, 'Ciak', 'Techno', 96, 'hard', 'Italy', 'squared'),
                                                                                  (14, 'Ciak', 'Duo', 96, 'hard', 'Italy', 'squared'),
                                                                                  (15, 'Ciak', 'Eco', 36, 'soft', 'Italy', 'bold'),
                                                                                  (16, 'Ciak', 'Titan', 96, 'hard', 'Italy', 'squared'),
                                                                                  (17, 'Blankster', 'Megapolis', 96, 'hard', 'Sweden', 'lined'),
                                                                                  (18, 'Fenimore', 'Isometric', 24, 'hard', 'GB', 'bold'),
                                                                                  (19, 'Fenimore', 'Black and Red Lines', 24, 'hard', 'GB', 'squared'),
                                                                                  (20, 'Zakrtka', 'A5', 24, 'soft', 'Ukraine', 'bold'),
                                                                                  (21, 'Zakrtka', 'Compact', 12, 'soft', 'Ukraine', 'lined'),
                                                                                  (22, 'Zakrtka', 'Update', 36, 'soft', 'Ukraine', 'lined');