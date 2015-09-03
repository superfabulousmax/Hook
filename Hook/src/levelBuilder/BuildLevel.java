package levelBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;



public class BuildLevel extends JFrame{
	//-------Components--------//
	JFrame frame ;
	JPanel tilePanel;//list all assets to drag onto the grid
	JPanel grid;//grid to place objects to create the level
	JMenu buildOptions;
	JMenuBar buildOptionsBar;
	JMenuItem saveOption;
	JMenuItem loadOption;
	//list of images to build level
	List <JButton>assetList;
	public BuildLevel(List assetList)
	{
		frame = new JFrame();
		tilePanel = new JPanel();
		grid = new JPanel();
		
		buildOptions = new JMenu("Options");
		buildOptionsBar = new JMenuBar();
		saveOption = new JMenuItem("Save");
		loadOption = new JMenuItem("Load");
			
		assetList = new ArrayList<JButton>();
		
		buildOptions.add(loadOption);
		buildOptions.add(saveOption);
		buildOptionsBar.add(buildOptions);
		
		frame.setJMenuBar(buildOptionsBar);
		
		tilePanel.setLayout(new GridLayout(10, 3));
		tilePanel.setBackground(Color.DARK_GRAY);
		tilePanel.setPreferredSize(new Dimension(200,900));
		
		
		
		frame.setLayout(new BorderLayout());
		frame.add(tilePanel, BorderLayout.WEST);
		frame.setSize(1300, 900);
		frame.setTitle("Level Builder");
		frame.setLocation(400,0);
		frame.setVisible(true);
	}
}
