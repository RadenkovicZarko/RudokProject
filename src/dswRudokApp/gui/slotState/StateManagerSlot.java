package dswRudokApp.gui.slotState;

import dswRudokApp.gui.state.EditState;
import dswRudokApp.gui.state.SlideShowState;


public class StateManagerSlot {
    private AddState addState;
    private DeleteState deleteState;
    private MoveState moveState;
    private State curr;
    private SelectionState selectionState;
    public StateManagerSlot() {
        initStates();
    }

    private void initStates() {
        addState=new AddState();
        deleteState= new DeleteState();
        moveState=new MoveState();
        selectionState=new SelectionState();
        curr=addState;
    }

    public State getCurr() {
        return curr;
    }

    public void setCurr(State curr) {
        this.curr = curr;
    }

    public void setAddState() {
        this.curr = this.addState;
    }

    public SelectionState getSelectionState() {
        return selectionState;
    }

    public void setSelectionState() {
        this.curr=this.selectionState;
    }

    public void setDeleteState() {
        this.curr = this.deleteState;
    }

    public void setMoveState() {
        this.curr = moveState;
    }
}
