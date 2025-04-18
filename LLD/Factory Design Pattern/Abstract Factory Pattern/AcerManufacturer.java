public class AcerManufacturer extends Company
{
    public CPU createCPU()
    {
        return new AcerCPU();
    }

    //@Override
    public Monitor createMonitor()
    {
        return new AcerMonitor();
    }
}
