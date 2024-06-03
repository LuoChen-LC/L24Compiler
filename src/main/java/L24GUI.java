import java.awt.*;
import javax.swing.*;
import com.intellij.uiDesigner.core.*;
/*
 * Created by JFormDesigner on Tue May 28 22:11:10 HKT 2024
 */



/**
 * @author LuoTianYi
 */
public class L24GUI extends JPanel {
    public L24GUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        textPane2 = new JTextPane();
        textPane3 = new JTextPane();
        textPane4 = new JTextPane();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();

        //======== this ========
        setLayout(null);
        add(textPane2);
        textPane2.setBounds(5, 195, 270, 345);
        add(textPane3);
        textPane3.setBounds(280, 195, 295, 345);
        add(textPane4);
        textPane4.setBounds(580, 195, 295, 345);

        //======== menu1 ========
        {
            menu1.setText("text");

            //---- menuItem1 ----
            menuItem1.setText("text");
            menu1.add(menuItem1);

            //---- menuItem2 ----
            menuItem2.setText("text");
            menu1.add(menuItem2);

            //---- menuItem3 ----
            menuItem3.setText("text");
            menu1.add(menuItem3);
        }
        add(menu1);
        menu1.setBounds(5, 5, 275, 75);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JTextPane textPane2;
    private JTextPane textPane3;
    private JTextPane textPane4;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
