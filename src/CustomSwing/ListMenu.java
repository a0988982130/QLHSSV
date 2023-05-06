
package CustomSwing;

import Events.EventMenuCallBack;
import Events.EventMenuSelected;
import Model.Menu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

public class ListMenu<E extends Object> extends JList<E>{
    private final DefaultListModel model;
    private final List<EventMenuSelected> events;
    private int selectedIndex = - 1;
    
    public ListMenu(){
        model = new DefaultListModel();
        events = new ArrayList<>();
        super.setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int index = locationToIndex(e.getPoint());
                    Object obj = model.getElementAt(index);
                    if (obj instanceof Model.Menu) {
                        Menu data = (Menu) obj;
                        if (data.getType() == Model.Menu.MenuType.MENU) {
                            if (index != selectedIndex) {
                                selectedIndex = -1;
                                runEvent(index);
                            }
                        }
                    }
                    else
                    {
                        if (index != selectedIndex) {
                            selectedIndex = -1;
                            runEvent(index);
                        }
                    }
                    
                }  
            }   

        });
    }
    

     public void runEvent(int index) {
        for(EventMenuSelected event: events)
               {
                   event.menuSelected(index, new EventMenuCallBack() {
                       @Override
                       public void call(int index) {
                           selectedIndex = index;
                           repaint();
                       }
                   });
               }
            }
     
     public ListCellRenderer<? super E> getCellRenderer(){
         return new DefaultListCellRenderer(){
             @Override
             public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Model.Menu data;
                 if (value instanceof Model.Menu) {
                     data = (Menu) value;
                 }
                 else
                 {
                     data = new Model.Menu("1", value + "", Model.Menu.MenuType.MENU);
                 }
                 MenuItem item = new MenuItem(data);
                 item.setSelected(index == selectedIndex);
                 return item; 
             }
             
         };
     }
     
     @Override
     public void setModel(ListModel<E> lm)
     {
         for (int i = 0; i < lm.getSize(); i++) {
             model.addElement(lm.getElementAt(i));
         }
     }
     
     public void addItem(Model.Menu data)
     {
         model.addElement(data);
     }
     
     public void selectedIndex(int index)
     {
         this.selectedIndex = index;
     }
     
     public void addEventSelectedMenu(EventMenuSelected event)
     {
         events.add(event);
     }
    
}
