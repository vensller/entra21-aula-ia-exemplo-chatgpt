package com.entra21.exemplo_chatgpt;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExemploChatgptApplication {

	public static void main(String[] args) {
		OpenAIClient client = OpenAIOkHttpClient.fromEnv(); // usa env var OPENAI_API_KEY
		ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
				.model(ChatModel.GPT_4_1)  // ou GPT_4_1
				.addUserMessage("Chat, meu grande amigo, me diga se você irá substituir a profissão de programador.")
				.build();

		ChatCompletion resp = client.chat().completions().create(params);
		System.out.println("Resposta: " + resp.choices().get(0).message().content());

		SpringApplication.run(ExemploChatgptApplication.class, args);
	}

}
