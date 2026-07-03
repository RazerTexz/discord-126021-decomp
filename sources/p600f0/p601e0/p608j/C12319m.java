package p600f0.p601e0.p608j;

import com.discord.api.permission.Permission;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.ranges.IntProgression;
import okio.ByteString;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p608j.C12309c;
import p615g0.C12388e;
import p615g0.C12408y;
import p615g0.InterfaceC12390g;
import p615g0.InterfaceC12407x;

/* JADX INFO: renamed from: f0.e0.j.m */
/* JADX INFO: compiled from: Http2Reader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12319m implements Closeable {

    /* JADX INFO: renamed from: j */
    public static final Logger f25700j;

    /* JADX INFO: renamed from: k */
    public static final C12319m f25701k = null;

    /* JADX INFO: renamed from: l */
    public final a f25702l;

    /* JADX INFO: renamed from: m */
    public final C12309c.a f25703m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC12390g f25704n;

    /* JADX INFO: renamed from: o */
    public final boolean f25705o;

    /* JADX INFO: renamed from: f0.e0.j.m$a */
    /* JADX INFO: compiled from: Http2Reader.kt */
    public static final class a implements InterfaceC12407x {

        /* JADX INFO: renamed from: j */
        public int f25706j;

        /* JADX INFO: renamed from: k */
        public int f25707k;

        /* JADX INFO: renamed from: l */
        public int f25708l;

        /* JADX INFO: renamed from: m */
        public int f25709m;

        /* JADX INFO: renamed from: n */
        public int f25710n;

        /* JADX INFO: renamed from: o */
        public final InterfaceC12390g f25711o;

        public a(InterfaceC12390g interfaceC12390g) {
            C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
            this.f25711o = interfaceC12390g;
        }

        @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // p615g0.InterfaceC12407x
        /* JADX INFO: renamed from: i0 */
        public long mo10176i0(C12388e c12388e, long j) throws IOException {
            int i;
            int i2;
            C12238m.checkParameterIsNotNull(c12388e, "sink");
            do {
                int i3 = this.f25709m;
                if (i3 != 0) {
                    long jMo10176i0 = this.f25711o.mo10176i0(c12388e, Math.min(j, i3));
                    if (jMo10176i0 == -1) {
                        return -1L;
                    }
                    this.f25709m -= (int) jMo10176i0;
                    return jMo10176i0;
                }
                this.f25711o.skip(this.f25710n);
                this.f25710n = 0;
                if ((this.f25707k & 4) != 0) {
                    return -1L;
                }
                i = this.f25708l;
                int iM10139t = C12272c.m10139t(this.f25711o);
                this.f25709m = iM10139t;
                this.f25706j = iM10139t;
                int i4 = this.f25711o.readByte() & 255;
                this.f25707k = this.f25711o.readByte() & 255;
                C12319m c12319m = C12319m.f25701k;
                Logger logger = C12319m.f25700j;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(C12310d.f25614e.m10257b(true, this.f25708l, this.f25706j, i4, this.f25707k));
                }
                i2 = this.f25711o.readInt() & Integer.MAX_VALUE;
                this.f25708l = i2;
                if (i4 != 9) {
                    throw new IOException(i4 + " != TYPE_CONTINUATION");
                }
            } while (i2 == i);
            throw new IOException("TYPE_CONTINUATION streamId changed");
        }

        @Override // p615g0.InterfaceC12407x
        public C12408y timeout() {
            return this.f25711o.timeout();
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.m$b */
    /* JADX INFO: compiled from: Http2Reader.kt */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo10268a();

        /* JADX INFO: renamed from: b */
        void mo10269b(boolean z2, C12325s c12325s);

        /* JADX INFO: renamed from: c */
        void mo10270c(boolean z2, int i, int i2, List<C12308b> list);

        /* JADX INFO: renamed from: d */
        void mo10271d(int i, long j);

        /* JADX INFO: renamed from: e */
        void mo10272e(boolean z2, int i, InterfaceC12390g interfaceC12390g, int i2) throws IOException;

        /* JADX INFO: renamed from: f */
        void mo10273f(boolean z2, int i, int i2);

        /* JADX INFO: renamed from: g */
        void mo10274g(int i, int i2, int i3, boolean z2);

        /* JADX INFO: renamed from: h */
        void mo10275h(int i, EnumC12307a enumC12307a);

        /* JADX INFO: renamed from: i */
        void mo10276i(int i, int i2, List<C12308b> list) throws IOException;

        /* JADX INFO: renamed from: j */
        void mo10277j(int i, EnumC12307a enumC12307a, ByteString byteString);
    }

    static {
        Logger logger = Logger.getLogger(C12310d.class.getName());
        C12238m.checkExpressionValueIsNotNull(logger, "Logger.getLogger(Http2::class.java.name)");
        f25700j = logger;
    }

    public C12319m(InterfaceC12390g interfaceC12390g, boolean z2) {
        C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
        this.f25704n = interfaceC12390g;
        this.f25705o = z2;
        a aVar = new a(interfaceC12390g);
        this.f25702l = aVar;
        this.f25703m = new C12309c.a(aVar, 4096, 0, 4);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m10278a(boolean z2, b bVar) throws IOException {
        EnumC12307a enumC12307a;
        EnumC12307a enumC12307a2;
        C12238m.checkParameterIsNotNull(bVar, "handler");
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        try {
            this.f25704n.mo10463p0(9L);
            int iM10139t = C12272c.m10139t(this.f25704n);
            if (iM10139t > 16384) {
                throw new IOException(C1643a.m871q("FRAME_SIZE_ERROR: ", iM10139t));
            }
            int i4 = this.f25704n.readByte() & 255;
            int i5 = this.f25704n.readByte() & 255;
            int i6 = this.f25704n.readInt() & Integer.MAX_VALUE;
            Logger logger = f25700j;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C12310d.f25614e.m10257b(true, i6, iM10139t, i4, i5));
            }
            if (z2 && i4 != 4) {
                StringBuilder sbM833U = C1643a.m833U("Expected a SETTINGS frame but was ");
                sbM833U.append(C12310d.f25614e.m10256a(i4));
                throw new IOException(sbM833U.toString());
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
                        byte b2 = this.f25704n.readByte();
                        byte[] bArr = C12272c.f25397a;
                        i = b2 & 255;
                    }
                    if (i7 != 0) {
                        iM10139t--;
                    }
                    if (i > iM10139t) {
                        throw new IOException(C1643a.m875s("PROTOCOL_ERROR padding ", i, " > remaining length ", iM10139t));
                    }
                    bVar.mo10272e(z3, i6, this.f25704n, iM10139t - i);
                    this.f25704n.skip(i);
                    return true;
                case 1:
                    if (i6 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
                    }
                    boolean z4 = (i5 & 1) != 0;
                    int i8 = i5 & 8;
                    if (i8 != 0) {
                        byte b3 = this.f25704n.readByte();
                        byte[] bArr2 = C12272c.f25397a;
                        i3 = b3 & 255;
                    }
                    if ((i5 & 32) != 0) {
                        m10281d(bVar, i6);
                        iM10139t -= 5;
                    }
                    if (i8 != 0) {
                        iM10139t--;
                    }
                    if (i3 > iM10139t) {
                        throw new IOException(C1643a.m875s("PROTOCOL_ERROR padding ", i3, " > remaining length ", iM10139t));
                    }
                    bVar.mo10270c(z4, i6, -1, m10280c(iM10139t - i3, i3, i5, i6));
                    return true;
                case 2:
                    if (iM10139t != 5) {
                        throw new IOException(C1643a.m873r("TYPE_PRIORITY length: ", iM10139t, " != 5"));
                    }
                    if (i6 == 0) {
                        throw new IOException("TYPE_PRIORITY streamId == 0");
                    }
                    m10281d(bVar, i6);
                    return true;
                case 3:
                    if (iM10139t != 4) {
                        throw new IOException(C1643a.m873r("TYPE_RST_STREAM length: ", iM10139t, " != 4"));
                    }
                    if (i6 == 0) {
                        throw new IOException("TYPE_RST_STREAM streamId == 0");
                    }
                    int i9 = this.f25704n.readInt();
                    EnumC12307a[] enumC12307aArrValues = EnumC12307a.values();
                    int i10 = 0;
                    while (true) {
                        if (i10 < 14) {
                            enumC12307a = enumC12307aArrValues[i10];
                            if (!(enumC12307a.m10241f() == i9)) {
                                i10++;
                            }
                        } else {
                            enumC12307a = null;
                        }
                    }
                    if (enumC12307a == null) {
                        throw new IOException(C1643a.m871q("TYPE_RST_STREAM unexpected error code: ", i9));
                    }
                    bVar.mo10275h(i6, enumC12307a);
                    return true;
                case 4:
                    if (i6 != 0) {
                        throw new IOException("TYPE_SETTINGS streamId != 0");
                    }
                    if ((i5 & 1) != 0) {
                        if (iM10139t != 0) {
                            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                        }
                        bVar.mo10268a();
                    } else {
                        if (iM10139t % 6 != 0) {
                            throw new IOException(C1643a.m871q("TYPE_SETTINGS length % 6 != 0: ", iM10139t));
                        }
                        C12325s c12325s = new C12325s();
                        IntProgression intProgressionStep = C11226f.step(C11226f.until(0, iM10139t), 6);
                        int first = intProgressionStep.getFirst();
                        int last = intProgressionStep.getLast();
                        int step = intProgressionStep.getStep();
                        if (step < 0 ? first >= last : first <= last) {
                            while (true) {
                                short s2 = this.f25704n.readShort();
                                byte[] bArr3 = C12272c.f25397a;
                                int i11 = s2 & 65535;
                                int i12 = this.f25704n.readInt();
                                if (i11 != 2) {
                                    if (i11 == 3) {
                                        i11 = 4;
                                    } else if (i11 == 4) {
                                        i11 = 7;
                                        if (i12 < 0) {
                                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                        }
                                    } else if (i11 == 5 && (i12 < 16384 || i12 > 16777215)) {
                                        throw new IOException(C1643a.m871q("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", i12));
                                    }
                                } else if (i12 != 0 && i12 != 1) {
                                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                }
                                c12325s.m10314c(i11, i12);
                                if (first != last) {
                                    first += step;
                                }
                            }
                        }
                        bVar.mo10269b(false, c12325s);
                    }
                    return true;
                case 5:
                    if (i6 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
                    }
                    int i13 = i5 & 8;
                    if (i13 != 0) {
                        byte b4 = this.f25704n.readByte();
                        byte[] bArr4 = C12272c.f25397a;
                        i2 = b4 & 255;
                    }
                    int i14 = this.f25704n.readInt() & Integer.MAX_VALUE;
                    int i15 = iM10139t - 4;
                    if (i13 != 0) {
                        i15--;
                    }
                    if (i2 > i15) {
                        throw new IOException(C1643a.m875s("PROTOCOL_ERROR padding ", i2, " > remaining length ", i15));
                    }
                    bVar.mo10276i(i6, i14, m10280c(i15 - i2, i2, i5, i6));
                    return true;
                case 6:
                    if (iM10139t != 8) {
                        throw new IOException(C1643a.m871q("TYPE_PING length != 8: ", iM10139t));
                    }
                    if (i6 != 0) {
                        throw new IOException("TYPE_PING streamId != 0");
                    }
                    bVar.mo10273f((i5 & 1) != 0, this.f25704n.readInt(), this.f25704n.readInt());
                    return true;
                case 7:
                    if (iM10139t < 8) {
                        throw new IOException(C1643a.m871q("TYPE_GOAWAY length < 8: ", iM10139t));
                    }
                    if (i6 != 0) {
                        throw new IOException("TYPE_GOAWAY streamId != 0");
                    }
                    int i16 = this.f25704n.readInt();
                    int i17 = this.f25704n.readInt();
                    int i18 = iM10139t - 8;
                    EnumC12307a[] enumC12307aArrValues2 = EnumC12307a.values();
                    int i19 = 0;
                    while (true) {
                        if (i19 < 14) {
                            enumC12307a2 = enumC12307aArrValues2[i19];
                            if (!(enumC12307a2.m10241f() == i17)) {
                                i19++;
                            }
                        } else {
                            enumC12307a2 = null;
                        }
                    }
                    if (enumC12307a2 == null) {
                        throw new IOException(C1643a.m871q("TYPE_GOAWAY unexpected error code: ", i17));
                    }
                    ByteString byteStringMo10461o = ByteString.f27592j;
                    if (i18 > 0) {
                        byteStringMo10461o = this.f25704n.mo10461o(i18);
                    }
                    bVar.mo10277j(i16, enumC12307a2, byteStringMo10461o);
                    return true;
                case 8:
                    if (iM10139t != 4) {
                        throw new IOException(C1643a.m871q("TYPE_WINDOW_UPDATE length !=4: ", iM10139t));
                    }
                    int i20 = this.f25704n.readInt();
                    byte[] bArr5 = C12272c.f25397a;
                    long j = ((long) i20) & 2147483647L;
                    if (j == 0) {
                        throw new IOException("windowSizeIncrement was 0");
                    }
                    bVar.mo10271d(i6, j);
                    return true;
                default:
                    this.f25704n.skip(iM10139t);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m10279b(b bVar) throws IOException {
        C12238m.checkParameterIsNotNull(bVar, "handler");
        if (this.f25705o) {
            if (!m10278a(true, bVar)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        InterfaceC12390g interfaceC12390g = this.f25704n;
        ByteString byteString = C12310d.f25610a;
        ByteString byteStringMo10461o = interfaceC12390g.mo10461o(byteString.mo10502j());
        Logger logger = f25700j;
        if (logger.isLoggable(Level.FINE)) {
            StringBuilder sbM833U = C1643a.m833U("<< CONNECTION ");
            sbM833U.append(byteStringMo10461o.mo10503k());
            logger.fine(C12272c.m10129j(sbM833U.toString(), new Object[0]));
        }
        if (!C12238m.areEqual(byteString, byteStringMo10461o)) {
            StringBuilder sbM833U2 = C1643a.m833U("Expected a connection header but was ");
            sbM833U2.append(byteStringMo10461o.m11008q());
            throw new IOException(sbM833U2.toString());
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003d  */
    /* JADX INFO: renamed from: c */
    public final List<C12308b> m10280c(int i, int i2, int i3, int i4) throws IOException {
        boolean z2;
        a aVar = this.f25702l;
        aVar.f25709m = i;
        aVar.f25706j = i;
        aVar.f25710n = i2;
        aVar.f25707k = i3;
        aVar.f25708l = i4;
        C12309c.a aVar2 = this.f25703m;
        while (!aVar2.f25593b.mo10472w()) {
            byte b2 = aVar2.f25593b.readByte();
            byte[] bArr = C12272c.f25397a;
            int i5 = b2 & 255;
            if (i5 == 128) {
                throw new IOException("index == 0");
            }
            if ((i5 & 128) == 128) {
                int iM10249g = aVar2.m10249g(i5, Opcodes.LAND) - 1;
                if (iM10249g >= 0) {
                    C12309c c12309c = C12309c.f25591c;
                    if (iM10249g <= C12309c.f25589a.length - 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (!z2) {
                    C12309c c12309c2 = C12309c.f25591c;
                    int iM10244b = aVar2.m10244b(iM10249g - C12309c.f25589a.length);
                    if (iM10244b >= 0) {
                        C12308b[] c12308bArr = aVar2.f25594c;
                        if (iM10244b < c12308bArr.length) {
                            List<C12308b> list = aVar2.f25592a;
                            C12308b c12308b = c12308bArr[iM10244b];
                            if (c12308b == null) {
                                C12238m.throwNpe();
                            }
                            list.add(c12308b);
                        }
                    }
                    StringBuilder sbM833U = C1643a.m833U("Header index too large ");
                    sbM833U.append(iM10249g + 1);
                    throw new IOException(sbM833U.toString());
                }
                C12309c c12309c3 = C12309c.f25591c;
                aVar2.f25592a.add(C12309c.f25589a[iM10249g]);
            } else if (i5 == 64) {
                C12309c c12309c4 = C12309c.f25591c;
                ByteString byteStringM10248f = aVar2.m10248f();
                c12309c4.m10242a(byteStringM10248f);
                aVar2.m10247e(-1, new C12308b(byteStringM10248f, aVar2.m10248f()));
            } else if ((i5 & 64) == 64) {
                aVar2.m10247e(-1, new C12308b(aVar2.m10246d(aVar2.m10249g(i5, 63) - 1), aVar2.m10248f()));
            } else if ((i5 & 32) == 32) {
                int iM10249g2 = aVar2.m10249g(i5, 31);
                aVar2.f25599h = iM10249g2;
                if (iM10249g2 < 0 || iM10249g2 > aVar2.f25598g) {
                    StringBuilder sbM833U2 = C1643a.m833U("Invalid dynamic table size update ");
                    sbM833U2.append(aVar2.f25599h);
                    throw new IOException(sbM833U2.toString());
                }
                int i6 = aVar2.f25597f;
                if (iM10249g2 < i6) {
                    if (iM10249g2 == 0) {
                        aVar2.m10243a();
                    } else {
                        aVar2.m10245c(i6 - iM10249g2);
                    }
                }
            } else if (i5 == 16 || i5 == 0) {
                C12309c c12309c5 = C12309c.f25591c;
                ByteString byteStringM10248f2 = aVar2.m10248f();
                c12309c5.m10242a(byteStringM10248f2);
                aVar2.f25592a.add(new C12308b(byteStringM10248f2, aVar2.m10248f()));
            } else {
                aVar2.f25592a.add(new C12308b(aVar2.m10246d(aVar2.m10249g(i5, 15) - 1), aVar2.m10248f()));
            }
        }
        C12309c.a aVar3 = this.f25703m;
        List<C12308b> list2 = C12163u.toList(aVar3.f25592a);
        aVar3.f25592a.clear();
        return list2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25704n.close();
    }

    /* JADX INFO: renamed from: d */
    public final void m10281d(b bVar, int i) throws IOException {
        int i2 = this.f25704n.readInt();
        boolean z2 = (i2 & ((int) Permission.USE_APPLICATION_COMMANDS)) != 0;
        byte b2 = this.f25704n.readByte();
        byte[] bArr = C12272c.f25397a;
        bVar.mo10274g(i, i2 & Integer.MAX_VALUE, (b2 & 255) + 1, z2);
    }
}
