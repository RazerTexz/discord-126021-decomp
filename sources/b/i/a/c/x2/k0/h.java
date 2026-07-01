package b.i.a.c.x2.k0;

import b.i.a.c.x2.t$b;
import java.io.IOException;

/* JADX INFO: compiled from: Ac4Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements b.i.a.c.x2.h {
    public final i a = new i(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.f3.x f1251b = new b.i.a.c.f3.x(16384);
    public boolean c;

    static {
        b bVar = b.a;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        int i;
        b.i.a.c.f3.x xVar = new b.i.a.c.f3.x(10);
        int i2 = 0;
        while (true) {
            iVar.o(xVar.a, 0, 10);
            xVar.E(0);
            if (xVar.v() != 4801587) {
                break;
            }
            xVar.F(3);
            int iS = xVar.s();
            i2 += iS + 10;
            iVar.g(iS);
        }
        iVar.k();
        iVar.g(i2);
        int i3 = i2;
        while (true) {
            int i4 = 0;
            while (true) {
                int i5 = 7;
                iVar.o(xVar.a, 0, 7);
                xVar.E(0);
                int iY = xVar.y();
                if (iY == 44096 || iY == 44097) {
                    i4++;
                    if (i4 >= 4) {
                        return true;
                    }
                    byte[] bArr = xVar.a;
                    if (bArr.length < 7) {
                        i = -1;
                    } else {
                        int i6 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                        if (i6 == 65535) {
                            i6 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
                        } else {
                            i5 = 4;
                        }
                        if (iY == 44097) {
                            i5 += 2;
                        }
                        i = i6 + i5;
                    }
                    if (i == -1) {
                        return false;
                    }
                    iVar.g(i - 7);
                }
            }
            iVar.k();
            i3++;
            if (i3 - i2 >= 8192) {
                return false;
            }
            iVar.g(i3);
        }
    }

    @Override // b.i.a.c.x2.h
    public int e(b.i.a.c.x2.i iVar, b.i.a.c.x2.s sVar) throws IOException {
        int i = iVar.read(this.f1251b.a, 0, 16384);
        if (i == -1) {
            return -1;
        }
        this.f1251b.E(0);
        this.f1251b.D(i);
        if (!this.c) {
            this.a.f(0L, 4);
            this.c = true;
        }
        this.a.b(this.f1251b);
        return 0;
    }

    @Override // b.i.a.c.x2.h
    public void f(b.i.a.c.x2.j jVar) {
        this.a.e(jVar, new i0$d(Integer.MIN_VALUE, 0, 1));
        jVar.j();
        jVar.a(new t$b(-9223372036854775807L, 0L));
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        this.c = false;
        this.a.c();
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
