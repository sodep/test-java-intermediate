CREATE TABLE potluck
(
  id integer NOT NULL,
  name character varying(20),
  food character varying(30),
  confirmed character(1),
  signup_date date,
  CONSTRAINT potluck_pkey PRIMARY KEY (id )
)
