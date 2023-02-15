import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        String userInput = scanner.nextLine();
        ReportsComparator reportsComparator = new ReportsComparator();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        while (!userInput.equals("exit")) {
            switch (userInput) {
                case "1":
                    monthlyReport.readFromFile();
                    System.out.println("Месячные отчеты считаны.");
                    break;
                case "2":
                    yearlyReport.readFromFile();
                    System.out.println("Годовой отчет считан.");
                    break;
                case "3":
                    System.out.println("Сверка данных:");
                    reportsComparator.comparator(yearlyReport, monthlyReport);
                    break;
                case "4":
                    System.out.println("Отчет по месяцам:");
                    monthlyReport.printReport();
                    break;
                case "5":
                    yearlyReport.printReport();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Такой команды нет");
            }
            printMenu();
            userInput = scanner.nextLine();
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Какое действие вы хотите выполнить?");
        System.out.println("1 - Считать все месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить отчеты");
        System.out.println("4 - Вывести информацию о всех месячных отчетах");
        System.out.println("5 - Вывестии информацию о годовом отчете");
        System.out.println("exit - Выйти из программы");
    }
}
