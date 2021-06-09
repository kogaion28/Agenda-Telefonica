package agendatelefonica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class Form extends javax.swing.JFrame {
//conectare la baza de date
    private Connection con = null;
    private PersonModel model = null;
    
    private String database = "agendatelefonica";
    private String tableName = database + ".tabel";
    private String mysql_password = "";

    public Form() {
        initComponents();

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = d.width/2 - this.getWidth()/2,
            y = d.height/2 - this.getHeight()/2;
        setLocation(x, y);

        scrollPane.getViewport().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
//cod generat de design
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        settingPanel = new javax.swing.JPanel();
        slider = new javax.swing.JSlider();
        infoPanel = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        City = new javax.swing.JTextField();
        Phone = new javax.swing.JTextField();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        Insert = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        label4 = new javax.swing.JLabel();
        fieldName = new javax.swing.JComboBox();
        value = new javax.swing.JTextField();
        tablePanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        Backup = new javax.swing.JButton();
        DeleteAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda telefonica");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        settingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        slider.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        slider.setOrientation(javax.swing.JSlider.VERTICAL);
        slider.setValue(20);
        slider.setNextFocusableComponent(Name);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout settingPanelLayout = new javax.swing.GroupLayout(settingPanel);
        settingPanel.setLayout(settingPanelLayout);
        settingPanelLayout.setHorizontalGroup(
            settingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        settingPanelLayout.setVerticalGroup(
            settingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
        );

        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inserare", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        label1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(153, 0, 51));
        label1.setText("Nume:");

        Name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        City.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Phone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        label2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        label2.setForeground(new java.awt.Color(204, 204, 0));
        label2.setText("Telefon :");

        label3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(0, 153, 0));
        label3.setText("Oras:");

        Insert.setBackground(new java.awt.Color(0, 0, 204));
        Insert.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Insert.setForeground(new java.awt.Color(0, 153, 51));
        Insert.setText("Inserare");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });

        Reset.setBackground(new java.awt.Color(153, 0, 0));
        Reset.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Reset.setForeground(new java.awt.Color(0, 0, 153));
        Reset.setText("Stergere");
        Reset.setNextFocusableComponent(fieldName);
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Name))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(City))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Phone))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2)
                    .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cauta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        label4.setBackground(new java.awt.Color(255, 255, 255));
        label4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        label4.setForeground(new java.awt.Color(0, 0, 153));
        label4.setText("Dupa:");

        fieldName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fieldName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nume", "oras", "telefon" }));
        fieldName.setNextFocusableComponent(value);

        value.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        value.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valueKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(value)
                    .addComponent(fieldName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label4)
                    .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(value, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Baza de date", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        dataTable.setBackground(new java.awt.Color(153, 153, 255));
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        dataTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        dataTable.setGridColor(new java.awt.Color(204, 204, 204));
        dataTable.setRowHeight(20);
        dataTable.setSelectionBackground(new java.awt.Color(102, 182, 250));
        dataTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dataTable.getTableHeader().setReorderingAllowed(false);
        dataTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dataTableKeyReleased(evt);
            }
        });
        scrollPane.setViewportView(dataTable);

        Backup.setBackground(new java.awt.Color(0, 102, 51));
        Backup.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Backup.setForeground(new java.awt.Color(255, 255, 255));
        Backup.setText("salvare externa");
        Backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackupActionPerformed(evt);
            }
        });

        DeleteAll.setBackground(new java.awt.Color(153, 0, 0));
        DeleteAll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        DeleteAll.setForeground(new java.awt.Color(102, 102, 255));
        DeleteAll.setText("Stergere tot");
        DeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addGroup(tablePanelLayout.createSequentialGroup()
                        .addComponent(Backup, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Backup, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(settingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(infoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        for(Component comp : this.infoPanel.getComponents())
            if(comp instanceof JTextField)
                ((JTextField)comp).setText("");
    }//GEN-LAST:event_ResetActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
            // cauta jdbc driver pt mysql
            Class.forName("com.mysql.jdbc.Driver");
            // creiaza conecsiunea cu mysql
            String url   = "jdbc:mysql://localhost/",
                   uname = "root",
                   upass = mysql_password;

            con = DriverManager.getConnection(url, uname, upass);

            createDatabase();
            createTable();
            Vector data = getData("");
            showData(data);
            //sseteaza baza de date
            con.setCatalog(database);

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage() + "\nNu ma pot conecta la mysql!");
            this.dispose();
        }
    }//GEN-LAST:event_formWindowOpened
