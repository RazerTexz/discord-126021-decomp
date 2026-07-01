package b.i.a.f.h.l;

import android.content.Context;
import b.d.b.a.outline;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v1 extends t2 {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z2<x2<h2>> f1498b;

    public v1(Context context, z2<x2<h2>> z2Var) {
        this.a = context;
        this.f1498b = z2Var;
    }

    @Override // b.i.a.f.h.l.t2
    public final Context a() {
        return this.a;
    }

    @Override // b.i.a.f.h.l.t2
    public final z2<x2<h2>> b() {
        return this.f1498b;
    }

    public final boolean equals(Object obj) {
        z2<x2<h2>> z2Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof t2) {
            t2 t2Var = (t2) obj;
            if (this.a.equals(t2Var.a()) && ((z2Var = this.f1498b) != null ? z2Var.equals(t2Var.b()) : t2Var.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        z2<x2<h2>> z2Var = this.f1498b;
        return iHashCode ^ (z2Var == null ? 0 : z2Var.hashCode());
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.a);
        String strValueOf2 = String.valueOf(this.f1498b);
        StringBuilder sbS = outline.S(strValueOf2.length() + strValueOf.length() + 46, "FlagsContext{context=", strValueOf, ", hermeticFileOverrides=", strValueOf2);
        sbS.append("}");
        return sbS.toString();
    }
}
