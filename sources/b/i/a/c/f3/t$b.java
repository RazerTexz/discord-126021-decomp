package b.i.a.c.f3;

import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: MimeTypes.java */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public final class t$b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f977b;

    public t$b(int i, int i2) {
        this.a = i;
        this.f977b = i2;
    }

    public int a() {
        int i = this.f977b;
        if (i == 2) {
            return 10;
        }
        if (i == 5) {
            return 11;
        }
        if (i == 29) {
            return 12;
        }
        if (i == 42) {
            return 16;
        }
        if (i != 22) {
            return i != 23 ? 0 : 15;
        }
        return BasicMeasure.EXACTLY;
    }
}
