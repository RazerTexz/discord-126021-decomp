package b.i.b.a;

import com.google.errorprone.annotations.ForOverride;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: Equivalence.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d<T> {
    @ForOverride
    public abstract boolean a(T t, T t2);

    @ForOverride
    public abstract int b(T t);

    public final boolean c(@NullableDecl T t, @NullableDecl T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return a(t, t2);
    }
}
