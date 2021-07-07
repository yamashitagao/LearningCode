package learning.tools;


import java.util.*;

/**
 * @description
 * @author:Alexius
 * @time: 17:15
 * @date: 2021/5/29
 */


public class MainText {
    public static void main(String[] args) {
//        String FILE_PATh = "D:\\A\\idanmu";
//        String DESTINATION_FILE_NAME = "";
//        String NEW_FILE_NAME = "";
//        String RULE = "^\\d{6}$";//^\d{2}$
//        RenameFile rf = new RenameFile(FILE_PATh,DESTINATION_FILE_NAME,NEW_FILE_NAME);
//        rf.ADD_DIR = false;
//        rf.C_SUFFIX = true;
//        rf.SUFFIX = "rar";
//
//        List<String> strings = rf.FindFiles();
//        File file =new File(FILE_PATh);
//        File[] files = file.listFiles();
//        List<File> files1 = Arrays.asList(files);
//        List<File> files2 = rf.findFilesItIteration(files1,RULE);
//        for (File f :
//                files2) {
//            System.out.println(f.getPath()+ " : "+f.getName());
//        }
//        rf.renameFile(files2);

//        ArrayList<String> s = new ArrayList<>();
//        s.add("a");
//        s.add(0, "b");
//
//        LinkedList<String> list = new LinkedList<>();
////        Vector<String> list =new Vector<>();
//        list.add("a");
//        list.add(null);
//        list.add(0, "b");
//        list.add("c");
////        list.addFirst("c");
//        list.remove("c");
//        list.add(null);
//        list.add("d");
//        for (String s1 :
//                list) {
//            System.out.println(s1);
//        }
//        LinkedHashSet
       HashSet<Employee> s= new HashSet();
       s.add(new Employee("a",1));
        s.add(new Employee("b",1));
        s.add(new Employee("a",1));
        System.out.println(s);
    }

    static class Employee{
        private String name;
        private int age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return (employee.name == ((Employee) o).name)&&(employee.age == ((Employee) o).age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

    }
}
