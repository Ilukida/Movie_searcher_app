create table image_metadata
(
    id          uuid not null
        constraint pk_image_metadata
            primary key,
    create_date timestamp default now(),
    update_date timestamp default now(),
    name        varchar(255),
    url         varchar(255)
        unique,
    height      integer,
    width       integer
);

create table users
(
    id                uuid         not null
        constraint pk_users
            primary key,
    create_date       timestamp default now(),
    update_date       timestamp default now(),
    username          varchar(64)  not null
        unique,
    email             varchar(64)  not null
        unique,
    first_name        varchar(64),
    last_name         varchar(64),
    hash_password     varchar(255) not null,
    image_metadata_id uuid      default 'f73c03ee-2b2e-4e21-9fd1-e5e78dc66cf1'::uuid
        constraint fk_users_image_metadata
        references image_metadata
);

create table genre
(
    id                uuid not null
        constraint pk_genre
            primary key,
    create_date       timestamp default now(),
    update_date       timestamp default now(),
    image_metadata_id uuid
        constraint fk_genre_image_metadata
            references image_metadata,
    name              varchar(255),
    description       varchar(1024)
);

create table person
(
    id                uuid not null
        constraint pk_person
            primary key,
    create_date       timestamp default now(),
    update_date       timestamp default now(),
    image_metadata_id uuid
        constraint fk_person_image_metadata
            references image_metadata,
    first_name        varchar(64),
    last_name         varchar(64),
    middle_name       varchar(64),
    description       varchar(1024)
);

create table movie
(
    id                uuid not null
        constraint pk_movie
            primary key,
    create_date       timestamp default now(),
    update_date       timestamp default now(),
    image_metadata_id uuid
        constraint fk_movie_image_metadata
            references image_metadata,
    name              varchar(255),
    description       varchar(1024),
    release_date      date,
    country           varchar(64),
    average_rating    integer,
    genre_id          uuid
        constraint fk_movie_genre
            references genre
            on delete cascade
);

create table movie_person
(
    movie_id  uuid
        constraint fk_movie_person_1
            references movie
            on delete cascade,
    person_id uuid
        constraint fk_movie_person_2
            references person
            on delete cascade
);

create table review
(
    id          uuid not null
        constraint pk_review
            primary key,
    create_date timestamp default now(),
    update_date timestamp default now(),
    rating      integer,
    title       varchar(255),
    review      text,
    user_id     uuid
        constraint fk_review_user
            references users
            on delete cascade,
    movie_id    uuid
        constraint fk_review_movie
            references movie
            on delete cascade
);

create trigger avg_rating
    after insert
    on review
    for each row
    execute procedure update_avg_rating();

create table genre_commentary
(
    id          uuid not null
        constraint pk_genre_commentary
            primary key,
    create_date timestamp default now(),
    update_date timestamp default now(),
    text        varchar(255),
    user_id     uuid
        constraint fk_genre_commentary_user
            references users
            on delete cascade,
    genre_id    uuid
        constraint fk_genre_commentary_genre
            references genre
            on delete cascade
);

create table person_commentary
(
    id          uuid not null
        constraint pk_person_commentary
            primary key,
    create_date timestamp default now(),
    update_date timestamp default now(),
    text        varchar(255),
    user_id     uuid
        constraint fk_person_commentary_user
            references users
            on delete cascade,
    person_id   uuid
        constraint fk_person_commentary_person
            references person
            on delete cascade
);

create table movie_commentary
(
    id          uuid not null
        constraint pk_movie_commentary
            primary key,
    create_date timestamp default now(),
    update_date timestamp default now(),
    text        varchar(255),
    user_id     uuid
        constraint fk_movie_commentary_user
            references users
            on delete cascade,
    movie_id    uuid
        constraint fk_movie_commentary_movie
            references movie
            on delete cascade
);

create table roles
(
    id          uuid not null
        constraint pk_role
            primary key,
    role        varchar(64),
    create_date timestamp default now(),
    update_date timestamp default now()
);

create table user_roles
(
    user_id uuid
        constraint fk_user_roles_1
            references users
            on delete cascade,
    role_id uuid
        constraint fk_user_roles_2
            references roles
            on delete cascade
);

