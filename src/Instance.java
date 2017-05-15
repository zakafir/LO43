import java.util.List;

/**
 * Created by zakaria_afir on 03/05/2017.
 */
public class Instance {

    private int idInstance;
    private int numberOfWorker;
    private int totalCost;
    //private List<Worker> listWorkers;

    public Instance(int idInstance, int numberOfWorker, int totalCost) {
        this.idInstance = idInstance;
        this.numberOfWorker = numberOfWorker;
        this.totalCost = totalCost;
    }

    public int getIdInstance() {
        return idInstance;
    }

    public void setIdInstance(int idInstance) {
        this.idInstance = idInstance;
    }

    public int getNumberOfWorker() {
        return numberOfWorker;
    }

    public void setNumberOfWorker(int numberOfWorker) {
        this.numberOfWorker = numberOfWorker;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
