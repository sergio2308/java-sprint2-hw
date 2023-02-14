import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class YearlyReport { 
    ArrayList<YearLine> yearlyReport= new ArrayList<>();

    public YearlyReport() {
        String path = "resources/y.2021.csv";
        String content = readFileContentsOrNull(path);
        String[] lines = content.split("\r?\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            yearlyReport.add(new YearLine(month, amount, isExpense));
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
        System.out.println("Годовой отчет за " + "2021" + " год:");
        System.out.println();
        int monthProfit = 0;
        ArrayList<Integer> profits = new ArrayList<>();
        ArrayList<Integer> expenses = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (YearLine line : yearlyReport) {
                if (!line.isExpense) {
                    profits.add(line.amount);
                } else {
                    expenses.add(line.amount);
                }
            }
            monthProfit = profits.get(i) - expenses.get(i);
            System.out.println("Прибыль за " + (i + 1) + "-й месяц: " + monthProfit);
        }
        int expenseSum = 0;
        for (Integer expense : expenses) {
            expenseSum += expense;
        }
        System.out.println();
        System.out.println("Средний расход за все месяцы составил: " + expenseSum / expenses.size());
        int profitSum = 0;
        for (Integer profit : profits) {
            profitSum += profit;
        }
        System.out.println("Средний доход за все месяцы составил: " + profitSum / profits.size());
    }

    public ArrayList<ArrayList> makeReports(ArrayList<ArrayList> yearReports) {//метод создает списки с доходами и расходами
        ArrayList<Integer> yearProfits = new ArrayList<>();
        ArrayList<Integer> yearExpenses = new ArrayList<>();
            for (YearLine line : yearlyReport) {
                if (!line.isExpense) {
                    yearProfits.add(line.amount);
                } else {
                    yearExpenses.add(line.amount);
                }
            }
        yearReports.add(yearProfits);
        yearReports.add(yearExpenses);
        return yearReports;
    }
}
