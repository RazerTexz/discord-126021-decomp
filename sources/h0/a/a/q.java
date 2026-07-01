package h0.a.a;

/* JADX INFO: compiled from: MethodVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f3715b;

    public q(int i) {
        if (i != 393216 && i != 327680 && i != 262144 && i != 458752) {
            throw new IllegalArgumentException();
        }
        this.a = i;
        this.f3715b = null;
    }

    public abstract a a(String str, boolean z2);

    public abstract void b(int i, String str, String str2, String str3);

    public abstract void c(int i, int i2, Object[] objArr, int i3, Object[] objArr2);

    public abstract void d(int i, int i2);

    public abstract void e(int i);

    public abstract a f(int i, x xVar, String str, boolean z2);

    public abstract void g(int i, int i2);

    public abstract void h(int i, p pVar);

    public abstract void i(p pVar);

    public abstract void j(Object obj);

    public abstract void k(int i, p pVar);

    public abstract void l(String str, String str2, String str3, p pVar, p pVar2, int i);

    public abstract a m(int i, x xVar, p[] pVarArr, p[] pVarArr2, int[] iArr, String str, boolean z2);

    public abstract void n(int i, int i2);

    @Deprecated
    public void o(int i, String str, String str2, String str3) {
        if (this.a >= 327680) {
            p(i, str, str2, str3, i == 185);
            return;
        }
        q qVar = this.f3715b;
        if (qVar != null) {
            qVar.o(i, str, str2, str3);
        }
    }

    public abstract void p(int i, String str, String str2, String str3, boolean z2);

    public abstract void q(int i, int i2, p pVar, p... pVarArr);

    public abstract a r(int i, x xVar, String str, boolean z2);

    public abstract void s(int i, String str);

    public abstract void t(int i, int i2);
}
