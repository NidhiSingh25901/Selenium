package MavenSeleniumFrameworkPart3TestComponent.resources;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Properties;

public class SystemInfoUtil {
    public static Properties getSystemInfo() {
        Properties properties = new Properties();
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        
        properties.setProperty("OS Name", System.getProperty("os.name"));
        properties.setProperty("OS Version", System.getProperty("os.version"));
        properties.setProperty("OS Architecture", System.getProperty("os.arch"));
        properties.setProperty("Available Processors", String.valueOf(osBean.getAvailableProcessors()));
        properties.setProperty("System Load Average", String.valueOf(osBean.getSystemLoadAverage()));

        return properties;
    }
}
