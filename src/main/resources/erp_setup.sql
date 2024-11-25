-- Create the ERP Database
CREATE DATABASE IF NOT EXISTS erp;

-- Use the ERP Database
USE erp;

-- Create the organizations table
CREATE TABLE IF NOT EXISTS organizations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- Create the organization_hr table
CREATE TABLE IF NOT EXISTS organization_hr (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT,
    hr_name VARCHAR(100),
    hr_email VARCHAR(100),
    hr_phone VARCHAR(20),
    FOREIGN KEY (organization_id) REFERENCES organizations(id) ON DELETE CASCADE
    );

-- Create the employees table
CREATE TABLE IF NOT EXISTS users (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    username VARCHAR(100) UNIQUE NOT NULL,
                                    password VARCHAR(255) NOT NULL,
                                    email VARCHAR(50) NOT NULL
    );

-- Insert initial data into the employees table
INSERT INTO users (username, password, email) VALUES ('user1', '$2y$10$Qphllk47iqPrUQZvr3XJA.7VATmIXObjoyM.NhSZ/XQjbSHOz/sCC', 'abc@123');