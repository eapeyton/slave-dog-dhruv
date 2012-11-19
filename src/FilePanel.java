/* FilePanel.java */
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JPanel;


/**
 * @author dhruv
 * @version $Revision: 1.0 $
 */
public class FilePanel extends JPanel {
	
	/**
	 * Field fileSelect.
	 */
	private final JFileChooser fileSelect;
	
	/**
	 * Constructor for FilePanel.
	 * @param listener ActionListener
	 */
	public FilePanel(ActionListener listener) {
		fileSelect = new JFileChooser();
		fileSelect.setDialogType(JFileChooser.OPEN_DIALOG);
		fileSelect.addActionListener(listener);
		
		this.add(fileSelect);
	}
	
	/**
	 * Method getFileChooser.
	
	 * @return JFileChooser */
	public JFileChooser getFileChooser() {
		return fileSelect;
	}
	
	/**
	 * Method setModeSave.
	 */
	public void saveMode() {
		fileSelect.setDialogType(JFileChooser.SAVE_DIALOG);
	}
	
	/**
	 * Method setModeOpen.
	 */
	public void openMode() {
		fileSelect.setDialogType(JFileChooser.OPEN_DIALOG);
	}
}
