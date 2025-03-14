CREATE TABLE IF NOT EXISTS "product" (
    "id" SERIAL PRIMARY KEY,
    "product_name" VARCHAR(255) NOT NULL,
    "quantity" INT DEFAULT NULL,
    "price" DECIMAL(10,2) DEFAULT NULL,
    "manufacturer" VARCHAR(255) DEFAULT NULL,
    "active" BOOLEAN DEFAULT TRUE,
    "last_update" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "date_created" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX IF NOT EXISTS idx_productname ON "product"("product_name");