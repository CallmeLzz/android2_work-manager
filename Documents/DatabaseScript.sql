-- DROP DATABASE WorkManager;
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
	TempId			INT,
    UserId			INT,
    
    CONSTRAINT FK_Members_TempId FOREIGN KEY (TempId) REFERENCES Teams(TeamId),
    CONSTRAINT FK_Members_UserId FOREIGN KEY (UserId) REFERENCES Users(UserId)
);

CREATE TABLE Works
(
	WorkId			INT AUTO_INCREMENT PRIMARY KEY,
	TempId			INT,
    UserId			INT,
    Title			VARCHAR(255),
    Descript		TEXT,
    Start			DATE,
    Finish			DATE,
    Status			TINYINT DEFAULT 0,
    
    CONSTRAINT FK_Works_TempId FOREIGN KEY (TempId) REFERENCES Teams(TeamId),
    CONSTRAINT FK_Works_UserId FOREIGN KEY (UserId) REFERENCES Users(UserId)
);
