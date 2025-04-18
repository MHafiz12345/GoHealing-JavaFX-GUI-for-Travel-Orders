<img width="570" alt="Assignment_2-1" src="https://github.com/user-attachments/assets/9f26dad9-9b6c-4294-be29-1a646f76a480" />

# 🚗 GoHealing JavaFX Application

A JavaFX-based desktop application designed to simulate a travel and rental booking system. It allows users to place orders for transportation and accommodations, calculates total costs, and applies relevant discounts. The goal is to provide a simple and interactive UI to understand object-oriented principles and GUI development with JavaFX.

## ✨ Features

- Place orders for:
  - ✈️ Plane Tickets
  - 🚆 Train Tickets
  - 🏨 Hotel Room Rentals
  - 🚘 Car Rentals
- View the **total cost** of all orders, including discounts
- Get a detailed breakdown of each order's type, transaction cost, and discount applied
- JavaFX-powered GUI with a clean and minimal layout

## 🧠 How It Works

### 🧩 Architecture

The system is composed of several key components:

- **GoHealingUser**: Stores the list of orders made by the user
- **Order (Abstract)**: Base class for all order types
- **Travel & Rental**: Abstract subclasses that separate logic based on travel (Plane/Train) and rental (Hotel/Car)
- **CalculateTotalWindow**: Displays the full transaction summary in a new window
- **PlaceOrderWindow**: UI to select and create a new order
- **GoHealingApplication**: Entry point and main UI to navigate features

### 🔁 Application Flow

1. **Launch App** → Home window with two main buttons: `Place Order` and `Calculate Total`
2. **Place Order**:
   - Choose an order type
   - Fill in distance (for travel) or number of days (for rental)
   - Submit to add order to user history
3. **Calculate Total**:
   - Opens a new window
   - Displays total amount (after discounts)
   - Shows each order's transaction and discount breakdown

## 🖥️ Sample UI

![image](https://github.com/user-attachments/assets/401d7efc-b345-4f02-a49a-68c702af92d0)


After placing orders:

![image](https://github.com/user-attachments/assets/d1c7a6ae-ed27-42dc-8a7d-7b8faff8cc6b)


## 💸 Discount Rules

| Order Type         | Rule                                           |
|--------------------|------------------------------------------------|
| **TrainTicket**    | 10% discount if distance < 100 km              |
| **CarRental**      | 15% discount if rented between 3 and 7 days    |
| **HotelRoomRental**| 5% per 10-day stay, max 30% total discount     |
| **PlaneTicket**    | No discount                                    |

## 📁 File Structure

```
GoHealing/
│
├── GoHealingApplication.java  # Main launcher
├── GoHealingUser.java         # Stores user and orders
├── PlaceOrderWindow.java      # Order creation UI
├── CalculateTotalWindow.java  # Summary UI
│
├── Order.java                 # Abstract base for all orders
│
├── Travel.java                # Abstract for travel (Plane, Train)
│ ├── PlaneTicket.java
│ └── TrainTicket.java
│
├── Rental.java                # Abstract for rentals (Hotel, Car)
│ ├── HotelRoomRental.java
│ └── CarRental.java
│
└── Discount.java              # Interface for discount calculation
```

## ▶️ Getting Started

### ✅ Requirements

- Java 8+
- JavaFX SDK installed

### 🔧 Build & Run

1. Clone the repository:
```bash
git clone https://github.com/yourusername/gohealing-javafx.git
cd gohealing-javafx
```

2. Compile and run:
```bash
# Using terminal:
javac *.java
java GoHealingApplication
```

Or import into any Java IDE (like IntelliJ IDEA or Eclipse) and run GoHealingApplication.

## 📌 Notes

- No external libraries are used. All UI is built using native JavaFX.
- Order IDs are auto-generated using UUID to ensure uniqueness.
