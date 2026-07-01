package b.i.a.c.x2.i0;

import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.x2.w;

/* JADX INFO: compiled from: FragmentedMp4Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g$b {
    public final w a;
    public p d;
    public f e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f1221b = new o();
    public final x c = new x();
    public final x j = new x(1);
    public final x k = new x();

    public g$b(w wVar, p pVar, f fVar) {
        this.a = wVar;
        this.d = pVar;
        this.e = fVar;
        this.d = pVar;
        this.e = fVar;
        wVar.e(pVar.a.f);
        e();
    }

    public long a() {
        return !this.l ? this.d.c[this.f] : this.f1221b.f[this.h];
    }

    @Nullable
    public n b() {
        if (!this.l) {
            return null;
        }
        o oVar = this.f1221b;
        f fVar = oVar.a;
        int i = e0.a;
        int i2 = fVar.a;
        n nVarA = oVar.m;
        if (nVarA == null) {
            nVarA = this.d.a.a(i2);
        }
        if (nVarA == null || !nVarA.a) {
            return null;
        }
        return nVarA;
    }

    public boolean c() {
        this.f++;
        if (!this.l) {
            return false;
        }
        int i = this.g + 1;
        this.g = i;
        int[] iArr = this.f1221b.g;
        int i2 = this.h;
        if (i != iArr[i2]) {
            return true;
        }
        this.h = i2 + 1;
        this.g = 0;
        return false;
    }

    public int d(int i, int i2) {
        x xVar;
        n nVarB = b();
        if (nVarB == null) {
            return 0;
        }
        int length = nVarB.d;
        if (length != 0) {
            xVar = this.f1221b.n;
        } else {
            byte[] bArr = nVarB.e;
            int i3 = e0.a;
            x xVar2 = this.k;
            int length2 = bArr.length;
            xVar2.a = bArr;
            xVar2.c = length2;
            xVar2.f984b = 0;
            length = bArr.length;
            xVar = xVar2;
        }
        o oVar = this.f1221b;
        boolean z2 = oVar.k && oVar.l[this.f];
        boolean z3 = z2 || i2 != 0;
        x xVar3 = this.j;
        xVar3.a[0] = (byte) ((z3 ? 128 : 0) | length);
        xVar3.E(0);
        this.a.f(this.j, 1, 1);
        this.a.f(xVar, length, 1);
        if (!z3) {
            return length + 1;
        }
        if (!z2) {
            this.c.A(8);
            x xVar4 = this.c;
            byte[] bArr2 = xVar4.a;
            bArr2[0] = 0;
            bArr2[1] = 1;
            bArr2[2] = (byte) ((i2 >> 8) & 255);
            bArr2[3] = (byte) (i2 & 255);
            bArr2[4] = (byte) ((i >> 24) & 255);
            bArr2[5] = (byte) ((i >> 16) & 255);
            bArr2[6] = (byte) ((i >> 8) & 255);
            bArr2[7] = (byte) (i & 255);
            this.a.f(xVar4, 8, 1);
            return length + 1 + 8;
        }
        x xVar5 = this.f1221b.n;
        int iY = xVar5.y();
        xVar5.F(-2);
        int i4 = (iY * 6) + 2;
        if (i2 != 0) {
            this.c.A(i4);
            byte[] bArr3 = this.c.a;
            xVar5.e(bArr3, 0, i4);
            int i5 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i2;
            bArr3[2] = (byte) ((i5 >> 8) & 255);
            bArr3[3] = (byte) (i5 & 255);
            xVar5 = this.c;
        }
        this.a.f(xVar5, i4, 1);
        return length + 1 + i4;
    }

    public void e() {
        o oVar = this.f1221b;
        oVar.d = 0;
        oVar.p = 0L;
        oVar.q = false;
        oVar.k = false;
        oVar.o = false;
        oVar.m = null;
        this.f = 0;
        this.h = 0;
        this.g = 0;
        this.i = 0;
        this.l = false;
    }
}
