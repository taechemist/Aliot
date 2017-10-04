package ApiAi;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ApiAiTest {
	
	private String input;
	private String expectOutput;
	private String token = "21570048dc7b4ac4af785340169e9eb4";
	private ApiClient api = new ApiClient(token);
	
	public ApiAiTest(String input, String output) {
		this.input = input;
		this.expectOutput = output;
	}
	
	@Parameters
	public static Collection<String[]> testApiCollection(){
		String ExpectedInputOutput[][] = {
				//whole sentence test
				{"How do I enroll?", "You can enroll in courses by visiting http://reg.stamford.edu/registrar/home.asp and logging in with your credentials and then click ‘Enroll’."},
				{"How many credits do I have?", "You currently have 30 credits."},
				{"Is software testing also known as devil incarnate?", "Yes."},
				{"What courses are available next term?", "Next term 2/2017 - ITE330, ITE221, ITE101 are available next term."},
				{"What is the wifi password?", "The password to Student Wifi is: Stu@stiu16am"},
				{"When is the drop period?", "After taking one of Chaky’s quiz."},
				{"Which subjects are being taught by Chaky?", "Software Testing and MIS103."},
				{"Who is teaching ITE101?", "Probably not Chaky."},
				{"Why is Chaky bronze?", "Because Chaky is not that great at League of Legends."},
				
				//key words test
				{"why chaky bronze", "Because Chaky is not that great at League of Legends."},
				{"how to enroll", "You can enroll in courses by visiting http://reg.stamford.edu/registrar/home.asp and logging in with your credentials and then click ‘Enroll’."},
				{"what is my credits", "You currently have 30 credits."},
				{"devil incarnate", "Yes."},
				{"course next term", "Next term 2/2017 - ITE330, ITE221, ITE101 are available next term."},
				{"wifi password", "The password to Student Wifi is: Stu@stiu16am"},
				{"when is drop period", "After taking one of Chaky’s quiz."},
				{"chaky subject", "Software Testing and MIS103."},
				{"ite101 teacher", "Probably not Chaky."},
				
				//Some small talk responses test
				{"who are you", "I am the master of whisperers. My role is to be sly, obsequious, and without scruples. Though, it seems I am stuck with answering questions from fellow IT students, I suppose it could be worse."},
				{"you're annoying", "I indeed, pride myself in being as such."},
				{"busy?", "Besides from answering your frivolous questions? Nah."},
				{"you're so clever", "You are too kind."},
				{"you're right", "Of course, I'm right."},
		};
		
		return Arrays.asList(ExpectedInputOutput);
	}

	@Test
	public void test() {
		assertEquals(expectOutput, api.getConversation(input));
	}

}
