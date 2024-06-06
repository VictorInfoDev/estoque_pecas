package estoque_pecas.filtros;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author rafae
 */
public class soNumerosQtd extends PlainDocument {

	public void insertString(int offs, String str, AttributeSet a)
		throws BadLocationException {
		super.insertString(offs,str.replaceAll("[^0-9]",""), a);
	}

}