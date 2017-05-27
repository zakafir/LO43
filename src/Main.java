/**
 * Created by zakaria_afir on 28/04/2017.
 */

//import services.Core.Worker;

import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.sql.SQLException;

/** Assumes UTF-8 encoding. JDK 7+. */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Retriever retriever = new Retriever();
        retriever.readSolutionAndInstanceFiles();

        Instance.getData();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JListExample();
            }
        });


        for (int it =0; it<Instance.tasksOfSpecificWorker(9).size();++it){
            System.out.println(Instance.tasksOfSpecificWorker(9).get(it));
        }


        /*//heure de début
        System.out.print(Instance.heureDebutTaskOfSpecifiWorker(1,2)[0]);
        System.out.print(Instance.heureDebutTaskOfSpecifiWorker(1,2)[1]);
        System.out.print(":");
        System.out.print(Instance.heureDebutTaskOfSpecifiWorker(1,2)[2]);
        System.out.println(Instance.heureDebutTaskOfSpecifiWorker(1,2)[3]);

        System.out.println("---");

        //heure de fin
        System.out.print(Instance.heureFinTaskOfSpecifiWorker(1,2)[0]);
        System.out.print(Instance.heureFinTaskOfSpecifiWorker(1,2)[1]);
        System.out.print(":");
        System.out.print(Instance.heureFinTaskOfSpecifiWorker(1,2)[2]);
        System.out.println(Instance.heureFinTaskOfSpecifiWorker(1,2)[3]);*/

        /*//finishTime
        System.out.println(Instance.startTimeOfSpecificWorker(1,2));

        //workerTimeSum
        System.out.println(Instance.workerTimeSumOfSpecificWorker(1));

        //destination
        System.out.println(Instance.destinationOfSpecificWorker(1,2));

        //origin
        System.out.println(Instance.originOfSpecificWorker(1,2));*/




        final DrawGantt drawGantt = new DrawGantt("Gantt");
        drawGantt.pack();
        RefineryUtilities.centerFrameOnScreen(drawGantt);
        drawGantt.setVisible(true);


    }
}

