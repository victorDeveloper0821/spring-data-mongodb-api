package idv.victor.docker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages= {"idv.victor"})
@EnableMongoRepositories(basePackages= {"idv.victor.dao"})
public class DockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerApplication.class, args);
	}
	@RestController
    class SimpleController {

        @GetMapping(value="/")
        public Map hello() {
            Map map = new HashMap();
            map.put("say", "hello");
            return map;
        }
    }
}
