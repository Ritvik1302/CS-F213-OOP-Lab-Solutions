/********************** IMPORTANT INSTRUCTIONS **************************
* 1. You are not allowed to import new classes or packages.
* 2. You are not allowed to declare new methods.
* 3. You are not allowed to declare new instance variables.
* 4. You are allowed to declare local variables inside the methods.
*************************************************************************/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class CBTSoln2024 {

    public static void main(String[] args) {
        try {
            
        	// Read matrix from file
            int[][] matrix = readMatrixFromFile("F:\\input_cbt_ss_23_24.txt");
            
            if (matrix == null) {
                System.out.println("Failed to read matrix from file.");
                return;
            }

            // Count clumps in rows using multiple threads
            List<List<Integer>> rowClumps = countRowClumpsMultithreaded(matrix);

            // Calculate total row clump count
            int rowClumpCount = rowClumps.size();

            // Output file path for writing results
            String outputFile = "F:\\output_cbt_ss_23_24.txt";

            // Write row clump count and details to output file
            writeOutputToFile(outputFile, rowClumpCount, rowClumps);

            // Display completion message
            System.out.println("Row clump count and details written to file: " + outputFile);
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }

    /**************************** Q.1 WRITE CODE FOR THIS METHOD *********************************
	 * The readMatrixFromFile method is designed to read an n x n matrix of integers from a 
	 * specified input file (filename). This method is responsible for handling file input 
	 * operations and populating a 2D integer array (matrix) with the matrix elements retrieved 
	 * from the file. The process begins by initializing variables for file input (FileInputStream 
	 * and Scanner) to open and read from the input file. Within a try block, the method attempts 
	 * to open the file (filename) using FileInputStream and create a Scanner to parse the file 
	 * contents. The first integer read by the Scanner represents the size (n) of the matrix, 
	 * which determines the dimensions of the square matrix (n x n). The method then proceeds to 
	 * iterate through each row and column of the matrix, reading integer values from the file 
	 * and populating the corresponding elements of the matrix array. If the file does not 
	 * contain sufficient or valid data to populate the matrix (hasNextInt() returns false 
	 * unexpectedly), an error message is displayed, and the method returns null to indicate 
	 * failure. Finally, the method ensures proper resource management by closing the 
	 * Scanner and FileInputStream within a finally block, ensuring that file resources are 
	 * released regardless of whether the file reading operation was successful or encountered 
	 * an error. 																	[10 MARKS]
	 ********************************************************************************************/
    private static int[][] readMatrixFromFile(String filename) throws FileNotFoundException, InterruptedException {

    	int[][] matrix = null;
    	
        /**
         * WRITE YOUR CODE HERE
         */
    	int n;
    	//Declare The Scanner Instance
    	Scanner in;
		try {
			//Initialize The Scanner Instance on the given filename
			in = new Scanner(new FileInputStream(filename));
			{
				//Input matrix size from file
				n = in.nextInt();
				//Initialize the matrix with the given size
				matrix = new int[n][n];
				//Loop Until N*N elements are read
				try {
					for(int i=0;i<n;i++){
						for(int j=0;j<n;j++){
							matrix[i][j] = in.nextInt();
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Close the Scanner
				in.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
        return matrix;
    }

    /**************************** Q.2 WRITE CODE FOR THIS METHOD *********************************
	 * The countRowClumpsMultithreaded method orchestrates concurrent clump detection 
     * within an n x n matrix by initializing a list (rowClumps) to store detected row 
     * clumps and creating an array of threads (threads) to handle clump detection for 
     * each row. Each thread is assigned a RowClumpCounter instance responsible for detecting 
     * clumps within a specific row of the matrix. After creating and starting threads for all rows, 
     * the method waits for all threads to complete (join()), ensuring that clump detection for 
     * all rows is finished before proceeding. Finally, the method returns the consolidated list 
     * of detected row clumps (rowClumps), leveraging multithreading to efficiently process clump 
     * detection across multiple matrix rows concurrently. The detailed clump detection logic is 
     * encapsulated within the RowClumpCounter class, enabling parallel execution of clump detection 
     * tasks and enhancing overall performance.
     * 																				[08 MARKS]
	 ********************************************************************************************/
    private static List<List<Integer>> countRowClumpsMultithreaded(int[][] matrix) throws Exception{
        
    	/**
    	 * WRITE YOUR CODE HERE
    	 */
    	//Declare the Lists and Threads
    	List<List<Integer>> rowClumps = new ArrayList<List<Integer>>();
    	ListIterator<List<Integer>> itr = rowClumps.listIterator();
    	Thread[] threads = new Thread[matrix[0].length];
    	
    	//Initialize and Run The Threads
    	for(int i=0;i<matrix[0].length;i++){
    		Runnable r = new RowClumpCounter(matrix, i, rowClumps);
    		threads[i] = new Thread(r);
    		threads[i].start();
    		itr.add(new ArrayList<Integer>());	
    	}
    	//Wait Until all the Threads have completed to return
    	for(int i=0;i<matrix[0].length;i++){
        	try {
				threads[i].join(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        return rowClumps; //return appropriate variable instead of null
    }

    /**************************** Q.3 WRITE CODE FOR THIS METHOD *********************************
   	 * The RowClumpCounter class encapsulates the logic for detecting clumps within 
     * a specific row of an n x n matrix. When instantiated as a Runnable task and 
     * executed by a thread within the countRowClumpsMultithreaded method, each RowClumpCounter 
     * instance is responsible for iterating over the elements of its assigned row to identify 
     * and record clumps. A clump is defined as a sequence of two or more consecutive identical 
     * elements within the row. The run method of RowClumpCounter traverses the row, maintains 
     * state to track the current clump (if any), and utilizes synchronization to safely update 
     * the shared rowClumps list with detected clumps. Upon completion of the clump detection 
     * process for its assigned row, the RowClumpCounter instance ensures that any ongoing clump 
     * is properly recorded before terminating.										   
     * 																				[15 MARKS] 
     ********************************************************************************************/
	private static class RowClumpCounter implements Runnable {

		private final int[][] matrix;
		private final int rowIndex;
		private final List<List<Integer>> rowClumps;

		public RowClumpCounter(int[][] matrix, int rowIndex, List<List<Integer>> rowClumps) {
			this.matrix = matrix;
			this.rowIndex = rowIndex;
			this.rowClumps = rowClumps;
		}

		public void run() {
			/**
			 * WRITE YOUR CODE HERE
			 */
			//Take Lock on the rowClumps Object to ensure Synchronization
			synchronized (rowClumps) {
				
				//Downcast the List To An ArrayList to Provide Random Access
				ArrayList<List<Integer>> al = (ArrayList<List<Integer>>)rowClumps;
				
				//Check the Given Row to find Clumps
				for (int i = 1; i < matrix[0].length; i++) {
					//If an element is not equal to the previous element, move ahead
					if (matrix[rowIndex][i] != matrix[rowIndex][i - 1]) {
						continue;
					}
					//If The Element is equal to its previous element, a clump is found and we
					// keep moving to get the number of elements in that clump
					else {
						al.get(rowIndex).add(matrix[rowIndex][i - 1]);
						while (i < matrix[0].length
								&& matrix[rowIndex][i] == matrix[rowIndex][i - 1]) {
							al.get(rowIndex).add(matrix[rowIndex][i]);
							i++;
						}
					}
				}
				//Notify the Other Threads That the Thread is finished
				rowClumps.notifyAll();
			}
		}
	}

    /**************************** Q.4 WRITE CODE FOR THIS METHOD *********************************
   	 * The writeOutputToFile method is responsible for writing the results of row clump 
   	 * detection to an output file specified by filename. This method takes as input parameters 
   	 * the output file path (filename), the total count of detected row clumps (rowClumpCount), 
   	 * and the details of each detected row clump (rowClumps). Within the method, a PrintWriter 
   	 * is used to write formatted output to the specified file. The method begins by opening the 
   	 * output file for writing, then proceeds to write the total count of row clumps followed by 
   	 * a blank line for readability. Subsequently, a loop iterates over each detected row clump, 
   	 * extracting the clump details from the rowClumps list and formatting them appropriately 
   	 * before writing them to the output file. Each row clump is labeled with its index and 
   	 * presented in a readable format. Finally, the method ensures proper resource management 
   	 * by automatically closing the PrintWriter upon completion of writing, ensuring that the 
   	 * output file is updated and saved with the detected row clump information. 
   	 * 																				[07 MARKS]
   	 ********************************************************************************************/
     private static void writeOutputToFile(String filename, int rowClumpCount, List<List<Integer>> rowClumps) {
     
    	/**
    	 * WRITE YOUR CODE HERE
    	 */
    	 try {
    		 //Initialize the PrintWriter Instance With The Given Filename
 			PrintWriter out = new PrintWriter(new File(filename));
 			
 			//Check if any of the lists is empty to modify the clump Count
 			ListIterator<List<Integer>> itr1 = rowClumps.listIterator();
 			while(itr1.hasNext()){
 				if(itr1.next().isEmpty()){
 					rowClumpCount--;
 				}
 			}
 			//Print the Number of Clumps
 			out.println("Number of row clumps: "+rowClumpCount);
 			
 			//Print the empty line for readability
 			out.println("");
 			
 			//Iterate over the list to print the clump to the file
 			int i = 1;
 			
 			//Initialize the List Iterator
 			ListIterator<List<Integer>> itr = rowClumps.listIterator();
 			
 			//Iterate over the list to print the details of the clumps, if they exist in that row
 			while(itr.hasNext()){
 				List<Integer> clump= itr.next();
 				//If No Clumps are there print the specific line
 				if(clump.isEmpty()){
 					out.println("Row Clump "+(i)+ ": " +"No clumps detected");
 				}
 				//Print the clump details
 				else{
 				out.println("Row Clump "+(i)+ ": " +clump);
 				}
 				i++;
 			}
 			//Close the Print Writer to successfully write into the file
 			out.close();
 		}
    	 //Handle File Not Found Exception
    	 catch (FileNotFoundException e) {
 			System.out.println("File Not Found");
 		}
     }
}
