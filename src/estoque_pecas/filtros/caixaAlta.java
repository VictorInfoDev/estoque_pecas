/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque_pecas.filtros;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class caixaAlta extends PlainDocument {

	public void insertString(int offset, String str, AttributeSet attr)
		throws BadLocationException {
		if (str == null)
			return;
		super.insertString(offset, str.toUpperCase(), attr); // Detalhe no str
		return;
	}

}
/**
 *
 * @author rafae
 */
