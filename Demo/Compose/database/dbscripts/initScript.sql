CREATE TABLE Workout
(
    id            SERIAL PRIMARY KEY,
    name          varchar   not null,
    creation_date timestamp not null,
    creator_id    int       not null,
    official_flag boolean   not null
);

CREATE TABLE Exercise
(
    id              SERIAL PRIMARY KEY,
    name            varchar   not null,
    creator_id      int       not null,
    creation_date   timestamp not null,
    exercise_type   varchar   not null,
    standard_set_nr int       not null,
    official_flag   boolean   not null
);

CREATE TABLE Person
(
    id         SERIAL PRIMARY KEY,
    name       varchar not null,
    picture_id int     not null,
    is_trainer boolean not null
);

CREATE TABLE Customer
(
    id            SERIAL PRIMARY KEY,
    join_date     date    not null,
    trainer_id    int     not null,
    cash_customer boolean not null,
    member_till   date    null

);

CREATE TABLE Workout2Exercise
(
    workout_id  int not null,
    exercise_id int not null
);

CREATE TABLE Trainer
(
    id            SERIAL PRIMARY KEY,
    trainer_since date not null
);

CREATE TABLE Workout_History
(
    id          SERIAL PRIMARY KEY,
    date        timestamp not null,
    workout_id  int       not null,
    customer_id int       not null
);

CREATE TABLE Set
(
    id          SERIAL PRIMARY KEY,
    exercise_id int     not null,
    repetitions int     null,
    distance    float   null,
    weight      float   null,
    time        float   null,
    set_number  int     not null,
    type        varchar not null
);

CREATE TABLE Exercise_History
(
    id                 SERIAL PRIMARY KEY,
    workout_history_id int
);

CREATE TABLE Set_History
(
    id                  SERIAL PRIMARY KEY,
    exercise_history_id int   not null,
    time                float not null,
    distance            float null,
    weight              float null,
    repetitions         int   null,
    set_number          int   null
);

CREATE TABLE News_Letter
(
    id       SERIAL PRIMARY KEY,
    title    varchar not null,
    body     varchar not null,
    imageUrl varchar not null
);

ALTER TABLE Workout
    ADD FOREIGN KEY (creator_id) REFERENCES Person (id);

ALTER TABLE Exercise
    ADD FOREIGN KEY (creator_id) REFERENCES Person (id);

ALTER TABLE Customer
    ADD FOREIGN KEY (trainer_id) REFERENCES Trainer (id);

ALTER TABLE Workout2Exercise
    ADD FOREIGN KEY (workout_id) REFERENCES Workout (id);

ALTER TABLE Workout2Exercise
    ADD FOREIGN KEY (exercise_id) REFERENCES Exercise (id);

ALTER TABLE Workout_History
    ADD FOREIGN KEY (workout_id) REFERENCES Workout (id);

ALTER TABLE Workout_History
    ADD FOREIGN KEY (customer_id) REFERENCES Person (id);

ALTER TABLE Set
    ADD FOREIGN KEY (exercise_id) REFERENCES Exercise (id);

ALTER TABLE Exercise_History
    ADD FOREIGN KEY (workout_history_id) REFERENCES Workout_History (id);

ALTER TABLE Set_History
    ADD FOREIGN KEY (exercise_history_id) REFERENCES Exercise_History (id);

--ALTER TABLE  Set  ADD FOREIGN KEY ( set_number ) REFERENCES  Workout2Exercise  ( workout_id );

CREATE SEQUENCE hibernate_sequence START 1;
