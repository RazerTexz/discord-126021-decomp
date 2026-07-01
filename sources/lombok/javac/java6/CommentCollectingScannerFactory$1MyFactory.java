package lombok.javac.java6;

import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Context$Factory;

/* JADX INFO: loaded from: app.apk:lombok/javac/java6/CommentCollectingScannerFactory$1MyFactory.SCL.lombok */
class CommentCollectingScannerFactory$1MyFactory implements Context$Factory {
    private final /* synthetic */ Context val$context;

    CommentCollectingScannerFactory$1MyFactory(Context context) {
        this.val$context = context;
    }

    public Object make() {
        return new CommentCollectingScannerFactory(this.val$context);
    }

    public Object make(Context c) {
        return new CommentCollectingScannerFactory(c);
    }
}
