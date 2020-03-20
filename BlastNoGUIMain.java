package blastGUI;

import blast.BlastController;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Esta sería la clase ExternalCtrl, por lo que tenemos que tener el action y
 * además un externalCtr(VPanel, controlador).
 */
/*se limita a hacer una llamada de ejemplo a la función blastQuery, de la clase BlastController,
 * que es la que se encarga de realizar la búsqueda y devolver el resultado como un String.
 */
public class BlastNoGUIMain implements ActionListener {

	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");
	BlastVista button;
	private String secuencia;
	private char type;
	private float porcentaje;
	private boolean correct;

	public BlastNoGUIMain(BlastVista b) {
		this.button = b;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		secuencia = button.getSecuencia();
		porcentaje = Float.parseFloat(button.getPorcentaje().getText());
		correct = false;
		if (button.getTypeN().isSelected()) {
			type = 'n';
		} else {
			type = 'p';
		}

		while (correct) {
			if (button.getSecuencia() == null) {
				try {
					button.getResult().setText("No se ha introducido una secuencia");
					correct = false;
				} catch (Exception e) {
					System.out.print("Error en la pantalla: " + e.toString());
				}
			} else if (button.getPorcentaje().getText() == null) {
				try {
					button.getResult().setText("No se ha introducido el porcentaje");
				} catch (Exception e) {
					System.out.print("Error en la pantalla: " + e.toString());
					correct = false;
				}
			} else {
				correct = true;
			}
		}
		if (!correct) {
			BlastController bCnt = new BlastController();
			try {
				String result = bCnt.blastQuery(type, dataBaseFile, dataBaseIndexes, (float) porcentaje, secuencia);
				button.printResult(result);
			} catch (Exception exc) {
				System.out.println("Error en la llamada: " + exc.toString());
			}
		}

	}
}
