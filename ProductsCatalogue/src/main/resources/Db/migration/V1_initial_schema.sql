CREATE TABLE category
(
    id              BIGINT       NOT NULL,
    created_at      datetime     NULL,
    updated_at      datetime     NULL,
    is_deleted      BIT(1)       NULL,
    category_name            VARCHAR(255) NOT NULL,
    `description`   VARCHAR(255) NULL,
    sub_category_id BIGINT       NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE category_featured_products
(
    category_id          BIGINT NOT NULL,
    featured_products_id BIGINT NOT NULL
);

CREATE TABLE product
(
    id            BIGINT       NOT NULL,
    created_at    datetime     NULL,
    updated_at    datetime     NULL,
    is_deleted    BIT(1)       NULL,
    name          VARCHAR(255) NULL,
    price         DOUBLE       NULL,
    imageurl      VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    category_id   BIGINT       NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE sub_category
(
    id         BIGINT       NOT NULL,
    created_at datetime     NULL,
    updated_at datetime     NULL,
    is_deleted BIT(1)       NULL,
    sur_name   VARCHAR(255) NULL,
    CONSTRAINT pk_subcategory PRIMARY KEY (id)
);

ALTER TABLE category_featured_products
    ADD CONSTRAINT uc_category_featured_products_featuredproducts UNIQUE (featured_products_id);

ALTER TABLE category
    ADD CONSTRAINT uc_category_name UNIQUE (category_name);

ALTER TABLE category
    ADD CONSTRAINT FK_CATEGORY_ON_SUB_CATEGORY FOREIGN KEY (sub_category_id) REFERENCES sub_category (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_featured_products
    ADD CONSTRAINT fk_catfeapro_on_category FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_featured_products
    ADD CONSTRAINT fk_catfeapro_on_product FOREIGN KEY (featured_products_id) REFERENCES product (id);