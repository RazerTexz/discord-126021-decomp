package lombok.javac.java8;

import com.sun.tools.javac.parser.Scanner;
import com.sun.tools.javac.parser.ScannerFactory;
import com.sun.tools.javac.util.List;
import lombok.javac.CommentInfo;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/java8/CommentCollectingScanner.SCL.lombok */
public class CommentCollectingScanner extends Scanner {
    private CommentCollectingTokenizer tokenizer;

    public CommentCollectingScanner(ScannerFactory fac, CommentCollectingTokenizer tokenizer) {
        super(fac, tokenizer);
        this.tokenizer = tokenizer;
    }

    public List<CommentInfo> getComments() {
        return this.tokenizer.getComments();
    }

    public List<Integer> getTextBlockStarts() {
        return this.tokenizer.getTextBlockStarts();
    }
}
