package f0.e0.n;

import d0.z.d.m;
import g0.e$a;
import g0.s;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import okio.BufferedSink;
import okio.ByteString;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WebSocketWriter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements Closeable {
    public final g0.e j;
    public final g0.e k;
    public boolean l;
    public a m;
    public final byte[] n;
    public final e$a o;
    public final boolean p;
    public final BufferedSink q;
    public final Random r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f3668s;
    public final boolean t;
    public final long u;

    public i(boolean z2, BufferedSink bufferedSink, Random random, boolean z3, boolean z4, long j) {
        m.checkParameterIsNotNull(bufferedSink, "sink");
        m.checkParameterIsNotNull(random, "random");
        this.p = z2;
        this.q = bufferedSink;
        this.r = random;
        this.f3668s = z3;
        this.t = z4;
        this.u = j;
        this.j = new g0.e();
        this.k = bufferedSink.g();
        this.n = z2 ? new byte[4] : null;
        this.o = z2 ? new e$a() : null;
    }

    public final void a(int i, ByteString byteString) throws IOException {
        String strQ;
        ByteString byteStringX = ByteString.j;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                if (i < 1000 || i >= 5000) {
                    strQ = b.d.b.a.a.q("Code must be in range [1000,5000): ", i);
                } else {
                    strQ = ((1004 > i || 1006 < i) && (1015 > i || 2999 < i)) ? null : b.d.b.a.a.r("Code ", i, " is reserved and may not be used.");
                }
                if (!(strQ == null)) {
                    if (strQ == null) {
                        m.throwNpe();
                    }
                    throw new IllegalArgumentException(strQ.toString());
                }
            }
            g0.e eVar = new g0.e();
            eVar.X(i);
            if (byteString != null) {
                eVar.O(byteString);
            }
            byteStringX = eVar.x();
        }
        try {
            b(8, byteStringX);
        } finally {
            this.l = true;
        }
    }

    public final void b(int i, ByteString byteString) throws IOException {
        if (this.l) {
            throw new IOException("closed");
        }
        int iJ = byteString.j();
        if (!(((long) iJ) <= 125)) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.k.T(i | 128);
        if (this.p) {
            this.k.T(iJ | 128);
            Random random = this.r;
            byte[] bArr = this.n;
            if (bArr == null) {
                m.throwNpe();
            }
            random.nextBytes(bArr);
            this.k.R(this.n);
            if (iJ > 0) {
                g0.e eVar = this.k;
                long j = eVar.k;
                eVar.O(byteString);
                g0.e eVar2 = this.k;
                e$a e_a = this.o;
                if (e_a == null) {
                    m.throwNpe();
                }
                eVar2.u(e_a);
                this.o.b(j);
                g.a(this.o, this.n);
                this.o.close();
            }
        } else {
            this.k.T(iJ);
            this.k.O(byteString);
        }
        this.q.flush();
    }

    public final void c(int i, ByteString byteString) throws IOException {
        m.checkParameterIsNotNull(byteString, "data");
        if (this.l) {
            throw new IOException("closed");
        }
        this.j.O(byteString);
        int i2 = i | 128;
        if (this.f3668s && byteString.j() >= this.u) {
            a aVar = this.m;
            if (aVar == null) {
                aVar = new a(this.t);
                this.m = aVar;
            }
            g0.e eVar = this.j;
            m.checkParameterIsNotNull(eVar, "buffer");
            boolean z2 = true;
            if (!(aVar.j.k == 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (aVar.m) {
                aVar.k.reset();
            }
            aVar.l.write(eVar, eVar.k);
            aVar.l.flush();
            g0.e eVar2 = aVar.j;
            ByteString byteString2 = b.a;
            long j = eVar2.k - ((long) byteString2.j());
            m.checkParameterIsNotNull(byteString2, "bytes");
            int iJ = byteString2.j();
            m.checkParameterIsNotNull(byteString2, "bytes");
            if (j < 0 || iJ < 0 || eVar2.k - j < iJ || byteString2.j() - 0 < iJ) {
                z2 = false;
                break;
            }
            for (int i3 = 0; i3 < iJ; i3++) {
                if (eVar2.q(((long) i3) + j) != byteString2.m(0 + i3)) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                g0.e eVar3 = aVar.j;
                long j2 = eVar3.k - ((long) 4);
                e$a e_a = new e$a();
                eVar3.u(e_a);
                try {
                    e_a.a(j2);
                    d0.y.b.closeFinally(e_a, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        d0.y.b.closeFinally(e_a, th);
                        throw th2;
                    }
                }
            } else {
                aVar.j.T(0);
            }
            g0.e eVar4 = aVar.j;
            eVar.write(eVar4, eVar4.k);
            i2 |= 64;
        }
        long j3 = this.j.k;
        this.k.T(i2);
        int i4 = this.p ? 128 : 0;
        if (j3 <= 125) {
            this.k.T(i4 | ((int) j3));
        } else if (j3 <= 65535) {
            this.k.T(i4 | 126);
            this.k.X((int) j3);
        } else {
            this.k.T(i4 | Opcodes.LAND);
            g0.e eVar5 = this.k;
            s sVarN = eVar5.N(8);
            byte[] bArr = sVarN.a;
            int i5 = sVarN.c;
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((j3 >>> 56) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((j3 >>> 48) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((j3 >>> 40) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((j3 >>> 32) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) ((j3 >>> 24) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) ((j3 >>> 16) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((j3 >>> 8) & 255);
            bArr[i12] = (byte) (j3 & 255);
            sVarN.c = i12 + 1;
            eVar5.k += 8;
        }
        if (this.p) {
            Random random = this.r;
            byte[] bArr2 = this.n;
            if (bArr2 == null) {
                m.throwNpe();
            }
            random.nextBytes(bArr2);
            this.k.R(this.n);
            if (j3 > 0) {
                g0.e eVar6 = this.j;
                e$a e_a2 = this.o;
                if (e_a2 == null) {
                    m.throwNpe();
                }
                eVar6.u(e_a2);
                this.o.b(0L);
                g.a(this.o, this.n);
                this.o.close();
            }
        }
        this.k.write(this.j, j3);
        this.q.p();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a aVar = this.m;
        if (aVar != null) {
            aVar.l.close();
        }
    }
}
