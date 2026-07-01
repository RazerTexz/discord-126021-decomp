package f0.e0.j;

import g0.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Hpack.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a {
    public final List<b> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0.g f3635b;
    public b[] c;
    public int d;
    public int e;
    public int f;
    public final int g;
    public int h;

    public c$a(x xVar, int i, int i2, int i3) {
        i2 = (i3 & 4) != 0 ? i : i2;
        d0.z.d.m.checkParameterIsNotNull(xVar, "source");
        this.g = i;
        this.h = i2;
        this.a = new ArrayList();
        d0.z.d.m.checkParameterIsNotNull(xVar, "$this$buffer");
        this.f3635b = new g0.r(xVar);
        this.c = new b[8];
        this.d = 7;
    }

    public final void a() {
        d0.t.j.fill$default(this.c, null, 0, 0, 6, null);
        this.d = this.c.length - 1;
        this.e = 0;
        this.f = 0;
    }

    public final int b(int i) {
        return this.d + 1 + i;
    }

    public final int c(int i) {
        int i2;
        int i3 = 0;
        if (i > 0) {
            int length = this.c.length;
            while (true) {
                length--;
                i2 = this.d;
                if (length < i2 || i <= 0) {
                    break;
                }
                b bVar = this.c[length];
                if (bVar == null) {
                    d0.z.d.m.throwNpe();
                }
                int i4 = bVar.g;
                i -= i4;
                this.f -= i4;
                this.e--;
                i3++;
            }
            b[] bVarArr = this.c;
            System.arraycopy(bVarArr, i2 + 1, bVarArr, i2 + 1 + i3, this.e);
            this.d += i3;
        }
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000d  */
    public final ByteString d(int i) throws IOException {
        boolean z2;
        if (i >= 0) {
            c cVar = c.c;
            if (i <= c.a.length - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            c cVar2 = c.c;
            return c.a[i].h;
        }
        c cVar3 = c.c;
        int iB = b(i - c.a.length);
        if (iB >= 0) {
            b[] bVarArr = this.c;
            if (iB < bVarArr.length) {
                b bVar = bVarArr[iB];
                if (bVar == null) {
                    d0.z.d.m.throwNpe();
                }
                return bVar.h;
            }
        }
        StringBuilder sbU = b.d.b.a.a.U("Header index too large ");
        sbU.append(i + 1);
        throw new IOException(sbU.toString());
    }

    public final void e(int i, b bVar) {
        this.a.add(bVar);
        int i2 = bVar.g;
        if (i != -1) {
            b bVar2 = this.c[this.d + 1 + i];
            if (bVar2 == null) {
                d0.z.d.m.throwNpe();
            }
            i2 -= bVar2.g;
        }
        int i3 = this.h;
        if (i2 > i3) {
            a();
            return;
        }
        int iC = c((this.f + i2) - i3);
        if (i == -1) {
            int i4 = this.e + 1;
            b[] bVarArr = this.c;
            if (i4 > bVarArr.length) {
                b[] bVarArr2 = new b[bVarArr.length * 2];
                System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                this.d = this.c.length - 1;
                this.c = bVarArr2;
            }
            int i5 = this.d;
            this.d = i5 - 1;
            this.c[i5] = bVar;
            this.e++;
        } else {
            this.c[this.d + 1 + i + iC + i] = bVar;
        }
        this.f += i2;
    }

    public final ByteString f() throws IOException {
        byte b2 = this.f3635b.readByte();
        byte[] bArr = f0.e0.c.a;
        int i = b2 & 255;
        int i2 = 0;
        boolean z2 = (i & 128) == 128;
        long jG = g(i, Opcodes.LAND);
        if (!z2) {
            return this.f3635b.o(jG);
        }
        g0.e eVar = new g0.e();
        p pVar = p.d;
        g0.g gVar = this.f3635b;
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        p$a p_a = p.c;
        int i3 = 0;
        for (long j = 0; j < jG; j++) {
            byte b3 = gVar.readByte();
            byte[] bArr2 = f0.e0.c.a;
            i2 = (i2 << 8) | (b3 & 255);
            i3 += 8;
            while (i3 >= 8) {
                int i4 = i3 - 8;
                int i5 = (i2 >>> i4) & 255;
                p$a[] p_aArr = p_a.a;
                if (p_aArr == null) {
                    d0.z.d.m.throwNpe();
                }
                p_a = p_aArr[i5];
                if (p_a == null) {
                    d0.z.d.m.throwNpe();
                }
                if (p_a.a == null) {
                    eVar.T(p_a.f3646b);
                    i3 -= p_a.c;
                    p_a = p.c;
                } else {
                    i3 = i4;
                }
            }
        }
        while (i3 > 0) {
            int i6 = (i2 << (8 - i3)) & 255;
            p$a[] p_aArr2 = p_a.a;
            if (p_aArr2 == null) {
                d0.z.d.m.throwNpe();
            }
            p$a p_a2 = p_aArr2[i6];
            if (p_a2 == null) {
                d0.z.d.m.throwNpe();
            }
            if (p_a2.a != null || p_a2.c > i3) {
                break;
            }
            eVar.T(p_a2.f3646b);
            i3 -= p_a2.c;
            p_a = p.c;
        }
        return eVar.x();
    }

    public final int g(int i, int i2) throws IOException {
        int i3 = i & i2;
        if (i3 < i2) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            byte b2 = this.f3635b.readByte();
            byte[] bArr = f0.e0.c.a;
            int i5 = b2 & 255;
            if ((i5 & 128) == 0) {
                return i2 + (i5 << i4);
            }
            i2 += (i5 & Opcodes.LAND) << i4;
            i4 += 7;
        }
    }
}
