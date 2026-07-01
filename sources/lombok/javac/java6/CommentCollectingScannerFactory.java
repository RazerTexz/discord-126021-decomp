package lombok.javac.java6;

import com.sun.tools.javac.parser.Scanner;
import com.sun.tools.javac.parser.Scanner$Factory;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Context$Factory;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: app.apk:lombok/javac/java6/CommentCollectingScannerFactory.SCL.lombok */
public class CommentCollectingScannerFactory extends Scanner$Factory {
    public static void preRegister(Context context) {
        if (context.get(scannerFactoryKey) == null) {
            Context$Factory<Scanner$Factory> factory = new CommentCollectingScannerFactory$1MyFactory(context);
            context.put(scannerFactoryKey, factory);
        }
    }

    protected CommentCollectingScannerFactory(Context context) {
        super(context);
    }

    public Scanner newScanner(CharSequence input) {
        if (input instanceof CharBuffer) {
            return new CommentCollectingScanner(this, (CharBuffer) input);
        }
        char[] array = input.toString().toCharArray();
        return newScanner(array, array.length);
    }

    public Scanner newScanner(char[] input, int inputLength) {
        return new CommentCollectingScanner(this, input, inputLength);
    }
}
