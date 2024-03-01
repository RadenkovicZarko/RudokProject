package dswRudokApp.gui.factory;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.Workspace;

public class FactoryManager {
    private static FactoryManager instance;
    private ProjectFactory projectFactory;
    private PresentationFactory presentationFactory;
    private SlajdFactory slajdFactory;

    private FactoryManager(){}

    public static FactoryManager getInstance()
    {
        if(instance==null)
        {
            instance=new FactoryManager();
            instance.setuj();
        }
        return instance;
    }

    public void setuj()
    {
        projectFactory=new ProjectFactory();
        presentationFactory=new PresentationFactory();
        slajdFactory=new SlajdFactory();
    }

    public static AbstractNodeFactory getFactory(RuNode ruNode)
    {
        if(ruNode instanceof Workspace) return new ProjectFactory();
        else if(ruNode instanceof Project) return new PresentationFactory();
        else if(ruNode instanceof Presentation) return new SlajdFactory();
        else return null;
    }


}
