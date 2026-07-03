package p600f0.p601e0.p608j;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.e0.j.s */
/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12325s {

    /* JADX INFO: renamed from: a */
    public int f25752a;

    /* JADX INFO: renamed from: b */
    public final int[] f25753b = new int[10];

    /* JADX INFO: renamed from: a */
    public final int m10312a() {
        if ((this.f25752a & 128) != 0) {
            return this.f25753b[7];
        }
        return 65535;
    }

    /* JADX INFO: renamed from: b */
    public final void m10313b(C12325s c12325s) {
        C12238m.checkParameterIsNotNull(c12325s, "other");
        for (int i = 0; i < 10; i++) {
            if (((1 << i) & c12325s.f25752a) != 0) {
                m10314c(i, c12325s.f25753b[i]);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final C12325s m10314c(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f25753b;
            if (i < iArr.length) {
                this.f25752a = (1 << i) | this.f25752a;
                iArr[i] = i2;
            }
        }
        return this;
    }
}
