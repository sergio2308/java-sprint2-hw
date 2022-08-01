import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        String userInput = scanner.nextLine();
        ReportsComparator reportsComparator = new ReportsComparator();

        while (!userInput.equals("exit")) {
            switch (userInput) {
                case "1":
                    reportsComparator.monthlyReport = new MonthlyReport();
                    System.out.println("Месячные отчеты считаны.");
                    break;
                case "2":
                    reportsComparator.yearlyReport = new YearlyReport();
                    System.out.println("Годовой отчет считан.");
                    break;
                case "3":
                    System.out.println("Сверка данных:");
                    reportsComparator.comparator();
                    break;
                case "4":
                    System.out.println("Отчет по месяцам:");
                    reportsComparator.printMonthlyReport();
                    break;
                case "5":
                    reportsComparator.printYearlyReport();
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
