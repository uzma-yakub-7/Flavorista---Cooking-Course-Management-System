

DROP TABLE IF EXISTS notifications CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS favorites CASCADE;
DROP TABLE IF EXISTS payments CASCADE;
DROP TABLE IF EXISTS order_items CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS cart_items CASCADE;
DROP TABLE IF EXISTS carts CASCADE;
DROP TABLE IF EXISTS menu_items CASCADE;
DROP TABLE IF EXISTS menu_categories CASCADE;
DROP TABLE IF EXISTS coupons CASCADE;
DROP TABLE IF EXISTS restaurants CASCADE;
DROP TABLE IF EXISTS addresses CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS roles CASCADE;

CREATE TABLE roles (

    role_id BIGSERIAL PRIMARY KEY,

    role_name VARCHAR(30) NOT NULL UNIQUE

);

CREATE TABLE users (

    user_id BIGSERIAL PRIMARY KEY,

    first_name VARCHAR(50) NOT NULL,

    last_name VARCHAR(50) NOT NULL,

    email VARCHAR(100) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL,

    phone VARCHAR(20),

    profile_image TEXT,

    auth_provider VARCHAR(30) NOT NULL DEFAULT 'LOCAL',

    is_verified BOOLEAN NOT NULL DEFAULT FALSE,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    role_id BIGINT NOT NULL,

    CONSTRAINT fk_user_role
        FOREIGN KEY (role_id)
        REFERENCES roles(role_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT

);

CREATE TABLE addresses (

    address_id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,

    label VARCHAR(30),

    address_line VARCHAR(255) NOT NULL,

    city VARCHAR(100) NOT NULL,

    state VARCHAR(100),

    postal_code VARCHAR(20),

    country VARCHAR(100) NOT NULL,

    latitude DECIMAL(10,7),

    longitude DECIMAL(10,7),

    is_default BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_address_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);

CREATE TABLE restaurants (

    restaurant_id BIGSERIAL PRIMARY KEY,

    restaurant_name VARCHAR(150) NOT NULL,

    description TEXT,

    email VARCHAR(100),

    phone VARCHAR(20),

    logo_url TEXT,

    cover_image TEXT,

    address VARCHAR(255),

    city VARCHAR(100),

    opening_time TIME,

    closing_time TIME,

    rating DECIMAL(2,1) DEFAULT 0,

    is_active BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

CREATE TABLE menu_categories (

    category_id BIGSERIAL PRIMARY KEY,

    restaurant_id BIGINT NOT NULL,

    category_name VARCHAR(100) NOT NULL,

    CONSTRAINT fk_category_restaurant
        FOREIGN KEY (restaurant_id)
        REFERENCES restaurants(restaurant_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);

CREATE TABLE menu_items (

    menu_item_id BIGSERIAL PRIMARY KEY,

    category_id BIGINT NOT NULL,

    restaurant_id BIGINT NOT NULL,

    item_name VARCHAR(150) NOT NULL,

    description TEXT,

    price NUMERIC(10,2) NOT NULL CHECK(price>=0),

    image_url TEXT,

    available BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_item_category
        FOREIGN KEY(category_id)
        REFERENCES menu_categories(category_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_item_restaurant
        FOREIGN KEY(restaurant_id)
        REFERENCES restaurants(restaurant_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);

CREATE TABLE coupons (

    coupon_id BIGSERIAL PRIMARY KEY,

    coupon_code VARCHAR(30) UNIQUE NOT NULL,

    discount_percentage NUMERIC(5,2),

    expiry_date DATE,

    active BOOLEAN DEFAULT TRUE

);

CREATE TABLE carts (

    cart_id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL UNIQUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_cart_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);

CREATE TABLE cart_items (

    cart_item_id BIGSERIAL PRIMARY KEY,

    cart_id BIGINT NOT NULL,

    menu_item_id BIGINT NOT NULL,

    quantity INTEGER NOT NULL DEFAULT 1 CHECK(quantity > 0),

    unit_price NUMERIC(10,2) NOT NULL CHECK(unit_price >= 0),

    subtotal NUMERIC(10,2) NOT NULL CHECK(subtotal >= 0),

    CONSTRAINT fk_cartitem_cart
        FOREIGN KEY (cart_id)
        REFERENCES carts(cart_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_cartitem_menuitem
        FOREIGN KEY (menu_item_id)
        REFERENCES menu_items(menu_item_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT

);


CREATE TABLE orders (

    order_id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,

    address_id BIGINT NOT NULL,

    coupon_id BIGINT,

    order_number VARCHAR(50) UNIQUE NOT NULL,

    order_status VARCHAR(30) NOT NULL DEFAULT 'PENDING',

    subtotal NUMERIC(10,2) NOT NULL CHECK(subtotal >= 0),

    discount NUMERIC(10,2) DEFAULT 0 CHECK(discount >= 0),

    delivery_fee NUMERIC(10,2) DEFAULT 0 CHECK(delivery_fee >= 0),

    tax NUMERIC(10,2) DEFAULT 0 CHECK(tax >= 0),

    total_amount NUMERIC(10,2) NOT NULL CHECK(total_amount >= 0),

    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_order_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT fk_order_address
        FOREIGN KEY (address_id)
        REFERENCES addresses(address_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT fk_order_coupon
        FOREIGN KEY (coupon_id)
        REFERENCES coupons(coupon_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL

);


CREATE TABLE order_items (

    order_item_id BIGSERIAL PRIMARY KEY,

    order_id BIGINT NOT NULL,

    menu_item_id BIGINT NOT NULL,

    quantity INTEGER NOT NULL CHECK(quantity > 0),

    price NUMERIC(10,2) NOT NULL CHECK(price >= 0),

    subtotal NUMERIC(10,2) NOT NULL CHECK(subtotal >= 0),

    CONSTRAINT fk_orderitem_order
        FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_orderitem_menuitem
        FOREIGN KEY (menu_item_id)
        REFERENCES menu_items(menu_item_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT

);



CREATE TABLE payments (

    payment_id BIGSERIAL PRIMARY KEY,

    order_id BIGINT NOT NULL UNIQUE,

    payment_method VARCHAR(50) NOT NULL,

    payment_status VARCHAR(30) NOT NULL DEFAULT 'PENDING',

    transaction_id VARCHAR(100) UNIQUE,

    amount NUMERIC(10,2) NOT NULL CHECK(amount >= 0),

    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_payment_order
        FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);



CREATE TABLE favorites (

    favorite_id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,

    restaurant_id BIGINT,

    menu_item_id BIGINT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_favorite_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_favorite_restaurant
        FOREIGN KEY (restaurant_id)
        REFERENCES restaurants(restaurant_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_favorite_menuitem
        FOREIGN KEY (menu_item_id)
        REFERENCES menu_items(menu_item_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);



CREATE TABLE reviews (

    review_id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,

    restaurant_id BIGINT NOT NULL,

    order_id BIGINT,

    rating INTEGER NOT NULL CHECK(rating BETWEEN 1 AND 5),

    review_text TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_review_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_review_restaurant
        FOREIGN KEY (restaurant_id)
        REFERENCES restaurants(restaurant_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_review_order
        FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL

);


CREATE TABLE notifications (

    notification_id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,

    title VARCHAR(150) NOT NULL,

    message TEXT NOT NULL,

    notification_type VARCHAR(50),

    is_read BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_notification_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);