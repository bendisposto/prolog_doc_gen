/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class TDocSingleString extends Token
{
    public TDocSingleString(String text)
    {
        setText(text);
    }

    public TDocSingleString(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TDocSingleString(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDocSingleString(this);
    }
}
