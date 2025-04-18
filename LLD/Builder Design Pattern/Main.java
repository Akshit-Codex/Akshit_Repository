public class Main
{
    public static void main(String[] args) throws Exception
    {
//        StudentHelper studentHelper=new StudentHelper();
//        StudentHelper.validate(studentHelper);
//        // you can call the static method like this coz
//        // static method is part of class rather than part of instance of the class
//
//        //Student st=new Student(studentHelper);
//        studentHelper.setId(1)
//                     .setAge(25)
//                     .setName("Vijay")
//                     .setPsp(70.90)
//                     .setGradYear(2025)
//                     .setPhoneNumber("9283527423")
//                     .setUniversityName("ABC");

        Student student= Student.builder()
                .Name("Raj")
                .Age(25)
                .Id(1234)
                .Psp(90.7)
                .UniversityName("ABCD College")
                .GradYear(2025)
                .build();
        System.out.println(student.getName());

    }
}
