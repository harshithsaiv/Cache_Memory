import java.util.*;


//Step 1 : Creating the Main Memory 
//Step 2 : Taking input from the user then converting integer into binary and then hex
class CacheController
{
	static LinkedHashMap<String,Integer> MainMemory = new LinkedHashMap<>();
	static int data =10000;
	static LinkedHashMap<String,Integer>[][] cache = new LinkedHashMap[4][32];
	
	public static void MainMemory()
	{
		//implemented for only 30 pages there are in total of 2^20 pages
		for(int i=0;i<=122880;i+=32)
		{
			String hex_add="0x"+String.format("%08X", i);
			MainMemory.put(hex_add,data+=100);
		}
	}
	
	// this function takes the input from the user the page number and the set number
	public static String input(int page,int set)
	{
		//Converting the page number to binary
		String page_binary = Integer.toBinaryString(page);

        // Check the number of bits in the binary representation
        int binaryLength = page_binary.length();

        // Add leading zeros to make it 20 bits long
        if (binaryLength < 20) {
            int zerosToAdd = 20 - binaryLength;
            StringBuilder zeroPadding = new StringBuilder();
            for (int i = 0; i < zerosToAdd; i++) {
                zeroPadding.append("0");
            }
            page_binary = zeroPadding.toString() + page_binary;
        }
        
        //Converting the set number to binary
        String set_binary = Integer.toBinaryString(set);

        // Check the number of bits in the binary representation
        int setLength = set_binary.length();

        // Add leading zeros to make it 7 bits long
        if (setLength < 7) {
            int zerosToAdd = 7- setLength;
            StringBuilder zeroPadding = new StringBuilder();
            for (int i = 0; i < zerosToAdd; i++) {
                zeroPadding.append("0");
            }
            set_binary = zeroPadding.toString() + set_binary;
        }
        
        //adding the 5 bits of offset at the end of the 32 bit address
        // Assumption that the offset is always 00000 i.e we are reading from the starting
        String total_binary = page_binary+set_binary+"00000"; // adding the last 5 bits of offset
        System.out.println(total_binary);
        System.out.println(total_binary.length());// Checking the total count of the address
        
        // converting the 32 bit address to hexadecimal 
        while (total_binary.length() % 4 != 0) {
            total_binary = "0" + total_binary;
        }
        
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < total_binary.length(); i += 4) {
            String hexDigit = Integer.toHexString(Integer.parseInt(total_binary.substring(i, i + 4), 2));
            hex.append(hexDigit);
        }
        // Adding a prefix to the hexadecimal
        String hex_add= "0x"+hex;
        
        System.out.println(hex_add);
		return hex_add;

	}
	
	//cache implementation 
	public static void Cache()
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<32;j++)
			{
				cache[i][j]= new LinkedHashMap<>();
				//insertion here
			}
		}
		//Taking Sample Insertion
//		cache[3][3].put("0x00003060", 12000);
		// Printing cache
		for (int i = 0; i < 4; i++) {
		    for (int j = 0; j < 32; j++) {
		        System.out.println("Element at (" + i + ", " + j + "):");
		        HashMap<String, Integer> element = cache[i][j];
		        for (String key : element.keySet()) {
		            Integer value = element.get(key);
		            System.out.println("  Address: " + key + ", Data: " + value);
		        }
		    }
		}
		
	}
	
	public static void Cache_Check(String hex_addr)
	{
		boolean address_found=false;
		Loop:
		for (int i = 0; i < 4; i++) {
		    for (int j = 0; j < 32; j++) {
		        HashMap<String, Integer> element = cache[i][j];
		        if(element.containsKey(hex_addr))
		        {
		        	System.out.println(" Address: " + hex_addr + ", Data: " + element.get(hex_addr));
		        	address_found=true;
		        	break Loop;
		        }
		    }
		}
		if(address_found==false)
		{
			System.out.println("Hit miss , Data not in the cache going to main mempry to fetch");
		}
		
	}
	
	public static void main(String [] args)
	{
		MainMemory();
		System.out.println(MainMemory);
		String hex_addr= input(3,3);
		System.out.println(MainMemory.get(hex_addr));
		Cache();
		Cache_Check(hex_addr);
		
	}
}