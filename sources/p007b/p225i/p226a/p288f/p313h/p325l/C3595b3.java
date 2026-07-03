package p007b.p225i.p226a.p288f.p313h.p325l;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.h.l.b3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3595b3<T> implements InterfaceC3914z2<T>, Serializable {

    @NullableDecl
    private final T zza;

    public C3595b3(@NullableDecl T t) {
        this.zza = t;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3914z2
    /* JADX INFO: renamed from: a */
    public final T mo4555a() {
        return this.zza;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof C3595b3) {
            return C3404f.m4306j2(this.zza, ((C3595b3) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        return C1643a.m859k(strValueOf.length() + 22, "Suppliers.ofInstance(", strValueOf, ")");
    }
}
