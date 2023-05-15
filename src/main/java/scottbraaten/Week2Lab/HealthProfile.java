package scottbraaten.Week2Lab;

/**************************************************** 
Program Name: HealthProfile.java
Programmer's Name: Scott Braaten 
Program Description: A class for defining a user's name,
age, weight, height, BMI, BMI category, and max heart rate.
***********************************************************/


public class HealthProfile {
    private String name;
    private int age;
    private double weight;
    private double height;

    public HealthProfile(String name, int age, double weight, double heightFt, double heightIn) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = heightFt * 12 + heightIn;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        if (age > 0)
            this.age = age;
    }

    public double getWeight() {
        return this.weight;
    }
    public void setWeight(double weight) {
        if (weight > 0.0)
            this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }
    public void setHeight(double height) {
        if (height > 0.0)
            this.height = height;
    }

    public double getBMI() {
        return (double) Math.round(this.weight * 703.0 / Math.pow(this.height, 2) * 10) / 10.0;
    }

    public String getCategory() {
        double bmi = this.getBMI();
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public int getMaxHR() {
        return 220 - this.age;
    }
}
