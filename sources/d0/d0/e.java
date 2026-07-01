package d0.d0;

import d0.z.d.m;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final void checkStepIsPositive(boolean z2, Number number) {
        m.checkNotNullParameter(number, "step");
        if (z2) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }
}
