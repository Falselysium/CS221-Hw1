import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.application.Application; 
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.scene.*;


// Canvas cv= new Canvas(800,600);
//         GraphicsContext gc = cv.getGraphicsContext2D();
//         MyColor test = MyColor.Red;
//         System.out.println(test.getColor());
public class App extends Application {
    @Override
    public void start(Stage stage) {
        // MyColor test = MyColor.Red;
        Group root = new Group();
        stage.setTitle("Hello World!");
        Canvas cv = new Canvas(800,600);
        GraphicsContext gc = cv.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fillOval(100, 200, 100, 150);
        gc.setFill(Color.BLUE);
        gc.fillOval(150, 200, 100, 150);
        gc.setFill(Color.GREEN);
        gc.fillOval(200, 100, 100, 250);
        gc.setFill(Color.YELLOW);
        gc.fillOval(250, 200, 100, 150);
        gc.setFill(Color.ORANGE);
        gc.fillOval(300, 200, 100, 150);

        root.getChildren().add(cv); //add Canvas to the group root
        stage.setScene(new Scene(root)); //creates Scene from the group root
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

class MyPoint{
    private int x;
    private int y;
    public MyPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){return x;}
    public int getY(){return y;}

    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
}

enum MyColor{
    Red(255,0,0,255),
 	Lime(0,255,0,255),
 	Blue(0,0,255,255),
 	Yellow(255,255,0,255),
 	Cyan(0,255,255,255),
 	Magenta(255,0,255,255),
 	Silver(192,192,192,255),
 	Gray(128,128,128,255);
    
    private int r;
    private int g;
    private int b;
    private int a;
    private int rgba;
    MyColor(int r, int g, int b, int a){
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        this.rgba = (a << 24) & 0xFF000000 | (r << 16) & 0x00FF0000 | (g << 8) & 0x0000FF00| (b << 0) & 0x000000FF;
    }
    public int getR(){return r;}
    public int getG(){return g;}
    public int getB(){return b;}
    public int getA(){return a;}
    public Color getColor(){return Color.rgb(r,g,b,a/255.0);}
    public String getRGBA(){return "#" + Integer.toHexString(rgba).toUpperCase();}
    
    

}

class MyShape{
    MyPoint point;
    MyColor color;

    MyShape(MyPoint p, MyColor c){
        this.point = p;
        this.color = c;
    }

    MyShape(int x_value, int y_value, MyColor z){
        this.point = new MyPoint(x_value, y_value);
        //this.color = new MyColor(z);
    }
    
    public int getX(){return point.getX();}
    public int getY(){return point.getY();}
    //public Color getColor(){return color.getColor();}

    public int area(){ return 0;}
    public int perimeter(){ return 0;}

    public String toString(){return "This is my Shape";}
}
