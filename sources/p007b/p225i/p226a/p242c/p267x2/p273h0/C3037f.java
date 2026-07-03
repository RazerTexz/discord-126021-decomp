package p007b.p225i.p226a.p242c.p267x2.p273h0;

import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p263t2.C2912a0;
import p007b.p225i.p226a.p242c.p267x2.C3023g;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3115p;
import p007b.p225i.p226a.p242c.p267x2.C3116q;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p273h0.InterfaceC3038g;
import p007b.p225i.p226a.p242c.p279z2.p283k.C3167b;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.f */
/* JADX INFO: compiled from: Mp3Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3037f implements InterfaceC3031h {

    /* JADX INFO: renamed from: a */
    public static final C3167b.a f8315a;

    /* JADX INFO: renamed from: b */
    public final int f8316b;

    /* JADX INFO: renamed from: c */
    public final long f8317c;

    /* JADX INFO: renamed from: d */
    public final C2757x f8318d;

    /* JADX INFO: renamed from: e */
    public final C2912a0.a f8319e;

    /* JADX INFO: renamed from: f */
    public final C3115p f8320f;

    /* JADX INFO: renamed from: g */
    public final C3116q f8321g;

    /* JADX INFO: renamed from: h */
    public final InterfaceC3122w f8322h;

    /* JADX INFO: renamed from: i */
    public InterfaceC3058j f8323i;

    /* JADX INFO: renamed from: j */
    public InterfaceC3122w f8324j;

    /* JADX INFO: renamed from: k */
    public InterfaceC3122w f8325k;

    /* JADX INFO: renamed from: l */
    public int f8326l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public Metadata f8327m;

    /* JADX INFO: renamed from: n */
    public long f8328n;

    /* JADX INFO: renamed from: o */
    public long f8329o;

    /* JADX INFO: renamed from: p */
    public long f8330p;

    /* JADX INFO: renamed from: q */
    public int f8331q;

    /* JADX INFO: renamed from: r */
    public InterfaceC3038g f8332r;

    /* JADX INFO: renamed from: s */
    public boolean f8333s;

    /* JADX INFO: renamed from: t */
    public boolean f8334t;

    /* JADX INFO: renamed from: u */
    public long f8335u;

    static {
        C3032a c3032a = new InterfaceC3106l() { // from class: b.i.a.c.x2.h0.a
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3037f(0)};
            }

            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: b */
            public /* synthetic */ InterfaceC3031h[] mo3631b(Uri uri, Map map) {
                return C3069k.m3748a(this, uri, map);
            }
        };
        f8315a = new C3167b.a() { // from class: b.i.a.c.x2.h0.b
            @Override // p007b.p225i.p226a.p242c.p279z2.p283k.C3167b.a
            /* JADX INFO: renamed from: a */
            public final boolean mo3688a(int i, int i2, int i3, int i4, int i5) {
                C3167b.a aVar = C3037f.f8315a;
                return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
            }
        };
    }

    public C3037f() {
        this(0);
    }

    /* JADX INFO: renamed from: d */
    public static long m3693d(@Nullable Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int length = metadata.f19936j.length;
        for (int i = 0; i < length; i++) {
            Metadata.Entry entry = metadata.f19936j[i];
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.f19989j.equals("TLEN")) {
                    return C2738e0.m2981B(Long.parseLong(textInformationFrame.f20001l));
                }
            }
        }
        return -9223372036854775807L;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m3694h(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    /* JADX INFO: renamed from: a */
    public final long m3695a(long j) {
        return ((j * 1000000) / ((long) this.f8319e.f7680d)) + this.f8328n;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        return m3698j(interfaceC3041i, true);
    }

    /* JADX INFO: renamed from: c */
    public final InterfaceC3038g m3696c(InterfaceC3041i interfaceC3041i, boolean z2) throws IOException {
        interfaceC3041i.mo3652o(this.f8318d.f6793a, 0, 4);
        this.f8318d.m3079E(0);
        this.f8319e.m3469a(this.f8318d.m3086f());
        return new C3034c(interfaceC3041i.mo3642b(), interfaceC3041i.getPosition(), this.f8319e, z2);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0230  */
    /* JADX WARN: Code duplicated, block: B:103:0x023b  */
    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    /* JADX WARN: Code duplicated, block: B:110:0x0253  */
    /* JADX WARN: Code duplicated, block: B:112:0x0259  */
    /* JADX WARN: Code duplicated, block: B:116:0x027c A[LOOP:2: B:115:0x027a->B:116:0x027c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:118:0x029f A[LOOP:1: B:111:0x0257->B:118:0x029f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:119:0x02a4 A[EDGE_INSN: B:119:0x02a4->B:120:0x02a5 BREAK  A[LOOP:1: B:111:0x0257->B:118:0x029f]] */
    /* JADX WARN: Code duplicated, block: B:122:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:123:0x02af  */
    /* JADX WARN: Code duplicated, block: B:125:0x02b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:128:0x02bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:12:0x003b  */
    /* JADX WARN: Code duplicated, block: B:130:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:132:0x02dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x02de  */
    /* JADX WARN: Code duplicated, block: B:134:0x02e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:142:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:144:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:145:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:149:0x032f  */
    /* JADX WARN: Code duplicated, block: B:14:0x003f  */
    /* JADX WARN: Code duplicated, block: B:150:0x0331  */
    /* JADX WARN: Code duplicated, block: B:152:0x0343  */
    /* JADX WARN: Code duplicated, block: B:154:0x034d  */
    /* JADX WARN: Code duplicated, block: B:156:0x0357  */
    /* JADX WARN: Code duplicated, block: B:159:0x0360  */
    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    /* JADX WARN: Code duplicated, block: B:162:0x036b  */
    /* JADX WARN: Code duplicated, block: B:184:0x040a  */
    /* JADX WARN: Code duplicated, block: B:187:0x0418  */
    /* JADX WARN: Code duplicated, block: B:18:0x0047  */
    /* JADX WARN: Code duplicated, block: B:190:0x0420  */
    /* JADX WARN: Code duplicated, block: B:208:0x0261 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x02a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0058  */
    /* JADX WARN: Code duplicated, block: B:25:0x0064  */
    /* JADX WARN: Code duplicated, block: B:27:0x006a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0073  */
    /* JADX WARN: Code duplicated, block: B:30:0x0077  */
    /* JADX WARN: Code duplicated, block: B:69:0x0160  */
    /* JADX WARN: Code duplicated, block: B:71:0x0179  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016 A[PHI: r1
      0x0016: PHI (r1v3 b.i.a.c.x2.h0.f) = (r1v2 b.i.a.c.x2.h0.f), (r1v6 b.i.a.c.x2.h0.f), (r1v6 b.i.a.c.x2.h0.f) binds: [B:6:0x0014, B:185:0x0414, B:160:0x0367] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:87:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:94:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:96:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:98:0x0229 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:99:0x022b  */
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        C3037f c3037f;
        int i;
        InterfaceC3041i interfaceC3041i2;
        long position;
        long j;
        int iMo2523b;
        int i2;
        int iM3086f;
        C2757x c2757x;
        C2912a0.a aVar;
        int i3;
        int iM3086f2;
        int iM3086f3;
        InterfaceC3038g interfaceC3038gM3696c;
        C3115p c3115p;
        boolean z2;
        int i4;
        C3115p c3115p2;
        int i5;
        int i6;
        int iM3103w;
        C3040i c3040i;
        Metadata metadata;
        long position2;
        C3036e c3036e;
        boolean z3;
        long jM3693d;
        long jMo3621i;
        long jMo3689a;
        Metadata metadata2;
        int length;
        int i7;
        Metadata.Entry entry;
        MlltFrame mlltFrame;
        int length2;
        long[] jArr;
        long[] jArr2;
        long j2;
        int i8;
        int iM3100t;
        C1460d.m438H(this.f8324j);
        int i9 = C2738e0.f6708a;
        if (this.f8326l == 0) {
            try {
                m3698j(interfaceC3041i, false);
                if (this.f8332r == null) {
                    c2757x = new C2757x(this.f8319e.f7679c);
                    interfaceC3041i.mo3652o(c2757x.f6793a, 0, this.f8319e.f7679c);
                    aVar = this.f8319e;
                    i3 = 21;
                    if ((aVar.f7677a & 1) != 0) {
                        if (aVar.f7681e != 1) {
                            i3 = 36;
                        }
                    } else if (aVar.f7681e == 1) {
                        i3 = 13;
                    }
                    if (c2757x.f6795c >= i3 + 4) {
                        c2757x.m3079E(i3);
                        iM3086f2 = c2757x.m3086f();
                        if (iM3086f2 != 1483304551 && iM3086f2 != 1231971951) {
                            if (c2757x.f6795c >= 40) {
                                c2757x.m3079E(36);
                                if (c2757x.m3086f() == 1447187017) {
                                    iM3086f2 = 1447187017;
                                } else {
                                    iM3086f2 = 0;
                                }
                            } else {
                                iM3086f2 = 0;
                            }
                        }
                    } else if (c2757x.f6795c >= 40) {
                        c2757x.m3079E(36);
                        if (c2757x.m3086f() == 1447187017) {
                            iM3086f2 = 1447187017;
                        } else {
                            iM3086f2 = 0;
                        }
                    } else {
                        iM3086f2 = 0;
                    }
                    String str = ", ";
                    if (iM3086f2 != 1483304551 || iM3086f2 == 1231971951) {
                        c3037f = this;
                        long jMo3642b = interfaceC3041i.mo3642b();
                        long position3 = interfaceC3041i.getPosition();
                        C2912a0.a aVar2 = c3037f.f8319e;
                        int i10 = aVar2.f7683g;
                        int i11 = aVar2.f7680d;
                        iM3086f3 = c2757x.m3086f();
                        if ((iM3086f3 & 1) == 1 || (iM3103w = c2757x.m3103w()) == 0) {
                            interfaceC3038gM3696c = null;
                        } else {
                            long jM2985F = C2738e0.m2985F(iM3103w, ((long) i10) * 1000000, i11);
                            if ((iM3086f3 & 6) != 6) {
                                c3040i = new C3040i(position3, aVar2.f7679c, jM2985F, -1L, null);
                            } else {
                                long jM3101u = c2757x.m3101u();
                                long[] jArr3 = new long[100];
                                for (int i12 = 0; i12 < 100; i12++) {
                                    jArr3[i12] = c2757x.m3100t();
                                }
                                if (jMo3642b != -1) {
                                    long j3 = position3 + jM3101u;
                                    if (jMo3642b != j3) {
                                        StringBuilder sbM830R = C1643a.m830R(67, "XING data size mismatch: ", jMo3642b, ", ");
                                        sbM830R.append(j3);
                                        Log.w("XingSeeker", sbM830R.toString());
                                    }
                                }
                                c3040i = new C3040i(position3, aVar2.f7679c, jM2985F, jM3101u, jArr3);
                            }
                            interfaceC3038gM3696c = c3040i;
                        }
                        if (interfaceC3038gM3696c != null) {
                            c3115p = c3037f.f8320f;
                            if (c3115p.f8985b != -1 || c3115p.f8986c == -1) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                interfaceC3041i2 = interfaceC3041i;
                            } else {
                                interfaceC3041i.mo3649k();
                                interfaceC3041i2 = interfaceC3041i;
                                interfaceC3041i2.mo3646g(i4 + Opcodes.F2D);
                                interfaceC3041i2.mo3652o(c3037f.f8318d.f6793a, 0, 3);
                                c3037f.f8318d.m3079E(0);
                                c3115p2 = c3037f.f8320f;
                                int iM3102v = c3037f.f8318d.m3102v();
                                Objects.requireNonNull(c3115p2);
                                i5 = iM3102v >> 12;
                                i6 = iM3102v & 4095;
                                if (i5 <= 0 || i6 > 0) {
                                    i4 = i3;
                                    c3115p2.f8985b = i5;
                                    c3115p2.f8986c = i6;
                                }
                            }
                        } else {
                            interfaceC3041i2 = interfaceC3041i;
                        }
                        interfaceC3041i2.mo3650l(c3037f.f8319e.f7679c);
                        if (interfaceC3038gM3696c != null && !interfaceC3038gM3696c.mo3619c() && iM3086f2 == 1231971951) {
                            interfaceC3038gM3696c = c3037f.m3696c(interfaceC3041i2, false);
                        }
                    } else if (iM3086f2 == 1447187017) {
                        long jMo3642b2 = interfaceC3041i.mo3642b();
                        long position4 = interfaceC3041i.getPosition();
                        C2912a0.a aVar3 = this.f8319e;
                        c2757x.m3080F(10);
                        int iM3086f4 = c2757x.m3086f();
                        if (iM3086f4 <= 0) {
                            interfaceC3038gM3696c = null;
                            break;
                        }
                        int i13 = aVar3.f7680d;
                        long jM2985F2 = C2738e0.m2985F(iM3086f4, ((long) (i13 >= 32000 ? 1152 : 576)) * 1000000, i13);
                        int iM3105y = c2757x.m3105y();
                        int iM3105y2 = c2757x.m3105y();
                        int iM3105y3 = c2757x.m3105y();
                        c2757x.m3080F(2);
                        long j4 = ((long) aVar3.f7679c) + position4;
                        long[] jArr4 = new long[iM3105y];
                        long[] jArr5 = new long[iM3105y];
                        int i14 = 0;
                        long j5 = position4;
                        while (true) {
                            if (i14 >= iM3105y) {
                                String str2 = str;
                                long j6 = jMo3642b2;
                                if (j6 != -1 && j6 != j5) {
                                    StringBuilder sbM830R2 = C1643a.m830R(67, "VBRI data size mismatch: ", j6, str2);
                                    sbM830R2.append(j5);
                                    Log.w("VbriSeeker", sbM830R2.toString());
                                }
                                interfaceC3038gM3696c = new C3039h(jArr4, jArr5, jM2985F2, j5);
                                break;
                            }
                            String str3 = str;
                            long j7 = jMo3642b2;
                            jArr4[i14] = (((long) i14) * jM2985F2) / ((long) iM3105y);
                            jArr5[i14] = Math.max(j5, j4);
                            if (iM3105y3 == 1) {
                                iM3100t = c2757x.m3100t();
                            } else if (iM3105y3 == 2) {
                                iM3100t = c2757x.m3105y();
                            } else if (iM3105y3 == 3) {
                                iM3100t = c2757x.m3102v();
                            } else {
                                if (iM3105y3 != 4) {
                                    interfaceC3038gM3696c = null;
                                    break;
                                }
                                iM3100t = c2757x.m3103w();
                            }
                            j5 += (long) (iM3100t * iM3105y2);
                            i14++;
                            str = str3;
                            jMo3642b2 = j7;
                        }
                        c3037f = this;
                        interfaceC3041i.mo3650l(c3037f.f8319e.f7679c);
                        interfaceC3041i2 = interfaceC3041i;
                    } else {
                        c3037f = this;
                        interfaceC3041i.mo3649k();
                        interfaceC3041i2 = interfaceC3041i;
                        interfaceC3038gM3696c = null;
                    }
                    metadata = c3037f.f8327m;
                    position2 = interfaceC3041i.getPosition();
                    if (metadata != null) {
                        c3036e = null;
                        break;
                    }
                    length = metadata.f19936j.length;
                    i7 = 0;
                    while (true) {
                        if (i7 < length) {
                            c3036e = null;
                            break;
                        }
                        entry = metadata.f19936j[i7];
                        if (entry instanceof MlltFrame) {
                            mlltFrame = (MlltFrame) entry;
                            long jM3693d2 = m3693d(metadata);
                            length2 = mlltFrame.f19996n.length;
                            int i15 = length2 + 1;
                            jArr = new long[i15];
                            jArr2 = new long[i15];
                            jArr[0] = position2;
                            jArr2[0] = 0;
                            j2 = 0;
                            for (i8 = 1; i8 <= length2; i8++) {
                                int i16 = i8 - 1;
                                position2 += (long) (mlltFrame.f19994l + mlltFrame.f19996n[i16]);
                                j2 += (long) (mlltFrame.f19995m + mlltFrame.f19997o[i16]);
                                jArr[i8] = position2;
                                jArr2[i8] = j2;
                            }
                            c3036e = new C3036e(jArr, jArr2, jM3693d2);
                            break;
                        }
                        i7++;
                    }
                    if (c3037f.f8333s) {
                        interfaceC3038gM3696c = new InterfaceC3038g.a();
                    } else {
                        if ((c3037f.f8316b & 4) != 0) {
                            if (c3036e != null) {
                                jM3693d = c3036e.f8314c;
                            } else {
                                if (interfaceC3038gM3696c != null) {
                                    jMo3621i = interfaceC3038gM3696c.mo3621i();
                                    jMo3689a = interfaceC3038gM3696c.mo3689a();
                                } else {
                                    jM3693d = m3693d(c3037f.f8327m);
                                }
                                interfaceC3038gM3696c = new C3035d(jMo3621i, interfaceC3041i.getPosition(), jMo3689a);
                            }
                            jMo3621i = jM3693d;
                            jMo3689a = -1;
                            interfaceC3038gM3696c = new C3035d(jMo3621i, interfaceC3041i.getPosition(), jMo3689a);
                        } else if (c3036e != null) {
                            interfaceC3038gM3696c = c3036e;
                        } else if (interfaceC3038gM3696c == null) {
                            interfaceC3038gM3696c = null;
                        }
                        if (interfaceC3038gM3696c != null || (!interfaceC3038gM3696c.mo3619c() && (c3037f.f8316b & 1) != 0)) {
                            if ((c3037f.f8316b & 2) != 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            interfaceC3038gM3696c = c3037f.m3696c(interfaceC3041i2, z3);
                        }
                    }
                    c3037f.f8332r = interfaceC3038gM3696c;
                    c3037f.f8323i.mo2477a(interfaceC3038gM3696c);
                    InterfaceC3122w interfaceC3122w = c3037f.f8325k;
                    C2811j1.b bVar = new C2811j1.b();
                    C2912a0.a aVar4 = c3037f.f8319e;
                    bVar.f7173k = aVar4.f7678b;
                    bVar.f7174l = 4096;
                    bVar.f7186x = aVar4.f7681e;
                    bVar.f7187y = aVar4.f7680d;
                    C3115p c3115p3 = c3037f.f8320f;
                    bVar.f7159A = c3115p3.f8985b;
                    bVar.f7160B = c3115p3.f8986c;
                    if ((c3037f.f8316b & 8) != 0) {
                        metadata2 = null;
                    } else {
                        metadata2 = c3037f.f8327m;
                    }
                    bVar.f7171i = metadata2;
                    interfaceC3122w.mo2526e(bVar.m3277a());
                    c3037f.f8330p = interfaceC3041i.getPosition();
                } else {
                    interfaceC3041i2 = interfaceC3041i;
                    c3037f = this;
                    if (c3037f.f8330p != 0) {
                        position = interfaceC3041i.getPosition();
                        j = c3037f.f8330p;
                        if (position < j) {
                            interfaceC3041i2.mo3650l((int) (j - position));
                        }
                    }
                }
                if (c3037f.f8331q == 0) {
                    interfaceC3041i.mo3649k();
                    if (m3697i(interfaceC3041i)) {
                        i = -1;
                    } else {
                        c3037f.f8318d.m3079E(0);
                        iM3086f = c3037f.f8318d.m3086f();
                        if (m3694h(iM3086f, c3037f.f8326l) || C2912a0.m3465a(iM3086f) == -1) {
                            interfaceC3041i2.mo3650l(1);
                            c3037f.f8326l = 0;
                        } else {
                            c3037f.f8319e.m3469a(iM3086f);
                            if (c3037f.f8328n == -9223372036854775807L) {
                                c3037f.f8328n = c3037f.f8332r.mo3690d(interfaceC3041i.getPosition());
                                if (c3037f.f8317c != -9223372036854775807L) {
                                    c3037f.f8328n = (c3037f.f8317c - c3037f.f8332r.mo3690d(0L)) + c3037f.f8328n;
                                }
                            }
                            C2912a0.a aVar5 = c3037f.f8319e;
                            c3037f.f8331q = aVar5.f7679c;
                            InterfaceC3038g interfaceC3038g = c3037f.f8332r;
                            if (interfaceC3038g instanceof C3035d) {
                                C3035d c3035d = (C3035d) interfaceC3038g;
                                long jM3695a = c3037f.m3695a(c3037f.f8329o + ((long) aVar5.f7683g));
                                long position5 = interfaceC3041i.getPosition() + ((long) c3037f.f8319e.f7679c);
                                if (!c3035d.m3691b(jM3695a)) {
                                    c3035d.f8309b.m3041a(jM3695a);
                                    c3035d.f8310c.m3041a(position5);
                                }
                                if (c3037f.f8334t && c3035d.m3691b(c3037f.f8335u)) {
                                    c3037f.f8334t = false;
                                    c3037f.f8325k = c3037f.f8324j;
                                }
                            }
                            iMo2523b = c3037f.f8325k.mo2523b(interfaceC3041i2, c3037f.f8331q, true);
                            if (iMo2523b == -1) {
                                i = -1;
                            } else {
                                i2 = c3037f.f8331q - iMo2523b;
                                c3037f.f8331q = i2;
                                if (i2 <= 0) {
                                    c3037f.f8325k.mo2525d(c3037f.m3695a(c3037f.f8329o), 1, c3037f.f8319e.f7679c, 0, null);
                                    c3037f.f8329o += (long) c3037f.f8319e.f7683g;
                                    c3037f.f8331q = 0;
                                }
                            }
                        }
                        i = 0;
                    }
                } else {
                    iMo2523b = c3037f.f8325k.mo2523b(interfaceC3041i2, c3037f.f8331q, true);
                    if (iMo2523b == -1) {
                        i = -1;
                    } else {
                        i2 = c3037f.f8331q - iMo2523b;
                        c3037f.f8331q = i2;
                        if (i2 <= 0) {
                            c3037f.f8325k.mo2525d(c3037f.m3695a(c3037f.f8329o), 1, c3037f.f8319e.f7679c, 0, null);
                            c3037f.f8329o += (long) c3037f.f8319e.f7683g;
                            c3037f.f8331q = 0;
                        }
                        i = 0;
                    }
                }
            } catch (EOFException unused) {
                c3037f = this;
            }
        } else {
            if (this.f8332r == null) {
                c2757x = new C2757x(this.f8319e.f7679c);
                interfaceC3041i.mo3652o(c2757x.f6793a, 0, this.f8319e.f7679c);
                aVar = this.f8319e;
                i3 = 21;
                if ((aVar.f7677a & 1) != 0) {
                    if (aVar.f7681e != 1) {
                        i3 = 36;
                    }
                } else if (aVar.f7681e == 1) {
                    i3 = 13;
                }
                if (c2757x.f6795c >= i3 + 4) {
                    c2757x.m3079E(i3);
                    iM3086f2 = c2757x.m3086f();
                    if (iM3086f2 != 1483304551) {
                        if (c2757x.f6795c >= 40) {
                            c2757x.m3079E(36);
                            if (c2757x.m3086f() == 1447187017) {
                                iM3086f2 = 1447187017;
                            } else {
                                iM3086f2 = 0;
                            }
                        } else {
                            iM3086f2 = 0;
                        }
                    }
                } else if (c2757x.f6795c >= 40) {
                    c2757x.m3079E(36);
                    if (c2757x.m3086f() == 1447187017) {
                        iM3086f2 = 1447187017;
                    } else {
                        iM3086f2 = 0;
                    }
                } else {
                    iM3086f2 = 0;
                }
                String str4 = ", ";
                if (iM3086f2 != 1483304551) {
                    c3037f = this;
                    long jMo3642b3 = interfaceC3041i.mo3642b();
                    long position6 = interfaceC3041i.getPosition();
                    C2912a0.a aVar6 = c3037f.f8319e;
                    int i17 = aVar6.f7683g;
                    int i18 = aVar6.f7680d;
                    iM3086f3 = c2757x.m3086f();
                    if ((iM3086f3 & 1) == 1) {
                        interfaceC3038gM3696c = null;
                    } else {
                        interfaceC3038gM3696c = null;
                    }
                    if (interfaceC3038gM3696c != null) {
                        c3115p = c3037f.f8320f;
                        if (c3115p.f8985b != -1) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            interfaceC3041i.mo3649k();
                            interfaceC3041i2 = interfaceC3041i;
                            interfaceC3041i2.mo3646g(i4 + Opcodes.F2D);
                            interfaceC3041i2.mo3652o(c3037f.f8318d.f6793a, 0, 3);
                            c3037f.f8318d.m3079E(0);
                            c3115p2 = c3037f.f8320f;
                            int iM3102v2 = c3037f.f8318d.m3102v();
                            Objects.requireNonNull(c3115p2);
                            i5 = iM3102v2 >> 12;
                            i6 = iM3102v2 & 4095;
                            if (i5 <= 0) {
                                i4 = i3;
                                c3115p2.f8985b = i5;
                                c3115p2.f8986c = i6;
                            } else {
                                i4 = i3;
                                c3115p2.f8985b = i5;
                                c3115p2.f8986c = i6;
                            }
                        } else {
                            interfaceC3041i2 = interfaceC3041i;
                        }
                    } else {
                        interfaceC3041i2 = interfaceC3041i;
                    }
                    interfaceC3041i2.mo3650l(c3037f.f8319e.f7679c);
                    if (interfaceC3038gM3696c != null) {
                        interfaceC3038gM3696c = c3037f.m3696c(interfaceC3041i2, false);
                    }
                } else {
                    c3037f = this;
                    long jMo3642b4 = interfaceC3041i.mo3642b();
                    long position7 = interfaceC3041i.getPosition();
                    C2912a0.a aVar7 = c3037f.f8319e;
                    int i19 = aVar7.f7683g;
                    int i110 = aVar7.f7680d;
                    iM3086f3 = c2757x.m3086f();
                    if ((iM3086f3 & 1) == 1) {
                        interfaceC3038gM3696c = null;
                    } else {
                        interfaceC3038gM3696c = null;
                    }
                    if (interfaceC3038gM3696c != null) {
                        c3115p = c3037f.f8320f;
                        if (c3115p.f8985b != -1) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            interfaceC3041i.mo3649k();
                            interfaceC3041i2 = interfaceC3041i;
                            interfaceC3041i2.mo3646g(i4 + Opcodes.F2D);
                            interfaceC3041i2.mo3652o(c3037f.f8318d.f6793a, 0, 3);
                            c3037f.f8318d.m3079E(0);
                            c3115p2 = c3037f.f8320f;
                            int iM3102v3 = c3037f.f8318d.m3102v();
                            Objects.requireNonNull(c3115p2);
                            i5 = iM3102v3 >> 12;
                            i6 = iM3102v3 & 4095;
                            if (i5 <= 0) {
                                i4 = i3;
                                c3115p2.f8985b = i5;
                                c3115p2.f8986c = i6;
                            } else {
                                i4 = i3;
                                c3115p2.f8985b = i5;
                                c3115p2.f8986c = i6;
                            }
                        } else {
                            interfaceC3041i2 = interfaceC3041i;
                        }
                    } else {
                        interfaceC3041i2 = interfaceC3041i;
                    }
                    interfaceC3041i2.mo3650l(c3037f.f8319e.f7679c);
                    if (interfaceC3038gM3696c != null) {
                        interfaceC3038gM3696c = c3037f.m3696c(interfaceC3041i2, false);
                    }
                }
                metadata = c3037f.f8327m;
                position2 = interfaceC3041i.getPosition();
                if (metadata != null) {
                    c3036e = null;
                    break;
                }
                length = metadata.f19936j.length;
                i7 = 0;
                while (true) {
                    if (i7 < length) {
                        c3036e = null;
                        break;
                    }
                    entry = metadata.f19936j[i7];
                    if (entry instanceof MlltFrame) {
                        mlltFrame = (MlltFrame) entry;
                        long jM3693d3 = m3693d(metadata);
                        length2 = mlltFrame.f19996n.length;
                        int i111 = length2 + 1;
                        jArr = new long[i111];
                        jArr2 = new long[i111];
                        jArr[0] = position2;
                        jArr2[0] = 0;
                        j2 = 0;
                        while (i8 <= length2) {
                            int i112 = i8 - 1;
                            position2 += (long) (mlltFrame.f19994l + mlltFrame.f19996n[i112]);
                            j2 += (long) (mlltFrame.f19995m + mlltFrame.f19997o[i112]);
                            jArr[i8] = position2;
                            jArr2[i8] = j2;
                        }
                        c3036e = new C3036e(jArr, jArr2, jM3693d3);
                        break;
                    }
                    i7++;
                }
                if (c3037f.f8333s) {
                    interfaceC3038gM3696c = new InterfaceC3038g.a();
                } else {
                    if ((c3037f.f8316b & 4) != 0) {
                        if (c3036e != null) {
                            jM3693d = c3036e.f8314c;
                        } else {
                            if (interfaceC3038gM3696c != null) {
                                jMo3621i = interfaceC3038gM3696c.mo3621i();
                                jMo3689a = interfaceC3038gM3696c.mo3689a();
                            } else {
                                jM3693d = m3693d(c3037f.f8327m);
                            }
                            interfaceC3038gM3696c = new C3035d(jMo3621i, interfaceC3041i.getPosition(), jMo3689a);
                        }
                        jMo3621i = jM3693d;
                        jMo3689a = -1;
                        interfaceC3038gM3696c = new C3035d(jMo3621i, interfaceC3041i.getPosition(), jMo3689a);
                    } else if (c3036e != null) {
                        interfaceC3038gM3696c = c3036e;
                    } else if (interfaceC3038gM3696c == null) {
                        interfaceC3038gM3696c = null;
                    }
                    if (interfaceC3038gM3696c != null) {
                        if ((c3037f.f8316b & 2) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        interfaceC3038gM3696c = c3037f.m3696c(interfaceC3041i2, z3);
                    } else {
                        if ((c3037f.f8316b & 2) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        interfaceC3038gM3696c = c3037f.m3696c(interfaceC3041i2, z3);
                    }
                }
                c3037f.f8332r = interfaceC3038gM3696c;
                c3037f.f8323i.mo2477a(interfaceC3038gM3696c);
                InterfaceC3122w interfaceC3122w2 = c3037f.f8325k;
                C2811j1.b bVar2 = new C2811j1.b();
                C2912a0.a aVar8 = c3037f.f8319e;
                bVar2.f7173k = aVar8.f7678b;
                bVar2.f7174l = 4096;
                bVar2.f7186x = aVar8.f7681e;
                bVar2.f7187y = aVar8.f7680d;
                C3115p c3115p4 = c3037f.f8320f;
                bVar2.f7159A = c3115p4.f8985b;
                bVar2.f7160B = c3115p4.f8986c;
                if ((c3037f.f8316b & 8) != 0) {
                    metadata2 = null;
                } else {
                    metadata2 = c3037f.f8327m;
                }
                bVar2.f7171i = metadata2;
                interfaceC3122w2.mo2526e(bVar2.m3277a());
                c3037f.f8330p = interfaceC3041i.getPosition();
            } else {
                interfaceC3041i2 = interfaceC3041i;
                c3037f = this;
                if (c3037f.f8330p != 0) {
                    position = interfaceC3041i.getPosition();
                    j = c3037f.f8330p;
                    if (position < j) {
                        interfaceC3041i2.mo3650l((int) (j - position));
                    }
                }
            }
            if (c3037f.f8331q == 0) {
                interfaceC3041i.mo3649k();
                if (m3697i(interfaceC3041i)) {
                    i = -1;
                } else {
                    c3037f.f8318d.m3079E(0);
                    iM3086f = c3037f.f8318d.m3086f();
                    if (m3694h(iM3086f, c3037f.f8326l)) {
                    }
                    interfaceC3041i2.mo3650l(1);
                    c3037f.f8326l = 0;
                    i = 0;
                }
            } else {
                iMo2523b = c3037f.f8325k.mo2523b(interfaceC3041i2, c3037f.f8331q, true);
                if (iMo2523b == -1) {
                    i = -1;
                } else {
                    i2 = c3037f.f8331q - iMo2523b;
                    c3037f.f8331q = i2;
                    if (i2 <= 0) {
                        c3037f.f8325k.mo2525d(c3037f.m3695a(c3037f.f8329o), 1, c3037f.f8319e.f7679c, 0, null);
                        c3037f.f8329o += (long) c3037f.f8319e.f7683g;
                        c3037f.f8331q = 0;
                    }
                    i = 0;
                }
            }
        }
        if (i == -1 && (c3037f.f8332r instanceof C3035d)) {
            long jM3695a2 = c3037f.m3695a(c3037f.f8329o);
            if (c3037f.f8332r.mo3621i() != jM3695a2) {
                InterfaceC3038g interfaceC3038g2 = c3037f.f8332r;
                ((C3035d) interfaceC3038g2).f8311d = jM3695a2;
                c3037f.f8323i.mo2477a(interfaceC3038g2);
            }
        }
        return i;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8323i = interfaceC3058j;
        InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(0, 1);
        this.f8324j = interfaceC3122wMo2492p;
        this.f8325k = interfaceC3122wMo2492p;
        this.f8323i.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8326l = 0;
        this.f8328n = -9223372036854775807L;
        this.f8329o = 0L;
        this.f8331q = 0;
        this.f8335u = j2;
        InterfaceC3038g interfaceC3038g = this.f8332r;
        if (!(interfaceC3038g instanceof C3035d) || ((C3035d) interfaceC3038g).m3691b(j2)) {
            return;
        }
        this.f8334t = true;
        this.f8325k = this.f8322h;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m3697i(InterfaceC3041i interfaceC3041i) throws IOException {
        InterfaceC3038g interfaceC3038g = this.f8332r;
        if (interfaceC3038g != null) {
            long jMo3689a = interfaceC3038g.mo3689a();
            if (jMo3689a != -1 && interfaceC3041i.mo3645f() > jMo3689a - 4) {
                return true;
            }
        }
        try {
            return !interfaceC3041i.mo3644e(this.f8318d.f6793a, 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    /* JADX INFO: renamed from: j */
    public final boolean m3698j(InterfaceC3041i interfaceC3041i, boolean z2) throws IOException {
        int i;
        int iMo3645f;
        int iM3465a;
        int i2 = z2 ? 32768 : 131072;
        interfaceC3041i.mo3649k();
        if (interfaceC3041i.getPosition() == 0) {
            Metadata metadataM3816a = this.f8321g.m3816a(interfaceC3041i, (this.f8316b & 8) == 0 ? null : f8315a);
            this.f8327m = metadataM3816a;
            if (metadataM3816a != null) {
                this.f8320f.m3815b(metadataM3816a);
            }
            iMo3645f = (int) interfaceC3041i.mo3645f();
            if (!z2) {
                interfaceC3041i.mo3650l(iMo3645f);
            }
            i = 0;
        } else {
            i = 0;
            iMo3645f = 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (m3697i(interfaceC3041i)) {
                if (i3 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.f8318d.m3079E(0);
            int iM3086f = this.f8318d.m3086f();
            if ((i == 0 || m3694h(iM3086f, i)) && (iM3465a = C2912a0.m3465a(iM3086f)) != -1) {
                i3++;
                if (i3 != 1) {
                    if (i3 == 4) {
                        break;
                    }
                } else {
                    this.f8319e.m3469a(iM3086f);
                    i = iM3086f;
                }
                interfaceC3041i.mo3646g(iM3465a - 4);
            } else {
                int i5 = i4 + 1;
                if (i4 == i2) {
                    if (z2) {
                        return false;
                    }
                    throw ParserException.m8755a("Searched too many bytes.", null);
                }
                if (z2) {
                    interfaceC3041i.mo3649k();
                    interfaceC3041i.mo3646g(iMo3645f + i5);
                } else {
                    interfaceC3041i.mo3650l(1);
                }
                i4 = i5;
                i = 0;
                i3 = 0;
            }
        }
        if (z2) {
            interfaceC3041i.mo3650l(iMo3645f + i4);
        } else {
            interfaceC3041i.mo3649k();
        }
        this.f8326l = i;
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }

    public C3037f(int i) {
        this.f8316b = (i & 2) != 0 ? i | 1 : i;
        this.f8317c = -9223372036854775807L;
        this.f8318d = new C2757x(10);
        this.f8319e = new C2912a0.a();
        this.f8320f = new C3115p();
        this.f8328n = -9223372036854775807L;
        this.f8321g = new C3116q();
        C3023g c3023g = new C3023g();
        this.f8322h = c3023g;
        this.f8325k = c3023g;
    }
}
