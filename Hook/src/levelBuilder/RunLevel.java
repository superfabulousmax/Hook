package levelBuilder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RunLevel {
	public static void main(String args[])
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new BuildLevel();
			}
		});

	}//end main
}
