     class Student {
        private String name;
        private int age;
        private int grade;

        public Student(String name, int age, int grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public int getGrade() {
            return grade;
        }

        public void study() {
            System.out.println(name + " is studying.");
        }
    }

     class Teacher {
        private String name;
        private int age;
        private Student[] students = new Student[3];

        public Teacher(String name, int age, Student[] students) {
            this.name = name;
            this.age = age;
            this.students = students;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setStudents(Student[] students) {
            this.students = students;
        }

        public Student[] getStudents() {
            return students;
        }

        public void printStudentInformation() {
            System.out.println("Teacher " + name + " has the following students:");
            for (int i = 0; i < students.length; i++) {
                System.out.println("Student " + (i + 1) + ": Name - " + students[i].getName() +
                        ", Age - " + students[i].getAge() + ", Grade - " + students[i].getGrade());
            }
        }

        public void askStudentsToStudy() {
            System.out.println("Teacher " + name + " is asking students to study:");
            for (int i = 0; i < students.length; i++) {
                students[i].study();
            }
        }
    }

      class University {
        public void mai(String[] args) {
            Student[] students1 = new Student[3];
            students1[0] = new Student("John", 20, 90);
            students1[1] = new Student("Jane", 21, 95);
            students1[2] = new Student("Jim", 22, 92);

            Student[] students2 = new Student[3];
            students2[0] = new Student("Paul", 19, 85);
            students2[1] = new Student("Peter", 20, 88);
            students2[2] = new Student("Phil", 21, 86);

            Student[] students3 = new Student[3];
            students3[0] = new Student("Sarah", 18, 93);
            students3[1] = new Student("Samantha", 19, 91);
            students3[2] = new Student("Vladimir", 22, 98);

            Teacher teacher1 = new Teacher("Ms. Smith", 30, students1);
            Teacher teacher2 = new Teacher("Mr. Brown", 35, students2);
            Teacher teacher3 = new Teacher("Mrs. Davis", 40, students3);

            teacher1.printStudentInformation();
            teacher2.printStudentInformation();
            teacher3.printStudentInformation();

            teacher1.askStudentsToStudy();
            teacher2.askStudentsToStudy();
            teacher3.askStudentsToStudy();
        }
    }
public class ch2Dz1 {
    public static void main(String[] args) {
        University university = new University();
        university.mai(args);
    }
    }