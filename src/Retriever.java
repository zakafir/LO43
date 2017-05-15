import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by zakaria_afir on 28/04/2017.
 */
public class Retriever {

    private static final String PATH_NAME_INSTANCE = "/Users/zakaria_afir/Downloads/sujet_LO43/Instance_1/Instance_1.txt";
    private static final String PATH_NAME_SOLUTION = "/Users/zakaria_afir/Downloads/sujet_LO43/Instance_1/Solution_1.txt";
    private int numberOfDrivers;
    private int totalCost;
    private Map<String, Object> worker = new TreeMap<String, Object>();
    private Map<String, Object> oneTask = new TreeMap<String, Object>();
    private List<Map<String, Object>> tasks = new LinkedList<>();
    private ArrayList instance = new ArrayList();
    char [] debut;
    char [] fin;




    public void readSolution() {
        BufferedReader br = null;
        BufferedReader br2 = null;
        try {
            br = new BufferedReader(new FileReader(PATH_NAME_SOLUTION));
            br2 = new BufferedReader(new FileReader(PATH_NAME_INSTANCE));
            System.out.println("Reading the txt file");
            String contentLine = br.readLine();

            System.out.println("Reading the txt file");
            String formatingHours;
            String contentLine2 = br2.readLine();
            while (contentLine2 != null) {
                if (!contentLine2.isEmpty()) {
                    System.out.print(getHeureDebut(contentLine2));
                    System.out.print("------->");
                    System.out.print(getHeureFin(contentLine2));
                    formatingHours = getHeureDebut(contentLine2) +"-------->"+ getHeureFin(contentLine2);
                    instance.add(formatingHours);
                    System.out.println("");
                }
                contentLine2 = br2.readLine();
            }

            //
            while (contentLine != null) {
                boolean hasUppercase = !contentLine.equals(contentLine.toLowerCase());
                //boolean hasLowercase = !contentLine.equals(contentLine.toUpperCase());

                if (!contentLine.isEmpty()) {
                    if (contentLine.contains("**********") && contentLine.contains("driver")) {
                        numberOfDrivers = Integer.parseInt(contentLine.replaceAll("[\\D]", ""));
                    }
                    if (contentLine.contains("----") && contentLine.contains("Worker")) {
                        worker.put("id_worker", Integer.parseInt(contentLine.replaceAll("[\\D]", "")));
                    }
                    if (contentLine.contains("workerTimeSum")) {
                        worker.put("workerTimeSum", Integer.parseInt(contentLine.replaceAll("[\\D]", "")));
                    }
                    if (contentLine.contains("UnderTime")) {
                        worker.put("UnderTime", Integer.parseInt(contentLine.replaceAll("[\\D]", "")));
                    }
                    if (contentLine.contains("IdleTime")) {
                        worker.put("IdleTime", Integer.parseInt(contentLine.replaceAll("[\\D]", "")));
                    }
                    if (contentLine.contains("Cost")) {
                        worker.put("Cost", Integer.parseInt(contentLine.replaceAll("[\\D]", "")));
                    }
                    if (contentLine.contains("task:")) {
                        String a = after(contentLine, ":");
                        String test = contentLine.replace("finishTime:" + a, "");
                        oneTask.put("finishTime", a.replaceAll("[\\D]", ""));
                        if (contentLine.contains("startTime:")) {
                            String b = after(test, ":");
                            String test2 = test.replace("startTime:" + b, "");
                            oneTask.put("startTime", b.replaceAll("[\\D]", ""));
                            if (contentLine.contains("finishTime:")) {
                                String c = after(test2, ":");
                                oneTask.put("task_id", c.replaceAll("[\\D]", ""));
                            }
                        }
                        if (hasUppercase) {
                            int[] j = lastIndexOfUCL(contentLine);
                            if (j[0] != 0 && j[1] != 0) {
                                oneTask.put("origin", contentLine.charAt(j[1]));
                                oneTask.put("destination", contentLine.charAt(j[0]));
                            }
                        }
                        oneTask.put("id_worker", worker.get("id_worker"));

                        //checher hours dans la liste instance
                        for(Map.Entry<String, Object> entry : oneTask.entrySet()){
                                if (entry.getKey().equals("task_id") && !instance.isEmpty()) {
                                        Object object = instance.get(Integer.parseInt((String) entry.getValue())-1);
                                        oneTask.put("hours", object);
                                        continue;
                            }
                        }

                        tasks.add(new TreeMap<String, Object>(oneTask));
                        oneTask.clear();
                    }
                    if (contentLine.contains("TotalCost")) {
                        totalCost = Integer.parseInt(contentLine.replaceAll("[\\D]", ""));
                    }
                }
                contentLine = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                System.out.println("Reading file successfully");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(tasks.get(i));
                }
                if (br != null)
                    br.close();
                if(br2 != null)
                br2.close();
        }
        catch (IOException ioe) {
                System.out.println("Error in closing the BufferedReader");
            }
        }
    }

