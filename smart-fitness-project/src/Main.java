import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class User {
    private String name;
    private int age;
    private double weight;
    private ArrayList<String> goals;

    public User() {
        goals = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;

    }

    public void setWeight(float weight) {
        this.weight = weight;

    }

    public void setGoals(ArrayList<String> goals) {
        this.goals = goals;

    }

    public String getName() {
        return name;

    }

    public int getAge() {
        return age;

    }

    public double getWeight() {
        return weight;

    }

    public ArrayList<String> getGoals() {
        return goals;

    }


}

class Workout{
    private String Type;
    private ArrayList<ArrayList<Object>> workoutlog;
    private String Date;
    private Double Duration;
    private float Calories;


    public Double getDuration() {
        return Duration;

    }

    public String getDate(){
        return Date;
    }

    public float getCalories() {
        return Calories;

    }


    public Workout() {
        workoutlog = new ArrayList<>();

    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getType() {
        return Type;
    }

    public void setDuration(Double duration) {
        this.Duration = duration;

    }

    public void setCalories(float calories) {
        this.Calories = calories;

    }

    public void setDate(String date) {
        this.Date = date;

    }

    public void setWorkoutLog(){
        ArrayList<Object> workout = new ArrayList<>();
        workout.add(Type);
        workout.add(Date);
        workout.add(Duration);
        workout.add(Calories);
        workoutlog.add(workout);

    }

    public double dailyCalories(String chosenDate){
        double totalCalories = 0.0;
        for (ArrayList<Object> workout : workoutlog) {
            if (chosenDate.equals(workout.get(1))){
                double calories = (double) workout.get(3);
                totalCalories = totalCalories + calories;
            }

        }
        return totalCalories;
    }
    public int totalWorkouts(){
        return workoutlog.size();
    }

}

public class Main {
    public static void main(String[] args) {
        Workout workout = new Workout();
        User user = new User();





        JFrame frame = new JFrame("Fitness Tracker");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Display area for submitted user data
        JTextArea displayArea = new JTextArea(8, 30);
        displayArea.setEditable(false);
        frame.add(displayArea);

        // Overlay panel for user input
        JPanel overlayPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        overlayPanel.setBackground(new Color(240, 240, 240));
        overlayPanel.setBorder(BorderFactory.createTitledBorder("Enter User Info"));

        // Input fields
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField weightField = new JTextField();
        JTextField goal1Field = new JTextField();
        JTextField goal2Field = new JTextField();
        JTextField goal3Field = new JTextField();

        // Add fields to overlay
        overlayPanel.add(new JLabel("Name:")); overlayPanel.add(nameField);
        overlayPanel.add(new JLabel("Age:")); overlayPanel.add(ageField);
        overlayPanel.add(new JLabel("Weight:")); overlayPanel.add(weightField);
        overlayPanel.add(new JLabel("Goal 1:")); overlayPanel.add(goal1Field);
        overlayPanel.add(new JLabel("Goal 2:")); overlayPanel.add(goal2Field);
        overlayPanel.add(new JLabel("Goal 3:")); overlayPanel.add(goal3Field);

        JButton submitButton = new JButton("Submit");
        overlayPanel.add(new JLabel()); // filler
        overlayPanel.add(submitButton);

        frame.add(overlayPanel);

        // Submit button action
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                String weight = weightField.getText();
                String goal1 = goal1Field.getText();
                String goal2 = goal2Field.getText();
                String goal3 = goal3Field.getText();

                // Handle empty goals
                if (goal1.isEmpty()) goal1 = "N/A";
                if (goal2.isEmpty()) goal2 = "N/A";
                if (goal3.isEmpty()) goal3 = "N/A";

                // Hide form
                overlayPanel.setVisible(false);

                // Show data in text area
                displayArea.setText("User Info:\n");
                displayArea.append("Name: " + name + "\n");
                displayArea.append("Age: " + age + "\n");
                displayArea.append("Weight: " + weight + "\n");
                displayArea.append("Goals:\n- " + goal1 + "\n- " + goal2 + "\n- " + goal3);
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JFrame frame1 = new JFrame("FITNESS TRACKER");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Fitness Tracker");
        frame.add(label);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.add(panel);

        JTextField workoutField = new JTextField();
        workoutField.setText("Enter Workout (RUNNING, CYCLING, SWIMMING, STRENGTH, YOGA)");
        workoutField.setColumns(10);
        frame.add(workoutField);

        JTextField durationField = new JTextField();
        durationField.setText("Enter Duration");
        durationField.setColumns(10);
        frame.add(durationField);

        JTextField caloriesField = new JTextField();
        caloriesField.setText("Enter Calories");
        caloriesField.setColumns(10);
        frame.add(caloriesField);

        JTextField dateField = new JTextField();
        dateField.setText("Enter Date");
        dateField.setColumns(10);
        frame.add(dateField);

        workoutField.setPreferredSize(new Dimension(150, 25));
        dateField.setPreferredSize(new Dimension(150, 25));
        durationField.setPreferredSize(new Dimension(75, 25));
        caloriesField.setPreferredSize(new Dimension(75, 25));

        JButton submit = new JButton("Submit");
        frame.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typeContent = workoutField.getText();
                workout.setType(typeContent);

                String dateContent = dateField.getText();
                workout.setDate(dateContent);

                int caloriesContent;
                try {
                    caloriesContent = Integer.parseInt(caloriesField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Calories must be a whole number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                workout.setCalories(caloriesContent);

                Double durationContent = Double.valueOf(durationField.getText());
                workout.setDuration(durationContent);

                workout.setWorkoutLog();

                JCheckBox check = new JCheckBox("Type: " + workout.getType() + " Date: " + workout.getDate() + " Calories: " + workout.getCalories() + " Duration: " + workout.getDuration());

                panel.add(check);
                panel.add(check);
                frame.revalidate();
                frame.repaint();




            }

        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ;}
}