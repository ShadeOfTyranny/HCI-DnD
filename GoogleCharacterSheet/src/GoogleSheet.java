import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoogleSheet {
	String spreadSheetId;
	String range;
	private Sheets service;

	private ValueRange response;
	private static final String APPLICATION_NAME = "Character Sheet";
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"),".credentials/sheets.googleapis.com-java-quickstart");
	private static FileDataStoreFactory DATA_STORE_FACTORY;
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static HttpTransport HTTP_TRANSPORT;
	private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS);

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	public GoogleSheet(String spreadSheetId) throws IOException {
		// Build a new authorized API client service.
		this.spreadSheetId = spreadSheetId;
		service = getSheetsService();
		range = "charactersheet!A1:E100";
		response = service.spreadsheets().values().get(spreadSheetId, range).execute();

	}
	
	public String[] getCharacterInfo(char character) throws IOException {
		range = "charactersheet!" + character + "1:" + character + "100";
		response = service.spreadsheets().values().get(spreadSheetId, range).execute();
		List<List<Object>> values = response.getValues();
		String[] myStrArray = new String[values.size()];
		for (int i = 0; i < values.size(); i++) {
			myStrArray[i] = values.get(i).get(0).toString();
		}
		return myStrArray;
	}

	// sets character info on google sheet
	public void setCharacterInfo(char character, String[] charAttr) throws IOException {
		service = getSheetsService();
		
		int asciiChar = (int) character;
		int characterNum = asciiChar - 65;
		
		for(int i = 0; i< charAttr.length ; i++){
			List<Request> requests = new ArrayList<>();
			List<CellData> values = new ArrayList<>();
			values.add(new CellData().setUserEnteredValue(new ExtendedValue().setStringValue(charAttr[i])));
			requests.add(new Request().setUpdateCells(
					new UpdateCellsRequest().setStart(new GridCoordinate().setSheetId(0).setRowIndex(i).setColumnIndex(characterNum))
							.setRows(Arrays.asList(new RowData().setValues(values)))
							.setFields("userEnteredValue,userEnteredFormat.backgroundColor")));
			BatchUpdateSpreadsheetRequest batchUpdateRequest = new BatchUpdateSpreadsheetRequest().setRequests(requests);
			service.spreadsheets().batchUpdate(spreadSheetId, batchUpdateRequest).execute();
			
		}
		
		
		
	}
	public static Credential authorize() throws IOException {
		// Load client secrets.
		InputStream in = GoogleSheet.class.getResourceAsStream("/sheets_client_secret.json");
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES).setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();
		Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
		return credential;
	}

	/**
	 * Build and return an authorized Sheets API client service.
	 * 
	 * @return an authorized Sheets API client service
	 * @throws IOException
	 */
	private static Sheets getSheetsService() throws IOException {
		Credential credential = authorize();
		return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME)
				.build();
	}


}