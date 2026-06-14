package spring.ai.example.spring_ai_demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringAiDemoApplication {

	private final ChatClient chatClient;

	public static void main(String[] args) {
		SpringApplication.run(SpringAiDemoApplication.class, args);
	}

	public SpringAiDemoApplication(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	@GetMapping("/ai")
	public String chat(@RequestParam String message) {
		return chatClient.prompt()
				.user(message)
				.call()
				.content();
	}

}
