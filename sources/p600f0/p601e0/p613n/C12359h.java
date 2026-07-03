package p600f0.p601e0.p613n;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p615g0.C12388e;
import p615g0.InterfaceC12390g;

/* JADX INFO: renamed from: f0.e0.n.h */
/* JADX INFO: compiled from: WebSocketReader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12359h implements Closeable {

    /* JADX INFO: renamed from: j */
    public boolean f25867j;

    /* JADX INFO: renamed from: k */
    public int f25868k;

    /* JADX INFO: renamed from: l */
    public long f25869l;

    /* JADX INFO: renamed from: m */
    public boolean f25870m;

    /* JADX INFO: renamed from: n */
    public boolean f25871n;

    /* JADX INFO: renamed from: o */
    public boolean f25872o;

    /* JADX INFO: renamed from: p */
    public final C12388e f25873p;

    /* JADX INFO: renamed from: q */
    public final C12388e f25874q;

    /* JADX INFO: renamed from: r */
    public C12354c f25875r;

    /* JADX INFO: renamed from: s */
    public final byte[] f25876s;

    /* JADX INFO: renamed from: t */
    public final C12388e.a f25877t;

    /* JADX INFO: renamed from: u */
    public final boolean f25878u;

    /* JADX INFO: renamed from: v */
    public final InterfaceC12390g f25879v;

    /* JADX INFO: renamed from: w */
    public final a f25880w;

    /* JADX INFO: renamed from: x */
    public final boolean f25881x;

    /* JADX INFO: renamed from: y */
    public final boolean f25882y;

    /* JADX INFO: renamed from: f0.e0.n.h$a */
    /* JADX INFO: compiled from: WebSocketReader.kt */
    public interface a {
        /* JADX INFO: renamed from: b */
        void mo10346b(ByteString byteString) throws IOException;

        /* JADX INFO: renamed from: c */
        void mo10347c(String str) throws IOException;

        /* JADX INFO: renamed from: d */
        void mo10348d(ByteString byteString);

        /* JADX INFO: renamed from: f */
        void mo10350f(ByteString byteString);

        /* JADX INFO: renamed from: g */
        void mo10351g(int i, String str);
    }

    public C12359h(boolean z2, InterfaceC12390g interfaceC12390g, a aVar, boolean z3, boolean z4) {
        C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
        C12238m.checkParameterIsNotNull(aVar, "frameCallback");
        this.f25878u = z2;
        this.f25879v = interfaceC12390g;
        this.f25880w = aVar;
        this.f25881x = z3;
        this.f25882y = z4;
        this.f25873p = new C12388e();
        this.f25874q = new C12388e();
        this.f25876s = z2 ? null : new byte[4];
        this.f25877t = z2 ? null : new C12388e.a();
    }

    /* JADX INFO: renamed from: a */
    public final void m10361a() throws IOException {
        String strM10429D;
        String strM871q;
        long j = this.f25869l;
        if (j > 0) {
            this.f25879v.mo10428B(this.f25873p, j);
            if (!this.f25878u) {
                C12388e c12388e = this.f25873p;
                C12388e.a aVar = this.f25877t;
                if (aVar == null) {
                    C12238m.throwNpe();
                }
                c12388e.m10469u(aVar);
                this.f25877t.m10476b(0L);
                C12388e.a aVar2 = this.f25877t;
                byte[] bArr = this.f25876s;
                if (bArr == null) {
                    C12238m.throwNpe();
                }
                C12358g.m10360a(aVar2, bArr);
                this.f25877t.close();
            }
        }
        switch (this.f25868k) {
            case 8:
                short s2 = 1005;
                C12388e c12388e2 = this.f25873p;
                long j2 = c12388e2.f26080k;
                if (j2 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j2 != 0) {
                    s2 = c12388e2.readShort();
                    strM10429D = this.f25873p.m10429D();
                    if (s2 < 1000 || s2 >= 5000) {
                        strM871q = C1643a.m871q("Code must be in range [1000,5000): ", s2);
                    } else {
                        strM871q = ((1004 > s2 || 1006 < s2) && (1015 > s2 || 2999 < s2)) ? null : C1643a.m873r("Code ", s2, " is reserved and may not be used.");
                    }
                    if (strM871q != null) {
                        throw new ProtocolException(strM871q);
                    }
                } else {
                    strM10429D = "";
                }
                this.f25880w.mo10351g(s2, strM10429D);
                this.f25867j = true;
                return;
            case 9:
                this.f25880w.mo10348d(this.f25873p.m10473x());
                return;
            case 10:
                this.f25880w.mo10350f(this.f25873p.m10473x());
                return;
            default:
                StringBuilder sbM833U = C1643a.m833U("Unknown control opcode: ");
                sbM833U.append(C12272c.m10143x(this.f25868k));
                throw new ProtocolException(sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m10362b() throws IOException {
        if (this.f25867j) {
            throw new IOException("closed");
        }
        long jMo10485h = this.f25879v.timeout().mo10485h();
        this.f25879v.timeout().mo10479b();
        try {
            byte b2 = this.f25879v.readByte();
            byte[] bArr = C12272c.f25397a;
            int i = b2 & 255;
            this.f25879v.timeout().mo10484g(jMo10485h, TimeUnit.NANOSECONDS);
            int i2 = i & 15;
            this.f25868k = i2;
            boolean z2 = (i & 128) != 0;
            this.f25870m = z2;
            boolean z3 = (i & 8) != 0;
            this.f25871n = z3;
            if (z3 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z4 = (i & 64) != 0;
            if (i2 == 1 || i2 == 2) {
                if (!z4) {
                    this.f25872o = false;
                } else {
                    if (!this.f25881x) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    this.f25872o = true;
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
            int i3 = this.f25879v.readByte() & 255;
            boolean z5 = (i3 & 128) != 0;
            if (z5 == this.f25878u) {
                throw new ProtocolException(this.f25878u ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = i3 & Opcodes.LAND;
            this.f25869l = j;
            if (j == 126) {
                this.f25869l = this.f25879v.readShort() & 65535;
            } else if (j == Opcodes.LAND) {
                long j2 = this.f25879v.readLong();
                this.f25869l = j2;
                if (j2 < 0) {
                    StringBuilder sbM833U = C1643a.m833U("Frame length 0x");
                    String hexString = Long.toHexString(this.f25869l);
                    C12238m.checkExpressionValueIsNotNull(hexString, "java.lang.Long.toHexString(this)");
                    sbM833U.append(hexString);
                    sbM833U.append(" > 0x7FFFFFFFFFFFFFFF");
                    throw new ProtocolException(sbM833U.toString());
                }
            }
            if (this.f25871n && this.f25869l > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z5) {
                InterfaceC12390g interfaceC12390g = this.f25879v;
                byte[] bArr2 = this.f25876s;
                if (bArr2 == null) {
                    C12238m.throwNpe();
                }
                interfaceC12390g.readFully(bArr2);
            }
        } catch (Throwable th) {
            this.f25879v.timeout().mo10484g(jMo10485h, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        C12354c c12354c = this.f25875r;
        if (c12354c != null) {
            c12354c.f25819l.close();
        }
    }
}
