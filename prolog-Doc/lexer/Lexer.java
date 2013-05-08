/* This file was generated by SableCC (http://www.sablecc.org/). */

package lexer;

import java.io.*;
import node.*;

@SuppressWarnings("nls")
public class Lexer
{
    protected Token token;
    protected State state = State.PL;

    private PushbackReader in;
    private int line;
    private int pos;
    private boolean cr;
    private boolean eof;
    private final StringBuffer text = new StringBuffer();

    @SuppressWarnings("unused")
    protected void filter() throws LexerException, IOException
    {
        // Do nothing
    }

    public Lexer(@SuppressWarnings("hiding") PushbackReader in)
    {
        this.in = in;
    }
 
    public Token peek() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        return this.token;
    }

    public Token next() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        Token result = this.token;
        this.token = null;
        return result;
    }

    protected Token getToken() throws IOException, LexerException
    {
        int dfa_state = 0;

        int start_pos = this.pos;
        int start_line = this.line;

        int accept_state = -1;
        int accept_token = -1;
        int accept_length = -1;
        int accept_pos = -1;
        int accept_line = -1;

        @SuppressWarnings("hiding") int[][][] gotoTable = Lexer.gotoTable[this.state.id()];
        @SuppressWarnings("hiding") int[] accept = Lexer.accept[this.state.id()];
        this.text.setLength(0);

        while(true)
        {
            int c = getChar();

            if(c != -1)
            {
                switch(c)
                {
                case 10:
                    if(this.cr)
                    {
                        this.cr = false;
                    }
                    else
                    {
                        this.line++;
                        this.pos = 0;
                    }
                    break;
                case 13:
                    this.line++;
                    this.pos = 0;
                    this.cr = true;
                    break;
                default:
                    this.pos++;
                    this.cr = false;
                    break;
                }

                this.text.append((char) c);

                do
                {
                    int oldState = (dfa_state < -1) ? (-2 -dfa_state) : dfa_state;

                    dfa_state = -1;

                    int[][] tmp1 =  gotoTable[oldState];
                    int low = 0;
                    int high = tmp1.length - 1;

                    while(low <= high)
                    {
                        // int middle = (low + high) / 2;
                        int middle = (low + high) >>> 1;
                        int[] tmp2 = tmp1[middle];

                        if(c < tmp2[0])
                        {
                            high = middle - 1;
                        }
                        else if(c > tmp2[1])
                        {
                            low = middle + 1;
                        }
                        else
                        {
                            dfa_state = tmp2[2];
                            break;
                        }
                    }
                }while(dfa_state < -1);
            }
            else
            {
                dfa_state = -1;
            }

            if(dfa_state >= 0)
            {
                if(accept[dfa_state] != -1)
                {
                    accept_state = dfa_state;
                    accept_token = accept[dfa_state];
                    accept_length = this.text.length();
                    accept_pos = this.pos;
                    accept_line = this.line;
                }
            }
            else
            {
                if(accept_state != -1)
                {
                    switch(accept_token)
                    {
                    case 0:
                        {
                            @SuppressWarnings("hiding") Token token = new0(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.PL; break;
                            }
                            return token;
                        }
                    case 1:
                        {
                            @SuppressWarnings("hiding") Token token = new1(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.DOC; break;
                            }
                            return token;
                        }
                    case 2:
                        {
                            @SuppressWarnings("hiding") Token token = new2(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 1: state = State.PL; break;
                            }
                            return token;
                        }
                    case 3:
                        {
                            @SuppressWarnings("hiding") Token token = new3(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.PL; break;
                            }
                            return token;
                        }
                    case 4:
                        {
                            @SuppressWarnings("hiding") Token token = new4(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.PL; break;
                            }
                            return token;
                        }
                    case 5:
                        {
                            @SuppressWarnings("hiding") Token token = new5(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 1: state = State.DOC; break;
                            }
                            return token;
                        }
                    case 6:
                        {
                            @SuppressWarnings("hiding") Token token = new6(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 1: state = State.DOC; break;
                            }
                            return token;
                        }
                    case 7:
                        {
                            @SuppressWarnings("hiding") Token token = new7(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 1: state = State.DOC; break;
                            }
                            return token;
                        }
                    case 8:
                        {
                            @SuppressWarnings("hiding") Token token = new8(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 1: state = State.DOC; break;
                            }
                            return token;
                        }
                    case 9:
                        {
                            @SuppressWarnings("hiding") Token token = new9(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 1: state = State.DOC; break;
                            }
                            return token;
                        }
                    case 10:
                        {
                            @SuppressWarnings("hiding") Token token = new10(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 0: state = State.PL; break;
                            }
                            return token;
                        }
                    case 11:
                        {
                            @SuppressWarnings("hiding") Token token = new11(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            switch(state.id())
                            {
                                case 1: state = State.DOC; break;
                            }
                            return token;
                        }
                    }
                }
                else
                {
                    if(this.text.length() > 0)
                    {
                        throw new LexerException(
                            "[" + (start_line + 1) + "," + (start_pos + 1) + "]" +
                            " Unknown token: " + this.text);
                    }

                    @SuppressWarnings("hiding") EOF token = new EOF(
                        start_line + 1,
                        start_pos + 1);
                    return token;
                }
            }
        }
    }

    Token new0(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TIgnore(text, line, pos); }
    Token new1(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDocStart(text, line, pos); }
    Token new2(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDocEnd(text, line, pos); }
    Token new3(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TCommentStart(text, line, pos); }
    Token new4(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TCommentEnd(text, line, pos); }
    Token new5(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDocDescr(text, line, pos); }
    Token new6(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDocDate(text, line, pos); }
    Token new7(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDocAuthor(text, line, pos); }
    Token new8(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDocAtdoc(text, line, pos); }
    Token new9(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDocIdentifier(text, line, pos); }
    Token new10(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TProgramm(text, line, pos); }
    Token new11(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TString(text, line, pos); }

    private int getChar() throws IOException
    {
        if(this.eof)
        {
            return -1;
        }

        int result = this.in.read();

        if(result == -1)
        {
            this.eof = true;
        }

        return result;
    }

    private void pushBack(int acceptLength) throws IOException
    {
        int length = this.text.length();
        for(int i = length - 1; i >= acceptLength; i--)
        {
            this.eof = false;

            this.in.unread(this.text.charAt(i));
        }
    }

    protected void unread(@SuppressWarnings("hiding") Token token) throws IOException
    {
        @SuppressWarnings("hiding") String text = token.getText();
        int length = text.length();

        for(int i = length - 1; i >= 0; i--)
        {
            this.eof = false;

            this.in.unread(text.charAt(i));
        }

        this.pos = token.getPos() - 1;
        this.line = token.getLine() - 1;
    }

    private String getText(int acceptLength)
    {
        StringBuffer s = new StringBuffer(acceptLength);
        for(int i = 0; i < acceptLength; i++)
        {
            s.append(this.text.charAt(i));
        }

        return s.toString();
    }

    private static int[][][][] gotoTable;
/*  {
        { // PL
            {{0, 8, 1}, {9, 9, 2}, {10, 10, 3}, {11, 12, 1}, {13, 13, 4}, {14, 31, 1}, {32, 32, 5}, {33, 41, 1}, {42, 42, 6}, {43, 46, 1}, {47, 47, 7}, {48, 63, 1}, {65, 237, 1}, },
            {{0, 8, 8}, {9, 9, 9}, {10, 10, 10}, {11, 12, 8}, {13, 13, 11}, {14, 31, 8}, {32, 32, 12}, {33, 41, 8}, {42, 42, 13}, {43, 46, 8}, {47, 47, 14}, {48, 63, 8}, {65, 237, 8}, },
            {{0, 8, 15}, {9, 9, 16}, {10, 10, 3}, {11, 12, 15}, {13, 13, 17}, {14, 31, 15}, {32, 32, 18}, {33, 41, 15}, {42, 42, 6}, {43, 46, 15}, {47, 47, 19}, {48, 63, 15}, {65, 237, 15}, },
            {{0, 8, 20}, {9, 9, 21}, {10, 10, 3}, {11, 12, 20}, {13, 13, 22}, {14, 31, 20}, {32, 32, 23}, {33, 41, 20}, {42, 42, 24}, {43, 46, 20}, {47, 47, 25}, {48, 63, 20}, {65, 237, 20}, },
            {{0, 237, -4}, },
            {{0, 237, -4}, },
            {{0, 46, -3}, {47, 47, 26}, {48, 237, -3}, },
            {{0, 9, 13}, {10, 10, 27}, {11, 41, 13}, {42, 42, 28}, {43, 46, 13}, {47, 47, 27}, {48, 63, 13}, {65, 237, 13}, },
            {{0, 8, 29}, {9, 9, 30}, {10, 10, 31}, {11, 12, 29}, {13, 13, 32}, {14, 31, 29}, {32, 32, 33}, {33, 41, 29}, {42, 42, 34}, {43, 46, 29}, {47, 47, 35}, {48, 63, 29}, {65, 237, 29}, },
            {{0, 237, -10}, },
            {{9, 9, 36}, {10, 10, 31}, {13, 13, 37}, {32, 32, 38}, },
            {{0, 237, -10}, },
            {{0, 237, -10}, },
            {{0, 237, -10}, },
            {{0, 8, 39}, {9, 9, 40}, {10, 10, 31}, {11, 12, 39}, {13, 13, 41}, {14, 31, 39}, {32, 32, 42}, {33, 41, 39}, {42, 42, 34}, {43, 46, 39}, {47, 47, 43}, {48, 63, 39}, {65, 237, 39}, },
            {{0, 237, -3}, },
            {{0, 237, -4}, },
            {{0, 237, -4}, },
            {{0, 237, -4}, },
            {{0, 8, 44}, {9, 9, 45}, {10, 10, 10}, {11, 12, 44}, {13, 13, 46}, {14, 31, 44}, {32, 32, 47}, {33, 41, 44}, {42, 42, 28}, {43, 46, 44}, {47, 47, 48}, {48, 63, 44}, {65, 237, 44}, },
            {{0, 63, 27}, {65, 237, 27}, },
            {{0, 237, -5}, },
            {{0, 237, -5}, },
            {{0, 237, -5}, },
            {{0, 46, 27}, {47, 47, 49}, {48, 63, 27}, {65, 237, 27}, },
            {{0, 41, 27}, {42, 42, 50}, {43, 63, 27}, {65, 237, 27}, },
            {{0, 8, 39}, {9, 9, 51}, {10, 10, 52}, {11, 12, 39}, {13, 13, 53}, {14, 31, 39}, {32, 32, 54}, {33, 237, -16}, },
            {},
            {{0, 8, 29}, {9, 9, 55}, {10, 10, 56}, {11, 12, 29}, {13, 13, 57}, {14, 31, 29}, {32, 32, 58}, {33, 41, 29}, {42, 42, 59}, {43, 237, -10}, },
            {{0, 237, -10}, },
            {{0, 237, -10}, },
            {{9, 32, -12}, },
            {{0, 237, -10}, },
            {{0, 237, -10}, },
            {{0, 237, -10}, },
            {{0, 237, -16}, },
            {{9, 32, -12}, },
            {{9, 32, -12}, },
            {{9, 32, -12}, },
            {{0, 237, -10}, },
            {{0, 237, -10}, },
            {{0, 237, -10}, },
            {{0, 237, -10}, },
            {{0, 9, 34}, {11, 46, 34}, {48, 63, 34}, {65, 237, 34}, },
            {{0, 237, -10}, },
            {{0, 237, -10}, },
            {{0, 237, -10}, },
            {{0, 237, -10}, },
            {{0, 237, -45}, },
            {{9, 9, 60}, {10, 10, 61}, {13, 13, 62}, {32, 32, 63}, },
            {{9, 9, 64}, {10, 10, 65}, {13, 13, 66}, {32, 32, 67}, {42, 42, 68}, },
            {{0, 8, 29}, {9, 9, 69}, {10, 10, 52}, {11, 12, 29}, {13, 13, 70}, {14, 31, 29}, {32, 32, 71}, {33, 237, -10}, },
            {{9, 9, 72}, {10, 10, 52}, {13, 13, 73}, {32, 32, 74}, },
            {{0, 237, -53}, },
            {{0, 237, -53}, },
            {{0, 41, -30}, {42, 237, -10}, },
            {{9, 9, 75}, {10, 10, 56}, {13, 13, 76}, {32, 32, 77}, },
            {{0, 237, -57}, },
            {{0, 237, -57}, },
            {{0, 8, 29}, {9, 9, 78}, {10, 10, 79}, {11, 12, 29}, {13, 13, 80}, {14, 31, 29}, {32, 32, 81}, {33, 41, 29}, {42, 42, 82}, {43, 237, -10}, },
            {{9, 32, -51}, },
            {{9, 32, -51}, },
            {{9, 32, -51}, },
            {{9, 32, -51}, },
            {{9, 32, -52}, },
            {{9, 32, -52}, },
            {{9, 32, -52}, },
            {{9, 32, -52}, },
            {{9, 9, 83}, {10, 10, 84}, {13, 13, 85}, {32, 32, 86}, {42, 42, 87}, },
            {{0, 237, -53}, },
            {{0, 237, -53}, },
            {{0, 237, -53}, },
            {{9, 32, -54}, },
            {{9, 32, -54}, },
            {{9, 32, -54}, },
            {{9, 32, -58}, },
            {{9, 32, -58}, },
            {{9, 32, -58}, },
            {{0, 41, -61}, {42, 237, -10}, },
            {{9, 9, 88}, {10, 10, 79}, {13, 13, 89}, {32, 32, 90}, },
            {{0, 237, -80}, },
            {{0, 237, -80}, },
            {{0, 41, -10}, {42, 237, -61}, },
            {{9, 32, -70}, },
            {{9, 32, -70}, },
            {{9, 32, -70}, },
            {{9, 32, -70}, },
            {{42, 42, 87}, },
            {{9, 32, -81}, },
            {{9, 32, -81}, },
            {{9, 32, -81}, },
        }
        { // DOC
            {{0, 8, 1}, {9, 9, 2}, {10, 10, 3}, {11, 12, 1}, {13, 13, 4}, {14, 31, 1}, {32, 32, 5}, {33, 41, 1}, {42, 42, 6}, {43, 46, 1}, {47, 47, 7}, {48, 63, 1}, {64, 64, 8}, {65, 90, 9}, {91, 94, 1}, {95, 95, 10}, {96, 96, 1}, {97, 122, 11}, {123, 237, 1}, },
            {{0, 8, 12}, {9, 9, 13}, {10, 10, 14}, {11, 12, 12}, {13, 13, 15}, {14, 31, 12}, {32, 32, 16}, {33, 41, 12}, {42, 42, 17}, {43, 46, 12}, {47, 47, 18}, {48, 63, 12}, {65, 237, 12}, },
            {{0, 8, 19}, {9, 9, 20}, {10, 10, 3}, {11, 12, 19}, {13, 13, 21}, {14, 31, 19}, {32, 32, 22}, {33, 41, 19}, {42, 42, 6}, {43, 46, 19}, {47, 47, 23}, {48, 63, 19}, {64, 64, 8}, {65, 237, 19}, },
            {{0, 8, 24}, {9, 9, 25}, {10, 10, 3}, {11, 12, 24}, {13, 13, 26}, {14, 31, 24}, {32, 32, 27}, {33, 41, 24}, {42, 42, 28}, {43, 63, 24}, {64, 64, 8}, {65, 237, 24}, },
            {{0, 237, -4}, },
            {{0, 237, -4}, },
            {{0, 41, -3}, {42, 42, 29}, {43, 46, 12}, {47, 47, 30}, {48, 237, -3}, },
            {{0, 9, 17}, {10, 10, 31}, {11, 46, 17}, {47, 47, 31}, {48, 63, 17}, {65, 237, 17}, },
            {{65, 65, 32}, {66, 67, 33}, {68, 68, 34}, {69, 90, 33}, {95, 95, 35}, {97, 97, 36}, {98, 99, 37}, {100, 100, 38}, {101, 122, 37}, },
            {{0, 63, -3}, {65, 90, 39}, {91, 94, 12}, {95, 95, 40}, {96, 96, 12}, {97, 122, 41}, {123, 237, 12}, },
            {{0, 237, -11}, },
            {{0, 237, -11}, },
            {{0, 8, 42}, {9, 9, 43}, {10, 10, 44}, {11, 12, 42}, {13, 13, 45}, {14, 31, 42}, {32, 32, 46}, {33, 41, 42}, {42, 42, 47}, {43, 46, 42}, {47, 47, 48}, {48, 63, 42}, {65, 237, 42}, },
            {{0, 237, -14}, },
            {{9, 9, 49}, {10, 10, 44}, {13, 13, 50}, {32, 32, 51}, },
            {{0, 237, -14}, },
            {{0, 237, -14}, },
            {{0, 237, -14}, },
            {{0, 8, 52}, {9, 9, 53}, {10, 10, 44}, {11, 12, 52}, {13, 13, 54}, {14, 31, 52}, {32, 32, 55}, {33, 41, 52}, {42, 42, 47}, {43, 46, 52}, {47, 47, 56}, {48, 63, 52}, {65, 237, 52}, },
            {{0, 237, -3}, },
            {{0, 237, -4}, },
            {{0, 237, -4}, },
            {{0, 237, -4}, },
            {{0, 8, 57}, {9, 9, 58}, {10, 10, 14}, {11, 12, 57}, {13, 13, 59}, {14, 31, 57}, {32, 32, 60}, {33, 41, 57}, {42, 42, 17}, {43, 46, 57}, {47, 47, 61}, {48, 63, 57}, {65, 237, 57}, },
            {{0, 63, 31}, {65, 237, 31}, },
            {{0, 237, -5}, },
            {{0, 237, -5}, },
            {{0, 237, -5}, },
            {{0, 41, 31}, {42, 42, 62}, {43, 46, 31}, {47, 47, 63}, {48, 63, 31}, {65, 237, 31}, },
            {{0, 41, -14}, {42, 42, 64}, {43, 46, 42}, {47, 47, 65}, {48, 237, -14}, },
            {{0, 8, 52}, {9, 9, 66}, {10, 10, 67}, {11, 12, 52}, {13, 13, 68}, {14, 31, 52}, {32, 32, 69}, {33, 41, 52}, {42, 42, 70}, {43, 237, -20}, },
            {},
            {{9, 9, 71}, {10, 10, 72}, {13, 13, 73}, {32, 32, 74}, {65, 84, 33}, {85, 85, 75}, {86, 90, 33}, {95, 95, 35}, {97, 116, 37}, {117, 117, 76}, {118, 122, 37}, },
            {{9, 32, -34}, {65, 90, 33}, {95, 95, 35}, {97, 122, 37}, },
            {{9, 32, -34}, {65, 65, 77}, {66, 68, 33}, {69, 69, 78}, {70, 90, 33}, {95, 95, 35}, {97, 97, 79}, {98, 100, 37}, {101, 101, 80}, {102, 122, 37}, },
            {{9, 122, -35}, },
            {{9, 122, -34}, },
            {{9, 122, -35}, },
            {{9, 122, -36}, },
            {{0, 63, -14}, {65, 90, 81}, {91, 94, 42}, {95, 95, 82}, {96, 96, 42}, {97, 122, 83}, {123, 237, 42}, },
            {{0, 237, -41}, },
            {{0, 237, -41}, },
            {{0, 237, -14}, },
            {{0, 237, -14}, },
            {{9, 32, -16}, },
            {{0, 237, -14}, },
            {{0, 237, -14}, },
            {{0, 237, -14}, },
            {{0, 237, -20}, },
            {{9, 32, -16}, },
            {{9, 32, -16}, },
            {{9, 32, -16}, },
            {{0, 237, -14}, },
            {{0, 237, -14}, },
            {{0, 237, -14}, },
            {{0, 237, -14}, },
            {{0, 9, 47}, {11, 46, 47}, {48, 63, 47}, {65, 237, 47}, },
            {{0, 237, -14}, },
            {{0, 237, -14}, },
            {{0, 237, -14}, },
            {{0, 237, -14}, },
            {{0, 237, -58}, },
            {{42, 42, 84}, {47, 47, 85}, },
            {{9, 9, 86}, {10, 10, 87}, {13, 13, 88}, {32, 32, 89}, {42, 42, 90}, },
            {{0, 237, -31}, },
            {{0, 237, -32}, },
            {{0, 8, 42}, {9, 9, 91}, {10, 10, 67}, {11, 12, 42}, {13, 13, 92}, {14, 31, 42}, {32, 32, 93}, {33, 237, -14}, },
            {{9, 9, 94}, {10, 10, 67}, {13, 13, 95}, {32, 32, 96}, },
            {{0, 237, -68}, },
            {{0, 237, -68}, },
            {{0, 41, -14}, {42, 42, 70}, {43, 237, -14}, },
            {{9, 32, -34}, },
            {{9, 32, -34}, },
            {{9, 32, -34}, },
            {{9, 32, -34}, },
            {{9, 32, -34}, {65, 83, 33}, {84, 84, 97}, {85, 90, 33}, {95, 95, 35}, {97, 115, 37}, {116, 116, 98}, {117, 122, 37}, },
            {{9, 122, -77}, },
            {{9, 83, -77}, {84, 84, 99}, {85, 115, -77}, {116, 116, 100}, {117, 122, 37}, },
            {{9, 32, -34}, {65, 82, 33}, {83, 83, 101}, {84, 90, 33}, {95, 95, 35}, {97, 114, 37}, {115, 115, 102}, {116, 122, 37}, },
            {{9, 122, -79}, },
            {{9, 122, -80}, },
            {{0, 237, -41}, },
            {{0, 237, -41}, },
            {{0, 237, -41}, },
            {{42, 47, -64}, },
            {{9, 42, -65}, },
            {{9, 32, -65}, },
            {{9, 32, -65}, },
            {{9, 32, -65}, },
            {{9, 32, -65}, },
            {{42, 42, 90}, },
            {{0, 237, -68}, },
            {{0, 237, -68}, },
            {{0, 237, -68}, },
            {{9, 32, -69}, },
            {{9, 32, -69}, },
            {{9, 32, -69}, },
            {{9, 32, -34}, {65, 71, 33}, {72, 72, 103}, {73, 90, 33}, {95, 95, 35}, {97, 103, 37}, {104, 104, 104}, {105, 122, 37}, },
            {{9, 122, -99}, },
            {{9, 32, -34}, {65, 68, 33}, {69, 69, 105}, {70, 95, -36}, {97, 100, 37}, {101, 101, 106}, {102, 122, 37}, },
            {{9, 122, -101}, },
            {{9, 32, -34}, {65, 66, 33}, {67, 67, 107}, {68, 90, 33}, {95, 95, 35}, {97, 98, 37}, {99, 99, 108}, {100, 122, 37}, },
            {{9, 122, -103}, },
            {{9, 32, -34}, {65, 78, 33}, {79, 79, 109}, {80, 90, 33}, {95, 95, 35}, {97, 110, 37}, {111, 111, 110}, {112, 122, 37}, },
            {{9, 122, -105}, },
            {{9, 9, 111}, {10, 10, 112}, {13, 13, 113}, {32, 32, 114}, {65, 122, -35}, },
            {{9, 122, -107}, },
            {{9, 32, -34}, {65, 81, 33}, {82, 82, 115}, {83, 90, 33}, {95, 95, 35}, {97, 113, 37}, {114, 114, 116}, {115, 122, 37}, },
            {{9, 122, -109}, },
            {{9, 81, -109}, {82, 82, 117}, {83, 113, -109}, {114, 114, 118}, {115, 122, 37}, },
            {{9, 122, -111}, },
            {{9, 32, -107}, },
            {{9, 32, -107}, },
            {{9, 32, -107}, },
            {{9, 32, -107}, },
            {{9, 9, 119}, {10, 10, 120}, {13, 13, 121}, {32, 32, 122}, {65, 72, 33}, {73, 73, 123}, {74, 90, 33}, {95, 95, 35}, {97, 104, 37}, {105, 105, 124}, {106, 122, 37}, },
            {{9, 122, -117}, },
            {{9, 9, 125}, {10, 10, 126}, {13, 13, 127}, {32, 32, 128}, {65, 122, -35}, },
            {{9, 122, -119}, },
            {{9, 32, -117}, },
            {{9, 32, -117}, },
            {{9, 32, -117}, },
            {{9, 32, -117}, },
            {{9, 32, -34}, {65, 79, 33}, {80, 80, 129}, {81, 90, 33}, {95, 95, 35}, {97, 111, 37}, {112, 112, 130}, {113, 122, 37}, },
            {{9, 122, -125}, },
            {{9, 32, -119}, },
            {{9, 32, -119}, },
            {{9, 32, -119}, },
            {{9, 32, -119}, },
            {{9, 83, -77}, {84, 84, 131}, {85, 115, -77}, {116, 116, 132}, {117, 122, 37}, },
            {{9, 122, -131}, },
            {{9, 32, -34}, {65, 72, 33}, {73, 73, 133}, {74, 104, -117}, {105, 105, 134}, {106, 122, 37}, },
            {{9, 122, -133}, },
            {{9, 78, -105}, {79, 79, 135}, {80, 110, -105}, {111, 111, 136}, {112, 122, 37}, },
            {{9, 122, -135}, },
            {{9, 32, -34}, {65, 77, 33}, {78, 78, 137}, {79, 90, 33}, {95, 95, 35}, {97, 109, 37}, {110, 110, 138}, {111, 122, 37}, },
            {{9, 122, -137}, },
            {{9, 32, -117}, {65, 122, -35}, },
            {{9, 122, -139}, },
        }
    };*/

    private static int[][] accept;
/*  {
        // PL
        {10, 10, 0, 0, 0, 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, 0, 0, 10, 10, 0, 0, 0, 10, 10, 4, 10, 3, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, -1, 10, 10, 10, 10, 10, 4, 3, 4, 4, 4, 4, 3, 3, 3, 3, 1, 4, 4, 4, 4, 3, 3, 3, 3, 1, 4, 4, 4, 4, 4, 4, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
        // DOC
        {11, 11, 11, 11, 11, 11, 11, 11, -1, 9, 9, 9, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 2, 11, -1, -1, -1, -1, -1, -1, -1, 9, 9, 9, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, -1, 11, 11, 11, 11, 11, 11, 2, 11, 2, 2, 2, 2, 2, 2, 8, 8, 8, 8, -1, -1, -1, -1, -1, -1, 9, 9, 9, -1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, 6, 6, 6, -1, -1, -1, -1, 5, 5, 5, 5, -1, -1, 7, 7, 7, 7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },

    };*/

    public static class State
    {
        public final static State PL = new State(0);
        public final static State DOC = new State(1);

        private int id;

        private State(@SuppressWarnings("hiding") int id)
        {
            this.id = id;
        }

        public int id()
        {
            return this.id;
        }
    }

    static 
    {
        try
        {
            DataInputStream s = new DataInputStream(
                new BufferedInputStream(
                Lexer.class.getResourceAsStream("lexer.dat")));

            // read gotoTable
            int length = s.readInt();
            gotoTable = new int[length][][][];
            for(int i = 0; i < gotoTable.length; i++)
            {
                length = s.readInt();
                gotoTable[i] = new int[length][][];
                for(int j = 0; j < gotoTable[i].length; j++)
                {
                    length = s.readInt();
                    gotoTable[i][j] = new int[length][3];
                    for(int k = 0; k < gotoTable[i][j].length; k++)
                    {
                        for(int l = 0; l < 3; l++)
                        {
                            gotoTable[i][j][k][l] = s.readInt();
                        }
                    }
                }
            }

            // read accept
            length = s.readInt();
            accept = new int[length][];
            for(int i = 0; i < accept.length; i++)
            {
                length = s.readInt();
                accept[i] = new int[length];
                for(int j = 0; j < accept[i].length; j++)
                {
                    accept[i][j] = s.readInt();
                }
            }

            s.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException("The file \"lexer.dat\" is either missing or corrupted.");
        }
    }
}
