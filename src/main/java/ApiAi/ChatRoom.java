package ApiAi;

public class ChatRoom {
	private ApiClient aliotApi;
	private User user;
	private String botName = "Aliot";
	
	public ChatRoom(ApiClient aliotApi, User user) {
		this.aliotApi = aliotApi;
		this.user = user;
	};
	
	public void sendMessage(String message){
		makeUserChatNode(message);
		makeBotChatNode(message);
	}
	
	public void makeUserChatNode(String message) {
		System.out.println(user.getUserName()+": "+message);
	}
	
	public void makeBotChatNode(String message) {
		System.out.println(botName+": "+aliotApi.getConversation(message));
	}
}
