package p007b.p225i.p226a.p242c.p267x2.p274i0;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2754u;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p263t2.C2930n;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3115p;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.C3120u;
import p007b.p225i.p226a.p242c.p267x2.C3123x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p274i0.AbstractC3045d;
import p007b.p225i.p226a.p242c.p267x2.p274i0.C3052k;
import p007b.p225i.p355b.p356a.InterfaceC4485e;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.i */
/* JADX INFO: compiled from: Mp4Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3050i implements InterfaceC3031h, InterfaceC3119t {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f8419a = 0;

    /* JADX INFO: renamed from: b */
    public final int f8420b;

    /* JADX INFO: renamed from: c */
    public final C2757x f8421c;

    /* JADX INFO: renamed from: d */
    public final C2757x f8422d;

    /* JADX INFO: renamed from: e */
    public final C2757x f8423e;

    /* JADX INFO: renamed from: f */
    public final C2757x f8424f;

    /* JADX INFO: renamed from: g */
    public final ArrayDeque<AbstractC3045d.a> f8425g;

    /* JADX INFO: renamed from: h */
    public final C3052k f8426h;

    /* JADX INFO: renamed from: i */
    public final List<Metadata.Entry> f8427i;

    /* JADX INFO: renamed from: j */
    public int f8428j;

    /* JADX INFO: renamed from: k */
    public int f8429k;

    /* JADX INFO: renamed from: l */
    public long f8430l;

    /* JADX INFO: renamed from: m */
    public int f8431m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public C2757x f8432n;

    /* JADX INFO: renamed from: o */
    public int f8433o;

    /* JADX INFO: renamed from: p */
    public int f8434p;

    /* JADX INFO: renamed from: q */
    public int f8435q;

    /* JADX INFO: renamed from: r */
    public int f8436r;

    /* JADX INFO: renamed from: s */
    public InterfaceC3058j f8437s;

    /* JADX INFO: renamed from: t */
    public a[] f8438t;

    /* JADX INFO: renamed from: u */
    public long[][] f8439u;

    /* JADX INFO: renamed from: v */
    public int f8440v;

    /* JADX INFO: renamed from: w */
    public long f8441w;

    /* JADX INFO: renamed from: x */
    public int f8442x;

    /* JADX INFO: renamed from: y */
    @Nullable
    public MotionPhotoMetadata f8443y;

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.i$a */
    /* JADX INFO: compiled from: Mp4Extractor.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final C3054m f8444a;

        /* JADX INFO: renamed from: b */
        public final C3057p f8445b;

        /* JADX INFO: renamed from: c */
        public final InterfaceC3122w f8446c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public final C3123x f8447d;

        /* JADX INFO: renamed from: e */
        public int f8448e;

        public a(C3054m c3054m, C3057p c3057p, InterfaceC3122w interfaceC3122w) {
            this.f8444a = c3054m;
            this.f8445b = c3057p;
            this.f8446c = interfaceC3122w;
            this.f8447d = "audio/true-hd".equals(c3054m.f8465f.f7155w) ? new C3123x() : null;
        }
    }

    static {
        C3043b c3043b = new InterfaceC3106l() { // from class: b.i.a.c.x2.i0.b
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3050i(0)};
            }

            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: b */
            public /* synthetic */ InterfaceC3031h[] mo3631b(Uri uri, Map map) {
                return C3069k.m3748a(this, uri, map);
            }
        };
    }

    public C3050i(int i) {
        this.f8420b = i;
        this.f8428j = (i & 4) != 0 ? 3 : 0;
        this.f8426h = new C3052k();
        this.f8427i = new ArrayList();
        this.f8424f = new C2757x(16);
        this.f8425g = new ArrayDeque<>();
        this.f8421c = new C2757x(C2754u.f6753a);
        this.f8422d = new C2757x(4);
        this.f8423e = new C2757x();
        this.f8433o = -1;
    }

    /* JADX INFO: renamed from: k */
    public static long m3727k(C3057p c3057p, long j, long j2) {
        int iM3732a = c3057p.m3732a(j);
        if (iM3732a == -1) {
            iM3732a = c3057p.m3733b(j);
        }
        return iM3732a == -1 ? j2 : Math.min(c3057p.f8495c[iM3732a], j2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        return C3053l.m3730a(interfaceC3041i, false, (this.f8420b & 2) != 0);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:235:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:256:0x0523  */
    /* JADX WARN: Code duplicated, block: B:257:0x053a  */
    /* JADX WARN: Code duplicated, block: B:259:0x0540  */
    /* JADX WARN: Code duplicated, block: B:266:0x055a  */
    /* JADX WARN: Code duplicated, block: B:269:0x056e  */
    /* JADX WARN: Code duplicated, block: B:284:0x0596  */
    /* JADX WARN: Code duplicated, block: B:287:0x059c  */
    /* JADX WARN: Code duplicated, block: B:293:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:297:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:298:0x05f6  */
    /* JADX WARN: Code duplicated, block: B:300:0x05fc  */
    /* JADX WARN: Code duplicated, block: B:336:0x0653  */
    /* JADX WARN: Code duplicated, block: B:338:0x0656  */
    /* JADX WARN: Code duplicated, block: B:340:0x065a  */
    /* JADX WARN: Code duplicated, block: B:341:0x065c  */
    /* JADX WARN: Code duplicated, block: B:344:0x0669  */
    /* JADX WARN: Code duplicated, block: B:345:0x066b  */
    /* JADX WARN: Code duplicated, block: B:347:0x0689  */
    /* JADX WARN: Code duplicated, block: B:349:0x0699  */
    /* JADX WARN: Code duplicated, block: B:361:0x04a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:363:0x06bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:367:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b1  */
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        int i;
        char c;
        boolean z2;
        boolean z3;
        long j;
        long jMo3642b;
        AbstractC3045d.a aVarPeek;
        long j2;
        int i2;
        int i3;
        boolean z4;
        boolean z5;
        long j3;
        long j4;
        boolean z6;
        boolean z7;
        boolean z8;
        long j5;
        long j6;
        long j7;
        C2757x c2757x;
        int i4;
        while (true) {
            int i5 = this.f8428j;
            int i6 = 4;
            int i7 = 2;
            if (i5 == 0) {
                if (this.f8431m != 0) {
                    j = this.f8430l;
                    if (j == 1) {
                        interfaceC3041i.readFully(this.f8424f.f6793a, 8, 8);
                        this.f8431m += 8;
                        this.f8430l = this.f8424f.m3104x();
                    } else if (j == 0) {
                        jMo3642b = interfaceC3041i.mo3642b();
                        if (jMo3642b == -1 && (aVarPeek = this.f8425g.peek()) != null) {
                            jMo3642b = aVarPeek.f8350b;
                        }
                        if (jMo3642b != -1) {
                            this.f8430l = (jMo3642b - interfaceC3041i.getPosition()) + ((long) this.f8431m);
                        }
                    }
                    j2 = this.f8430l;
                    i2 = this.f8431m;
                    if (j2 >= i2) {
                        throw ParserException.m8756b("Atom size less than header length (unsupported).");
                    }
                    i3 = this.f8429k;
                    if (i3 != 1836019574 || i3 == 1953653099 || i3 == 1835297121 || i3 == 1835626086 || i3 == 1937007212 || i3 == 1701082227 || i3 == 1835365473) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        long position = interfaceC3041i.getPosition();
                        j5 = this.f8430l;
                        j6 = this.f8431m;
                        j7 = (position + j5) - j6;
                        if (j5 != j6 && this.f8429k == 1835365473) {
                            this.f8423e.m3075A(8);
                            interfaceC3041i.mo3652o(this.f8423e.f6793a, 0, 8);
                            c2757x = this.f8423e;
                            byte[] bArr = C3046e.f8354a;
                            i4 = c2757x.f6794b;
                            c2757x.m3080F(4);
                            if (c2757x.m3086f() != 1751411826) {
                                i4 += 4;
                            }
                            c2757x.m3079E(i4);
                            interfaceC3041i.mo3650l(this.f8423e.f6794b);
                            interfaceC3041i.mo3649k();
                        }
                        this.f8425g.push(new AbstractC3045d.a(this.f8429k, j7));
                        if (this.f8430l == this.f8431m) {
                            m3729l(j7);
                        } else {
                            m3728j();
                        }
                    } else {
                        if (i3 != 1835296868 || i3 == 1836476516 || i3 == 1751411826 || i3 == 1937011556 || i3 == 1937011827 || i3 == 1937011571 || i3 == 1668576371 || i3 == 1701606260 || i3 == 1937011555 || i3 == 1937011578 || i3 == 1937013298 || i3 == 1937007471 || i3 == 1668232756 || i3 == 1953196132 || i3 == 1718909296 || i3 == 1969517665 || i3 == 1801812339 || i3 == 1768715124) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            if (i2 == 8) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            C1460d.m426D(z6);
                            if (this.f8430l <= 2147483647L) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            C1460d.m426D(z7);
                            C2757x c2757x2 = new C2757x((int) this.f8430l);
                            System.arraycopy(this.f8424f.f6793a, 0, c2757x2.f6793a, 0, 8);
                            this.f8432n = c2757x2;
                            this.f8428j = 1;
                        } else {
                            long position2 = interfaceC3041i.getPosition();
                            j3 = this.f8431m;
                            j4 = position2 - j3;
                            if (this.f8429k == 1836086884) {
                                this.f8443y = new MotionPhotoMetadata(0L, j4, -9223372036854775807L, j4 + j3, this.f8430l - j3);
                            }
                            this.f8432n = null;
                            this.f8428j = 1;
                        }
                    }
                    z8 = true;
                } else if (interfaceC3041i.mo3643c(this.f8424f.f6793a, 0, 8, true)) {
                    this.f8431m = 8;
                    this.f8424f.m3079E(0);
                    this.f8430l = this.f8424f.m3101u();
                    this.f8429k = this.f8424f.m3086f();
                    j = this.f8430l;
                    if (j == 1) {
                        interfaceC3041i.readFully(this.f8424f.f6793a, 8, 8);
                        this.f8431m += 8;
                        this.f8430l = this.f8424f.m3104x();
                    } else if (j == 0) {
                        jMo3642b = interfaceC3041i.mo3642b();
                        if (jMo3642b == -1) {
                            jMo3642b = aVarPeek.f8350b;
                        }
                        if (jMo3642b != -1) {
                            this.f8430l = (jMo3642b - interfaceC3041i.getPosition()) + ((long) this.f8431m);
                        }
                    }
                    j2 = this.f8430l;
                    i2 = this.f8431m;
                    if (j2 >= i2) {
                        throw ParserException.m8756b("Atom size less than header length (unsupported).");
                    }
                    i3 = this.f8429k;
                    if (i3 != 1836019574) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (z4) {
                        long position3 = interfaceC3041i.getPosition();
                        j5 = this.f8430l;
                        j6 = this.f8431m;
                        j7 = (position3 + j5) - j6;
                        if (j5 != j6) {
                            this.f8423e.m3075A(8);
                            interfaceC3041i.mo3652o(this.f8423e.f6793a, 0, 8);
                            c2757x = this.f8423e;
                            byte[] bArr2 = C3046e.f8354a;
                            i4 = c2757x.f6794b;
                            c2757x.m3080F(4);
                            if (c2757x.m3086f() != 1751411826) {
                                i4 += 4;
                            }
                            c2757x.m3079E(i4);
                            interfaceC3041i.mo3650l(this.f8423e.f6794b);
                            interfaceC3041i.mo3649k();
                        }
                        this.f8425g.push(new AbstractC3045d.a(this.f8429k, j7));
                        if (this.f8430l == this.f8431m) {
                            m3729l(j7);
                        } else {
                            m3728j();
                        }
                    } else {
                        if (i3 != 1835296868) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        if (z5) {
                            if (i2 == 8) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            C1460d.m426D(z6);
                            if (this.f8430l <= 2147483647L) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            C1460d.m426D(z7);
                            C2757x c2757x3 = new C2757x((int) this.f8430l);
                            System.arraycopy(this.f8424f.f6793a, 0, c2757x3.f6793a, 0, 8);
                            this.f8432n = c2757x3;
                            this.f8428j = 1;
                        } else {
                            long position4 = interfaceC3041i.getPosition();
                            j3 = this.f8431m;
                            j4 = position4 - j3;
                            if (this.f8429k == 1836086884) {
                                this.f8443y = new MotionPhotoMetadata(0L, j4, -9223372036854775807L, j4 + j3, this.f8430l - j3);
                            }
                            this.f8432n = null;
                            this.f8428j = 1;
                        }
                    }
                    z8 = true;
                } else {
                    if (this.f8442x == 2 && (this.f8420b & 2) != 0) {
                        InterfaceC3058j interfaceC3058j = this.f8437s;
                        Objects.requireNonNull(interfaceC3058j);
                        InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(0, 4);
                        MotionPhotoMetadata motionPhotoMetadata = this.f8443y;
                        Metadata metadata = motionPhotoMetadata == null ? null : new Metadata(motionPhotoMetadata);
                        C2811j1.b bVar = new C2811j1.b();
                        bVar.f7171i = metadata;
                        interfaceC3122wMo2492p.mo2526e(bVar.m3277a());
                        interfaceC3058j.mo2486j();
                        interfaceC3058j.mo2477a(new InterfaceC3119t.b(-9223372036854775807L, 0L));
                    }
                    z8 = false;
                }
                if (!z8) {
                    return -1;
                }
            } else {
                if (i5 != 1) {
                    if (i5 == 2) {
                        long position5 = interfaceC3041i.getPosition();
                        if (this.f8433o == -1) {
                            int i8 = -1;
                            boolean z9 = true;
                            int i9 = -1;
                            int i10 = 0;
                            long j8 = RecyclerView.FOREVER_NS;
                            boolean z10 = true;
                            long j9 = RecyclerView.FOREVER_NS;
                            long j10 = RecyclerView.FOREVER_NS;
                            while (true) {
                                a[] aVarArr = this.f8438t;
                                int i11 = C2738e0.f6708a;
                                if (i10 >= aVarArr.length) {
                                    break;
                                }
                                a aVar = aVarArr[i10];
                                int i12 = aVar.f8448e;
                                C3057p c3057p = aVar.f8445b;
                                if (i12 != c3057p.f8494b) {
                                    long j11 = c3057p.f8495c[i12];
                                    long j12 = this.f8439u[i10][i12];
                                    long j13 = j11 - position5;
                                    boolean z11 = j13 < 0 || j13 >= Permission.USE_EXTERNAL_EMOJIS;
                                    if ((!z11 && z9) || (z11 == z9 && j13 < j10)) {
                                        z9 = z11;
                                        j10 = j13;
                                        i9 = i10;
                                        j9 = j12;
                                    }
                                    if (j12 < j8) {
                                        z10 = z11;
                                        i8 = i10;
                                        j8 = j12;
                                    }
                                }
                                i10++;
                            }
                            if (j8 == RecyclerView.FOREVER_NS || !z10 || j9 < j8 + 10485760) {
                                i8 = i9;
                            }
                            this.f8433o = i8;
                            if (i8 == -1) {
                                return -1;
                            }
                        }
                        a[] aVarArr2 = this.f8438t;
                        int i13 = C2738e0.f6708a;
                        a aVar2 = aVarArr2[this.f8433o];
                        InterfaceC3122w interfaceC3122w = aVar2.f8446c;
                        int i14 = aVar2.f8448e;
                        C3057p c3057p2 = aVar2.f8445b;
                        long j14 = c3057p2.f8495c[i14];
                        int i15 = c3057p2.f8496d[i14];
                        C3123x c3123x = aVar2.f8447d;
                        long j15 = (j14 - position5) + ((long) this.f8434p);
                        if (j15 < 0 || j15 >= Permission.USE_EXTERNAL_EMOJIS) {
                            c3118s.f8992a = j14;
                            return 1;
                        }
                        if (aVar2.f8444a.f8466g == 1) {
                            j15 += 8;
                            i15 -= 8;
                        }
                        interfaceC3041i.mo3650l((int) j15);
                        C3054m c3054m = aVar2.f8444a;
                        int i16 = c3054m.f8469j;
                        if (i16 == 0) {
                            if ("audio/ac4".equals(c3054m.f8465f.f7155w)) {
                                if (this.f8435q == 0) {
                                    C2930n.m3492a(i15, this.f8423e);
                                    interfaceC3122w.mo2524c(this.f8423e, 7);
                                    this.f8435q += 7;
                                }
                                i15 += 7;
                            } else if (c3123x != null) {
                                c3123x.m3821c(interfaceC3041i);
                            }
                            while (true) {
                                int i17 = this.f8435q;
                                if (i17 >= i15) {
                                    break;
                                }
                                int iMo2523b = interfaceC3122w.mo2523b(interfaceC3041i, i15 - i17, false);
                                this.f8434p += iMo2523b;
                                this.f8435q += iMo2523b;
                                this.f8436r -= iMo2523b;
                            }
                        } else {
                            byte[] bArr3 = this.f8422d.f6793a;
                            bArr3[0] = 0;
                            bArr3[1] = 0;
                            bArr3[2] = 0;
                            int i18 = 4 - i16;
                            while (this.f8435q < i15) {
                                int i19 = this.f8436r;
                                if (i19 == 0) {
                                    interfaceC3041i.readFully(bArr3, i18, i16);
                                    this.f8434p += i16;
                                    this.f8422d.m3079E(0);
                                    int iM3086f = this.f8422d.m3086f();
                                    if (iM3086f < 0) {
                                        throw ParserException.m8755a("Invalid NAL length", null);
                                    }
                                    this.f8436r = iM3086f;
                                    this.f8421c.m3079E(0);
                                    interfaceC3122w.mo2524c(this.f8421c, 4);
                                    this.f8435q += 4;
                                    i15 += i18;
                                } else {
                                    int iMo2523b2 = interfaceC3122w.mo2523b(interfaceC3041i, i19, false);
                                    this.f8434p += iMo2523b2;
                                    this.f8435q += iMo2523b2;
                                    this.f8436r -= iMo2523b2;
                                }
                            }
                        }
                        int i20 = i15;
                        C3057p c3057p3 = aVar2.f8445b;
                        long j16 = c3057p3.f8498f[i14];
                        int i21 = c3057p3.f8499g[i14];
                        if (c3123x != null) {
                            c3123x.m3820b(interfaceC3122w, j16, i21, i20, 0, null);
                            if (i14 + 1 == aVar2.f8445b.f8494b) {
                                c3123x.m3819a(interfaceC3122w, null);
                            }
                        } else {
                            interfaceC3122w.mo2525d(j16, i21, i20, 0, null);
                        }
                        aVar2.f8448e++;
                        this.f8433o = -1;
                        this.f8434p = 0;
                        this.f8435q = 0;
                        this.f8436r = 0;
                        return 0;
                    }
                    if (i5 != 3) {
                        throw new IllegalStateException();
                    }
                    C3052k c3052k = this.f8426h;
                    List<Metadata.Entry> list = this.f8427i;
                    int i22 = c3052k.f8455d;
                    if (i22 == 0) {
                        long jMo3642b2 = interfaceC3041i.mo3642b();
                        c3118s.f8992a = (jMo3642b2 == -1 || jMo3642b2 < 8) ? 0L : jMo3642b2 - 8;
                        c3052k.f8455d = 1;
                    } else if (i22 != 1) {
                        short s2 = 2819;
                        if (i22 == 2) {
                            long jMo3642b3 = interfaceC3041i.mo3642b();
                            int i23 = (c3052k.f8456e - 12) - 8;
                            C2757x c2757x4 = new C2757x(i23);
                            interfaceC3041i.readFully(c2757x4.f6793a, 0, i23);
                            int i24 = 0;
                            while (i24 < i23 / 12) {
                                c2757x4.m3080F(i7);
                                short sM3089i = c2757x4.m3089i();
                                if (sM3089i == 2192 || sM3089i == 2816 || sM3089i == 2817 || sM3089i == s2 || sM3089i == 2820) {
                                    c3052k.f8454c.add(new C3052k.a(sM3089i, (jMo3642b3 - ((long) c3052k.f8456e)) - ((long) c2757x4.m3088h()), c2757x4.m3088h()));
                                } else {
                                    c2757x4.m3080F(8);
                                }
                                i24++;
                                s2 = 2819;
                                i7 = 2;
                            }
                            if (c3052k.f8454c.isEmpty()) {
                                c3118s.f8992a = 0L;
                            } else {
                                c3052k.f8455d = 3;
                                c3118s.f8992a = c3052k.f8454c.get(0).f8457a;
                            }
                        } else {
                            if (i22 != 3) {
                                throw new IllegalStateException();
                            }
                            long position6 = interfaceC3041i.getPosition();
                            int iMo3642b = (int) ((interfaceC3041i.mo3642b() - interfaceC3041i.getPosition()) - ((long) c3052k.f8456e));
                            C2757x c2757x5 = new C2757x(iMo3642b);
                            interfaceC3041i.readFully(c2757x5.f6793a, 0, iMo3642b);
                            int i25 = 0;
                            while (i25 < c3052k.f8454c.size()) {
                                C3052k.a aVar3 = c3052k.f8454c.get(i25);
                                List<Metadata.Entry> list2 = list;
                                c2757x5.m3079E((int) (aVar3.f8457a - position6));
                                c2757x5.m3080F(i6);
                                int iM3088h = c2757x5.m3088h();
                                switch (c2757x5.m3097q(iM3088h)) {
                                    case "SlowMotion_Data":
                                        i = 0;
                                        break;
                                    case "Super_SlowMotion_Edit_Data":
                                        i = 1;
                                        break;
                                    case "Super_SlowMotion_Data":
                                        i = 2;
                                        break;
                                    case "Super_SlowMotion_Deflickering_On":
                                        i = 3;
                                        break;
                                    case "Super_SlowMotion_BGM":
                                        i = 4;
                                        break;
                                    default:
                                        i = -1;
                                        break;
                                }
                                if (i == 0) {
                                    c = 2192;
                                } else if (i == 1) {
                                    c = 2819;
                                } else if (i == 2) {
                                    c = 2816;
                                } else if (i == 3) {
                                    c = 2820;
                                } else {
                                    if (i != i6) {
                                        throw ParserException.m8755a("Invalid SEF name", null);
                                    }
                                    c = 2817;
                                }
                                int i26 = aVar3.f8458b - (iM3088h + 8);
                                if (c == 2192) {
                                    ArrayList arrayList = new ArrayList();
                                    List<String> listM6215a = C3052k.f8453b.m6215a(c2757x5.m3097q(i26));
                                    for (int i27 = 0; i27 < listM6215a.size(); i27++) {
                                        List<String> listM6215a2 = C3052k.f8452a.m6215a(listM6215a.get(i27));
                                        if (listM6215a2.size() != 3) {
                                            throw ParserException.m8755a(null, null);
                                        }
                                        try {
                                            arrayList.add(new SlowMotionData.Segment(Long.parseLong(listM6215a2.get(0)), Long.parseLong(listM6215a2.get(1)), 1 << (Integer.parseInt(listM6215a2.get(2)) - 1)));
                                        } catch (NumberFormatException e) {
                                            throw ParserException.m8755a(null, e);
                                        }
                                    }
                                    list2.add(new SlowMotionData(arrayList));
                                } else if (c != 2816 && c != 2817 && c != 2819 && c != 2820) {
                                    throw new IllegalStateException();
                                }
                                i25++;
                                list = list2;
                                i6 = 4;
                            }
                            c3118s.f8992a = 0L;
                        }
                    } else {
                        byte[] bArr4 = new byte[8];
                        interfaceC3041i.readFully(bArr4, 0, 8);
                        c3052k.f8456e = ((bArr4[0] & 255) | ((bArr4[1] & 255) << 8) | ((bArr4[2] & 255) << 16) | ((bArr4[3] & 255) << 24)) + 8;
                        if (((bArr4[7] & 255) | ((bArr4[5] & 255) << 16) | ((bArr4[4] & 255) << 24) | ((bArr4[6] & 255) << 8)) != 1397048916) {
                            c3118s.f8992a = 0L;
                        } else {
                            c3118s.f8992a = interfaceC3041i.getPosition() - ((long) (c3052k.f8456e - 12));
                            c3052k.f8455d = 2;
                        }
                    }
                    if (c3118s.f8992a == 0) {
                        m3728j();
                    }
                    return 1;
                }
                long j17 = this.f8430l - ((long) this.f8431m);
                long position7 = interfaceC3041i.getPosition() + j17;
                C2757x c2757x6 = this.f8432n;
                if (c2757x6 != null) {
                    interfaceC3041i.readFully(c2757x6.f6793a, this.f8431m, (int) j17);
                    if (this.f8429k == 1718909296) {
                        c2757x6.m3079E(8);
                        int iM3086f2 = c2757x6.m3086f();
                        int i28 = iM3086f2 != 1751476579 ? iM3086f2 != 1903435808 ? 0 : 1 : 2;
                        if (i28 == 0) {
                            c2757x6.m3080F(4);
                            do {
                                if (c2757x6.m3081a() <= 0) {
                                    i28 = 0;
                                    break;
                                }
                                int iM3086f3 = c2757x6.m3086f();
                                i28 = iM3086f3 != 1751476579 ? iM3086f3 != 1903435808 ? 0 : 1 : 2;
                            } while (i28 == 0);
                        }
                        this.f8442x = i28;
                    } else if (!this.f8425g.isEmpty()) {
                        this.f8425g.peek().f8351c.add(new AbstractC3045d.b(this.f8429k, c2757x6));
                    }
                } else {
                    if (j17 < Permission.USE_EXTERNAL_EMOJIS) {
                        interfaceC3041i.mo3650l((int) j17);
                    } else {
                        c3118s.f8992a = interfaceC3041i.getPosition() + j17;
                        z2 = true;
                    }
                    m3729l(position7);
                    if (z2 || this.f8428j == 2) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        return 1;
                    }
                }
                z2 = false;
                m3729l(position7);
                if (z2) {
                    z3 = false;
                } else {
                    z3 = false;
                }
                if (z3) {
                    return 1;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8437s = interfaceC3058j;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8425g.clear();
        this.f8431m = 0;
        this.f8433o = -1;
        this.f8434p = 0;
        this.f8435q = 0;
        this.f8436r = 0;
        if (j == 0) {
            if (this.f8428j != 3) {
                m3728j();
                return;
            }
            C3052k c3052k = this.f8426h;
            c3052k.f8454c.clear();
            c3052k.f8455d = 0;
            this.f8427i.clear();
            return;
        }
        a[] aVarArr = this.f8438t;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                C3057p c3057p = aVar.f8445b;
                int iM3732a = c3057p.m3732a(j2);
                if (iM3732a == -1) {
                    iM3732a = c3057p.m3733b(j2);
                }
                aVar.f8448e = iM3732a;
                C3123x c3123x = aVar.f8447d;
                if (c3123x != null) {
                    c3123x.f9005b = false;
                    c3123x.f9006c = 0;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: h */
    public InterfaceC3119t.a mo3620h(long j) {
        long j2;
        long jM3727k;
        long j3;
        long j4;
        int iM3733b;
        long j5 = j;
        a[] aVarArr = this.f8438t;
        Objects.requireNonNull(aVarArr);
        if (aVarArr.length == 0) {
            return new InterfaceC3119t.a(C3120u.f8997a);
        }
        long j6 = -1;
        int i = this.f8440v;
        if (i != -1) {
            C3057p c3057p = this.f8438t[i].f8445b;
            int iM3732a = c3057p.m3732a(j5);
            if (iM3732a == -1) {
                iM3732a = c3057p.m3733b(j5);
            }
            if (iM3732a == -1) {
                return new InterfaceC3119t.a(C3120u.f8997a);
            }
            long j7 = c3057p.f8498f[iM3732a];
            j2 = c3057p.f8495c[iM3732a];
            if (j7 >= j5 || iM3732a >= c3057p.f8494b - 1 || (iM3733b = c3057p.m3733b(j5)) == -1 || iM3733b == iM3732a) {
                j4 = -9223372036854775807L;
            } else {
                long j8 = c3057p.f8498f[iM3733b];
                long j9 = c3057p.f8495c[iM3733b];
                j4 = j8;
                j6 = j9;
            }
            jM3727k = j6;
            j3 = j4;
            j5 = j7;
        } else {
            j2 = RecyclerView.FOREVER_NS;
            jM3727k = -1;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            a[] aVarArr2 = this.f8438t;
            if (i2 >= aVarArr2.length) {
                break;
            }
            if (i2 != this.f8440v) {
                C3057p c3057p2 = aVarArr2[i2].f8445b;
                long jM3727k2 = m3727k(c3057p2, j5, j2);
                if (j3 != -9223372036854775807L) {
                    jM3727k = m3727k(c3057p2, j3, jM3727k);
                }
                j2 = jM3727k2;
            }
            i2++;
        }
        C3120u c3120u = new C3120u(j5, j2);
        return j3 == -9223372036854775807L ? new InterfaceC3119t.a(c3120u) : new InterfaceC3119t.a(c3120u, new C3120u(j3, jM3727k));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8441w;
    }

    /* JADX INFO: renamed from: j */
    public final void m3728j() {
        this.f8428j = 0;
        this.f8431m = 0;
    }

    /* JADX WARN: Code duplicated, block: B:155:0x02a8 A[Catch: all -> 0x022a, TryCatch #0 {all -> 0x022a, blocks: (B:38:0x00cb, B:40:0x00d1, B:42:0x00d6, B:45:0x00de, B:46:0x00e5, B:49:0x00f3, B:52:0x0100, B:55:0x010d, B:58:0x011d, B:61:0x012a, B:64:0x0135, B:67:0x0142, B:70:0x014e, B:73:0x015a, B:76:0x0166, B:79:0x0172, B:82:0x017e, B:85:0x018c, B:88:0x0199, B:91:0x01a5, B:96:0x01b7, B:98:0x01bb, B:100:0x01d0, B:103:0x01dd, B:107:0x01ec, B:115:0x01ff, B:153:0x0298, B:155:0x02a8, B:157:0x02b2, B:156:0x02ad, B:117:0x0219, B:119:0x0224, B:134:0x024a, B:137:0x0257, B:140:0x0263, B:143:0x026f, B:146:0x027b, B:149:0x0287, B:152:0x0291, B:159:0x02b7, B:160:0x02be), top: B:343:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:156:0x02ad A[Catch: all -> 0x022a, TryCatch #0 {all -> 0x022a, blocks: (B:38:0x00cb, B:40:0x00d1, B:42:0x00d6, B:45:0x00de, B:46:0x00e5, B:49:0x00f3, B:52:0x0100, B:55:0x010d, B:58:0x011d, B:61:0x012a, B:64:0x0135, B:67:0x0142, B:70:0x014e, B:73:0x015a, B:76:0x0166, B:79:0x0172, B:82:0x017e, B:85:0x018c, B:88:0x0199, B:91:0x01a5, B:96:0x01b7, B:98:0x01bb, B:100:0x01d0, B:103:0x01dd, B:107:0x01ec, B:115:0x01ff, B:153:0x0298, B:155:0x02a8, B:157:0x02b2, B:156:0x02ad, B:117:0x0219, B:119:0x0224, B:134:0x024a, B:137:0x0257, B:140:0x0263, B:143:0x026f, B:146:0x027b, B:149:0x0287, B:152:0x0291, B:159:0x02b7, B:160:0x02be), top: B:343:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:236:0x0494  */
    /* JADX WARN: Code duplicated, block: B:294:0x05ac  */
    /* JADX WARN: Code duplicated, block: B:43:0x00db  */
    /* JADX INFO: renamed from: l */
    public final void m3729l(long j) throws ParserException {
        ArrayList arrayList;
        boolean z2;
        Metadata metadata;
        int i;
        Metadata metadata2;
        Metadata metadata3;
        Metadata metadata4;
        Metadata metadata5;
        int i2;
        ArrayList arrayList2;
        int i3;
        int i4;
        MdtaMetadataEntry mdtaMetadataEntry;
        ArrayList arrayList3;
        boolean z3;
        Metadata metadata6;
        boolean z4;
        Id3Frame id3FrameM3724d;
        String strValueOf;
        String str;
        String str2;
        while (!this.f8425g.isEmpty() && this.f8425g.peek().f8350b == j) {
            AbstractC3045d.a aVarPop = this.f8425g.pop();
            if (aVarPop.f8349a == 1836019574) {
                ArrayList arrayList4 = new ArrayList();
                boolean z5 = this.f8442x == 1;
                C3115p c3115p = new C3115p();
                AbstractC3045d.b bVarM3701c = aVarPop.m3701c(1969517665);
                int i5 = 1768715124;
                int i6 = 1751411826;
                int i7 = 1835365473;
                int i8 = 4;
                int i9 = 8;
                Metadata metadata7 = null;
                if (bVarM3701c != null) {
                    byte[] bArr = C3046e.f8354a;
                    C2757x c2757x = bVarM3701c.f8353b;
                    c2757x.m3079E(8);
                    Metadata metadata8 = null;
                    String strM3095o = null;
                    while (c2757x.m3081a() >= i9) {
                        int i10 = c2757x.f6794b;
                        int iM3086f = c2757x.m3086f();
                        int i11 = i5;
                        int iM3086f2 = c2757x.m3086f();
                        if (iM3086f2 == i7) {
                            c2757x.m3079E(i10);
                            int i12 = i10 + iM3086f;
                            c2757x.m3080F(i9);
                            int i13 = c2757x.f6794b;
                            c2757x.m3080F(i8);
                            if (c2757x.m3086f() != i6) {
                                i13 += 4;
                            }
                            c2757x.m3079E(i13);
                            int i14 = i11;
                            while (true) {
                                int i15 = c2757x.f6794b;
                                if (i15 < i12) {
                                    int iM3086f3 = c2757x.m3086f();
                                    if (c2757x.m3086f() == i14) {
                                        c2757x.m3079E(i15);
                                        int i16 = i15 + iM3086f3;
                                        c2757x.m3080F(i9);
                                        ArrayList arrayList5 = new ArrayList();
                                        while (true) {
                                            int i17 = c2757x.f6794b;
                                            if (i17 >= i16) {
                                                break;
                                            }
                                            int iM3086f4 = c2757x.m3086f() + i17;
                                            int iM3086f5 = c2757x.m3086f();
                                            int i18 = (iM3086f5 >> 24) & 255;
                                            int i19 = i16;
                                            ArrayList arrayList6 = arrayList4;
                                            if (i18 == 169 || i18 == 253) {
                                                z4 = z5;
                                                int i20 = 16777215 & iM3086f5;
                                                if (i20 == 6516084) {
                                                    id3FrameM3724d = C3049h.m3721a(iM3086f5, c2757x);
                                                } else if (i20 == 7233901 || i20 == 7631467) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TIT2", c2757x);
                                                } else if (i20 == 6516589 || i20 == 7828084) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TCOM", c2757x);
                                                } else if (i20 == 6578553) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TDRC", c2757x);
                                                } else if (i20 == 4280916) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TPE1", c2757x);
                                                } else if (i20 == 7630703) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TSSE", c2757x);
                                                } else if (i20 == 6384738) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TALB", c2757x);
                                                } else if (i20 == 7108978) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "USLT", c2757x);
                                                } else if (i20 == 6776174) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TCON", c2757x);
                                                } else if (i20 == 6779504) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TIT1", c2757x);
                                                } else {
                                                    strValueOf = String.valueOf(AbstractC3045d.m3699a(iM3086f5));
                                                    if (strValueOf.length() != 0) {
                                                        str = "Skipped unknown metadata entry: ".concat(strValueOf);
                                                    } else {
                                                        str = new String("Skipped unknown metadata entry: ");
                                                    }
                                                    Log.d("MetadataUtil", str);
                                                    id3FrameM3724d = null;
                                                }
                                            } else if (iM3086f5 == 1735291493) {
                                                try {
                                                    int iM3726f = C3049h.m3726f(c2757x);
                                                    if (iM3726f > 0) {
                                                        String[] strArr = C3049h.f8418a;
                                                        if (iM3726f <= strArr.length) {
                                                            str2 = strArr[iM3726f - 1];
                                                        } else {
                                                            str2 = strM3095o;
                                                        }
                                                    } else {
                                                        str2 = strM3095o;
                                                    }
                                                    if (str2 != null) {
                                                        id3FrameM3724d = new TextInformationFrame("TCON", strM3095o, str2);
                                                        z4 = z5;
                                                    } else {
                                                        Log.w("MetadataUtil", "Failed to parse standard genre code");
                                                        z4 = z5;
                                                        id3FrameM3724d = null;
                                                    }
                                                } catch (Throwable th) {
                                                    c2757x.m3079E(iM3086f4);
                                                    throw th;
                                                }
                                            } else {
                                                if (iM3086f5 == 1684632427) {
                                                    id3FrameM3724d = C3049h.m3723c(iM3086f5, "TPOS", c2757x);
                                                } else if (iM3086f5 == 1953655662) {
                                                    id3FrameM3724d = C3049h.m3723c(iM3086f5, "TRCK", c2757x);
                                                } else if (iM3086f5 == 1953329263) {
                                                    id3FrameM3724d = C3049h.m3725e(iM3086f5, "TBPM", c2757x, true, false);
                                                } else if (iM3086f5 == 1668311404) {
                                                    id3FrameM3724d = C3049h.m3725e(iM3086f5, "TCMP", c2757x, true, true);
                                                } else if (iM3086f5 == 1668249202) {
                                                    id3FrameM3724d = C3049h.m3722b(c2757x);
                                                } else if (iM3086f5 == 1631670868) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TPE2", c2757x);
                                                } else if (iM3086f5 == 1936682605) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TSOT", c2757x);
                                                } else if (iM3086f5 == 1936679276) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TSO2", c2757x);
                                                } else if (iM3086f5 == 1936679282) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TSOA", c2757x);
                                                } else if (iM3086f5 == 1936679265) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TSOP", c2757x);
                                                } else if (iM3086f5 == 1936679791) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TSOC", c2757x);
                                                } else if (iM3086f5 == 1920233063) {
                                                    id3FrameM3724d = C3049h.m3725e(iM3086f5, "ITUNESADVISORY", c2757x, false, false);
                                                } else if (iM3086f5 == 1885823344) {
                                                    id3FrameM3724d = C3049h.m3725e(iM3086f5, "ITUNESGAPLESS", c2757x, false, true);
                                                } else if (iM3086f5 == 1936683886) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TVSHOWSORT", c2757x);
                                                } else if (iM3086f5 == 1953919848) {
                                                    id3FrameM3724d = C3049h.m3724d(iM3086f5, "TVSHOW", c2757x);
                                                } else if (iM3086f5 == 757935405) {
                                                    int i21 = -1;
                                                    int i22 = -1;
                                                    String strM3095o2 = strM3095o;
                                                    while (true) {
                                                        int i23 = c2757x.f6794b;
                                                        if (i23 >= iM3086f4) {
                                                            break;
                                                        }
                                                        int iM3086f6 = c2757x.m3086f();
                                                        int iM3086f7 = c2757x.m3086f();
                                                        boolean z6 = z5;
                                                        c2757x.m3080F(4);
                                                        if (iM3086f7 == 1835360622) {
                                                            strM3095o = c2757x.m3095o(iM3086f6 - 12);
                                                        } else if (iM3086f7 == 1851878757) {
                                                            strM3095o2 = c2757x.m3095o(iM3086f6 - 12);
                                                        } else {
                                                            if (iM3086f7 == 1684108385) {
                                                                i22 = iM3086f6;
                                                                i21 = i23;
                                                            }
                                                            c2757x.m3080F(iM3086f6 - 12);
                                                        }
                                                        z5 = z6;
                                                    }
                                                    z4 = z5;
                                                    if (strM3095o == null || strM3095o2 == null || i21 == -1) {
                                                        id3FrameM3724d = null;
                                                    } else {
                                                        c2757x.m3079E(i21);
                                                        c2757x.m3080F(16);
                                                        id3FrameM3724d = new InternalFrame(strM3095o, strM3095o2, c2757x.m3095o(i22 - 16));
                                                    }
                                                } else {
                                                    z4 = z5;
                                                    strValueOf = String.valueOf(AbstractC3045d.m3699a(iM3086f5));
                                                    if (strValueOf.length() != 0) {
                                                        str = "Skipped unknown metadata entry: ".concat(strValueOf);
                                                    } else {
                                                        str = new String("Skipped unknown metadata entry: ");
                                                    }
                                                    Log.d("MetadataUtil", str);
                                                    id3FrameM3724d = null;
                                                }
                                                z4 = z5;
                                            }
                                            c2757x.m3079E(iM3086f4);
                                            if (id3FrameM3724d != null) {
                                                arrayList5.add(id3FrameM3724d);
                                            }
                                            strM3095o = null;
                                            i16 = i19;
                                            arrayList4 = arrayList6;
                                            z5 = z4;
                                        }
                                        arrayList3 = arrayList4;
                                        z3 = z5;
                                        if (!arrayList5.isEmpty()) {
                                            metadata6 = new Metadata(arrayList5);
                                            break;
                                        }
                                        break;
                                    }
                                    c2757x.m3079E(i15 + iM3086f3);
                                    i9 = 8;
                                    i14 = 1768715124;
                                    strM3095o = null;
                                } else {
                                    arrayList3 = arrayList4;
                                    z3 = z5;
                                }
                                metadata6 = null;
                                break;
                            }
                            metadata7 = metadata6;
                        } else {
                            arrayList3 = arrayList4;
                            z3 = z5;
                            if (iM3086f2 == 1936553057) {
                                c2757x.m3079E(i10);
                                int i24 = i10 + iM3086f;
                                c2757x.m3080F(12);
                                while (true) {
                                    int i25 = c2757x.f6794b;
                                    if (i25 < i24) {
                                        int iM3086f8 = c2757x.m3086f();
                                        if (c2757x.m3086f() != 1935766900) {
                                            c2757x.m3079E(i25 + iM3086f8);
                                        } else if (iM3086f8 >= 14) {
                                            c2757x.m3080F(5);
                                            int iM3100t = c2757x.m3100t();
                                            if (iM3100t == 12 || iM3100t == 13) {
                                                float f = iM3100t == 12 ? 240.0f : 120.0f;
                                                c2757x.m3080F(1);
                                                metadata8 = new Metadata(new SmtaMetadataEntry(f, c2757x.m3100t()));
                                                break;
                                            }
                                        }
                                    }
                                    metadata8 = null;
                                    break;
                                }
                            }
                        }
                        c2757x.m3079E(i10 + iM3086f);
                        i9 = 8;
                        i5 = 1768715124;
                        i6 = 1751411826;
                        i7 = 1835365473;
                        strM3095o = null;
                        i8 = 4;
                        arrayList4 = arrayList3;
                        z5 = z3;
                    }
                    arrayList = arrayList4;
                    z2 = z5;
                    Pair pairCreate = Pair.create(metadata7, metadata8);
                    metadata2 = (Metadata) pairCreate.first;
                    metadata = (Metadata) pairCreate.second;
                    if (metadata2 != null) {
                        c3115p.m3815b(metadata2);
                    }
                    i = 1835365473;
                } else {
                    arrayList = arrayList4;
                    z2 = z5;
                    metadata = null;
                    i = 1835365473;
                    metadata2 = null;
                }
                Metadata metadata9 = metadata2;
                AbstractC3045d.a aVarM3700b = aVarPop.m3700b(i);
                if (aVarM3700b != null) {
                    byte[] bArr2 = C3046e.f8354a;
                    AbstractC3045d.b bVarM3701c2 = aVarM3700b.m3701c(1751411826);
                    AbstractC3045d.b bVarM3701c3 = aVarM3700b.m3701c(1801812339);
                    AbstractC3045d.b bVarM3701c4 = aVarM3700b.m3701c(1768715124);
                    if (bVarM3701c2 == null || bVarM3701c3 == null || bVarM3701c4 == null) {
                        metadata3 = metadata9;
                        metadata4 = null;
                    } else {
                        C2757x c2757x2 = bVarM3701c2.f8353b;
                        c2757x2.m3079E(16);
                        if (c2757x2.m3086f() != 1835299937) {
                            metadata3 = metadata9;
                        } else {
                            C2757x c2757x3 = bVarM3701c3.f8353b;
                            c2757x3.m3079E(12);
                            int iM3086f9 = c2757x3.m3086f();
                            String[] strArr2 = new String[iM3086f9];
                            for (int i26 = 0; i26 < iM3086f9; i26++) {
                                int iM3086f10 = c2757x3.m3086f();
                                c2757x3.m3080F(4);
                                strArr2[i26] = c2757x3.m3097q(iM3086f10 - 8);
                            }
                            int i27 = 8;
                            C2757x c2757x4 = bVarM3701c4.f8353b;
                            c2757x4.m3079E(8);
                            ArrayList arrayList7 = new ArrayList();
                            while (c2757x4.m3081a() > i27) {
                                int i28 = c2757x4.f6794b;
                                int iM3086f11 = c2757x4.m3086f();
                                int iM3086f12 = c2757x4.m3086f() - 1;
                                if (iM3086f12 < 0 || iM3086f12 >= iM3086f9) {
                                    i4 = iM3086f9;
                                    strArr2 = strArr2;
                                    metadata9 = metadata9;
                                    C1643a.m852g0(52, "Skipped metadata with unknown key index: ", iM3086f12, "AtomParsers");
                                } else {
                                    String str3 = strArr2[iM3086f12];
                                    int i29 = i28 + iM3086f11;
                                    while (true) {
                                        int i30 = c2757x4.f6794b;
                                        if (i30 >= i29) {
                                            i4 = iM3086f9;
                                            mdtaMetadataEntry = null;
                                            break;
                                        }
                                        int iM3086f13 = c2757x4.m3086f();
                                        i4 = iM3086f9;
                                        if (c2757x4.m3086f() == 1684108385) {
                                            int iM3086f14 = c2757x4.m3086f();
                                            int iM3086f15 = c2757x4.m3086f();
                                            int i31 = iM3086f13 - 16;
                                            byte[] bArr3 = new byte[i31];
                                            System.arraycopy(c2757x4.f6793a, c2757x4.f6794b, bArr3, 0, i31);
                                            c2757x4.f6794b += i31;
                                            mdtaMetadataEntry = new MdtaMetadataEntry(str3, bArr3, iM3086f15, iM3086f14);
                                            break;
                                        }
                                        c2757x4.m3079E(i30 + iM3086f13);
                                        iM3086f9 = i4;
                                    }
                                    if (mdtaMetadataEntry != null) {
                                        arrayList7.add(mdtaMetadataEntry);
                                    }
                                }
                                c2757x4.m3079E(i28 + iM3086f11);
                                i27 = 8;
                                iM3086f9 = i4;
                                strArr2 = strArr2;
                                metadata9 = metadata9;
                            }
                            metadata3 = metadata9;
                            if (!arrayList7.isEmpty()) {
                                metadata4 = new Metadata(arrayList7);
                            }
                        }
                        metadata4 = null;
                    }
                } else {
                    metadata3 = metadata9;
                    metadata4 = null;
                }
                Metadata metadata10 = metadata4;
                List<C3057p> listM3706e = C3046e.m3706e(aVarPop, c3115p, -9223372036854775807L, null, (this.f8420b & 1) != 0, z2, new InterfaceC4485e() { // from class: b.i.a.c.x2.i0.a
                    @Override // p007b.p225i.p355b.p356a.InterfaceC4485e
                    public final Object apply(Object obj) {
                        C3054m c3054m = (C3054m) obj;
                        int i32 = C3050i.f8419a;
                        return c3054m;
                    }
                });
                InterfaceC3058j interfaceC3058j = this.f8437s;
                Objects.requireNonNull(interfaceC3058j);
                ArrayList arrayList8 = (ArrayList) listM3706e;
                int size = arrayList8.size();
                long jMax = -9223372036854775807L;
                long j2 = -9223372036854775807L;
                int i32 = 0;
                int size2 = -1;
                while (i32 < size) {
                    C3057p c3057p = (C3057p) arrayList8.get(i32);
                    if (c3057p.f8494b == 0) {
                        metadata5 = metadata;
                        arrayList2 = arrayList;
                    } else {
                        C3054m c3054m = c3057p.f8493a;
                        Metadata metadata11 = metadata10;
                        int i33 = size2;
                        long j3 = c3054m.f8464e;
                        if (j3 == j2) {
                            j3 = c3057p.f8500h;
                        }
                        jMax = Math.max(jMax, j3);
                        a aVar = new a(c3054m, c3057p, interfaceC3058j.mo2492p(i32, c3054m.f8461b));
                        int i34 = "audio/true-hd".equals(c3054m.f8465f.f7155w) ? c3057p.f8497e * 16 : c3057p.f8497e + 30;
                        C2811j1.b bVarM3275a = c3054m.f8465f.m3275a();
                        bVarM3275a.f7174l = i34;
                        int i35 = c3054m.f8461b;
                        if (i35 == 2 && j3 > 0 && (i3 = c3057p.f8494b) > 1) {
                            bVarM3275a.f7180r = i3 / (j3 / 1000000.0f);
                        }
                        if (i35 == 1) {
                            int i36 = c3115p.f8985b;
                            if ((i36 == -1 || c3115p.f8986c == -1) ? false : true) {
                                bVarM3275a.f7159A = i36;
                                bVarM3275a.f7160B = c3115p.f8986c;
                            }
                        }
                        Metadata[] metadataArr = new Metadata[2];
                        metadataArr[0] = metadata;
                        metadataArr[1] = this.f8427i.isEmpty() ? null : new Metadata(this.f8427i);
                        Metadata metadata12 = new Metadata(new Metadata.Entry[0]);
                        if (i35 != 1) {
                            if (i35 == 2 && metadata11 != null) {
                                int i37 = 0;
                                metadata10 = metadata11;
                                while (true) {
                                    Metadata.Entry[] entryArr = metadata10.f19936j;
                                    if (i37 >= entryArr.length) {
                                        metadata5 = metadata;
                                        break;
                                    }
                                    Metadata.Entry entry = entryArr[i37];
                                    if (entry instanceof MdtaMetadataEntry) {
                                        MdtaMetadataEntry mdtaMetadataEntry2 = (MdtaMetadataEntry) entry;
                                        metadata5 = metadata;
                                        if ("com.android.capture.fps".equals(mdtaMetadataEntry2.f20004j)) {
                                            metadata12 = new Metadata(mdtaMetadataEntry2);
                                            break;
                                        }
                                    } else {
                                        metadata5 = metadata;
                                    }
                                    i37++;
                                    metadata = metadata5;
                                }
                            } else {
                                metadata5 = metadata;
                                metadata10 = metadata11;
                            }
                        } else if (metadata3 != null) {
                            metadata5 = metadata;
                            metadata10 = metadata11;
                            metadata12 = metadata3;
                        } else {
                            metadata5 = metadata;
                            metadata10 = metadata11;
                        }
                        for (int i38 = 0; i38 < 2; i38++) {
                            Metadata metadata13 = metadataArr[i38];
                            if (metadata13 != null) {
                                metadata12 = metadata12.m8877a(metadata13.f19936j);
                            }
                        }
                        if (metadata12.f19936j.length > 0) {
                            bVarM3275a.f7171i = metadata12;
                        }
                        aVar.f8446c.mo2526e(bVarM3275a.m3277a());
                        if (c3054m.f8461b == 2) {
                            i2 = i33;
                            if (i2 == -1) {
                                size2 = arrayList.size();
                            }
                            arrayList2 = arrayList;
                            arrayList2.add(aVar);
                        } else {
                            i2 = i33;
                        }
                        size2 = i2;
                        arrayList2 = arrayList;
                        arrayList2.add(aVar);
                    }
                    i32++;
                    j2 = -9223372036854775807L;
                    arrayList = arrayList2;
                    arrayList8 = arrayList8;
                    size = size;
                    metadata = metadata5;
                }
                long j4 = 0;
                this.f8440v = size2;
                this.f8441w = jMax;
                a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
                this.f8438t = aVarArr;
                long[][] jArr = new long[aVarArr.length][];
                int[] iArr = new int[aVarArr.length];
                long[] jArr2 = new long[aVarArr.length];
                boolean[] zArr = new boolean[aVarArr.length];
                for (int i39 = 0; i39 < aVarArr.length; i39++) {
                    jArr[i39] = new long[aVarArr[i39].f8445b.f8494b];
                    jArr2[i39] = aVarArr[i39].f8445b.f8498f[0];
                }
                int i40 = 0;
                while (i40 < aVarArr.length) {
                    long j5 = RecyclerView.FOREVER_NS;
                    int i41 = -1;
                    for (int i42 = 0; i42 < aVarArr.length; i42++) {
                        if (!zArr[i42] && jArr2[i42] <= j5) {
                            j5 = jArr2[i42];
                            i41 = i42;
                        }
                    }
                    int i43 = iArr[i41];
                    jArr[i41][i43] = j4;
                    j4 += (long) aVarArr[i41].f8445b.f8496d[i43];
                    int i44 = i43 + 1;
                    iArr[i41] = i44;
                    if (i44 < jArr[i41].length) {
                        jArr2[i41] = aVarArr[i41].f8445b.f8498f[i44];
                    } else {
                        zArr[i41] = true;
                        i40++;
                    }
                }
                this.f8439u = jArr;
                interfaceC3058j.mo2486j();
                interfaceC3058j.mo2477a(this);
                this.f8425g.clear();
                this.f8428j = 2;
            } else if (!this.f8425g.isEmpty()) {
                this.f8425g.peek().f8352d.add(aVarPop);
            }
        }
        if (this.f8428j != 2) {
            m3728j();
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}
