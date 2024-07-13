package view;

import javax.swing.JButton;


public class ButtonTile extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean empty;
	
	
	ButtonTile(){
		empty=true;
	}

	public boolean isEmpty() {
		return empty;
	}
	
	
	public void makeEmpty(boolean e) {
		empty=e;
	}
	
	

}
