package b.i.a.f.h.l;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b3<T> implements z2<T>, Serializable {

    @NullableDecl
    private final T zza;

    public b3(@NullableDecl T t) {
        this.zza = t;
    }

    @Override // b.i.a.f.h.l.z2
    public final T a() {
        return this.zza;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof b3) {
            return b.i.a.f.e.o.f.j2(this.zza, ((b3) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        return b.d.b.a.a.k(strValueOf.length() + 22, "Suppliers.ofInstance(", strValueOf, ")");
    }
}
