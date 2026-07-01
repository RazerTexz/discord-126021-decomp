package lombok.javac.java8;

import com.sun.tools.javac.parser.ScannerFactory;
import com.sun.tools.javac.parser.UnicodeReader;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: app.apk:lombok/javac/java8/CommentCollectingTokenizer$PositionUnicodeReader.SCL.lombok */
class CommentCollectingTokenizer$PositionUnicodeReader extends UnicodeReader {
    protected CommentCollectingTokenizer$PositionUnicodeReader(ScannerFactory sf, char[] input, int inputLength) {
        super(sf, input, inputLength);
    }

    public CommentCollectingTokenizer$PositionUnicodeReader(ScannerFactory sf, CharBuffer buffer) {
        super(sf, buffer);
    }

    int pos() {
        return this.bp;
    }
}
