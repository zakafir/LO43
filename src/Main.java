/**
 * Created by zakaria_afir on 28/04/2017.
 */

//import services.Core.Worker;

import java.sql.SQLException;

/** Assumes UTF-8 encoding. JDK 7+. */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Database.createCoreDatabase();
        Retriever retriever = new Retriever();
        retriever.readSolutionAndInstanceFiles();
        //retriever.readInstance();
        //worker
        /*Worker worker1 = new Worker(4);
        worker1.getWorkerData();

        Worker worker2 = new Worker(9);
        worker2.getWorkerData();

        Worker worker3 = new Worker(5);
        worker3.getWorkerData();*/
    }
}

