package f0.e0.n;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import g0.Buffer3;
import g0.BufferedSource;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: f0.e0.n.h, reason: use source file name */
/* JADX INFO: compiled from: WebSocketReader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketReader implements Closeable {
    public boolean j;
    public int k;
    public long l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final Buffer3 p;
    public final Buffer3 q;
    public MessageInflater r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final byte[] f3665s;
    public final Buffer3.a t;
    public final boolean u;
    public final BufferedSource v;
    public final a w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f3666x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f3667y;

    /* JADX INFO: renamed from: f0.e0.n.h$a */
    /* JADX INFO: compiled from: WebSocketReader.kt */
    public interface a {
        void b(ByteString byteString) throws IOException;

        void c(String str) throws IOException;

        void d(ByteString byteString);

        void f(ByteString byteString);

        void g(int i, String str);
    }

    public WebSocketReader(boolean z2, BufferedSource bufferedSource, a aVar, boolean z3, boolean z4) {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        Intrinsics3.checkParameterIsNotNull(aVar, "frameCallback");
        this.u = z2;
        this.v = bufferedSource;
        this.w = aVar;
        this.f3666x = z3;
        this.f3667y = z4;
        this.p = new Buffer3();
        this.q = new Buffer3();
        this.f3665s = z2 ? null : new byte[4];
        this.t = z2 ? null : new Buffer3.a();
    }

    public final void a() throws IOException {
        String strD;
        String strQ;
        long j = this.l;
        if (j > 0) {
            this.v.B(this.p, j);
            if (!this.u) {
                Buffer3 buffer3 = this.p;
                Buffer3.a aVar = this.t;
                if (aVar == null) {
                    Intrinsics3.throwNpe();
                }
                buffer3.u(aVar);
                this.t.b(0L);
                Buffer3.a aVar2 = this.t;
                byte[] bArr = this.f3665s;
                if (bArr == null) {
                    Intrinsics3.throwNpe();
                }
                WebSocketProtocol.a(aVar2, bArr);
                this.t.close();
            }
        }
        switch (this.k) {
            case 8:
                short s2 = 1005;
                Buffer3 buffer4 = this.p;
                long j2 = buffer4.k;
                if (j2 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j2 != 0) {
                    s2 = buffer4.readShort();
                    strD = this.p.D();
                    if (s2 < 1000 || s2 >= 5000) {
                        strQ = outline.q("Code must be in range [1000,5000): ", s2);
                    } else {
                        strQ = ((1004 > s2 || 1006 < s2) && (1015 > s2 || 2999 < s2)) ? null : outline.r("Code ", s2, " is reserved and may not be used.");
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
                StringBuilder sbU = outline.U("Unknown control opcode: ");
                sbU.append(Util7.x(this.k));
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
            byte[] bArr = Util7.a;
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
                    StringBuilder sbU = outline.U("Frame length 0x");
                    String hexString = Long.toHexString(this.l);
                    Intrinsics3.checkExpressionValueIsNotNull(hexString, "java.lang.Long.toHexString(this)");
                    sbU.append(hexString);
                    sbU.append(" > 0x7FFFFFFFFFFFFFFF");
                    throw new ProtocolException(sbU.toString());
                }
            }
            if (this.n && this.l > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z5) {
                BufferedSource bufferedSource = this.v;
                byte[] bArr2 = this.f3665s;
                if (bArr2 == null) {
                    Intrinsics3.throwNpe();
                }
                bufferedSource.readFully(bArr2);
            }
        } catch (Throwable th) {
            this.v.timeout().g(jH, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater messageInflater = this.r;
        if (messageInflater != null) {
            messageInflater.l.close();
        }
    }
}
