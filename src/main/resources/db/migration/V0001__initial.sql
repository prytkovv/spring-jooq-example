CREATE TABLE public.product_category (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE public.product (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    inserted_at TIMESTAMPTZ NOT NULL,
    created_at TIMESTAMPTZ NOT NULL,
    category_id INT NOT NULL,
    CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES product_category (id)
);

CREATE TABLE public.tag (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE public.product_tag (
    product_id BIGINT NOT NULL,
    tag_id INTEGER NOT NULL,
    inserted_at TIMESTAMPTZ NOT NULL,
    PRIMARY KEY (product_id, tag_id),
    CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES public.product (id),
    CONSTRAINT fk_tag_id FOREIGN KEY (tag_id) REFERENCES public.tag (id)
);
