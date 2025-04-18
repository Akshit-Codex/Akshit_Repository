public class StudentHelper
{
    private int id;
    private String name;
    private int age;
    private double psp;
    private String universityName;
    private int gradYear;
    private String phoneNumber;

    public StudentHelper()
    {    }


    public StudentHelper setId(int id) {
        this.id = id;
        return this;
    }
    public StudentHelper setName(String name) {
        this.name=name;
        return this;
    }
    public StudentHelper setAge(int age) {
        this.age = age;
        return this;
    }
    public StudentHelper setPsp(double psp) {
        this.psp=psp;
        return this;
    }
    public StudentHelper setUniversityName(String universityName) {
        this.universityName = universityName;
        return this;
    }
    public StudentHelper setGradYear(int gradYear) {
        this.gradYear = gradYear;
        return this;
    }
    public StudentHelper setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }

    public double getPsp() {
        return psp;
    }

    public int getAge() {
        return age;
    }

    public String getUniversityName() {
        return universityName;
    }

    public int getGradYear() {
        return gradYear;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static void validate(StudentHelper studentHelper) throws Exception
    {
        if(studentHelper.age<24)
        {
            throw new Exception("Invalid Age");
        }
        else if(studentHelper.gradYear<2024)
        {
            throw new Exception("Invalid grad year");
        }
        else if(studentHelper.name == null)
        {
            throw new Exception("Name cant be empty");
        }
    }
}
