-- Create the department table
CREATE TABLE IF NOT EXISTS department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    capacity INT NOT NULL
    );

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
    hr_name VARCHAR(100),
    hr_email VARCHAR(100),
    hr_phone VARCHAR(20),
    organization_id BIGINT
    );

-- Create the employees table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(50) NOT NULL
    );

