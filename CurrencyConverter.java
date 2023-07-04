import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class CurrencyConverter {
  public static void main(String[] args) {
    String conversionKey = "";
    Double amount = 0.0;

    Map<String, Double> conversionRates = new HashMap<>();
    conversionRates.put("EUR_USD", 1.09);
    conversionRates.put("USD_EUR", 1 / 1.09);
    conversionRates.put("EUR_COL", 4525.34);
    conversionRates.put("COL_EUR", 1 / 4525.34);
    conversionRates.put("USD_COL", 4157.98);
    conversionRates.put("COL_USD", 1 / 4157.98);


    String[] currencyOptions = {"EUR", "USD", "COL", "EXIT"};

    while (conversionKey.length() < 7 && !conversionKey.equals("EXIT")) {

      int selectOptionCurrency = JOptionPane.showOptionDialog(null, "Select currency:",
          "Currenty Conversor", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
          currencyOptions, currencyOptions[0]);


      switch (selectOptionCurrency) {
        case 0:
        case 1:
        case 2:
          if (conversionKey.equals("")) {
            conversionKey = currencyOptions[selectOptionCurrency];
          } else {
            conversionKey = conversionKey + "_" + currencyOptions[selectOptionCurrency];
          }
          // System.out.println(currentCurrencies);
          break;
        case 3:
          conversionKey = currencyOptions[selectOptionCurrency];
          break;
        default:
          JOptionPane.showMessageDialog(null, "Invalid Option");
          conversionKey = "EXIT";
          break;
      }
    }
    if (!conversionKey.equals("EXIT")) {
      String amountString = JOptionPane.showInputDialog("Enter the amount:");
      amount = Double.parseDouble(amountString);
      Double conversionRate = conversionRates.get(conversionKey);

      if (conversionRate != null) {
        double convertedAmount = amount * conversionRate;
        String formattedAmount = String.format("%.3f", convertedAmount);
        JOptionPane.showMessageDialog(null, "Converted Amount: " + formattedAmount);
      } else {
        JOptionPane.showMessageDialog(null, "Invalid currency combination");
      }
    } ;

  }
}
