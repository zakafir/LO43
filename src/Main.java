/**
 * Created by zakaria_afir on 28/04/2017.
 */

//import services.Core.Worker;

import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/** Assumes UTF-8 encoding. JDK 7+. */
public class Main {
    public static int compteurFichiers = 0;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        javax.swing.JTextArea text = new javax.swing.JTextArea();








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



        JButton button = new JButton("Add files");
        javax.swing.JFrame frame = new javax.swing.JFrame("FileDrop");
        frame.getContentPane().add(
                new javax.swing.JScrollPane(text),
                java.awt.BorderLayout.CENTER);

        frame.getContentPane().add(
                button, BorderLayout.SOUTH);

        button.setBorderPainted( false );
        button.setFocusPainted( false );


        new FileDrop(System.out, text,new FileDrop.Listener() {
            public void filesDropped(java.io.File[] files) {
                for (int i = 0; i < files.length; i++) {
                    try {
                        text.append(files[i].getCanonicalPath() + "\n");
                        if(compteurFichiers == 0){
                            Retriever.setPathNameInstance(files[i].getCanonicalPath());
                        }else{
                            Retriever.setPathNameSolution(files[i].getCanonicalPath());
                        }
                        compteurFichiers++;
                        if(compteurFichiers == 2) {
                            button.setBorderPainted(true);
                            button.setFocusPainted(true);
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    SwingUtilities.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            new JListExample();
                                        }
                                    });
                                    Retriever retriever = new Retriever();
                                    retriever.readSolutionAndInstanceFiles();

                                    Instance.getData();
                                }
                            });
                        }
                    }   // end try
                    catch (java.io.IOException e) {
                    }
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener

        frame.setBounds(100, 100, 300, 400);
        frame.setVisible(true);
    }
}

