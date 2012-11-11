import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JPanel;


public class FilePanel extends JPanel
{
	
	private JFileChooser fileSelect;
	
	public FilePanel(ActionListener listener)
	{
		fileSelect = new JFileChooser();
		fileSelect.setDialogType(JFileChooser.OPEN_DIALOG);
		fileSelect.addActionListener(listener);
		
		this.add(fileSelect);
	}
	
	public JFileChooser getFileChooser()
	{
		return fileSelect;
	}
	
	public void setModeSave()
	{
		fileSelect.setDialogType(JFileChooser.SAVE_DIALOG);
	}
	
	public void setModeOpen()
	{
		fileSelect.setDialogType(JFileChooser.OPEN_DIALOG);
	}
}
