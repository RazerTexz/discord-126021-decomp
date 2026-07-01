package b.i.a.c.x2.j0;

import androidx.annotation.Nullable;
import b.i.a.c.f3.x;
import b.i.a.c.x2.m;
import b.i.a.c.x2.o;
import b.i.a.c.x2.o$a;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: FlacReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends i {

    @Nullable
    public o n;

    @Nullable
    public c$a o;

    @Override // b.i.a.c.x2.j0.i
    public long c(x xVar) {
        byte[] bArr = xVar.a;
        if (!(bArr[0] == -1)) {
            return -1L;
        }
        int i = (bArr[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            xVar.F(4);
            xVar.z();
        }
        int iC = m.c(xVar, i);
        xVar.E(0);
        return iC;
    }

    @Override // b.i.a.c.x2.j0.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean d(x xVar, long j, i$b i_b) {
        byte[] bArr = xVar.a;
        o oVar = this.n;
        if (oVar == null) {
            o oVar2 = new o(bArr, 17);
            this.n = oVar2;
            i_b.a = oVar2.e(Arrays.copyOfRange(bArr, 9, xVar.c), null);
            return true;
        }
        if ((bArr[0] & 127) == 3) {
            o$a o_aL1 = b.c.a.a0.d.L1(xVar);
            o oVarB = oVar.b(o_aL1);
            this.n = oVarB;
            this.o = new c$a(oVarB, o_aL1);
            return true;
        }
        if (!(bArr[0] == -1)) {
            return true;
        }
        c$a c_a = this.o;
        if (c_a != null) {
            c_a.c = j;
            i_b.f1240b = c_a;
        }
        Objects.requireNonNull(i_b.a);
        return false;
    }

    @Override // b.i.a.c.x2.j0.i
    public void e(boolean z2) {
        super.e(z2);
        if (z2) {
            this.n = null;
            this.o = null;
        }
    }
}
