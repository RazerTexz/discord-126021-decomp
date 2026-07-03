package p007b.p109f.p187l.p188a;

import p007b.p109f.p187l.p188a.C2041a;

/* JADX INFO: renamed from: b.f.l.a.b */
/* JADX INFO: compiled from: TransformGestureDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2042b implements C2041a.a {

    /* JADX INFO: renamed from: a */
    public final C2041a f4287a;

    /* JADX INFO: renamed from: b */
    public a f4288b = null;

    /* JADX INFO: renamed from: b.f.l.a.b$a */
    /* JADX INFO: compiled from: TransformGestureDetector.java */
    public interface a {
        /* JADX INFO: renamed from: b */
        void mo1549b(C2042b c2042b);

        /* JADX INFO: renamed from: c */
        void mo1550c(C2042b c2042b);
    }

    public C2042b(C2041a c2041a) {
        this.f4287a = c2041a;
        c2041a.f4286h = this;
    }

    /* JADX INFO: renamed from: a */
    public final float m1545a(float[] fArr, int i) {
        float f = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            f += fArr[i2];
        }
        if (i > 0) {
            return f / i;
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: b */
    public float m1546b() {
        C2041a c2041a = this.f4287a;
        return m1545a(c2041a.f4282d, c2041a.f4280b);
    }

    /* JADX INFO: renamed from: c */
    public float m1547c() {
        C2041a c2041a = this.f4287a;
        return m1545a(c2041a.f4283e, c2041a.f4280b);
    }

    /* JADX INFO: renamed from: d */
    public void m1548d() {
        C2041a c2041a = this.f4287a;
        if (c2041a.f4279a) {
            c2041a.m1544c();
            for (int i = 0; i < 2; i++) {
                c2041a.f4282d[i] = c2041a.f4284f[i];
                c2041a.f4283e[i] = c2041a.f4285g[i];
            }
            c2041a.m1543b();
        }
    }
}
