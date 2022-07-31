import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        String userInput = scanner.nextLine();
        ReportsComparator reportsComparator= new ReportsComparator();

        while (!userInput.equals("exit")) {
            if (userInput.equals("1")) {
                reportsComparator.monthlyReport = new MonthlyReport();
                System.out.println("Месячные отчеты считаны.");
            } else if (userInput.equals("2")) {
                reportsComparator.yearlyReport = new YearlyReport();
                System.out.println("Годовой отчет считан.");
            } else if (userInput.equals("3")) {
                System.out.println("Сверка данных:");
                reportsComparator.comparator();
            } else if (userInput.equals("4")) {
                System.out.println("Отчет по месяцам:");
                reportsComparator.printMonthlyReport();
            } else if (userInput.equals("5")) {
                reportsComparator.printYearlyReport();
            }  else {
                System.out.println("Такой команды нет");
            }
            if (userInput.equals("exit")) {
                System.out.println("Выход");
                break;
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

