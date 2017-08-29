import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class FutureValueApp
{
	public static void main(String[] args)
	{
		JFrame frame = new FutureValueFrame();
		frame.setVisible(true);
	}
}

class FutureValueFrame extends JFrame
{
	public FutureValueFrame()
	{
		setTitle("Future Value Calculator");
		setSize(267, 200);
		centerWindow(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new FutureValuePanel();
		this.add(panel);
	}
	
	private void centerWindow(Window w)
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
	}
}

class FutureValuePanel extends JPanel implements ActionListener
{
	 private JTextField paymentTextField,
	 					rateTextField,
	 					yearsTextField,
	 					futureValueTextField;
	 private JLabel paymentLabel,
	 				rateLabel,
	 				yearsLabel,
	 				futureValueLabel;
	 private JButton calculateButton,
	 				 exitButton;
	
	 public FutureValuePanel()
	 {
		 // display panel
		 JPanel displayPanel = new JPanel();
		 displayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	 
		 // payment label
		 paymentLabel = new JLabel("Monthly Payment:");
		 displayPanel.add(paymentLabel);
		 // payment text field
		 paymentTextField = new JTextField(10);
		 displayPanel.add(paymentTextField);
		 
		 // rate label
		 rateLabel = new JLabel("Yearly Interest Rate:");
		 displayPanel.add(rateLabel);
		 // rate text field
		 rateTextField = new JTextField(10);
		 displayPanel.add(rateTextField);
		 
		 // years label
		 yearsLabel = new JLabel("Number of Years:");
		 displayPanel.add(yearsLabel);
		 // years text field
		 yearsTextField = new JTextField(10);
		 displayPanel.add(yearsTextField);
		 
		 // future value label
		 futureValueLabel = new JLabel("Future Value:");
		 displayPanel.add(futureValueLabel);
		 // future value text field
		 futureValueTextField = new JTextField(10);
		 futureValueTextField.setEditable(false);
		 futureValueTextField.setFocusable(false);
		 displayPanel.add(futureValueTextField);
		 
		 // button panel
		 JPanel buttonPanel = new JPanel();
		 buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	 
		 // calculate button
		 calculateButton = new JButton("Calculate");
		 calculateButton.addActionListener(this);
		 buttonPanel.add(calculateButton);
		 // exit button
		 exitButton = new JButton("Exit");
		 exitButton.addActionListener(this);
		 buttonPanel.add(exitButton);
		 // add panels to main panel
		 this.setLayout(new BorderLayout());
		 this.add(displayPanel, BorderLayout.CENTER);
		 this.add(buttonPanel, BorderLayout.SOUTH);
	 }
	 
	 public void actionPerformed(ActionEvent e)
	 {
		 Object source = e.getSource();
		 if (source == exitButton)
			 System.exit(0);
		 else if (source == calculateButton)
		 {
			 double payment = Double.parseDouble(paymentTextField.getText());
			 double rate = Double.parseDouble(rateTextField.getText());
			 int years = Integer.parseInt(yearsTextField.getText());
			 double futureValue = payment * Math.pow(rate + 1, years);
			 NumberFormat currency = NumberFormat.getCurrencyInstance();
			 futureValueTextField.setText(currency.format(futureValue));
		 }
	 }
}