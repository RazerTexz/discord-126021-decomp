package p617h0.p618a.p619a;

/* JADX INFO: renamed from: h0.a.a.q */
/* JADX INFO: compiled from: MethodVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12428q {

    /* JADX INFO: renamed from: a */
    public final int f26262a;

    /* JADX INFO: renamed from: b */
    public AbstractC12428q f26263b;

    public AbstractC12428q(int i) {
        if (i != 393216 && i != 327680 && i != 262144 && i != 458752) {
            throw new IllegalArgumentException();
        }
        this.f26262a = i;
        this.f26263b = null;
    }

    /* JADX INFO: renamed from: a */
    public abstract C12412a mo10593a(String str, boolean z2);

    /* JADX INFO: renamed from: b */
    public abstract void mo10594b(int i, String str, String str2, String str3);

    /* JADX INFO: renamed from: c */
    public abstract void mo10595c(int i, int i2, Object[] objArr, int i3, Object[] objArr2);

    /* JADX INFO: renamed from: d */
    public abstract void mo10596d(int i, int i2);

    /* JADX INFO: renamed from: e */
    public abstract void mo10597e(int i);

    /* JADX INFO: renamed from: f */
    public abstract C12412a mo10598f(int i, C12435x c12435x, String str, boolean z2);

    /* JADX INFO: renamed from: g */
    public abstract void mo10599g(int i, int i2);

    /* JADX INFO: renamed from: h */
    public abstract void mo10600h(int i, C12427p c12427p);

    /* JADX INFO: renamed from: i */
    public abstract void mo10601i(C12427p c12427p);

    /* JADX INFO: renamed from: j */
    public abstract void mo10602j(Object obj);

    /* JADX INFO: renamed from: k */
    public abstract void mo10603k(int i, C12427p c12427p);

    /* JADX INFO: renamed from: l */
    public abstract void mo10604l(String str, String str2, String str3, C12427p c12427p, C12427p c12427p2, int i);

    /* JADX INFO: renamed from: m */
    public abstract C12412a mo10605m(int i, C12435x c12435x, C12427p[] c12427pArr, C12427p[] c12427pArr2, int[] iArr, String str, boolean z2);

    /* JADX INFO: renamed from: n */
    public abstract void mo10606n(int i, int i2);

    @Deprecated
    /* JADX INFO: renamed from: o */
    public void m10607o(int i, String str, String str2, String str3) {
        if (this.f26262a >= 327680) {
            mo10608p(i, str, str2, str3, i == 185);
            return;
        }
        AbstractC12428q abstractC12428q = this.f26263b;
        if (abstractC12428q != null) {
            abstractC12428q.m10607o(i, str, str2, str3);
        }
    }

    /* JADX INFO: renamed from: p */
    public abstract void mo10608p(int i, String str, String str2, String str3, boolean z2);

    /* JADX INFO: renamed from: q */
    public abstract void mo10609q(int i, int i2, C12427p c12427p, C12427p... c12427pArr);

    /* JADX INFO: renamed from: r */
    public abstract C12412a mo10610r(int i, C12435x c12435x, String str, boolean z2);

    /* JADX INFO: renamed from: s */
    public abstract void mo10611s(int i, String str);

    /* JADX INFO: renamed from: t */
    public abstract void mo10612t(int i, int i2);
}
