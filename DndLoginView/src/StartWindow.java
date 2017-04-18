import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class StartWindow extends Application{
	private GridPane root;
	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			root = new GridPane();
			root.setHgap(10);
		    root.setVgap(10);
		    root.setPadding(new Insets(0, 10, 0, 10));
		    
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Button clientGoButton = new Button("Go");
			
			Label clientLabel = new Label("Player");
			clientLabel.setUnderline(true);
			
			Label connect = new Label("Connect to a campaign?");
			
			TextField clientConnectField = new TextField("Insert client ID");
			
			Label createOrEdit = new Label("Or work with a character locally");
			
			Button createButton = new Button("create");
			Button loadButton = new Button("load");
			HBox buttonBox = new HBox();
			buttonBox.setSpacing(10);
			buttonBox.getChildren().add(createButton);
			buttonBox.getChildren().add(loadButton);
			
			root.add(clientLabel,0,0);
			root.add(connect,0,1);
			root.add(clientConnectField, 0, 2);
			root.add(clientGoButton,1,2);
			root.add(createOrEdit, 0, 3);
			root.add(buttonBox, 0, 4);
			
			Button DMGoButton = new Button("Go");
			
			Label DMLabel = new Label("Dungeon Master");
			DMLabel.setUnderline(true);
			
			Label DMConnect = new Label("Enter your campaign");
			
			TextField DMConnectField = new TextField("Insert Master ID");
			
			Label createDM = new Label("Or create new campaign");
			
			Button DMCreateButton = new Button("create");
			
			root.add(DMLabel,4,0);
			root.add(DMConnect,4,1);
			root.add(DMConnectField, 4, 2);
			root.add(DMGoButton,5,2);
			root.add(createDM, 4, 3);
			root.add(DMCreateButton, 4, 4);
			
			DMCreateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					BorderPane borderPane = new BorderPane();
					GridPane createCampaignPane = new GridPane();

					createCampaignPane.setHgap(10);
					createCampaignPane.setVgap(10);
					createCampaignPane.setPadding(new Insets(0, 3, 0, 2));
					borderPane.setTop(createCampaignPane);
					borderPane.setPadding(new Insets(10, 10, 10, 10));
					
					Scene dmScene = new Scene(borderPane, 600, 400);
					
					
					Label step1 = new Label("Step 1: Make a new google spreadsheet");
					Label step2 = new Label("Step 2: Copy the link and insert it here: ");
					Label step3 = new Label("This is your DM code. The app needs this to access your campaign so keep it secret, keep it safe. ");
					TextField googleSpreadSheet = new TextField();
					Button goButton = new Button("Go");
					TextField code = new TextField();
					code.setEditable(false);
					
					createCampaignPane.add(step1, 0, 1);
					createCampaignPane.add(step2, 0, 2);
					createCampaignPane.add(googleSpreadSheet, 1, 2);
					createCampaignPane.add(goButton, 2, 2);
					
					goButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent event) {
							if(googleSpreadSheet.getText()!=""){
								VBox box = new VBox();
								code.setText(GenerateKeys.generateKey("_", googleSpreadSheet.getText()));
								box.getChildren().add(step3);
								box.getChildren().add(code);
								borderPane.setCenter(box);
							}
							
							
						}
						
					});
					
					primaryStage.setScene(dmScene);
					primaryStage.show();
				}
				
			});
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
