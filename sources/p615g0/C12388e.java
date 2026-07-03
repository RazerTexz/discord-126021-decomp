package p615g0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;
import okio.BufferedSink;
import okio.ByteString;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.C12086c;
import p507d0.p580t.C12139j;
import p507d0.p592z.p594d.C12238m;
import p615g0.p616z.C12409a;
import p615g0.p616z.C12410b;

/* JADX INFO: renamed from: g0.e */
/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12388e implements InterfaceC12390g, BufferedSink, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: j */
    public C12402s f26079j;

    /* JADX INFO: renamed from: k */
    public long f26080k;

    /* JADX INFO: renamed from: g0.e$a */
    /* JADX INFO: compiled from: Buffer.kt */
    public static final class a implements Closeable {

        /* JADX INFO: renamed from: j */
        public C12388e f26081j;

        /* JADX INFO: renamed from: k */
        public boolean f26082k;

        /* JADX INFO: renamed from: l */
        public C12402s f26083l;

        /* JADX INFO: renamed from: n */
        public byte[] f26085n;

        /* JADX INFO: renamed from: m */
        public long f26084m = -1;

        /* JADX INFO: renamed from: o */
        public int f26086o = -1;

        /* JADX INFO: renamed from: p */
        public int f26087p = -1;

        /* JADX INFO: renamed from: a */
        public final long m10475a(long j) {
            C12388e c12388e = this.f26081j;
            if (c12388e == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.f26082k) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long j2 = c12388e.f26080k;
            int i = 1;
            if (j <= j2) {
                if (!(j >= 0)) {
                    throw new IllegalArgumentException(C1643a.m877t("newSize < 0: ", j).toString());
                }
                long j3 = j2 - j;
                while (j3 > 0) {
                    C12402s c12402s = c12388e.f26079j;
                    if (c12402s == null) {
                        C12238m.throwNpe();
                    }
                    C12402s c12402s2 = c12402s.f26124g;
                    if (c12402s2 == null) {
                        C12238m.throwNpe();
                    }
                    int i2 = c12402s2.f26120c;
                    long j4 = i2 - c12402s2.f26119b;
                    if (j4 > j3) {
                        c12402s2.f26120c = i2 - ((int) j3);
                        break;
                    }
                    c12388e.f26079j = c12402s2.m10494a();
                    C12403t.m10498a(c12402s2);
                    j3 -= j4;
                }
                this.f26083l = null;
                this.f26084m = j;
                this.f26085n = null;
                this.f26086o = -1;
                this.f26087p = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z2 = true;
                while (j5 > 0) {
                    C12402s c12402sM10438N = c12388e.m10438N(i);
                    int iMin = (int) Math.min(j5, 8192 - c12402sM10438N.f26120c);
                    int i3 = c12402sM10438N.f26120c + iMin;
                    c12402sM10438N.f26120c = i3;
                    j5 -= (long) iMin;
                    if (z2) {
                        this.f26083l = c12402sM10438N;
                        this.f26084m = j2;
                        this.f26085n = c12402sM10438N.f26118a;
                        this.f26086o = i3 - iMin;
                        this.f26087p = i3;
                        z2 = false;
                    }
                    i = 1;
                }
            }
            c12388e.f26080k = j;
            return j2;
        }

        /* JADX INFO: renamed from: b */
        public final int m10476b(long j) {
            long j2;
            C12402s c12402s;
            C12388e c12388e = this.f26081j;
            if (c12388e == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (j >= -1) {
                long j3 = c12388e.f26080k;
                if (j <= j3) {
                    if (j == -1 || j == j3) {
                        this.f26083l = null;
                        this.f26084m = j;
                        this.f26085n = null;
                        this.f26086o = -1;
                        this.f26087p = -1;
                        return -1;
                    }
                    C12402s c12402s2 = c12388e.f26079j;
                    C12402s c12402s3 = this.f26083l;
                    if (c12402s3 != null) {
                        long j4 = this.f26084m;
                        int i = this.f26086o;
                        if (c12402s3 == null) {
                            C12238m.throwNpe();
                        }
                        j2 = j4 - ((long) (i - c12402s3.f26119b));
                        if (j2 > j) {
                            c12402s = c12402s2;
                            c12402s2 = this.f26083l;
                            j3 = j2;
                            j2 = 0;
                        } else {
                            c12402s = this.f26083l;
                        }
                    } else {
                        j2 = 0;
                        c12402s = c12402s2;
                    }
                    if (j3 - j > j - j2) {
                        while (true) {
                            if (c12402s == null) {
                                C12238m.throwNpe();
                            }
                            int i2 = c12402s.f26120c;
                            int i3 = c12402s.f26119b;
                            if (j < ((long) (i2 - i3)) + j2) {
                                break;
                            }
                            j2 += (long) (i2 - i3);
                            c12402s = c12402s.f26123f;
                        }
                    } else {
                        while (j3 > j) {
                            if (c12402s2 == null) {
                                C12238m.throwNpe();
                            }
                            c12402s2 = c12402s2.f26124g;
                            if (c12402s2 == null) {
                                C12238m.throwNpe();
                            }
                            j3 -= (long) (c12402s2.f26120c - c12402s2.f26119b);
                        }
                        c12402s = c12402s2;
                        j2 = j3;
                    }
                    if (this.f26082k) {
                        if (c12402s == null) {
                            C12238m.throwNpe();
                        }
                        if (c12402s.f26121d) {
                            byte[] bArr = c12402s.f26118a;
                            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                            C12238m.checkExpressionValueIsNotNull(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                            C12402s c12402s4 = new C12402s(bArrCopyOf, c12402s.f26119b, c12402s.f26120c, false, true);
                            if (c12388e.f26079j == c12402s) {
                                c12388e.f26079j = c12402s4;
                            }
                            c12402s.m10495b(c12402s4);
                            C12402s c12402s5 = c12402s4.f26124g;
                            if (c12402s5 == null) {
                                C12238m.throwNpe();
                            }
                            c12402s5.m10494a();
                            c12402s = c12402s4;
                        }
                    }
                    this.f26083l = c12402s;
                    this.f26084m = j;
                    if (c12402s == null) {
                        C12238m.throwNpe();
                    }
                    this.f26085n = c12402s.f26118a;
                    int i4 = c12402s.f26119b + ((int) (j - j2));
                    this.f26086o = i4;
                    int i5 = c12402s.f26120c;
                    this.f26087p = i5;
                    return i5 - i4;
                }
            }
            String str = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(c12388e.f26080k)}, 2));
            C12238m.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
            throw new ArrayIndexOutOfBoundsException(str);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.f26081j != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.f26081j = null;
            this.f26083l = null;
            this.f26084m = -1L;
            this.f26085n = null;
            this.f26086o = -1;
            this.f26087p = -1;
        }
    }

    /* JADX INFO: renamed from: A */
    public String m10427A(long j, Charset charset) throws EOFException {
        C12238m.checkParameterIsNotNull(charset, "charset");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(C1643a.m877t("byteCount: ", j).toString());
        }
        if (this.f26080k < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            C12238m.throwNpe();
        }
        int i = c12402s.f26119b;
        if (((long) i) + j > c12402s.f26120c) {
            return new String(mo10450Z(j), charset);
        }
        int i2 = (int) j;
        String str = new String(c12402s.f26118a, i, i2, charset);
        int i3 = c12402s.f26119b + i2;
        c12402s.f26119b = i3;
        this.f26080k -= j;
        if (i3 == c12402s.f26120c) {
            this.f26079j = c12402s.m10494a();
            C12403t.m10498a(c12402s);
        }
        return str;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: B */
    public void mo10428B(C12388e c12388e, long j) throws EOFException {
        C12238m.checkParameterIsNotNull(c12388e, "sink");
        long j2 = this.f26080k;
        if (j2 >= j) {
            c12388e.write(this, j);
        } else {
            c12388e.write(this, j2);
            throw new EOFException();
        }
    }

    /* JADX INFO: renamed from: D */
    public String m10429D() {
        return m10427A(this.f26080k, C12086c.f25136a);
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: E */
    public long mo10430E(ByteString byteString) {
        C12238m.checkParameterIsNotNull(byteString, "targetBytes");
        return m10468t(byteString, 0L);
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: F */
    public BufferedSink mo10431F() {
        return this;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: G */
    public String mo10432G(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(C1643a.m877t("limit < 0: ", j).toString());
        }
        long j2 = RecyclerView.FOREVER_NS;
        if (j != RecyclerView.FOREVER_NS) {
            j2 = j + 1;
        }
        byte b2 = (byte) 10;
        long jM10466s = m10466s(b2, 0L, j2);
        if (jM10466s != -1) {
            return C12409a.m10513a(this, jM10466s);
        }
        if (j2 < this.f26080k && m10464q(j2 - 1) == ((byte) 13) && m10464q(j2) == b2) {
            return C12409a.m10513a(this, j2);
        }
        C12388e c12388e = new C12388e();
        m10460n(c12388e, 0L, Math.min(32, this.f26080k));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f26080k, j) + " content=" + c12388e.m10473x().mo10503k() + (char) 8230);
    }

    /* JADX INFO: renamed from: H */
    public String m10433H(long j) throws EOFException {
        return m10427A(j, C12086c.f25136a);
    }

    /* JADX INFO: renamed from: I */
    public int m10434I() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.f26080k == 0) {
            throw new EOFException();
        }
        byte bM10464q = m10464q(0L);
        if ((bM10464q & 128) == 0) {
            i = bM10464q & 127;
            i2 = 1;
            i3 = 0;
        } else if ((bM10464q & 224) == 192) {
            i = bM10464q & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bM10464q & 240) == 224) {
            i = bM10464q & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bM10464q & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i = bM10464q & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.f26080k < j) {
            StringBuilder sbM834V = C1643a.m834V("size < ", i2, ": ");
            sbM834V.append(this.f26080k);
            sbM834V.append(" (to read code point prefixed 0x");
            sbM834V.append(C3404f.m4345t1(bM10464q));
            sbM834V.append(')');
            throw new EOFException(sbM834V.toString());
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bM10464q2 = m10464q(j2);
            if ((bM10464q2 & 192) != 128) {
                skip(j2);
                return 65533;
            }
            i = (i << 6) | (bM10464q2 & 63);
        }
        skip(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((55296 <= i && 57343 >= i) || i < i3) {
            return 65533;
        }
        return i;
    }

    /* JADX INFO: renamed from: J */
    public final ByteString m10435J(int i) {
        if (i == 0) {
            return ByteString.f27592j;
        }
        C3404f.m4192B(this.f26080k, 0L, i);
        C12402s c12402s = this.f26079j;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (c12402s == null) {
                C12238m.throwNpe();
            }
            int i5 = c12402s.f26120c;
            int i6 = c12402s.f26119b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            c12402s = c12402s.f26123f;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        C12402s c12402s2 = this.f26079j;
        int i7 = 0;
        while (i2 < i) {
            if (c12402s2 == null) {
                C12238m.throwNpe();
            }
            bArr[i7] = c12402s2.f26118a;
            i2 += c12402s2.f26120c - c12402s2.f26119b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = c12402s2.f26119b;
            c12402s2.f26121d = true;
            i7++;
            c12402s2 = c12402s2.f26123f;
        }
        return new C12404u(bArr, iArr);
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: K */
    public /* bridge */ /* synthetic */ BufferedSink mo10436K(String str) {
        m10452b0(str);
        return this;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: M */
    public String mo10437M(Charset charset) {
        C12238m.checkParameterIsNotNull(charset, "charset");
        return m10427A(this.f26080k, charset);
    }

    /* JADX INFO: renamed from: N */
    public final C12402s m10438N(int i) {
        if (!(i >= 1 && i <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            C12402s c12402sM10499b = C12403t.m10499b();
            this.f26079j = c12402sM10499b;
            c12402sM10499b.f26124g = c12402sM10499b;
            c12402sM10499b.f26123f = c12402sM10499b;
            return c12402sM10499b;
        }
        if (c12402s == null) {
            C12238m.throwNpe();
        }
        C12402s c12402s2 = c12402s.f26124g;
        if (c12402s2 == null) {
            C12238m.throwNpe();
        }
        if (c12402s2.f26120c + i <= 8192 && c12402s2.f26122e) {
            return c12402s2;
        }
        C12402s c12402sM10499b2 = C12403t.m10499b();
        c12402s2.m10495b(c12402sM10499b2);
        return c12402sM10499b2;
    }

    /* JADX INFO: renamed from: O */
    public C12388e m10439O(ByteString byteString) {
        C12238m.checkParameterIsNotNull(byteString, "byteString");
        byteString.mo10510s(this, 0, byteString.mo10502j());
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: P */
    public long mo10440P(InterfaceC12407x interfaceC12407x) throws IOException {
        C12238m.checkParameterIsNotNull(interfaceC12407x, "source");
        long j = 0;
        while (true) {
            long jMo10176i0 = interfaceC12407x.mo10176i0(this, 8192);
            if (jMo10176i0 == -1) {
                return j;
            }
            j += jMo10176i0;
        }
    }

    /* JADX INFO: renamed from: R */
    public C12388e m10442R(byte[] bArr) {
        C12238m.checkParameterIsNotNull(bArr, "source");
        m10443S(bArr, 0, bArr.length);
        return this;
    }

    /* JADX INFO: renamed from: S */
    public C12388e m10443S(byte[] bArr, int i, int i2) {
        C12238m.checkParameterIsNotNull(bArr, "source");
        long j = i2;
        C3404f.m4192B(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            C12402s c12402sM10438N = m10438N(1);
            int iMin = Math.min(i3 - i, 8192 - c12402sM10438N.f26120c);
            int i4 = i + iMin;
            C12139j.copyInto(bArr, c12402sM10438N.f26118a, c12402sM10438N.f26120c, i, i4);
            c12402sM10438N.f26120c += iMin;
            i = i4;
        }
        this.f26080k += j;
        return this;
    }

    /* JADX INFO: renamed from: T */
    public C12388e m10444T(int i) {
        C12402s c12402sM10438N = m10438N(1);
        byte[] bArr = c12402sM10438N.f26118a;
        int i2 = c12402sM10438N.f26120c;
        c12402sM10438N.f26120c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f26080k++;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:15:0x002d  */
    /* JADX WARN: Code duplicated, block: B:17:0x0033  */
    /* JADX WARN: Code duplicated, block: B:20:0x003b  */
    /* JADX WARN: Code duplicated, block: B:21:0x003e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    /* JADX WARN: Code duplicated, block: B:30:0x005b  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x006c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0085  */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:43:0x008b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    /* JADX WARN: Code duplicated, block: B:46:0x0097  */
    /* JADX WARN: Code duplicated, block: B:47:0x009a  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:52:0x00af  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:56:0x00be  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00df  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f5 A[LOOP:0: B:69:0x00f1->B:71:0x00f5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x0105  */
    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public C12388e mo10465q0(long j) {
        byte[] bArr;
        int i;
        if (j == 0) {
            m10444T(48);
        } else {
            boolean z2 = false;
            int i2 = 1;
            if (j < 0) {
                j = -j;
                if (j < 0) {
                    m10452b0("-9223372036854775808");
                } else {
                    z2 = true;
                    if (j < 100000000) {
                        if (j < 10000) {
                            if (j < 100) {
                                if (j >= 10) {
                                    i2 = 2;
                                }
                            } else if (j < 1000) {
                                i2 = 3;
                            } else {
                                i2 = 4;
                            }
                        } else if (j < 1000000) {
                            if (j < 100000) {
                                i2 = 5;
                            } else {
                                i2 = 6;
                            }
                        } else if (j < 10000000) {
                            i2 = 7;
                        } else {
                            i2 = 8;
                        }
                    } else if (j < 1000000000000L) {
                        if (j < 10000000000L) {
                            if (j < 1000000000) {
                                i2 = 9;
                            } else {
                                i2 = 10;
                            }
                        } else if (j < 100000000000L) {
                            i2 = 11;
                        } else {
                            i2 = 12;
                        }
                    } else if (j < 1000000000000000L) {
                        if (j < 10000000000000L) {
                            i2 = 13;
                        } else if (j < 100000000000000L) {
                            i2 = 14;
                        } else {
                            i2 = 15;
                        }
                    } else if (j < 100000000000000000L) {
                        if (j < 10000000000000000L) {
                            i2 = 16;
                        } else {
                            i2 = 17;
                        }
                    } else if (j < 1000000000000000000L) {
                        i2 = 18;
                    } else {
                        i2 = 19;
                    }
                    if (z2) {
                        i2++;
                    }
                    C12402s c12402sM10438N = m10438N(i2);
                    bArr = c12402sM10438N.f26118a;
                    i = c12402sM10438N.f26120c + i2;
                    while (j != 0) {
                        long j2 = 10;
                        i--;
                        bArr[i] = C12409a.f26137a[(int) (j % j2)];
                        j /= j2;
                    }
                    if (z2) {
                        bArr[i - 1] = (byte) 45;
                    }
                    c12402sM10438N.f26120c += i2;
                    this.f26080k += (long) i2;
                }
            } else {
                if (j < 100000000) {
                    if (j < 10000) {
                        if (j < 100) {
                            if (j >= 10) {
                                i2 = 2;
                            }
                        } else if (j < 1000) {
                            i2 = 3;
                        } else {
                            i2 = 4;
                        }
                    } else if (j < 1000000) {
                        if (j < 100000) {
                            i2 = 5;
                        } else {
                            i2 = 6;
                        }
                    } else if (j < 10000000) {
                        i2 = 7;
                    } else {
                        i2 = 8;
                    }
                } else if (j < 1000000000000L) {
                    if (j < 10000000000L) {
                        if (j < 1000000000) {
                            i2 = 9;
                        } else {
                            i2 = 10;
                        }
                    } else if (j < 100000000000L) {
                        i2 = 11;
                    } else {
                        i2 = 12;
                    }
                } else if (j < 1000000000000000L) {
                    if (j < 10000000000000L) {
                        i2 = 13;
                    } else if (j < 100000000000000L) {
                        i2 = 14;
                    } else {
                        i2 = 15;
                    }
                } else if (j < 100000000000000000L) {
                    if (j < 10000000000000000L) {
                        i2 = 16;
                    } else {
                        i2 = 17;
                    }
                } else if (j < 1000000000000000000L) {
                    i2 = 18;
                } else {
                    i2 = 19;
                }
                if (z2) {
                    i2++;
                }
                C12402s c12402sM10438N2 = m10438N(i2);
                bArr = c12402sM10438N2.f26118a;
                i = c12402sM10438N2.f26120c + i2;
                while (j != 0) {
                    long j3 = 10;
                    i--;
                    bArr[i] = C12409a.f26137a[(int) (j % j3)];
                    j /= j3;
                }
                if (z2) {
                    bArr[i - 1] = (byte) 45;
                }
                c12402sM10438N2.f26120c += i2;
                this.f26080k += (long) i2;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public C12388e mo10441Q(long j) {
        if (j == 0) {
            m10444T(48);
        } else {
            long j2 = (j >>> 1) | j;
            long j3 = j2 | (j2 >>> 2);
            long j4 = j3 | (j3 >>> 4);
            long j5 = j4 | (j4 >>> 8);
            long j6 = j5 | (j5 >>> 16);
            long j7 = j6 | (j6 >>> 32);
            long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
            long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
            long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
            long j11 = j10 + (j10 >>> 8);
            long j12 = j11 + (j11 >>> 16);
            int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
            C12402s c12402sM10438N = m10438N(i);
            byte[] bArr = c12402sM10438N.f26118a;
            int i2 = c12402sM10438N.f26120c;
            for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
                bArr[i3] = C12409a.f26137a[(int) (15 & j)];
                j >>>= 4;
            }
            c12402sM10438N.f26120c += i;
            this.f26080k += (long) i;
        }
        return this;
    }

    /* JADX INFO: renamed from: W */
    public C12388e m10447W(int i) {
        C12402s c12402sM10438N = m10438N(4);
        byte[] bArr = c12402sM10438N.f26118a;
        int i2 = c12402sM10438N.f26120c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        c12402sM10438N.f26120c = i5 + 1;
        this.f26080k += 4;
        return this;
    }

    /* JADX INFO: renamed from: X */
    public C12388e m10448X(int i) {
        C12402s c12402sM10438N = m10438N(2);
        byte[] bArr = c12402sM10438N.f26118a;
        int i2 = c12402sM10438N.f26120c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        c12402sM10438N.f26120c = i3 + 1;
        this.f26080k += 2;
        return this;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: Y */
    public String mo10449Y() throws EOFException {
        return mo10432G(RecyclerView.FOREVER_NS);
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: Z */
    public byte[] mo10450Z(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(C1643a.m877t("byteCount: ", j).toString());
        }
        if (this.f26080k < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C12388e clone() {
        C12388e c12388e = new C12388e();
        if (this.f26080k != 0) {
            C12402s c12402s = this.f26079j;
            if (c12402s == null) {
                C12238m.throwNpe();
            }
            C12402s c12402sM10496c = c12402s.m10496c();
            c12388e.f26079j = c12402sM10496c;
            c12402sM10496c.f26124g = c12402sM10496c;
            c12402sM10496c.f26123f = c12402sM10496c;
            for (C12402s c12402s2 = c12402s.f26123f; c12402s2 != c12402s; c12402s2 = c12402s2.f26123f) {
                C12402s c12402s3 = c12402sM10496c.f26124g;
                if (c12402s3 == null) {
                    C12238m.throwNpe();
                }
                if (c12402s2 == null) {
                    C12238m.throwNpe();
                }
                c12402s3.m10495b(c12402s2.m10496c());
            }
            c12388e.f26080k = this.f26080k;
        }
        return c12388e;
    }

    /* JADX INFO: renamed from: b0 */
    public C12388e m10452b0(String str) {
        C12238m.checkParameterIsNotNull(str, "string");
        m10453c0(str, 0, str.length());
        return this;
    }

    /* JADX INFO: renamed from: c0 */
    public C12388e m10453c0(String str, int i, int i2) {
        char cCharAt;
        C12238m.checkParameterIsNotNull(str, "string");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m871q("beginIndex < 0: ", i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(C1643a.m875s("endIndex < beginIndex: ", i2, " < ", i).toString());
        }
        if (!(i2 <= str.length())) {
            StringBuilder sbM834V = C1643a.m834V("endIndex > string.length: ", i2, " > ");
            sbM834V.append(str.length());
            throw new IllegalArgumentException(sbM834V.toString().toString());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                C12402s c12402sM10438N = m10438N(1);
                byte[] bArr = c12402sM10438N.f26118a;
                int i3 = c12402sM10438N.f26120c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = c12402sM10438N.f26120c;
                int i6 = (i3 + i) - i5;
                c12402sM10438N.f26120c = i5 + i6;
                this.f26080k += (long) i6;
            } else {
                if (cCharAt2 < 2048) {
                    C12402s c12402sM10438N2 = m10438N(2);
                    byte[] bArr2 = c12402sM10438N2.f26118a;
                    int i7 = c12402sM10438N2.f26120c;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | Opcodes.CHECKCAST);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    c12402sM10438N2.f26120c = i7 + 2;
                    this.f26080k += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    C12402s c12402sM10438N3 = m10438N(3);
                    byte[] bArr3 = c12402sM10438N3.f26118a;
                    int i8 = c12402sM10438N3.f26120c;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    c12402sM10438N3.f26120c = i8 + 3;
                    this.f26080k += 3;
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        m10444T(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        C12402s c12402sM10438N4 = m10438N(4);
                        byte[] bArr4 = c12402sM10438N4.f26118a;
                        int i11 = c12402sM10438N4.f26120c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        c12402sM10438N4.f26120c = i11 + 4;
                        this.f26080k += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX INFO: renamed from: d0 */
    public C12388e m10454d0(int i) {
        String str;
        if (i < 128) {
            m10444T(i);
        } else if (i < 2048) {
            C12402s c12402sM10438N = m10438N(2);
            byte[] bArr = c12402sM10438N.f26118a;
            int i2 = c12402sM10438N.f26120c;
            bArr[i2] = (byte) ((i >> 6) | Opcodes.CHECKCAST);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            c12402sM10438N.f26120c = i2 + 2;
            this.f26080k += 2;
        } else if (55296 <= i && 57343 >= i) {
            m10444T(63);
        } else if (i < 65536) {
            C12402s c12402sM10438N2 = m10438N(3);
            byte[] bArr2 = c12402sM10438N2.f26118a;
            int i3 = c12402sM10438N2.f26120c;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            c12402sM10438N2.f26120c = i3 + 3;
            this.f26080k += 3;
        } else {
            if (i > 1114111) {
                StringBuilder sbM833U = C1643a.m833U("Unexpected code point: 0x");
                if (i != 0) {
                    char[] cArr = C12410b.f26138a;
                    int i4 = 0;
                    char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
                    while (i4 < 8 && cArr2[i4] == '0') {
                        i4++;
                    }
                    str = new String(cArr2, i4, 8 - i4);
                } else {
                    str = "0";
                }
                sbM833U.append(str);
                throw new IllegalArgumentException(sbM833U.toString());
            }
            C12402s c12402sM10438N3 = m10438N(4);
            byte[] bArr3 = c12402sM10438N3.f26118a;
            int i5 = c12402sM10438N3.f26120c;
            bArr3[i5] = (byte) ((i >> 18) | 240);
            bArr3[i5 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i & 63) | 128);
            c12402sM10438N3.f26120c = i5 + 4;
            this.f26080k += 4;
        }
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: e0 */
    public /* bridge */ /* synthetic */ BufferedSink mo10455e0(ByteString byteString) {
        m10439O(byteString);
        return this;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof C12388e)) {
                return false;
            }
            long j = this.f26080k;
            C12388e c12388e = (C12388e) obj;
            if (j != c12388e.f26080k) {
                return false;
            }
            if (j != 0) {
                C12402s c12402s = this.f26079j;
                if (c12402s == null) {
                    C12238m.throwNpe();
                }
                C12402s c12402s2 = c12388e.f26079j;
                if (c12402s2 == null) {
                    C12238m.throwNpe();
                }
                int i = c12402s.f26119b;
                int i2 = c12402s2.f26119b;
                long j2 = 0;
                while (j2 < this.f26080k) {
                    long jMin = Math.min(c12402s.f26120c - i, c12402s2.f26120c - i2);
                    long j3 = 0;
                    while (j3 < jMin) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (c12402s.f26118a[i] != c12402s2.f26118a[i2]) {
                            return false;
                        }
                        j3++;
                        i = i3;
                        i2 = i4;
                    }
                    if (i == c12402s.f26120c) {
                        c12402s = c12402s.f26123f;
                        if (c12402s == null) {
                            C12238m.throwNpe();
                        }
                        i = c12402s.f26119b;
                    }
                    if (i2 == c12402s2.f26120c) {
                        c12402s2 = c12402s2.f26123f;
                        if (c12402s2 == null) {
                            C12238m.throwNpe();
                        }
                        i2 = c12402s2.f26119b;
                    }
                    j2 += jMin;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public final long m10456f() {
        long j = this.f26080k;
        if (j == 0) {
            return 0L;
        }
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            C12238m.throwNpe();
        }
        C12402s c12402s2 = c12402s.f26124g;
        if (c12402s2 == null) {
            C12238m.throwNpe();
        }
        int i = c12402s2.f26120c;
        if (i < 8192 && c12402s2.f26122e) {
            j -= (long) (i - c12402s2.f26119b);
        }
        return j;
    }

    @Override // okio.BufferedSink, p615g0.InterfaceC12405v, java.io.Flushable
    public void flush() {
    }

    @Override // p615g0.InterfaceC12390g, okio.BufferedSink
    /* JADX INFO: renamed from: g */
    public C12388e mo10457g() {
        return this;
    }

    public int hashCode() {
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = c12402s.f26120c;
            for (int i3 = c12402s.f26119b; i3 < i2; i3++) {
                i = (i * 31) + c12402s.f26118a[i3];
            }
            c12402s = c12402s.f26123f;
            if (c12402s == null) {
                C12238m.throwNpe();
            }
        } while (c12402s != this.f26079j);
        return i;
    }

    @Override // p615g0.InterfaceC12407x
    /* JADX INFO: renamed from: i0 */
    public long mo10176i0(C12388e c12388e, long j) {
        C12238m.checkParameterIsNotNull(c12388e, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(C1643a.m877t("byteCount < 0: ", j).toString());
        }
        long j2 = this.f26080k;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        c12388e.write(this, j);
        return j;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: j */
    public boolean mo10458j(long j) {
        return this.f26080k >= j;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: k0 */
    public long mo10459k0(InterfaceC12405v interfaceC12405v) throws IOException {
        C12238m.checkParameterIsNotNull(interfaceC12405v, "sink");
        long j = this.f26080k;
        if (j > 0) {
            interfaceC12405v.write(this, j);
        }
        return j;
    }

    /* JADX INFO: renamed from: n */
    public final C12388e m10460n(C12388e c12388e, long j, long j2) {
        C12238m.checkParameterIsNotNull(c12388e, "out");
        C3404f.m4192B(this.f26080k, j, j2);
        if (j2 != 0) {
            c12388e.f26080k += j2;
            C12402s c12402s = this.f26079j;
            while (true) {
                if (c12402s == null) {
                    C12238m.throwNpe();
                }
                int i = c12402s.f26120c;
                int i2 = c12402s.f26119b;
                if (j < i - i2) {
                    break;
                }
                j -= (long) (i - i2);
                c12402s = c12402s.f26123f;
            }
            while (j2 > 0) {
                if (c12402s == null) {
                    C12238m.throwNpe();
                }
                C12402s c12402sM10496c = c12402s.m10496c();
                int i3 = c12402sM10496c.f26119b + ((int) j);
                c12402sM10496c.f26119b = i3;
                c12402sM10496c.f26120c = Math.min(i3 + ((int) j2), c12402sM10496c.f26120c);
                C12402s c12402s2 = c12388e.f26079j;
                if (c12402s2 == null) {
                    c12402sM10496c.f26124g = c12402sM10496c;
                    c12402sM10496c.f26123f = c12402sM10496c;
                    c12388e.f26079j = c12402sM10496c;
                } else {
                    if (c12402s2 == null) {
                        C12238m.throwNpe();
                    }
                    C12402s c12402s3 = c12402s2.f26124g;
                    if (c12402s3 == null) {
                        C12238m.throwNpe();
                    }
                    c12402s3.m10495b(c12402sM10496c);
                }
                j2 -= (long) (c12402sM10496c.f26120c - c12402sM10496c.f26119b);
                c12402s = c12402s.f26123f;
                j = 0;
            }
        }
        return this;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: o */
    public ByteString mo10461o(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(C1643a.m877t("byteCount: ", j).toString());
        }
        if (this.f26080k < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(mo10450Z(j));
        }
        ByteString byteStringM10435J = m10435J((int) j);
        skip(j);
        return byteStringM10435J;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: p */
    public BufferedSink mo10462p() {
        return this;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: p0 */
    public void mo10463p0(long j) throws EOFException {
        if (this.f26080k < j) {
            throw new EOFException();
        }
    }

    /* JADX INFO: renamed from: q */
    public final byte m10464q(long j) {
        C3404f.m4192B(this.f26080k, j, 1L);
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            C12238m.throwNpe();
            throw null;
        }
        long j2 = this.f26080k;
        if (j2 - j < j) {
            while (j2 > j) {
                c12402s = c12402s.f26124g;
                if (c12402s == null) {
                    C12238m.throwNpe();
                }
                j2 -= (long) (c12402s.f26120c - c12402s.f26119b);
            }
            return c12402s.f26118a[(int) ((((long) c12402s.f26119b) + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = c12402s.f26120c;
            int i2 = c12402s.f26119b;
            long j4 = ((long) (i - i2)) + j3;
            if (j4 > j) {
                return c12402s.f26118a[(int) ((((long) i2) + j) - j3)];
            }
            c12402s = c12402s.f26123f;
            if (c12402s == null) {
                C12238m.throwNpe();
            }
            j3 = j4;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        C12238m.checkParameterIsNotNull(byteBuffer, "sink");
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), c12402s.f26120c - c12402s.f26119b);
        byteBuffer.put(c12402s.f26118a, c12402s.f26119b, iMin);
        int i = c12402s.f26119b + iMin;
        c12402s.f26119b = i;
        this.f26080k -= (long) iMin;
        if (i == c12402s.f26120c) {
            this.f26079j = c12402s.m10494a();
            C12403t.m10498a(c12402s);
        }
        return iMin;
    }

    @Override // p615g0.InterfaceC12390g
    public byte readByte() throws EOFException {
        if (this.f26080k == 0) {
            throw new EOFException();
        }
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            C12238m.throwNpe();
        }
        int i = c12402s.f26119b;
        int i2 = c12402s.f26120c;
        int i3 = i + 1;
        byte b2 = c12402s.f26118a[i];
        this.f26080k--;
        if (i3 == i2) {
            this.f26079j = c12402s.m10494a();
            C12403t.m10498a(c12402s);
        } else {
            c12402s.f26119b = i3;
        }
        return b2;
    }

    @Override // p615g0.InterfaceC12390g
    public void readFully(byte[] bArr) throws EOFException {
        C12238m.checkParameterIsNotNull(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // p615g0.InterfaceC12390g
    public int readInt() throws EOFException {
        if (this.f26080k < 4) {
            throw new EOFException();
        }
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            C12238m.throwNpe();
        }
        int i = c12402s.f26119b;
        int i2 = c12402s.f26120c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = c12402s.f26118a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.f26080k -= 4;
        if (i8 == i2) {
            this.f26079j = c12402s.m10494a();
            C12403t.m10498a(c12402s);
        } else {
            c12402s.f26119b = i8;
        }
        return i9;
    }

    @Override // p615g0.InterfaceC12390g
    public long readLong() throws EOFException {
        if (this.f26080k < 8) {
            throw new EOFException();
        }
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            C12238m.throwNpe();
        }
        int i = c12402s.f26119b;
        int i2 = c12402s.f26120c;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = c12402s.f26118a;
        int i3 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i3]) & 255) << 48);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 40);
        int i6 = i5 + 1;
        long j4 = ((((long) bArr[i5]) & 255) << 32) | j3;
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 24);
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 16);
        int i9 = i8 + 1;
        long j7 = j6 | ((((long) bArr[i8]) & 255) << 8);
        int i10 = i9 + 1;
        long j8 = j7 | (((long) bArr[i9]) & 255);
        this.f26080k -= 8;
        if (i10 == i2) {
            this.f26079j = c12402s.m10494a();
            C12403t.m10498a(c12402s);
        } else {
            c12402s.f26119b = i10;
        }
        return j8;
    }

    @Override // p615g0.InterfaceC12390g
    public short readShort() throws EOFException {
        if (this.f26080k < 2) {
            throw new EOFException();
        }
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            C12238m.throwNpe();
        }
        int i = c12402s.f26119b;
        int i2 = c12402s.f26120c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = c12402s.f26118a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f26080k -= 2;
        if (i4 == i2) {
            this.f26079j = c12402s.m10494a();
            C12403t.m10498a(c12402s);
        } else {
            c12402s.f26119b = i4;
        }
        return (short) i5;
    }

    /* JADX INFO: renamed from: s */
    public long m10466s(byte b2, long j, long j2) {
        C12402s c12402s;
        long j3 = 0;
        if (!(0 <= j && j2 >= j)) {
            StringBuilder sbM833U = C1643a.m833U("size=");
            sbM833U.append(this.f26080k);
            sbM833U.append(" fromIndex=");
            sbM833U.append(j);
            sbM833U.append(" toIndex=");
            sbM833U.append(j2);
            throw new IllegalArgumentException(sbM833U.toString().toString());
        }
        long j4 = this.f26080k;
        if (j2 > j4) {
            j2 = j4;
        }
        if (j != j2 && (c12402s = this.f26079j) != null) {
            if (j4 - j < j) {
                while (j4 > j) {
                    c12402s = c12402s.f26124g;
                    if (c12402s == null) {
                        C12238m.throwNpe();
                    }
                    j4 -= (long) (c12402s.f26120c - c12402s.f26119b);
                }
                while (j4 < j2) {
                    byte[] bArr = c12402s.f26118a;
                    int iMin = (int) Math.min(c12402s.f26120c, (((long) c12402s.f26119b) + j2) - j4);
                    for (int i = (int) ((((long) c12402s.f26119b) + j) - j4); i < iMin; i++) {
                        if (bArr[i] == b2) {
                            return ((long) (i - c12402s.f26119b)) + j4;
                        }
                    }
                    j4 += (long) (c12402s.f26120c - c12402s.f26119b);
                    c12402s = c12402s.f26123f;
                    if (c12402s == null) {
                        C12238m.throwNpe();
                    }
                    j = j4;
                }
            } else {
                while (true) {
                    long j5 = ((long) (c12402s.f26120c - c12402s.f26119b)) + j3;
                    if (j5 > j) {
                        break;
                    }
                    c12402s = c12402s.f26123f;
                    if (c12402s == null) {
                        C12238m.throwNpe();
                    }
                    j3 = j5;
                }
                while (j3 < j2) {
                    byte[] bArr2 = c12402s.f26118a;
                    int iMin2 = (int) Math.min(c12402s.f26120c, (((long) c12402s.f26119b) + j2) - j3);
                    for (int i2 = (int) ((((long) c12402s.f26119b) + j) - j3); i2 < iMin2; i2++) {
                        if (bArr2[i2] == b2) {
                            return ((long) (i2 - c12402s.f26119b)) + j3;
                        }
                    }
                    j3 += (long) (c12402s.f26120c - c12402s.f26119b);
                    c12402s = c12402s.f26123f;
                    if (c12402s == null) {
                        C12238m.throwNpe();
                    }
                    j = j3;
                }
            }
        }
        return -1L;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: s0 */
    public long mo10467s0() throws EOFException {
        int i;
        if (this.f26080k == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z2 = false;
        long j = 0;
        do {
            C12402s c12402s = this.f26079j;
            if (c12402s == null) {
                C12238m.throwNpe();
            }
            byte[] bArr = c12402s.f26118a;
            int i3 = c12402s.f26119b;
            int i4 = c12402s.f26120c;
            while (i3 < i4) {
                byte b2 = bArr[i3];
                byte b3 = (byte) 48;
                if (b2 < b3 || b2 > ((byte) 57)) {
                    byte b4 = (byte) 97;
                    if ((b2 < b4 || b2 > ((byte) 102)) && (b2 < (b4 = (byte) 65) || b2 > ((byte) 70))) {
                        if (i2 != 0) {
                            z2 = true;
                            break;
                        }
                        StringBuilder sbM833U = C1643a.m833U("Expected leading [0-9a-fA-F] character but was 0x");
                        sbM833U.append(C3404f.m4345t1(b2));
                        throw new NumberFormatException(sbM833U.toString());
                    }
                    i = (b2 - b4) + 10;
                } else {
                    i = b2 - b3;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    C12388e c12388e = new C12388e();
                    c12388e.mo10441Q(j);
                    c12388e.m10444T(b2);
                    StringBuilder sbM833U2 = C1643a.m833U("Number too large: ");
                    sbM833U2.append(c12388e.m10429D());
                    throw new NumberFormatException(sbM833U2.toString());
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.f26079j = c12402s.m10494a();
                C12403t.m10498a(c12402s);
            } else {
                c12402s.f26119b = i3;
            }
            if (z2) {
                break;
            }
        } while (this.f26079j != null);
        this.f26080k -= (long) i2;
        return j;
    }

    @Override // p615g0.InterfaceC12390g
    public void skip(long j) throws EOFException {
        while (j > 0) {
            C12402s c12402s = this.f26079j;
            if (c12402s == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, c12402s.f26120c - c12402s.f26119b);
            long j2 = iMin;
            this.f26080k -= j2;
            j -= j2;
            int i = c12402s.f26119b + iMin;
            c12402s.f26119b = i;
            if (i == c12402s.f26120c) {
                this.f26079j = c12402s.m10494a();
                C12403t.m10498a(c12402s);
            }
        }
    }

    /* JADX INFO: renamed from: t */
    public long m10468t(ByteString byteString, long j) {
        int i;
        int i2;
        int i3;
        int i4;
        long j2 = j;
        C12238m.checkParameterIsNotNull(byteString, "targetBytes");
        long j3 = 0;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(C1643a.m877t("fromIndex < 0: ", j2).toString());
        }
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            return -1L;
        }
        long j4 = this.f26080k;
        if (j4 - j2 < j2) {
            while (j4 > j2) {
                c12402s = c12402s.f26124g;
                if (c12402s == null) {
                    C12238m.throwNpe();
                }
                j4 -= (long) (c12402s.f26120c - c12402s.f26119b);
            }
            if (byteString.mo10502j() == 2) {
                byte bMo10505m = byteString.mo10505m(0);
                byte bMo10505m2 = byteString.mo10505m(1);
                while (j4 < this.f26080k) {
                    byte[] bArr = c12402s.f26118a;
                    i3 = (int) ((((long) c12402s.f26119b) + j2) - j4);
                    int i5 = c12402s.f26120c;
                    while (i3 < i5) {
                        byte b2 = bArr[i3];
                        if (b2 == bMo10505m || b2 == bMo10505m2) {
                            i4 = c12402s.f26119b;
                        } else {
                            i3++;
                        }
                    }
                    j4 += (long) (c12402s.f26120c - c12402s.f26119b);
                    c12402s = c12402s.f26123f;
                    if (c12402s == null) {
                        C12238m.throwNpe();
                    }
                    j2 = j4;
                }
                return -1L;
            }
            byte[] bArrMo10504l = byteString.mo10504l();
            while (j4 < this.f26080k) {
                byte[] bArr2 = c12402s.f26118a;
                i3 = (int) ((((long) c12402s.f26119b) + j2) - j4);
                int i6 = c12402s.f26120c;
                while (i3 < i6) {
                    byte b3 = bArr2[i3];
                    for (byte b4 : bArrMo10504l) {
                        if (b3 == b4) {
                            i4 = c12402s.f26119b;
                        }
                    }
                    i3++;
                }
                j4 += (long) (c12402s.f26120c - c12402s.f26119b);
                c12402s = c12402s.f26123f;
                if (c12402s == null) {
                    C12238m.throwNpe();
                }
                j2 = j4;
            }
            return -1L;
            return ((long) (i3 - i4)) + j4;
        }
        while (true) {
            long j5 = ((long) (c12402s.f26120c - c12402s.f26119b)) + j3;
            if (j5 > j2) {
                break;
            }
            c12402s = c12402s.f26123f;
            if (c12402s == null) {
                C12238m.throwNpe();
            }
            j3 = j5;
        }
        if (byteString.mo10502j() == 2) {
            byte bMo10505m3 = byteString.mo10505m(0);
            byte bMo10505m4 = byteString.mo10505m(1);
            while (j3 < this.f26080k) {
                byte[] bArr3 = c12402s.f26118a;
                i = (int) ((((long) c12402s.f26119b) + j2) - j3);
                int i7 = c12402s.f26120c;
                while (i < i7) {
                    byte b5 = bArr3[i];
                    if (b5 == bMo10505m3 || b5 == bMo10505m4) {
                        i2 = c12402s.f26119b;
                    } else {
                        i++;
                    }
                }
                j3 += (long) (c12402s.f26120c - c12402s.f26119b);
                c12402s = c12402s.f26123f;
                if (c12402s == null) {
                    C12238m.throwNpe();
                }
                j2 = j3;
            }
            return -1L;
        }
        byte[] bArrMo10504l2 = byteString.mo10504l();
        while (j3 < this.f26080k) {
            byte[] bArr4 = c12402s.f26118a;
            i = (int) ((((long) c12402s.f26119b) + j2) - j3);
            int i8 = c12402s.f26120c;
            while (i < i8) {
                byte b6 = bArr4[i];
                for (byte b7 : bArrMo10504l2) {
                    if (b6 == b7) {
                        i2 = c12402s.f26119b;
                    }
                }
                i++;
            }
            j3 += (long) (c12402s.f26120c - c12402s.f26119b);
            c12402s = c12402s.f26123f;
            if (c12402s == null) {
                C12238m.throwNpe();
            }
            j2 = j3;
        }
        return -1L;
        return ((long) (i - i2)) + j3;
    }

    @Override // p615g0.InterfaceC12407x
    public C12408y timeout() {
        return C12408y.f26133a;
    }

    public String toString() {
        long j = this.f26080k;
        if (j <= ((long) Integer.MAX_VALUE)) {
            return m10435J((int) j).toString();
        }
        StringBuilder sbM833U = C1643a.m833U("size > Int.MAX_VALUE: ");
        sbM833U.append(this.f26080k);
        throw new IllegalStateException(sbM833U.toString().toString());
    }

    /* JADX INFO: renamed from: u */
    public final a m10469u(a aVar) {
        C12238m.checkParameterIsNotNull(aVar, "unsafeCursor");
        if (!(aVar.f26081j == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        aVar.f26081j = this;
        aVar.f26082k = true;
        return aVar;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: u0 */
    public InputStream mo10470u0() {
        return new b();
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: v0 */
    public int mo10471v0(C12398o c12398o) throws EOFException {
        C12238m.checkParameterIsNotNull(c12398o, "options");
        int iM10514b = C12409a.m10514b(this, c12398o, false);
        if (iM10514b == -1) {
            return -1;
        }
        skip(c12398o.f26107l[iM10514b].mo10502j());
        return iM10514b;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: w */
    public boolean mo10472w() {
        return this.f26080k == 0;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr) {
        m10442R(bArr);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeByte(int i) {
        m10444T(i);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeInt(int i) {
        m10447W(i);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShort(int i) {
        m10448X(i);
        return this;
    }

    /* JADX INFO: renamed from: x */
    public ByteString m10473x() {
        return mo10461o(this.f26080k);
    }

    /* JADX INFO: renamed from: y */
    public short m10474y() throws EOFException {
        int i = readShort() & 65535;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr, int i, int i2) {
        m10443S(bArr, i, i2);
        return this;
    }

    /* JADX INFO: renamed from: g0.e$b */
    /* JADX INFO: compiled from: Buffer.kt */
    public static final class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(C12388e.this.f26080k, Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            C12388e c12388e = C12388e.this;
            if (c12388e.f26080k > 0) {
                return c12388e.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return C12388e.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            C12238m.checkParameterIsNotNull(bArr, "sink");
            return C12388e.this.read(bArr, i, i2);
        }
    }

    @Override // p615g0.InterfaceC12405v
    public void write(C12388e c12388e, long j) {
        int i;
        C12402s c12402s;
        C12402s c12402sM10499b;
        C12238m.checkParameterIsNotNull(c12388e, "source");
        if (c12388e != this) {
            C3404f.m4192B(c12388e.f26080k, 0L, j);
            long j2 = j;
            while (j2 > 0) {
                C12402s c12402s2 = c12388e.f26079j;
                if (c12402s2 == null) {
                    C12238m.throwNpe();
                }
                int i2 = c12402s2.f26120c;
                C12402s c12402s3 = c12388e.f26079j;
                if (c12402s3 == null) {
                    C12238m.throwNpe();
                }
                if (j2 < i2 - c12402s3.f26119b) {
                    C12402s c12402s4 = this.f26079j;
                    if (c12402s4 != null) {
                        if (c12402s4 == null) {
                            C12238m.throwNpe();
                        }
                        c12402s = c12402s4.f26124g;
                    } else {
                        c12402s = null;
                    }
                    if (c12402s != null && c12402s.f26122e) {
                        if ((((long) c12402s.f26120c) + j2) - ((long) (c12402s.f26121d ? 0 : c12402s.f26119b)) <= 8192) {
                            C12402s c12402s5 = c12388e.f26079j;
                            if (c12402s5 == null) {
                                C12238m.throwNpe();
                            }
                            c12402s5.m10497d(c12402s, (int) j2);
                            c12388e.f26080k -= j2;
                            this.f26080k += j2;
                            return;
                        }
                    }
                    C12402s c12402s6 = c12388e.f26079j;
                    if (c12402s6 == null) {
                        C12238m.throwNpe();
                    }
                    int i3 = (int) j2;
                    Objects.requireNonNull(c12402s6);
                    if (i3 > 0 && i3 <= c12402s6.f26120c - c12402s6.f26119b) {
                        if (i3 >= 1024) {
                            c12402sM10499b = c12402s6.m10496c();
                        } else {
                            c12402sM10499b = C12403t.m10499b();
                            byte[] bArr = c12402s6.f26118a;
                            byte[] bArr2 = c12402sM10499b.f26118a;
                            int i4 = c12402s6.f26119b;
                            C12139j.copyInto$default(bArr, bArr2, 0, i4, i4 + i3, 2, (Object) null);
                        }
                        c12402sM10499b.f26120c = c12402sM10499b.f26119b + i3;
                        c12402s6.f26119b += i3;
                        C12402s c12402s7 = c12402s6.f26124g;
                        if (c12402s7 == null) {
                            C12238m.throwNpe();
                        }
                        c12402s7.m10495b(c12402sM10499b);
                        c12388e.f26079j = c12402sM10499b;
                    } else {
                        throw new IllegalArgumentException("byteCount out of range".toString());
                    }
                }
                C12402s c12402s8 = c12388e.f26079j;
                if (c12402s8 == null) {
                    C12238m.throwNpe();
                }
                long j3 = c12402s8.f26120c - c12402s8.f26119b;
                c12388e.f26079j = c12402s8.m10494a();
                C12402s c12402s9 = this.f26079j;
                if (c12402s9 == null) {
                    this.f26079j = c12402s8;
                    c12402s8.f26124g = c12402s8;
                    c12402s8.f26123f = c12402s8;
                } else {
                    if (c12402s9 == null) {
                        C12238m.throwNpe();
                    }
                    C12402s c12402s10 = c12402s9.f26124g;
                    if (c12402s10 == null) {
                        C12238m.throwNpe();
                    }
                    c12402s10.m10495b(c12402s8);
                    C12402s c12402s11 = c12402s8.f26124g;
                    if (!(c12402s11 != c12402s8)) {
                        throw new IllegalStateException("cannot compact".toString());
                    }
                    if (c12402s11 == null) {
                        C12238m.throwNpe();
                    }
                    if (c12402s11.f26122e) {
                        int i5 = c12402s8.f26120c - c12402s8.f26119b;
                        C12402s c12402s12 = c12402s8.f26124g;
                        if (c12402s12 == null) {
                            C12238m.throwNpe();
                        }
                        int i6 = 8192 - c12402s12.f26120c;
                        C12402s c12402s13 = c12402s8.f26124g;
                        if (c12402s13 == null) {
                            C12238m.throwNpe();
                        }
                        if (c12402s13.f26121d) {
                            i = 0;
                        } else {
                            C12402s c12402s14 = c12402s8.f26124g;
                            if (c12402s14 == null) {
                                C12238m.throwNpe();
                            }
                            i = c12402s14.f26119b;
                        }
                        if (i5 <= i6 + i) {
                            C12402s c12402s15 = c12402s8.f26124g;
                            if (c12402s15 == null) {
                                C12238m.throwNpe();
                            }
                            c12402s8.m10497d(c12402s15, i5);
                            c12402s8.m10494a();
                            C12403t.m10498a(c12402s8);
                        }
                    }
                }
                c12388e.f26080k -= j3;
                this.f26080k += j3;
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public int read(byte[] bArr, int i, int i2) {
        C12238m.checkParameterIsNotNull(bArr, "sink");
        C3404f.m4192B(bArr.length, i, i2);
        C12402s c12402s = this.f26079j;
        if (c12402s == null) {
            return -1;
        }
        int iMin = Math.min(i2, c12402s.f26120c - c12402s.f26119b);
        byte[] bArr2 = c12402s.f26118a;
        int i3 = c12402s.f26119b;
        C12139j.copyInto(bArr2, bArr, i, i3, i3 + iMin);
        int i4 = c12402s.f26119b + iMin;
        c12402s.f26119b = i4;
        this.f26080k -= (long) iMin;
        if (i4 != c12402s.f26120c) {
            return iMin;
        }
        this.f26079j = c12402s.m10494a();
        C12403t.m10498a(c12402s);
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        C12238m.checkParameterIsNotNull(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            C12402s c12402sM10438N = m10438N(1);
            int iMin = Math.min(i, 8192 - c12402sM10438N.f26120c);
            byteBuffer.get(c12402sM10438N.f26118a, c12402sM10438N.f26120c, iMin);
            i -= iMin;
            c12402sM10438N.f26120c += iMin;
        }
        this.f26080k += (long) iRemaining;
        return iRemaining;
    }
}
