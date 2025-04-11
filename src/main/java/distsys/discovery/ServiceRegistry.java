/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package distsys.discovery;
/**
 *
 * @author ajand
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Simulates a static service registry that maps service names to gRPC ports.
 * This is useful for demonstrating how service discovery can work in
 * a distributed system where services are registered and located.
 */
public class ServiceRegistry {

    // Map of service names to their assigned ports
    private static final Map<String, Integer> services = new HashMap<>();

    static {
        services.put("Marites", 50051);
        services.put("Juan Tamad", 50052);
        services.put("Lito Lapis", 50053);
    }

    /**
     * Returns the service registry map.
     * @return a map of service names to ports
     */
    public static Map<String, Integer> getServices() {
        return services;
    }

    /**
     * Gets the port number for a given service.
     * @param serviceName name of the service
     * @return port number, or -1 if not found
     */
    public static int getPort(String serviceName) {
        return services.getOrDefault(serviceName, -1);
    }
}
