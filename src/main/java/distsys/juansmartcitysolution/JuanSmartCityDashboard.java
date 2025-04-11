/*
 * Juan Smart City Dashboard - with Status-Tagged Tabs for Service Availability
 */
package distsys.juansmartcitysolution;

import distsys.discovery.ServiceHealth;
import distsys.discovery.ServiceRegistry;
import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import java.util.Map;

public class JuanSmartCityDashboard extends JFrame {

    private JTextArea maritesClientOutput;
    private JTextArea juanClientOutput;
    private JTextArea litoClientOutput;
    private JTabbedPane tabs;

    public JuanSmartCityDashboard() {
        setTitle("Juan Smart City Dashboard");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabs = new JTabbedPane();
        tabs.addTab(getServiceTabTitle("Marites"), createServicePanel("Marites"));
        tabs.addTab(getServiceTabTitle("Juan Tamad"), createServicePanel("Juan Tamad"));
        tabs.addTab(getServiceTabTitle("Lito Lapis"), createServicePanel("Lito Lapis"));

        add(tabs);
    }

    private String getServiceTabTitle(String serviceName) {
        int port = ServiceRegistry.getPort(serviceName);
        boolean isOnline = ServiceHealth.isServiceRunning(port);
        return serviceName + (isOnline ? " (ONLINE)" : " (OFFLINE)");
    }

    private JPanel createServicePanel(String serviceName) {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(2, 5, 10, 10));

        JTextArea clientArea = new JTextArea(15, 80);
        clientArea.setEditable(false);
        JScrollPane clientScroll = new JScrollPane(clientArea);

        JButton discoverBtn = new JButton("🔍 Discover Service");
        discoverBtn.addActionListener(e -> {
            int port = ServiceRegistry.getPort(serviceName);
            boolean status = ServiceHealth.isServiceRunning(port);
            String statusLabel = status ? "✅ ONLINE" : "❌ OFFLINE";
            JOptionPane.showMessageDialog(panel,
                    serviceName + " Service\nPort: " + port + "\nStatus: " + statusLabel,
                    "Service Discovery",
                    JOptionPane.INFORMATION_MESSAGE);
            updateTabStatus();
        });

        JButton exportBtn = new JButton("💾 Export Log");
        exportBtn.addActionListener(e -> exportLog(clientArea, serviceName));

        JButton clearBtn = new JButton("❌ Clear Results");
        clearBtn.addActionListener(e -> clientArea.setText(""));

        JButton runServerBtn = new JButton("▶ Run Server");
        runServerBtn.addActionListener(e -> {
            runServer(serviceName);
            clientArea.append("[INFO] " + serviceName + " server running...\n");
            updateTabStatus();
        });

        if (serviceName.equals("Marites")) {
            JButton scanFace = new JButton("Scan Face (Unary)");
            JButton surveillance = new JButton("Live Surveillance (Server Streaming)");
            JButton report = new JButton("Report Suspicious (Client Streaming)");

            scanFace.addActionListener(e -> tryRunSim(serviceName, "MaritesServer", "MaritesClient", clientArea, "[Unary] Scanned face..."));
            surveillance.addActionListener(e -> tryRunSim(serviceName, "MaritesServer", "MaritesClient", clientArea, "[Server Streaming] Surveillance in progress..."));
            report.addActionListener(e -> tryRunSim(serviceName, "MaritesServer", "MaritesClient", clientArea, "[Client Streaming] Suspicious data sent..."));

            buttonPanel.add(scanFace);
            buttonPanel.add(surveillance);
            buttonPanel.add(report);
            buttonPanel.add(discoverBtn);
            buttonPanel.add(exportBtn);
            buttonPanel.add(clearBtn);
            buttonPanel.add(runServerBtn);
            maritesClientOutput = clientArea;
        }

