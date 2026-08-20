package lombok.javac.java7;

import com.sun.tools.javac.main.JavaCompiler;
import com.sun.tools.javac.parser.Parser;
import com.sun.tools.javac.parser.ParserFactory;
import com.sun.tools.javac.parser.ScannerFactory;
import com.sun.tools.javac.util.Context;
import java.lang.reflect.Field;
import lombok.permit.Permit;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/java7/CommentCollectingParserFactory.SCL.lombok */
public class CommentCollectingParserFactory extends ParserFactory {
    private final Context context;

    static Context.Key<ParserFactory> key() {
        return parserFactoryKey;
    }

    protected CommentCollectingParserFactory(Context context) {
        super(context);
        this.context = context;
    }

    public Parser newParser(CharSequence input, boolean keepDocComments, boolean keepEndPos, boolean keepLineMap) {
        ScannerFactory scannerFactory = ScannerFactory.instance(this.context);
        Object x2 = new CommentCollectingParser(this, scannerFactory.newScanner(input, true), true, keepLineMap);
        return (Parser) x2;
    }

    public static void setInCompiler(JavaCompiler compiler, Context context) {
        context.put(key(), (Object) null);
        try {
            Field field = Permit.getField(JavaCompiler.class, "parserFactory");
            field.set(compiler, new CommentCollectingParserFactory(context));
        } catch (Exception e) {
            throw new IllegalStateException("Could not set comment sensitive parser in the compiler", e);
        }
    }
}
