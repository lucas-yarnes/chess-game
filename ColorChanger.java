import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class ColorChanger extends MouseAdapter {
    public void mouseEntered(MouseEvent evt) {
    	((JButton)evt.getSource()).setBackground(Color.BLUE);
    }

    public void mouseExited(MouseEvent evt) {
    	if (Integer.parseInt(((JButton)evt.getSource()).getName().substring(3, 4)) % 2 == 0) {
    		if(Integer.parseInt(((JButton)evt.getSource()).getName().substring(0, 1)) % 2 == 0) {
    			((JButton)evt.getSource()).setBackground(Color.WHITE);
    		}
    		else {
    			((JButton)evt.getSource()).setBackground(Color.LIGHT_GRAY);
    		}
    	}
    	else {
    		if(Integer.parseInt(((JButton)evt.getSource()).getName().substring(0, 1)) % 2 == 0) {
    			((JButton)evt.getSource()).setBackground(Color.LIGHT_GRAY);
    		}
    		else {
    			((JButton)evt.getSource()).setBackground(Color.WHITE);
    		}
    	}
    }
}

