/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JWindow;

/**
 *
 * @author fernando.m.souza
 */
public class PostIt extends JWindow{
  public PostIt(Nota nota) throws IllegalArgumentException{
    super();

    // controllo se ho una nota valida
    if( nota == null ){
      throw new IllegalArgumentException("Devi specificare una nota valida per il Post-It");
    }

    // creo una casella di testo per contenere la nota
    JTextArea text = new JTextArea(10,10);
    text.setEnabled(false);
    text.setBackground( java.awt.Color.yellow);

    // inizializzo il post it con i dati della nota
    text.setText( nota.getText() );
    text.setToolTipText( nota.getSubject() );

    // aggiungo la nota alla finestra
    this.getContentPane().add( new JScrollPane(text) );

    // centro nella finestra
    this.centraFinestra();

    // rendo visibile
    this.setVisible(true);
  }

  /**
   * Metodo per centrare la finestra corrente nello schermo in modo indipendente
   * dalla risoluzione.
   */
  protected final void centraFinestra(){
    // percentuale dello schermo che deve occupare il post-it
    double percent = 0.1;

    /* Prelevo il toolkit corrente */
    Toolkit tk = java.awt.Toolkit.getDefaultToolkit();

    /* prelevo le dimensioni dello schermo */
    Dimension sz = tk.getScreenSize();

    /* calcolo le dimensioni che deve avere questa finestra */
    int w = (int) ( ( (double) sz.width) * percent);
    int h = (int) ( ( (double) sz.height) * percent);

    /* imposto le dimensioni di questa finestra */
    this.setSize(w, h);

    /* prelevo le dimensioni di questa finestra, che potrebbero essere state alterate */
    Dimension ws = this.getSize();

    /* centro la finestra: la visualizzo con l'angolo superiore sinisto a "meta'" rispetto al centro
       dello schermo */
    this.setLocation( (sz.width / 2) - (ws.width / 2),
                     (sz.height / 2) - (ws.height / 2));

  }
}