import java.util.ArrayList;

public class ReportsComparator {

    MonthlyReport monthlyReport = new MonthlyReport();
    YearlyReport yearlyReport = new YearlyReport();
    ArrayList<ArrayList> yearReports = new ArrayList<>();
    ArrayList<ArrayList<Integer>> monthReports = new ArrayList<ArrayList<Integer>>();

    public void printYearlyReport() {
        yearlyReport.printReport();
    }

    public void printMonthlyReport() {
        monthlyReport.printReport();
    }

    public void comparator() {//в метод передаются два списка: за месяц и за год, каждый из которых содержит по два списка: все доходы и все траты
        yearlyReport.makeReports(this.yearReports);
        monthlyReport.makeReports(this.monthReports);
        ArrayList<ArrayList> yearReport = new ArrayList<>();
        ArrayList<ArrayList> monthReport = new ArrayList<>();
        String[] monthNames = {"Январь", "Февраль", "Март"};
        for (int i = 0; i < monthReports.size(); i++) {//списки распаковываются
            yearReport.add(yearReports.get(i));
            monthReport.add(monthReports.get(i));
        }
        ArrayList<Integer> yearProfits = yearReport.get(0);
        ArrayList<Integer> monthProfits = monthReport.get(0);
        ArrayList<Integer> yearExpenses = yearReport.get(1);
        ArrayList<Integer> monthExpenses = monthReport.get(1);
        ArrayList<String> difference = new ArrayList<>();
            for (int k = 0; k < monthNames.length; k++) {//каждые трата и доход списка за месяц сравниваются с тратой и доходом за этот месяц из списков за год
                int yearProfit = yearProfits.get(k);
                int monthProfit = monthProfits.get(k);
                int yearExpense = yearExpenses.get(k);
                int monthExpense = monthExpenses.get(k);
                if (!(yearProfit == monthProfit) || !(yearExpense == monthExpense)) {
                    difference.add(monthNames[k]);
                }
            }
            if (difference.isEmpty()) {
                System.out.println("Сверка прошла успешно. Расхождений нет");
            } else {
                System.out.println("Расхождение за " + difference);
            }
        }
    }