import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by zakaria_afir on 05/05/2017.
 */

public class Worker {

    private int id;
    private int cost;
    private int idleTime;
    private int underTime;
    private int overTime;
    private int startTime;
    private int finishTime;
    private String hours;
    private String origin;
    private String destination;
    private int workerTimeSum;
    private ArrayList<ArrayList> allData;

    public Worker(){
    }

    public Worker(int id){
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public ArrayList<ArrayList> getAllData() {
        return allData;
    }

    public int getId() {
        return id;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public int getUnderTime() {
        return underTime;
    }

    public int getOverTime() {
        return overTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public String getHours() {
        return hours;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getWorkerTimeSum() {
        return workerTimeSum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setIdleTime(int idleTime) {
        this.idleTime = idleTime;
    }

    public void setUnderTime(int underTime) {
        this.underTime = underTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setWorkerTimeSum(int workerTimeSum) {
        this.workerTimeSum = workerTimeSum;
    }

    public void setAllData(ArrayList<ArrayList> allData) {
        this.allData = allData;
    }
}

