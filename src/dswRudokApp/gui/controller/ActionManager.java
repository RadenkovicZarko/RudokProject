package dswRudokApp.gui.controller;

import javax.swing.*;

public class ActionManager {
    private NewProjectAction newProjectAction;
    private InfoAction infoAction;
    private ChangeBackgroundImageAction changeBackgroundImageAction;
    private ChangeAutoraAction changeAutoraAction;
    private DeleteAction deleteAction;
    private SlideShowAction slideShowAction;
    private ExitSlideShowAction exitSlideShowAction;
    private AddSlotAction addSlotAction;
    private RemoveSlotAction removeSlotAction;
    private MoveSlotAction moveSlotAction;
    private ChangeColorAction changeColorAction;
    private ChangeStrokeAction changeStrokeAction;
    private ChangeTicknessAction changeTicknessAction;
    private SelectSlotAction selectSlotAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private EditSlotAction editSlotAction;
    private ShareAction shareAction;
    private SaveAction saveAction;
    private OpenAction openAction;
    private SaveWorkspaceAction saveWorkspaceAction;
    private SavePresentationAction savePresentationAction;
    private OpenPresentationAction openPresentationAction;

    public ActionManager(){initialiseAction();}

    private void initialiseAction()
    {
        infoAction=new InfoAction();
        newProjectAction=new NewProjectAction();
       changeBackgroundImageAction=new ChangeBackgroundImageAction();
        changeAutoraAction=new ChangeAutoraAction();
        deleteAction=new DeleteAction();
        slideShowAction=new SlideShowAction();
        exitSlideShowAction=new ExitSlideShowAction();
        addSlotAction=new AddSlotAction();
        removeSlotAction=new RemoveSlotAction();
        moveSlotAction=new MoveSlotAction();
        changeColorAction =new ChangeColorAction();
        changeStrokeAction=new ChangeStrokeAction();
        changeTicknessAction=new ChangeTicknessAction();
        selectSlotAction=new SelectSlotAction();
        undoAction=new UndoAction();
        redoAction=new RedoAction();
        editSlotAction=new EditSlotAction();
        shareAction=new ShareAction();
        saveAction=new SaveAction();
        openAction=new OpenAction();
        saveWorkspaceAction=new SaveWorkspaceAction();
        savePresentationAction=new SavePresentationAction();
        openPresentationAction=new OpenPresentationAction();
    }



    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public void setNewProjectAction(NewProjectAction newProjectAction) {
        this.newProjectAction = newProjectAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public ChangeBackgroundImageAction getChangeBackgroundImageAction() {
        return changeBackgroundImageAction;
    }

    public void setChangeBackgroundImageAction(ChangeBackgroundImageAction changeBackgroundImageAction) {
        this.changeBackgroundImageAction = changeBackgroundImageAction;
    }

    public ChangeAutoraAction getChangeAutoraAction() {
        return changeAutoraAction;
    }

    public void setChangeAutoraAction(ChangeAutoraAction changeAutoraAction) {
        this.changeAutoraAction = changeAutoraAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        this.deleteAction = deleteAction;
    }

    public SlideShowAction getSlideShowAction() {
        return slideShowAction;
    }

    public void setSlideShowAction(SlideShowAction slideShowAction) {
        this.slideShowAction = slideShowAction;
    }

    public ExitSlideShowAction getExitSlideShowAction() {
        return exitSlideShowAction;
    }

    public void setExitSlideShowAction(ExitSlideShowAction exitSlideShowAction) {
        this.exitSlideShowAction = exitSlideShowAction;
    }

    public AddSlotAction getAddSlotAction() {
        return addSlotAction;
    }

    public void setAddSlotAction(AddSlotAction addSlotAction) {
        this.addSlotAction = addSlotAction;
    }

    public RemoveSlotAction getRemoveSlotAction() {
        return removeSlotAction;
    }

    public void setRemoveSlotAction(RemoveSlotAction removeSlotAction) {
        this.removeSlotAction = removeSlotAction;
    }

    public MoveSlotAction getMoveSlotAction() {
        return moveSlotAction;
    }

    public void setMoveSlotAction(MoveSlotAction moveSlotAction) {
        this.moveSlotAction = moveSlotAction;
    }

    public ChangeColorAction getChangeColorAction() {
        return changeColorAction;
    }

    public void setChangeColorAction(ChangeColorAction changeColorAction) {
        this.changeColorAction = changeColorAction;
    }

    public ChangeStrokeAction getChangeStrokeAction() {
        return changeStrokeAction;
    }

    public void setChangeStrokeAction(ChangeStrokeAction changeStrokeAction) {
        this.changeStrokeAction = changeStrokeAction;
    }

    public ChangeTicknessAction getChangeTicknessAction() {
        return changeTicknessAction;
    }

    public void setChangeTicknessAction(ChangeTicknessAction changeTicknessAction) {
        this.changeTicknessAction = changeTicknessAction;
    }

    public SelectSlotAction getSelectSlotAction() {
        return selectSlotAction;
    }

    public void setSelectSlotAction(SelectSlotAction selectSlotAction) {
        this.selectSlotAction = selectSlotAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public void setUndoAction(UndoAction undoAction) {
        this.undoAction = undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public void setRedoAction(RedoAction redoAction) {
        this.redoAction = redoAction;
    }

    public EditSlotAction getEditSlotAction() {
        return editSlotAction;
    }

    public void setEditSlotAction(EditSlotAction editSlotAction) {
        this.editSlotAction = editSlotAction;
    }

    public ShareAction getShareAction() {
        return shareAction;
    }

    public void setShareAction(ShareAction shareAction) {
        this.shareAction = shareAction;
    }

    public SaveAction getSaveAction() {
        return saveAction;
    }

    public OpenAction getOpenAction() {
        return openAction;
    }

    public void setOpenAction(OpenAction openAction) {
        this.openAction = openAction;
    }

    public void setSaveAction(SaveAction saveAction) {
        this.saveAction = saveAction;
    }

    public SaveWorkspaceAction getSaveWorkspaceAction() {
        return saveWorkspaceAction;
    }

    public void setSaveWorkspaceAction(SaveWorkspaceAction saveWorkspaceAction) {
        this.saveWorkspaceAction = saveWorkspaceAction;
    }

    public SavePresentationAction getSavePresentationAction() {
        return savePresentationAction;
    }

    public void setSavePresentationAction(SavePresentationAction savePresentationAction) {
        this.savePresentationAction = savePresentationAction;
    }

    public OpenPresentationAction getOpenPresentationAction() {
        return openPresentationAction;
    }

    public void setOpenPresentationAction(OpenPresentationAction openPresentationAction) {
        this.openPresentationAction = openPresentationAction;
    }
}
