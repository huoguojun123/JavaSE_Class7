import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import com.example.*;
import com.example.ui.AdminPortalFrame;
import com.example.ui.EmployeePortalFrame;
import com.example.ui.MainFrame;

public class MainApp {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException{
        SwingUtilities.invokeLater(()->{
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
