
public class GenerateKeys {
	public static String generateKey(String identifier, String googleURL){
		//https://docs.google.com/spreadsheets/d/17ZDZr4OjRN0XrtV90mInS_hI_d66gdqeWlM3p_hcy7w/edit#gid=0
		int beginIndex = googleURL.indexOf("/d/")+3;
		int endIndex = beginIndex + 44;
		String spreadSheetId = googleURL.substring(beginIndex,endIndex);
		String identifierPlusSpreadSheetId = identifier + spreadSheetId;
		char[] charArray = identifierPlusSpreadSheetId.toCharArray();
		String code = "";
		for(char myChar : charArray){
			myChar--;
			code+=myChar;
			
		}
		
		return code;
	}
	public static String decryptKey(String code){
		String identifierPlusSpreadSheetId = "";
		char[] charArray = code.toCharArray();
		for(char myChar : charArray){
			myChar++;
			identifierPlusSpreadSheetId+=myChar;
			
		}
		return identifierPlusSpreadSheetId;
		
	}
	public static void main( String[] args){
		String code = generateKey("_",
		"https://docs.google.com/spreadsheets/d/17ZDZr4OjRN0XrtV90mInS_hI_d66gdqeWlM3p_hcy7w/edit#gid=0");
		String id = decryptKey(code);
		System.out.println(code);
		System.out.println(id);
		
	}
}
