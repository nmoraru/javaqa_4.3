import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CreditPaymentService cps = new CreditPaymentService();
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите, пожалуйста, необходимую сумму кредита. Доступны суммы кредита от 100 тыс до 5 млн руб");
        double creditMoney = Double.parseDouble(bis.readLine()); // сумма кредита

        System.out.println("На сколько лет Вы берете кредит? Доступны займы на 1, 2 и 3 года");
        double creditTermYear = Double.parseDouble(bis.readLine()); // срок кредита
        System.out.println("Укажите вид платежа. Введите 1 для выбора аннуитетных платежей. Для выбора дифференцированных платежей введите 0");
        System.out.println("При выборе дифференцированных платежей, будет рассчитан платеж в первый месяц. Последующие платежи будут меньше");
        double paymentTypeInput = Double.parseDouble(bis.readLine()); // тип платежа - аннуитетный или дифференцированный

        double InterestRateYear = 9.99; // годовая процентная ставка

        // Не удержался и добавил таки проверки на некорректные данные уже после отправки задания))))
        if ((creditMoney >= 100_000 && creditMoney <= 5_000_000) && (creditTermYear == 1 || creditTermYear == 2 || creditTermYear == 3) && (paymentTypeInput == 0 || paymentTypeInput == 1)) {
            Double monthlyPayment = cps.calculateMonthlyPayment(creditMoney, creditTermYear, paymentTypeInput, InterestRateYear);
            System.out.println("Ваш ежемесячный платеж составит " + Math.round(monthlyPayment) + " рублей.");
        } else {
            System.out.println("Введены некорректные данные. Повторите ввод.");
        }

    }

}
