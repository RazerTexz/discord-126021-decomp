package d0.d0;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.d0.e, reason: use source file name */
/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Ranges {
    public static final void checkStepIsPositive(boolean z2, Number number) {
        Intrinsics3.checkNotNullParameter(number, "step");
        if (z2) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }
}
