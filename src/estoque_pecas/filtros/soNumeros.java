/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque_pecas.filtros;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class soNumeros extends PlainDocument {

	public void insertString(int offs, String str, AttributeSet a)
		throws BadLocationException {
		super.insertString(offs,str.replaceAll("[^0-9,]", ""), a);
	}

}
