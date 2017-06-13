package View; /**
 * Created by zakaria_afir on 27/05/2017.
 */

import Controller.Constants;
import Model.Instance;
import org.jfree.ui.RefineryUtilities;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
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

        for (int i = 1; i <= Instance.getNumberOfWorker(); ++i) {
            listModel.addElement("" + i);
        }


        //create the list
        countryList = new JList<>(listModel);
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    List<String> selectedValuesList = countryList.getSelectedValuesList();
                    System.out.println(selectedValuesList);

                    DrawGantt.idDuChauffeur = Integer.parseInt(selectedValuesList.get(0));
                    System.out.println("+---------------------------------------------------------------------------------------+");
                    if (Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur) >= Constants.TEMPS_NORMAL) {
                        System.out.println("+Id Worker: " + DrawGantt.idDuChauffeur + " (★★★★★)");
                        System.out.println("+Ce chauffeur a obtenu 5 étoiles parce qu'il a travaillé plus que " + Constants.TEMPS_NORMAL + " min");
                    } else if (Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur) > 0 &&
                            Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur) < 96) {

                        System.out.println("+Id Worker: " + DrawGantt.idDuChauffeur + " (☆☆☆☆☆)");
                        System.out.println("+Ce chauffeur n'a pas obtenu d'étoiles ");

                    } else if (Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur) >= 96 &&
                            Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur) < 192) {

                        System.out.println("+Id Worker: " + DrawGantt.idDuChauffeur + " (★☆☆☆☆)");
                        System.out.println("+Ce chauffeur a obtenu 1 étoile ");


                    } else if (Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur) >= 192 &&
                            Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur) < 288) {

                        System.out.println("+Id Worker: " + DrawGantt.idDuChauffeur + " (★★☆☆☆)");
                        System.out.println("+Ce chauffeur a obtenu 2 étoiles ");

                    } else if (Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur) >= 288 &&
                            Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur) < 384) {

                        System.out.println("+Id Worker: " + DrawGantt.idDuChauffeur + " (★★★☆☆)");
                        System.out.println("+Ce chauffeur a obtenu 3 étoiles ");

                    } else if (Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur) >= 384 &&
                            Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur) < 480) {

                        System.out.println("+Id Worker: " + DrawGantt.idDuChauffeur + " (★★★★☆)");
                        System.out.println("+Ce chauffeur a obtenu 4 étoiles ");

                    } else {
                        System.out.println("+Id Worker: " + DrawGantt.idDuChauffeur);
                    }
                    System.out.println("+The WorkerTime Sum: " + Instance.workerTimeSumOfSpecificWorker(DrawGantt.idDuChauffeur));
                    System.out.println("+The Cost: " + Instance.costOfSpecificWorker(DrawGantt.idDuChauffeur));
                    System.out.println("+The Idle Time: " + Instance.idleTimeOfSpecificWorker(DrawGantt.idDuChauffeur));
                    System.out.println("+Ce Chauffeur a Under Time : " + Instance.hasUnderTime(Instance.overTimeOfSpecificWorker(DrawGantt.idDuChauffeur), Instance.underTimeOfSpecificWorker(DrawGantt.idDuChauffeur)));
                    System.out.println("+The Under Time: " + Instance.underTimeOfSpecificWorker(DrawGantt.idDuChauffeur));
                    System.out.println("+The Over Time: " + Instance.overTimeOfSpecificWorker(DrawGantt.idDuChauffeur));
                    System.out.println("+---------------------------------------------------------------------------------------+");
                    System.out.println("\n");

                    System.out.println("Tasks of worker :" + DrawGantt.idDuChauffeur);
                    for (int it = 0; it < Instance.tasksOfSpecificWorker(DrawGantt.idDuChauffeur).size(); ++it) {
                        System.out.println("********************************************");
                        System.out.println("Task :" + it + 1);
                        System.out.println("Start Time: " + Instance.startTimeOfSpecificWorker(DrawGantt.idDuChauffeur, it + 1));
                        System.out.println("Finish Time: " + Instance.finishTimeOfSpecificWorker(DrawGantt.idDuChauffeur, it + 1));
                        System.out.println("Origin: " + Instance.originOfSpecificWorker(DrawGantt.idDuChauffeur, it + 1));
                        System.out.println("Destination: " + Instance.destinationOfSpecificWorker(DrawGantt.idDuChauffeur, it + 1));
                        System.out.println("Id Task : " + Instance.taskIdOfSpecificWorker(DrawGantt.idDuChauffeur, it + 1));
                        System.out.print("l'heure de début : ");
                        System.out.print(Instance.heureDebutTaskOfSpecifiWorker(DrawGantt.idDuChauffeur, it + 1)[0]);
                        System.out.print(Instance.heureDebutTaskOfSpecifiWorker(DrawGantt.idDuChauffeur, it + 1)[1]);
                        System.out.print(":");
                        System.out.print(Instance.heureDebutTaskOfSpecifiWorker(DrawGantt.idDuChauffeur, it + 1)[2]);
                        System.out.println(Instance.heureDebutTaskOfSpecifiWorker(DrawGantt.idDuChauffeur, it + 1)[3]);

                        System.out.print("l'heure de fin : ");
                        System.out.print(Instance.heureFinTaskOfSpecifiWorker(DrawGantt.idDuChauffeur, it + 1)[0]);
                        System.out.print(Instance.heureFinTaskOfSpecifiWorker(DrawGantt.idDuChauffeur, it + 1)[1]);
                        System.out.print(":");
                        System.out.print(Instance.heureFinTaskOfSpecifiWorker(DrawGantt.idDuChauffeur, it + 1)[2]);
                        System.out.println(Instance.heureFinTaskOfSpecifiWorker(DrawGantt.idDuChauffeur, it + 1)[3]);

                        System.out.println("********************************************");
                        System.out.println("\n");

                    }
                    DrawGantt drawGantt = new DrawGantt("Gantt");
                    drawGantt.pack();
                    RefineryUtilities.centerFrameOnScreen(drawGantt);
                    drawGantt.setVisible(true);
                }
            }
        });

        add(new JScrollPane(countryList));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("List of workers");
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}