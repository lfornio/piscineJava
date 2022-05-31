INSERT INTO Users (Login, Password)
VALUES
    ('AAAAA', 'aaaaaa'),
    ('BBBBB', 'bbbbb'),
    ('CCCCC', 'ccccc'),
    ('DDDDD', 'ddddd'),
    ('IIIII', 'iiiii');

INSERT INTO Chatrooms (Name, Owner)
VALUES
    ('Chat_1', 3),
    ('Chat_2', 1),
    ('Chat_3', 2),
    ('Chat_4', 5),
    ('Chat_5', 2);

INSERT INTO Messages (Author, Room, Text, Date_time)
VALUES
    (2, 5, 'hei-hei-hei-hei', current_timestamp AT TIME ZONE 'UTC'),
    (2, 1, 'vay-vay-vay-vay-vay', current_timestamp AT TIME ZONE 'UTC' ),
    (1, 2, 'la-la-la-la-la-la', current_timestamp AT TIME ZONE 'UTC'),
    (3, 3, 'go-go-go-go-go-go', current_timestamp AT TIME ZONE 'UTC'),
    (5, 3, 'eee-eee-eee-eee-eee', current_timestamp AT TIME ZONE 'UTC');

INSERT INTO UsersChatrooms (UserId, ChatId)
VALUES
    (1, 3),
    (5, 1),
    (3, 2),
    (1, 5),
    (2, 2);