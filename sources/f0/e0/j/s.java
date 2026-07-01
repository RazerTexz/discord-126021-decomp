package f0.e0.j;

/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f3647b = new int[10];

    public final int a() {
        if ((this.a & 128) != 0) {
            return this.f3647b[7];
        }
        return 65535;
    }

    public final void b(s sVar) {
        d0.z.d.m.checkParameterIsNotNull(sVar, "other");
        for (int i = 0; i < 10; i++) {
            if (((1 << i) & sVar.a) != 0) {
                c(i, sVar.f3647b[i]);
            }
        }
    }

    public final s c(int i, int i2) {
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
