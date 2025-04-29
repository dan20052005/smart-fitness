import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.FileReader;
import java.util.Date;

class user {
    private String name;
    private int age;
    private float weight;
    private ArrayList<String> goals;

    public user() {
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

    public float getWeight() {
        return weight;

    }

    public ArrayList<String> getGoals() {
        return goals;

    }


}

class Workout{
    private enum Type{
        RUNNING, CYCLING, SWIMMING, STRENGTH, YOGA

    }

    private ArrayList<ArrayList<Object>> workoutlog;
    private String Date;
    private float Duration;
    private float Calories;


    public float getDuration() {
        return Duration;

    }

    public String getDate(){
        return Date;
    }

    public float getCalories() {
        return Calories;

    }

    private Type type;

    public Workout(String typeName) {
        this.type = Type.valueOf(typeName.toUpperCase());
        workoutlog = new ArrayList<>();

    }

    public String getType() {
        return type.name();

    }

    public void setDuration(float duration) {
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
        workout.add(type);
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
        JFrame frame = new JFrame("FITNESS TRACKER");
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
    }
}