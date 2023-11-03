import java.util.Map;

public class Main {
    public static void changeLastRow(double[][] array, double[] newValues) {
        if (array.length < 1 || newValues.length != array[0].length) {
            // Перевірка на наявність рядків у масиві та на відповідність розмірів
            System.out.println("Неправильна кількість рядків у масиві або неправильна кількість нових значень.");
            return;
        }

        int lastRowIndex = array.length - 1;
        array[lastRowIndex] = newValues;
    }

    public static void swapLastTwoRows(double[][] array) {
        if (array.length < 2) {
            // Якщо масив має менше двох рядків, немає рядків для обміну.
            System.out.println("Недостатньо рядків для обміну.");
            return;
        }

        int lastRowIndex = array.length - 1;
        int secondLastRowIndex = array.length - 2;

        double[] tempRow = array[lastRowIndex];
        array[lastRowIndex] = array[secondLastRowIndex];
        array[secondLastRowIndex] = tempRow;
    }
    private static double[] convertMapResultToArray(Map<String, Double> resultMap, int unknown){
        int arraySize = resultMap.size();
        double[] resultArray = new double[arraySize];
        for(int i = 0; i < resultMap.size() - 1; i++){
            if(i < unknown){
                resultArray[i] = resultMap.get("x" + (i + 1)) == null ? 0.0 : resultMap.get("x" + (i + 1));
            }else {
                resultArray[i] = resultMap.get("y" + (i - unknown + 1)) == null ? 0.0 : resultMap.get("y" + (i - unknown + 1));
            }
        }
        resultArray[arraySize - 1] = resultMap.get("F");
        return resultArray;
    }
    public static void main(String[] args) {
        final SimplexMethod simplexMethod = new SimplexMethod();
        double [][] table = {
                {2,   1,-1, 0, 0,  2},
                {1,  -2, 0, 3, 0,  4},
                {-1,  2, 0, 0,-1,  4}};
        double[][] table1= Canon.result(table, table.length, table[0].length);
        double [] con = {0,0,0,0,0,0};
        double[][] newTable = new double[table.length + 1][table[0].length];
        // Копіювання існуючого масиву `table` в новий масив `newTable`
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(table[i], 0, newTable[i], 0, table[i].length);
        }
        System.arraycopy(con, 0, newTable[newTable.length-1], 0, con.length-1);
        table = newTable;
        double[] newFun = { 1,  4,-4, 0, 0,  0};
        changeLastRow(table,newFun);
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        Map<String, Double> result = simplexMethod.doMethod(table, 2);
        System.out.println(result);
        double[] converted = convertMapResultToArray(result, 2);
        // Створення нового масиву з розширеним розміром
        double[][] newTable1 = new double[table.length + 1][table[0].length];
        // Копіювання існуючого масиву `table` в новий масив `newTable`
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(table[i], 0, newTable1[i], 0, table[i].length);
        }
        System.arraycopy(converted, 0, newTable1[newTable1.length-1], 0, converted.length-1);
        newTable1[newTable1.length-1][5] = converted[5];
        table = newTable1;
        swapLastTwoRows(table);
        double[] newFun1 = {1,3,-2,0,0,0};
        changeLastRow(table,newFun1);
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println(); // Перехід на новий рядок після виведення всіх стовпців в рядку
        }
        //2
        Map<String, Double> result1 = simplexMethod.doMethod(table, 2);
        System.out.println(result1);
        double[] converted1 = convertMapResultToArray(result1, 2);
        // Створення нового масиву з розширеним розміром
        double[][] newTable2 = new double[table.length + 1][table[0].length];
        // Копіювання існуючого масиву `table` в новий масив `newTable`
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(table[i], 0, newTable2[i], 0, table[i].length);
        }
        System.arraycopy(converted1, 0, newTable2[newTable2.length-1], 0, converted1.length-1);
        newTable2[newTable2.length-1][5] = converted1[5];
        table = newTable2;
        swapLastTwoRows(table);
        double[] newFun2 = {-2,1,4,0,0,0};
        changeLastRow(table,newFun2);
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println(); // Перехід на новий рядок після виведення всіх стовпців в рядку
        }

        Map<String, Double> result3 = simplexMethod.doMethod(table, 2);
        System.out.println(result);


    }

}