package carbonFootprintCalculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class CO2FootprintCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField txt_flighttime;
	private JTextField txt_numberOfFlights;
	private JTextField txt_FuelConsumption;
	private JTextField txt_ElectricConsumption;
	private JTextField txt_TotalAirway;
	private JTextField txt_TotalHighway;
	private JTextField txt_TotalElectricity;
	private JTextField txt_TotalCO2Emissions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					CO2FootprintCalculator frame = new CO2FootprintCalculator();
					frame.setVisible(true);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void AirwayHesapla() {
		double averagePlaneSpeed = 850;
		double flightTime = Double.parseDouble(txt_flighttime.getText()); // Flight timea yazýlan String deðeri double çevirdik.
		double numberOfFlights = Double.parseDouble(txt_numberOfFlights.getText()); // NumberofFlightsa yazýlan String deðeri double çevirdik.
		double airwayTotalEmission = (flightTime * averagePlaneSpeed * numberOfFlights * 0.06375) / 1000;
		
		String airwayEmission = String.valueOf(airwayTotalEmission); // double olan airwayTotalEmission deðerini Stringe çevirdik.
		txt_TotalAirway.setText(airwayEmission); // Result kýsmýnda Airway text fielda airwayEmission deðerini yazdýrýr.
	}
	
	public void ElectricityHesapla() {
		// Elektrik için Monthly total consumption yazýlan String deðeri double çevirdik.
		double monthlyConsumption = Double.parseDouble(txt_ElectricConsumption.getText());
		double annualConsumption = monthlyConsumption * 12;
		double electricEmissionCoefficient = 0.492;
		double electricTotalEmission = (annualConsumption * electricEmissionCoefficient) / 1000 ;
		
		String electricEmission = String.valueOf(electricTotalEmission); // double olan electricTotalEmission deðerini Stringe çevirdik.
		txt_TotalElectricity.setText(electricEmission); // Result kýsmýnda Electricity text fielda airwayEmission deðerini yazdýrýr
	}
		
		
	
	
	

	/**
	 * Create the frame.
	 */
	public CO2FootprintCalculator() {
		setTitle("CarbonFootprintCalculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		
		JLabel lbl_flighttime = new JLabel("Flight Time (One Way)");
		lbl_flighttime.setForeground(new Color(153, 51, 51));
		lbl_flighttime.setBounds(34, 49, 128, 17);
		contentPane.add(lbl_flighttime);
		
		txt_flighttime = new JTextField();
		txt_flighttime.setBounds(165, 49, 104, 20);
		contentPane.add(txt_flighttime);
		txt_flighttime.setColumns(10);
		
		JLabel lbl_numberOfFlights = new JLabel("Number of Flights");
		lbl_numberOfFlights.setForeground(new Color(153, 51, 51));
		lbl_numberOfFlights.setBounds(372, 49, 104, 17);
		contentPane.add(lbl_numberOfFlights);
		
		txt_numberOfFlights = new JTextField();
		txt_numberOfFlights.setColumns(10);
		txt_numberOfFlights.setBounds(486, 49, 104, 20);
		contentPane.add(txt_numberOfFlights);
		
		JLabel lbl_highway = new JLabel("Highway Transportation");
		lbl_highway.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_highway.setBounds(50, 100, 153, 17);
		contentPane.add(lbl_highway);
		
		JLabel airplaneresmi = new JLabel();
		airplaneresmi.setForeground(Color.WHITE);
		airplaneresmi.setBackground(new Color(255, 255, 255));
		airplaneresmi.setBounds(15, 11, 25, 25);
		Image img = new ImageIcon(CO2FootprintCalculator.class.getResource("/a_icon.png")).getImage();
		airplaneresmi.setIcon(new ImageIcon(img));
		contentPane.add(airplaneresmi);
		
		JLabel carresmi = new JLabel();
		carresmi.setBounds(15,92,25,25);
		Image img2 = new ImageIcon(CO2FootprintCalculator.class.getResource("/c_icon.png")).getImage();
		carresmi.setIcon(new ImageIcon(img2));
		contentPane.add(carresmi);
		
		JLabel electricresmi = new JLabel();
		electricresmi.setBounds(15,209,25,25);
		Image img3 = new ImageIcon(CO2FootprintCalculator.class.getResource("/e_icon.png")).getImage();
		electricresmi.setIcon(new ImageIcon(img3));
		contentPane.add(electricresmi);
		
		JLabel lbl_fuelType = new JLabel("Fuel Type");
		lbl_fuelType.setForeground(new Color(153, 51, 0));
		lbl_fuelType.setBounds(34, 148, 104, 17);
		contentPane.add(lbl_fuelType);
		
		JLabel lbl_annualConsumption = new JLabel("Monthly Total");
		lbl_annualConsumption.setForeground(new Color(153, 51, 0));
		lbl_annualConsumption.setBounds(372, 148, 104, 17);
		contentPane.add(lbl_annualConsumption);
		
		txt_FuelConsumption = new JTextField();
		txt_FuelConsumption.setColumns(10);
		txt_FuelConsumption.setBounds(486, 148, 104, 38);
		contentPane.add(txt_FuelConsumption);
		
		JLabel lbl_annualConsumption_1 = new JLabel("Consumption (lt)");
		lbl_annualConsumption_1.setForeground(new Color(153, 51, 0));
		lbl_annualConsumption_1.setBounds(372, 169, 104, 17);
		contentPane.add(lbl_annualConsumption_1);
		
		
		
		String[] fuelType = {"Gasoline", "Diesel", "LPG"};
		JComboBox cBox_FuelType = new JComboBox(fuelType);
		cBox_FuelType.setBounds(165, 145, 104, 22);
		contentPane.add(cBox_FuelType);		
		
		
		
		JLabel lbl_electricity = new JLabel("Electricity Consumption");
		lbl_electricity.setForeground(new Color(255, 0, 51));
		lbl_electricity.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_electricity.setBounds(50, 217, 153, 17);
		contentPane.add(lbl_electricity);
		
		JLabel lbl_electricConsumption = new JLabel("Monthly Total Consumption (kWh)");
		lbl_electricConsumption.setForeground(new Color(128, 0, 0));
		lbl_electricConsumption.setBounds(34, 258, 210, 17);
		contentPane.add(lbl_electricConsumption);
		
		txt_ElectricConsumption = new JTextField();
		txt_ElectricConsumption.setColumns(10);
		txt_ElectricConsumption.setBounds(254, 256, 104, 20);
		contentPane.add(txt_ElectricConsumption);
		
		JLabel lbl_results = new JLabel("Results");
		lbl_results.setForeground(new Color(0, 0, 128));
		lbl_results.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_results.setBounds(23, 311, 153, 17);
		contentPane.add(lbl_results);
		
		JLabel lbl_results2 = new JLabel("Your total greenhouse gas emissions, which constitute the annual carbon footprint, are given below.");
		lbl_results2.setBounds(23, 339, 567, 14);
		contentPane.add(lbl_results2);
		
		JLabel lbl_AirwayResult = new JLabel("Airway");
		lbl_AirwayResult.setForeground(Color.BLUE);
		lbl_AirwayResult.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_AirwayResult.setBounds(23, 364, 153, 17);
		contentPane.add(lbl_AirwayResult);
		
		JLabel lbl_HighwayResult = new JLabel("Highway");
		lbl_HighwayResult.setForeground(Color.BLUE);
		lbl_HighwayResult.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_HighwayResult.setBounds(23, 392, 153, 17);
		contentPane.add(lbl_HighwayResult);
		
		JLabel lbl_ElectricityResult = new JLabel("Electricity");
		lbl_ElectricityResult.setForeground(Color.BLUE);
		lbl_ElectricityResult.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_ElectricityResult.setBounds(23, 420, 153, 17);
		contentPane.add(lbl_ElectricityResult);
		
		JLabel lbl_TotalEmissions = new JLabel("Total CO2 Emissions");
		lbl_TotalEmissions.setForeground(Color.RED);
		lbl_TotalEmissions.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_TotalEmissions.setBounds(23, 448, 153, 17);
		contentPane.add(lbl_TotalEmissions);
		
		txt_TotalAirway = new JTextField();
		txt_TotalAirway.setColumns(10);
		txt_TotalAirway.setBounds(425, 362, 138, 20);
		contentPane.add(txt_TotalAirway);
		txt_TotalAirway.setEditable(false); // içine yazýlabilmeyi kapatýr
		
		txt_TotalHighway = new JTextField();
		txt_TotalHighway.setColumns(10);
		txt_TotalHighway.setBounds(425, 389, 138, 20);
		contentPane.add(txt_TotalHighway);
		txt_TotalHighway.setEditable(false);
		
		txt_TotalElectricity = new JTextField();
		txt_TotalElectricity.setColumns(10);
		txt_TotalElectricity.setBounds(425, 417, 138, 20);
		contentPane.add(txt_TotalElectricity);
		txt_TotalElectricity.setEditable(false);
		
		txt_TotalCO2Emissions = new JTextField();
		txt_TotalCO2Emissions.setColumns(10);
		txt_TotalCO2Emissions.setBounds(425, 445, 138, 20);
		contentPane.add(txt_TotalCO2Emissions);
		txt_TotalCO2Emissions.setEditable(false);
		
		
		JButton btn_Calculate = new JButton("Calculate");
		btn_Calculate.setBounds(486, 255, 89, 23);
		contentPane.add(btn_Calculate);
		
		JLabel lbl_TCO2_1 = new JLabel("T CO2");
		lbl_TCO2_1.setBounds(575, 364, 64, 14);
		contentPane.add(lbl_TCO2_1);
		
		JLabel lbl_TCO2_2 = new JLabel("T CO2");
		lbl_TCO2_2.setBounds(575, 393, 64, 14);
		contentPane.add(lbl_TCO2_2);
		
		JLabel lbl_TCO2_3 = new JLabel("T CO2");
		lbl_TCO2_3.setBounds(575, 421, 64, 14);
		contentPane.add(lbl_TCO2_3);
		
		JLabel lbl_TCO2_4 = new JLabel("T CO2");
		lbl_TCO2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_TCO2_4.setForeground(Color.RED);
		lbl_TCO2_4.setBounds(575, 449, 64, 14);
		contentPane.add(lbl_TCO2_4);
		
		JLabel lbl_company = new JLabel("FLYtelligence");
		lbl_company.setForeground(Color.BLUE);
		lbl_company.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 12));
		lbl_company.setBounds(568, 480, 89, 14);
		contentPane.add(lbl_company);
		
		JLabel lbl_airway = new JLabel("Airway Transportation");		
		lbl_airway.setForeground(new Color(51, 255, 255));
		lbl_airway.setBackground(new Color(102, 205, 170));
		lbl_airway.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_airway.setBounds(50, 11, 153, 17);
		contentPane.add(lbl_airway);
		
		JLabel lbl_flighttime_hours = new JLabel("hours");
		lbl_flighttime_hours.setForeground(new Color(153, 51, 51));
		lbl_flighttime_hours.setBounds(273, 52, 44, 17);
		contentPane.add(lbl_flighttime_hours);
		
		JProgressBar progressBar = new JProgressBar(0,2000);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setBounds(464, 289, 146, 14);
		contentPane.add(progressBar);
		
		btn_Calculate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i=0;
				while(i<= 2000) {
					progressBar.setValue(i);
					i = i + 20;
					try {
						Thread.sleep(25);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				AirwayHesapla();
				
				// Highway için hesaplama
				// Highway da monthly total consumption da yazan String deðeri double çevirdik.
				double monthlyConsumption = Double.parseDouble(txt_FuelConsumption.getText());
				double annualConsumption = monthlyConsumption * 12;
				double highwayEmissionFactor = 0;
				if(cBox_FuelType.getSelectedIndex() == 0) {
					highwayEmissionFactor = 2.239;
				}
				else if(cBox_FuelType.getSelectedIndex() == 1) {
					highwayEmissionFactor = 2.599;
				}
				else if(cBox_FuelType.getSelectedIndex() == 2) {
					highwayEmissionFactor = 1.679;
				}
				
				
				
				double highwayTotalEmission = (annualConsumption * highwayEmissionFactor) / 1000;
				String highwayEmission = String.valueOf(highwayTotalEmission); // double olan highwayTotalEmission deðerini Stringe çevirdik.
				txt_TotalHighway.setText(highwayEmission); // Result kýsmýnda Highway text fielda highwayEmission deðerini yazdýrýr.
				// Highway için hesaplama bitti
				// Electric için hesapla
				ElectricityHesapla();
				double Airway1 = Double.parseDouble(txt_TotalAirway.getText()); // Results kýsmýnda TotalAirway de yazan String deðeri double a çevirdik.
				double Highway2 = Double.parseDouble(txt_TotalHighway.getText()); // Results kýsmýnda TotalHighway de yazan String deðeri double a çevirdik.
				double Electricity3 = Double.parseDouble(txt_TotalElectricity.getText()); // Results kýsmýnda TotalElectricity de yazan String deðeri double a çevirdik.
				double totalEmission = Airway1 + Highway2 + Electricity3;
				
				double treeNumber = totalEmission / 0.4114;
				
				
				String resultTotalEmission = String.valueOf(totalEmission); // double olan totalEmission deðerini Stringe çevirir.
				txt_TotalCO2Emissions.setText(resultTotalEmission);
				
				// Math.round(sayi) double sayisini int e yuvarlar.
				
				JOptionPane.showMessageDialog(contentPane, "Calculating has been done !");
				JOptionPane.showMessageDialog(contentPane, "You owe nature "+ Math.round(treeNumber) + " trees annually", "Please Plant Trees", JOptionPane.WARNING_MESSAGE);
				
				
			}

			
			
		});
	}
}
