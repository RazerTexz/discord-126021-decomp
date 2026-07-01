package b.i.a.f.h.l;

import b.d.b.a.outline;
import java.io.Serializable;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a3<T> implements z2<T>, Serializable {
    public volatile transient boolean j;

    @NullableDecl
    public transient T k;
    private final z2<T> zza;

    public a3(z2<T> z2Var) {
        Objects.requireNonNull(z2Var);
        this.zza = z2Var;
    }

    @Override // b.i.a.f.h.l.z2
    public final T a() {
        if (!this.j) {
            synchronized (this) {
                if (!this.j) {
                    T tA = this.zza.a();
                    this.k = tA;
                    this.j = true;
                    return tA;
                }
            }
        }
        return this.k;
    }

    public final String toString() {
        Object objK;
        if (this.j) {
            String strValueOf = String.valueOf(this.k);
            objK = outline.k(strValueOf.length() + 25, "<supplier that returned ", strValueOf, ">");
        } else {
            objK = this.zza;
        }
        String strValueOf2 = String.valueOf(objK);
        return outline.k(strValueOf2.length() + 19, "Suppliers.memoize(", strValueOf2, ")");
    }
}
