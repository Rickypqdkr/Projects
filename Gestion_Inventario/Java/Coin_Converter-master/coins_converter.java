import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class coins_converter {

    //******************* Constructor ***********************

    public coins_converter(double value) {

    }
//************************* Methods *********************************************************
    public void pesos_to_dolar (double value){
        double coin_dolar = value/3967.04;
        BigDecimal round_value = new BigDecimal(coin_dolar);
        round_value = round_value.setScale(2, RoundingMode.HALF_UP);
        JOptionPane.showMessageDialog(null, "You have $ " + round_value +" dls");
    }

    public void pesos_to_euro (double value){
        double coin_euro = value/4359.03;
        BigDecimal round_value = new BigDecimal(coin_euro);
        round_value = round_value.setScale(2, RoundingMode.HALF_UP);
        JOptionPane.showMessageDialog(null, "You have $ " + round_value +" euros");
    }

    public void pesos_to_libras (double value){
        double coin_libra = value/5079.50;
        BigDecimal round_value = new BigDecimal(coin_libra);
        round_value = round_value.setScale(2, RoundingMode.HALF_UP);
        JOptionPane.showMessageDialog(null, "You have $ " + round_value +" lbs");
    }

    public void pesos_to_yen (double value){
        double coin_yen = value/27.76;
        BigDecimal round_value = new BigDecimal(coin_yen);
        round_value = round_value.setScale(2, RoundingMode.HALF_UP);
        JOptionPane.showMessageDialog(null, "You have $ " + round_value +" yens");
    }

    public void pesos_to_won (double value){
        double coin_won = value/3.08;
        BigDecimal round_value = new BigDecimal(coin_won);
        round_value = round_value.setScale(2, RoundingMode.HALF_UP);
        JOptionPane.showMessageDialog(null, "You have $ " + round_value +" yens");
    }


    public void dolar_to_pesos (double value){
        double coin_dolar = value*3967.04;
        BigDecimal round_value = new BigDecimal(coin_dolar);
        round_value = round_value.setScale(2, RoundingMode.HALF_UP);
        JOptionPane.showMessageDialog(null, "You have $ " + round_value );
    }

    public void euro_to_pesos (double value){
        double coin_euro = value*4359.03;
        BigDecimal round_value = new BigDecimal(coin_euro);
        round_value = round_value.setScale(2, RoundingMode.HALF_UP);
        JOptionPane.showMessageDialog(null, "You have $ " + round_value );
    }

    public void libras_to_pesos (double value){
        double coin_libra = value*5079.50;
        BigDecimal round_value = new BigDecimal(coin_libra);
        round_value = round_value.setScale(2, RoundingMode.HALF_UP);
        JOptionPane.showMessageDialog(null, "You have $ " + round_value );
    }

}
