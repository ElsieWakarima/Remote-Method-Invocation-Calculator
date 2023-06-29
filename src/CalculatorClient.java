import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;

public class CalculatorClient extends JFrame {
    private JTextField number1Field, number2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    private CalculatorInterface calculator;

    public CalculatorClient() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        JLabel number1Label = new JLabel("Number 1:");
        add(number1Label);

        number1Field = new JTextField();
        add(number1Field);

        JLabel number2Label = new JLabel("Number 2:");
        add(number2Label);

        number2Field = new JTextField();
        add(number2Field);

        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("add");
            }
        });
        add(addButton);

        subtractButton = new JButton("Subtract");
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("subtract");
            }
        });
        add(subtractButton);

        multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("multiply");
            }
        });
        add(multiplyButton);

        divideButton = new JButton("Divide");
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("divide");
            }
        });
        add(divideButton);

        JLabel resultLabel = new JLabel("Result:");
        add(resultLabel);

        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        pack();
        setVisible(true);

        try {
            calculator = (CalculatorInterface) Naming.lookup("rmi://localhost/CalculatorService");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void calculate(String operation) {
        try {
            int number1 = Integer.parseInt(number1Field.getText());
            int number2 = Integer.parseInt(number2Field.getText());
            int result = 0;

            switch (operation) {
                case "add":
                    result = calculator.add(number1, number2);
                    break;
                case "subtract":
                    result = calculator.subtract(number1, number2);
                    break;
                case "multiply":
                    result = calculator.multiply(number1, number2);
                    break;
                case "divide":
                    result = calculator.divide(number1, number2);
                    break;
            }

            resultField.setText(String.valueOf(result));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorClient();
            }
        });
    }
}
