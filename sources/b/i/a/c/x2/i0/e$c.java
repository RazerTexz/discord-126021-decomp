package b.i.a.c.x2.i0;

import android.util.Log;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.j1;

/* JADX INFO: compiled from: AtomParsers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$c implements e$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1212b;
    public final x c;

    public e$c(d$b d_b, j1 j1Var) {
        x xVar = d_b.f1210b;
        this.c = xVar;
        xVar.E(12);
        int iW = xVar.w();
        if ("audio/raw".equals(j1Var.w)) {
            int iS = e0.s(j1Var.L, j1Var.J);
            if (iW == 0 || iW % iS != 0) {
                Log.w("AtomParsers", b.d.b.a.a.h(88, "Audio sample size mismatch. stsd sample size: ", iS, ", stsz sample size: ", iW));
                iW = iS;
            }
        }
        this.a = iW == 0 ? -1 : iW;
        this.f1212b = xVar.w();
    }

    @Override // b.i.a.c.x2.i0.e$a
    public int a() {
        return this.a;
    }

    @Override // b.i.a.c.x2.i0.e$a
    public int b() {
        return this.f1212b;
    }

    @Override // b.i.a.c.x2.i0.e$a
    public int c() {
        int i = this.a;
        return i == -1 ? this.c.w() : i;
    }
}
