package ApiAi;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ApiAiTest {
	
	private String input;
	private String expectOutput;
	private ApiClient api = new ApiClient();

//	@Before
//	public void setUp() throws Exception {
//	}
	
	public ApiAiTest(String input, String output) {
		this.input = input;
		this.expectOutput = output;
	}
	
	@Parameters
	public static Collection<String[]> testApiCollection(){
		String ExpectedInputOutput[][] = {
				{"How do I enroll?", "You can enroll in courses by visiting http://reg.stamford.edu/registrar/home.asp and logging in with your credentials and then click ‘Enroll’."}	
		};
		
		return Arrays.asList(ExpectedInputOutput);
	}

	@Test
	public void test() {
		assertEquals(expectOutput, api.getConversation(input));
	}

}
