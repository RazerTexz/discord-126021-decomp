package f0.e0.j;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: f0.e0.j.s, reason: use source file name */
/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Settings3 {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f3647b = new int[10];

    public final int a() {
        if ((this.a & 128) != 0) {
            return this.f3647b[7];
        }
        return 65535;
    }

    public final void b(Settings3 settings3) {
        Intrinsics3.checkParameterIsNotNull(settings3, "other");
        for (int i = 0; i < 10; i++) {
            if (((1 << i) & settings3.a) != 0) {
                c(i, settings3.f3647b[i]);
            }
        }
    }

    public final Settings3 c(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f3647b;
            if (i < iArr.length) {
                this.a = (1 << i) | this.a;
                iArr[i] = i2;
            }
        }
        return this;
    }
}
