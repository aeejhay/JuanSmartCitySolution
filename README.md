# Juan Smart City Solution 🚦🧠  
*A gRPC-Based Simulation of Smart City Services for Distributed Systems*

## 📘 Overview

This project is a simulation of a Smart City ecosystem using **gRPC** and Java. It demonstrates **four types of gRPC communication**—Unary, Server Streaming, Client Streaming, and Bi-Directional Streaming—across **three microservices**, visualized through a desktop GUI.

Built as part of the **Distributed Systems CA_2025** module at NCI.

---

## 🏙 Smart Services

### 1. **Marites** – AI Public Camera Robot
- Prevents crime by using facial recognition and live threat alerts.
- **gRPC Types Used:** Unary, Server Streaming, Client Streaming

### 2. **Juan Tamad** – Smart Traffic Oracle
- Analyzes and broadcasts traffic congestion using real-time and crowdsourced data.
- **gRPC Types Used:** Unary, Server Streaming, Client Streaming

### 3. **Lito Lapis** – Smart GPS Pen for Students
- Monitors and alerts child movement in city centers to prevent abduction.
- **gRPC Types Used:** Unary, Server Streaming, Bi-Directional Streaming

---

## 💡 Technologies Used

- Java 17+
- gRPC & Protocol Buffers
- Maven
- Swing (Java GUI)
- NetBeans IDE 17

---

## 📂 Project Structure

/src ├── distsys.marites 
│ └── MaritesServer.java / MaritesClient.java 
├── distsys.juantamad 
│ └── JuanTamadServer.java / JuanTamadClient.java
├── distsys.litolapis 
│ └── LitoLapisServer.java / LitoLapisClient.java 
├── distsys.juansmartcitysolution 
│ └── JuanSmartCityDashboard.java 
└── /proto 
├── marites.proto 
├── juantamad.proto 
└── litolapis.proto


---

## 🖥 GUI Dashboard

The `JuanSmartCityDashboard` lets users simulate:
- Each service's gRPC methods
- Live results displayed in a single **Results** area
- Real gRPC calls or simulations via buttons per service

---

## 🔧 How to Run

> ⚠️ Requires Java 17+ and Maven.

1. Clone the repository  
   ```bash
   git clone https://github.com/your-username/juan-smart-city-solution.git
   cd juan-smart-city-solution


Adrian Jandongan
Higher Diploma in Science in Computing
National College of Ireland

