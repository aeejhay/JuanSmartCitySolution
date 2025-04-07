/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.juansmartcitysolution;

/**
 *
 * @author ajand
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.PrintStream;

public class JuanSmartCityDashboard extends JFrame {

    private JTextArea maritesServerOutput, maritesClientOutput;
    private JTextArea juanServerOutput, juanClientOutput;
    private JTextArea litoServerOutput, litoClientOutput;

    public JuanSmartCityDashboard() {
        setTitle("Juan Smart City Dashboard");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Marites", createServicePanel("Marites"));
        tabs.add("Juan Tamad", createServicePanel("Juan Tamad"));
        tabs.add("Lito Lapis", createServicePanel("Lito Lapis"));

        add(tabs);
    }

    private JPanel createServicePanel(String serviceName) {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        JTextArea serverArea = new JTextArea(10, 40);
        JTextArea clientArea = new JTextArea(10, 40);
        serverArea.setEditable(false);
        clientArea.setEditable(false);

        JScrollPane serverScroll = new JScrollPane(serverArea);
        JScrollPane clientScroll = new JScrollPane(clientArea);

        if (serviceName.equals("Marites")) {
            JButton scanFace = new JButton("Scan Face (Unary)");
            JButton surveillance = new JButton("Live Surveillance (Server Streaming)");
            JButton report = new JButton("Report Suspicious Activity (Client Streaming)");

            scanFace.addActionListener(e -> runSim("MaritesServer", "MaritesClient", serverArea, clientArea, "[Unary] Scanned face..."));
            surveillance.addActionListener(e -> runSim("MaritesServer", "MaritesClient", serverArea, clientArea, "[Server Streaming] Surveillance in progress..."));
            report.addActionListener(e -> runSim("MaritesServer", "MaritesClient", serverArea, clientArea, "[Client Streaming] Suspicious data sent..."));

            buttonPanel.add(scanFace);
            buttonPanel.add(surveillance);
            buttonPanel.add(report);
            maritesServerOutput = serverArea;
            maritesClientOutput = clientArea;
        }

        if (serviceName.equals("Juan Tamad")) {
            JButton check = new JButton("Check Traffic Status (Unary)");
            JButton live = new JButton("Live Traffic Reports (Server Streaming)");
            JButton crowd = new JButton("Crowdsourced Traffic Data (Client Streaming)");

            check.addActionListener(e -> runSim("JuanTamadServer", "JuanTamadClient", serverArea, clientArea, "[Unary] Traffic checked: MODERATE"));
            live.addActionListener(e -> runSim("JuanTamadServer", "JuanTamadClient", serverArea, clientArea, "[Server Streaming] Streaming traffic reports..."));
            crowd.addActionListener(e -> runSim("JuanTamadServer", "JuanTamadClient", serverArea, clientArea, "[Client Streaming] User data submitted."));

            buttonPanel.add(check);
            buttonPanel.add(live);
            buttonPanel.add(crowd);
            juanServerOutput = serverArea;
            juanClientOutput = clientArea;
        }

        if (serviceName.equals("Lito Lapis")) {
            JButton locate = new JButton("Get Current Location (Unary)");
            JButton track = new JButton("Track Student Live (Server Streaming)");
            JButton alert = new JButton("Alert Student Lost (Bi-Directional)");

            locate.addActionListener(e -> runSim("LitoLapisServer", "LitoLapisClient", serverArea, clientArea, "[Unary] GPS acquired: 14.5995, 120.9842"));
            track.addActionListener(e -> runSim("LitoLapisServer", "LitoLapisClient", serverArea, clientArea, "[Server Streaming] Tracking in progress..."));
            alert.addActionListener(e -> runSim("LitoLapisServer", "LitoLapisClient", serverArea, clientArea, "[Bi-Directional] Lost alert triggered."));

            buttonPanel.add(locate);
            buttonPanel.add(track);
            buttonPanel.add(alert);
            litoServerOutput = serverArea;
            litoClientOutput = clientArea;
        }

        JPanel outputPanel = new JPanel(new GridLayout(2, 1));
        //outputPanel.add(labeledScrollPane("Server Output", serverScroll));
        outputPanel.add(labeledScrollPane("Results", clientScroll));

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(outputPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel labeledScrollPane(String label, JScrollPane scrollPane) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(label), BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void runSim(String serverClass, String clientClass, JTextArea serverOut, JTextArea clientOut, String simulatedOutput) {
        PrintStream serverStream = new PrintStream(new CustomOutputStream(serverOut));
        PrintStream clientStream = new PrintStream(new CustomOutputStream(clientOut));

        new Thread(() -> {
            System.setOut(serverStream);
            try {
                switch (serverClass) {
                    case "MaritesServer":
                        distsys.juansmartcitysolution.MaritesServer.main(new String[]{});
                        break;
                    case "JuanTamadServer":
                        distsys.juansmartcitysolution.JuanTamadServer.main(new String[]{});
                        break;
                    case "LitoLapisServer":
                        distsys.juansmartcitysolution.LitoLapisServer.main(new String[]{});
                        break;
                }
            } catch (Exception ex) {
                serverOut.append("Error: " + ex.getMessage() + "\n");
            }
        }).start();

        new Thread(() -> {
            System.setOut(clientStream);
            try {
                switch (clientClass) {
                    case "MaritesClient":
                        distsys.juansmartcitysolution.MaritesClient.main(new String[]{});
                        break;
                    case "JuanTamadClient":
                        distsys.juansmartcitysolution.JuanTamadClient.main(new String[]{});
                        break;
                    case "LitoLapisClient":
                        distsys.juansmartcitysolution.LitoLapisClient.main(new String[]{});
                        break;
                }
            } catch (Exception ex) {
                clientOut.append("Error: " + ex.getMessage() + "\n");
            }
        }).start();

        // Simulated result
        clientOut.append(simulatedOutput + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JuanSmartCityDashboard().setVisible(true));
    }
}

class CustomOutputStream extends java.io.OutputStream {
    private final JTextArea textArea;

    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        textArea.append(String.valueOf((char) b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
} 
