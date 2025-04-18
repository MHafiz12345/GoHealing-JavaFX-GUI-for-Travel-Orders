# GoHealing - Travel and Accommodation Booking Application

## Overview
GoHealing is a JavaFX-based application for booking travel tickets, hotel rooms, and rental cars. The application provides a simple interface for users to place orders for various services and calculate the total cost including applicable discounts.

## Features
- Book plane tickets, train tickets, hotel rooms, and rental cars
- Automatic discount calculations based on business rules
- Order history tracking
- Total cost calculation with Indonesian currency format (Rupiah)
- Clean and intuitive user interface

## Application Structure

### Class Hierarchy
```
                  ┌─────────┐
                  │  Order  │◄───────────┐
                  └────┬────┘            │
                       │                 │
           ┌───────────┴────────────┐    │
           ▼                        ▼    │ implements
    ┌────────────┐            ┌─────────┐│
    │   Travel   │            │  Rental │├─────────┐
    └─────┬──────┘            └────┬────┘         │
          │                        │              │
    ┌─────┴──────┐            ┌────┴─────┐    ┌───┴─────┐
    ▼            ▼            ▼          ▼    │ Discount │
┌──────────┐ ┌─────────┐ ┌─────────┐ ┌───────┐└─────────┘
│PlaneTicket│ │TrainTicket│ │HotelRoom│ │CarRental│
└──────────┘ └─────────┘ └─────────┘ └───────┘
```

### Main Components
- **GoHealingApplication**: Main application class with the primary UI
- **GoHealingUser**: Manages user data and order list
- **PlaceOrderWindow**: UI for creating new orders
- **CalculateTotalWindow**: UI for displaying order summary and totals

## Business Logic

### Order Types
1. **PlaneTicket**
   - Cost: 4,000 Rupiah per kilometer
   - No discount

2. **TrainTicket**
   - Cost: 750 Rupiah per kilometer
   - 10% discount for distances less than 100 km

3. **HotelRoomRental**
   - Cost: 1,500,000 Rupiah per day
   - 5% discount for each 10-day period (max 30%)

4. **CarRental**
   - Cost: 500,000 Rupiah per day
   - 15% discount for rentals between 3-7 days

## Usage Flow

1. **Launch Application**
   - The main screen displays two buttons: "Place Order" and "Calculate Total"

2. **Place Order**
   - Click "Place Order" to open order creation window
   - Select order type (plane, train, hotel, car)
   - Enter required details (distance or number of days)
   - Click "Place Order" to add to cart

3. **Calculate Total**
   - Click "Calculate Total" to view all orders
   - See breakdown of each order with discounts
   - View total amount in Indonesian Rupiah format

## Implementation Details

### Key Design Patterns
- **Inheritance**: Order hierarchy with specialized subclasses
- **Interface**: Discount interface implemented by Order class
- **Composition**: GoHealingUser contains a list of Order objects

### Discount Calculation
Each order type implements its own discount calculation logic:
- Plane tickets have no discount
- Train tickets offer 10% off for short distances
- Hotel rooms provide increasing discounts for longer stays
- Car rentals have a special discount for medium-length rentals

## Technical Requirements
- Java 8 or higher
- JavaFX library
- JVM-compatible operating system (Windows, macOS, Linux)

## Getting Started
1. Clone the repository
2. Ensure JavaFX is properly set up in your development environment
3. Compile and run the GoHealingApplication class
4. Start placing orders and calculate totals

