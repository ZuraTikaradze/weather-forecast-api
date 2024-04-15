# Weather Forecast API Documentation

## Overview

**Purpose:** This document details the design and implementation of the Weather Forecast API, designed to provide and
manage weather forecasts.

## Technology Stack:

* Java Version : 21
* Framework: Spring Boot 3.2.4
* Database: H2 Database
* Database Migration: FlyWay
* Validation: Jakarta Validation API

## Set Up:

### Environment variables:

* DB_URL
* DB_USR
* DB_PWD

## Endpoints:

### Get Weather Forecast

* Endpoint: GET /weather-forecast
* Description: Retrieves a list of all weather forecasts.
* Returns: List of WeatherForecastModel objects.
* Success Response: HTTP 200 OK

### Add Weather Forecast

* Endpoint: POST /weather-forecast
* Description: Adds a new weather forecast to the database.
* Request Body: Requires a WeatherForecastModel object.
* Success Response: HTTP 200 OK

### Validation:

* date: Cannot be null.
* temperatureC: Must be between -20 and 55 degrees Celsius.
* Cannot be empty and must not exceed 200 characters.





