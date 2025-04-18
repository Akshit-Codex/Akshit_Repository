public class AsusManufacturer extends Company
{
    //@Override
    public CPU createCPU()
    {
        return new AsusCPU();
    }
    //@Override
    public Monitor createMonitor()
    {
        return new AsusMonitor();
    }
}
