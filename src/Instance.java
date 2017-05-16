import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zakaria_afir on 03/05/2017.
 */
public class Instance {

    private int idInstance;
    private int numberOfWorker;
    private int totalCost;
    public Worker worker;
    private static List<Map<String, Object>> listOfDataInstance = new LinkedList<>();

    public Instance() {

    }

    public List<Map<String, Object>> getData() {
        listOfDataInstance = Retriever.getTasks();
        return listOfDataInstance;
    }

    public List<Map<String, Object>> tasksOfSpecificWorker(int idWorker) {
        List<Map<String, Object>> tasksOfThisWorker = new LinkedList<>();
        if (idWorker <= getNumberOfWorker()) {
            for (int k = 0; k < listOfDataInstance.size(); ++k) {
                for (Map.Entry<String, Object> entry : listOfDataInstance.get(k).entrySet()) {
                    if (!listOfDataInstance.get(k).isEmpty() && entry.getValue().equals(idWorker) && entry.getKey().equals("id_worker")) {
                        tasksOfThisWorker.add(listOfDataInstance.get(k));
                    }
                }
            }
        }
        return tasksOfThisWorker;
    }

    public int costOfSpecificWorker(int idWorker){
        int cost = 0;
        if (idWorker <= getNumberOfWorker()) {
            for (int k = 0; k < tasksOfSpecificWorker(idWorker).size(); ++k) {
                for (Map.Entry<String, Object> entry : tasksOfSpecificWorker(idWorker).get(k).entrySet()) {
                    if (!listOfDataInstance.get(k).isEmpty() && entry.getKey().equals("Cost")) {
                        cost = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
        }
        return cost;
    }

    public int idleTimeOfSpecificWorker(int idWorker){
        int idleTime = 0;
        if (idWorker <= getNumberOfWorker()) {
            for (int k = 0; k < tasksOfSpecificWorker(idWorker).size(); ++k) {
                for (Map.Entry<String, Object> entry : tasksOfSpecificWorker(idWorker).get(k).entrySet()) {
                    if (!listOfDataInstance.get(k).isEmpty() && entry.getKey().equals("IdleTime")) {
                        idleTime = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
        }
        return idleTime;
    }

    public int underTimeOfSpecificWorker(int idWorker){
        int underTime = 0;
        if (idWorker <= getNumberOfWorker()) {
            for (int k = 0; k < tasksOfSpecificWorker(idWorker).size(); ++k) {
                for (Map.Entry<String, Object> entry : tasksOfSpecificWorker(idWorker).get(k).entrySet()) {
                    if (!listOfDataInstance.get(k).isEmpty() && entry.getKey().equals("UnderTime")) {
                        underTime = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
        }
        return underTime;
    }

    public int overTimeOfSpecificWorker(int idWorker){
        int overTime = 0;
        if (idWorker <= getNumberOfWorker()) {
            for (int k = 0; k < tasksOfSpecificWorker(idWorker).size(); ++k) {
                for (Map.Entry<String, Object> entry : tasksOfSpecificWorker(idWorker).get(k).entrySet()) {
                    if (!listOfDataInstance.get(k).isEmpty() && entry.getKey().equals("OverTime")) {
                        overTime = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
        }
        return overTime;
    }

    public boolean hasUnderTime(int a, int b){
        return a < b ? true : false;
    }


    public int getIdInstance() {
        return idInstance;
    }

    public void setIdInstance(int idInstance) {
        this.idInstance = idInstance;
    }

    public int getNumberOfWorker() {
        numberOfWorker = Retriever.numberOfDrivers;
        return numberOfWorker;
    }

    public int getTotalCost() {
        totalCost = Retriever.getTotalCost();
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public static List<Map<String, Object>> getListOfDataInstance() {
        return listOfDataInstance;
    }
}
