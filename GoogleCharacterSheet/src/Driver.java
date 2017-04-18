import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException {
		// https://docs.google.com/spreadsheets/d/17ZDZr4OjRN0XrtV90mInS_hI_d66gdqeWlM3p_hcy7w/edit?usp=sharing
		String spreadSheetId = "17ZDZr4OjRN0XrtV90mInS_hI_d66gdqeWlM3p_hcy7w";
		
		GoogleSheet sheet = new GoogleSheet(spreadSheetId);
		char character = 'A';
		String[] characterAttributes = sheet.getCharacterInfo(character);
		for(String myStr : characterAttributes){
			System.out.println(myStr);
		}
		sheet.setCharacterInfo('C', characterAttributes);
	}

}
