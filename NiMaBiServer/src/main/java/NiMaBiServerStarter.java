import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class NiMaBiServerStarter {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ServerConfig.class);
        ctx.refresh();

        ServerConfig serverConfig = ctx.getBean(ServerConfig.class);
        int serviceThreads = Integer.parseInt(serverConfig.getServiceThreads());

        


        System.out.println(serviceThreads);

    }


}
