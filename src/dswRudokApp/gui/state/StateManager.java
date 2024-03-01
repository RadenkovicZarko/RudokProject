package dswRudokApp.gui.state;

public class StateManager {
    private State curr;
    private EditState editState;
    private SlideShowState slideShowState;

    public StateManager() {
        initStates();
    }

    private void initStates() {
        editState=new EditState();
        slideShowState=new SlideShowState();
        curr=editState;
    }

    public State getCurr() {
        return curr;
    }

    public void setEditState() {
        this.curr = this.editState;
    }

    public void setSlideShowState() {
        this.curr = this.slideShowState;
    }
}
