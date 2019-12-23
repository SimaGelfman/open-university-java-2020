package sima.classwork16_12;

public class Student {
    private String _name;
    private int _heightInCM;

    public Student(String name, int height){
        _name = name;
        _heightInCM = height;
    }

    public Student(Student s){
        _name = s._name;
        _heightInCM = s._heightInCM;
    }

}