//inserare date + erori
    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        try{
            if(isEmpty())
                throw new Exception("Introdu toate datele!");

            // if phone is frequency dont insert
            if(isExitsPhone())
                throw new Exception("Eroare nr telefon!");

            boolean ok = insert();
            if(ok){
                Vector data = getData("");
                showData(data);
            } else
                throw new Exception("Eroare la inserare!");

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_InsertActionPerformed

    private void dataTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataTableKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_DELETE)
            return;
        
        JTable table = (JTable)evt.getSource();

        int row = table.getSelectedRow();
        if(row < 0)
            return;
        Object phone = table.getValueAt(row, 2);
        
        if(cb_shwDlg.isSelected()){
            int option = JOptionPane.showConfirmDialog(this, "Vrei sa stergi data?", 
                    "sterge", JOptionPane.YES_NO_CANCEL_OPTION);
            if(option != JOptionPane.YES_OPTION)
                return;
        }

        try{
            boolean ok = delete(phone);
            if(ok){
                Vector data = getData("");
                showData(data);
            } else
                throw new Exception("O eroare o aparut la stergere!");

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_dataTableKeyReleased

    private void valueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valueKeyReleased
        String text = value.getText().trim();
        try{
            String where = "";
            if(!text.equals(""))
                where = " WHERE " + fieldName.getSelectedItem() + " LIKE '" + text + "%'";
            Vector data = getData(where);
            showData(data);
        }catch(Exception e){
        }
    }//GEN-LAST:event_valueKeyReleased

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        int height = ((JSlider)evt.getSource()).getValue() + 1;
        dataTable.setRowHeight(height);
    }//GEN-LAST:event_sliderStateChanged
