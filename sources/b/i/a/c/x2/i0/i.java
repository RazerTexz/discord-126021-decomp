package b.i.a.c.x2.i0;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.u;
import b.i.a.c.f3.x;
import b.i.a.c.j1$b;
import b.i.a.c.x2.s;
import b.i.a.c.x2.t;
import b.i.a.c.x2.t$a;
import b.i.a.c.x2.t$b;
import b.i.a.c.x2.w;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData$Segment;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: Mp4Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements b.i.a.c.x2.h, t {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1222b;
    public final x c;
    public final x d;
    public final x e;
    public final x f;
    public final ArrayDeque<d$a> g;
    public final k h;
    public final List<Metadata$Entry> i;
    public int j;
    public int k;
    public long l;
    public int m;

    @Nullable
    public x n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b.i.a.c.x2.j f1223s;
    public i$a[] t;
    public long[][] u;
    public int v;
    public long w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1224x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public MotionPhotoMetadata f1225y;

    static {
        b bVar = b.a;
    }

    public i(int i) {
        this.f1222b = i;
        this.j = (i & 4) != 0 ? 3 : 0;
        this.h = new k();
        this.i = new ArrayList();
        this.f = new x(16);
        this.g = new ArrayDeque<>();
        this.c = new x(u.a);
        this.d = new x(4);
        this.e = new x();
        this.o = -1;
    }

    public static long k(p pVar, long j, long j2) {
        int iA = pVar.a(j);
        if (iA == -1) {
            iA = pVar.b(j);
        }
        return iA == -1 ? j2 : Math.min(pVar.c[iA], j2);
    }

    @Override // b.i.a.c.x2.h
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        return l.a(iVar, false, (this.f1222b & 2) != 0);
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
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
    @Override // b.i.a.c.x2.h
    public int e(b.i.a.c.x2.i iVar, s sVar) throws IOException {
        int i;
        char c;
        boolean z2;
        boolean z3;
        long j;
        long jB;
        d$a d_aPeek;
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
        x xVar;
        int i4;
        while (true) {
            int i5 = this.j;
            int i6 = 4;
            int i7 = 2;
            if (i5 == 0) {
                if (this.m != 0) {
                    j = this.l;
                    if (j == 1) {
                        iVar.readFully(this.f.a, 8, 8);
                        this.m += 8;
                        this.l = this.f.x();
                    } else if (j == 0) {
                        jB = iVar.b();
                        if (jB == -1 && (d_aPeek = this.g.peek()) != null) {
                            jB = d_aPeek.f1209b;
                        }
                        if (jB != -1) {
                            this.l = (jB - iVar.getPosition()) + ((long) this.m);
                        }
                    }
                    j2 = this.l;
                    i2 = this.m;
                    if (j2 >= i2) {
                        throw ParserException.b("Atom size less than header length (unsupported).");
                    }
                    i3 = this.k;
                    if (i3 != 1836019574 || i3 == 1953653099 || i3 == 1835297121 || i3 == 1835626086 || i3 == 1937007212 || i3 == 1701082227 || i3 == 1835365473) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        long position = iVar.getPosition();
                        j5 = this.l;
                        j6 = this.m;
                        j7 = (position + j5) - j6;
                        if (j5 != j6 && this.k == 1835365473) {
                            this.e.A(8);
                            iVar.o(this.e.a, 0, 8);
                            xVar = this.e;
                            byte[] bArr = e.a;
                            i4 = xVar.f984b;
                            xVar.F(4);
                            if (xVar.f() != 1751411826) {
                                i4 += 4;
                            }
                            xVar.E(i4);
                            iVar.l(this.e.f984b);
                            iVar.k();
                        }
                        this.g.push(new d$a(this.k, j7));
                        if (this.l == this.m) {
                            l(j7);
                        } else {
                            j();
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
                            b.c.a.a0.d.D(z6);
                            if (this.l <= 2147483647L) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            b.c.a.a0.d.D(z7);
                            x xVar2 = new x((int) this.l);
                            System.arraycopy(this.f.a, 0, xVar2.a, 0, 8);
                            this.n = xVar2;
                            this.j = 1;
                        } else {
                            long position2 = iVar.getPosition();
                            j3 = this.m;
                            j4 = position2 - j3;
                            if (this.k == 1836086884) {
                                this.f1225y = new MotionPhotoMetadata(0L, j4, -9223372036854775807L, j4 + j3, this.l - j3);
                            }
                            this.n = null;
                            this.j = 1;
                        }
                    }
                    z8 = true;
                } else if (iVar.c(this.f.a, 0, 8, true)) {
                    this.m = 8;
                    this.f.E(0);
                    this.l = this.f.u();
                    this.k = this.f.f();
                    j = this.l;
                    if (j == 1) {
                        iVar.readFully(this.f.a, 8, 8);
                        this.m += 8;
                        this.l = this.f.x();
                    } else if (j == 0) {
                        jB = iVar.b();
                        if (jB == -1) {
                            jB = d_aPeek.f1209b;
                        }
                        if (jB != -1) {
                            this.l = (jB - iVar.getPosition()) + ((long) this.m);
                        }
                    }
                    j2 = this.l;
                    i2 = this.m;
                    if (j2 >= i2) {
                        throw ParserException.b("Atom size less than header length (unsupported).");
                    }
                    i3 = this.k;
                    if (i3 != 1836019574) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (z4) {
                        long position3 = iVar.getPosition();
                        j5 = this.l;
                        j6 = this.m;
                        j7 = (position3 + j5) - j6;
                        if (j5 != j6) {
                            this.e.A(8);
                            iVar.o(this.e.a, 0, 8);
                            xVar = this.e;
                            byte[] bArr2 = e.a;
                            i4 = xVar.f984b;
                            xVar.F(4);
                            if (xVar.f() != 1751411826) {
                                i4 += 4;
                            }
                            xVar.E(i4);
                            iVar.l(this.e.f984b);
                            iVar.k();
                        }
                        this.g.push(new d$a(this.k, j7));
                        if (this.l == this.m) {
                            l(j7);
                        } else {
                            j();
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
                            b.c.a.a0.d.D(z6);
                            if (this.l <= 2147483647L) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            b.c.a.a0.d.D(z7);
                            x xVar3 = new x((int) this.l);
                            System.arraycopy(this.f.a, 0, xVar3.a, 0, 8);
                            this.n = xVar3;
                            this.j = 1;
                        } else {
                            long position4 = iVar.getPosition();
                            j3 = this.m;
                            j4 = position4 - j3;
                            if (this.k == 1836086884) {
                                this.f1225y = new MotionPhotoMetadata(0L, j4, -9223372036854775807L, j4 + j3, this.l - j3);
                            }
                            this.n = null;
                            this.j = 1;
                        }
                    }
                    z8 = true;
                } else {
                    if (this.f1224x == 2 && (this.f1222b & 2) != 0) {
                        b.i.a.c.x2.j jVar = this.f1223s;
                        Objects.requireNonNull(jVar);
                        w wVarP = jVar.p(0, 4);
                        MotionPhotoMetadata motionPhotoMetadata = this.f1225y;
                        Metadata metadata = motionPhotoMetadata == null ? null : new Metadata(motionPhotoMetadata);
                        j1$b j1_b = new j1$b();
                        j1_b.i = metadata;
                        wVarP.e(j1_b.a());
                        jVar.j();
                        jVar.a(new t$b(-9223372036854775807L, 0L));
                    }
                    z8 = false;
                }
                if (!z8) {
                    return -1;
                }
            } else {
                if (i5 != 1) {
                    if (i5 == 2) {
                        long position5 = iVar.getPosition();
                        if (this.o == -1) {
                            int i8 = -1;
                            boolean z9 = true;
                            int i9 = -1;
                            int i10 = 0;
                            long j8 = RecyclerView.FOREVER_NS;
                            boolean z10 = true;
                            long j9 = RecyclerView.FOREVER_NS;
                            long j10 = RecyclerView.FOREVER_NS;
                            while (true) {
                                i$a[] i_aArr = this.t;
                                int i11 = e0.a;
                                if (i10 >= i_aArr.length) {
                                    break;
                                }
                                i$a i_a = i_aArr[i10];
                                int i12 = i_a.e;
                                p pVar = i_a.f1226b;
                                if (i12 != pVar.f1233b) {
                                    long j11 = pVar.c[i12];
                                    long j12 = this.u[i10][i12];
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
                            this.o = i8;
                            if (i8 == -1) {
                                return -1;
                            }
                        }
                        i$a[] i_aArr2 = this.t;
                        int i13 = e0.a;
                        i$a i_a2 = i_aArr2[this.o];
                        w wVar = i_a2.c;
                        int i14 = i_a2.e;
                        p pVar2 = i_a2.f1226b;
                        long j14 = pVar2.c[i14];
                        int i15 = pVar2.d[i14];
                        b.i.a.c.x2.x xVar4 = i_a2.d;
                        long j15 = (j14 - position5) + ((long) this.p);
                        if (j15 < 0 || j15 >= Permission.USE_EXTERNAL_EMOJIS) {
                            sVar.a = j14;
                            return 1;
                        }
                        if (i_a2.a.g == 1) {
                            j15 += 8;
                            i15 -= 8;
                        }
                        iVar.l((int) j15);
                        m mVar = i_a2.a;
                        int i16 = mVar.j;
                        if (i16 == 0) {
                            if ("audio/ac4".equals(mVar.f.w)) {
                                if (this.q == 0) {
                                    b.i.a.c.t2.n.a(i15, this.e);
                                    wVar.c(this.e, 7);
                                    this.q += 7;
                                }
                                i15 += 7;
                            } else if (xVar4 != null) {
                                xVar4.c(iVar);
                            }
                            while (true) {
                                int i17 = this.q;
                                if (i17 >= i15) {
                                    break;
                                }
                                int iB = wVar.b(iVar, i15 - i17, false);
                                this.p += iB;
                                this.q += iB;
                                this.r -= iB;
                            }
                        } else {
                            byte[] bArr3 = this.d.a;
                            bArr3[0] = 0;
                            bArr3[1] = 0;
                            bArr3[2] = 0;
                            int i18 = 4 - i16;
                            while (this.q < i15) {
                                int i19 = this.r;
                                if (i19 == 0) {
                                    iVar.readFully(bArr3, i18, i16);
                                    this.p += i16;
                                    this.d.E(0);
                                    int iF = this.d.f();
                                    if (iF < 0) {
                                        throw ParserException.a("Invalid NAL length", null);
                                    }
                                    this.r = iF;
                                    this.c.E(0);
                                    wVar.c(this.c, 4);
                                    this.q += 4;
                                    i15 += i18;
                                } else {
                                    int iB2 = wVar.b(iVar, i19, false);
                                    this.p += iB2;
                                    this.q += iB2;
                                    this.r -= iB2;
                                }
                            }
                        }
                        int i20 = i15;
                        p pVar3 = i_a2.f1226b;
                        long j16 = pVar3.f[i14];
                        int i21 = pVar3.g[i14];
                        if (xVar4 != null) {
                            xVar4.b(wVar, j16, i21, i20, 0, null);
                            if (i14 + 1 == i_a2.f1226b.f1233b) {
                                xVar4.a(wVar, null);
                            }
                        } else {
                            wVar.d(j16, i21, i20, 0, null);
                        }
                        i_a2.e++;
                        this.o = -1;
                        this.p = 0;
                        this.q = 0;
                        this.r = 0;
                        return 0;
                    }
                    if (i5 != 3) {
                        throw new IllegalStateException();
                    }
                    k kVar = this.h;
                    List<Metadata$Entry> list = this.i;
                    int i22 = kVar.d;
                    if (i22 == 0) {
                        long jB2 = iVar.b();
                        sVar.a = (jB2 == -1 || jB2 < 8) ? 0L : jB2 - 8;
                        kVar.d = 1;
                    } else if (i22 != 1) {
                        short s2 = 2819;
                        if (i22 == 2) {
                            long jB3 = iVar.b();
                            int i23 = (kVar.e - 12) - 8;
                            x xVar5 = new x(i23);
                            iVar.readFully(xVar5.a, 0, i23);
                            int i24 = 0;
                            while (i24 < i23 / 12) {
                                xVar5.F(i7);
                                short sI = xVar5.i();
                                if (sI == 2192 || sI == 2816 || sI == 2817 || sI == s2 || sI == 2820) {
                                    kVar.c.add(new k$a(sI, (jB3 - ((long) kVar.e)) - ((long) xVar5.h()), xVar5.h()));
                                } else {
                                    xVar5.F(8);
                                }
                                i24++;
                                s2 = 2819;
                                i7 = 2;
                            }
                            if (kVar.c.isEmpty()) {
                                sVar.a = 0L;
                            } else {
                                kVar.d = 3;
                                sVar.a = kVar.c.get(0).a;
                            }
                        } else {
                            if (i22 != 3) {
                                throw new IllegalStateException();
                            }
                            long position6 = iVar.getPosition();
                            int iB3 = (int) ((iVar.b() - iVar.getPosition()) - ((long) kVar.e));
                            x xVar6 = new x(iB3);
                            iVar.readFully(xVar6.a, 0, iB3);
                            int i25 = 0;
                            while (i25 < kVar.c.size()) {
                                k$a k_a = kVar.c.get(i25);
                                List<Metadata$Entry> list2 = list;
                                xVar6.E((int) (k_a.a - position6));
                                xVar6.F(i6);
                                int iH = xVar6.h();
                                switch (xVar6.q(iH)) {
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
                                        throw ParserException.a("Invalid SEF name", null);
                                    }
                                    c = 2817;
                                }
                                int i26 = k_a.f1229b - (iH + 8);
                                if (c == 2192) {
                                    ArrayList arrayList = new ArrayList();
                                    List<String> listA = k.f1228b.a(xVar6.q(i26));
                                    for (int i27 = 0; i27 < listA.size(); i27++) {
                                        List<String> listA2 = k.a.a(listA.get(i27));
                                        if (listA2.size() != 3) {
                                            throw ParserException.a(null, null);
                                        }
                                        try {
                                            arrayList.add(new SlowMotionData$Segment(Long.parseLong(listA2.get(0)), Long.parseLong(listA2.get(1)), 1 << (Integer.parseInt(listA2.get(2)) - 1)));
                                        } catch (NumberFormatException e) {
                                            throw ParserException.a(null, e);
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
                            sVar.a = 0L;
                        }
                    } else {
                        byte[] bArr4 = new byte[8];
                        iVar.readFully(bArr4, 0, 8);
                        kVar.e = ((bArr4[0] & 255) | ((bArr4[1] & 255) << 8) | ((bArr4[2] & 255) << 16) | ((bArr4[3] & 255) << 24)) + 8;
                        if (((bArr4[7] & 255) | ((bArr4[5] & 255) << 16) | ((bArr4[4] & 255) << 24) | ((bArr4[6] & 255) << 8)) != 1397048916) {
                            sVar.a = 0L;
                        } else {
                            sVar.a = iVar.getPosition() - ((long) (kVar.e - 12));
                            kVar.d = 2;
                        }
                    }
                    if (sVar.a == 0) {
                        j();
                    }
                    return 1;
                }
                long j17 = this.l - ((long) this.m);
                long position7 = iVar.getPosition() + j17;
                x xVar7 = this.n;
                if (xVar7 != null) {
                    iVar.readFully(xVar7.a, this.m, (int) j17);
                    if (this.k == 1718909296) {
                        xVar7.E(8);
                        int iF2 = xVar7.f();
                        int i28 = iF2 != 1751476579 ? iF2 != 1903435808 ? 0 : 1 : 2;
                        if (i28 == 0) {
                            xVar7.F(4);
                            do {
                                if (xVar7.a() <= 0) {
                                    i28 = 0;
                                    break;
                                }
                                int iF3 = xVar7.f();
                                i28 = iF3 != 1751476579 ? iF3 != 1903435808 ? 0 : 1 : 2;
                            } while (i28 == 0);
                        }
                        this.f1224x = i28;
                    } else if (!this.g.isEmpty()) {
                        this.g.peek().c.add(new d$b(this.k, xVar7));
                    }
                } else {
                    if (j17 < Permission.USE_EXTERNAL_EMOJIS) {
                        iVar.l((int) j17);
                    } else {
                        sVar.a = iVar.getPosition() + j17;
                        z2 = true;
                    }
                    l(position7);
                    if (z2 || this.j == 2) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        return 1;
                    }
                }
                z2 = false;
                l(position7);
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

    @Override // b.i.a.c.x2.h
    public void f(b.i.a.c.x2.j jVar) {
        this.f1223s = jVar;
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        this.g.clear();
        this.m = 0;
        this.o = -1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        if (j == 0) {
            if (this.j != 3) {
                j();
                return;
            }
            k kVar = this.h;
            kVar.c.clear();
            kVar.d = 0;
            this.i.clear();
            return;
        }
        i$a[] i_aArr = this.t;
        if (i_aArr != null) {
            for (i$a i_a : i_aArr) {
                p pVar = i_a.f1226b;
                int iA = pVar.a(j2);
                if (iA == -1) {
                    iA = pVar.b(j2);
                }
                i_a.e = iA;
                b.i.a.c.x2.x xVar = i_a.d;
                if (xVar != null) {
                    xVar.f1300b = false;
                    xVar.c = 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.t
    public t$a h(long j) {
        long j2;
        long jK;
        long j3;
        long j4;
        int iB;
        long j5 = j;
        i$a[] i_aArr = this.t;
        Objects.requireNonNull(i_aArr);
        if (i_aArr.length == 0) {
            return new t$a(b.i.a.c.x2.u.a);
        }
        long j6 = -1;
        int i = this.v;
        if (i != -1) {
            p pVar = this.t[i].f1226b;
            int iA = pVar.a(j5);
            if (iA == -1) {
                iA = pVar.b(j5);
            }
            if (iA == -1) {
                return new t$a(b.i.a.c.x2.u.a);
            }
            long j7 = pVar.f[iA];
            j2 = pVar.c[iA];
            if (j7 >= j5 || iA >= pVar.f1233b - 1 || (iB = pVar.b(j5)) == -1 || iB == iA) {
                j4 = -9223372036854775807L;
            } else {
                long j8 = pVar.f[iB];
                long j9 = pVar.c[iB];
                j4 = j8;
                j6 = j9;
            }
            jK = j6;
            j3 = j4;
            j5 = j7;
        } else {
            j2 = RecyclerView.FOREVER_NS;
            jK = -1;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            i$a[] i_aArr2 = this.t;
            if (i2 >= i_aArr2.length) {
                break;
            }
            if (i2 != this.v) {
                p pVar2 = i_aArr2[i2].f1226b;
                long jK2 = k(pVar2, j5, j2);
                if (j3 != -9223372036854775807L) {
                    jK = k(pVar2, j3, jK);
                }
                j2 = jK2;
            }
            i2++;
        }
        b.i.a.c.x2.u uVar = new b.i.a.c.x2.u(j5, j2);
        return j3 == -9223372036854775807L ? new t$a(uVar) : new t$a(uVar, new b.i.a.c.x2.u(j3, jK));
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.w;
    }

    public final void j() {
        this.j = 0;
        this.m = 0;
    }

    /* JADX WARN: Code duplicated, block: B:155:0x02a8 A[Catch: all -> 0x022a, TryCatch #0 {all -> 0x022a, blocks: (B:38:0x00cb, B:40:0x00d1, B:42:0x00d6, B:45:0x00de, B:46:0x00e5, B:49:0x00f3, B:52:0x0100, B:55:0x010d, B:58:0x011d, B:61:0x012a, B:64:0x0135, B:67:0x0142, B:70:0x014e, B:73:0x015a, B:76:0x0166, B:79:0x0172, B:82:0x017e, B:85:0x018c, B:88:0x0199, B:91:0x01a5, B:96:0x01b7, B:98:0x01bb, B:100:0x01d0, B:103:0x01dd, B:107:0x01ec, B:115:0x01ff, B:153:0x0298, B:155:0x02a8, B:157:0x02b2, B:156:0x02ad, B:117:0x0219, B:119:0x0224, B:134:0x024a, B:137:0x0257, B:140:0x0263, B:143:0x026f, B:146:0x027b, B:149:0x0287, B:152:0x0291, B:159:0x02b7, B:160:0x02be), top: B:343:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:156:0x02ad A[Catch: all -> 0x022a, TryCatch #0 {all -> 0x022a, blocks: (B:38:0x00cb, B:40:0x00d1, B:42:0x00d6, B:45:0x00de, B:46:0x00e5, B:49:0x00f3, B:52:0x0100, B:55:0x010d, B:58:0x011d, B:61:0x012a, B:64:0x0135, B:67:0x0142, B:70:0x014e, B:73:0x015a, B:76:0x0166, B:79:0x0172, B:82:0x017e, B:85:0x018c, B:88:0x0199, B:91:0x01a5, B:96:0x01b7, B:98:0x01bb, B:100:0x01d0, B:103:0x01dd, B:107:0x01ec, B:115:0x01ff, B:153:0x0298, B:155:0x02a8, B:157:0x02b2, B:156:0x02ad, B:117:0x0219, B:119:0x0224, B:134:0x024a, B:137:0x0257, B:140:0x0263, B:143:0x026f, B:146:0x027b, B:149:0x0287, B:152:0x0291, B:159:0x02b7, B:160:0x02be), top: B:343:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:236:0x0494  */
    /* JADX WARN: Code duplicated, block: B:294:0x05ac  */
    /* JADX WARN: Code duplicated, block: B:43:0x00db  */
    public final void l(long j) throws ParserException {
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
        Id3Frame id3FrameD;
        String strValueOf;
        String str;
        String str2;
        while (!this.g.isEmpty() && this.g.peek().f1209b == j) {
            d$a d_aPop = this.g.pop();
            if (d_aPop.a == 1836019574) {
                ArrayList arrayList4 = new ArrayList();
                boolean z5 = this.f1224x == 1;
                b.i.a.c.x2.p pVar = new b.i.a.c.x2.p();
                d$b d_bC = d_aPop.c(1969517665);
                int i5 = 1768715124;
                int i6 = 1751411826;
                int i7 = 1835365473;
                int i8 = 4;
                int i9 = 8;
                Metadata metadata7 = null;
                if (d_bC != null) {
                    byte[] bArr = e.a;
                    x xVar = d_bC.f1210b;
                    xVar.E(8);
                    Metadata metadata8 = null;
                    String strO = null;
                    while (xVar.a() >= i9) {
                        int i10 = xVar.f984b;
                        int iF = xVar.f();
                        int i11 = i5;
                        int iF2 = xVar.f();
                        if (iF2 == i7) {
                            xVar.E(i10);
                            int i12 = i10 + iF;
                            xVar.F(i9);
                            int i13 = xVar.f984b;
                            xVar.F(i8);
                            if (xVar.f() != i6) {
                                i13 += 4;
                            }
                            xVar.E(i13);
                            int i14 = i11;
                            while (true) {
                                int i15 = xVar.f984b;
                                if (i15 < i12) {
                                    int iF3 = xVar.f();
                                    if (xVar.f() == i14) {
                                        xVar.E(i15);
                                        int i16 = i15 + iF3;
                                        xVar.F(i9);
                                        ArrayList arrayList5 = new ArrayList();
                                        while (true) {
                                            int i17 = xVar.f984b;
                                            if (i17 >= i16) {
                                                break;
                                            }
                                            int iF4 = xVar.f() + i17;
                                            int iF5 = xVar.f();
                                            int i18 = (iF5 >> 24) & 255;
                                            int i19 = i16;
                                            ArrayList arrayList6 = arrayList4;
                                            if (i18 == 169 || i18 == 253) {
                                                z4 = z5;
                                                int i20 = 16777215 & iF5;
                                                if (i20 == 6516084) {
                                                    id3FrameD = h.a(iF5, xVar);
                                                } else if (i20 == 7233901 || i20 == 7631467) {
                                                    id3FrameD = h.d(iF5, "TIT2", xVar);
                                                } else if (i20 == 6516589 || i20 == 7828084) {
                                                    id3FrameD = h.d(iF5, "TCOM", xVar);
                                                } else if (i20 == 6578553) {
                                                    id3FrameD = h.d(iF5, "TDRC", xVar);
                                                } else if (i20 == 4280916) {
                                                    id3FrameD = h.d(iF5, "TPE1", xVar);
                                                } else if (i20 == 7630703) {
                                                    id3FrameD = h.d(iF5, "TSSE", xVar);
                                                } else if (i20 == 6384738) {
                                                    id3FrameD = h.d(iF5, "TALB", xVar);
                                                } else if (i20 == 7108978) {
                                                    id3FrameD = h.d(iF5, "USLT", xVar);
                                                } else if (i20 == 6776174) {
                                                    id3FrameD = h.d(iF5, "TCON", xVar);
                                                } else if (i20 == 6779504) {
                                                    id3FrameD = h.d(iF5, "TIT1", xVar);
                                                } else {
                                                    strValueOf = String.valueOf(d.a(iF5));
                                                    if (strValueOf.length() != 0) {
                                                        str = "Skipped unknown metadata entry: ".concat(strValueOf);
                                                    } else {
                                                        str = new String("Skipped unknown metadata entry: ");
                                                    }
                                                    Log.d("MetadataUtil", str);
                                                    id3FrameD = null;
                                                }
                                            } else if (iF5 == 1735291493) {
                                                try {
                                                    int iF6 = h.f(xVar);
                                                    if (iF6 > 0) {
                                                        String[] strArr = h.a;
                                                        if (iF6 <= strArr.length) {
                                                            str2 = strArr[iF6 - 1];
                                                        } else {
                                                            str2 = strO;
                                                        }
                                                    } else {
                                                        str2 = strO;
                                                    }
                                                    if (str2 != null) {
                                                        id3FrameD = new TextInformationFrame("TCON", strO, str2);
                                                        z4 = z5;
                                                    } else {
                                                        Log.w("MetadataUtil", "Failed to parse standard genre code");
                                                        z4 = z5;
                                                        id3FrameD = null;
                                                    }
                                                } catch (Throwable th) {
                                                    xVar.E(iF4);
                                                    throw th;
                                                }
                                            } else {
                                                if (iF5 == 1684632427) {
                                                    id3FrameD = h.c(iF5, "TPOS", xVar);
                                                } else if (iF5 == 1953655662) {
                                                    id3FrameD = h.c(iF5, "TRCK", xVar);
                                                } else if (iF5 == 1953329263) {
                                                    id3FrameD = h.e(iF5, "TBPM", xVar, true, false);
                                                } else if (iF5 == 1668311404) {
                                                    id3FrameD = h.e(iF5, "TCMP", xVar, true, true);
                                                } else if (iF5 == 1668249202) {
                                                    id3FrameD = h.b(xVar);
                                                } else if (iF5 == 1631670868) {
                                                    id3FrameD = h.d(iF5, "TPE2", xVar);
                                                } else if (iF5 == 1936682605) {
                                                    id3FrameD = h.d(iF5, "TSOT", xVar);
                                                } else if (iF5 == 1936679276) {
                                                    id3FrameD = h.d(iF5, "TSO2", xVar);
                                                } else if (iF5 == 1936679282) {
                                                    id3FrameD = h.d(iF5, "TSOA", xVar);
                                                } else if (iF5 == 1936679265) {
                                                    id3FrameD = h.d(iF5, "TSOP", xVar);
                                                } else if (iF5 == 1936679791) {
                                                    id3FrameD = h.d(iF5, "TSOC", xVar);
                                                } else if (iF5 == 1920233063) {
                                                    id3FrameD = h.e(iF5, "ITUNESADVISORY", xVar, false, false);
                                                } else if (iF5 == 1885823344) {
                                                    id3FrameD = h.e(iF5, "ITUNESGAPLESS", xVar, false, true);
                                                } else if (iF5 == 1936683886) {
                                                    id3FrameD = h.d(iF5, "TVSHOWSORT", xVar);
                                                } else if (iF5 == 1953919848) {
                                                    id3FrameD = h.d(iF5, "TVSHOW", xVar);
                                                } else if (iF5 == 757935405) {
                                                    int i21 = -1;
                                                    int i22 = -1;
                                                    String strO2 = strO;
                                                    while (true) {
                                                        int i23 = xVar.f984b;
                                                        if (i23 >= iF4) {
                                                            break;
                                                        }
                                                        int iF7 = xVar.f();
                                                        int iF8 = xVar.f();
                                                        boolean z6 = z5;
                                                        xVar.F(4);
                                                        if (iF8 == 1835360622) {
                                                            strO = xVar.o(iF7 - 12);
                                                        } else if (iF8 == 1851878757) {
                                                            strO2 = xVar.o(iF7 - 12);
                                                        } else {
                                                            if (iF8 == 1684108385) {
                                                                i22 = iF7;
                                                                i21 = i23;
                                                            }
                                                            xVar.F(iF7 - 12);
                                                        }
                                                        z5 = z6;
                                                    }
                                                    z4 = z5;
                                                    if (strO == null || strO2 == null || i21 == -1) {
                                                        id3FrameD = null;
                                                    } else {
                                                        xVar.E(i21);
                                                        xVar.F(16);
                                                        id3FrameD = new InternalFrame(strO, strO2, xVar.o(i22 - 16));
                                                    }
                                                } else {
                                                    z4 = z5;
                                                    strValueOf = String.valueOf(d.a(iF5));
                                                    if (strValueOf.length() != 0) {
                                                        str = "Skipped unknown metadata entry: ".concat(strValueOf);
                                                    } else {
                                                        str = new String("Skipped unknown metadata entry: ");
                                                    }
                                                    Log.d("MetadataUtil", str);
                                                    id3FrameD = null;
                                                }
                                                z4 = z5;
                                            }
                                            xVar.E(iF4);
                                            if (id3FrameD != null) {
                                                arrayList5.add(id3FrameD);
                                            }
                                            strO = null;
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
                                    xVar.E(i15 + iF3);
                                    i9 = 8;
                                    i14 = 1768715124;
                                    strO = null;
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
                            if (iF2 == 1936553057) {
                                xVar.E(i10);
                                int i24 = i10 + iF;
                                xVar.F(12);
                                while (true) {
                                    int i25 = xVar.f984b;
                                    if (i25 < i24) {
                                        int iF9 = xVar.f();
                                        if (xVar.f() != 1935766900) {
                                            xVar.E(i25 + iF9);
                                        } else if (iF9 >= 14) {
                                            xVar.F(5);
                                            int iT = xVar.t();
                                            if (iT == 12 || iT == 13) {
                                                float f = iT == 12 ? 240.0f : 120.0f;
                                                xVar.F(1);
                                                metadata8 = new Metadata(new SmtaMetadataEntry(f, xVar.t()));
                                                break;
                                            }
                                        }
                                    }
                                    metadata8 = null;
                                    break;
                                }
                            }
                        }
                        xVar.E(i10 + iF);
                        i9 = 8;
                        i5 = 1768715124;
                        i6 = 1751411826;
                        i7 = 1835365473;
                        strO = null;
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
                        pVar.b(metadata2);
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
                d$a d_aB = d_aPop.b(i);
                if (d_aB != null) {
                    byte[] bArr2 = e.a;
                    d$b d_bC2 = d_aB.c(1751411826);
                    d$b d_bC3 = d_aB.c(1801812339);
                    d$b d_bC4 = d_aB.c(1768715124);
                    if (d_bC2 == null || d_bC3 == null || d_bC4 == null) {
                        metadata3 = metadata9;
                        metadata4 = null;
                    } else {
                        x xVar2 = d_bC2.f1210b;
                        xVar2.E(16);
                        if (xVar2.f() != 1835299937) {
                            metadata3 = metadata9;
                        } else {
                            x xVar3 = d_bC3.f1210b;
                            xVar3.E(12);
                            int iF10 = xVar3.f();
                            String[] strArr2 = new String[iF10];
                            for (int i26 = 0; i26 < iF10; i26++) {
                                int iF11 = xVar3.f();
                                xVar3.F(4);
                                strArr2[i26] = xVar3.q(iF11 - 8);
                            }
                            int i27 = 8;
                            x xVar4 = d_bC4.f1210b;
                            xVar4.E(8);
                            ArrayList arrayList7 = new ArrayList();
                            while (xVar4.a() > i27) {
                                int i28 = xVar4.f984b;
                                int iF12 = xVar4.f();
                                int iF13 = xVar4.f() - 1;
                                if (iF13 < 0 || iF13 >= iF10) {
                                    i4 = iF10;
                                    strArr2 = strArr2;
                                    metadata9 = metadata9;
                                    b.d.b.a.a.g0(52, "Skipped metadata with unknown key index: ", iF13, "AtomParsers");
                                } else {
                                    String str3 = strArr2[iF13];
                                    int i29 = i28 + iF12;
                                    while (true) {
                                        int i30 = xVar4.f984b;
                                        if (i30 >= i29) {
                                            i4 = iF10;
                                            mdtaMetadataEntry = null;
                                            break;
                                        }
                                        int iF14 = xVar4.f();
                                        i4 = iF10;
                                        if (xVar4.f() == 1684108385) {
                                            int iF15 = xVar4.f();
                                            int iF16 = xVar4.f();
                                            int i31 = iF14 - 16;
                                            byte[] bArr3 = new byte[i31];
                                            System.arraycopy(xVar4.a, xVar4.f984b, bArr3, 0, i31);
                                            xVar4.f984b += i31;
                                            mdtaMetadataEntry = new MdtaMetadataEntry(str3, bArr3, iF16, iF15);
                                            break;
                                        }
                                        xVar4.E(i30 + iF14);
                                        iF10 = i4;
                                    }
                                    if (mdtaMetadataEntry != null) {
                                        arrayList7.add(mdtaMetadataEntry);
                                    }
                                }
                                xVar4.E(i28 + iF12);
                                i27 = 8;
                                iF10 = i4;
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
                List<p> listE = e.e(d_aPop, pVar, -9223372036854775807L, null, (this.f1222b & 1) != 0, z2, a.a);
                b.i.a.c.x2.j jVar = this.f1223s;
                Objects.requireNonNull(jVar);
                ArrayList arrayList8 = (ArrayList) listE;
                int size = arrayList8.size();
                long jMax = -9223372036854775807L;
                long j2 = -9223372036854775807L;
                int i32 = 0;
                int size2 = -1;
                while (i32 < size) {
                    p pVar2 = (p) arrayList8.get(i32);
                    if (pVar2.f1233b == 0) {
                        metadata5 = metadata;
                        arrayList2 = arrayList;
                    } else {
                        m mVar = pVar2.a;
                        Metadata metadata11 = metadata10;
                        int i33 = size2;
                        long j3 = mVar.e;
                        if (j3 == j2) {
                            j3 = pVar2.h;
                        }
                        jMax = Math.max(jMax, j3);
                        i$a i_a = new i$a(mVar, pVar2, jVar.p(i32, mVar.f1230b));
                        int i34 = "audio/true-hd".equals(mVar.f.w) ? pVar2.e * 16 : pVar2.e + 30;
                        j1$b j1_bA = mVar.f.a();
                        j1_bA.l = i34;
                        int i35 = mVar.f1230b;
                        if (i35 == 2 && j3 > 0 && (i3 = pVar2.f1233b) > 1) {
                            j1_bA.r = i3 / (j3 / 1000000.0f);
                        }
                        if (i35 == 1) {
                            int i36 = pVar.f1294b;
                            if ((i36 == -1 || pVar.c == -1) ? false : true) {
                                j1_bA.A = i36;
                                j1_bA.B = pVar.c;
                            }
                        }
                        Metadata[] metadataArr = new Metadata[2];
                        metadataArr[0] = metadata;
                        metadataArr[1] = this.i.isEmpty() ? null : new Metadata(this.i);
                        Metadata metadata12 = new Metadata(new Metadata$Entry[0]);
                        if (i35 != 1) {
                            if (i35 == 2 && metadata11 != null) {
                                int i37 = 0;
                                metadata10 = metadata11;
                                while (true) {
                                    Metadata$Entry[] metadata$EntryArr = metadata10.j;
                                    if (i37 >= metadata$EntryArr.length) {
                                        metadata5 = metadata;
                                        break;
                                    }
                                    Metadata$Entry metadata$Entry = metadata$EntryArr[i37];
                                    if (metadata$Entry instanceof MdtaMetadataEntry) {
                                        MdtaMetadataEntry mdtaMetadataEntry2 = (MdtaMetadataEntry) metadata$Entry;
                                        metadata5 = metadata;
                                        if ("com.android.capture.fps".equals(mdtaMetadataEntry2.j)) {
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
                                metadata12 = metadata12.a(metadata13.j);
                            }
                        }
                        if (metadata12.j.length > 0) {
                            j1_bA.i = metadata12;
                        }
                        i_a.c.e(j1_bA.a());
                        if (mVar.f1230b == 2) {
                            i2 = i33;
                            if (i2 == -1) {
                                size2 = arrayList.size();
                            }
                            arrayList2 = arrayList;
                            arrayList2.add(i_a);
                        } else {
                            i2 = i33;
                        }
                        size2 = i2;
                        arrayList2 = arrayList;
                        arrayList2.add(i_a);
                    }
                    i32++;
                    j2 = -9223372036854775807L;
                    arrayList = arrayList2;
                    arrayList8 = arrayList8;
                    size = size;
                    metadata = metadata5;
                }
                long j4 = 0;
                this.v = size2;
                this.w = jMax;
                i$a[] i_aArr = (i$a[]) arrayList.toArray(new i$a[0]);
                this.t = i_aArr;
                long[][] jArr = new long[i_aArr.length][];
                int[] iArr = new int[i_aArr.length];
                long[] jArr2 = new long[i_aArr.length];
                boolean[] zArr = new boolean[i_aArr.length];
                for (int i39 = 0; i39 < i_aArr.length; i39++) {
                    jArr[i39] = new long[i_aArr[i39].f1226b.f1233b];
                    jArr2[i39] = i_aArr[i39].f1226b.f[0];
                }
                int i40 = 0;
                while (i40 < i_aArr.length) {
                    long j5 = RecyclerView.FOREVER_NS;
                    int i41 = -1;
                    for (int i42 = 0; i42 < i_aArr.length; i42++) {
                        if (!zArr[i42] && jArr2[i42] <= j5) {
                            j5 = jArr2[i42];
                            i41 = i42;
                        }
                    }
                    int i43 = iArr[i41];
                    jArr[i41][i43] = j4;
                    j4 += (long) i_aArr[i41].f1226b.d[i43];
                    int i44 = i43 + 1;
                    iArr[i41] = i44;
                    if (i44 < jArr[i41].length) {
                        jArr2[i41] = i_aArr[i41].f1226b.f[i44];
                    } else {
                        zArr[i41] = true;
                        i40++;
                    }
                }
                this.u = jArr;
                jVar.j();
                jVar.a(this);
                this.g.clear();
                this.j = 2;
            } else if (!this.g.isEmpty()) {
                this.g.peek().d.add(d_aPop);
            }
        }
        if (this.j != 2) {
            j();
        }
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
