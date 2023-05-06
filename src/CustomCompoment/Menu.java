/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomCompoment;

import CustomShadow.ShadowBorder;
import CustomSwing.PanelShadow;
import Events.EventMenu;
import Events.EventMenuCallBack;
import Events.EventMenuSelected;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Menu extends PanelShadow {
    
    private int selectedIndex = -1;
    private double menuTarget;
    private double menuLastTarget;
    private double currentLocation;
    private BufferedImage selectedImage;
    private Animator animator;
    private EventMenuCallBack callBack;
    private EventMenu event;
    
    public Menu() {
        initComponents();
        setBackground(new Color(242, 246, 253));
        initData();
        listMenu.addEventSelectedMenu(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, EventMenuCallBack callBack) {
                if (!animator.isRunning()) {
                    if (index != selectedIndex) {
                        Menu.this.callBack = callBack;
                        selectedIndex = index;
                        menuTarget = selectedIndex * 50 + listMenu.getY();
                        animator.start();
                    }
                }
            }
        });
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                currentLocation = (menuTarget - menuLastTarget) * fraction;
                currentLocation += menuLastTarget;
                repaint();
            }

            @Override
            public void end() {
                menuLastTarget = menuTarget;
                callBack.call(selectedIndex);
                if (event != null) {
                    event.menuIndexChange(selectedIndex);
                }
            }
        };
        animator = new Animator(300, target);
        animator.setResolution(1);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
       
    }

     private void initData() {
//        listMenu.addItem(new Model.Menu("1", "Account", Model.Menu.MenuType.MENU));
//        listMenu.addItem(new Model.Menu("2", "Employee", Model.Menu.MenuType.MENU));
//        listMenu.addItem(new Model.Menu("3", "Majors", Model.Menu.MenuType.MENU));
//        listMenu.addItem(new Model.Menu("4", "Course", Model.Menu.MenuType.MENU));
//        listMenu.addItem(new Model.Menu("5", "Class", Model.Menu.MenuType.MENU));
//        listMenu.addItem(new Model.Menu("6", "Student", Model.Menu.MenuType.MENU));
//        listMenu.addItem(new Model.Menu("7", "Contact", Model.Menu.MenuType.MENU));
//        listMenu.addItem(new Model.Menu("8", "Training", Model.Menu.MenuType.MENU));
//        listMenu.addItem(new Model.Menu("9", "Ratings", Model.Menu.MenuType.MENU));
//        listMenu.addItem(new Model.Menu("", "", Model.Menu.MenuType.EMPTY));
        listMenu.addItem(new Model.Menu("1", "Account", Model.Menu.MenuType.MENU));
        listMenu.addItem(new Model.Menu("2", "Majors", Model.Menu.MenuType.MENU));
        listMenu.addItem(new Model.Menu("3", "Course", Model.Menu.MenuType.MENU));
        listMenu.addItem(new Model.Menu("4", "Class", Model.Menu.MenuType.MENU));
        listMenu.addItem(new Model.Menu("5", "Student", Model.Menu.MenuType.MENU));
        listMenu.addItem(new Model.Menu("6", "Contact", Model.Menu.MenuType.MENU));
        listMenu.addItem(new Model.Menu("7", "Training", Model.Menu.MenuType.MENU));
        listMenu.addItem(new Model.Menu("8", "Ratings", Model.Menu.MenuType.MENU));
        listMenu.addItem(new Model.Menu("", "", Model.Menu.MenuType.EMPTY));
    }

      public void setSelectedIndex(int index) {
        selectedIndex = index;
        menuTarget = selectedIndex * 50 + listMenu.getY();
        menuLastTarget = menuTarget;
        currentLocation = menuLastTarget;
        listMenu.selectedIndex(index);
        repaint();
    }
      
      private void createImage(){
         int width = getWidth() - 30;
         selectedImage = ShadowBorder.getInstance().createShadowOut(width, 50, 8, 8, new Color(242, 246, 253));
     }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        createImage();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (selectedIndex >= 0) {
            g.drawImage(selectedImage, 15, (int) currentLocation, null);
        }
    }
    
     public void addEvent(EventMenu event) {
        this.event = event;
    }
      
      
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listMenu = new CustomSwing.ListMenu<>();
        profile2 = new CustomCompoment.Profile();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(25, 118, 211), new java.awt.Color(25, 118, 211), new java.awt.Color(25, 118, 211), new java.awt.Color(25, 118, 211)));
        setForeground(new java.awt.Color(25, 118, 211));

        listMenu.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(profile2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(profile2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomSwing.ListMenu<String> listMenu;
    private CustomCompoment.Profile profile2;
    // End of variables declaration//GEN-END:variables

  
}
