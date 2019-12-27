package sima.classwork16_12;

public class Class {
    private Student[] _studentArr;
    private int numOfStudents;
    private final int MAX_NUM_OF_STUDENTS = 30;

    public Class(){
        _studentArr = new Student[MAX_NUM_OF_STUDENTS];
        numOfStudents = 0;
    }
}
