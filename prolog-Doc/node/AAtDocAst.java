/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import java.util.*;
import analysis.*;

@SuppressWarnings("nls")
public final class AAtDocAst extends PAst
{
    private TDocAtdoc _identifier_;
    private final LinkedList<PAst> _description_ = new LinkedList<PAst>();

    public AAtDocAst()
    {
        // Constructor
    }

    public AAtDocAst(
        @SuppressWarnings("hiding") TDocAtdoc _identifier_,
        @SuppressWarnings("hiding") List<?> _description_)
    {
        // Constructor
        setIdentifier(_identifier_);

        setDescription(_description_);

    }

    @Override
    public Object clone()
    {
        return new AAtDocAst(
            cloneNode(this._identifier_),
            cloneList(this._description_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAtDocAst(this);
    }

    public TDocAtdoc getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TDocAtdoc node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    public LinkedList<PAst> getDescription()
    {
        return this._description_;
    }

    public void setDescription(List<?> list)
    {
        for(PAst e : this._description_)
        {
            e.parent(null);
        }
        this._description_.clear();

        for(Object obj_e : list)
        {
            PAst e = (PAst) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._description_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifier_)
            + toString(this._description_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._description_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identifier_ == oldChild)
        {
            setIdentifier((TDocAtdoc) newChild);
            return;
        }

        for(ListIterator<PAst> i = this._description_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PAst) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}