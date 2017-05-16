/**
 * Created by zakaria_afir on 28/04/2017.
 */

//import services.Core.Worker;

import View.DrawGantt;
import org.jfree.ui.RefineryUtilities;

import java.sql.SQLException;

/** Assumes UTF-8 encoding. JDK 7+. */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Retriever retriever = new Retriever();
        retriever.readSolutionAndInstanceFiles();
        final DrawGantt drawGantt = new DrawGantt("Gantt Chart Demo 1");
        drawGantt.pack();
        RefineryUtilities.centerFrameOnScreen(drawGantt);
        drawGantt.setVisible(true);


    }
}

