/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import nimgame.SillyComputer;
import nimgame.Pile;

/**
 *
 * @author tuongdi
 */
public class SillyPageCont extends javax.swing.JFrame {

    private Pile pile;
    private boolean turn = true;
    private int amount;
    private String setnameplayer1;
    private String setnameplayer2;
    private SillyComputer silly;
    private int last;
    public static ArrayList<String> data = null;
    private boolean tt;

    /**
     * Creates new form SillyPage1
     */
    public SillyPageCont() {
        initComponents();
        pile = new Pile();
        silly = new SillyComputer();
        data = new ArrayList<String>();
        getContentPane().setBackground(new java.awt.Color(255, 255, 255));
        readData();
        if (last > 1) {
            for (int i = 0; i < last; i++) {
                JLabel j1 = new JLabel();
                j1.setSize(60, 60);
                j1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Images/coke.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                jPanel2.add(j1);
                jPanel2.setBackground(new java.awt.Color(255, 255, 255));
            }
            showTotal.setText(String.valueOf(last));
            player1.setText(setnameplayer1);
            player2.setText(setnameplayer2);
            if (tt == turn) {
                turn = true;
                takecoke2.setEditable(false);
                takecoke1.setEditable(true);
            } else {
                turn = false;
                takecoke2.setEditable(true);
                takecoke1.setEditable(false);
            }
        } else {
            coke();
        }
    }

    public void coke() {
        setnameplayer1 = JOptionPane.showInputDialog(this, "Tên người chơi thứ nhất?");
        setnameplayer2 = JOptionPane.showInputDialog(this, "Tên người chơi thứ hai?");
        player1.setText(setnameplayer1);
        player2.setText(setnameplayer2);
        showTotal.setText(String.valueOf(last));
        System.out.println(last);
        for (int i = 0; i < last; i++) {
            JLabel j1 = new JLabel();
            j1.setSize(60, 60);
            j1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Images/coke.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            jPanel2.add(j1);
            jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        }
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn chơi trước?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            amount = silly.move(last);
            takecoke2.setText(String.valueOf(amount));
            takecoke1.setText("");
            turn = true;
        }
        turn = true;
        takecoke2.setEditable(false);
    }

    public void updateData() {
        String url = "D:\\TuongDi\\HK1.4\\NLCSKTPM\\test\\Nim_Game_Java-master\\data_silly.txt";
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(url);
            bw = new BufferedWriter(fw);
            
            String lastUpdate = String.valueOf(last);
            String turnUpdate = String.valueOf(turn);

            bw.write(setnameplayer1 + "\n");
            bw.write(setnameplayer2 + "\n");
            bw.write(lastUpdate + "\n");
            bw.write(turnUpdate);

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public void readData() {
        String url = "D:\\TuongDi\\HK1.4\\NLCSKTPM\\test\\Nim_Game_Java-master\\data_silly.txt";
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(url);
            br = new BufferedReader(fr);
            String str = null;
            while ((str = br.readLine()) != null && !str.isEmpty()) {
                String[] arr = str.split("\n");
                for (int i = 0; i < arr.length; i++) {
                    data.add(arr[i]);
                }
            }

            setnameplayer1 = data.get(0);
            setnameplayer2 = data.get(1);
            String lastStr = String.valueOf(data.get(2));
            String turnStr = String.valueOf(data.get(3));

            last = Integer.parseInt(lastStr);
            tt = Boolean.parseBoolean(turnStr);

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        newgame = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        player1 = new javax.swing.JLabel();
        takecoke1 = new javax.swing.JTextField();
        takecoke2 = new javax.swing.JTextField();
        showTotal = new javax.swing.JTextField();
        player2 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        take = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Mode");

        jPanel1.setBackground(new java.awt.Color(132, 166, 132));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo_Nim.png"))); // NOI18N

        newgame.setBackground(new java.awt.Color(255, 255, 255));
        newgame.setText("Trò chơi mới");
        newgame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newgameActionPerformed(evt);
            }
        });

        Exit.setBackground(new java.awt.Color(255, 255, 255));
        Exit.setText("Thoát");
        Exit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        player1.setBackground(new java.awt.Color(255, 255, 255));

        showTotal.setEnabled(false);

        player2.setBackground(new java.awt.Color(255, 255, 255));

        Total.setBackground(new java.awt.Color(255, 255, 255));
        Total.setText("Số coke");

        take.setBackground(new java.awt.Color(255, 255, 255));
        take.setText("Chọn");
        take.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        take.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                takeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(player2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(player1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newgame, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(take, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takecoke1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takecoke2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(newgame, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(takecoke1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(takecoke2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(take, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridLayout(10, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void takeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_takeMouseClicked
        // TODO add your handling code here:
        if (turn == true) {

            amount = Integer.parseInt(takecoke1.getText());
            takecoke1.setText("");
            while (true) {
                if (amount <= last / 2 && amount > 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(this, "Số coke không hợp lệ, bạn vui lòng nhập lại!");
                    return;
                }
            }
            last = last - amount;
            jPanel2.removeAll();
            jPanel2.updateUI();
            for (int i = 0; i < last; i++) {
                JLabel j1 = new JLabel();
                j1.setSize(60, 60);
                j1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Images/coke.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                jPanel2.add(j1);
                jPanel2.setBackground(new java.awt.Color(255, 255, 255));
            }
            showTotal.setText(String.valueOf(last));
            if (last == 1) {
                JOptionPane.showMessageDialog(this, player1.getText() + " đã thắng rồi nè!!!");
            }
            turn = false;
        }
        if (turn == false) {
            amount = silly.move(last);
            System.out.println(amount);
            String ComputerTake = String.valueOf(amount);
            takecoke2.setText(ComputerTake);
            last = last - amount;
            jPanel2.removeAll();
            jPanel2.updateUI();
            for (int i = 0; i < last; i++) {
                JLabel j1 = new JLabel();
                j1.setSize(60, 60);
                j1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Images/coke.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                jPanel2.add(j1);
                jPanel2.setBackground(new java.awt.Color(255, 255, 255));
            }
            showTotal.setText(String.valueOf(last));
            if (last == 1) {
                JOptionPane.showMessageDialog(this, player2.getText() + " đã thắng rồi nè!!!");
            }

            turn = true;
            takecoke2.setEditable(false);
            takecoke1.setEditable(true);
        }
    }//GEN-LAST:event_takeMouseClicked

    private void newgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newgameActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new SillyPage().setVisible(true);
    }//GEN-LAST:event_newgameActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        updateData();
        this.setVisible(false);
        new FirstPage().setVisible(true);
    }//GEN-LAST:event_ExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SillyPageCont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SillyPageCont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SillyPageCont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SillyPageCont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SillyPageCont().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JLabel Total;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton newgame;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JTextField showTotal;
    private javax.swing.JButton take;
    private javax.swing.JTextField takecoke1;
    private javax.swing.JTextField takecoke2;
    // End of variables declaration//GEN-END:variables
}
