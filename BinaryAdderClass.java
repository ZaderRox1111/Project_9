package p9_package;

public class BinaryAdderClass
   {
      //creating the constants
      private final int BASE_TWO = 2;
      private final int DEFAULT_CAPACITY = 50;
      private final char SPACE = ' ';
      
      //creating the variables
      private int[] bitArray;
      int numBits;
      
      /*
      Name: BinaryAdderClass
      Process: default constructor - create empty array, set numBits to 0
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
     */
      //default constructor
      public BinaryAdderClass() 
         {
            //set empty numBits and array
            this.numBits = 0;
            this.bitArray = new int[this.numBits];
         }
      
      /*
      Name: BinaryAdderClass
      Process: Initialization constructor - set array with binary values with numBits
      Method Input/Parameters: decimalValue (int)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
     */
      public BinaryAdderClass(int decimalValue) 
         {
            //convert the value to binary array, store as this objects bit array
            this.bitArray = convertToBinary(decimalValue);
         }
      
      /*
      Name: BinaryAdderClass
      Process: copy constructor - copies another BinaryAdderClass into this one
      Method Input/Parameters: copied (BinaryAdderClass)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
     */
      public BinaryAdderClass(BinaryAdderClass copied) 
         {
            this.numBits = copied.numBits;
            this.bitArray = copied.bitArray;
         }
      
      /*
      Name: addValue
      Process: add value to this object using decimal value
      Method Input/Parameters: decimalValue (int)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: BinaryAdderClass
     */
      public void addValue(int decimalValue) 
         {
            //create variables
            BinaryAdderClass addend = new BinaryAdderClass(decimalValue);
            
            //find the longer bit array
            int maxValue = findMax(this.numBits, addend.numBits);
            
            //sum array
            int[] sum = new int[maxValue + 1];
            int index = 0;
            int carry = 0;
            
            //loop over the longest length, adding each bit/carry to the sum as applicable
            while (index < maxValue) 
               {
                  //loop
                  
                  //create variables for the bitArrays at the index
                  int bitFirst, bitSecond, sumHere;
                  int bitAddition = 0;
                  
                  bitFirst = this.bitArray[index];
                  bitSecond = addend.bitArray[index];
                  
                  //add carry
                  bitAddition += carry;
                  
                  //check the first object, if there is a bit at the index
                  if (index < this.numBits) 
                     {
                        bitAddition += bitFirst;
                     }
                  
                  //check the second object
                  if (index < addend.numBits) 
                     {
                        bitAddition += bitSecond;
                     }

                  //add all values at the index together then use % to get a 0 or 1
                  //Update the carry value as well
                  sumHere = (bitAddition) % BASE_TWO;
                  carry = (bitAddition) / BASE_TWO;
                  
                  //set the sum at index as the calculated bit
                  sum[index] = sumHere;
                  
                  //update the index
                  index++;
                  
                  //end loop
               }
            
            //set the numBits equal to the sum length
            this.numBits = maxValue;
            
            //check if the carry is equal to 1 after the sum
            //if so, add the 1 to the sum
            //set the numBits equal to the total length if there is a carry 1
            if (carry == 1) 
               {
                  sum[index] = carry;
                  this.numBits = maxValue + 1;
               }

            //setting the bitArray equal to the sum
            this.bitArray = sum;
         }
      
      /*
      Name: addValue
      Process: add value to this object using another object
      Method Input/Parameters: BinaryAdderClass object (BinaryAdderClass)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: BinaryAdderClass
     */
      public void addValue(BinaryAdderClass addend) 
         {
            //create variables
            
            //find the longer bit array
            int maxValue = findMax(this.numBits, addend.numBits);
            
            //sum array
            int[] sum = new int[maxValue + 1];
            int index = 0;
            int carry = 0;
            
            //loop over the longest length, adding each bit/carry to the sum as applicable
            while (index < maxValue) 
               {
                  //loop
                  
                  //create variables for the bitArrays at the index
                  int bitFirst, bitSecond, sumHere;
                  int bitAddition = 0;
                  
                  bitFirst = this.bitArray[index];
                  bitSecond = addend.bitArray[index];
                  
                  //add carry
                  bitAddition += carry;
                  
                  //check the first object, if there is a bit at the index
                  if (index < this.numBits) 
                     {
                        bitAddition += bitFirst;
                     }
                  
                  //check the second object
                  if (index < addend.numBits) 
                     {
                        bitAddition += bitSecond;
                     }

                  //add all values at the index together then use % to get a 0 or 1
                  //Update the carry value as well
                  sumHere = (bitAddition) % BASE_TWO;
                  carry = (bitAddition) / BASE_TWO;
                  
                  //set the sum at index as the calculated bit
                  sum[index] = sumHere;
                  
                  //update the index
                  index++;
                  
                  //end loop
               }
            
            //set the numBits equal to the sum length
            this.numBits = maxValue;
            
            //check if the carry is equal to 1 after the sum
            //if so, add the 1 to the sum
            //set the numBits equal to the total length if there is a carry 1
            if (carry == 1) 
               {
                  sum[index] = carry;
                  this.numBits = maxValue + 1;
               }

            //setting the bitArray equal to the sum
            this.bitArray = sum;
         }
      
      /*
      Name: convertToBinary
      Process: converts decimal value into binary array, LSD at index 0
      Method Input/Parameters: decimalValue (int)
      Method Output/Parameters: none
      Method Output/Returned: converted binary array (int[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: BinaryAdderClass
     */
      private int[] convertToBinary(int decimalValue) 
         {
            //create variables
            int[] binary = new int[DEFAULT_CAPACITY];
            int index = 0;
            int value = decimalValue;
            
            //using a while loop to go through the bits until the value is converted
            while (value > 0) 
               {
                  binary[index] = value % BASE_TWO;
                  value = value / BASE_TWO;
                  index++;
               }
            
            //set numBits as the final index, the correct amount
            this.numBits = index;
            
            //return the binary array
            return binary;
         }
      
      /*
      Name: displayBits
      Process: displays the bits with block-right justification
      Method Input/Parameters: blockSize (int)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: bits
      Dependencies: BinaryAdderClass
     */
      public void displayBits(int blockSize) 
         {
            //create variables
            int preSpace = 0;
            int bitSize = this.numBits;
            int index;
            
            //determine how many spaces to put before the bits
            preSpace = blockSize - bitSize;
            
            //print out the spaces
            displayChars(preSpace, SPACE);
            
            //use a backwards for loop to go over the bits in reverse order
            //in order to have it in the correct direction
            //set the index at the HSD -> the furthest right in the array
            for (index = bitSize - 1; index >= 0; index--) 
               {
                  //print out each bit in a row, backwards
                  System.out.print(this.bitArray[index]);
               }
            
            //print out a new line
            System.out.println();
         }
      
      /*
      Name: displayChars
      Process: display characters using recursion
      Method Input/Parameters: numChars (int), outChar (char)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: characters
      Dependencies: BinaryAdderClass
     */
      public void displayChars(int numChars, char outChar) 
         {
            //create variables
            int index;
            
            //use a for loop over the number of chars printing out the outChar
            for (index = 0; index < numChars; index++) 
               {
                  System.out.print(outChar);
               }
         }
      
      /*
      Name: findMax
      Process: finds the max of two values
      Method Input/Parameters: valOne (int), valTwo (int)
      Method Output/Parameters: none
      Method Output/Returned: larger value
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: BinaryAdderClass
     */
      private int findMax(int valOne, int valOther) 
         {
            //create variables
            int max = 0;
            
            //checks to see if the first value is bigger
            //if so, it is set as the max
            //otherwise the second value is bigger than or equal to the first
            //so the second value is set as the max
            if (valOne > valOther) 
               {
                  max = valOne;
               }
            else 
               {
                  max = valOther;
               }
            
            //return the max
            return max;
         }
      
      /*
      Name: toString
      Process: converts to string
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: string representation of array bits
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: BinaryAdderClass
     */
      @Override
      public String toString() 
         {
            //create variables
            String finalStr = "";
            int index, currentBitNum;
            char currentBit;
            
            //loop through the bit array, cast the bit to a char, then add it to the final string
            //loop through backwards, like in displayBits method
            for (index = this.numBits - 1; index >= 0; index--) 
               {
                  //store the values for each, then cast the int bit to a character
                  currentBitNum = this.bitArray[index];
                  currentBit = (char) (currentBitNum + '0');
                  
                  //concatenate the bit to the final string
                  finalStr += currentBit;
               }
            
            //return the final string
            return finalStr;
         }
   }
