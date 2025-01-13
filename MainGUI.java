import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class MainGUI extends JFrame {
    private List<Orang> clients = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private List<Vendor> vendors = new ArrayList<>();
    private float totalBiaya = 0;

    // UI Components
    private JPanel mainPanel;
    private JTable clientTable;
    private JTable eventTable;
    private JTable vendorTable;
    private DefaultTableModel clientModel;
    private DefaultTableModel eventModel;
    private DefaultTableModel vendorModel;
    private JTextField searchField;
    private JLabel statusLabel;
    private Color primaryColor = new Color(51, 153, 255);
    private Color accentColor = new Color(245, 245, 245);

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            MainGUI frame = new MainGUI();
            frame.setVisible(true);
        });
    }

    public MainGUI() {
        setTitle("Sistem Manajemen Acara");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
        setupLayout();
        setupStyles();
    }

    private void initializeComponents() {
        // Initialize main panel with modern border
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Create modern toolbar
        JToolBar toolBar = createStyledToolBar();
        mainPanel.add(toolBar, BorderLayout.NORTH);

        // Create tabbed pane for main content
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Initialize tables
        setupTables();

        // Add tabs with scroll panes
        tabbedPane.addTab("Klien", createClientPanel());
        tabbedPane.addTab("Acara", createEventPanel());
        tabbedPane.addTab("Vendor", createVendorPanel());
        tabbedPane.addTab("Ringkasan", createSummaryPanel());

        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        // Status bar
        statusLabel = new JLabel(" Status: Siap");
        statusLabel.setBorder(new EmptyBorder(5, 10, 5, 10));
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        mainPanel.add(statusLabel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JToolBar createStyledToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBackground(primaryColor);
        toolBar.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Search field with modern look
        searchField = new JTextField(20);
        searchField.setMaximumSize(new Dimension(200, 30));
        searchField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(4, 4, 4, 4)
        ));

        JButton refreshButton = createStyledButton("Refresh");
        JButton settingsButton = createStyledButton("Pengaturan");
        JButton helpButton = createStyledButton("Bantuan");

        JLabel searchLabel = new JLabel("Cari: ");
        searchLabel.setForeground(Color.BLACK);

        toolBar.add(searchLabel);
        toolBar.add(searchField);
        toolBar.add(Box.createHorizontalStrut(20));
        toolBar.add(refreshButton);
        toolBar.add(settingsButton);
        toolBar.add(helpButton);

        return toolBar;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLACK);
        button.setBackground(primaryColor);
        button.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 15, 5, 15)
        ));
        button.setFocusPainted(false);
        return button;
    }

    private void setupTables() {
        // Client table
        String[] clientColumns = {"ID", "Nama", "Kontak", "Status"};
        clientModel = new DefaultTableModel(clientColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        clientTable = new JTable(clientModel);
        styleTable(clientTable);

        // Event table
        String[] eventColumns = {"ID", "Nama Acara", "Tanggal", "Lokasi", "Jenis", "Status"};
        eventModel = new DefaultTableModel(eventColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        eventTable = new JTable(eventModel);
        styleTable(eventTable);

        // Vendor table
        String[] vendorColumns = {"ID", "Nama", "Layanan", "Status"};
        vendorModel = new DefaultTableModel(vendorColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        vendorTable = new JTable(vendorModel);
        styleTable(vendorTable);
    }

    private void styleTable(JTable table) {
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(25);
        table.setIntercellSpacing(new Dimension(10, 5));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(primaryColor);
        table.getTableHeader().setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(232, 242, 254));
        table.setSelectionForeground(Color.BLACK);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private JPanel createClientPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = createActionButton("Tambah Klien", "add");
        JButton deleteButton = createActionButton("Hapus Klien", "delete");

        addButton.addActionListener(e -> clientModel.addRow(new Object[]{"", "", "", ""}));
        deleteButton.addActionListener(e -> {
            int selectedRow = clientTable.getSelectedRow();
            if (selectedRow != -1) clientModel.removeRow(selectedRow);
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(clientTable), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createEventPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = createActionButton("Tambah Acara", "add");
        JButton deleteButton = createActionButton("Hapus Acara", "delete");

        addButton.addActionListener(e -> eventModel.addRow(new Object[]{"", "", "", "", "", ""}));
        deleteButton.addActionListener(e -> {
            int selectedRow = eventTable.getSelectedRow();
            if (selectedRow != -1) eventModel.removeRow(selectedRow);
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(eventTable), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createVendorPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = createActionButton("Tambah Vendor", "add");
        JButton deleteButton = createActionButton("Hapus Vendor", "delete");

        addButton.addActionListener(e -> vendorModel.addRow(new Object[]{"", "", "", ""}));
        deleteButton.addActionListener(e -> {
            int selectedRow = vendorTable.getSelectedRow();
            if (selectedRow != -1) vendorModel.removeRow(selectedRow);
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(vendorTable), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createSummaryPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextArea summaryArea = new JTextArea();
        summaryArea.setEditable(false);
        summaryArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        summaryArea.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton calculateButton = createActionButton("Hitung Ringkasan", "calculate");
        calculateButton.addActionListener(e -> hitungRingkasanBiaya(summaryArea));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(calculateButton);

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(summaryArea), BorderLayout.CENTER);

        return panel;
    }

    private JButton createActionButton(String text, String action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(primaryColor),
                new EmptyBorder(5, 15, 5, 15)
        ));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(primaryColor);
                button.setForeground(Color.BLACK);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
            }
        });

        return button;
    }

    private void hitungRingkasanBiaya(JTextArea summaryArea) {
        StringBuilder summary = new StringBuilder();
        totalBiaya = 0;

        // Loop untuk menghitung biaya acara dan menampilkan nama klien
        for (int i = 0; i < eventModel.getRowCount(); i++) {
            String namaAcara = (String) eventModel.getValueAt(i, 1);
            String namaKlien = (String) clientModel.getValueAt(i, 1); // Mengambil nama klien berdasarkan baris yang sama
            float biaya = (float) Math.random() * 1000; // Contoh biaya acak
            totalBiaya += biaya;

            // Menambahkan nama klien dan biaya acara ke dalam ringkasan
            summary.append("Klien: ").append(namaKlien).append(" | Acara: ").append(namaAcara).append(" | Biaya: Rp ").append(biaya).append("\n");
        }

        summary.append("\nTotal Biaya Keseluruhan: Rp ").append(totalBiaya);
        summaryArea.setText(summary.toString());
    }

    private void setupStyles() {
        UIManager.put("Panel.background", Color.WHITE);
        UIManager.put("TabbedPane.selected", accentColor);
        UIManager.put("TabbedPane.background", Color.WHITE);
        UIManager.put("TabbedPane.focus", primaryColor);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        add(mainPanel);
    }
}
