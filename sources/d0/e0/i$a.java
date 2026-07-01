package d0.e0;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: KTypeProjection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$a {
    public i$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final i contravariant(KType kType) {
        d0.z.d.m.checkNotNullParameter(kType, "type");
        return new i(j.IN, kType);
    }

    public final i covariant(KType kType) {
        d0.z.d.m.checkNotNullParameter(kType, "type");
        return new i(j.OUT, kType);
    }

    public final i getSTAR() {
        return i.a;
    }

    public final i invariant(KType kType) {
        d0.z.d.m.checkNotNullParameter(kType, "type");
        return new i(j.INVARIANT, kType);
    }
}
