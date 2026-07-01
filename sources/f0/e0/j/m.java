package f0.e0.j;

import com.discord.api.permission.Permission;
import d0.t.u;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.ranges.IntProgression;
import okio.ByteString;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Http2Reader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements Closeable {
    public static final Logger j;
    public static final m k = null;
    public final m$a l;
    public final c$a m;
    public final g0.g n;
    public final boolean o;

    static {
        Logger logger = Logger.getLogger(d.class.getName());
        d0.z.d.m.checkExpressionValueIsNotNull(logger, "Logger.getLogger(Http2::class.java.name)");
        j = logger;
    }

    public m(g0.g gVar, boolean z2) {
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        this.n = gVar;
        this.o = z2;
        m$a m_a = new m$a(gVar);
        this.l = m_a;
        this.m = new c$a(m_a, 4096, 0, 4);
    }

    public final boolean a(boolean z2, m$b m_b) throws IOException {
        a aVar;
        a aVar2;
        d0.z.d.m.checkParameterIsNotNull(m_b, "handler");
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        try {
            this.n.p0(9L);
            int iT = f0.e0.c.t(this.n);
            if (iT > 16384) {
                throw new IOException(b.d.b.a.a.q("FRAME_SIZE_ERROR: ", iT));
            }
            int i4 = this.n.readByte() & 255;
            int i5 = this.n.readByte() & 255;
            int i6 = this.n.readInt() & Integer.MAX_VALUE;
            Logger logger = j;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(d.e.b(true, i6, iT, i4, i5));
            }
            if (z2 && i4 != 4) {
                StringBuilder sbU = b.d.b.a.a.U("Expected a SETTINGS frame but was ");
                sbU.append(d.e.a(i4));
                throw new IOException(sbU.toString());
            }
            switch (i4) {
                case 0:
                    if (i6 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
                    }
                    boolean z3 = (i5 & 1) != 0;
                    if ((i5 & 32) != 0) {
                        throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
                    }
                    int i7 = i5 & 8;
                    if (i7 != 0) {
                        byte b2 = this.n.readByte();
                        byte[] bArr = f0.e0.c.a;
                        i = b2 & 255;
                    }
                    if (i7 != 0) {
                        iT--;
                    }
                    if (i > iT) {
                        throw new IOException(b.d.b.a.a.s("PROTOCOL_ERROR padding ", i, " > remaining length ", iT));
                    }
                    m_b.e(z3, i6, this.n, iT - i);
                    this.n.skip(i);
                    return true;
                case 1:
                    if (i6 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
                    }
                    boolean z4 = (i5 & 1) != 0;
                    int i8 = i5 & 8;
                    if (i8 != 0) {
                        byte b3 = this.n.readByte();
                        byte[] bArr2 = f0.e0.c.a;
                        i3 = b3 & 255;
                    }
                    if ((i5 & 32) != 0) {
                        d(m_b, i6);
                        iT -= 5;
                    }
                    if (i8 != 0) {
                        iT--;
                    }
                    if (i3 > iT) {
                        throw new IOException(b.d.b.a.a.s("PROTOCOL_ERROR padding ", i3, " > remaining length ", iT));
                    }
                    m_b.c(z4, i6, -1, c(iT - i3, i3, i5, i6));
                    return true;
                case 2:
                    if (iT != 5) {
                        throw new IOException(b.d.b.a.a.r("TYPE_PRIORITY length: ", iT, " != 5"));
                    }
                    if (i6 == 0) {
                        throw new IOException("TYPE_PRIORITY streamId == 0");
                    }
                    d(m_b, i6);
                    return true;
                case 3:
                    if (iT != 4) {
                        throw new IOException(b.d.b.a.a.r("TYPE_RST_STREAM length: ", iT, " != 4"));
                    }
                    if (i6 == 0) {
                        throw new IOException("TYPE_RST_STREAM streamId == 0");
                    }
                    int i9 = this.n.readInt();
                    a[] aVarArrValues = a.values();
                    int i10 = 0;
                    while (true) {
                        if (i10 < 14) {
                            aVar = aVarArrValues[i10];
                            if (!(aVar.f() == i9)) {
                                i10++;
                            }
                        } else {
                            aVar = null;
                        }
                    }
                    if (aVar == null) {
                        throw new IOException(b.d.b.a.a.q("TYPE_RST_STREAM unexpected error code: ", i9));
                    }
                    m_b.h(i6, aVar);
                    return true;
                case 4:
                    if (i6 != 0) {
                        throw new IOException("TYPE_SETTINGS streamId != 0");
                    }
                    if ((i5 & 1) != 0) {
                        if (iT != 0) {
                            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                        }
                        m_b.a();
                    } else {
                        if (iT % 6 != 0) {
                            throw new IOException(b.d.b.a.a.q("TYPE_SETTINGS length % 6 != 0: ", iT));
                        }
                        s sVar = new s();
                        IntProgression intProgressionStep = d0.d0.f.step(d0.d0.f.until(0, iT), 6);
                        int first = intProgressionStep.getFirst();
                        int last = intProgressionStep.getLast();
                        int step = intProgressionStep.getStep();
                        if (step < 0 ? first >= last : first <= last) {
                            while (true) {
                                short s2 = this.n.readShort();
                                byte[] bArr3 = f0.e0.c.a;
                                int i11 = s2 & 65535;
                                int i12 = this.n.readInt();
                                if (i11 != 2) {
                                    if (i11 == 3) {
                                        i11 = 4;
                                    } else if (i11 == 4) {
                                        i11 = 7;
                                        if (i12 < 0) {
                                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                        }
                                    } else if (i11 == 5 && (i12 < 16384 || i12 > 16777215)) {
                                        throw new IOException(b.d.b.a.a.q("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", i12));
                                    }
                                } else if (i12 != 0 && i12 != 1) {
                                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                }
                                sVar.c(i11, i12);
                                if (first != last) {
                                    first += step;
                                }
                            }
                        }
                        m_b.b(false, sVar);
                    }
                    return true;
                case 5:
                    if (i6 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
                    }
                    int i13 = i5 & 8;
                    if (i13 != 0) {
                        byte b4 = this.n.readByte();
                        byte[] bArr4 = f0.e0.c.a;
                        i2 = b4 & 255;
                    }
                    int i14 = this.n.readInt() & Integer.MAX_VALUE;
                    int i15 = iT - 4;
                    if (i13 != 0) {
                        i15--;
                    }
                    if (i2 > i15) {
                        throw new IOException(b.d.b.a.a.s("PROTOCOL_ERROR padding ", i2, " > remaining length ", i15));
                    }
                    m_b.i(i6, i14, c(i15 - i2, i2, i5, i6));
                    return true;
                case 6:
                    if (iT != 8) {
                        throw new IOException(b.d.b.a.a.q("TYPE_PING length != 8: ", iT));
                    }
                    if (i6 != 0) {
                        throw new IOException("TYPE_PING streamId != 0");
                    }
                    m_b.f((i5 & 1) != 0, this.n.readInt(), this.n.readInt());
                    return true;
                case 7:
                    if (iT < 8) {
                        throw new IOException(b.d.b.a.a.q("TYPE_GOAWAY length < 8: ", iT));
                    }
                    if (i6 != 0) {
                        throw new IOException("TYPE_GOAWAY streamId != 0");
                    }
                    int i16 = this.n.readInt();
                    int i17 = this.n.readInt();
                    int i18 = iT - 8;
                    a[] aVarArrValues2 = a.values();
                    int i19 = 0;
                    while (true) {
                        if (i19 < 14) {
                            aVar2 = aVarArrValues2[i19];
                            if (!(aVar2.f() == i17)) {
                                i19++;
                            }
                        } else {
                            aVar2 = null;
                        }
                    }
                    if (aVar2 == null) {
                        throw new IOException(b.d.b.a.a.q("TYPE_GOAWAY unexpected error code: ", i17));
                    }
                    ByteString byteStringO = ByteString.j;
                    if (i18 > 0) {
                        byteStringO = this.n.o(i18);
                    }
                    m_b.j(i16, aVar2, byteStringO);
                    return true;
                case 8:
                    if (iT != 4) {
                        throw new IOException(b.d.b.a.a.q("TYPE_WINDOW_UPDATE length !=4: ", iT));
                    }
                    int i20 = this.n.readInt();
                    byte[] bArr5 = f0.e0.c.a;
                    long j2 = ((long) i20) & 2147483647L;
                    if (j2 == 0) {
                        throw new IOException("windowSizeIncrement was 0");
                    }
                    m_b.d(i6, j2);
                    return true;
                default:
                    this.n.skip(iT);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void b(m$b m_b) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(m_b, "handler");
        if (this.o) {
            if (!a(true, m_b)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        g0.g gVar = this.n;
        ByteString byteString = d.a;
        ByteString byteStringO = gVar.o(byteString.j());
        Logger logger = j;
        if (logger.isLoggable(Level.FINE)) {
            StringBuilder sbU = b.d.b.a.a.U("<< CONNECTION ");
            sbU.append(byteStringO.k());
            logger.fine(f0.e0.c.j(sbU.toString(), new Object[0]));
        }
        if (!d0.z.d.m.areEqual(byteString, byteStringO)) {
            StringBuilder sbU2 = b.d.b.a.a.U("Expected a connection header but was ");
            sbU2.append(byteStringO.q());
            throw new IOException(sbU2.toString());
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003d  */
    public final List<b> c(int i, int i2, int i3, int i4) throws IOException {
        boolean z2;
        m$a m_a = this.l;
        m_a.m = i;
        m_a.j = i;
        m_a.n = i2;
        m_a.k = i3;
        m_a.l = i4;
        c$a c_a = this.m;
        while (!c_a.f3635b.w()) {
            byte b2 = c_a.f3635b.readByte();
            byte[] bArr = f0.e0.c.a;
            int i5 = b2 & 255;
            if (i5 == 128) {
                throw new IOException("index == 0");
            }
            if ((i5 & 128) == 128) {
                int iG = c_a.g(i5, Opcodes.LAND) - 1;
                if (iG >= 0) {
                    c cVar = c.c;
                    if (iG <= c.a.length - 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (!z2) {
                    c cVar2 = c.c;
                    int iB = c_a.b(iG - c.a.length);
                    if (iB >= 0) {
                        b[] bVarArr = c_a.c;
                        if (iB < bVarArr.length) {
                            List<b> list = c_a.a;
                            b bVar = bVarArr[iB];
                            if (bVar == null) {
                                d0.z.d.m.throwNpe();
                            }
                            list.add(bVar);
                        }
                    }
                    StringBuilder sbU = b.d.b.a.a.U("Header index too large ");
                    sbU.append(iG + 1);
                    throw new IOException(sbU.toString());
                }
                c cVar3 = c.c;
                c_a.a.add(c.a[iG]);
            } else if (i5 == 64) {
                c cVar4 = c.c;
                ByteString byteStringF = c_a.f();
                cVar4.a(byteStringF);
                c_a.e(-1, new b(byteStringF, c_a.f()));
            } else if ((i5 & 64) == 64) {
                c_a.e(-1, new b(c_a.d(c_a.g(i5, 63) - 1), c_a.f()));
            } else if ((i5 & 32) == 32) {
                int iG2 = c_a.g(i5, 31);
                c_a.h = iG2;
                if (iG2 < 0 || iG2 > c_a.g) {
                    StringBuilder sbU2 = b.d.b.a.a.U("Invalid dynamic table size update ");
                    sbU2.append(c_a.h);
                    throw new IOException(sbU2.toString());
                }
                int i6 = c_a.f;
                if (iG2 < i6) {
                    if (iG2 == 0) {
                        c_a.a();
                    } else {
                        c_a.c(i6 - iG2);
                    }
                }
            } else if (i5 == 16 || i5 == 0) {
                c cVar5 = c.c;
                ByteString byteStringF2 = c_a.f();
                cVar5.a(byteStringF2);
                c_a.a.add(new b(byteStringF2, c_a.f()));
            } else {
                c_a.a.add(new b(c_a.d(c_a.g(i5, 15) - 1), c_a.f()));
            }
        }
        c$a c_a2 = this.m;
        List<b> list2 = u.toList(c_a2.a);
        c_a2.a.clear();
        return list2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.n.close();
    }

    public final void d(m$b m_b, int i) throws IOException {
        int i2 = this.n.readInt();
        boolean z2 = (i2 & ((int) Permission.USE_APPLICATION_COMMANDS)) != 0;
        byte b2 = this.n.readByte();
        byte[] bArr = f0.e0.c.a;
        m_b.g(i, i2 & Integer.MAX_VALUE, (b2 & 255) + 1, z2);
    }
}
