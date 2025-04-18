import javax.lang.model.element.Name;

public class Student
{
    private int id;
    private String name;
    private int age;
    private double psp;
    private String universityName;
    private int gradYear;
    private String phoneNumber;

    public Student(Builder builder)
    {
        this.id=builder.id;
        this.name=builder.name;
        this.age=builder.age;
        this.psp=builder.psp;
        this.universityName=builder.universityName;
        this.gradYear=builder.gradYear;
        this.phoneNumber=builder.phoneNumber;
    }

//    public String getName() // Just trying to print student's name
//    {
//        return name;
//    }
    public static Builder builder()
    {
        return new Builder();
    }
    public static class Builder
    {
        private int id;
        private String name;
        private int age;
        private double psp;
        private String universityName;
        private int gradYear;
        private String phoneNumber;

        public Builder()
        {    }


        public Builder Id(int id) {
            this.id = id;
            return this;
        }
        public Builder Name(String name) {
            this.name=name;
            return this;
        }
        public Builder Age(int age) {
            this.age = age;
            return this;
        }
        public Builder Psp(double psp) {
            this.psp=psp;
            return this;
        }
        public Builder UniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }
        public Builder GradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }
        public Builder PhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public static void validate(Builder builder) throws Exception
        {
            if(builder.age<24)
            {
                throw new Exception("Invalid Age");
            }
            else if(builder.gradYear<2024)
            {
                throw new Exception("Invalid grad year");
            }
            else if(builder.name == null)
            {
                throw new Exception("Name cant be empty");
            }
            else
            {
                System.out.println("SAB CHANGA HAI JI");
            }
        }

        public Student build() throws Exception
        {
            validate(this);
            return new Student(this);
        }
    }
}
