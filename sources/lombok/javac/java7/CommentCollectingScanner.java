package lombok.javac.java7;

import com.sun.tools.javac.parser.Scanner;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import java.nio.CharBuffer;
import lombok.javac.CommentInfo;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/java7/CommentCollectingScanner.SCL.lombok */
public class CommentCollectingScanner extends Scanner {
    private final ListBuffer<CommentInfo> comments;
    private int endComment;

    public CommentCollectingScanner(CommentCollectingScannerFactory factory, CharBuffer charBuffer) {
        super(factory, charBuffer);
        this.comments = new ListBuffer<>();
        this.endComment = 0;
    }

    public CommentCollectingScanner(CommentCollectingScannerFactory factory, char[] input, int inputLength) {
        super(factory, input, inputLength);
        this.comments = new ListBuffer<>();
        this.endComment = 0;
    }

    protected void processComment(Scanner.CommentStyle style) {
        int prevEndPos = Math.max(prevEndPos(), this.endComment);
        int pos = pos();
        int endPos = endPos();
        this.endComment = endPos;
        String content = new String(getRawCharacters(pos, endPos));
        CommentInfo.StartConnection start = determineStartConnection(prevEndPos, pos);
        CommentInfo.EndConnection end = determineEndConnection(endPos);
        CommentInfo comment = new CommentInfo(prevEndPos, pos, endPos, content, start, end);
        this.comments.append(comment);
        super.processComment(style);
    }

    private CommentInfo.EndConnection determineEndConnection(int pos) {
        char c;
        boolean first = true;
        int i = pos;
        while (true) {
            try {
                c = getRawCharacters(i, i + 1)[0];
            } catch (IndexOutOfBoundsException unused) {
                c = '\n';
            }
            if (isNewLine(c)) {
                return CommentInfo.EndConnection.ON_NEXT_LINE;
            }
            if (!Character.isWhitespace(c)) {
                return first ? CommentInfo.EndConnection.DIRECT_AFTER_COMMENT : CommentInfo.EndConnection.AFTER_COMMENT;
            }
            first = false;
            i++;
        }
    }

    private CommentInfo.StartConnection determineStartConnection(int from, int to) {
        if (from == to) {
            return CommentInfo.StartConnection.DIRECT_AFTER_PREVIOUS;
        }
        char[] between = getRawCharacters(from, to);
        if (isNewLine(between[between.length - 1])) {
            return CommentInfo.StartConnection.START_OF_LINE;
        }
        for (char c : between) {
            if (isNewLine(c)) {
                return CommentInfo.StartConnection.ON_NEXT_LINE;
            }
        }
        return CommentInfo.StartConnection.AFTER_PREVIOUS;
    }

    private boolean isNewLine(char c) {
        return c == '\n' || c == '\r';
    }

    public List<CommentInfo> getComments() {
        return this.comments.toList();
    }
}
