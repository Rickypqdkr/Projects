import javax.swing.*;

public class main {

    //********************************* Validate that it is a number **********************
    public static boolean validate_num (String num){
        try {
            Double.parseDouble(num);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static void main(String[] args) {
        //*************************** Options ************************************
        String [] options  =  {"COIN CONVERTER"};
        String [] optns_coin_converter = {"Pesos to Dolar","Pesos to Euros","Pesos to Libras","Pesos to Yen",
                "Pesos to wonCoreano","Dolar to Pesos","Euro to Pesos","Libras to Pesos" };
        boolean flag = true;
        while (flag){
            String menu_select = (String)  JOptionPane.showInputDialog(null,"Chosse  an Option", "Down Menu",
                    JOptionPane.QUESTION_MESSAGE,null,options, options[0]);

            switch (menu_select){
                case "COIN CONVERTER":
                    String input_value = JOptionPane.showInputDialog(null,"Enter the amount that your want to convert:");
                    System.out.println(input_value.getClass().getSimpleName());
                    if (validate_num(input_value)){
                        double num = Double.parseDouble(input_value);
                        String chosse_convert = (String) JOptionPane.showInputDialog(null,"Chosse the coin  that you want converter","Coins", JOptionPane.QUESTION_MESSAGE,
                                null, optns_coin_converter, optns_coin_converter[0]);
                        coins_converter cnt_cnv = new coins_converter(num);
                        switch (chosse_convert){
                            case "Pesos to Dolar":
                                cnt_cnv.pesos_to_dolar(num);
                                break;

                            case "Pesos to Euros":
                                //System.out.println("enter pesos to euros");
                                cnt_cnv.pesos_to_euro(num);
                                break;

                            case "Pesos to Libras":
                                cnt_cnv.pesos_to_libras(num);
                                break;

                            case "Pesos to Yen":
                                //System.out.println("enter pesos to euros");
                                cnt_cnv.pesos_to_yen(num);
                                break;

                            case "Pesos to wonCoreano":
                                //System.out.println("enter pesos to euros");
                                cnt_cnv.pesos_to_yen(num);
                                break;

                            case "Dolar to Pesos":
                                cnt_cnv.dolar_to_pesos(num);
                                break;

                            case "Euro to Pesos":
                                //System.out.println("enter pesos to euros");
                                cnt_cnv.euro_to_pesos(num);
                                break;

                            case "Libras to Pesos":
                                //System.out.println("enter pesos to euros");
                                cnt_cnv.libras_to_pesos(num);
                                break;
                        }
                        int optns = JOptionPane.showConfirmDialog(null, "do you want to make another conversion?","Window", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (optns == JOptionPane.YES_OPTION){
                            flag = true;
                        } else if ((optns == JOptionPane.NO_OPTION) || (optns == JOptionPane.CANCEL_OPTION)) {
                            JOptionPane.showMessageDialog(null, "Thank for use Good bye");
                            flag = false;
                        }
                    }
                    break;
            }

        }


    }
}
