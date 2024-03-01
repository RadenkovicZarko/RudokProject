package dswRudokApp.gui.view;

import dswRudokApp.gui.command.CommandManager;
import dswRudokApp.gui.controller.ActionManager;
import dswRudokApp.gui.controller.Utils;
import dswRudokApp.gui.error.MyError;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.Workspace;
import dswRudokApp.gui.observer.ISubscriber;
import dswRudokApp.gui.state.StateManager;
import dswRudokApp.gui.tree.MyTree;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.tree.TreeModel;
import dswRudokApp.gui.view.tree.ProjectView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;

public class MainFrame extends JFrame implements ISubscriber {
    private static MainFrame instance = null;
    private JMenuBar menu;
    private Toolbar toolBar;
    private ActionManager actionManager;
    private JScrollPane scroll;
    private TreeModel treeModel;
    private MyTree myTree;
    private JSplitPane splitPane;
    private JPanel jPanel;
    private ProjectView projectView;
    private CommandManager commandManager;
    //private StateManager stateManager;


    private MainFrame() {

    }

    private void initialise()
    {
        projectView=new ProjectView();
        actionManager=new ActionManager();
        commandManager=new CommandManager();
        //stateManager=new StateManager();
        initialiseWorkspaceTree();
        initialiseGUI();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initialiseGUI(){

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                ChooseWorkspaceOpening chooseWorkspaceOpening=new ChooseWorkspaceOpening();
                chooseWorkspaceOpening.setVisible(true);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                try{
                    FileWriter fileWriter=new FileWriter(Utils.getLokacija(),false);
                    MyTreeNode myTreeNode=(MyTreeNode) myTree.getModel().getRoot();
                    Workspace workspace=(Workspace) myTreeNode.getRuNode();
                    for (RuNode ruNode:workspace.getListaRuNodova())
                    {

                        Project project=(Project) ruNode;
                        if(project.getProjectFile()==null)
                        {
                            File file=new File("rudok-ZarkoRadenkovic"+project.getName()+".gpf");
                            Utils.pisi(project,file);
                        };

                        Utils.pisi(project,project.getProjectFile());
                        fileWriter.append(project.getProjectFile().getPath());
                        fileWriter.append("\n");
                    }
                    fileWriter.close();
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }

            }
        });

        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension dimension=toolkit.getScreenSize();
        setSize(dimension.width/2,dimension.height/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("RuDok app");
        menu=new MenuBar();
        setJMenuBar(menu);

        toolBar=new Toolbar();
        //toolBar.setEditMode();
        add(toolBar, BorderLayout.NORTH);

        jPanel=new JPanel();
        jPanel.setLayout(new BorderLayout());
        scroll=new JScrollPane(myTree);
        jPanel.setBackground(Color.LIGHT_GRAY);
        scroll.setPreferredSize(new Dimension(200,200));
        scroll.setBorder(new LineBorder(Color.LIGHT_GRAY,3));
        jPanel.add(projectView);
        splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,jPanel);
       /*add(scroll,BorderLayout.WEST);
       add(jPanel,BorderLayout.CENTER);
       jPanel.add(projectView);*/
       add(splitPane,BorderLayout.CENTER);

        splitPane.setOneTouchExpandable(true);
    }

    public static MainFrame getInstance(){
        if (instance == null){
            instance  = new MainFrame();
            instance.initialise();

        }
        return instance;
    }
    private void initialiseWorkspaceTree()
    {
        myTree=new MyTree();
        treeModel=new TreeModel();
        myTree.setModel(treeModel);
    }

    /*public void startEditState(){
        this.stateManager.setEditState();
    }

    public void startSlideShowState(){
        this.stateManager.setSlideShowState();
    }

    public void showContent()
    {
        this.stateManager.getCurr().showContent();
    }*/

    public ActionManager getActionManager()
    {
        return actionManager;
    }

    public TreeModel getTreeModel() {
        return treeModel;
    }

    public void setTreeModel(TreeModel treeModel) {
        this.treeModel = treeModel;
    }

    public MyTree getMyTree() {
        return myTree;
    }

    public void setMyTree(MyTree myTree) {
        this.myTree = myTree;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public ProjectView getProjectView() {
        return projectView;
    }

    public void setProjectView(ProjectView projectView) {
        this.projectView = projectView;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public Toolbar getToolBar() {
        return toolBar;
    }

    public void setToolBar(Toolbar toolBar) {
        this.toolBar = toolBar;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    public void setSplitPane(JSplitPane splitPane) {
        this.splitPane = splitPane;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void update(Object notification) {
        JOptionPane.showMessageDialog(this,((MyError)notification).getTekst());
    }
}
