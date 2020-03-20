package blastGUI;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;

public class BlastVista extends JPanel {

	private JButton busqu;
	private JLabel secuen, porcent, tipo, protein, nucleoti, esp;
	private JRadioButton typeProt, typeNucle;
	private JTextField Porc;
	private JTextArea result;
	private JPanel pIzq, pUp;
	private ButtonGroup tipos = new ButtonGroup();
	private Vector<String> lista = new Vector<String>();
	private JComboBox<String> secuProt = new JComboBox<String>(lista);
	private JScrollPane scroll = new JScrollPane(secuProt);

	public BlastVista() {

		busqu = new JButton("Buscar secuencia");
		secuen = new JLabel("Secuencia de proteínas a traducir");
		porcent = new JLabel("Porcentaje de similitud");
		tipo = new JLabel("Tipo de secuencia");
		protein = new JLabel("           Proteína");
		nucleoti = new JLabel("          Nucleótido");
		esp = new JLabel(" ");
		Porc = new JTextField();
		result = new JTextArea(60, 100);
		result.setEditable(false);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		typeProt = new JRadioButton();
		typeNucle = new JRadioButton();
		secuProt.setEditable(true);
		tipos.add(typeNucle);
		tipos.add(typeProt);
		pIzq = new JPanel();
		pIzq.setLayout(new GridLayout(3, 2));
		pIzq.add(tipo);
		pIzq.add(esp);
		pIzq.add(protein);
		pIzq.add(typeProt);
		pIzq.add(nucleoti);
		pIzq.add(typeNucle);
		pUp = new JPanel();
		pUp.setLayout(new GridLayout(2, 2));
		pUp.add(secuen);
		pUp.add(secuProt);
		pUp.add(porcent);
		pUp.add(Porc);
		add(pIzq, BorderLayout.WEST);
		add(pUp, BorderLayout.EAST);
		add(busqu, BorderLayout.CENTER);
		add(result, BorderLayout.SOUTH);

	}

	public JButton getBusquedad() {
		return this.busqu;
	}

	public void setBusquedad(JButton b) {
		this.busqu = b;
	}

	public JRadioButton getTypeP() {
		return this.typeProt;
	}

	public JRadioButton getTypeN() {
		return this.typeNucle;
	}

	public void setTypeP(JRadioButton rb) {
		this.typeProt = rb;
	}

	public void setTypeN(JRadioButton rb) {
		this.typeNucle = rb;
	}

	public JTextField getPorcentaje() {
		return this.Porc;
	}

	public JTextArea getResult() {
		return this.result;
	}

	public void setResult(JTextArea a) {
		this.result = a;
	}

	public void printResult(String t) {
		result.setText(t);
		String secGuarda = secuProt.getSelectedItem().toString().toUpperCase();
		boolean guardada = false;
		int cnt = 0;
		while (guardada == false && cnt < lista.size()) {
			if (lista.elementAt(cnt).toUpperCase().equals(secGuarda)) {
				guardada = true;
			}
			cnt++;
		}
		if (!guardada) {
			lista.add(secGuarda);
		}
	}

	public String getSecuencia() {
		return this.secuProt.getSelectedItem().toString().toUpperCase();
	}

	public void setLista(JComboBox<String> s) {
		this.secuProt = s;
	}

	public JScrollPane getScroll() {
		return this.scroll;
	}

}
