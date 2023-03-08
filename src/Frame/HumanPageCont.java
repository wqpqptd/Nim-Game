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
import nimgame.Pile;

/**
 *
 * @author tuongdi
 */
public class HumanPageCont extends javax.swing.JFrame {

    private Pile pile;
    private boolean turn = true;
    private int amount;
    private String setnameplayer1;
    private String setnameplayer2;
    private int last;
    private boolean tt;
    public static ArrayList<String> data = null;

    /**
     * Creates new form SetupGame
     */
    public HumanPageCont() {

        initComponents();
        pile = new Pile();
        data = new ArrayList<String>();
        getContentPane().setBackground(new java.awt.Color(255, 255, 255));
        readData();
        if (last > 1) {
            for (int i = 0; i < last; i++) {
                JLabel j1 = new JLabel();
                j1.setSize(60, 60);
                j1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Images/coke.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                jPanel3.add(j1);
                jPanel3.setBackground(new java.awt.Color(255, 255, 255));
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
            jPanel3.add(j1);
            jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        }
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn chơi trước?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            turn = false;
            takecoke1.setEditable(false);
            takecoke1.setText("");
        } else {
            turn = true;
            takecoke2.setEditable(false);
            takecoke2.setText("");
        }
    }

    public void updateData() {
        String url = "D:\\TuongDi\\HK1.4\\NLCSKTPM\\test\\Nim_Game_Java-master\\data_human.txt";
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
        String url = "D:\\TuongDi\\HK1.4\\NLCSKTPM\\test\\Nim_Game_Java-master\\data_human.txt";
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
        newgame = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        player1 = new javax.swing.JLabel();
        player2 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        takecoke1 = new javax.swing.JTextField();
        takecoke2 = new javax.swing.JTextField();
        showTotal = new javax.swing.JTextField();
        take = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Player Mode");
        setBackground(new java.awt.Color(85, 132, 108));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(132, 166, 132));

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

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo_Nim.png"))); // NOI18N

        player1.setBackground(new java.awt.Color(255, 255, 255));

        total.setBackground(new java.awt.Color(255, 255, 255));
        total.setText("Số coke");

        showTotal.setEnabled(false);

        take.setText("Chọn ");
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
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(takecoke1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(player2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(showTotal)
                                    .addComponent(take, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(takecoke2)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newgame, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(newgame, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(takecoke1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(takecoke2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(take, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jPanel3.setLayout(new java.awt.GridLayout(10, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        updateData();
        this.setVisible(false);
        new FirstPage().setVisible(true);
    }//GEN-LAST:event_ExitActionPerformed

    private void newgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newgameActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new HumanPage().setVisible(true);

    }//GEN-LAST:event_newgameActionPerformed

    private void takeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_takeMouseClicked
        // TODO add your handling code here:
        if (turn == true) {
            takecoke2.setEditable(false);
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
            jPanel3.removeAll();
            jPanel3.updateUI();
            for (int i = 0; i < last; i++) {
                JLabel j1 = new JLabel();
                j1.setSize(60, 60);
                j1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Images/coke.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                jPanel3.add(j1);
                jPanel3.setBackground(new java.awt.Color(255, 255, 255));
            }
            showTotal.setText(String.valueOf(last));
            if (last == 1) {
                JOptionPane.showMessageDialog(this, player1.getText() + " đã thắng rồi nè!!!");
            }
            turn = false;
            takecoke1.setEditable(false);
            takecoke2.setEditable(true);

        } else {
            takecoke1.setEditable(false);
            amount = Integer.parseInt(takecoke2.getText());
            takecoke2.setText("");
            while (true) {
                if (amount <= last / 2 && amount > 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(this, "Số coke không hợp lệ, bạn vui lòng nhập lại!");
                    return;
                }
            }
            last = last - amount;
            jPanel3.removeAll();
            jPanel3.updateUI();
            for (int i = 0; i < last; i++) {
                JLabel j1 = new JLabel();
                j1.setSize(60, 60);
                j1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Images/coke.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                jPanel3.add(j1);
                jPanel3.setBackground(new java.awt.Color(255, 255, 255));
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

//    
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
            java.util.logging.Logger.getLogger(HumanPageCont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HumanPageCont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HumanPageCont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HumanPageCont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HumanPageCont().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logo;
    private javax.swing.JButton newgame;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JTextField showTotal;
    private javax.swing.JButton take;
    private javax.swing.JTextField takecoke1;
    private javax.swing.JTextField takecoke2;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

}
