package b.i.a.c.x2.j0;

import b.i.a.c.f3.x;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: OggPacket.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public final f a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f1237b = new x(new byte[65025], 0);
    public int c = -1;
    public int d;
    public boolean e;

    public final int a(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            f fVar = this.a;
            if (i5 >= fVar.d) {
                break;
            }
            int[] iArr = fVar.g;
            this.d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        boolean z2;
        int i;
        boolean z3;
        b.c.a.a0.d.D(iVar != null);
        if (this.e) {
            this.e = false;
            this.f1237b.A(0);
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.a.c(iVar, -1L) || !this.a.a(iVar, true)) {
                    return false;
                }
                f fVar = this.a;
                int iA = fVar.e;
                if ((fVar.f1238b & 1) == 1 && this.f1237b.c == 0) {
                    iA += a(0);
                    i = this.d + 0;
                } else {
                    i = 0;
                }
                try {
                    iVar.l(iA);
                    z3 = true;
                } catch (EOFException unused) {
                    z3 = false;
                }
                if (!z3) {
                    return false;
                }
                this.c = i;
            }
            int iA2 = a(this.c);
            int i2 = this.c + this.d;
            if (iA2 > 0) {
                x xVar = this.f1237b;
                xVar.b(xVar.c + iA2);
                x xVar2 = this.f1237b;
                try {
                    iVar.readFully(xVar2.a, xVar2.c, iA2);
                    z2 = true;
                } catch (EOFException unused2) {
                    z2 = false;
                }
                if (!z2) {
                    return false;
                }
                x xVar3 = this.f1237b;
                xVar3.D(xVar3.c + iA2);
                this.e = this.a.g[i2 + (-1)] != 255;
            }
            if (i2 == this.a.d) {
                i2 = -1;
            }
            this.c = i2;
        }
        return true;
    }
}
