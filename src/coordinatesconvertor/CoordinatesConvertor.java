package coordinatesconvertor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CoordinatesConvertor extends Application {
    
    @Override
    public void start(Stage primaryStage) { 
        GridPane grid1 = new GridPane();
        GridPane grid2 = new GridPane();
        GridPane grid3 = new GridPane();
        
        grid1.setPadding(new Insets(20));
        grid2.setPadding(new Insets(20));
        grid3.setPadding(new Insets(20));
        
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid3.setHgap(10);
        grid3.setVgap(10);
        
        HBox bottomButtons = new HBox(10);
        bottomButtons.setAlignment(Pos.BOTTOM_RIGHT);
        bottomButtons.setPadding(new Insets(10)); 
     
        TextField X_Txf = new TextField();
        TextField Y_Txf = new TextField();
        TextField Z_Txf = new TextField();
        
        TextField Rho_Txf = new TextField();
        TextField Phi_Txf = new TextField();
        TextField ZZ_Txf = new TextField();
        
        TextField R_Txf = new TextField();
        TextField Theta_Txf = new TextField();
        TextField Phii_Txf = new TextField();
           
        Button Btu_1 = new Button("Convert");
        Button Btu_2 = new Button("Convert");
        Button Btu_3 = new Button("Convert");
        Button Reset_Btn = new Button("Reset");
        Button Exit_Btn = new Button("Exit");
        
        Btu_1.setOnAction(e -> {
            double x = Double.parseDouble(X_Txf.getText());
            double y = Double.parseDouble(Y_Txf.getText());
            double z = Double.parseDouble(Z_Txf.getText());
            
            Cartesian c = new Cartesian(x, y, z);
            Cylendrical cyl = c.toCylindrical(c);
            Spherical s = c.toSpherical(c);
            
            Rho_Txf.setText(String.format("%.3f",cyl.getRho()));
            Phi_Txf.setText(String.format("%.3f",cyl.getPhi()));
            ZZ_Txf.setText(String.format("%.3f",cyl.getZ()));
            
            R_Txf.setText(String.format("%.3f",s.getR()));
            Theta_Txf.setText(String.format("%.3f",s.getTheta()));
            Phii_Txf.setText(String.format("%.3f",s.getPhi()));          
        });
        
        Btu_2.setOnAction(e -> {
            try {
            double rho = Double.parseDouble(Rho_Txf.getText());
            double phi = Double.parseDouble(Phi_Txf.getText());
            double zz= Double.parseDouble(ZZ_Txf.getText());
            
            Cylendrical cyl = new Cylendrical(rho, phi, zz);
            Cartesian c = cyl.toCartesian(cyl);
            Spherical s = cyl.toSpherical(cyl);
            
            X_Txf.setText(String.format("%.3f",c.getX()));
            Y_Txf.setText(String.format("%.3f",c.getY()));
            Z_Txf.setText(String.format("%.3f",c.getZ()));
            
            R_Txf.setText(String.format("%.3f",s.getR()));
            Theta_Txf.setText(String.format("%.3f",s.getTheta()));
            Phii_Txf.setText(String.format("%.3f",s.getPhi()));  
            } catch (NumberFormatException ex){
                showError("Please Enter numbers only");
            }
        });
  
        Btu_3.setOnAction(e -> {
            double r = Double.parseDouble(R_Txf.getText());
            double theta = Double.parseDouble(Theta_Txf.getText());
            double phi = Double.parseDouble(Phii_Txf.getText());
            
            Spherical s = new Spherical(r, theta, phi);
            Cartesian c = s.toCartesian(s);
            Cylendrical cyl = s.toCylindrical(s);
            
            X_Txf.setText(String.format("%.3f",c.getX()));
            Y_Txf.setText(String.format("%.3f",c.getY()));
            Z_Txf.setText(String.format("%.3f",c.getZ()));   
                        
            Rho_Txf.setText(String.format("%.3f",cyl.getRho()));
            Phi_Txf.setText(String.format("%.3f",cyl.getPhi()));
            ZZ_Txf.setText(String.format("%.3f",cyl.getZ()));                             
        });
        
        Reset_Btn.setOnAction(e -> {
            X_Txf.clear();
            Y_Txf.clear();
            Z_Txf.clear();

            Rho_Txf.clear();
            Phi_Txf.clear();
            ZZ_Txf.clear();

            R_Txf.clear();
            Theta_Txf.clear();
            Phii_Txf.clear();
        });
     
        Exit_Btn.setOnAction(e -> {
            System.exit(0);
        });
  
        grid1.add(new Label("Catesian"), 0, 0);
        grid1.add(new Label("X"), 0, 1);
        grid1.add(new Label("Y"), 0, 2);
        grid1.add(new Label("Z"), 0, 3);
        grid1.add(Btu_1, 1, 0);
        grid1.add(X_Txf, 1, 1);
        grid1.add(Y_Txf, 1, 2);
        grid1.add(Z_Txf, 1, 3);
        
        grid2.add(new Label("Cylendrical"), 0, 0);
        grid2.add( new Label("Rho"), 0, 1);
        grid2.add( new Label("Phi"), 0, 2);
        grid2.add( new Label("Z"), 0, 3);
        grid2.add(Btu_2, 1, 0);
        grid2.add(Rho_Txf, 1, 1);
        grid2.add(Phi_Txf, 1, 2);
        grid2.add(ZZ_Txf, 1, 3);
        
        grid3.add(new Label("Spherical"), 0, 0);
        grid3.add( new Label("R"), 0, 1);
        grid3.add( new Label("Theta"), 0, 2);
        grid3.add( new Label("Phi"), 0, 3);
        grid3.add(Btu_3, 1, 0);
        grid3.add(R_Txf, 1, 1);
        grid3.add(Theta_Txf, 1, 2);
        grid3.add(Phii_Txf, 1, 3);
        
        bottomButtons.getChildren().addAll(Reset_Btn,Exit_Btn);
           
        VBox v = new VBox(grid1 , grid2 , grid3, bottomButtons); 
        v.setSpacing(10);
        v.setPadding(new Insets(10));
      
        Scene scene = new Scene(v, 600, 650);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
    private void showError(String massage){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText(massage);
        alert.showAndWait();
    }
}
