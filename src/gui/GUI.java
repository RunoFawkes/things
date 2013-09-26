package gui;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Component.Alignment;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Panel.Orientation;
import com.googlecode.lanterna.gui.component.Table;
import com.googlecode.lanterna.gui.layout.*;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.gui.Component;
/**
 * Interface, em construcao
 * @author Gabriel
 *
 */
public class GUI {

	 GUIScreen guiScreen = TerminalFacade.createGUIScreen();
	
	public void run() {
		final Window window = new Window("Sample window");
		window.setWindowSizeOverride(new TerminalSize(130, 50));
		window.setSoloWindow(true);

		Panel panelHolder = new Panel("Holder panel", Orientation.VERTICAL);

		Panel panel = new Panel("Panel with a right-aligned button");

		panel.setLayoutManager(new HorisontalLayout());
		Button button = new Button("Button");
		button.setAlignment(Component.Alignment.RIGHT_CENTER);
		panel.addComponent(button, LinearLayout.GROWS_HORIZONTALLY);

		Table table = new Table(6);
		table.setColumnPaddingSize(5);

		Component[] row1 = new Component[6];
		row1[0] = new Button("Field-1----");
		row1[1] = new Label("Field-2");
		row1[2] = new Label("Field-3");
		row1[3] = new Label("Field-4");
		row1[4] = new Label("Field-5");
		row1[5] = new Label("Field-6");

		table.addRow(row1);
		panel.addComponent(table);

		panelHolder.addComponent(panel);

		window.addComponent(panelHolder);
		window.addComponent(new EmptySpace());

		final Window newWindow = new Window(
				"This window should be of the same size as the previous one");

		Button quitButton = new Button("Show next window", new Action() {

			public void doAction() {

				newWindow.setWindowSizeOverride(new TerminalSize(130, 50));
				newWindow.setSoloWindow(true);

				Button exitBtn = new Button("Exit", new Action() {

					public void doAction() {
						// TODO Auto-generated method stub
						newWindow.close();
						window.close();
					}
				});

				exitBtn.setAlignment(Alignment.RIGHT_CENTER);

				newWindow
						.addComponent(exitBtn, LinearLayout.GROWS_HORIZONTALLY);

				guiScreen.showWindow(newWindow);
			}
		});
		quitButton.setAlignment(Component.Alignment.RIGHT_CENTER);
		window.addComponent(quitButton, LinearLayout.GROWS_HORIZONTALLY);

		guiScreen.getScreen().startScreen();
		guiScreen.showWindow(window);
		guiScreen.getScreen().stopScreen();

	}

}
