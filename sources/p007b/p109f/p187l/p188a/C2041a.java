package p007b.p109f.p187l.p188a;

import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p187l.p188a.C2042b;
import p007b.p109f.p187l.p189b.C2045c;

/* JADX INFO: renamed from: b.f.l.a.a */
/* JADX INFO: compiled from: MultiPointerGestureDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2041a {

    /* JADX INFO: renamed from: a */
    public boolean f4279a;

    /* JADX INFO: renamed from: b */
    public int f4280b;

    /* JADX INFO: renamed from: c */
    public final int[] f4281c = new int[2];

    /* JADX INFO: renamed from: d */
    public final float[] f4282d = new float[2];

    /* JADX INFO: renamed from: e */
    public final float[] f4283e = new float[2];

    /* JADX INFO: renamed from: f */
    public final float[] f4284f = new float[2];

    /* JADX INFO: renamed from: g */
    public final float[] f4285g = new float[2];

    /* JADX INFO: renamed from: h */
    public a f4286h = null;

    /* JADX INFO: renamed from: b.f.l.a.a$a */
    /* JADX INFO: compiled from: MultiPointerGestureDetector.java */
    public interface a {
    }

    public C2041a() {
        m1542a();
    }

    /* JADX INFO: renamed from: a */
    public void m1542a() {
        this.f4279a = false;
        this.f4280b = 0;
        for (int i = 0; i < 2; i++) {
            this.f4281c[i] = -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1543b() {
        C2042b c2042b;
        C2042b.a aVar;
        if (this.f4279a) {
            return;
        }
        a aVar2 = this.f4286h;
        if (aVar2 != null && (aVar = (c2042b = (C2042b) aVar2).f4288b) != null) {
            aVar.mo1550c(c2042b);
        }
        this.f4279a = true;
    }

    /* JADX INFO: renamed from: c */
    public final void m1544c() {
        C2042b.a aVar;
        if (this.f4279a) {
            this.f4279a = false;
            a aVar2 = this.f4286h;
            if (aVar2 == null || (aVar = ((C2042b) aVar2).f4288b) == null) {
                return;
            }
            C1691a.m981i(C2045c.class, "onGestureEnd");
        }
    }
}
