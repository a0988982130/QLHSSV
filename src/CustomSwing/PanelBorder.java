
package CustomSwing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelBorder extends JPanel{

    public PanelBorder() {
        setOpaque(false);//thiết lập tính năng độ che phủ cho nền = false
        setBackground(new Color(242, 246, 253));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());//thiết lập màu cho graphics bằng màu nền của panel
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g); 
    }
    
    
    
}
