package lombok.javac;

import com.sun.tools.javac.code.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacResolution$1.SCL.lombok */
class JavacResolution$1 implements Iterable<Type> {
    private final /* synthetic */ Collection val$ts;
    private final /* synthetic */ Type val$t;

    JavacResolution$1(Collection collection, Type type) {
        this.val$ts = collection;
        this.val$t = type;
    }

    @Override // java.lang.Iterable
    public Iterator<Type> iterator() {
        return new JavacResolution$1$1(this, this.val$ts, this.val$t);
    }
}