/*
    public void readInstance() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(PATH_NAME_INSTANCE));

            System.out.println("Reading the txt file");
            int ligne = 0;
            String contentLine = br.readLine();
            while (contentLine != null) {
                if(!contentLine.isEmpty()){
                    System.out.print(gettingThings(contentLine));
                    System.out.println("");
                    ligne++;
                    contentLine = br.readLine();
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                System.out.println("Reading file successfully");
                if (br != null)
                    br.close();
            } catch (IOException ioe) {
                System.out.println("Error in closing the BufferedReader");
            }
        }
    }
*/

    public String getHeureDebut(String contentLine){
        char [] test = contentLine.toCharArray();
        debut = new char[5];
        for(int i = 0; i<5;++i){
            if(i==2){
                debut[i]='h';
                continue;
            }
            debut[i]=test[i];
        }
        String a = String.valueOf(debut);
        a = a.replaceAll("\\s+","");
        return a;
    }

    public String getHeureFin(String contentLine){
        char [] test = contentLine.toCharArray();
        fin = new char[8];
        int cmp = 1;
        for(int i = 6; i<14;++i){
            if(test[i] == ' ' && cmp == 1){
                fin[i-6]='h';
                cmp++;
                continue;
            }
            fin[i-6]=test[i];
        }
        String a = String.valueOf(fin);
        a = a.replaceAll("([A-Z])", "");
        a = a.replaceAll("\\s+","");
        return a;
    }


    public int[] lastIndexOfUCL(String contentLine) {
        int[] nothing = new int[2];
        nothing[0] = 0;
        nothing[1] = 0;
        int[] all = new int[2];
        for (int i = contentLine.length() - 1; i >= 0; i--) {
            if (Character.isUpperCase(contentLine.charAt(i))) {
                all[0] = i;
                if (Character.isUpperCase(contentLine.charAt(i - 1))) {
                    all[1] = i - 1;
                }
            }
            return all;
        }
        return nothing;
    }


    public String after(String value, String a) {
        // Returns a substring containing all characters after a string.
        int posA = value.lastIndexOf(a);
        if (posA == -1) {
            return "";
        }
        int adjustedPosA = posA + a.length();
        if (adjustedPosA >= value.length()) {
            return "";
        }
        return value.substring(adjustedPosA);
    }

    public String between(String value, String a, String b) {
        // Return a substring between the two strings.
        int posA = value.indexOf(a);
        if (posA == -1) {
            return "";
        }
        int posB = value.lastIndexOf(b);
        if (posB == -1) {
            return "";
        }
        int adjustedPosA = posA + a.length();
        if (adjustedPosA >= posB) {
            return "";
        }
        return value.substring(adjustedPosA, posB);
    }

    public String before(String value, String a) {
        // Return substring containing all characters before a string.
        int posA = value.indexOf(a);
        if (posA == -1) {
            return "";
        }
        return value.substring(0, posA);
    }

    /*public void ajouterH(String t){
        StringBuilder stringBuilder = new StringBuilder();
        char[] test = t.toCharArray();
        if(t.length() == 4){
            stringBuilder.append(test[0])
                    .append(test[1])
                    .append('h')
                    .append(test[2])
                    .append(test[3]);
        }
        else if((t.length() == 3)){
            if(test[0] > 1){
                stringBuilder.append(test[0])
                        .append('h')
                        .append(test[1])
                        .append(test[2]);
            }
            else if()
        }
    }*/

}
