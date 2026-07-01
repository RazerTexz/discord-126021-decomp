package b.i.b.b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: AbstractIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> extends s0<T> {
    public int j = 2;

    @NullableDecl
    public T k;

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final boolean hasNext() {
        T t;
        int i = this.j;
        if (!(i != 4)) {
            throw new IllegalStateException();
        }
        int iH = b.c.a.y.b.h(i);
        if (iH == 0) {
            return true;
        }
        if (iH == 2) {
            return false;
        }
        this.j = 4;
        n0 n0Var = (n0) this;
        do {
            if (!n0Var.l.hasNext()) {
                n0Var.j = 3;
                t = null;
                break;
            }
            t = (T) n0Var.l.next();
        } while (!n0Var.m.k.contains(t));
        this.k = t;
        if (this.j == 3) {
            return false;
        }
        this.j = 1;
        return true;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.j = 2;
        T t = this.k;
        this.k = null;
        return t;
    }
}
