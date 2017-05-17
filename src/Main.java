/**
 * Created by zakaria_afir on 28/04/2017.
 */

//import services.Core.Worker;

import java.sql.SQLException;

/** Assumes UTF-8 encoding. JDK 7+. */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Retriever retriever = new Retriever();
        retriever.readSolutionAndInstanceFiles();
        Instance i = new Instance();

        i.getData();
        for (int it =0; it<i.tasksOfSpecificWorker(121).size();++it){
            System.out.println(i.tasksOfSpecificWorker(121).get(it));
        }


        //heure de début
        System.out.print(i.heureDebutTaskOfSpecifiWorker(121,2)[0]);
        System.out.print(i.heureDebutTaskOfSpecifiWorker(121,2)[1]);
        System.out.print(":");
        System.out.print(i.heureDebutTaskOfSpecifiWorker(121,2)[2]);
        System.out.println(i.heureDebutTaskOfSpecifiWorker(121,2)[3]);

        System.out.println("---");

        //heure de fin
        System.out.print(i.heureFinTaskOfSpecifiWorker(121,2)[0]);
        System.out.print(i.heureFinTaskOfSpecifiWorker(121,2)[1]);
        System.out.print(":");
        System.out.print(i.heureFinTaskOfSpecifiWorker(121,2)[2]);
        System.out.println(i.heureFinTaskOfSpecifiWorker(121,2)[3]);

        //finishTime
        System.out.println(i.startTimeOfSpecificWorker(121,3));

        //workerTimeSum
        System.out.println(i.workerTimeSumOfSpecificWorker(121));

        //destination
        System.out.println(i.destinationOfSpecificWorker(121,4));

        //origin
        System.out.println(i.originOfSpecificWorker(121,4));




        /*final DrawGantt drawGantt = new DrawGantt("Gantt Chart Demo 1");
        drawGantt.pack();
        RefineryUtilities.centerFrameOnScreen(drawGantt);
        drawGantt.setVisible(true);*/


    }
}

