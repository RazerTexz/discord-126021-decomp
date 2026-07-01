package f0.e0.n;

import d0.z.d.m;
import g0.e$a;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WebSocketReader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements Closeable {
    public boolean j;
    public int k;
    public long l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final g0.e p;
    public final g0.e q;
    public c r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final byte[] f3665s;
    public final e$a t;
    public final boolean u;
    public final g0.g v;
    public final h$a w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f3666x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f3667y;

    public h(boolean z2, g0.g gVar, h$a h_a, boolean z3, boolean z4) {
        m.checkParameterIsNotNull(gVar, "source");
        m.checkParameterIsNotNull(h_a, "frameCallback");
        this.u = z2;
        this.v = gVar;
        this.w = h_a;
        this.f3666x = z3;
        this.f3667y = z4;
        this.p = new g0.e();
        this.q = new g0.e();
        this.f3665s = z2 ? null : new byte[4];
        this.t = z2 ? null : new e$a();
    }

    public final void a() throws IOException {
        String strD;
        String strQ;
        long j = this.l;
        if (j > 0) {
            this.v.B(this.p, j);
            if (!this.u) {
                g0.e eVar = this.p;
                e$a e_a = this.t;
                if (e_a == null) {
                    m.throwNpe();
                }
                eVar.u(e_a);
                this.t.b(0L);
                e$a e_a2 = this.t;
                byte[] bArr = this.f3665s;
                if (bArr == null) {
                    m.throwNpe();
                }
                g.a(e_a2, bArr);
                this.t.close();
            }
        }
        switch (this.k) {
            case 8:
                short s2 = 1005;
                g0.e eVar2 = this.p;
                long j2 = eVar2.k;
                if (j2 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j2 != 0) {
                    s2 = eVar2.readShort();
                    strD = this.p.D();
                    if (s2 < 1000 || s2 >= 5000) {
                        strQ = b.d.b.a.a.q("Code must be in range [1000,5000): ", s2);
                    } else {
                        strQ = ((1004 > s2 || 1006 < s2) && (1015 > s2 || 2999 < s2)) ? null : b.d.b.a.a.r("Code ", s2, " is reserved and may not be used.");
                    }
                    if (strQ != null) {
                        throw new ProtocolException(strQ);
                    }
                } else {
                    strD = "";
                }
                this.w.g(s2, strD);
                this.j = true;
                return;
            case 9:
                this.w.d(this.p.x());
                return;
            case 10:
                this.w.f(this.p.x());
                return;
            default:
                StringBuilder sbU = b.d.b.a.a.U("Unknown control opcode: ");
                sbU.append(f0.e0.c.x(this.k));
                throw new ProtocolException(sbU.toString());
        }
    }

    public final void b() throws IOException {
        if (this.j) {
            throw new IOException("closed");
        }
        long jH = this.v.timeout().h();
        this.v.timeout().b();
        try {
            byte b2 = this.v.readByte();
            byte[] bArr = f0.e0.c.a;
            int i = b2 & 255;
            this.v.timeout().g(jH, TimeUnit.NANOSECONDS);
            int i2 = i & 15;
            this.k = i2;
            boolean z2 = (i & 128) != 0;
            this.m = z2;
            boolean z3 = (i & 8) != 0;
            this.n = z3;
            if (z3 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z4 = (i & 64) != 0;
            if (i2 == 1 || i2 == 2) {
                if (!z4) {
                    this.o = false;
                } else {
                    if (!this.f3666x) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    this.o = true;
                }
            } else if (z4) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((i & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((i & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int i3 = this.v.readByte() & 255;
            boolean z5 = (i3 & 128) != 0;
            if (z5 == this.u) {
                throw new ProtocolException(this.u ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = i3 & Opcodes.LAND;
            this.l = j;
            if (j == 126) {
                this.l = this.v.readShort() & 65535;
            } else if (j == Opcodes.LAND) {
                long j2 = this.v.readLong();
                this.l = j2;
                if (j2 < 0) {
                    StringBuilder sbU = b.d.b.a.a.U("Frame length 0x");
                    String hexString = Long.toHexString(this.l);
                    m.checkExpressionValueIsNotNull(hexString, "java.lang.Long.toHexString(this)");
                    sbU.append(hexString);
                    sbU.append(" > 0x7FFFFFFFFFFFFFFF");
                    throw new ProtocolException(sbU.toString());
                }
            }
            if (this.n && this.l > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z5) {
                g0.g gVar = this.v;
                byte[] bArr2 = this.f3665s;
                if (bArr2 == null) {
                    m.throwNpe();
                }
                gVar.readFully(bArr2);
            }
        } catch (Throwable th) {
            this.v.timeout().g(jH, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        c cVar = this.r;
        if (cVar != null) {
            cVar.l.close();
        }
    }
}
