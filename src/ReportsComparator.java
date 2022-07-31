import java.util.ArrayList;

public class ReportsComparator {//TODO перенести в этот класс вызов всех методов из майн создавать в этом классе все экземпляры объектов классов репортов и здесь работать с инфой в памяти
    ArrayList<YearLine> yearReport= new ArrayList<>();
    ArrayList<MonthlyReport> rows = new ArrayList<>();

    public void compare () {
        this.yearReport = yearReport;
        this.rows = rows;
        System.out.println(yearReport);
            /*if(!line.isExpense) {
                System.out.println("Прибыль за " + line.month + "-й месяц: " + line.amount);
            } else if (line.isExpense) {
                System.out.println("Расходы за " + line.month + "-й месяц: " + line.amount);
            }*/
    }

    public void compare() {
    }
}
