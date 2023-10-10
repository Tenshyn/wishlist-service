create table wl_user(
wu_id uuid not null,
wu_name varchar(80) not null,
wu_email varchar(100) not null,
primary key (wu_id)
);


create table wl_product(
wp_id uuid not null,
wp_name varchar(80) not null,
wp_link varchar(100) not null,
wp_price decimal not null,
primary key (wp_id)
);


create table wl_wishlist(
ww_user_id uuid not null,
ww_product_id uuid not null,
created_at date default now(),
primary key (ww_user_id, ww_product_id),
FOREIGN KEY (ww_user_id) REFERENCES wl_user(wu_id),
FOREIGN KEY (ww_product_id) REFERENCES wl_product(wp_id)
);