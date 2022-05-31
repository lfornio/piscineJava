CREATE TABLE IF NOT EXISTS Users
(
    UserId   BIGSERIAL PRIMARY KEY,
    Login    VARCHAR(30) NOT NULL,
    Password VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS Chatrooms
(
    ChatId BIGSERIAL PRIMARY KEY,
    Name   VARCHAR(100)                     NOT NULL,
    Owner  BIGINT REFERENCES Users (UserId) NOT NULL
);

CREATE TABLE IF NOT EXISTS Messages
(
    MessageId BIGSERIAL PRIMARY KEY,
    Author    BIGINT REFERENCES Users (UserId)     NOT NULL,
    Room      BIGINT REFERENCES Chatrooms (ChatId) NOT NULL,
    Text      text,
    Date_time timestamp with time zone
);

CREATE TABLE IF NOT EXISTS UsersChatrooms
(
    UserId BIGINT NOT NULL,
    ChatId BIGINT NOT NULL,
    PRIMARY KEY (UserId, ChatId),
    FOREIGN KEY (UserId) REFERENCES Users (UserId),
    FOREIGN KEY (ChatId) REFERENCES Chatrooms (ChatId)
);