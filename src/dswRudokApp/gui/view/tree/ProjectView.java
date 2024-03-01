package dswRudokApp.gui.view.tree;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.*;
import dswRudokApp.gui.observer.ISubscriber;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements ISubscriber {

    Project project;
    JTabbedPane jTabbedPane;
    public ProjectView() {
        super();
        this.project = null;
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        jTabbedPane=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    public ProjectView(RuNode project) {
        super();
        this.project=(Project) project;
        this.setLayout(new BorderLayout());
        this.project.addSubscriber(this);

    }

    public void paint()
    {
        JLabel jLabel=new JLabel(project.getName());
        jLabel.setFont(new Font("Verdana", Font.PLAIN, 18));

        this.setPreferredSize(new Dimension(MainFrame.getInstance().getjPanel().getWidth(),MainFrame.getInstance().getjPanel().getHeight()));
        this.add(jLabel,BorderLayout.NORTH);
        jTabbedPane.removeAll();

        for (RuNode p:project.getListaRuNodova()) {
            if(p instanceof Presentation)
            {
                PresentationView presentationView=(PresentationView)((Presentation) p).getSubscribers().get(0);
                //JScrollPane jScrollPane=new JScrollPane((PresentationView)((Presentation) p).getSubscribers().get(0),ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                jTabbedPane.add(p.getName(),presentationView);
            }
        }
        this.add(jTabbedPane,BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getjPanel());

    }

    @Override
    public void update(Object notification) {
        if(notification instanceof PomocnaPrezentacija)
        {
            if(!((PomocnaPrezentacija) notification).getPresentation().getParent().equals(MainFrame.getInstance().getProjectView().getProject()))
                return;
            PomocnaPrezentacija pomocnaPrezentacija=(PomocnaPrezentacija)notification;
            if(pomocnaPrezentacija.getStr().equals("dodat"))
            {
                PresentationView presentationView=(PresentationView) pomocnaPrezentacija.getPresentation().getSubscribers().get(0);
                //JScrollPane jScrollPane=new JScrollPane(presentationView,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                jTabbedPane.add(((PomocnaPrezentacija) notification).getPresentation().getName(),presentationView);

                return;
            }
            else if(pomocnaPrezentacija.getStr().equals("uklonjen"))
            {


                for (int i=0;i<jTabbedPane.getTabCount();i++)
                {
                    PresentationView presentationView=(PresentationView) jTabbedPane.getComponentAt(i);
                    if(pomocnaPrezentacija.getPresentation().equals(presentationView.getPresentation()))
                    {
                        jTabbedPane.removeTabAt(i);
                        return;
                    }
                }
            }

        }
        else {

            MainFrame.getInstance().getProjectView().removeAll();
            paint();
        }
    }


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
        this.project.addSubscriber(this);
        this.update(new Object());

    }

    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }

    public void setjTabbedPane(JTabbedPane jTabbedPane) {
        this.jTabbedPane = jTabbedPane;
    }
}
