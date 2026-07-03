package p600f0.p601e0.p613n;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import okio.BufferedSink;
import okio.ByteString;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;
import p615g0.C12388e;
import p615g0.C12402s;

/* JADX INFO: renamed from: f0.e0.n.i */
/* JADX INFO: compiled from: WebSocketWriter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12360i implements Closeable {

    /* JADX INFO: renamed from: j */
    public final C12388e f25883j;

    /* JADX INFO: renamed from: k */
    public final C12388e f25884k;

    /* JADX INFO: renamed from: l */
    public boolean f25885l;

    /* JADX INFO: renamed from: m */
    public C12352a f25886m;

    /* JADX INFO: renamed from: n */
    public final byte[] f25887n;

    /* JADX INFO: renamed from: o */
    public final C12388e.a f25888o;

    /* JADX INFO: renamed from: p */
    public final boolean f25889p;

    /* JADX INFO: renamed from: q */
    public final BufferedSink f25890q;

    /* JADX INFO: renamed from: r */
    public final Random f25891r;

    /* JADX INFO: renamed from: s */
    public final boolean f25892s;

    /* JADX INFO: renamed from: t */
    public final boolean f25893t;

    /* JADX INFO: renamed from: u */
    public final long f25894u;

    public C12360i(boolean z2, BufferedSink bufferedSink, Random random, boolean z3, boolean z4, long j) {
        C12238m.checkParameterIsNotNull(bufferedSink, "sink");
        C12238m.checkParameterIsNotNull(random, "random");
        this.f25889p = z2;
        this.f25890q = bufferedSink;
        this.f25891r = random;
        this.f25892s = z3;
        this.f25893t = z4;
        this.f25894u = j;
        this.f25883j = new C12388e();
        this.f25884k = bufferedSink.mo10457g();
        this.f25887n = z2 ? new byte[4] : null;
        this.f25888o = z2 ? new C12388e.a() : null;
    }

    /* JADX INFO: renamed from: a */
    public final void m10363a(int i, ByteString byteString) throws IOException {
        String strM871q;
        ByteString byteStringM10473x = ByteString.f27592j;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                if (i < 1000 || i >= 5000) {
                    strM871q = C1643a.m871q("Code must be in range [1000,5000): ", i);
                } else {
                    strM871q = ((1004 > i || 1006 < i) && (1015 > i || 2999 < i)) ? null : C1643a.m873r("Code ", i, " is reserved and may not be used.");
                }
                if (!(strM871q == null)) {
                    if (strM871q == null) {
                        C12238m.throwNpe();
                    }
                    throw new IllegalArgumentException(strM871q.toString());
                }
            }
            C12388e c12388e = new C12388e();
            c12388e.m10448X(i);
            if (byteString != null) {
                c12388e.m10439O(byteString);
            }
            byteStringM10473x = c12388e.m10473x();
        }
        try {
            m10364b(8, byteStringM10473x);
        } finally {
            this.f25885l = true;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m10364b(int i, ByteString byteString) throws IOException {
        if (this.f25885l) {
            throw new IOException("closed");
        }
        int iMo10502j = byteString.mo10502j();
        if (!(((long) iMo10502j) <= 125)) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.f25884k.m10444T(i | 128);
        if (this.f25889p) {
            this.f25884k.m10444T(iMo10502j | 128);
            Random random = this.f25891r;
            byte[] bArr = this.f25887n;
            if (bArr == null) {
                C12238m.throwNpe();
            }
            random.nextBytes(bArr);
            this.f25884k.m10442R(this.f25887n);
            if (iMo10502j > 0) {
                C12388e c12388e = this.f25884k;
                long j = c12388e.f26080k;
                c12388e.m10439O(byteString);
                C12388e c12388e2 = this.f25884k;
                C12388e.a aVar = this.f25888o;
                if (aVar == null) {
                    C12238m.throwNpe();
                }
                c12388e2.m10469u(aVar);
                this.f25888o.m10476b(j);
                C12358g.m10360a(this.f25888o, this.f25887n);
                this.f25888o.close();
            }
        } else {
            this.f25884k.m10444T(iMo10502j);
            this.f25884k.m10439O(byteString);
        }
        this.f25890q.flush();
    }

    /* JADX INFO: renamed from: c */
    public final void m10365c(int i, ByteString byteString) throws IOException {
        C12238m.checkParameterIsNotNull(byteString, "data");
        if (this.f25885l) {
            throw new IOException("closed");
        }
        this.f25883j.m10439O(byteString);
        int i2 = i | 128;
        if (this.f25892s && byteString.mo10502j() >= this.f25894u) {
            C12352a c12352a = this.f25886m;
            if (c12352a == null) {
                c12352a = new C12352a(this.f25893t);
                this.f25886m = c12352a;
            }
            C12388e c12388e = this.f25883j;
            C12238m.checkParameterIsNotNull(c12388e, "buffer");
            boolean z2 = true;
            if (!(c12352a.f25812j.f26080k == 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (c12352a.f25815m) {
                c12352a.f25813k.reset();
            }
            c12352a.f25814l.write(c12388e, c12388e.f26080k);
            c12352a.f25814l.flush();
            C12388e c12388e2 = c12352a.f25812j;
            ByteString byteString2 = C12353b.f25816a;
            long jMo10502j = c12388e2.f26080k - ((long) byteString2.mo10502j());
            C12238m.checkParameterIsNotNull(byteString2, "bytes");
            int iMo10502j = byteString2.mo10502j();
            C12238m.checkParameterIsNotNull(byteString2, "bytes");
            if (jMo10502j < 0 || iMo10502j < 0 || c12388e2.f26080k - jMo10502j < iMo10502j || byteString2.mo10502j() - 0 < iMo10502j) {
                z2 = false;
                break;
            }
            for (int i3 = 0; i3 < iMo10502j; i3++) {
                if (c12388e2.m10464q(((long) i3) + jMo10502j) != byteString2.mo10505m(0 + i3)) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                C12388e c12388e3 = c12352a.f25812j;
                long j = c12388e3.f26080k - ((long) 4);
                C12388e.a aVar = new C12388e.a();
                c12388e3.m10469u(aVar);
                try {
                    aVar.m10475a(j);
                    C12201b.closeFinally(aVar, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        C12201b.closeFinally(aVar, th);
                        throw th2;
                    }
                }
            } else {
                c12352a.f25812j.m10444T(0);
            }
            C12388e c12388e4 = c12352a.f25812j;
            c12388e.write(c12388e4, c12388e4.f26080k);
            i2 |= 64;
        }
        long j2 = this.f25883j.f26080k;
        this.f25884k.m10444T(i2);
        int i4 = this.f25889p ? 128 : 0;
        if (j2 <= 125) {
            this.f25884k.m10444T(i4 | ((int) j2));
        } else if (j2 <= 65535) {
            this.f25884k.m10444T(i4 | 126);
            this.f25884k.m10448X((int) j2);
        } else {
            this.f25884k.m10444T(i4 | Opcodes.LAND);
            C12388e c12388e5 = this.f25884k;
            C12402s c12402sM10438N = c12388e5.m10438N(8);
            byte[] bArr = c12402sM10438N.f26118a;
            int i5 = c12402sM10438N.f26120c;
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((j2 >>> 56) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((j2 >>> 48) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((j2 >>> 40) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((j2 >>> 32) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) ((j2 >>> 24) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) ((j2 >>> 16) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((j2 >>> 8) & 255);
            bArr[i12] = (byte) (j2 & 255);
            c12402sM10438N.f26120c = i12 + 1;
            c12388e5.f26080k += 8;
        }
        if (this.f25889p) {
            Random random = this.f25891r;
            byte[] bArr2 = this.f25887n;
            if (bArr2 == null) {
                C12238m.throwNpe();
            }
            random.nextBytes(bArr2);
            this.f25884k.m10442R(this.f25887n);
            if (j2 > 0) {
                C12388e c12388e6 = this.f25883j;
                C12388e.a aVar2 = this.f25888o;
                if (aVar2 == null) {
                    C12238m.throwNpe();
                }
                c12388e6.m10469u(aVar2);
                this.f25888o.m10476b(0L);
                C12358g.m10360a(this.f25888o, this.f25887n);
                this.f25888o.close();
            }
        }
        this.f25884k.write(this.f25883j, j2);
        this.f25890q.mo10462p();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C12352a c12352a = this.f25886m;
        if (c12352a != null) {
            c12352a.f25814l.close();
        }
    }
}
