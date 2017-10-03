package ApiAi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

public class ApiClient {
	private AIConfiguration aiConfiguration;
	private AIDataService dataService;
	
	public ApiClient(String token) {
		this.aiConfiguration = new AIConfiguration(token);
		this.dataService = new AIDataService(aiConfiguration);
	}

	public String getConversation(String message) {
		AIRequest request = new AIRequest(message);
        AIResponse response;
		try {
			response = dataService.request(request);
	        return response.getResult().getFulfillment().getSpeech();

		} catch (AIServiceException e) {
			e.printStackTrace();
		}
		return "Something went wrong.";
		
	}
}
