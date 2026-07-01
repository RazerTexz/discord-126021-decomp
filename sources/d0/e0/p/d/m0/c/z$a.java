package d0.e0.p.d.m0.c;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Modality.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z$a {
    public z$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final z convertFromFlags(boolean z2, boolean z3, boolean z4) {
        if (z2) {
            return z.SEALED;
        }
        if (z3) {
            return z.ABSTRACT;
        }
        return z4 ? z.OPEN : z.FINAL;
    }
}
