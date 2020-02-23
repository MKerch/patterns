package patterns.creational.Prototype;

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cash cash = new Cash();
        cash.setStudent(new Student());

        Student student = cash.getStudent();
        System.out.println(student.hashCode());
        Student student2 = cash.getStudent();
        System.out.println(student2.hashCode());
    }
}

class Student implements Cloneable {

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}

class Cash {

    Student student;

    public Student getStudent() throws CloneNotSupportedException {
        return student.clone();
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
