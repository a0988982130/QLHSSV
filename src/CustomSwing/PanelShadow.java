/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomSwing;


import CustomShadow.ShadowBorder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class PanelShadow extends JPanel{

    public ShadowBorder.ShadowType getShadowType() {
        return shadowType;
    }

    public void setShadowType(ShadowBorder.ShadowType shadowType) {
        this.shadowType = shadowType;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getShadowSize() {
        return shadowSize;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        setBorder(new EmptyBorder(shadowSize, shadowSize, shadowSize, shadowSize));
    }

    private ShadowBorder.ShadowType shadowType = ShadowBorder.ShadowType.OUT_SHADOW;
    private int radius = 20;
    private int shadowSize = 8;
    private BufferedImage imageShadow;

    public PanelShadow() {
        setBackground(new Color(242, 246, 253));
        setBorder(new EmptyBorder(16, 16, 16, 16));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imageShadow != null) {
            g.drawImage(imageShadow, 0, 0, null);
        }
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        createShadowImage();
    }

    private void createShadowImage() {
        if (shadowType == ShadowBorder.ShadowType.OUT_SHADOW) {
            imageShadow = ShadowBorder.getInstance().createShadowOut(this, shadowSize, radius);
        } else {
            imageShadow = ShadowBorder.getInstance().createShadowIn(this, shadowSize, radius);
        }
    }
}
