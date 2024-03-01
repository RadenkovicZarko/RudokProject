package dswRudokApp.gui.tree;

import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.RuNodeComposite;
import dswRudokApp.gui.model.Workspace;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.*;

public class MyTreeNode extends DefaultMutableTreeNode {
    MyTreeNode parent;
    RuNode ruNode;
    private String name;


    public MyTreeNode( RuNode ruNode) {
        this.ruNode = ruNode;
        name=ruNode.getName();
        parent=null;
    }

    public MyTreeNode(MyTreeNode parent, RuNode ruNode) {
        this.parent = parent;
        this.ruNode = ruNode;
        name=ruNode.getName();
    }

    /*@Override
    public int getIndex(TreeNode aChild) {
        return findIndexByChild((MyTreeNode) aChild);
    }

    @Override
    public TreeNode getChildAt(int index) {
        return findChildByIndex(index);
    }

    private TreeNode findChildByIndex(int childIndex)
    {
        if(ruNode instanceof RuNode){
            MyTreeNode toLookFor = new MyTreeNode(((RuNodeComposite) ruNode).getListaRuNodova().get(childIndex));

            Iterator childrenIterator = children.iterator();
            TreeNode current;
            while (childrenIterator.hasNext()){
                current = (TreeNode) childrenIterator.next();
                if (current.equals(toLookFor))
                    return current;
            }
        }

        return null;
    }*/


    /*private int findIndexByChild(MyTreeNode node){

        if(this.ruNode instanceof RuNodeComposite){
            return  ((RuNodeComposite) this.ruNode).getListaRuNodova().indexOf(node.getRuNode());
        }
        return -1;
    }*/

    /*@Override
    public boolean getAllowsChildren() {
        if(ruNode instanceof RuNodeComposite)
            return true;
        return false;
    }*/

    @Override
    public boolean isLeaf() {
        if(ruNode instanceof RuNodeComposite)
            return false;
        return true;
    }

    @Override
    public Enumeration children() {
        if(ruNode instanceof RuNodeComposite)
            return (Enumeration)((RuNodeComposite)ruNode).getListaRuNodova();
        return null;
    }

   /* @Override
    public int getChildCount() {
        if(ruNode instanceof RuNodeComposite)
        {
          return ((RuNodeComposite) ruNode).getListaRuNodova().size();
        }
        return 0;
    }*/

    @Override
    public String toString() {
        return ruNode.toString() ;
    }

    public RuNode getRuNode() {
        return ruNode;
    }

    public void setRuNode(RuNode ruNode) {
        this.ruNode = ruNode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTreeNode that = (MyTreeNode) o;
        return Objects.equals(ruNode, that.ruNode) && Objects.equals(name, that.name);
    }*/

    @Override
    public MyTreeNode getParent() {
        return parent;
    }

    public void setParent(MyTreeNode parent) {
        this.parent = parent;
    }

    public boolean jednaki(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTreeNode that = (MyTreeNode) o;
        return Objects.equals(ruNode, that.ruNode) && Objects.equals(name, that.name);
    }
}
