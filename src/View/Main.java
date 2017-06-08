package View; /**
 * Created by zakaria_afir on 28/04/2017.
 */

//import services.Core.Worker;

import Controller.Retriever;
import Model.Instance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

/**
 * Assumes UTF-8 encoding. JDK 7+.
 */
public class Main {
    public static int compteurFichiers = 0;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        lanchApp();
    }

    public static void lanchApp() {
        javax.swing.JTextArea text = new javax.swing.JTextArea();
        JButton button = new JButton("Add files");
        javax.swing.JFrame frame = new javax.swing.JFrame("FileDrop");
        frame.getContentPane().add(
                new javax.swing.JScrollPane(text),
                java.awt.BorderLayout.CENTER);

        frame.getContentPane().add(
                button, BorderLayout.SOUTH);

        button.setBorderPainted(false);
        button.setFocusPainted(false);


        new FileDrop(System.out, text, new FileDrop.Listener() {
            public void filesDropped(java.io.File[] files) {
                for (int i = 0; i < files.length; i++) {
                    try {
                        text.append(files[i].getCanonicalPath() + "\n");
                        if (compteurFichiers == 0) {
                            Retriever.setPathNameInstance(files[i].getCanonicalPath());
                        } else {
                            Retriever.setPathNameSolution(files[i].getCanonicalPath());
                        }
                        compteurFichiers++;
                        if (compteurFichiers == 2) {
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
                                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
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

