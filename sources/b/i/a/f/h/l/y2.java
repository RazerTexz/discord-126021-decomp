package b.i.a.f.h.l;

import b.d.b.a.outline;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y2<T> extends x2<T> {
    private final T zza;

    public y2(T t) {
        this.zza = t;
    }

    @Override // b.i.a.f.h.l.x2
    public final boolean b() {
        return true;
    }

    @Override // b.i.a.f.h.l.x2
    public final T c() {
        return this.zza;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof y2) {
            return this.zza.equals(((y2) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        return outline.k(strValueOf.length() + 13, "Optional.of(", strValueOf, ")");
    }
}
