import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

public class ConversationExample {
	
	private final static String username = "22b06a7b-a0b4-4047-89c3-16867b1d63df";
	private final static String password = "DJaQxMEaoJBG";
	private final static String workspaceID = "840a9622-bffe-4ee7-a71c-4ac5b84cc575";

	public static void main(String[] args) {
		ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2017_04_21);
		service.setUsernameAndPassword(username, password);
		
		Map<String, Object> context = new HashMap<String, Object>();

		// first message
		MessageRequest newMessage = new MessageRequest.Builder()
			.inputText("What is your name")
			.context(context)
			.build();

		MessageResponse response = service.message(workspaceID, newMessage).execute();

		// second message
		newMessage = new MessageRequest.Builder()
			.inputText("what is your name")
			.context(response.getContext()) // output context from the first message
			.build();

		response = service.message(workspaceID, newMessage).execute();

		System.out.println(response.getTextConcatenated(""));
	}

}
