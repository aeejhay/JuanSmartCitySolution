/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.discovery;

/**
 *
 * @author ajand
 */

import java.io.IOException;
import java.net.Socket;

/**
 * Utility class to simulate checking if a gRPC service is currently online.
 * It tries to connect to the specified port to see if the service is running.
 */
public class ServiceHealth {

    /**
     * Checks if a service is running by attempting to open a socket on the given port.
     * @param port the gRPC service port to check
     * @return true if the port is open (i.e., service is online), false otherwise
     */
    public static boolean isServiceRunning(int port) {
        try (Socket socket = new Socket("localhost", port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
