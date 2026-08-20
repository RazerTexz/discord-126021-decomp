package lombok.javac.java8;

import com.sun.tools.javac.parser.JavaTokenizer;
import com.sun.tools.javac.parser.ScannerFactory;
import com.sun.tools.javac.parser.Tokens;
import com.sun.tools.javac.parser.UnicodeReader;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import java.nio.CharBuffer;
import lombok.javac.CommentInfo;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/java8/CommentCollectingTokenizer.SCL.lombok */
class CommentCollectingTokenizer extends JavaTokenizer {
    private int prevEndPosition;
    private final ListBuffer<CommentInfo> comments;
    private final ListBuffer<Integer> textBlockStarts;
    private int endComment;

    CommentCollectingTokenizer(ScannerFactory fac, char[] buf, int inputLength, boolean findTextBlocks) {
        super(fac, new PositionUnicodeReader(fac, buf, inputLength));
        this.prevEndPosition = 0;
        this.comments = new ListBuffer<>();
        this.endComment = 0;
        this.textBlockStarts = findTextBlocks ? new ListBuffer<>() : null;
    }

    CommentCollectingTokenizer(ScannerFactory fac, CharBuffer buf, boolean findTextBlocks) {
        super(fac, new PositionUnicodeReader(fac, buf));
        this.prevEndPosition = 0;
        this.comments = new ListBuffer<>();
        this.endComment = 0;
        this.textBlockStarts = findTextBlocks ? new ListBuffer<>() : null;
    }

    int pos() {
        return ((PositionUnicodeReader) this.reader).pos();
    }

    public Tokens.Token readToken() {
        Tokens.Token token = super.readToken();
        this.prevEndPosition = pos();
        if (this.textBlockStarts != null && this.prevEndPosition - token.pos > 5 && token.getClass().getName().endsWith("$StringToken")) {
            char[] start = this.reader.getRawCharacters(token.pos, token.pos + 3);
            if (start[0] == '\"' && start[1] == '\"' && start[2] == '\"') {
                this.textBlockStarts.add(Integer.valueOf(token.pos));
            }
        }
        return token;
    }

    protected Tokens.Comment processComment(int pos, int endPos, Tokens.Comment.CommentStyle style) {
        int prevEndPos = Math.max(this.prevEndPosition, this.endComment);
        this.endComment = endPos;
        String content = new String(this.reader.getRawCharacters(pos, endPos));
        CommentInfo.StartConnection start = determineStartConnection(prevEndPos, pos);
        CommentInfo.EndConnection end = determineEndConnection(endPos);
        CommentInfo comment = new CommentInfo(prevEndPos, pos, endPos, content, start, end);
        this.comments.append(comment);
        return super.processComment(pos, endPos, style);
    }

    private CommentInfo.EndConnection determineEndConnection(int pos) {
        char c;
        boolean first = true;
        int i = pos;
        while (true) {
            try {
                c = this.reader.getRawCharacters(i, i + 1)[0];
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
        char[] between = this.reader.getRawCharacters(from, to);
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

    public List<Integer> getTextBlockStarts() {
        return this.textBlockStarts == null ? List.nil() : this.textBlockStarts.toList();
    }

    /* JADX INFO: loaded from: discord-126021.apk:lombok/javac/java8/CommentCollectingTokenizer$PositionUnicodeReader.SCL.lombok */
    static class PositionUnicodeReader extends UnicodeReader {
        protected PositionUnicodeReader(ScannerFactory sf, char[] input, int inputLength) {
            super(sf, input, inputLength);
        }

        public PositionUnicodeReader(ScannerFactory sf, CharBuffer buffer) {
            super(sf, buffer);
        }

        int pos() {
            return this.bp;
        }
    }
}
