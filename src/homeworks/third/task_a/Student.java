package homeworks.third.task_a;

import java.util.Arrays;

public class Student {

    String fio;
    String groupNumber;
    float[] marks;

    public Student(String fio, String groupNumber, float[] marks) {
        this.fio = fio;
        this.groupNumber = groupNumber;
        this.marks = marks;
    }

    public String getStudentInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("Student ");
        sb.append(fio);
        sb.append(" from group ");
        sb.append(groupNumber);
        sb.append(" with these marks ");
        sb.append(Arrays.toString(marks));

        return sb.toString();
    }
}
