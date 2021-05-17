package entornoGithub;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class entornoGithub extends Application {

	@Override
	public void start(Stage stage) {



		BorderPane borde = new BorderPane();

		//creamos un grid pane

		GridPane grid= new GridPane();

		TextField nombre = new TextField();
		TextField apellidos = new TextField();
		TextField direccion = new TextField();

		Text txtNombre = new Text("Nombre: ");
		Text txtApellidos = new Text("Apellidos: ");
		Text txtdireccion = new Text("Dirección: ");
		Text txtedad = new Text("edad: ");

		Text txtbiografia = new Text("biografia: ");
		TextArea biografia = new TextArea();
		biografia.setMaxSize(250.0, 250.0);

		//boton de verificacion marcado predefininamente
		CheckBox checkBox1 = new CheckBox("Subscribirse a la newsletter");
		checkBox1.setSelected(true);


		RadioButton masculino = new RadioButton("masculino");
		RadioButton femenino = new RadioButton("femenino");

		ComboBox edad = new ComboBox();

		//añadimos valroes a combobox
		for(int i=0; i<=100; i++){
		edad.getItems().add(i);
		}

		Button enviar = new Button("enviar");

		//FORMULARIO*******************************************************************

		//contraseña
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("contraseña: ");
		Text txtcontraseña = new Text("contraseña: ");

		//primera fila del grid
		grid.add(txtNombre, 0, 0);
		grid.add(nombre, 1, 0);
		grid.add(masculino, 2, 0);

		//segunda fila
		grid.add(txtApellidos, 0, 1);
		grid.add(apellidos, 1, 1);
		grid.add(femenino, 2, 1);

		//otra fila
		grid.add(txtdireccion, 0, 3);
		grid.add(direccion, 1, 3);
		grid.add(txtcontraseña, 0, 2);
		grid.add(passwordField, 1, 2);
		grid.add(txtedad, 0, 4);
		grid.add(edad, 1, 4,4,1);
		grid.add(txtbiografia, 1, 5);
		grid.add(biografia, 1, 7);
		grid.add(checkBox1, 0, 9);
		grid.add(enviar, 0, 11);


		grid.setPadding(new Insets(8.0,8.0,8.0,8.0));
		grid.setHgap(10);
		grid.setVgap(10);


		//ponemos el panel de grid en el centro de borde panel
		borde.setCenter(grid);







	//escena
		Scene scene = new Scene(borde, 800.0,600.0);

		stage.setScene(scene);
		stage.show();


}











	public static void main(String[] args) {
		launch(args);
	}
}