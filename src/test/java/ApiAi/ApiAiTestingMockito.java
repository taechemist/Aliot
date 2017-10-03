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
	private ChatRoom bot = new ChatRoom(api, user);
	
	@Test
	public void test() {
		//set test message
		String testMessage = "Hello";
		
		//set behavior in the method
		when(api.getConversation(testMessage)).thenReturn("Hello User");
		when(user.getUserName()).thenReturn("User1");
		
		//call method
		bot.sendMessage(testMessage);
		
		//verify if the behavior get involved
		verify(api).getConversation(testMessage);
		verify(user).getUserName();
	}

}