//sterge actiunea
    private void DeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAllActionPerformed
        try{
            int row = deleteall();
            Vector data = getData("");
            showData(data);
            throw new Exception(row + " row(s) deleted!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}//GEN-LAST:event_DeleteAllActionPerformed
//salvare date in  fisier sql
    private void BackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackupActionPerformed
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("salvare.sql"));
            Vector allData = getData("");

            for(int row = 0; row < allData.size(); ++row){
                Person data = (Person)allData.elementAt(row);

                String sql = "insert into " + tableName + " values ('" + data.getName() + "' , '" +
                             data.getCity() + "' , '" + data.getPhone() + "');";
                writer.write(sql);
                writer.newLine();
            }
            writer.close();
            JOptionPane.showMessageDialog(this, "Salvare cu succes!" , "salvare", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "O eroare la salvarea fisierului!" , "formWindowOpened", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_BackupActionPerformed
    private boolean isEmpty(){        
        Component[] comps = infoPanel.getComponents();        
        for(int i = 0; i < comps.length; ++i){
            Component comp = comps[i];
            if(comp instanceof JTextField){
                JTextField field = (JTextField)comp;
                if(field.getText().equals(""))
                    return true;
            }
        }
        return false;
    }
    // baza de date daca exista
    private void createDatabase() throws Exception{
        Statement stm = this.con.createStatement();
        stm.execute("CREATE DATABASE IF NOT EXISTS " + database +
                " DEFAULT CHARACTER SET utf8 COLLATE utf8_persian_ci");
    }
//tabel la baza de date
    private void createTable() throws Exception{
        Statement stm = this.con.createStatement();

        String query = "CREATE TABLE IF NOT EXISTS "     + tableName +
                        "(name VARCHAR( 15 )  CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL ," +
                        " city VARCHAR( 15 )  CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL ," +
                        " phone VARCHAR( 15 ) NOT NULL, " +
                        "PRIMARY KEY (phone) )";
        stm.execute(query);
    }
//insereaza in baza de date
    private boolean insert()throws Exception{
        String query = "INSERT INTO " + tableName + " VALUES(?, ?, ?)";
        PreparedStatement pstm = this.con.prepareStatement(query);

        pstm.setObject(1, Name.getText().trim());
        pstm.setObject(2, City.getText().trim());
        pstm.setObject(3, Phone.getText().trim());

        int result = pstm.executeUpdate();

        return (result > 0);
    }
//actualizeaz in baza de date cand modificam ceva
    private boolean update(Object[] data)throws Exception{
        String query = "UPDATE " + tableName + " SET name=?, city=? WHERE phone=?";
        PreparedStatement pstm = con.prepareStatement(query);
        
        pstm.setObject(1, data[0]);
        pstm.setObject(2, data[1]);
        pstm.setObject(3, data[2]);

        int result = pstm.executeUpdate();

        return (result > 0);
    }
//daca exita data de telefon 
    private boolean isExitsPhone() throws Exception{
        String query = "SELECT COUNT(*) FROM " + tableName + " WHERE phone=?";
        PreparedStatement pstm = this.con.prepareStatement(query);
        pstm.setObject(1, Phone.getText());

        ResultSet result = pstm.executeQuery();

        result.next();
        return (result.getInt(1) > 0);
    }
//sterge date de la baza date 
    private boolean delete(Object data)throws Exception{
        String query = "DELETE FROM " + tableName + " WHERE phone=?";
        PreparedStatement pstm = this.con.prepareStatement(query);
        pstm.setObject(1, data);

        int result = pstm.executeUpdate();
        return (result > 0);
    }

    private int deleteall()throws Exception{
        Statement stm = con.createStatement();
        int result = stm.executeUpdate("DELETE FROM " + tableName );
        return result;
    }
// ia date de la baza de date pentru afisare 
    private Vector getData(String where) throws Exception{
        Vector info = new Vector();

        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery("SELECT * FROM " + tableName + where);

        while(result.next()){
            String name  = result.getObject("name").toString(),
                   city  = result.getObject("city").toString(),
                   phone = result.getObject("phone").toString();

            info.addElement(new Person(name, city, phone));
        }
        return info;
    }
//tabelul de artat data
    private void showData(Vector data) throws Exception{
        model = new PersonModel(data);
        dataTable.setModel(model);
        
        int[] width = {
          80, 80, 120  
        };
        int count = dataTable.getColumnModel().getColumnCount();
        for(int i = 0; i < count; ++i){
            dataTable.getColumnModel().getColumn(i).setMinWidth(width[i]);
            dataTable.getColumnModel().getColumn(i).setMaxWidth(width[i] + 20);
        }
        // seteaza coloana telefon background
        TableColumn phoneColumn = dataTable.getColumnModel().getColumn(2);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBackground(new Color(245, 245, 245));
        phoneColumn.setCellRenderer(renderer);
    }
    
    public static void main(String args[]) {
        try{
            for(UIManager.LookAndFeelInfo laf  : UIManager.getInstalledLookAndFeels()){
                //Metal , Nimbus, CDE/Motif, Windows, Windows Classic
                if(laf.getName().equals("Nimbus"))
                    UIManager.setLookAndFeel(laf.getClassName());
                //System.out.println(laf.getName());
            }
        }catch(Exception e){            
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Form().setVisible(true);
            }
        });
    }
    //tabelul oras din aplicatie 
    private class PersonModel extends AbstractTableModel{
        
        private Vector<Person> items;
        private String[] columns = {
            "Nume","Oras","Telefon"
        };        
        public static final int NAME  = 0;
        public static final int CITY  = 1;
        public static final int PHONE = 2;
        
        public PersonModel(Vector items) {
            this.items = items;
        }
        
        @Override public int getRowCount() {
            return (items == null ? 0 : items.size());
        }
        @Override public int getColumnCount() {
            return columns.length;
        }
        @Override public String getColumnName(int columnIndex) {
            return columns[columnIndex];
        }
        @Override public boolean isCellEditable(int rowIndex, int columnIndex) {
            return (columnIndex != PHONE);
        }
        @Override public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if(aValue.toString().equals(""))
                return;
            Person row = items.elementAt(rowIndex);
            switch(columnIndex){
                case NAME :
                    row.setName((String)aValue);
                    break;
                case CITY :
                    row.setCity((String)aValue);
                    break;
                case PHONE :
                    row.setPhone((String)aValue);
                    break;
            }
            // atualizeza  baza de date + mesaj de eroare
            try{
                boolean edit = update(new Object[] {
                    getValueAt(rowIndex, NAME),
                    getValueAt(rowIndex, CITY),
                    getValueAt(rowIndex, PHONE)
                });
                if(!edit)
                    throw new Exception("Eroare la actualizarea bazei de date!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(Form.this, e.getMessage());
            }
        }
    
        @Override public Object getValueAt(int rowIndex, int columnIndex) {
            Person info = items.elementAt(rowIndex);
            switch(columnIndex){
                case NAME  : return info.getName();
                case CITY  : return info.getCity();
                case PHONE : return info.getPhone();
            }
            return "NULL";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backup;
    private javax.swing.JTextField City;
    private javax.swing.JButton DeleteAll;
    private javax.swing.JButton Insert;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Phone;
    private javax.swing.JButton Reset;
    private javax.swing.JTable dataTable;
    private javax.swing.JComboBox fieldName;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel settingPanel;
    private javax.swing.JSlider slider;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextField value;
    // End of variables declaration//GEN-END:variables

}
