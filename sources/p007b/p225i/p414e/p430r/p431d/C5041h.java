package p007b.p225i.p414e.p430r.p431d;

/* JADX INFO: renamed from: b.i.e.r.d.h */
/* JADX INFO: compiled from: DetectionResultRowIndicatorColumn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5041h extends C5040g {

    /* JADX INFO: renamed from: c */
    public final boolean f13493c;

    public C5041h(C5036c c5036c, boolean z2) {
        super(c5036c);
        this.f13493c = z2;
    }

    /* JADX INFO: renamed from: c */
    public C5034a m7059c() {
        C5037d[] c5037dArr = this.f13492b;
        C5035b c5035b = new C5035b();
        C5035b c5035b2 = new C5035b();
        C5035b c5035b3 = new C5035b();
        C5035b c5035b4 = new C5035b();
        for (C5037d c5037d : c5037dArr) {
            if (c5037d != null) {
                c5037d.m7051b();
                int i = c5037d.f13482d % 30;
                int i2 = c5037d.f13483e;
                if (!this.f13493c) {
                    i2 += 2;
                }
                int i3 = i2 % 3;
                if (i3 == 0) {
                    c5035b2.m7049b((i * 3) + 1);
                } else if (i3 == 1) {
                    c5035b4.m7049b(i / 3);
                    c5035b3.m7049b(i % 3);
                } else if (i3 == 2) {
                    c5035b.m7049b(i + 1);
                }
            }
        }
        if (c5035b.m7048a().length == 0 || c5035b2.m7048a().length == 0 || c5035b3.m7048a().length == 0 || c5035b4.m7048a().length == 0 || c5035b.m7048a()[0] <= 0 || c5035b2.m7048a()[0] + c5035b3.m7048a()[0] < 3 || c5035b2.m7048a()[0] + c5035b3.m7048a()[0] > 90) {
            return null;
        }
        C5034a c5034a = new C5034a(c5035b.m7048a()[0], c5035b2.m7048a()[0], c5035b3.m7048a()[0], c5035b4.m7048a()[0]);
        m7060d(c5037dArr, c5034a);
        return c5034a;
    }

    /* JADX INFO: renamed from: d */
    public final void m7060d(C5037d[] c5037dArr, C5034a c5034a) {
        for (int i = 0; i < c5037dArr.length; i++) {
            C5037d c5037d = c5037dArr[i];
            if (c5037dArr[i] != null) {
                int i2 = c5037d.f13482d % 30;
                int i3 = c5037d.f13483e;
                if (i3 > c5034a.f13468e) {
                    c5037dArr[i] = null;
                } else {
                    if (!this.f13493c) {
                        i3 += 2;
                    }
                    int i4 = i3 % 3;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2 && i2 + 1 != c5034a.f13464a) {
                                c5037dArr[i] = null;
                            }
                        } else if (i2 / 3 != c5034a.f13465b || i2 % 3 != c5034a.f13467d) {
                            c5037dArr[i] = null;
                        }
                    } else if ((i2 * 3) + 1 != c5034a.f13466c) {
                        c5037dArr[i] = null;
                    }
                }
            }
        }
    }

    @Override // p007b.p225i.p414e.p430r.p431d.C5040g
    public String toString() {
        return "IsLeft: " + this.f13493c + '\n' + super.toString();
    }
}
