package p507d0.p512d0;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.d0.e */
/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11225e {
    public static final void checkStepIsPositive(boolean z2, Number number) {
        C12238m.checkNotNullParameter(number, "step");
        if (z2) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }
}
