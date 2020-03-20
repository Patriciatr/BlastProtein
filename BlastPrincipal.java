package blastGUI;

import javax.swing.*;

public class BlastPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				busqueda();
			}
		});
	}

	public static void busqueda() {
		BlastVista button = new BlastVista();
		JFrame fr = new JFrame("Búsqueda");
		BlastNoGUIMain ctr = new BlastNoGUIMain(button);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setContentPane(button);
		button.getBusquedad().addActionListener(ctr);
		fr.add(button.getScroll());
		fr.pack();
		fr.setVisible(true);

	}

}
