package lombok.javac;

import com.sun.tools.javac.code.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacResolution$1$1.SCL.lombok */
class JavacResolution$1$1 implements Iterator<Type> {
    private boolean first = true;
    private Iterator<? extends Type> wrap;
    final /* synthetic */ JavacResolution$1 this$1;
    private final /* synthetic */ Type val$t;

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Type next() {
        return next();
    }

    JavacResolution$1$1(JavacResolution$1 javacResolution$1, Collection collection, Type type) {
        this.this$1 = javacResolution$1;
        this.val$t = type;
        this.wrap = collection == null ? null : collection.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.first) {
            return true;
        }
        if (this.wrap == null) {
            return false;
        }
        return this.wrap.hasNext();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Type next() {
        if (this.first) {
            this.first = false;
            return this.val$t;
        }
        if (this.wrap == null) {
            throw new NoSuchElementException();
        }
        return this.wrap.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
