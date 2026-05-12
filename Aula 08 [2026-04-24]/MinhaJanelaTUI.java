// import com.googlecode.lanterna.TerminalSize;
// import com.googlecode.lanterna.TextColor;
// import com.googlecode.lanterna.gui2.*;
// import com.googlecode.lanterna.screen.Screen;
// import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

// public class MinhaJanelaTUI {
//     public static void main(String[] args) throws Exception {
//         DefaultTerminalFactory factory = new DefaultTerminalFactory();
//         Screen screen = factory.createScreen();
//         screen.startScreen();

//         // Cria uma janela centralizada
//         BasicWindow window = new BasicWindow("Minha Janela");
//         Panel panel = new Panel();
//         panel.addComponent(new Label("Bem-vindo à montagem de votos!"));
//         panel.addComponent(new Button("Fechar", () -> window.close()));
//         window.setComponent(panel);
//         window.setFixedSize(new TerminalSize(40, 10));

//         // Cria a GUI e adiciona a janela
//         MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
//         gui.addWindowAndWait(window);

//         screen.stopScreen();
//     }
// }