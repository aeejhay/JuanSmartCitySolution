# Juan Smart City Solution – A gRPC-Based Simulation

## 👨‍💻 About the Project
This project simulates a smart city ecosystem using **gRPC in Java**. It demonstrates **Unary**, **Server Streaming**, **Client Streaming**, and **Bi-Directional Streaming** across three original services:

- **Marites** – AI Public Camera Robot
- **Juan Tamad** – Traffic Oracle
- **Lito Lapis** – Smart GPS Pen for Students

Developed as part of the Distributed Systems module (CA_2025).

---

## 🎯 Project Goals
- Implement real-time communication using gRPC
- Simulate smart services and interactions
- Demonstrate all gRPC RPC types
- Include authentication, discovery, and error handling
- Provide a Java Swing GUI to simulate client usage

---

## 🧠 Smart Services Breakdown
### 🔍 Marites Service (Crime Detection)
- `ScanFace()` – Unary
- `LiveSurveillance()` – Server Streaming
- `ReportSuspiciousActivity()` – Client Streaming

### 🚦 Juan Tamad Service (Traffic Reports)
- `CheckTrafficStatus()` – Unary
- `LiveTrafficReports()` – Server Streaming
- `CrowdsourcedTrafficData()` – Client Streaming

### 📍 Lito Lapis Service (Child Tracking)
- `GetCurrentLocation()` – Unary
- `TrackStudentLive()` – Server Streaming
- `AlertLostStudent()` – Bi-Directional Streaming

---

## 🖥 GUI Dashboard
Built in Java Swing to:
- Launch services and clients
- Show live status (ONLINE/OFFLINE)
- Display logs in output area
- Support log export and clearing

---

## 🔐 Authentication
Implemented via `AuthInterceptor.java` which simulates API key validation using gRPC metadata.

---

## 🌐 Service Discovery
Custom `ServiceRegistry.java` and `ServiceHealth.java` simulate service discovery and availability checks.

---

## 📚 UML Diagrams Included
- ✅ Component Diagram
- ✅ Sequence Diagram
- ✅ Class Diagram
- ✅ Deployment Diagram

All diagrams are in the `/docs/diagrams/` folder (or can be generated from PlantUML scripts).

---

## 📁 Folder Structure
```
├── proto/                  # .proto service definitions
├── src/distsys/...         # All services and GUI code
├── docs/                   # UML Diagrams and Report
├── logs/                   # Exported log files from GUI
├── README.md               # This file
```

---

## 🚀 How to Run
1. Compile `.proto` files using `protoc`
2. Run `JuanSmartCityDashboard.java` in NetBeans or via terminal
3. Click "Run Server" for any service tab
4. Use buttons to simulate gRPC calls

---

## 📄 Final Report
Soon

---

## 🤝 Credits
Adrian Jandongan – Higher Diploma in Computing  
Distributed Systems Module – CA_2025

---

## 📝 License
For educational use only.

