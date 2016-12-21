DROP DATABASE WorkManager;
CREATE DATABASE WorkManager DEFAULT CHARACTER SET utf8;
USE WorkManager;

CREATE TABLE Teams
(
	TeamId			INT AUTO_INCREMENT PRIMARY KEY,
    Name			VARCHAR(255)
);

CREATE TABLE Users
(
	UserId			INT AUTO_INCREMENT PRIMARY KEY,
    Phone			VARCHAR(20),
    Name			VARCHAR(255),
    
    CONSTRAINT UC_Users_Id UNIQUE (Phone)
);

CREATE TABLE Members
(
	MemberId		INT AUTO_INCREMENT PRIMARY KEY,
	TeamId			INT,
    UserId			INT,
    
    CONSTRAINT FK_Members_TeamId FOREIGN KEY (TeamId) REFERENCES Teams(TeamId),
    CONSTRAINT FK_Members_UserId FOREIGN KEY (UserId) REFERENCES Users(UserId)
);

CREATE TABLE Tasks
(
	TaskId			INT AUTO_INCREMENT PRIMARY KEY,
	TeamId			INT,
    UserId			INT,
    Title			VARCHAR(255),
    Descript		TEXT,
    Begin			DATE,
    End				DATE,
    Status			TINYINT DEFAULT 0,
    
    CONSTRAINT FK_Works_TeamId FOREIGN KEY (TeamId) REFERENCES Teams(TeamId),
    CONSTRAINT FK_Works_UserId FOREIGN KEY (UserId) REFERENCES Users(UserId)
);

CREATE TABLE Tokens
(
	TokenId		INT AUTO_INCREMENT PRIMARY KEY,
    UserId		INT,
    VerifyCode	VARCHAR(6),
    Token		VARCHAR(32),
    
    CONSTRAINT FK_Tokens_UserId FOREIGN KEY (UserId) REFERENCES Users(UserId)
);
