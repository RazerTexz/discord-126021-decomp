package b.i.a.f.h.l;

import com.google.android.gms.internal.measurement.zzhi;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f7 extends d7<c7, c7> {
    @Override // b.i.a.f.h.l.d7
    public final /* synthetic */ c7 a() {
        return c7.c();
    }

    @Override // b.i.a.f.h.l.d7
    public final /* synthetic */ void b(c7 c7Var, int i, long j) {
        c7Var.a(i << 3, Long.valueOf(j));
    }

    @Override // b.i.a.f.h.l.d7
    public final /* synthetic */ void c(c7 c7Var, v7 v7Var) throws IOException {
        c7Var.d(v7Var);
    }

    @Override // b.i.a.f.h.l.d7
    public final void d(Object obj, c7 c7Var) {
        ((u4) obj).zzb = c7Var;
    }

    @Override // b.i.a.f.h.l.d7
    public final /* synthetic */ c7 e(Object obj) {
        return ((u4) obj).zzb;
    }

    @Override // b.i.a.f.h.l.d7
    public final void f(c7 c7Var, v7 v7Var) throws IOException {
        c7 c7Var2 = c7Var;
        Objects.requireNonNull(c7Var2);
        Objects.requireNonNull(v7Var);
        for (int i = 0; i < c7Var2.f1438b; i++) {
            ((g4) v7Var).c(c7Var2.c[i] >>> 3, c7Var2.d[i]);
        }
    }

    @Override // b.i.a.f.h.l.d7
    public final c7 g(c7 c7Var, c7 c7Var2) {
        c7 c7Var3 = c7Var;
        c7 c7Var4 = c7Var2;
        if (c7Var4.equals(c7.a)) {
            return c7Var3;
        }
        int i = c7Var3.f1438b + c7Var4.f1438b;
        int[] iArrCopyOf = Arrays.copyOf(c7Var3.c, i);
        System.arraycopy(c7Var4.c, 0, iArrCopyOf, c7Var3.f1438b, c7Var4.f1438b);
        Object[] objArrCopyOf = Arrays.copyOf(c7Var3.d, i);
        System.arraycopy(c7Var4.d, 0, objArrCopyOf, c7Var3.f1438b, c7Var4.f1438b);
        return new c7(i, iArrCopyOf, objArrCopyOf, true);
    }

    @Override // b.i.a.f.h.l.d7
    public final void h(Object obj) {
        ((u4) obj).zzb.f = false;
    }

    @Override // b.i.a.f.h.l.d7
    public final int i(c7 c7Var) {
        c7 c7Var2 = c7Var;
        int i = c7Var2.e;
        if (i != -1) {
            return i;
        }
        int iW = 0;
        for (int i2 = 0; i2 < c7Var2.f1438b; i2++) {
            int i3 = c7Var2.c[i2] >>> 3;
            t3 t3Var = (t3) c7Var2.d[i2];
            iW += zzhi.w(3, t3Var) + zzhi.M(2, i3) + (zzhi.L(8) << 1);
        }
        c7Var2.e = iW;
        return iW;
    }

    @Override // b.i.a.f.h.l.d7
    public final /* synthetic */ int j(c7 c7Var) {
        return c7Var.e();
    }
}
