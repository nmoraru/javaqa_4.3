public class CreditPaymentService {
    public double calculateMonthlyPayment(double creditMoney, double creditTermYear, double paymentTypeInput, double InterestRateYear) {
        double InterestRateMonth = InterestRateYear / 100 / 12;        //месячная процентная ставка
        double creditTermMonth = creditTermYear * 12;                  //срок кредита в месяцах
        double coeffAnnuit = InterestRateMonth * Math.pow((1 + InterestRateMonth), creditTermMonth) /
                (Math.pow((1 + InterestRateMonth), creditTermMonth) - 1);  //коэффициент аннуитетного платежа
        double generalPayment = creditMoney / creditTermMonth;             //Определение размера основного платежа
        // double currentDebtBalance = creditMoney - (generalPayment * n)  //текущий остаток задолженности
        // n - количество оплаченных взносов, в текущем примере n = 0 и currentDebtBalance == creditMoney т.к. я рассчитываю взнос только для первого месяца
        double chargePercent = creditMoney * InterestRateMonth;

        if (paymentTypeInput == 1) {          // Аннуитетный платеж
            double monthlyPayment = creditMoney * coeffAnnuit;
            //double monthlyPayment = creditMoney * (InterestRateMonth + InterestRateMonth / (Math.pow((1 + InterestRateMonth), InterestRateMonth) - 1));
            return monthlyPayment;
        } else {
            double monthlyPayment = generalPayment + chargePercent;
            return monthlyPayment;
        }

    }
}
