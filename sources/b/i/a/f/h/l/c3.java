package b.i.a.f.h.l;

import b.d.b.a.outline;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c3<T> implements z2<T> {
    public volatile z2<T> j;
    public volatile boolean k;

    @NullableDecl
    public T l;

    public c3(z2<T> z2Var) {
        Objects.requireNonNull(z2Var);
        this.j = z2Var;
    }

    @Override // b.i.a.f.h.l.z2
    public final T a() {
        if (!this.k) {
            synchronized (this) {
                if (!this.k) {
                    T tA = this.j.a();
                    this.l = tA;
                    this.k = true;
                    this.j = null;
                    return tA;
                }
            }
        }
        return this.l;
    }

    public final String toString() {
        Object objK = this.j;
        if (objK == null) {
            String strValueOf = String.valueOf(this.l);
            objK = outline.k(strValueOf.length() + 25, "<supplier that returned ", strValueOf, ">");
        }
        String strValueOf2 = String.valueOf(objK);
        return outline.k(strValueOf2.length() + 19, "Suppliers.memoize(", strValueOf2, ")");
    }
}
