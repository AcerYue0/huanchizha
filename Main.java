import java.util.*;      
public class Main{      
    public static void main(String[] args) {      
        Scanner scn = new Scanner(System.in);      
        String string = scn.nextLine();
        int arraySize = 16;
        for(int i = 1; i < 16; i++){
        	if(string.length() <= i * i){
        		arraySize = i;
        		break;
        	}
        }
        int charCount = 0;
        char[][] cArray = new char[arraySize][arraySize];
        for(int i = 0; i < arraySize; i++){
        	for(int j = 0; j < arraySize; j++){
        		int index = i * arraySize + j;
        		if(index <= string.length()){
        			cArray[i][j] = string.charAt(index);
        		}
        	}
        }
        for(int j = 0; j < arraySize; j++){
        	for(int i = 0; i < arraySize; i++){
        		if(j * arraySize + i < string.length()){
        			System.out.printf("%c", cArray[i][j]);
        		}
        	}
        }
        System.out.println();
    }  
}  