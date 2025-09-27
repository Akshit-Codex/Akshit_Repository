public class Client
{
    public static void main(String[] args)
    {
        AcerManufacturer acerManufacturer=new AcerManufacturer();
        CPU acerCPU= acerManufacturer.createCPU();
        acerCPU.getCPU();
        Monitor acerMonitor= acerManufacturer.createMonitor();
        acerMonitor.getMonitor();

        Company asusManufacturer=new AsusManufacturer();
        CPU asusCPU= asusManufacturer.createCPU();
        asusCPU.getCPU();
        Monitor asusMonitor= asusManufacturer.createMonitor();
        asusMonitor.getMonitor();
    }
}
