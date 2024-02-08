import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class arrayAddressCalcC {
    public static void main(String args[]) {
        Scanner acceptInput = new Scanner(System.in);

        // Initialize variables
        int numOfDim;
        long alpha, esize, numOfEle, location; // 'long' to avoid int overflow
        int[] upperBounds, index;
        String definedMode, definedType, definedBounds, findIndex;
        String[] boundsArr, indexArr;
        
        // Welcome
        System.out.println("Address Calculator (v.1.1)\n-----------<+>------------\n");

        // Get amount of Dimensions
        System.out.print("Number of dimensions: ");
        numOfDim = acceptInput.nextInt();
        System.out.println();

        // Get Upper Bounds
        upperBounds = new int[numOfDim];
        System.out.print("Upperbounds (Comma-separated): ");
        definedBounds = acceptInput.next();
        boundsArr = definedBounds.split(",");
        for (int i = 0; i < numOfDim; i++) {
            upperBounds[i] = Integer.parseInt(boundsArr[i]);
        }
        System.out.println();

        // Get ESize
        esize = 0;

        System.out.print("Data Type / ESize: ");
        definedType = acceptInput.next();
        // if number, that is esize. else, refer to fetchtype
        try {
            esize = Long.parseLong(definedType);
        } catch (NumberFormatException e) {
            esize = fetchTypeESize(definedType);
        }
        System.out.println();

        // Get Starting Address
        System.out.print("Starting Address: ");
        alpha = acceptInput.nextLong();
        System.out.println();

        // Initialize HashMap to store addresses
        Map<String, Long> addressMap = new HashMap<>();

        // Store addresses in the Map
        storeAddresses(numOfDim, upperBounds, alpha, esize, addressMap);

        System.out.println("\n==========================\nINITIALIZATION COMPLETE...\n==========================\n");

        // Display number of elements
        numOfEle = countElements(numOfDim, upperBounds);
        System.out.println("TOTAL ELEMENT COUNT: " + numOfEle);
        
        // Display element size
        System.out.println("TOTAL ELEMENT SIZE (esize): " + esize + " Bytes");
        System.out.println();

        index = new int[numOfDim];

        // Get index of element to search
        System.out.print("Find address of index (Comma-separated): ");
        findIndex = acceptInput.next();
        indexArr = findIndex.split(",");
        for (int i = 0; i < numOfDim; i++) {
            // this loop does not count towards the search function, it just for casting the string input into an int array
            index[i] = Integer.parseInt(indexArr[i]);
        }
        System.out.println();

        // Use the HashMap to find the address
        String indexKey = createIndexKey(index);
        location = addressMap.get(indexKey);

        System.out.println("Address of index: " + location);
        System.out.println();

        acceptInput.close();
    }

    private static long fetchTypeESize(String type) {
        switch (type) {
            // based on module
            case "char":
                return 1;
            case "int":
                return 2;
            case "float":
                return 4;
            case "double":
                return 8;

            default:
                return 0;
        }
    }

    private static long countElements(int dim, int[] ub) {
        long amount = 1;
        // multiplies all the upper bounds together
        for (int i = 0; i < dim; i++) {
            amount *= ub[i];
        }
        return amount;
    }

    private static long calculateAddress(int dim, int[] ub, long alpha, long esize, int[] index) {
        long address = alpha;
        long multiplier = 1;

        for (int i = dim - 1; i >= 0; i--) {
            address += multiplier * index[i] * esize;
            multiplier *= ub[i];
        }

        return address;
    }

    private static String createIndexKey(int[] index) {
        StringBuilder keyBuilder = new StringBuilder();
        for (int i : index) {
            keyBuilder.append(i).append("_");
        }
        return keyBuilder.toString();
    }

    private static void storeAddresses(int dim, int[] ub, long alpha, long esize, Map<String, Long> addressMap) {
        int[] index = new int[dim];
        storeAddressesRecursive(dim, ub, alpha, esize, index, addressMap, 0, "");
    }

    private static void storeAddressesRecursive(int dim, int[] ub, long alpha, long esize, int[] index,
            Map<String, Long> addressMap, int level, String keyPrefix) {
        if (level == dim) {
            long address = calculateAddress(dim, ub, alpha, esize, index);
            addressMap.put(keyPrefix, address);
            return;
        }

        for (int i = 0; i < ub[level]; i++) {
            index[level] = i;
            String key = keyPrefix + i + "_";
            storeAddressesRecursive(dim, ub, alpha, esize, index, addressMap, level + 1, key);
        }
    }
}
