
package CustomSwing;

import java.awt.Color;


public class MenuItem extends javax.swing.JPanel {
    private final Model.Menu data;
   
    public MenuItem(Model.Menu data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        if (data.getType() == Model.Menu.MenuType.MENU) {
            lbIcon.setIcon(data.toIcon());
            lbName.setText(data.getName());
        }
        else
        {
            lbName.setText(" ");
        }
    }
 
    public void setSelected(Boolean selected)
    {
        if (data.getType() == Model.Menu.MenuType.MENU) {
            if (selected) {
                lbIcon.setIcon(data.toIconSelected());
                lbName.setForeground(new Color(60,60,60));
            }
            else
            {
                lbIcon.setIcon(data.toIcon());
                lbName.setForeground(new Color(198,203,210));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbName = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();

        lbName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(198, 203, 210));
        lbName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIcon)
                .addGap(18, 18, 18)
                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
