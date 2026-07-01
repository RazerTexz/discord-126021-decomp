package b.i.a.c.e3;

import b.i.a.c.f3.e0;
import java.util.Arrays;

/* JADX INFO: compiled from: DefaultAllocator.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f944b;
    public final e[] c;
    public int d;
    public int e;
    public int f;
    public e[] g;

    public o(boolean z2, int i) {
        b.c.a.a0.d.j(i > 0);
        b.c.a.a0.d.j(true);
        this.a = z2;
        this.f944b = i;
        this.f = 0;
        this.g = new e[100];
        this.c = new e[1];
    }

    public synchronized void a(e[] eVarArr) {
        int i = this.f;
        int length = eVarArr.length + i;
        e[] eVarArr2 = this.g;
        if (length >= eVarArr2.length) {
            this.g = (e[]) Arrays.copyOf(eVarArr2, Math.max(eVarArr2.length * 2, i + eVarArr.length));
        }
        for (e eVar : eVarArr) {
            e[] eVarArr3 = this.g;
            int i2 = this.f;
            this.f = i2 + 1;
            eVarArr3[i2] = eVar;
        }
        this.e -= eVarArr.length;
        notifyAll();
    }

    public synchronized void b(int i) {
        boolean z2 = i < this.d;
        this.d = i;
        if (z2) {
            c();
        }
    }

    public synchronized void c() {
        int iMax = Math.max(0, e0.f(this.d, this.f944b) - this.e);
        int i = this.f;
        if (iMax >= i) {
            return;
        }
        Arrays.fill(this.g, iMax, i, (Object) null);
        this.f = iMax;
    }
}
