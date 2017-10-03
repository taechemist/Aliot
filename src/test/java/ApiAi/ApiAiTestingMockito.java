package ApiAi;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class ApiAiTestingMockito {
	
	//mocking api, user
	private ApiClient api = mock(ApiClient.class);
	private User user = mock(User.class);
	//set a new bot
	private Aliot bot = new Aliot(api, user);
	
	@Test
	public void test() {
		//set test message
		String testMessage = "Hello World";
		
		//set behavior in the method
		when(api.getConversation(testMessage)).thenReturn("Hello there");
		when(user.getUserName()).thenReturn("User1");
		//call method
		bot.makeChatNode(testMessage);
		
		//verify if the behavior get involved
		verify(api).getConversation(testMessage);
		verify(user).getUserName();
	}

}
