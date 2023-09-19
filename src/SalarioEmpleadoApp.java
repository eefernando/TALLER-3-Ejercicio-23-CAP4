import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalarioEmpleadoApp extends JFrame implements ActionListener {
    private JLabel nombreLabel, salarioLabel, horasLabel;
    private JTextField nombreField, salarioField, horasField;
    private JButton calcularButton;
    private JTextArea resultadoArea;

    public SalarioEmpleadoApp() {
        // Configurar la ventana
        setTitle("Calculadora de Salario Mensual");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes de la interfaz
        nombreLabel = new JLabel("Nombre del Empleado:");
        nombreField = new JTextField(30);
        salarioLabel = new JLabel("Salario Básico por Hora:");
        salarioField = new JTextField(10);
        horasLabel = new JLabel("Horas Trabajadas en el Mes:");
        horasField = new JTextField(10);
        calcularButton = new JButton("Calcular Salario");
        resultadoArea = new JTextArea(5, 30);

        // Agregar componentes a la ventana
        add(nombreLabel);
        add(nombreField);
        add(salarioLabel);
        add(salarioField);
        add(horasLabel);
        add(horasField);
        add(calcularButton);
        add(resultadoArea);

        // Manejar el evento del botón Calcular Salario
        calcularButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            // Obtener los datos ingresados por el usuario
            String nombre = nombreField.getText();
            double salarioPorHora = Double.parseDouble(salarioField.getText());
            double horasTrabajadas = Double.parseDouble(horasField.getText());

            // Calcular el salario mensual
            double salarioMensual = salarioPorHora * horasTrabajadas;

            // Mostrar el resultado en el área de texto
            resultadoArea.setText("Nombre del Empleado: " + nombre + "\n");
            if (salarioMensual > 450000) {
                resultadoArea.append("Salario Mensual: $" + salarioMensual);
            } else {
                resultadoArea.append("Salario Mensual: Menos de $450,000");
            }
        } catch (NumberFormatException ex) {
            resultadoArea.setText("Error: Ingresa valores numéricos válidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SalarioEmpleadoApp app = new SalarioEmpleadoApp();
            app.setVisible(true);
        });
    }
}
