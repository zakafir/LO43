/*
package services.Core;

import services.Database;

import java.sql.SQLException;
import java.util.ArrayList;

import static services.Constants.NUMBER_OF_COLUMNS;
import static services.Database.getRows;
import static services.Database.rows;


*/
/**
 * Created by zakaria_afir on 05/05/2017.
 *//*

public class Worker {

    private int id;
    private int workerTimeSum;
    private ArrayList<ArrayList> allData;
    private String[][] tab;
    public int getId() {
        return id;
    }

    public Worker(int id){
        this.id = id;
    }

    public void getWorkerData(){
        try {
            allData = Database.retrieveDatabase(id);
            System.out.println(allData.toString()+"\n"+"-------------Worker: "+this.getId());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rows = 0;
        }
    }
}
*/
