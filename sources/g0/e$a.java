package g0;

import java.io.Closeable;
import java.util.Arrays;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a implements Closeable {
    public e j;
    public boolean k;
    public s l;
    public byte[] n;
    public long m = -1;
    public int o = -1;
    public int p = -1;

    public final long a(long j) {
        e eVar = this.j;
        if (eVar == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (!this.k) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
        long j2 = eVar.k;
        int i = 1;
        if (j <= j2) {
            if (!(j >= 0)) {
                throw new IllegalArgumentException(b.d.b.a.a.t("newSize < 0: ", j).toString());
            }
            long j3 = j2 - j;
            while (j3 > 0) {
                s sVar = eVar.j;
                if (sVar == null) {
                    d0.z.d.m.throwNpe();
                }
                s sVar2 = sVar.g;
                if (sVar2 == null) {
                    d0.z.d.m.throwNpe();
                }
                int i2 = sVar2.c;
                long j4 = i2 - sVar2.f3693b;
                if (j4 > j3) {
                    sVar2.c = i2 - ((int) j3);
                    break;
                }
                eVar.j = sVar2.a();
                t.a(sVar2);
                j3 -= j4;
            }
            this.l = null;
            this.m = j;
            this.n = null;
            this.o = -1;
            this.p = -1;
        } else if (j > j2) {
            long j5 = j - j2;
            boolean z2 = true;
            while (j5 > 0) {
                s sVarN = eVar.N(i);
                int iMin = (int) Math.min(j5, 8192 - sVarN.c);
                int i3 = sVarN.c + iMin;
                sVarN.c = i3;
                j5 -= (long) iMin;
                if (z2) {
                    this.l = sVarN;
                    this.m = j2;
                    this.n = sVarN.a;
                    this.o = i3 - iMin;
                    this.p = i3;
                    z2 = false;
                }
                i = 1;
            }
        }
        eVar.k = j;
        return j2;
    }

    public final int b(long j) {
        long j2;
        s sVar;
        e eVar = this.j;
        if (eVar == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (j >= -1) {
            long j3 = eVar.k;
            if (j <= j3) {
                if (j == -1 || j == j3) {
                    this.l = null;
                    this.m = j;
                    this.n = null;
                    this.o = -1;
                    this.p = -1;
                    return -1;
                }
                s sVar2 = eVar.j;
                s sVar3 = this.l;
                if (sVar3 != null) {
                    long j4 = this.m;
                    int i = this.o;
                    if (sVar3 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    j2 = j4 - ((long) (i - sVar3.f3693b));
                    if (j2 > j) {
                        sVar = sVar2;
                        sVar2 = this.l;
                        j3 = j2;
                        j2 = 0;
                    } else {
                        sVar = this.l;
                    }
                } else {
                    j2 = 0;
                    sVar = sVar2;
                }
                if (j3 - j > j - j2) {
                    while (true) {
                        if (sVar == null) {
                            d0.z.d.m.throwNpe();
                        }
                        int i2 = sVar.c;
                        int i3 = sVar.f3693b;
                        if (j < ((long) (i2 - i3)) + j2) {
                            break;
                        }
                        j2 += (long) (i2 - i3);
                        sVar = sVar.f;
                    }
                } else {
                    while (j3 > j) {
                        if (sVar2 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        sVar2 = sVar2.g;
                        if (sVar2 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        j3 -= (long) (sVar2.c - sVar2.f3693b);
                    }
                    sVar = sVar2;
                    j2 = j3;
                }
                if (this.k) {
                    if (sVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                    if (sVar.d) {
                        byte[] bArr = sVar.a;
                        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                        d0.z.d.m.checkExpressionValueIsNotNull(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                        s sVar4 = new s(bArrCopyOf, sVar.f3693b, sVar.c, false, true);
                        if (eVar.j == sVar) {
                            eVar.j = sVar4;
                        }
                        sVar.b(sVar4);
                        s sVar5 = sVar4.g;
                        if (sVar5 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        sVar5.a();
                        sVar = sVar4;
                    }
                }
                this.l = sVar;
                this.m = j;
                if (sVar == null) {
                    d0.z.d.m.throwNpe();
                }
                this.n = sVar.a;
                int i4 = sVar.f3693b + ((int) (j - j2));
                this.o = i4;
                int i5 = sVar.c;
                this.p = i5;
                return i5 - i4;
            }
        }
        String str = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(eVar.k)}, 2));
        d0.z.d.m.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
        throw new ArrayIndexOutOfBoundsException(str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!(this.j != null)) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        this.j = null;
        this.l = null;
        this.m = -1L;
        this.n = null;
        this.o = -1;
        this.p = -1;
    }
}
