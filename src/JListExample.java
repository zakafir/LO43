/**
 * Created by zakaria_afir on 27/05/2017.
 */
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * JList basic tutorial and example
 *
 * @author wwww.codejava.net
 */
public class JListExample extends JFrame {

    private JList<String> countryList;

    public JListExample() {
        //create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for(int i = 1; i<=Instance.getNumberOfWorker(); ++i){
            listModel.addElement(""+i);
        }


        //create the list
        countryList = new JList<>(listModel);
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = countryList.getSelectedValuesList();
                    System.out.println(selectedValuesList);
                }
            }
        });

        add(new JScrollPane(countryList));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JList Example");
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}