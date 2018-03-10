import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("nimabi.properties")
public class ServerConfig {

    private final int serverPortNumber;
    private final int maxClientAllowed;

    @Autowired
    public ServerConfig(@Value("#{new Integer('${serverPortNumber}')}") int serverPortNumber, @Value("#{new Integer('${maxClientAllowed}')}") int maxClientAllowed) {
        this.serverPortNumber = serverPortNumber;
        this.maxClientAllowed = maxClientAllowed;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public int getServerPortNumber() {
        return serverPortNumber;
    }

    public int getMaxClientAllowed() {
        return maxClientAllowed;
    }
}
