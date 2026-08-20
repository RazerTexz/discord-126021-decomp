package lombok.javac.java9;

import com.sun.tools.javac.parser.JavacParser;
import com.sun.tools.javac.parser.Lexer;
import com.sun.tools.javac.parser.ParserFactory;
import com.sun.tools.javac.tree.JCTree;
import lombok.javac.CommentCatcher;
import lombok.javac.java8.CommentCollectingScanner;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/java9/CommentCollectingParser.SCL.lombok */
class CommentCollectingParser extends JavacParser {
    private final Lexer lexer;

    protected CommentCollectingParser(ParserFactory fac, Lexer S, boolean keepDocComments, boolean keepLineMap, boolean keepEndPositions, boolean parseModuleInfo) {
        super(fac, S, keepDocComments, keepLineMap, keepEndPositions, parseModuleInfo);
        this.lexer = S;
    }

    public JCTree.JCCompilationUnit parseCompilationUnit() {
        JCTree.JCCompilationUnit result = super.parseCompilationUnit();
        if (this.lexer instanceof CommentCollectingScanner) {
            CommentCatcher.JCCompilationUnit_comments.set(result, this.lexer.getComments());
            CommentCatcher.JCCompilationUnit_textBlockStarts.set(result, this.lexer.getTextBlockStarts());
        }
        return result;
    }
}