        if (serviceName.equals("Juan Tamad")) {
            JButton check = new JButton("Check Traffic Status (Unary)");
            JButton live = new JButton("Live Traffic Reports (Server Streaming)");
            JButton crowd = new JButton("Crowdsourced Traffic Data (Client Streaming)");

            check.addActionListener(e -> tryRunSim(serviceName, "JuanTamadServer", "JuanTamadClient", clientArea, "[Unary] Traffic checked: MODERATE"));
            live.addActionListener(e -> tryRunSim(serviceName, "JuanTamadServer", "JuanTamadClient", clientArea, "[Server Streaming] Streaming traffic reports..."));
            crowd.addActionListener(e -> tryRunSim(serviceName, "JuanTamadServer", "JuanTamadClient", clientArea, "[Client Streaming] User data submitted."));

            buttonPanel.add(check);
            buttonPanel.add(live);
            buttonPanel.add(crowd);
            buttonPanel.add(discoverBtn);
            buttonPanel.add(exportBtn);
            buttonPanel.add(clearBtn);
            buttonPanel.add(runServerBtn);
            juanClientOutput = clientArea;
        }

        if (serviceName.equals("Lito Lapis")) {
            JButton locate = new JButton("Get Current Location (Unary)");
            JButton track = new JButton("Track Student Live (Server Streaming)");
            JButton alert = new JButton("Alert Student Lost (Bi-Directional)");

            locate.addActionListener(e -> tryRunSim(serviceName, "LitoLapisServer", "LitoLapisClient", clientArea, "[Unary] GPS acquired: 14.5995, 120.9842"));
            track.addActionListener(e -> tryRunSim(serviceName, "LitoLapisServer", "LitoLapisClient", clientArea, "[Server Streaming] Tracking in progress..."));
            alert.addActionListener(e -> tryRunSim(serviceName, "LitoLapisServer", "LitoLapisClient", clientArea, "[Bi-Directional] Lost alert triggered."));

            buttonPanel.add(locate);
            buttonPanel.add(track);
            buttonPanel.add(alert);
            buttonPanel.add(discoverBtn);
            buttonPanel.add(exportBtn);
            buttonPanel.add(clearBtn);
            buttonPanel.add(runServerBtn);
            litoClientOutput = clientArea;
        }

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(labeledScrollPane("Results", clientScroll), BorderLayout.CENTER);

        return panel;
    }

    private void updateTabStatus() {
        tabs.setTitleAt(0, getServiceTabTitle("Marites"));
        tabs.setTitleAt(1, getServiceTabTitle("Juan Tamad"));
        tabs.setTitleAt(2, getServiceTabTitle("Lito Lapis"));
    }

    private void tryRunSim(String serviceName, String serverClass, String clientClass, JTextArea clientOut, String simulatedOutput) {
        int port = ServiceRegistry.getPort(serviceName);
        if (!ServiceHealth.isServiceRunning(port)) {
            clientOut.append("[WARNING] Please run the " + serviceName + " server before accessing this method.\n");
        } else {
            runSim(serverClass, clientClass, clientOut, simulatedOutput);
        }
    }

    private JPanel labeledScrollPane(String label, JScrollPane scrollPane) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(label), BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void runSim(String serverClass, String clientClass, JTextArea clientOut, String simulatedOutput) {
        PrintStream clientStream = new PrintStream(new CustomOutputStream(clientOut));

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

        clientOut.append(simulatedOutput + "\n");
    }

    private void runServer(String serviceName) {
        new Thread(() -> {
            try {
                switch (serviceName) {
                    case "Marites":
                        distsys.juansmartcitysolution.MaritesServer.main(new String[]{});
                        break;
                    case "Juan Tamad":
                        distsys.juansmartcitysolution.JuanTamadServer.main(new String[]{});
                        break;
                    case "Lito Lapis":
                        distsys.juansmartcitysolution.LitoLapisServer.main(new String[]{});
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error starting server: " + e.getMessage());
            }
        }).start();
    }

    private void exportLog(JTextArea area, String serviceName) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new java.io.File(serviceName.toLowerCase() + "_log.txt"));
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try (java.io.PrintWriter out = new java.io.PrintWriter(fileChooser.getSelectedFile())) {
                out.println(area.getText());
                JOptionPane.showMessageDialog(this, "Log saved successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Failed to save log: " + ex.getMessage());
            }
        }
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
