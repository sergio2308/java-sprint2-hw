import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MonthlyReport {
    ArrayList<MonthLine> rows = new ArrayList<>();
    String[] monthNames = new String[3];

    public MonthlyReport() {
        for (int j = 1; j < 4; j++) {
            String path = "resources/m.20210" + j + ".csv";
            String content = readFileContentsOrNull(path);
            String[] lines = content.split("\r?\n");
            monthNames [0] = "Январь";
            monthNames [1] = "Февраль";
            monthNames [2] = "Март";
            for (int i = 1; i < lines.length; i++) {
                String line = lines[i];
                String[] parts = line.split(",");
                String monthName = monthNames[j - 1];
                String itemName = parts[0];
                boolean isExpense = Boolean.parseBoolean(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                rows.add(new MonthLine(monthName, itemName, isExpense, quantity, price));
            }
        }
    }

    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public void printReport() {
        System.out.println();
        for (int i = 0; i < monthNames.length; i++) {//итерации равные размеру массива имен месяцев, если в будущем будут добавлены новые csv-файлы за другие месяцы
            System.out.println(monthNames[i]);
            int profit = 0;
            int expense = 0;
            String profitName = "";
            String expenseName = "";
            for (MonthLine row : rows) {
                int maxExpense = row.quantity * row.price;
                if ((row.monthName.equals(monthNames[i])) && (!row.isExpense) && ((row.quantity * row.price) > profit)) {
                    profit = row.quantity * row.price;
                    profitName = row.itemName;
                } else if ((row.monthName.equals(monthNames[i])) && (row.isExpense) && ((row.quantity * row.price) <= maxExpense)) {
                    expense = maxExpense;
                    expenseName  = row.itemName;
                }

            }
            System.out.println("Самый прибыльный товар: " + profitName + " " + profit);
            System.out.println("Самая большая трата: " + expenseName + " " + expense);
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> makeReports(ArrayList<ArrayList<Integer>> monthReports) {//метод создает два списка: с доходами и расходами
        ArrayList<Integer> monthProfits = new ArrayList<>();
        ArrayList<Integer> monthExpenses = new ArrayList<>();
        for (int i = 0; i < monthNames.length; i++) {//здесь и в других местах я попытался учесть, что в будущем могут быть добавлены другие файлы с месячными отчетами
            int expenses = 0;
            int profits = 0;
            for (MonthLine line : rows) {
                int profit = 0;
                int expense = 0;
                if (!line.isExpense && line.monthName.equals(monthNames[i])) {
                    profit = line.quantity * line.price;
                } else if (line.isExpense && line.monthName.equals(monthNames[i])) {
                    expense = line.quantity * line.price;
                }
                profits += profit;
                expenses += expense;
            }
            monthProfits.add(i, profits);
            monthExpenses.add(i, expenses);
        }
        monthReports.add(monthProfits);
        monthReports.add(monthExpenses);
        return monthReports;
    }//из всех средств, которые мы изучили в курсе, у меня получилось передать уже считанные данные в другой класс и там распаковать таким путем
}
