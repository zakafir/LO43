import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zakaria_afir on 03/05/2017.
 */
public class Instance {

    private static int idInstance;
    private static int numberOfWorker;
    private static int totalCost;
    private static List<Map<String, Object>> listOfDataInstance = new LinkedList<>();


    public static List<Map<String, Object>> getData() {
        listOfDataInstance = Retriever.getTasks();
        return listOfDataInstance;
    }

    public static List<Map<String, Object>> tasksOfSpecificWorker(int idWorker) {
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

    public static int costOfSpecificWorker(int idWorker) {
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

    public static int idleTimeOfSpecificWorker(int idWorker) {
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

    public static int underTimeOfSpecificWorker(int idWorker) {
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

    public static int overTimeOfSpecificWorker(int idWorker) {
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

    public static String destinationOfSpecificWorker(int idWorker, int task) {
        String destination = "*";
        if (idWorker <= getNumberOfWorker() && task <= tasksOfSpecificWorker(idWorker).size()) {
            for (Map.Entry<String, Object> entry : tasksOfSpecificWorker(idWorker).get(task - 1).entrySet()) {
                if (!tasksOfSpecificWorker(idWorker).get(task - 1).isEmpty() && entry.getKey().equals("destination")) {
                    destination = entry.getValue().toString();
                }
            }
        }

        return destination;
    }

    public static int finishTimeOfSpecificWorker(int idWorker, int task) {
        int finishTime = 0;
        if (idWorker <= getNumberOfWorker() && task <= tasksOfSpecificWorker(idWorker).size()) {
            for (Map.Entry<String, Object> entry : tasksOfSpecificWorker(idWorker).get(task - 1).entrySet()) {
                if (!tasksOfSpecificWorker(idWorker).get(task - 1).isEmpty() && entry.getKey().equals("finishTime")) {
                    finishTime = Integer.parseInt(entry.getValue().toString());
                }
            }
        }

        return finishTime;
    }

    public static Integer[] heureDebutTaskOfSpecifiWorker(int idWorker, int task) {
        Integer[] heureEtMinuteDebut = new Integer[4];
        if (idWorker <= getNumberOfWorker() && task <= tasksOfSpecificWorker(idWorker).size()) {
            for (Map.Entry<String, Object> entry : tasksOfSpecificWorker(idWorker).get(task - 1).entrySet()) {
                if (!tasksOfSpecificWorker(idWorker).get(task - 1).isEmpty() && entry.getKey().equals("hours")) {
                    String hours = (String) entry.getValue();
                    hours = hours.replace("-------->", " ");
                    char[] h = hours.toCharArray();
                    for (int i = 0; i < h.length; ++i) {
                        if (heureEtMinuteDebut[0] == null && heureEtMinuteDebut[1] == null) {
                            if (Character.isDigit(h[i]) && h[i + 1] == 'h') {
                                heureEtMinuteDebut[0] = 0;
                                heureEtMinuteDebut[1] = Character.getNumericValue(h[i]);
                            } else if (Character.isDigit(h[i]) && Character.isDigit(h[i + 1])) {
                                heureEtMinuteDebut[0] = Character.getNumericValue(h[i]);
                                heureEtMinuteDebut[1] = Character.getNumericValue(h[i + 1]);
                            }
                        }
                        if ((heureEtMinuteDebut[2] == null && heureEtMinuteDebut[3] == null)) {
                            hours = Retriever.between(hours, "h", " ");
                            char[] m = hours.toCharArray();
                            if (m.length > 1) {
                                if (Character.isDigit(m[i]) && Character.isDigit(m[i + 1])) {
                                    heureEtMinuteDebut[2] = Character.getNumericValue(m[i]);
                                    heureEtMinuteDebut[3] = Character.getNumericValue(m[i + 1]);
                                    break;
                                }
                            } else {
                                heureEtMinuteDebut[2] = 0;
                                heureEtMinuteDebut[3] = Character.getNumericValue(m[i]);
                                break;
                            }


                        }
                    }
                }
            }
        }
        return heureEtMinuteDebut;
    }

    public static Integer[] heureFinTaskOfSpecifiWorker(int idWorker, int task) {
        Integer[] heureEtMinuteFin = new Integer[4];
        if (idWorker <= getNumberOfWorker() && task <= tasksOfSpecificWorker(idWorker).size()) {
            for (Map.Entry<String, Object> entry : tasksOfSpecificWorker(idWorker).get(task - 1).entrySet()) {
                if (!tasksOfSpecificWorker(idWorker).get(task - 1).isEmpty() && entry.getKey().equals("hours")) {
                    String hours = (String) entry.getValue();
                    hours = Retriever.after(hours, "-------->");
                    char[] h = hours.toCharArray();
                    for (int i = 0; i < h.length; ++i) {
                        if (heureEtMinuteFin[0] == null && heureEtMinuteFin[1] == null) {
                            if (Character.isDigit(h[i]) && h[i + 1] == 'h') {
                                heureEtMinuteFin[1] = Character.getNumericValue(h[i]);
                                heureEtMinuteFin[0] = 0;
                            } else if (Character.isDigit(h[i]) && Character.isDigit(h[i + 1])) {
                                heureEtMinuteFin[1] = Character.getNumericValue(h[i + 1]);
                                heureEtMinuteFin[0] = Character.getNumericValue(h[i]);
                            }
                        }
                        if ((heureEtMinuteFin[2] == null && heureEtMinuteFin[3] == null)) {
                            hours = Retriever.after(hours, "h");
                            char[] m = hours.toCharArray();
                            if (m.length > 1) {
                                if (Character.isDigit(m[i]) && Character.isDigit(m[i + 1])) {
                                    heureEtMinuteFin[3] = Character.getNumericValue(m[i + 1]);
                                    heureEtMinuteFin[2] = Character.getNumericValue(m[i]);
                                    break;
                                }
                            } else {
                                heureEtMinuteFin[3] = Character.getNumericValue(m[i]);
                                heureEtMinuteFin[2] = 0;
                                break;
                            }

                        }

                    }
                }
            }
        }
        return heureEtMinuteFin;
    }

    public static String originOfSpecificWorker(int idWorker, int task) {
        String origin = "*";
        if (idWorker <= getNumberOfWorker() && task <= tasksOfSpecificWorker(idWorker).size()) {
            for (Map.Entry<String, Object> entry : tasksOfSpecificWorker(idWorker).get(task - 1).entrySet()) {
                if (!tasksOfSpecificWorker(idWorker).get(task - 1).isEmpty() && entry.getKey().equals("origin")) {
                    origin = entry.getValue().toString();
                }
            }
        }

        return origin;
    }

    public static int startTimeOfSpecificWorker(int idWorker, int task) {
        int startTime = 0;
        if (idWorker <= getNumberOfWorker() && task <= tasksOfSpecificWorker(idWorker).size()) {
            for (Map.Entry<String, Object> entry : tasksOfSpecificWorker(idWorker).get(task - 1).entrySet()) {
                if (!tasksOfSpecificWorker(idWorker).get(task - 1).isEmpty() && entry.getKey().equals("startTime")) {
                    startTime = Integer.parseInt(entry.getValue().toString());
                }
            }
        }

        return startTime;
    }

    public static int workerTimeSumOfSpecificWorker(int idWorker) {
        int workerTimeSum = 0;
        if (idWorker <= getNumberOfWorker()) {
            for (int k = 0; k < tasksOfSpecificWorker(idWorker).size(); ++k) {
                for (Map.Entry<String, Object> entry : tasksOfSpecificWorker(idWorker).get(k).entrySet()) {
                    if (!listOfDataInstance.get(k).isEmpty() && entry.getKey().equals("workerTimeSum")) {
                        workerTimeSum = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
        }
        return workerTimeSum;
    }

    public static boolean hasUnderTime(int a, int b) {
        return a < b ? true : false;
    }

    public static int getIdInstance() {
        return idInstance;
    }

    public static void setIdInstance(int idInstance) {
        idInstance = idInstance;
    }

    public static int getNumberOfWorker() {
        numberOfWorker = Retriever.numberOfDrivers;
        return numberOfWorker;
    }

    public static int getTotalCost() {
        totalCost = Retriever.getTotalCost();
        return totalCost;
    }

    public static void setTotalCost(int totalCost) {
        totalCost = totalCost;
    }

    public static List<Map<String, Object>> getListOfDataInstance() {
        return listOfDataInstance;
    }
}
