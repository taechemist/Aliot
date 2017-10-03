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
	private AIConfiguration configuration = new AIConfiguration("21570048dc7b4ac4af785340169e9eb4");
	private AIDataService dataService = new AIDataService(configuration);

	
	public String getConversation(String message) {
		
		AIRequest request = new AIRequest(message);
        AIResponse response;
		try {
			response = dataService.request(request);
//	        System.out.println(response.getResult().getFulfillment().getSpeech());
	        return response.getResult().getFulfillment().getSpeech();

		} catch (AIServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no message...";
		
	}
	
	
//	  public static void main(String[] args) {
//		  System.out.print("test");
//		  AIConfiguration configuration = new AIConfiguration("21570048dc7b4ac4af785340169e9eb4");
//		  AIDataService dataService = new AIDataService(configuration);
		  
//          AIRequest request = new AIRequest("Hello");
//          AIResponse response;
//		try {
//			response = dataService.request(request);
//	        System.out.println(response.getResult().getFulfillment().getSpeech());
//
//		} catch (AIServiceException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//	  }
}
