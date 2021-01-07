

-- Drop table
-- DROP TABLE public.customer;

CREATE TABLE public.customer (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	username varchar(50) NOT NULL,
	"password" varchar(255) NOT NULL,
	email varchar(25) NOT NULL,
	first_name varchar(25) NOT NULL,
	last_name varchar(25) NULL,
	bank_account_id uuid NULL,
    created_at timestamp,
    created_by uuid,
    updated_at timestamp,
    updated_by uuid,
    is_deleted smallint,
	CONSTRAINT customer_pkey PRIMARY KEY (id)
);


-- public.customer foreign keys

ALTER TABLE public.customer ADD CONSTRAINT customer_bank_account_id_fkey FOREIGN KEY (bank_account_id) REFERENCES bank_account(id);

-- public.bank_account definition

-- Drop table

-- DROP TABLE public.bank_account;

CREATE TABLE public.bank_account (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	bank_name varchar(25) NOT NULL,
	account_number varchar(25) NOT NULL,
	CONSTRAINT bank_account_pkey PRIMARY KEY (id)
);