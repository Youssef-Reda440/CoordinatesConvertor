# CoordinatesConvertor
CoordinatesConvertor is a JavaFX application that converts points between three coordinate systems: Cartesian, Cylindrical, and Spherical.   You can enter a point in any system, and the application instantly calculates the equivalent values in the other two systems.

---

## 📌 Features
- ✔ Convert **Cartesian → Cylindrical → Spherical** in all directions  
- ✔ Clean JavaFX GUI  
- ✔ Rounded output with 3 decimal places  
- ✔ Error handling for non-numeric input  
- ✔ Reset & Exit functions  
- ✔ Fully modular OOP structure  

---

## 🔧 Technologies Used
- ☕ **Java 17+**
- 🎨 **JavaFX**
- 🧱 **Object-Oriented Programming**
- 🛠 **NetBeans IDE**

---

## 📂 Project Structure

CoordinatesConvertor
├── Cartesian.java
├── Cylendrical.java
├── Spherical.java
└── CoordinatesConvertor.java (JavaFX GUI)

---

## 🚀 How to Run

### ▶ Run using NetBeans
1. Open the project in NetBeans  
2. Make sure JavaFX libraries are configured  
3. Press **Shift + F6** to run

### ▶ Run manually from terminal


---

## 🧮 Conversion Formulas

### **Cartesian → Cylindrical**
- ρ = √(x² + y²)  
- φ = atan2(y, x)

### **Cartesian → Spherical**
- R = √(x² + y² + z²)  
- θ = acos(z / R)

### **Cylindrical → Cartesian**
- x = ρ cos(φ)  
- y = ρ sin(φ)

### **Spherical → Cartesian**
- x = R sin(θ) cos(φ)  
- y = R sin(θ) sin(φ)  
- z = R cos(θ)

---

## 📄 License
This project is open-source. Feel free to use or modify it.
