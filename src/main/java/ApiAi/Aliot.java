package ApiAi;

public class Aliot {
	private ApiClient aliotApi;
	private User user;
	private String botName = "Aliot";
	
	public Aliot(ApiClient aliotApi, User user) {
		this.aliotApi = aliotApi;
		this.user = user;
	};
	
	public void makeChatNode(String message) {
		System.out.println(user.getUserName()+": "+message);
		System.out.println(botName+": "+aliotApi.getConversation(message));
	}
}
