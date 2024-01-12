package in.cdac.epramaan.mainTest;
import java.io.*;

public class ObjectToFileExample {
    public static void main(String[] args) {
        // Create an instance of your object
        MyClass object = new MyClass("John Doe", 25);

        // Specify the file path to write the object
        String filePath = "C:\\Users\\CDAC-HP80\\Desktop\\file.txt";

        try {
            // Create a FileOutputStream to write the object to the file
            FileOutputStream fileOut = new FileOutputStream(filePath);

            // Create an ObjectOutputStream to serialize the object
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            // Write the object to the ObjectOutputStream
            objectOut.writeObject(object);

            // Close the streams
            objectOut.close();
            fileOut.close();

            System.out.println("Object has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Define your class to be serialized
class MyClass implements Serializable {
    private String name;
    private int age;

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and setter methods for the class properties
    // ...
}
