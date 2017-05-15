
import java.util.ArrayList;

/**
 * Created by zakaria_afir on 05/05/2017.
 */
public class Task {

    private int idInstance;
    private int idTask;
    private int idWorker;
    private String heure_dep;
    private String heure_fin;
    private int startTime;
    private int finishTime;
    private String origine;
    private String destination;
    private int underTime;
    private int idleTime;
    private int cost;


    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getIdInstance() {
        return idInstance;
    }

    public void setIdInstance(int idInstance) {
        this.idInstance = idInstance;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public String getHeure_dep() {
        return heure_dep;
    }

    public void setHeure_dep(String heure_dep) {
        this.heure_dep = heure_dep;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public int getUnderTime() {
        return underTime;
    }

    public void setUnderTime(int underTime) {
        this.underTime = underTime;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(int idleTime) {
        this.idleTime = idleTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
