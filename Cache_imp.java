import java.util.*;
public class Cache_imp {
	
	public static void main(String [] args)
	{
		HashMap<String, Integer>[][] data = new HashMap[3][3]; // 3x3 2D array of HashMap

        // Populate the 2D array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                data[i][j] = new HashMap<>();
                data[i][j].put("Key" + i + j, (i + 1) * (j + 1)); // Example data
            }
        }

        // Print the 2D array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Element at (" + i + ", " + j + "):");
                HashMap<String, Integer> element = data[i][j];
                for (String key : element.keySet()) {
                    Integer value = element.get(key);
                    System.out.println("  Key: " + key + ", Value: " + value);
                }
            }
        }
	}
}
