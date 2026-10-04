package se411lab4;
import javafx.application.*;
import javafx.stage.*;
public class App extends Application {

	public static void main(String[] args) {
		launch();
		}

		@Override
		public void start(Stage primaryStage) {
		try {
		primaryStage.setTitle("My Project");
		primaryStage.show();
		} catch (Exception e) {
		e.printStackTrace();
		}
}
}