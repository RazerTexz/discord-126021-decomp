package f0.e0.j;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import okio.ByteString;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Hpack.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$b {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3636b;
    public int c;
    public b[] d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final boolean i;
    public final g0.e j;

    public c$b(int i, boolean z2, g0.e eVar, int i2) {
        i = (i2 & 1) != 0 ? 4096 : i;
        z2 = (i2 & 2) != 0 ? true : z2;
        d0.z.d.m.checkParameterIsNotNull(eVar, "out");
        this.h = i;
        this.i = z2;
        this.j = eVar;
        this.a = Integer.MAX_VALUE;
        this.c = i;
        this.d = new b[8];
        this.e = 7;
    }

    public final void a() {
        d0.t.j.fill$default(this.d, null, 0, 0, 6, null);
        this.e = this.d.length - 1;
        this.f = 0;
        this.g = 0;
    }

    public final int b(int i) {
        int i2;
        int i3 = 0;
        if (i > 0) {
            int length = this.d.length;
            while (true) {
                length--;
                i2 = this.e;
                if (length < i2 || i <= 0) {
                    break;
                }
                b bVar = this.d[length];
                if (bVar == null) {
                    d0.z.d.m.throwNpe();
                }
                i -= bVar.g;
                int i4 = this.g;
                b bVar2 = this.d[length];
                if (bVar2 == null) {
                    d0.z.d.m.throwNpe();
                }
                this.g = i4 - bVar2.g;
                this.f--;
                i3++;
            }
            b[] bVarArr = this.d;
            System.arraycopy(bVarArr, i2 + 1, bVarArr, i2 + 1 + i3, this.f);
            b[] bVarArr2 = this.d;
            int i5 = this.e;
            Arrays.fill(bVarArr2, i5 + 1, i5 + 1 + i3, (Object) null);
            this.e += i3;
        }
        return i3;
    }

    public final void c(b bVar) {
        int i = bVar.g;
        int i2 = this.c;
        if (i > i2) {
            a();
            return;
        }
        b((this.g + i) - i2);
        int i3 = this.f + 1;
        b[] bVarArr = this.d;
        if (i3 > bVarArr.length) {
            b[] bVarArr2 = new b[bVarArr.length * 2];
            System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
            this.e = this.d.length - 1;
            this.d = bVarArr2;
        }
        int i4 = this.e;
        this.e = i4 - 1;
        this.d[i4] = bVar;
        this.f++;
        this.g += i;
    }

    public final void d(ByteString byteString) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(byteString, "data");
        if (this.i) {
            p pVar = p.d;
            d0.z.d.m.checkParameterIsNotNull(byteString, "bytes");
            int iJ = byteString.j();
            long j = 0;
            for (int i = 0; i < iJ; i++) {
                byte bM = byteString.m(i);
                byte[] bArr = f0.e0.c.a;
                j += (long) p.f3645b[bM & 255];
            }
            if (((int) ((j + ((long) 7)) >> 3)) < byteString.j()) {
                g0.e eVar = new g0.e();
                p pVar2 = p.d;
                d0.z.d.m.checkParameterIsNotNull(byteString, "source");
                d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
                int iJ2 = byteString.j();
                long j2 = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < iJ2; i3++) {
                    byte bM2 = byteString.m(i3);
                    byte[] bArr2 = f0.e0.c.a;
                    int i4 = bM2 & 255;
                    int i5 = p.a[i4];
                    byte b2 = p.f3645b[i4];
                    j2 = (j2 << b2) | ((long) i5);
                    i2 += b2;
                    while (i2 >= 8) {
                        i2 -= 8;
                        eVar.writeByte((int) (j2 >> i2));
                    }
                }
                if (i2 > 0) {
                    eVar.writeByte((int) ((255 >>> i2) | (j2 << (8 - i2))));
                }
                ByteString byteStringX = eVar.x();
                f(byteStringX.j(), Opcodes.LAND, 128);
                this.j.O(byteStringX);
                return;
            }
        }
        f(byteString.j(), Opcodes.LAND, 0);
        this.j.O(byteString);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0072  */
    public final void e(List<b> list) throws IOException {
        int length;
        int length2;
        d0.z.d.m.checkParameterIsNotNull(list, "headerBlock");
        if (this.f3636b) {
            int i = this.a;
            if (i < this.c) {
                f(i, 31, 32);
            }
            this.f3636b = false;
            this.a = Integer.MAX_VALUE;
            f(this.c, 31, 32);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = list.get(i2);
            ByteString byteStringP = bVar.h.p();
            ByteString byteString = bVar.i;
            c cVar = c.c;
            Integer num = c.f3634b.get(byteStringP);
            if (num != null) {
                length = num.intValue() + 1;
                if (2 <= length && 7 >= length) {
                    b[] bVarArr = c.a;
                    if (d0.z.d.m.areEqual(bVarArr[length - 1].i, byteString)) {
                        length2 = length;
                    } else if (d0.z.d.m.areEqual(bVarArr[length].i, byteString)) {
                        length2 = length;
                        length++;
                    } else {
                        length2 = length;
                        length = -1;
                    }
                } else {
                    length2 = length;
                    length = -1;
                }
            } else {
                length = -1;
                length2 = -1;
            }
            if (length == -1) {
                int length3 = this.d.length;
                for (int i3 = this.e + 1; i3 < length3; i3++) {
                    b bVar2 = this.d[i3];
                    if (bVar2 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    if (d0.z.d.m.areEqual(bVar2.h, byteStringP)) {
                        b bVar3 = this.d[i3];
                        if (bVar3 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        if (d0.z.d.m.areEqual(bVar3.i, byteString)) {
                            int i4 = i3 - this.e;
                            c cVar2 = c.c;
                            length = c.a.length + i4;
                            break;
                        } else if (length2 == -1) {
                            int i5 = i3 - this.e;
                            c cVar3 = c.c;
                            length2 = i5 + c.a.length;
                        }
                    }
                }
            }
            if (length != -1) {
                f(length, Opcodes.LAND, 128);
            } else if (length2 == -1) {
                this.j.T(64);
                d(byteStringP);
                d(byteString);
                c(bVar);
            } else {
                ByteString byteString2 = b.a;
                Objects.requireNonNull(byteStringP);
                d0.z.d.m.checkParameterIsNotNull(byteString2, "prefix");
                if (byteStringP.n(0, byteString2, 0, byteString2.j()) && (!d0.z.d.m.areEqual(b.f, byteStringP))) {
                    f(length2, 15, 0);
                    d(byteString);
                } else {
                    f(length2, 63, 64);
                    d(byteString);
                    c(bVar);
                }
            }
        }
    }

    public final void f(int i, int i2, int i3) {
        if (i < i2) {
            this.j.T(i | i3);
            return;
        }
        this.j.T(i3 | i2);
        int i4 = i - i2;
        while (i4 >= 128) {
            this.j.T(128 | (i4 & Opcodes.LAND));
            i4 >>>= 7;
        }
        this.j.T(i4);
    }
}
