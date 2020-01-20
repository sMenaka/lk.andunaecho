package lk.andunaechomedia;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({lk.andunaechomedia.models.File.class})
class Fire {
    public  static void main(String ar[]){
        SpringApplication.run(Fire.class,ar);
    }

}