/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class TProgrammSlashSlash extends Token
{
    public TProgrammSlashSlash()
    {
        super.setText("/");
    }

    public TProgrammSlashSlash(int line, int pos)
    {
        super.setText("/");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TProgrammSlashSlash(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTProgrammSlashSlash(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TProgrammSlashSlash text.");
    }
}