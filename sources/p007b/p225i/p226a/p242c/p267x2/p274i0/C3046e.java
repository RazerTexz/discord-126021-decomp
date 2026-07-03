package p007b.p225i.p226a.p242c.p267x2.p274i0;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2753t;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p260g3.C2776m;
import p007b.p225i.p226a.p242c.p260g3.C2777n;
import p007b.p225i.p226a.p242c.p260g3.C2778o;
import p007b.p225i.p226a.p242c.p260g3.C2780q;
import p007b.p225i.p226a.p242c.p263t2.C2928l;
import p007b.p225i.p226a.p242c.p263t2.C2929m;
import p007b.p225i.p226a.p242c.p267x2.C3115p;
import p007b.p225i.p226a.p242c.p267x2.p274i0.AbstractC3045d;
import p007b.p225i.p355b.p356a.InterfaceC4485e;
import p007b.p225i.p355b.p357b.AbstractC4523p;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.e */
/* JADX INFO: compiled from: AtomParsers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3046e {

    /* JADX INFO: renamed from: a */
    public static final byte[] f8354a = C2738e0.m3015w("OpusHead");

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.e$a */
    /* JADX INFO: compiled from: AtomParsers.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        int mo3707a();

        /* JADX INFO: renamed from: b */
        int mo3708b();

        /* JADX INFO: renamed from: c */
        int mo3709c();
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.e$b */
    /* JADX INFO: compiled from: AtomParsers.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final C3055n[] f8355a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public C2811j1 f8356b;

        /* JADX INFO: renamed from: c */
        public int f8357c;

        /* JADX INFO: renamed from: d */
        public int f8358d = 0;

        public b(int i) {
            this.f8355a = new C3055n[i];
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.e$c */
    /* JADX INFO: compiled from: AtomParsers.java */
    public static final class c implements a {

        /* JADX INFO: renamed from: a */
        public final int f8359a;

        /* JADX INFO: renamed from: b */
        public final int f8360b;

        /* JADX INFO: renamed from: c */
        public final C2757x f8361c;

        public c(AbstractC3045d.b bVar, C2811j1 c2811j1) {
            C2757x c2757x = bVar.f8353b;
            this.f8361c = c2757x;
            c2757x.m3079E(12);
            int iM3103w = c2757x.m3103w();
            if ("audio/raw".equals(c2811j1.f7155w)) {
                int iM3011s = C2738e0.m3011s(c2811j1.f7138L, c2811j1.f7136J);
                if (iM3103w == 0 || iM3103w % iM3011s != 0) {
                    Log.w("AtomParsers", C1643a.m853h(88, "Audio sample size mismatch. stsd sample size: ", iM3011s, ", stsz sample size: ", iM3103w));
                    iM3103w = iM3011s;
                }
            }
            this.f8359a = iM3103w == 0 ? -1 : iM3103w;
            this.f8360b = c2757x.m3103w();
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.C3046e.a
        /* JADX INFO: renamed from: a */
        public int mo3707a() {
            return this.f8359a;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.C3046e.a
        /* JADX INFO: renamed from: b */
        public int mo3708b() {
            return this.f8360b;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.C3046e.a
        /* JADX INFO: renamed from: c */
        public int mo3709c() {
            int i = this.f8359a;
            return i == -1 ? this.f8361c.m3103w() : i;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.e$d */
    /* JADX INFO: compiled from: AtomParsers.java */
    public static final class d implements a {

        /* JADX INFO: renamed from: a */
        public final C2757x f8362a;

        /* JADX INFO: renamed from: b */
        public final int f8363b;

        /* JADX INFO: renamed from: c */
        public final int f8364c;

        /* JADX INFO: renamed from: d */
        public int f8365d;

        /* JADX INFO: renamed from: e */
        public int f8366e;

        public d(AbstractC3045d.b bVar) {
            C2757x c2757x = bVar.f8353b;
            this.f8362a = c2757x;
            c2757x.m3079E(12);
            this.f8364c = c2757x.m3103w() & 255;
            this.f8363b = c2757x.m3103w();
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.C3046e.a
        /* JADX INFO: renamed from: a */
        public int mo3707a() {
            return -1;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.C3046e.a
        /* JADX INFO: renamed from: b */
        public int mo3708b() {
            return this.f8363b;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.C3046e.a
        /* JADX INFO: renamed from: c */
        public int mo3709c() {
            int i = this.f8364c;
            if (i == 8) {
                return this.f8362a.m3100t();
            }
            if (i == 16) {
                return this.f8362a.m3105y();
            }
            int i2 = this.f8365d;
            this.f8365d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.f8366e & 15;
            }
            int iM3100t = this.f8362a.m3100t();
            this.f8366e = iM3100t;
            return (iM3100t & 240) >> 4;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Pair<String, byte[]> m3702a(C2757x c2757x, int i) {
        c2757x.m3079E(i + 8 + 4);
        c2757x.m3080F(1);
        m3703b(c2757x);
        c2757x.m3080F(2);
        int iM3100t = c2757x.m3100t();
        if ((iM3100t & 128) != 0) {
            c2757x.m3080F(2);
        }
        if ((iM3100t & 64) != 0) {
            c2757x.m3080F(c2757x.m3105y());
        }
        if ((iM3100t & 32) != 0) {
            c2757x.m3080F(2);
        }
        c2757x.m3080F(1);
        m3703b(c2757x);
        String strM3046d = C2753t.m3046d(c2757x.m3100t());
        if ("audio/mpeg".equals(strM3046d) || "audio/vnd.dts".equals(strM3046d) || "audio/vnd.dts.hd".equals(strM3046d)) {
            return Pair.create(strM3046d, null);
        }
        c2757x.m3080F(12);
        c2757x.m3080F(1);
        int iM3703b = m3703b(c2757x);
        byte[] bArr = new byte[iM3703b];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, iM3703b);
        c2757x.f6794b += iM3703b;
        return Pair.create(strM3046d, bArr);
    }

    /* JADX INFO: renamed from: b */
    public static int m3703b(C2757x c2757x) {
        int iM3100t = c2757x.m3100t();
        int i = iM3100t & Opcodes.LAND;
        while ((iM3100t & 128) == 128) {
            iM3100t = c2757x.m3100t();
            i = (i << 7) | (iM3100t & Opcodes.LAND);
        }
        return i;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public static Pair<Integer, C3055n> m3704c(C2757x c2757x, int i, int i2) throws ParserException {
        C3055n c3055n;
        Pair<Integer, C3055n> pairCreate;
        int i3;
        int i4;
        byte[] bArr;
        int i5 = c2757x.f6794b;
        while (i5 - i < i2) {
            c2757x.m3079E(i5);
            int iM3086f = c2757x.m3086f();
            int i6 = 1;
            C1460d.m559q(iM3086f > 0, "childAtomSize must be positive");
            if (c2757x.m3086f() == 1936289382) {
                int i7 = i5 + 8;
                int i8 = -1;
                int i9 = 0;
                String strM3097q = null;
                Integer numValueOf = null;
                while (i7 - i5 < iM3086f) {
                    c2757x.m3079E(i7);
                    int iM3086f2 = c2757x.m3086f();
                    int iM3086f3 = c2757x.m3086f();
                    if (iM3086f3 == 1718775137) {
                        numValueOf = Integer.valueOf(c2757x.m3086f());
                    } else if (iM3086f3 == 1935894637) {
                        c2757x.m3080F(4);
                        strM3097q = c2757x.m3097q(4);
                    } else if (iM3086f3 == 1935894633) {
                        i8 = i7;
                        i9 = iM3086f2;
                    }
                    i7 += iM3086f2;
                }
                if ("cenc".equals(strM3097q) || "cbc1".equals(strM3097q) || "cens".equals(strM3097q) || "cbcs".equals(strM3097q)) {
                    C1460d.m559q(numValueOf != null, "frma atom is mandatory");
                    C1460d.m559q(i8 != -1, "schi atom is mandatory");
                    int i10 = i8 + 8;
                    while (true) {
                        if (i10 - i8 >= i9) {
                            c3055n = null;
                            break;
                        }
                        c2757x.m3079E(i10);
                        int iM3086f4 = c2757x.m3086f();
                        if (c2757x.m3086f() == 1952804451) {
                            int iM3086f5 = (c2757x.m3086f() >> 24) & 255;
                            c2757x.m3080F(i6);
                            if (iM3086f5 == 0) {
                                c2757x.m3080F(i6);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int iM3100t = c2757x.m3100t();
                                int i11 = (iM3100t & 240) >> 4;
                                i3 = iM3100t & 15;
                                i4 = i11;
                            }
                            boolean z2 = c2757x.m3100t() == i6;
                            int iM3100t2 = c2757x.m3100t();
                            byte[] bArr2 = new byte[16];
                            System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr2, 0, 16);
                            c2757x.f6794b += 16;
                            if (z2 && iM3100t2 == 0) {
                                int iM3100t3 = c2757x.m3100t();
                                byte[] bArr3 = new byte[iM3100t3];
                                System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr3, 0, iM3100t3);
                                c2757x.f6794b += iM3100t3;
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            c3055n = new C3055n(z2, strM3097q, iM3100t2, bArr2, i4, i3, bArr);
                            break;
                        }
                        i10 += iM3086f4;
                        i6 = 1;
                    }
                    C1460d.m559q(c3055n != null, "tenc atom is mandatory");
                    int i12 = C2738e0.f6708a;
                    pairCreate = Pair.create(numValueOf, c3055n);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            i5 += iM3086f;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:232:0x0374  */
    /* JADX WARN: Code duplicated, block: B:234:0x037d  */
    /* JADX WARN: Code duplicated, block: B:235:0x0383  */
    /* JADX WARN: Code duplicated, block: B:238:0x0396  */
    /* JADX WARN: Code duplicated, block: B:239:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:241:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:247:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:249:0x0409  */
    /* JADX WARN: Code duplicated, block: B:251:0x0424  */
    /* JADX WARN: Code duplicated, block: B:253:0x0429  */
    /* JADX WARN: Code duplicated, block: B:255:0x0452  */
    /* JADX WARN: Code duplicated, block: B:266:0x0479  */
    /* JADX WARN: Code duplicated, block: B:268:0x0493  */
    /* JADX WARN: Code duplicated, block: B:270:0x0498  */
    /* JADX WARN: Code duplicated, block: B:272:0x04af  */
    /* JADX WARN: Code duplicated, block: B:273:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:277:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:279:0x04d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:280:0x04db  */
    /* JADX WARN: Code duplicated, block: B:283:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:285:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:286:0x050a  */
    /* JADX WARN: Code duplicated, block: B:288:0x0511  */
    /* JADX WARN: Code duplicated, block: B:290:0x0531  */
    /* JADX WARN: Code duplicated, block: B:292:0x0536  */
    /* JADX WARN: Code duplicated, block: B:293:0x0569  */
    /* JADX WARN: Code duplicated, block: B:295:0x0570  */
    /* JADX WARN: Code duplicated, block: B:297:0x05c3 A[PHI: r6 r26
      0x05c3: PHI (r6v42 int) = (r6v18 int), (r6v44 int) binds: [B:294:0x056e, B:276:0x04d0] A[DONT_GENERATE, DONT_INLINE]
      0x05c3: PHI (r26v22 java.lang.String) = (r26v17 java.lang.String), (r26v23 java.lang.String) binds: [B:294:0x056e, B:276:0x04d0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:299:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:301:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:302:0x05df  */
    /* JADX WARN: Code duplicated, block: B:304:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:305:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:309:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:311:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:312:0x05fb  */
    /* JADX WARN: Code duplicated, block: B:316:0x060e A[LOOP:2: B:307:0x05ea->B:316:0x060e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:319:0x061e  */
    /* JADX WARN: Code duplicated, block: B:321:0x062d  */
    /* JADX WARN: Code duplicated, block: B:323:0x0635  */
    /* JADX WARN: Code duplicated, block: B:324:0x0646  */
    /* JADX WARN: Code duplicated, block: B:515:0x04e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:524:0x0616 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:525:0x060c A[SYNTHETIC] */
    /* JADX INFO: renamed from: d */
    public static b m3705d(C2757x c2757x, int i, int i2, String str, @Nullable DrmInitData drmInitData, boolean z2) throws ParserException {
        int i3;
        int i4;
        int i5;
        DrmInitData drmInitDataM8835a;
        String str2;
        byte[] bArr;
        int i6;
        int i7;
        int i8;
        int i9;
        b bVar;
        float f;
        List<byte[]> listM6266u;
        int i10;
        List<byte[]> list;
        String str3;
        int iM3105y;
        int iRound;
        int iM3103w;
        int i11;
        int i12;
        int i13;
        DrmInitData drmInitDataM8835a2;
        String str4;
        int i14;
        int i15;
        int iIntValue;
        String str5;
        int i16;
        String str6;
        List<byte[]> listM6266u2;
        int i17;
        int i18;
        int iM3086f;
        boolean z3;
        int iM3086f2;
        int i19;
        int i20;
        String str7;
        int i21;
        int i22;
        int i23;
        List<byte[]> listM519g;
        int i24;
        boolean z4;
        int i25;
        int iM3086f3;
        boolean z5;
        byte[] bArr2;
        String str8;
        int iIntValue2;
        AbstractC4523p abstractC4523pM6266u;
        int i26;
        int iM3100t;
        int i27;
        String str9;
        int iM3100t2;
        int i28;
        AbstractC4523p abstractC4523pM6266u2;
        String str10;
        c2757x.m3079E(12);
        int iM3086f4 = c2757x.m3086f();
        b bVar2 = new b(iM3086f4);
        int i29 = 0;
        while (i29 < iM3086f4) {
            int i30 = c2757x.f6794b;
            int iM3086f5 = c2757x.m3086f();
            String str11 = "childAtomSize must be positive";
            C1460d.m559q(iM3086f5 > 0, "childAtomSize must be positive");
            int iM3086f6 = c2757x.m3086f();
            if (iM3086f6 == 1635148593 || iM3086f6 == 1635148595 || iM3086f6 == 1701733238 || iM3086f6 == 1831958048 || iM3086f6 == 1836070006 || iM3086f6 == 1752589105 || iM3086f6 == 1751479857 || iM3086f6 == 1932670515 || iM3086f6 == 1211250227 || iM3086f6 == 1987063864 || iM3086f6 == 1987063865 || iM3086f6 == 1635135537 || iM3086f6 == 1685479798 || iM3086f6 == 1685479729 || iM3086f6 == 1685481573 || iM3086f6 == 1685481521) {
                iM3086f4 = iM3086f4;
                i3 = i29;
                c2757x.m3079E(i30 + 8 + 8);
                c2757x.m3080F(16);
                int iM3105y2 = c2757x.m3105y();
                int iM3105y3 = c2757x.m3105y();
                c2757x.m3080F(50);
                int i31 = c2757x.f6794b;
                if (iM3086f6 == 1701733238) {
                    Pair<Integer, C3055n> pairM3704c = m3704c(c2757x, i4, i5);
                    if (pairM3704c != null) {
                        iM3086f6 = ((Integer) pairM3704c.first).intValue();
                        if (drmInitData == null) {
                            i4 = i30;
                            i5 = iM3086f5;
                            drmInitDataM8835a = null;
                        } else {
                            i4 = i30;
                            i5 = iM3086f5;
                            drmInitDataM8835a = drmInitData.m8835a(((C3055n) pairM3704c.second).f8472b);
                        }
                        bVar2.f8355a[i3] = (C3055n) pairM3704c.second;
                    } else {
                        i4 = i30;
                        i5 = iM3086f5;
                        drmInitDataM8835a = drmInitData;
                    }
                    c2757x.m3079E(i31);
                } else {
                    i4 = i30;
                    i5 = iM3086f5;
                    drmInitDataM8835a = drmInitData;
                }
                if (iM3086f6 == 1831958048) {
                    str2 = "video/mpeg";
                } else {
                    str2 = iM3086f6 == 1211250227 ? "video/3gpp" : null;
                }
                float fM3103w = 1.0f;
                ByteBuffer byteBufferOrder = null;
                boolean z6 = false;
                DrmInitData drmInitData2 = drmInitDataM8835a;
                byte[] bArrCopyOfRange = null;
                String str12 = null;
                List<byte[]> list2 = null;
                int iM3124b = -1;
                int i32 = -1;
                int i33 = -1;
                int i34 = -1;
                while (true) {
                    if (i31 - i4 >= i5) {
                        bArr = bArrCopyOfRange;
                        i6 = i34;
                        break;
                    }
                    c2757x.m3079E(i31);
                    int i35 = c2757x.f6794b;
                    i6 = i34;
                    int iM3086f7 = c2757x.m3086f();
                    bArr = bArrCopyOfRange;
                    if (iM3086f7 == 0 && c2757x.f6794b - i4 == i5) {
                        break;
                    }
                    C1460d.m559q(iM3086f7 > 0, str11);
                    int iM3086f8 = c2757x.m3086f();
                    String str13 = str11;
                    if (iM3086f8 == 1635148611) {
                        C1460d.m559q(str2 == null, null);
                        c2757x.m3079E(i35 + 8);
                        C2776m c2776mM3122b = C2776m.m3122b(c2757x);
                        list = c2776mM3122b.f6837a;
                        bVar2.f8357c = c2776mM3122b.f6838b;
                        if (!z6) {
                            fM3103w = c2776mM3122b.f6841e;
                        }
                        str12 = c2776mM3122b.f6842f;
                        str3 = "video/avc";
                    } else if (iM3086f8 == 1752589123) {
                        C1460d.m559q(str2 == null, null);
                        c2757x.m3079E(i35 + 8);
                        C2780q c2780qM3131a = C2780q.m3131a(c2757x);
                        list = c2780qM3131a.f6863a;
                        bVar2.f8357c = c2780qM3131a.f6864b;
                        if (!z6) {
                            fM3103w = c2780qM3131a.f6865c;
                        }
                        str12 = c2780qM3131a.f6866d;
                        str3 = "video/hevc";
                    } else {
                        if (iM3086f8 == 1685480259 || iM3086f8 == 1685485123) {
                            iM3105y2 = iM3105y2;
                            iM3105y3 = iM3105y3;
                            bVar2 = bVar2;
                            i4 = i4;
                            i5 = i5;
                            iM3086f6 = iM3086f6;
                            f = fM3103w;
                            C2778o c2778oM3126a = C2778o.m3126a(c2757x);
                            if (c2778oM3126a != null) {
                                str2 = "video/dolby-vision";
                                str12 = c2778oM3126a.f6849a;
                            }
                        } else {
                            if (iM3086f8 == 1987076931) {
                                C1460d.m559q(str2 == null, null);
                                str3 = iM3086f6 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                list = list2;
                            } else {
                                if (iM3086f8 == 1635135811) {
                                    C1460d.m559q(str2 == null, null);
                                    str2 = "video/av01";
                                } else if (iM3086f8 == 1668050025) {
                                    if (byteBufferOrder == null) {
                                        byteBufferOrder = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                    }
                                    ByteBuffer byteBuffer = byteBufferOrder;
                                    byteBuffer.position(21);
                                    byteBuffer.putShort(c2757x.m3096p());
                                    byteBuffer.putShort(c2757x.m3096p());
                                    byteBufferOrder = byteBuffer;
                                } else if (iM3086f8 == 1835295606) {
                                    if (byteBufferOrder == null) {
                                        byteBufferOrder = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                    }
                                    ByteBuffer byteBuffer2 = byteBufferOrder;
                                    short sM3096p = c2757x.m3096p();
                                    short sM3096p2 = c2757x.m3096p();
                                    short sM3096p3 = c2757x.m3096p();
                                    short sM3096p4 = c2757x.m3096p();
                                    short sM3096p5 = c2757x.m3096p();
                                    short sM3096p6 = c2757x.m3096p();
                                    float f2 = fM3103w;
                                    short sM3096p7 = c2757x.m3096p();
                                    short sM3096p8 = c2757x.m3096p();
                                    long jM3101u = c2757x.m3101u();
                                    long jM3101u2 = c2757x.m3101u();
                                    byteBuffer2.position(1);
                                    byteBuffer2.putShort(sM3096p5);
                                    byteBuffer2.putShort(sM3096p6);
                                    byteBuffer2.putShort(sM3096p);
                                    byteBuffer2.putShort(sM3096p2);
                                    byteBuffer2.putShort(sM3096p3);
                                    byteBuffer2.putShort(sM3096p4);
                                    byteBuffer2.putShort(sM3096p7);
                                    byteBuffer2.putShort(sM3096p8);
                                    byteBuffer2.putShort((short) (jM3101u / 10000));
                                    byteBuffer2.putShort((short) (jM3101u2 / 10000));
                                    byteBufferOrder = byteBuffer2;
                                    list = list2;
                                    fM3103w = f2;
                                    list2 = list;
                                    bArrCopyOfRange = bArr;
                                } else {
                                    iM3105y2 = iM3105y2;
                                    iM3105y3 = iM3105y3;
                                    bVar2 = bVar2;
                                    i4 = i4;
                                    i5 = i5;
                                    iM3086f6 = iM3086f6;
                                    f = fM3103w;
                                    if (iM3086f8 == 1681012275) {
                                        C1460d.m559q(str2 == null, null);
                                        str2 = "video/3gpp";
                                    } else if (iM3086f8 == 1702061171) {
                                        C1460d.m559q(str2 == null, null);
                                        Pair<String, byte[]> pairM3702a = m3702a(c2757x, i35);
                                        str2 = (String) pairM3702a.first;
                                        byte[] bArr3 = (byte[]) pairM3702a.second;
                                        listM6266u = bArr3 != null ? AbstractC4523p.m6266u(bArr3) : list2;
                                        bArrCopyOfRange = bArr;
                                        list2 = listM6266u;
                                        fM3103w = f;
                                    } else if (iM3086f8 == 1885434736) {
                                        c2757x.m3079E(i35 + 8);
                                        fM3103w = c2757x.m3103w() / c2757x.m3103w();
                                        bArrCopyOfRange = bArr;
                                        z6 = true;
                                    } else {
                                        if (iM3086f8 == 1937126244) {
                                            int i36 = i35 + 8;
                                            while (true) {
                                                if (i36 - i35 >= iM3086f7) {
                                                    bArrCopyOfRange = null;
                                                    break;
                                                }
                                                c2757x.m3079E(i36);
                                                int iM3086f9 = c2757x.m3086f();
                                                if (c2757x.m3086f() == 1886547818) {
                                                    bArrCopyOfRange = Arrays.copyOfRange(c2757x.f6793a, i36, iM3086f9 + i36);
                                                    break;
                                                }
                                                i36 += iM3086f9;
                                            }
                                            listM6266u = list2;
                                        } else if (iM3086f8 == 1936995172) {
                                            int iM3100t3 = c2757x.m3100t();
                                            c2757x.m3080F(3);
                                            if (iM3100t3 == 0) {
                                                int iM3100t4 = c2757x.m3100t();
                                                if (iM3100t4 == 0) {
                                                    i10 = 0;
                                                } else if (iM3100t4 == 1) {
                                                    i10 = 1;
                                                } else if (iM3100t4 == 2) {
                                                    i10 = 2;
                                                } else if (iM3100t4 == 3) {
                                                    i10 = 3;
                                                }
                                            }
                                            i6 = i10;
                                            bArrCopyOfRange = bArr;
                                        } else if (iM3086f8 == 1668246642) {
                                            int iM3086f10 = c2757x.m3086f();
                                            if (iM3086f10 == 1852009592 || iM3086f10 == 1852009571) {
                                                int iM3105y4 = c2757x.m3105y();
                                                int iM3105y5 = c2757x.m3105y();
                                                c2757x.m3080F(2);
                                                boolean z7 = iM3086f7 == 19 && (c2757x.m3100t() & 128) != 0;
                                                int iM3123a = C2777n.m3123a(iM3105y4);
                                                int i37 = z7 ? 1 : 2;
                                                i33 = iM3123a;
                                                iM3124b = C2777n.m3124b(iM3105y5);
                                                i32 = i37;
                                            } else {
                                                String strValueOf = String.valueOf(AbstractC3045d.m3699a(iM3086f10));
                                                Log.w("AtomParsers", strValueOf.length() != 0 ? "Unsupported color type: ".concat(strValueOf) : new String("Unsupported color type: "));
                                            }
                                        }
                                        list2 = listM6266u;
                                        fM3103w = f;
                                    }
                                }
                                list = list2;
                                list2 = list;
                                bArrCopyOfRange = bArr;
                            }
                            i31 += iM3086f7;
                            i34 = i6;
                            str11 = str13;
                            iM3086f6 = iM3086f6;
                            i4 = i4;
                            i5 = i5;
                            bVar2 = bVar2;
                            iM3105y3 = iM3105y3;
                            iM3105y2 = iM3105y2;
                        }
                        i10 = i6;
                        i6 = i10;
                        bArrCopyOfRange = bArr;
                        list2 = listM6266u;
                        fM3103w = f;
                        i31 += iM3086f7;
                        i34 = i6;
                        str11 = str13;
                        iM3086f6 = iM3086f6;
                        i4 = i4;
                        i5 = i5;
                        bVar2 = bVar2;
                        iM3105y3 = iM3105y3;
                        iM3105y2 = iM3105y2;
                    }
                    str2 = str3;
                    list2 = list;
                    bArrCopyOfRange = bArr;
                    i31 += iM3086f7;
                    i34 = i6;
                    str11 = str13;
                    iM3086f6 = iM3086f6;
                    i4 = i4;
                    i5 = i5;
                    bVar2 = bVar2;
                    iM3105y3 = iM3105y3;
                    iM3105y2 = iM3105y2;
                }
                float f3 = fM3103w;
                if (str2 == null) {
                    bVar = bVar2;
                } else {
                    C2811j1.b bVar3 = new C2811j1.b();
                    bVar3.m3278b(i);
                    bVar3.f7173k = str2;
                    bVar3.f7170h = str12;
                    bVar3.f7178p = iM3105y2;
                    bVar3.f7179q = i7;
                    bVar3.f7182t = f3;
                    bVar3.f7181s = i2;
                    bVar3.f7183u = bArr;
                    bVar3.f7184v = i6;
                    bVar3.f7175m = list2;
                    bVar3.f7176n = drmInitData2;
                    int i38 = i33;
                    if (i38 == -1) {
                        i9 = i32;
                        i8 = iM3124b;
                        if (i9 != -1 || i8 != -1 || byteBufferOrder != null) {
                        }
                        C2811j1 c2811j1M3277a = bVar3.m3277a();
                        bVar = bVar2;
                        bVar.f8356b = c2811j1M3277a;
                    } else {
                        i7 = iM3105y3;
                        i8 = iM3124b;
                        i9 = i32;
                    }
                    i7 = iM3105y3;
                    bVar3.f7185w = new C2777n(i38, i9, i8, byteBufferOrder != null ? byteBufferOrder.array() : null);
                    C2811j1 c2811j1M3277a2 = bVar3.m3277a();
                    bVar = bVar2;
                    bVar.f8356b = c2811j1M3277a2;
                }
            } else if (iM3086f6 == 1836069985 || iM3086f6 == 1701733217 || iM3086f6 == 1633889587 || iM3086f6 == 1700998451 || iM3086f6 == 1633889588 || iM3086f6 == 1835823201 || iM3086f6 == 1685353315 || iM3086f6 == 1685353317 || iM3086f6 == 1685353320 || iM3086f6 == 1685353324 || iM3086f6 == 1685353336 || iM3086f6 == 1935764850 || iM3086f6 == 1935767394 || iM3086f6 == 1819304813 || iM3086f6 == 1936684916 || iM3086f6 == 1953984371 || iM3086f6 == 778924082 || iM3086f6 == 778924083 || iM3086f6 == 1835557169 || iM3086f6 == 1835560241 || iM3086f6 == 1634492771 || iM3086f6 == 1634492791 || iM3086f6 == 1970037111 || iM3086f6 == 1332770163 || iM3086f6 == 1716281667) {
                c2757x.m3079E(i30 + 8 + 8);
                if (z2) {
                    iM3105y = c2757x.m3105y();
                    c2757x.m3080F(6);
                } else {
                    c2757x.m3080F(8);
                    iM3105y = 0;
                }
                if (iM3105y == 0 || iM3105y == 1) {
                    int iM3105y6 = c2757x.m3105y();
                    c2757x.m3080F(6);
                    byte[] bArr4 = c2757x.f6793a;
                    int i39 = c2757x.f6794b;
                    int i40 = i39 + 1;
                    c2757x.f6794b = i40;
                    int i41 = (bArr4[i39] & 255) << 8;
                    int i42 = i40 + 1;
                    c2757x.f6794b = i42;
                    iRound = (bArr4[i40] & 255) | i41;
                    int i43 = i42 + 2;
                    c2757x.f6794b = i43;
                    c2757x.m3079E(i43 - 4);
                    int iM3086f11 = c2757x.m3086f();
                    if (iM3105y == 1) {
                        c2757x.m3080F(16);
                    }
                    iM3103w = iM3105y6;
                    i11 = iM3086f11;
                } else {
                    if (iM3105y == 2) {
                        c2757x.m3080F(16);
                        iRound = (int) Math.round(Double.longBitsToDouble(c2757x.m3093m()));
                        iM3103w = c2757x.m3103w();
                        c2757x.m3080F(20);
                        i11 = 0;
                    } else {
                        iM3086f4 = iM3086f4;
                        i3 = i29;
                        i13 = i30;
                        i12 = iM3086f5;
                    }
                    bVar = bVar2;
                    i4 = i13;
                    i5 = i12;
                }
                int i44 = c2757x.f6794b;
                if (iM3086f6 == 1701733217) {
                    Pair<Integer, C3055n> pairM3704c2 = m3704c(c2757x, i30, iM3086f5);
                    if (pairM3704c2 != null) {
                        int iIntValue3 = ((Integer) pairM3704c2.first).intValue();
                        drmInitDataM8835a2 = drmInitData == 0 ? null : drmInitData.m8835a(((C3055n) pairM3704c2.second).f8472b);
                        bVar2.f8355a[i29] = (C3055n) pairM3704c2.second;
                        iM3086f6 = iIntValue3;
                    } else {
                        drmInitDataM8835a2 = drmInitData;
                    }
                    c2757x.m3079E(i44);
                } else {
                    drmInitDataM8835a2 = drmInitData;
                }
                String str14 = "audio/ac3";
                String str15 = "audio/raw";
                int i45 = iM3103w;
                if (iM3086f6 == 1633889587) {
                    str15 = "audio/ac3";
                } else if (iM3086f6 == 1700998451) {
                    str15 = "audio/eac3";
                } else if (iM3086f6 == 1633889588) {
                    str15 = "audio/ac4";
                } else {
                    if (iM3086f6 == 1685353315) {
                        str4 = "audio/vnd.dts";
                    } else if (iM3086f6 == 1685353320 || iM3086f6 == 1685353324) {
                        str4 = "audio/vnd.dts.hd";
                    } else if (iM3086f6 == 1685353317) {
                        str4 = "audio/vnd.dts.hd;profile=lbr";
                    } else if (iM3086f6 == 1685353336) {
                        str4 = "audio/vnd.dts.uhd;profile=p2";
                    } else if (iM3086f6 == 1935764850) {
                        str4 = "audio/3gpp";
                    } else if (iM3086f6 == 1935767394) {
                        str4 = "audio/amr-wb";
                    } else {
                        if (iM3086f6 == 1819304813 || iM3086f6 == 1936684916) {
                            i14 = 2;
                        } else if (iM3086f6 == 1953984371) {
                            i14 = 268435456;
                        } else if (iM3086f6 == 778924082 || iM3086f6 == 778924083) {
                            str4 = "audio/mpeg";
                        } else if (iM3086f6 == 1835557169) {
                            str4 = "audio/mha1";
                        } else if (iM3086f6 == 1835560241) {
                            str4 = "audio/mhm1";
                        } else if (iM3086f6 == 1634492771) {
                            str4 = "audio/alac";
                        } else if (iM3086f6 == 1634492791) {
                            str4 = "audio/g711-alaw";
                        } else if (iM3086f6 == 1970037111) {
                            str4 = "audio/g711-mlaw";
                        } else if (iM3086f6 == 1332770163) {
                            str4 = "audio/opus";
                        } else if (iM3086f6 == 1716281667) {
                            str4 = "audio/flac";
                        } else if (iM3086f6 == 1835823201) {
                            str4 = "audio/true-hd";
                        } else {
                            i14 = -1;
                            str15 = null;
                        }
                        i15 = iRound;
                        iIntValue = i45;
                        str5 = null;
                        i3 = i29;
                        String str16 = str15;
                        i16 = i14;
                        str6 = str16;
                        listM6266u2 = null;
                        i17 = i44;
                        while (i17 - i30 < iM3086f5) {
                            c2757x.m3079E(i17);
                            iM3086f = c2757x.m3086f();
                            if (iM3086f > 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            C1460d.m559q(z3, str11);
                            iM3086f2 = c2757x.m3086f();
                            int i46 = i30;
                            if (iM3086f2 == 1835557187) {
                                int i47 = iM3086f - 13;
                                byte[] bArr5 = new byte[i47];
                                c2757x.m3079E(i17 + 13);
                                System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr5, 0, i47);
                                c2757x.f6794b += i47;
                                listM6266u2 = AbstractC4523p.m6266u(bArr5);
                                str11 = str11;
                                i23 = iM3086f;
                                i15 = i15;
                                str14 = str14;
                                i22 = i11;
                            } else {
                                i19 = i15;
                                i20 = iM3086f;
                                str7 = str11;
                                if (iM3086f2 != 1702061171) {
                                    if (z2 || iM3086f2 != 2002876005) {
                                        if (iM3086f2 == 1684103987) {
                                            c2757x.m3079E(i17 + 8);
                                            String string = Integer.toString(i);
                                            int i48 = C2929m.f7770b[(c2757x.m3100t() & Opcodes.CHECKCAST) >> 6];
                                            iM3100t2 = c2757x.m3100t();
                                            i28 = C2929m.f7772d[(iM3100t2 & 56) >> 3];
                                            if ((iM3100t2 & 4) != 0) {
                                                i28++;
                                            }
                                            C2811j1.b bVar4 = new C2811j1.b();
                                            bVar4.f7163a = string;
                                            bVar4.f7173k = str14;
                                            bVar4.f7186x = i28;
                                            bVar4.f7187y = i48;
                                            bVar4.f7176n = drmInitDataM8835a2;
                                            bVar4.f7165c = str;
                                            bVar2.f8356b = bVar4.m3277a();
                                        } else if (iM3086f2 == 1684366131) {
                                            c2757x.m3079E(i17 + 8);
                                            String string2 = Integer.toString(i);
                                            c2757x.m3080F(2);
                                            int i49 = C2929m.f7770b[(c2757x.m3100t() & Opcodes.CHECKCAST) >> 6];
                                            iM3100t = c2757x.m3100t();
                                            i27 = C2929m.f7772d[(iM3100t & 14) >> 1];
                                            if ((iM3100t & 1) != 0) {
                                                i27++;
                                            }
                                            if (((c2757x.m3100t() & 30) >> 1) > 0 && (c2757x.m3100t() & 2) != 0) {
                                                i27 += 2;
                                            }
                                            if (c2757x.m3081a() > 0 || (c2757x.m3100t() & 1) == 0) {
                                                str9 = "audio/eac3";
                                            } else {
                                                str9 = "audio/eac3-joc";
                                            }
                                            C2811j1.b bVar5 = new C2811j1.b();
                                            bVar5.f7163a = string2;
                                            bVar5.f7173k = str9;
                                            bVar5.f7186x = i27;
                                            bVar5.f7187y = i49;
                                            bVar5.f7176n = drmInitDataM8835a2;
                                            bVar5.f7165c = str;
                                            bVar2.f8356b = bVar5.m3277a();
                                        } else {
                                            if (iM3086f2 == 1684103988) {
                                                c2757x.m3079E(i17 + 8);
                                                String string3 = Integer.toString(i);
                                                c2757x.m3080F(1);
                                                if (((c2757x.m3100t() & 32) >> 5) == 1) {
                                                    i26 = 48000;
                                                } else {
                                                    i26 = 44100;
                                                }
                                                C2811j1.b bVar6 = new C2811j1.b();
                                                bVar6.f7163a = string3;
                                                bVar6.f7173k = "audio/ac4";
                                                bVar6.f7186x = 2;
                                                bVar6.f7187y = i26;
                                                bVar6.f7176n = drmInitDataM8835a2;
                                                bVar6.f7165c = str;
                                                bVar2.f8356b = bVar6.m3277a();
                                            } else {
                                                if (iM3086f2 == 1684892784) {
                                                    if (i11 > 0) {
                                                        throw C1643a.m884w0(60, "Invalid sample rate for Dolby TrueHD MLP stream: ", i11, null);
                                                    }
                                                    iIntValue = 2;
                                                    i15 = i11;
                                                    listM519g = listM6266u2;
                                                } else if (iM3086f2 == 1684305011) {
                                                    C2811j1.b bVar7 = new C2811j1.b();
                                                    bVar7.m3278b(i);
                                                    bVar7.f7173k = str6;
                                                    bVar7.f7186x = iIntValue;
                                                    iIntValue2 = i19;
                                                    bVar7.f7187y = iIntValue2;
                                                    bVar7.f7176n = drmInitDataM8835a2;
                                                    bVar7.f7165c = str;
                                                    bVar2.f8356b = bVar7.m3277a();
                                                    str14 = str14;
                                                    i15 = iIntValue2;
                                                    listM519g = listM6266u2;
                                                } else {
                                                    iIntValue2 = i19;
                                                    if (iM3086f2 == 1682927731) {
                                                        int i50 = i20 - 8;
                                                        byte[] bArr6 = f8354a;
                                                        byte[] bArrCopyOf = Arrays.copyOf(bArr6, bArr6.length + i50);
                                                        c2757x.m3079E(i17 + 8);
                                                        c2757x.m3085e(bArrCopyOf, bArr6.length, i50);
                                                        listM519g = C1460d.m519g(bArrCopyOf);
                                                        i15 = iIntValue2;
                                                    } else {
                                                        if (iM3086f2 == 1684425825) {
                                                            int i51 = i20 - 12;
                                                            byte[] bArr7 = new byte[i51 + 4];
                                                            bArr7[0] = 102;
                                                            bArr7[1] = 76;
                                                            bArr7[2] = 97;
                                                            bArr7[3] = 67;
                                                            c2757x.m3079E(i17 + 12);
                                                            str14 = str14;
                                                            System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr7, 4, i51);
                                                            c2757x.f6794b += i51;
                                                            abstractC4523pM6266u = AbstractC4523p.m6266u(bArr7);
                                                        } else {
                                                            str14 = str14;
                                                            if (iM3086f2 == 1634492771) {
                                                                int i52 = i20 - 12;
                                                                byte[] bArr8 = new byte[i52];
                                                                c2757x.m3079E(i17 + 12);
                                                                System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr8, 0, i52);
                                                                c2757x.f6794b += i52;
                                                                C2757x c2757x2 = new C2757x(bArr8);
                                                                c2757x2.m3079E(9);
                                                                int iM3100t5 = c2757x2.m3100t();
                                                                c2757x2.m3079E(20);
                                                                Pair pairCreate = Pair.create(Integer.valueOf(c2757x2.m3103w()), Integer.valueOf(iM3100t5));
                                                                iIntValue2 = ((Integer) pairCreate.first).intValue();
                                                                iIntValue = ((Integer) pairCreate.second).intValue();
                                                                abstractC4523pM6266u = AbstractC4523p.m6266u(bArr8);
                                                            } else {
                                                                i15 = iIntValue2;
                                                                listM519g = listM6266u2;
                                                            }
                                                        }
                                                        int i53 = iIntValue2;
                                                        listM519g = abstractC4523pM6266u;
                                                        i15 = i53;
                                                    }
                                                }
                                                str14 = str14;
                                            }
                                            str11 = str7;
                                            i23 = i20;
                                            i22 = i11;
                                        }
                                        iIntValue2 = i19;
                                        str14 = str14;
                                        i15 = iIntValue2;
                                        listM519g = listM6266u2;
                                        str11 = str7;
                                        i23 = i20;
                                        i22 = i11;
                                    } else {
                                        i21 = 1702061171;
                                    }
                                    listM6266u2 = listM519g;
                                } else {
                                    i21 = 1702061171;
                                }
                                if (iM3086f2 == i21) {
                                    i24 = i17;
                                    str11 = str7;
                                    i23 = i20;
                                    i22 = i11;
                                } else {
                                    i24 = c2757x.f6794b;
                                    if (i24 >= i17) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    C1460d.m559q(z4, null);
                                    while (true) {
                                        i23 = i20;
                                        if (i24 - i17 < i23) {
                                            str11 = str7;
                                            i22 = i11;
                                            i25 = -1;
                                            i24 = -1;
                                            break;
                                        }
                                        c2757x.m3079E(i24);
                                        iM3086f3 = c2757x.m3086f();
                                        if (iM3086f3 > 0) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        str11 = str7;
                                        C1460d.m559q(z5, str11);
                                        i22 = i11;
                                        if (c2757x.m3086f() == 1702061171) {
                                            i24 += iM3086f3;
                                            i20 = i23;
                                            i11 = i22;
                                            str7 = str11;
                                        }
                                    }
                                    if (i24 != i25) {
                                        Pair<String, byte[]> pairM3702a2 = m3702a(c2757x, i24);
                                        str6 = (String) pairM3702a2.first;
                                        bArr2 = (byte[]) pairM3702a2.second;
                                        if (bArr2 != null) {
                                            if ("audio/mp4a-latm".equals(str6)) {
                                                C2928l.b bVarM3489b = C2928l.m3489b(new C2756w(bArr2), false);
                                                i19 = bVarM3489b.f7766a;
                                                iIntValue = bVarM3489b.f7767b;
                                                str8 = bVarM3489b.f7768c;
                                            } else {
                                                str8 = str5;
                                            }
                                            listM6266u2 = AbstractC4523p.m6266u(bArr2);
                                            str5 = str8;
                                            i15 = i19;
                                        }
                                    }
                                    i15 = i19;
                                    listM519g = listM6266u2;
                                    listM6266u2 = listM519g;
                                }
                                i25 = -1;
                                if (i24 != i25) {
                                    Pair<String, byte[]> pairM3702a3 = m3702a(c2757x, i24);
                                    str6 = (String) pairM3702a3.first;
                                    bArr2 = (byte[]) pairM3702a3.second;
                                    if (bArr2 != null) {
                                        if ("audio/mp4a-latm".equals(str6)) {
                                            C2928l.b bVarM3489b2 = C2928l.m3489b(new C2756w(bArr2), false);
                                            i19 = bVarM3489b2.f7766a;
                                            iIntValue = bVarM3489b2.f7767b;
                                            str8 = bVarM3489b2.f7768c;
                                        } else {
                                            str8 = str5;
                                        }
                                        listM6266u2 = AbstractC4523p.m6266u(bArr2);
                                        str5 = str8;
                                        i15 = i19;
                                    }
                                }
                                i15 = i19;
                                listM519g = listM6266u2;
                                listM6266u2 = listM519g;
                            }
                            i17 += i23;
                            i30 = i46;
                            iM3086f5 = iM3086f5;
                            i11 = i22;
                            str14 = str14;
                        }
                        i18 = i15;
                        i13 = i30;
                        i12 = iM3086f5;
                        if (bVar2.f8356b == null && str6 != null) {
                            C2811j1.b bVar8 = new C2811j1.b();
                            bVar8.m3278b(i);
                            bVar8.f7173k = str6;
                            bVar8.f7170h = str5;
                            bVar8.f7186x = iIntValue;
                            bVar8.f7187y = i18;
                            bVar8.f7188z = i16;
                            bVar8.f7175m = listM6266u2;
                            bVar8.f7176n = drmInitDataM8835a2;
                            bVar8.f7165c = str;
                            bVar2.f8356b = bVar8.m3277a();
                        }
                        bVar = bVar2;
                        i4 = i13;
                        i5 = i12;
                    }
                    str15 = str4;
                }
                i14 = -1;
                i15 = iRound;
                iIntValue = i45;
                str5 = null;
                i3 = i29;
                String str17 = str15;
                i16 = i14;
                str6 = str17;
                listM6266u2 = null;
                i17 = i44;
                while (i17 - i30 < iM3086f5) {
                    c2757x.m3079E(i17);
                    iM3086f = c2757x.m3086f();
                    if (iM3086f > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    C1460d.m559q(z3, str11);
                    iM3086f2 = c2757x.m3086f();
                    int i410 = i30;
                    if (iM3086f2 == 1835557187) {
                        int i411 = iM3086f - 13;
                        byte[] bArr9 = new byte[i411];
                        c2757x.m3079E(i17 + 13);
                        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr9, 0, i411);
                        c2757x.f6794b += i411;
                        listM6266u2 = AbstractC4523p.m6266u(bArr9);
                        str11 = str11;
                        i23 = iM3086f;
                        i15 = i15;
                        str14 = str14;
                        i22 = i11;
                    } else {
                        i19 = i15;
                        i20 = iM3086f;
                        str7 = str11;
                        if (iM3086f2 != 1702061171) {
                            if (z2) {
                            }
                            if (iM3086f2 == 1684103987) {
                                c2757x.m3079E(i17 + 8);
                                String string4 = Integer.toString(i);
                                int i412 = C2929m.f7770b[(c2757x.m3100t() & Opcodes.CHECKCAST) >> 6];
                                iM3100t2 = c2757x.m3100t();
                                i28 = C2929m.f7772d[(iM3100t2 & 56) >> 3];
                                if ((iM3100t2 & 4) != 0) {
                                    i28++;
                                }
                                C2811j1.b bVar9 = new C2811j1.b();
                                bVar9.f7163a = string4;
                                bVar9.f7173k = str14;
                                bVar9.f7186x = i28;
                                bVar9.f7187y = i412;
                                bVar9.f7176n = drmInitDataM8835a2;
                                bVar9.f7165c = str;
                                bVar2.f8356b = bVar9.m3277a();
                            } else if (iM3086f2 == 1684366131) {
                                c2757x.m3079E(i17 + 8);
                                String string5 = Integer.toString(i);
                                c2757x.m3080F(2);
                                int i413 = C2929m.f7770b[(c2757x.m3100t() & Opcodes.CHECKCAST) >> 6];
                                iM3100t = c2757x.m3100t();
                                i27 = C2929m.f7772d[(iM3100t & 14) >> 1];
                                if ((iM3100t & 1) != 0) {
                                    i27++;
                                }
                                if (((c2757x.m3100t() & 30) >> 1) > 0) {
                                    i27 += 2;
                                }
                                if (c2757x.m3081a() > 0) {
                                    str9 = "audio/eac3";
                                } else {
                                    str9 = "audio/eac3";
                                }
                                C2811j1.b bVar10 = new C2811j1.b();
                                bVar10.f7163a = string5;
                                bVar10.f7173k = str9;
                                bVar10.f7186x = i27;
                                bVar10.f7187y = i413;
                                bVar10.f7176n = drmInitDataM8835a2;
                                bVar10.f7165c = str;
                                bVar2.f8356b = bVar10.m3277a();
                            } else {
                                if (iM3086f2 == 1684103988) {
                                    c2757x.m3079E(i17 + 8);
                                    String string6 = Integer.toString(i);
                                    c2757x.m3080F(1);
                                    if (((c2757x.m3100t() & 32) >> 5) == 1) {
                                        i26 = 48000;
                                    } else {
                                        i26 = 44100;
                                    }
                                    C2811j1.b bVar11 = new C2811j1.b();
                                    bVar11.f7163a = string6;
                                    bVar11.f7173k = "audio/ac4";
                                    bVar11.f7186x = 2;
                                    bVar11.f7187y = i26;
                                    bVar11.f7176n = drmInitDataM8835a2;
                                    bVar11.f7165c = str;
                                    bVar2.f8356b = bVar11.m3277a();
                                } else {
                                    if (iM3086f2 == 1684892784) {
                                        if (i11 > 0) {
                                            throw C1643a.m884w0(60, "Invalid sample rate for Dolby TrueHD MLP stream: ", i11, null);
                                        }
                                        iIntValue = 2;
                                        i15 = i11;
                                        listM519g = listM6266u2;
                                    } else if (iM3086f2 == 1684305011) {
                                        C2811j1.b bVar12 = new C2811j1.b();
                                        bVar12.m3278b(i);
                                        bVar12.f7173k = str6;
                                        bVar12.f7186x = iIntValue;
                                        iIntValue2 = i19;
                                        bVar12.f7187y = iIntValue2;
                                        bVar12.f7176n = drmInitDataM8835a2;
                                        bVar12.f7165c = str;
                                        bVar2.f8356b = bVar12.m3277a();
                                        str14 = str14;
                                        i15 = iIntValue2;
                                        listM519g = listM6266u2;
                                    } else {
                                        iIntValue2 = i19;
                                        if (iM3086f2 == 1682927731) {
                                            int i54 = i20 - 8;
                                            byte[] bArr10 = f8354a;
                                            byte[] bArrCopyOf2 = Arrays.copyOf(bArr10, bArr10.length + i54);
                                            c2757x.m3079E(i17 + 8);
                                            c2757x.m3085e(bArrCopyOf2, bArr10.length, i54);
                                            listM519g = C1460d.m519g(bArrCopyOf2);
                                            i15 = iIntValue2;
                                        } else {
                                            if (iM3086f2 == 1684425825) {
                                                int i55 = i20 - 12;
                                                byte[] bArr11 = new byte[i55 + 4];
                                                bArr11[0] = 102;
                                                bArr11[1] = 76;
                                                bArr11[2] = 97;
                                                bArr11[3] = 67;
                                                c2757x.m3079E(i17 + 12);
                                                str14 = str14;
                                                System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr11, 4, i55);
                                                c2757x.f6794b += i55;
                                                abstractC4523pM6266u = AbstractC4523p.m6266u(bArr11);
                                            } else {
                                                str14 = str14;
                                                if (iM3086f2 == 1634492771) {
                                                    int i56 = i20 - 12;
                                                    byte[] bArr12 = new byte[i56];
                                                    c2757x.m3079E(i17 + 12);
                                                    System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr12, 0, i56);
                                                    c2757x.f6794b += i56;
                                                    C2757x c2757x3 = new C2757x(bArr12);
                                                    c2757x3.m3079E(9);
                                                    int iM3100t6 = c2757x3.m3100t();
                                                    c2757x3.m3079E(20);
                                                    Pair pairCreate2 = Pair.create(Integer.valueOf(c2757x3.m3103w()), Integer.valueOf(iM3100t6));
                                                    iIntValue2 = ((Integer) pairCreate2.first).intValue();
                                                    iIntValue = ((Integer) pairCreate2.second).intValue();
                                                    abstractC4523pM6266u = AbstractC4523p.m6266u(bArr12);
                                                } else {
                                                    i15 = iIntValue2;
                                                    listM519g = listM6266u2;
                                                }
                                            }
                                            int i57 = iIntValue2;
                                            listM519g = abstractC4523pM6266u;
                                            i15 = i57;
                                        }
                                    }
                                    str14 = str14;
                                }
                                str11 = str7;
                                i23 = i20;
                                i22 = i11;
                                listM6266u2 = listM519g;
                            }
                            iIntValue2 = i19;
                            str14 = str14;
                            i15 = iIntValue2;
                            listM519g = listM6266u2;
                            str11 = str7;
                            i23 = i20;
                            i22 = i11;
                            listM6266u2 = listM519g;
                        } else {
                            i21 = 1702061171;
                        }
                        if (iM3086f2 == i21) {
                            i24 = i17;
                            str11 = str7;
                            i23 = i20;
                            i22 = i11;
                        } else {
                            i24 = c2757x.f6794b;
                            if (i24 >= i17) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            C1460d.m559q(z4, null);
                            while (true) {
                                i23 = i20;
                                if (i24 - i17 < i23) {
                                    str11 = str7;
                                    i22 = i11;
                                    i25 = -1;
                                    i24 = -1;
                                    break;
                                }
                                c2757x.m3079E(i24);
                                iM3086f3 = c2757x.m3086f();
                                if (iM3086f3 > 0) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                str11 = str7;
                                C1460d.m559q(z5, str11);
                                i22 = i11;
                                if (c2757x.m3086f() == 1702061171) {
                                    i24 += iM3086f3;
                                    i20 = i23;
                                    i11 = i22;
                                    str7 = str11;
                                }
                            }
                            if (i24 != i25) {
                                Pair<String, byte[]> pairM3702a4 = m3702a(c2757x, i24);
                                str6 = (String) pairM3702a4.first;
                                bArr2 = (byte[]) pairM3702a4.second;
                                if (bArr2 != null) {
                                    if ("audio/mp4a-latm".equals(str6)) {
                                        C2928l.b bVarM3489b3 = C2928l.m3489b(new C2756w(bArr2), false);
                                        i19 = bVarM3489b3.f7766a;
                                        iIntValue = bVarM3489b3.f7767b;
                                        str8 = bVarM3489b3.f7768c;
                                    } else {
                                        str8 = str5;
                                    }
                                    listM6266u2 = AbstractC4523p.m6266u(bArr2);
                                    str5 = str8;
                                    i15 = i19;
                                }
                            }
                            i15 = i19;
                            listM519g = listM6266u2;
                            listM6266u2 = listM519g;
                        }
                        i25 = -1;
                        if (i24 != i25) {
                            Pair<String, byte[]> pairM3702a5 = m3702a(c2757x, i24);
                            str6 = (String) pairM3702a5.first;
                            bArr2 = (byte[]) pairM3702a5.second;
                            if (bArr2 != null) {
                                if ("audio/mp4a-latm".equals(str6)) {
                                    C2928l.b bVarM3489b4 = C2928l.m3489b(new C2756w(bArr2), false);
                                    i19 = bVarM3489b4.f7766a;
                                    iIntValue = bVarM3489b4.f7767b;
                                    str8 = bVarM3489b4.f7768c;
                                } else {
                                    str8 = str5;
                                }
                                listM6266u2 = AbstractC4523p.m6266u(bArr2);
                                str5 = str8;
                                i15 = i19;
                            }
                        }
                        i15 = i19;
                        listM519g = listM6266u2;
                        listM6266u2 = listM519g;
                    }
                    i17 += i23;
                    i30 = i410;
                    iM3086f5 = iM3086f5;
                    i11 = i22;
                    str14 = str14;
                }
                i18 = i15;
                i13 = i30;
                i12 = iM3086f5;
                if (bVar2.f8356b == null) {
                    C2811j1.b bVar13 = new C2811j1.b();
                    bVar13.m3278b(i);
                    bVar13.f7173k = str6;
                    bVar13.f7170h = str5;
                    bVar13.f7186x = iIntValue;
                    bVar13.f7187y = i18;
                    bVar13.f7188z = i16;
                    bVar13.f7175m = listM6266u2;
                    bVar13.f7176n = drmInitDataM8835a2;
                    bVar13.f7165c = str;
                    bVar2.f8356b = bVar13.m3277a();
                }
                bVar = bVar2;
                i4 = i13;
                i5 = i12;
            } else {
                if (iM3086f6 == 1414810956 || iM3086f6 == 1954034535 || iM3086f6 == 2004251764 || iM3086f6 == 1937010800 || iM3086f6 == 1664495672) {
                    c2757x.m3079E(i30 + 8 + 8);
                    long j = RecyclerView.FOREVER_NS;
                    String str18 = "application/ttml+xml";
                    if (iM3086f6 == 1414810956) {
                        abstractC4523pM6266u2 = null;
                        str10 = str18;
                    } else if (iM3086f6 == 1954034535) {
                        int i58 = (iM3086f5 - 8) - 8;
                        byte[] bArr13 = new byte[i58];
                        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr13, 0, i58);
                        c2757x.f6794b += i58;
                        abstractC4523pM6266u2 = AbstractC4523p.m6266u(bArr13);
                        str10 = "application/x-quicktime-tx3g";
                    } else {
                        if (iM3086f6 == 2004251764) {
                            str18 = "application/x-mp4-vtt";
                        } else if (iM3086f6 == 1937010800) {
                            j = 0;
                        } else {
                            if (iM3086f6 != 1664495672) {
                                throw new IllegalStateException();
                            }
                            bVar2.f8358d = 1;
                            str18 = "application/x-mp4-cea-608";
                        }
                        abstractC4523pM6266u2 = null;
                        str10 = str18;
                    }
                    C2811j1.b bVar14 = new C2811j1.b();
                    bVar14.m3278b(i);
                    bVar14.f7173k = str10;
                    bVar14.f7165c = str;
                    bVar14.f7177o = j;
                    bVar14.f7175m = abstractC4523pM6266u2;
                    bVar2.f8356b = bVar14.m3277a();
                } else if (iM3086f6 == 1835365492) {
                    c2757x.m3079E(i30 + 8 + 8);
                    if (iM3086f6 == 1835365492) {
                        c2757x.m3094n();
                        String strM3094n = c2757x.m3094n();
                        if (strM3094n != null) {
                            C2811j1.b bVar15 = new C2811j1.b();
                            bVar15.m3278b(i);
                            bVar15.f7173k = strM3094n;
                            bVar2.f8356b = bVar15.m3277a();
                        }
                    }
                } else if (iM3086f6 == 1667329389) {
                    C2811j1.b bVar16 = new C2811j1.b();
                    bVar16.m3278b(i);
                    bVar16.f7173k = "application/x-camera-motion";
                    bVar2.f8356b = bVar16.m3277a();
                }
                iM3086f4 = iM3086f4;
                bVar = bVar2;
                i3 = i29;
                i4 = i30;
                i5 = iM3086f5;
            }
            c2757x.m3079E(i4 + i5);
            i29 = i3 + 1;
            bVar2 = bVar;
            iM3086f4 = iM3086f4;
        }
        return bVar2;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0284  */
    /* JADX WARN: Code duplicated, block: B:120:0x028e  */
    /* JADX WARN: Code duplicated, block: B:121:0x0292  */
    /* JADX WARN: Code duplicated, block: B:173:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:175:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:178:0x0400  */
    /* JADX WARN: Code duplicated, block: B:179:0x0402 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:180:0x0404  */
    /* JADX WARN: Code duplicated, block: B:181:0x0409  */
    /* JADX WARN: Code duplicated, block: B:183:0x040f  */
    /* JADX WARN: Code duplicated, block: B:185:0x041b  */
    /* JADX WARN: Code duplicated, block: B:186:0x0422  */
    /* JADX WARN: Code duplicated, block: B:189:0x0426 A[LOOP:2: B:176:0x03fc->B:189:0x0426, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:192:0x0433 A[LOOP:3: B:191:0x0431->B:192:0x0433, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:195:0x044c  */
    /* JADX WARN: Code duplicated, block: B:197:0x045e A[LOOP:5: B:196:0x045c->B:197:0x045e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:200:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:203:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:205:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:207:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:208:0x04ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:209:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:210:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:212:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:214:0x0508  */
    /* JADX WARN: Code duplicated, block: B:215:0x050f  */
    /* JADX WARN: Code duplicated, block: B:219:0x0516 A[LOOP:12: B:204:0x04e4->B:219:0x0516, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:223:0x0539 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:224:0x053b A[ADDED_TO_REGION, LOOP:13: B:224:0x053b->B:226:0x053f, LOOP_START, PHI: r19 r37 r38
      0x053b: PHI (r19v7 int) = (r19v3 int), (r19v8 int) binds: [B:223:0x0539, B:226:0x053f] A[DONT_GENERATE, DONT_INLINE]
      0x053b: PHI (r37v4 int) = (r37v1 int), (r37v5 int) binds: [B:223:0x0539, B:226:0x053f] A[DONT_GENERATE, DONT_INLINE]
      0x053b: PHI (r38v3 int) = (r38v1 int), (r38v5 int) binds: [B:223:0x0539, B:226:0x053f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:230:0x055a  */
    /* JADX WARN: Code duplicated, block: B:233:0x0566  */
    /* JADX WARN: Code duplicated, block: B:234:0x0568  */
    /* JADX WARN: Code duplicated, block: B:237:0x056f  */
    /* JADX WARN: Code duplicated, block: B:239:0x0576  */
    /* JADX WARN: Code duplicated, block: B:248:0x05c0 A[DONT_INVERT, LOOP:14: B:248:0x05c0->B:252:0x05ca, LOOP_START, PHI: r19
      0x05c0: PHI (r19v4 int) = (r19v3 int), (r19v5 int) binds: [B:247:0x05be, B:252:0x05ca] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:249:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:252:0x05ca A[LOOP:14: B:248:0x05c0->B:252:0x05ca, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:253:0x05d0 A[EDGE_INSN: B:253:0x05d0->B:254:0x05d1 BREAK  A[LOOP:14: B:248:0x05c0->B:252:0x05ca]] */
    /* JADX WARN: Code duplicated, block: B:263:0x05e3  */
    /* JADX WARN: Code duplicated, block: B:266:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:267:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:272:0x0652  */
    /* JADX WARN: Code duplicated, block: B:273:0x0664  */
    /* JADX WARN: Code duplicated, block: B:300:0x0720  */
    /* JADX WARN: Code duplicated, block: B:303:0x072c  */
    /* JADX WARN: Code duplicated, block: B:313:0x0775  */
    /* JADX WARN: Code duplicated, block: B:314:0x0777  */
    /* JADX WARN: Code duplicated, block: B:318:0x078c  */
    /* JADX WARN: Code duplicated, block: B:320:0x0797  */
    /* JADX WARN: Code duplicated, block: B:323:0x07be  */
    /* JADX WARN: Code duplicated, block: B:328:0x07d6  */
    /* JADX WARN: Code duplicated, block: B:329:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:331:0x07e1  */
    /* JADX WARN: Code duplicated, block: B:335:0x07f6  */
    /* JADX WARN: Code duplicated, block: B:336:0x07f8  */
    /* JADX WARN: Code duplicated, block: B:339:0x07fd  */
    /* JADX WARN: Code duplicated, block: B:340:0x0801  */
    /* JADX WARN: Code duplicated, block: B:342:0x0804  */
    /* JADX WARN: Code duplicated, block: B:343:0x0807  */
    /* JADX WARN: Code duplicated, block: B:345:0x080a  */
    /* JADX WARN: Code duplicated, block: B:346:0x080c  */
    /* JADX WARN: Code duplicated, block: B:348:0x0810  */
    /* JADX WARN: Code duplicated, block: B:349:0x0813  */
    /* JADX WARN: Code duplicated, block: B:353:0x0820  */
    /* JADX WARN: Code duplicated, block: B:355:0x082c  */
    /* JADX WARN: Code duplicated, block: B:356:0x083e  */
    /* JADX WARN: Code duplicated, block: B:359:0x0848  */
    /* JADX WARN: Code duplicated, block: B:361:0x0879  */
    /* JADX WARN: Code duplicated, block: B:380:0x042b A[EDGE_INSN: B:380:0x042b->B:190:0x042b BREAK  A[LOOP:2: B:176:0x03fc->B:189:0x0426], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:385:0x07f0 A[EDGE_INSN: B:385:0x07f0->B:333:0x07f0 BREAK  A[LOOP:7: B:316:0x0787->B:332:0x07e9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:393:0x0880 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:396:0x0521 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:400:0x051d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:401:0x051f A[EDGE_INSN: B:401:0x051f->B:221:0x051f BREAK  A[LOOP:12: B:204:0x04e4->B:219:0x0516], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:404:0x05d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:405:0x05c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0111 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x0113 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0120 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:71:0x012b  */
    /* JADX WARN: Code duplicated, block: B:74:0x0136  */
    /* JADX WARN: Code duplicated, block: B:75:0x0139  */
    /* JADX WARN: Code duplicated, block: B:78:0x014c  */
    /* JADX WARN: Code duplicated, block: B:79:0x014f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    /* JADX WARN: Code duplicated, block: B:83:0x0162  */
    /* JADX WARN: Code duplicated, block: B:86:0x019c  */
    /* JADX WARN: Code duplicated, block: B:87:0x019f  */
    /* JADX WARN: Code duplicated, block: B:90:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ac  */
    /* JADX INFO: renamed from: e */
    public static List<C3057p> m3706e(AbstractC3045d.a aVar, C3115p c3115p, long j, @Nullable DrmInitData drmInitData, boolean z2, boolean z3, InterfaceC4485e<C3054m, C3054m> interfaceC4485e) throws ParserException {
        int i;
        C3054m c3054m;
        a dVar;
        boolean z4;
        int iM3103w;
        int iM3103w2;
        int iM3103w3;
        int i2;
        int iMo3707a;
        ArrayList arrayList;
        boolean z5;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int[] iArrCopyOf2;
        int i3;
        int i4;
        int iM3103w4;
        long j2;
        long j3;
        long jM3101u;
        int i5;
        int i6;
        int iM3103w5;
        int i7;
        int i8;
        int iM3086f;
        int iM3103w6;
        int i9;
        int i10;
        int i11;
        boolean z6;
        int i12;
        C3054m c3054m2;
        String str;
        int[] iArr;
        int i13;
        long[] jArr;
        int[] iArr2;
        long j4;
        boolean z7;
        int i14;
        int iM3103w7;
        int i15;
        int i16;
        int iM3103w8;
        int i17;
        long jM2985F;
        long[] jArr2;
        int i18;
        int[] iArr3;
        long[] jArr3;
        long[] jArr4;
        boolean z8;
        int[] iArr4;
        int[] iArr5;
        long[] jArr5;
        int i19;
        boolean z9;
        int i20;
        int i21;
        long[] jArr6;
        int[] iArr6;
        boolean z10;
        boolean z11;
        long[] jArr7;
        int[] iArr7;
        int i22;
        int[] iArr8;
        long[] jArr8;
        int i23;
        int i24;
        long j5;
        C3057p c3057p;
        long j6;
        int i25;
        int i26;
        int[] iArr9;
        boolean z12;
        int i27;
        long j7;
        int[] iArr10;
        boolean z13;
        C3057p c3057p2;
        long[] jArr9;
        int[] iArr11;
        int iM3103w9;
        long jM3101u2;
        int i28;
        int iM3103w10;
        boolean z14;
        long j8;
        int i29;
        int i30;
        int iM2998f;
        int[] iArr12;
        long[] jArr10;
        int[] iArr13;
        int i31;
        int i32;
        int i33;
        int i34;
        int iMax;
        int i35;
        long j9;
        ArrayList arrayList2;
        boolean z15;
        long jM3101u3;
        int i36;
        int iM3086f2;
        int i37;
        long j10;
        C2757x c2757x;
        int i38;
        long jM3101u4;
        long jM2985F2;
        int iM3086f3;
        int i39;
        int i40;
        Pair pairCreate;
        b bVarM3705d;
        long[] jArr11;
        long[] jArr12;
        AbstractC3045d.a aVarM3700b;
        Pair pairCreate2;
        ArrayList arrayList3 = new ArrayList();
        int i41 = 0;
        while (i41 < aVar.f8352d.size()) {
            AbstractC3045d.a aVar2 = aVar.f8352d.get(i41);
            if (aVar2.f8349a != 1953653099) {
                arrayList2 = arrayList3;
                i2 = i41;
            } else {
                AbstractC3045d.b bVarM3701c = aVar.m3701c(1836476516);
                Objects.requireNonNull(bVarM3701c);
                AbstractC3045d.a aVarM3700b2 = aVar2.m3700b(1835297121);
                Objects.requireNonNull(aVarM3700b2);
                AbstractC3045d.b bVarM3701c2 = aVarM3700b2.m3701c(1751411826);
                Objects.requireNonNull(bVarM3701c2);
                C2757x c2757x2 = bVarM3701c2.f8353b;
                c2757x2.m3079E(16);
                int iM3086f4 = c2757x2.m3086f();
                if (iM3086f4 == 1936684398) {
                    i = 1;
                } else if (iM3086f4 == 1986618469) {
                    i = 2;
                } else if (iM3086f4 == 1952807028 || iM3086f4 == 1935832172 || iM3086f4 == 1937072756 || iM3086f4 == 1668047728) {
                    i = 3;
                } else {
                    i = iM3086f4 == 1835365473 ? 5 : -1;
                }
                if (i == -1) {
                    c3054m = null;
                } else {
                    AbstractC3045d.b bVarM3701c3 = aVar2.m3701c(1953196132);
                    Objects.requireNonNull(bVarM3701c3);
                    C2757x c2757x3 = bVarM3701c3.f8353b;
                    c2757x3.m3079E(8);
                    int iM3086f5 = (c2757x3.m3086f() >> 24) & 255;
                    c2757x3.m3080F(iM3086f5 != 0 ? 16 : 8);
                    int iM3086f6 = c2757x3.m3086f();
                    c2757x3.m3080F(4);
                    int i42 = c2757x3.f6794b;
                    int i43 = iM3086f5 == 0 ? 4 : 8;
                    int i44 = 0;
                    while (true) {
                        if (i44 >= i43) {
                            z15 = true;
                            break;
                        }
                        if (c2757x3.f6793a[i42 + i44] != -1) {
                            z15 = false;
                            break;
                        }
                        i44++;
                    }
                    if (z15) {
                        c2757x3.m3080F(i43);
                    } else {
                        jM3101u3 = iM3086f5 == 0 ? c2757x3.m3101u() : c2757x3.m3104x();
                        if (jM3101u3 != 0) {
                            i36 = 16;
                        }
                        c2757x3.m3080F(i36);
                        iM3086f2 = c2757x3.m3086f();
                        int iM3086f7 = c2757x3.m3086f();
                        c2757x3.m3080F(4);
                        int iM3086f8 = c2757x3.m3086f();
                        int iM3086f9 = c2757x3.m3086f();
                        if (iM3086f2 != 0 && iM3086f7 == 65536 && iM3086f8 == -65536 && iM3086f9 == 0) {
                            i37 = 90;
                        } else if (iM3086f2 != 0 && iM3086f7 == -65536 && iM3086f8 == 65536 && iM3086f9 == 0) {
                            i37 = 270;
                        } else if (iM3086f2 != -65536 && iM3086f7 == 0 && iM3086f8 == 0 && iM3086f9 == -65536) {
                            i37 = 180;
                        } else {
                            i37 = 0;
                        }
                        if (j == -9223372036854775807L) {
                            j10 = jM3101u3;
                        } else {
                            j10 = j;
                        }
                        c2757x = bVarM3701c.f8353b;
                        c2757x.m3079E(8);
                        if (((c2757x.m3086f() >> 24) & 255) == 0) {
                            i38 = 8;
                        } else {
                            i38 = 16;
                        }
                        c2757x.m3080F(i38);
                        jM3101u4 = c2757x.m3101u();
                        jM2985F2 = j10 != -9223372036854775807L ? C2738e0.m2985F(j10, 1000000L, jM3101u4) : -9223372036854775807L;
                        AbstractC3045d.a aVarM3700b3 = aVarM3700b2.m3700b(1835626086);
                        Objects.requireNonNull(aVarM3700b3);
                        AbstractC3045d.a aVarM3700b4 = aVarM3700b3.m3700b(1937007212);
                        Objects.requireNonNull(aVarM3700b4);
                        AbstractC3045d.b bVarM3701c4 = aVarM3700b2.m3701c(1835296868);
                        Objects.requireNonNull(bVarM3701c4);
                        C2757x c2757x4 = bVarM3701c4.f8353b;
                        c2757x4.m3079E(8);
                        iM3086f3 = (c2757x4.m3086f() >> 24) & 255;
                        if (iM3086f3 == 0) {
                            i39 = 8;
                        } else {
                            i39 = 16;
                        }
                        c2757x4.m3080F(i39);
                        long jM3101u5 = c2757x4.m3101u();
                        if (iM3086f3 == 0) {
                            i40 = 4;
                        } else {
                            i40 = 8;
                        }
                        c2757x4.m3080F(i40);
                        int iM3105y = c2757x4.m3105y();
                        StringBuilder sb = new StringBuilder(3);
                        sb.append((char) (((iM3105y >> 10) & 31) + 96));
                        sb.append((char) (((iM3105y >> 5) & 31) + 96));
                        sb.append((char) ((iM3105y & 31) + 96));
                        pairCreate = Pair.create(Long.valueOf(jM3101u5), sb.toString());
                        AbstractC3045d.b bVarM3701c5 = aVarM3700b4.m3701c(1937011556);
                        Objects.requireNonNull(bVarM3701c5);
                        bVarM3705d = m3705d(bVarM3701c5.f8353b, iM3086f6, i37, (String) pairCreate.second, drmInitData, z3);
                        if (!z2 || (aVarM3700b = aVar2.m3700b(1701082227)) == null) {
                            jArr11 = null;
                            jArr12 = null;
                        } else {
                            AbstractC3045d.b bVarM3701c6 = aVarM3700b.m3701c(1701606260);
                            if (bVarM3701c6 == null) {
                                pairCreate2 = null;
                            } else {
                                C2757x c2757x5 = bVarM3701c6.f8353b;
                                c2757x5.m3079E(8);
                                int iM3086f10 = (c2757x5.m3086f() >> 24) & 255;
                                int iM3103w11 = c2757x5.m3103w();
                                long[] jArr13 = new long[iM3103w11];
                                long[] jArr14 = new long[iM3103w11];
                                int i45 = 0;
                                while (i45 < iM3103w11) {
                                    jArr13[i45] = iM3086f10 == 1 ? c2757x5.m3104x() : c2757x5.m3101u();
                                    jArr14[i45] = iM3086f10 == 1 ? c2757x5.m3093m() : c2757x5.m3086f();
                                    if (c2757x5.m3096p() != 1) {
                                        throw new IllegalArgumentException("Unsupported media rate.");
                                    }
                                    c2757x5.m3080F(2);
                                    i45++;
                                    iM3086f10 = iM3086f10;
                                    iM3103w11 = iM3103w11;
                                }
                                pairCreate2 = Pair.create(jArr13, jArr14);
                            }
                            if (pairCreate2 != null) {
                                long[] jArr15 = (long[]) pairCreate2.first;
                                jArr12 = (long[]) pairCreate2.second;
                                jArr11 = jArr15;
                            } else {
                                jArr11 = null;
                                jArr12 = null;
                            }
                        }
                        if (bVarM3705d.f8356b == null) {
                            c3054m = null;
                        } else {
                            c3054m = new C3054m(iM3086f6, i, ((Long) pairCreate.first).longValue(), jM3101u4, jM2985F2, bVarM3705d.f8356b, bVarM3705d.f8358d, bVarM3705d.f8355a, bVarM3705d.f8357c, jArr11, jArr12);
                        }
                    }
                    i36 = 16;
                    jM3101u3 = -9223372036854775807L;
                    c2757x3.m3080F(i36);
                    iM3086f2 = c2757x3.m3086f();
                    int iM3086f11 = c2757x3.m3086f();
                    c2757x3.m3080F(4);
                    int iM3086f12 = c2757x3.m3086f();
                    int iM3086f13 = c2757x3.m3086f();
                    if (iM3086f2 != 0) {
                        if (iM3086f2 != 0) {
                            if (iM3086f2 != -65536) {
                                i37 = 0;
                            } else {
                                i37 = 0;
                            }
                        } else if (iM3086f2 != -65536) {
                            i37 = 0;
                        } else {
                            i37 = 0;
                        }
                    } else if (iM3086f2 != 0) {
                        if (iM3086f2 != -65536) {
                            i37 = 0;
                        } else {
                            i37 = 0;
                        }
                    } else if (iM3086f2 != -65536) {
                        i37 = 0;
                    } else {
                        i37 = 0;
                    }
                    if (j == -9223372036854775807L) {
                        j10 = jM3101u3;
                    } else {
                        j10 = j;
                    }
                    c2757x = bVarM3701c.f8353b;
                    c2757x.m3079E(8);
                    if (((c2757x.m3086f() >> 24) & 255) == 0) {
                        i38 = 8;
                    } else {
                        i38 = 16;
                    }
                    c2757x.m3080F(i38);
                    jM3101u4 = c2757x.m3101u();
                    jM2985F2 = j10 != -9223372036854775807L ? C2738e0.m2985F(j10, 1000000L, jM3101u4) : -9223372036854775807L;
                    AbstractC3045d.a aVarM3700b5 = aVarM3700b2.m3700b(1835626086);
                    Objects.requireNonNull(aVarM3700b5);
                    AbstractC3045d.a aVarM3700b6 = aVarM3700b5.m3700b(1937007212);
                    Objects.requireNonNull(aVarM3700b6);
                    AbstractC3045d.b bVarM3701c7 = aVarM3700b2.m3701c(1835296868);
                    Objects.requireNonNull(bVarM3701c7);
                    C2757x c2757x6 = bVarM3701c7.f8353b;
                    c2757x6.m3079E(8);
                    iM3086f3 = (c2757x6.m3086f() >> 24) & 255;
                    if (iM3086f3 == 0) {
                        i39 = 8;
                    } else {
                        i39 = 16;
                    }
                    c2757x6.m3080F(i39);
                    long jM3101u6 = c2757x6.m3101u();
                    if (iM3086f3 == 0) {
                        i40 = 4;
                    } else {
                        i40 = 8;
                    }
                    c2757x6.m3080F(i40);
                    int iM3105y2 = c2757x6.m3105y();
                    StringBuilder sb2 = new StringBuilder(3);
                    sb2.append((char) (((iM3105y2 >> 10) & 31) + 96));
                    sb2.append((char) (((iM3105y2 >> 5) & 31) + 96));
                    sb2.append((char) ((iM3105y2 & 31) + 96));
                    pairCreate = Pair.create(Long.valueOf(jM3101u6), sb2.toString());
                    AbstractC3045d.b bVarM3701c8 = aVarM3700b6.m3701c(1937011556);
                    Objects.requireNonNull(bVarM3701c8);
                    bVarM3705d = m3705d(bVarM3701c8.f8353b, iM3086f6, i37, (String) pairCreate.second, drmInitData, z3);
                    if (z2) {
                        jArr11 = null;
                        jArr12 = null;
                    } else {
                        jArr11 = null;
                        jArr12 = null;
                    }
                    if (bVarM3705d.f8356b == null) {
                        c3054m = null;
                    } else {
                        c3054m = new C3054m(iM3086f6, i, ((Long) pairCreate.first).longValue(), jM3101u4, jM2985F2, bVarM3705d.f8356b, bVarM3705d.f8358d, bVarM3705d.f8355a, bVarM3705d.f8357c, jArr11, jArr12);
                    }
                }
                C3054m c3054mApply = interfaceC4485e.apply(c3054m);
                if (c3054mApply == null) {
                    arrayList2 = arrayList3;
                    i2 = i41;
                } else {
                    AbstractC3045d.a aVarM3700b7 = aVar2.m3700b(1835297121);
                    Objects.requireNonNull(aVarM3700b7);
                    AbstractC3045d.a aVarM3700b8 = aVarM3700b7.m3700b(1835626086);
                    Objects.requireNonNull(aVarM3700b8);
                    AbstractC3045d.a aVarM3700b9 = aVarM3700b8.m3700b(1937007212);
                    Objects.requireNonNull(aVarM3700b9);
                    AbstractC3045d.b bVarM3701c9 = aVarM3700b9.m3701c(1937011578);
                    if (bVarM3701c9 != null) {
                        dVar = new c(bVarM3701c9, c3054mApply.f8465f);
                    } else {
                        AbstractC3045d.b bVarM3701c10 = aVarM3700b9.m3701c(1937013298);
                        if (bVarM3701c10 == null) {
                            throw ParserException.m8755a("Track has no sample table size information", null);
                        }
                        dVar = new d(bVarM3701c10);
                    }
                    int iMo3708b = dVar.mo3708b();
                    if (iMo3708b == 0) {
                        c3057p = new C3057p(c3054mApply, new long[0], new int[0], 0, new long[0], new int[0], 0L);
                        arrayList = arrayList3;
                        i2 = i41;
                    } else {
                        AbstractC3045d.b bVarM3701c11 = aVarM3700b9.m3701c(1937007471);
                        if (bVarM3701c11 == null) {
                            bVarM3701c11 = aVarM3700b9.m3701c(1668232756);
                            Objects.requireNonNull(bVarM3701c11);
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        C2757x c2757x7 = bVarM3701c11.f8353b;
                        AbstractC3045d.b bVarM3701c12 = aVarM3700b9.m3701c(1937011555);
                        Objects.requireNonNull(bVarM3701c12);
                        C2757x c2757x8 = bVarM3701c12.f8353b;
                        AbstractC3045d.b bVarM3701c13 = aVarM3700b9.m3701c(1937011827);
                        Objects.requireNonNull(bVarM3701c13);
                        C2757x c2757x9 = bVarM3701c13.f8353b;
                        AbstractC3045d.b bVarM3701c14 = aVarM3700b9.m3701c(1937011571);
                        C2757x c2757x10 = bVarM3701c14 != null ? bVarM3701c14.f8353b : null;
                        AbstractC3045d.b bVarM3701c15 = aVarM3700b9.m3701c(1668576371);
                        C2757x c2757x11 = bVarM3701c15 != null ? bVarM3701c15.f8353b : null;
                        c2757x7.m3079E(12);
                        int iM3103w12 = c2757x7.m3103w();
                        c2757x8.m3079E(12);
                        int iM3103w13 = c2757x8.m3103w();
                        C1460d.m559q(c2757x8.m3086f() == 1, "first_chunk must be 1");
                        c2757x9.m3079E(12);
                        int iM3103w14 = c2757x9.m3103w() - 1;
                        int iM3103w15 = c2757x9.m3103w();
                        int i46 = iM3103w13;
                        int iM3103w16 = c2757x9.m3103w();
                        if (c2757x11 != null) {
                            c2757x11.m3079E(12);
                            iM3103w = c2757x11.m3103w();
                        } else {
                            iM3103w = 0;
                        }
                        if (c2757x10 != null) {
                            c2757x10.m3079E(12);
                            iM3103w2 = c2757x10.m3103w();
                            if (iM3103w2 > 0) {
                                iM3103w3 = c2757x10.m3103w() - 1;
                            } else {
                                c2757x10 = null;
                            }
                            i2 = i41;
                            iMo3707a = dVar.mo3707a();
                            arrayList = arrayList3;
                            String str2 = c3054mApply.f8465f.f7155w;
                            if (iMo3707a == -1 && (("audio/raw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/g711-alaw".equals(str2)) && iM3103w14 == 0 && iM3103w == 0 && iM3103w2 == 0)) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                jArr9 = new long[iM3103w12];
                                iArr11 = new int[iM3103w12];
                                iM3103w9 = 0;
                                jM3101u2 = 0;
                                i28 = -1;
                                iM3103w10 = 0;
                                while (true) {
                                    i28++;
                                    if (i28 == iM3103w12) {
                                        z14 = false;
                                    } else {
                                        if (z4) {
                                            jM3101u2 = c2757x7.m3104x();
                                        } else {
                                            jM3101u2 = c2757x7.m3101u();
                                        }
                                        if (i28 == iM3103w9) {
                                            iM3103w10 = c2757x8.m3103w();
                                            c2757x8.m3080F(4);
                                            i46--;
                                            if (i46 > 0) {
                                                iM3103w9 = c2757x8.m3103w() - 1;
                                            } else {
                                                iM3103w9 = -1;
                                            }
                                        }
                                        z14 = true;
                                    }
                                    if (z14) {
                                        break;
                                    }
                                    jArr9[i28] = jM3101u2;
                                    iArr11[i28] = iM3103w10;
                                }
                                j8 = iM3103w16;
                                i29 = 8192 / iMo3707a;
                                iM2998f = 0;
                                for (i30 = 0; i30 < iM3103w12; i30++) {
                                    iM2998f += C2738e0.m2998f(iArr11[i30], i29);
                                }
                                jArr = new long[iM2998f];
                                iArr12 = new int[iM2998f];
                                jArr10 = new long[iM2998f];
                                iArr13 = new int[iM2998f];
                                i31 = 0;
                                i32 = 0;
                                i33 = 0;
                                i34 = 0;
                                while (i31 < iM3103w12) {
                                    int i47 = iArr11[i31];
                                    long j11 = jArr9[i31];
                                    long[] jArr16 = jArr9;
                                    int[] iArr14 = iArr11;
                                    iMax = i34;
                                    i35 = i47;
                                    j9 = j11;
                                    while (i35 > 0) {
                                        int iMin = Math.min(i29, i35);
                                        jArr[i33] = j9;
                                        iArr12[i33] = iMo3707a * iMin;
                                        iMax = Math.max(iMax, iArr12[i33]);
                                        jArr10[i33] = ((long) i32) * j8;
                                        iArr13[i33] = 1;
                                        j9 += (long) iArr12[i33];
                                        i32 += iMin;
                                        i35 -= iMin;
                                        i33++;
                                        i29 = i29;
                                        iMo3707a = iMo3707a;
                                    }
                                    i31++;
                                    i34 = iMax;
                                    jArr9 = jArr16;
                                    iArr11 = iArr14;
                                }
                                j4 = j8 * ((long) i32);
                                iArr2 = iArr13;
                                iArr = iArr12;
                                jArrCopyOf2 = jArr10;
                                i13 = i34;
                                c3054m2 = c3054mApply;
                            } else {
                                jArrCopyOf = new long[iMo3708b];
                                iArrCopyOf = new int[iMo3708b];
                                jArrCopyOf2 = new long[iMo3708b];
                                int i48 = iM3103w2;
                                iArrCopyOf2 = new int[iMo3708b];
                                i3 = 0;
                                i4 = 0;
                                iM3103w4 = 0;
                                j2 = 0;
                                j3 = 0;
                                jM3101u = 0;
                                i5 = -1;
                                i6 = iM3103w16;
                                iM3103w5 = iM3103w15;
                                i7 = iM3103w3;
                                i8 = i48;
                                iM3086f = 0;
                                iM3103w6 = 0;
                                int i49 = iM3103w14;
                                i9 = iM3103w;
                                i10 = 0;
                                i11 = 0;
                                while (i10 < iMo3708b) {
                                    z7 = true;
                                    int i50 = i3;
                                    i14 = iMo3708b;
                                    iM3103w7 = i50;
                                    while (true) {
                                        if (i4 == 0) {
                                            i15 = i7;
                                            break;
                                        }
                                        i15 = i7;
                                        i17 = i5 + 1;
                                        if (i17 == iM3103w12) {
                                            z7 = false;
                                        } else {
                                            if (z4) {
                                                jM3101u = c2757x7.m3104x();
                                            } else {
                                                jM3101u = c2757x7.m3101u();
                                            }
                                            if (i17 == iM3103w7) {
                                                iM3103w4 = c2757x8.m3103w();
                                                c2757x8.m3080F(4);
                                                i46--;
                                                if (i46 > 0) {
                                                    iM3103w7 = c2757x8.m3103w() - 1;
                                                } else {
                                                    iM3103w7 = -1;
                                                }
                                            }
                                            z7 = true;
                                        }
                                        i5 = i17;
                                        if (z7) {
                                            break;
                                        }
                                        i4 = iM3103w4;
                                        j3 = jM3101u;
                                        i7 = i15;
                                    }
                                    if (!z7) {
                                        Log.w("AtomParsers", "Unexpected end of chunk data");
                                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i10);
                                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i10);
                                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i10);
                                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i10);
                                        iMo3708b = i10;
                                        break;
                                    }
                                    if (c2757x11 != null) {
                                        while (iM3103w6 == 0 && i9 > 0) {
                                            iM3103w6 = c2757x11.m3103w();
                                            iM3086f = c2757x11.m3086f();
                                            i9--;
                                        }
                                        iM3103w6--;
                                    }
                                    int i51 = iM3086f;
                                    jArrCopyOf[i10] = j3;
                                    iArrCopyOf[i10] = dVar.mo3709c();
                                    if (iArrCopyOf[i10] > i11) {
                                        i11 = iArrCopyOf[i10];
                                    }
                                    C2757x c2757x12 = c2757x7;
                                    boolean z16 = z4;
                                    jArrCopyOf2[i10] = j2 + ((long) i51);
                                    if (c2757x10 == null) {
                                        i16 = 1;
                                    } else {
                                        i16 = 0;
                                    }
                                    iArrCopyOf2[i10] = i16;
                                    iM3103w8 = i15;
                                    if (i10 == iM3103w8) {
                                        iArrCopyOf2[i10] = 1;
                                        i8--;
                                        if (i8 > 0) {
                                            Objects.requireNonNull(c2757x10);
                                            iM3103w8 = c2757x10.m3103w() - 1;
                                        }
                                    }
                                    long[] jArr17 = jArrCopyOf2;
                                    int iM3086f14 = i6;
                                    int i52 = iM3103w7;
                                    j2 += (long) iM3086f14;
                                    iM3103w5--;
                                    if (iM3103w5 != 0 && i49 > 0) {
                                        i49--;
                                        iM3103w5 = c2757x9.m3103w();
                                        iM3086f14 = c2757x9.m3086f();
                                    }
                                    j3 += (long) iArrCopyOf[i10];
                                    i4--;
                                    i10++;
                                    iM3086f = i51;
                                    iMo3708b = i14;
                                    i3 = i52;
                                    jArrCopyOf2 = jArr17;
                                    i6 = iM3086f14;
                                    z4 = z16;
                                    i7 = iM3103w8;
                                    c2757x7 = c2757x12;
                                }
                                int i53 = i4;
                                long j12 = j2 + ((long) iM3086f);
                                if (c2757x11 != null) {
                                    z6 = true;
                                    break;
                                }
                                while (true) {
                                    if (i9 > 0) {
                                        z6 = true;
                                        break;
                                    }
                                    if (c2757x11.m3103w() != 0) {
                                        z6 = false;
                                        break;
                                    }
                                    c2757x11.m3086f();
                                    i9--;
                                }
                                if (i8 != 0 && iM3103w5 == 0 && i53 == 0 && i49 == 0) {
                                    i12 = iM3103w6;
                                    if (i12 == 0 && z6) {
                                        c3054m2 = c3054mApply;
                                    }
                                    iArr = iArrCopyOf;
                                    i13 = i11;
                                    jArr = jArrCopyOf;
                                    iArr2 = iArrCopyOf2;
                                    j4 = j12;
                                } else {
                                    i12 = iM3103w6;
                                }
                                c3054m2 = c3054mApply;
                                int i54 = c3054m2.f8460a;
                                if (z6) {
                                    str = "";
                                } else {
                                    str = ", ctts invalid";
                                }
                                StringBuilder sb3 = new StringBuilder(str.length() + 262);
                                sb3.append("Inconsistent stbl box for track ");
                                sb3.append(i54);
                                sb3.append(": remainingSynchronizationSamples ");
                                sb3.append(i8);
                                sb3.append(", remainingSamplesAtTimestampDelta ");
                                sb3.append(iM3103w5);
                                sb3.append(", remainingSamplesInChunk ");
                                sb3.append(i53);
                                sb3.append(", remainingTimestampDeltaChanges ");
                                sb3.append(i49);
                                sb3.append(", remainingSamplesAtTimestampOffset ");
                                sb3.append(i12);
                                C1643a.m874r0(sb3, str, "AtomParsers");
                                iArr = iArrCopyOf;
                                i13 = i11;
                                jArr = jArrCopyOf;
                                iArr2 = iArrCopyOf2;
                                j4 = j12;
                            }
                            jM2985F = C2738e0.m2985F(j4, 1000000L, c3054m2.f8462c);
                            jArr2 = c3054m2.f8467h;
                            if (jArr2 == null) {
                                C2738e0.m2986G(jArrCopyOf2, 1000000L, c3054m2.f8462c);
                                c3057p = new C3057p(c3054m2, jArr, iArr, i13, jArrCopyOf2, iArr2, jM2985F);
                            } else {
                                if (jArr2.length == 1 || c3054m2.f8461b != 1 || jArrCopyOf2.length < 2) {
                                    i18 = i13;
                                    iArr3 = iArr2;
                                    jArr3 = jArr;
                                } else {
                                    long[] jArr18 = c3054m2.f8468i;
                                    Objects.requireNonNull(jArr18);
                                    long j13 = jArr18[0];
                                    jArr3 = jArr;
                                    i18 = i13;
                                    iArr3 = iArr2;
                                    long jM2985F3 = C2738e0.m2985F(c3054m2.f8467h[0], c3054m2.f8462c, c3054m2.f8463d) + j13;
                                    int length = jArrCopyOf2.length - 1;
                                    if (jArrCopyOf2[0] <= j13 && j13 < jArrCopyOf2[C2738e0.m3000h(4, 0, length)] && jArrCopyOf2[C2738e0.m3000h(jArrCopyOf2.length - 4, 0, length)] < jM2985F3 && jM2985F3 <= j4) {
                                        long j14 = j4 - jM2985F3;
                                        long jM2985F4 = C2738e0.m2985F(j13 - jArrCopyOf2[0], c3054m2.f8465f.f7137K, c3054m2.f8462c);
                                        long jM2985F5 = C2738e0.m2985F(j14, c3054m2.f8465f.f7137K, c3054m2.f8462c);
                                        if ((jM2985F4 != 0 || jM2985F5 != 0) && jM2985F4 <= 2147483647L && jM2985F5 <= 2147483647L) {
                                            c3115p.f8985b = (int) jM2985F4;
                                            c3115p.f8986c = (int) jM2985F5;
                                            C2738e0.m2986G(jArrCopyOf2, 1000000L, c3054m2.f8462c);
                                            c3057p2 = new C3057p(c3054m2, jArr3, iArr, i18, jArrCopyOf2, iArr3, C2738e0.m2985F(c3054m2.f8467h[0], 1000000L, c3054m2.f8463d));
                                        }
                                        c3057p = c3057p2;
                                    }
                                }
                                jArr4 = c3054m2.f8467h;
                                if (jArr4.length == 1 || jArr4[0] != 0) {
                                    if (c3054m2.f8461b == 1) {
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                    iArr4 = new int[jArr4.length];
                                    iArr5 = new int[jArr4.length];
                                    jArr5 = c3054m2.f8468i;
                                    Objects.requireNonNull(jArr5);
                                    i19 = 0;
                                    z9 = false;
                                    i20 = 0;
                                    i21 = 0;
                                    while (true) {
                                        jArr6 = c3054m2.f8467h;
                                        if (i19 >= jArr6.length) {
                                            break;
                                        }
                                        z12 = z9;
                                        i27 = i20;
                                        j7 = jArr5[i19];
                                        if (j7 != -1) {
                                            iArr10 = iArr5;
                                            long jM2985F6 = C2738e0.m2985F(jArr6[i19], c3054m2.f8462c, c3054m2.f8463d);
                                            iArr4[i19] = C2738e0.m2997e(jArrCopyOf2, j7, true, true);
                                            iArr10[i19] = C2738e0.m2994b(jArrCopyOf2, j7 + jM2985F6, z8, false);
                                            while (iArr4[i19] < iArr10[i19] && (iArr3[iArr4[i19]] & 1) == 0) {
                                                iArr4[i19] = iArr4[i19] + 1;
                                            }
                                            int i55 = (iArr10[i19] - iArr4[i19]) + i27;
                                            if (i21 != iArr4[i19]) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            i20 = i55;
                                            i21 = iArr10[i19];
                                            z9 = z12 | z13;
                                        } else {
                                            iArr10 = iArr5;
                                            i20 = i27;
                                            z9 = z12;
                                        }
                                        i19++;
                                        iArr5 = iArr10;
                                    }
                                    iArr6 = iArr5;
                                    boolean z17 = z9;
                                    if (i20 != iMo3708b) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    z11 = z17 | z10;
                                    if (z11) {
                                        jArr7 = new long[i20];
                                    } else {
                                        jArr7 = jArr3;
                                    }
                                    if (z11) {
                                        iArr7 = new int[i20];
                                    } else {
                                        iArr7 = iArr;
                                    }
                                    if (z11) {
                                        i22 = 0;
                                    } else {
                                        i22 = i18;
                                    }
                                    if (z11) {
                                        iArr8 = new int[i20];
                                    } else {
                                        iArr8 = iArr3;
                                    }
                                    jArr8 = new long[i20];
                                    i23 = 0;
                                    i24 = 0;
                                    j5 = 0;
                                    while (i23 < c3054m2.f8467h.length) {
                                        j6 = c3054m2.f8468i[i23];
                                        i25 = iArr4[i23];
                                        int[] iArr15 = iArr4;
                                        i26 = iArr6[i23];
                                        if (z11) {
                                            int i56 = i26 - i25;
                                            System.arraycopy(jArr3, i25, jArr7, i24, i56);
                                            System.arraycopy(iArr, i25, iArr7, i24, i56);
                                            iArr9 = iArr3;
                                            System.arraycopy(iArr9, i25, iArr8, i24, i56);
                                        } else {
                                            iArr9 = iArr3;
                                        }
                                        i22 = i22;
                                        while (i25 < i26) {
                                            int[] iArr16 = iArr8;
                                            int i57 = i26;
                                            int[] iArr17 = iArr9;
                                            long[] jArr19 = jArrCopyOf2;
                                            long j15 = j5;
                                            jArr8[i24] = C2738e0.m2985F(j5, 1000000L, c3054m2.f8463d) + C2738e0.m2985F(Math.max(0L, jArrCopyOf2[i25] - j6), 1000000L, c3054m2.f8462c);
                                            if (!z11 && iArr7[i24] > i22) {
                                                i22 = iArr[i25];
                                            }
                                            i24++;
                                            i25++;
                                            iArr8 = iArr16;
                                            j5 = j15;
                                            jArrCopyOf2 = jArr19;
                                            iArr9 = iArr17;
                                            i26 = i57;
                                        }
                                        j5 += c3054m2.f8467h[i23];
                                        i23++;
                                        iArr4 = iArr15;
                                        iArr8 = iArr8;
                                        iArr3 = iArr9;
                                        jArr3 = jArr3;
                                    }
                                    c3057p = new C3057p(c3054m2, jArr7, iArr7, i22, jArr8, iArr8, C2738e0.m2985F(j5, 1000000L, c3054m2.f8463d));
                                } else {
                                    long[] jArr20 = c3054m2.f8468i;
                                    Objects.requireNonNull(jArr20);
                                    long j16 = jArr20[0];
                                    for (int i58 = 0; i58 < jArrCopyOf2.length; i58++) {
                                        jArrCopyOf2[i58] = C2738e0.m2985F(jArrCopyOf2[i58] - j16, 1000000L, c3054m2.f8462c);
                                    }
                                    c3057p2 = new C3057p(c3054m2, jArr3, iArr, i18, jArrCopyOf2, iArr3, C2738e0.m2985F(j4 - j16, 1000000L, c3054m2.f8462c));
                                    c3057p = c3057p2;
                                }
                            }
                        } else {
                            iM3103w2 = 0;
                        }
                        iM3103w3 = -1;
                        i2 = i41;
                        iMo3707a = dVar.mo3707a();
                        arrayList = arrayList3;
                        String str3 = c3054mApply.f8465f.f7155w;
                        if (iMo3707a == -1) {
                            z5 = false;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            jArr9 = new long[iM3103w12];
                            iArr11 = new int[iM3103w12];
                            iM3103w9 = 0;
                            jM3101u2 = 0;
                            i28 = -1;
                            iM3103w10 = 0;
                            while (true) {
                                i28++;
                                if (i28 == iM3103w12) {
                                    z14 = false;
                                } else {
                                    if (z4) {
                                        jM3101u2 = c2757x7.m3104x();
                                    } else {
                                        jM3101u2 = c2757x7.m3101u();
                                    }
                                    if (i28 == iM3103w9) {
                                        iM3103w10 = c2757x8.m3103w();
                                        c2757x8.m3080F(4);
                                        i46--;
                                        if (i46 > 0) {
                                            iM3103w9 = c2757x8.m3103w() - 1;
                                        } else {
                                            iM3103w9 = -1;
                                        }
                                    }
                                    z14 = true;
                                }
                                if (z14) {
                                    break;
                                    break;
                                }
                                jArr9[i28] = jM3101u2;
                                iArr11[i28] = iM3103w10;
                            }
                            j8 = iM3103w16;
                            i29 = 8192 / iMo3707a;
                            iM2998f = 0;
                            while (i30 < iM3103w12) {
                                iM2998f += C2738e0.m2998f(iArr11[i30], i29);
                            }
                            jArr = new long[iM2998f];
                            iArr12 = new int[iM2998f];
                            jArr10 = new long[iM2998f];
                            iArr13 = new int[iM2998f];
                            i31 = 0;
                            i32 = 0;
                            i33 = 0;
                            i34 = 0;
                            while (i31 < iM3103w12) {
                                int i410 = iArr11[i31];
                                long j17 = jArr9[i31];
                                long[] jArr110 = jArr9;
                                int[] iArr18 = iArr11;
                                iMax = i34;
                                i35 = i410;
                                j9 = j17;
                                while (i35 > 0) {
                                    int iMin2 = Math.min(i29, i35);
                                    jArr[i33] = j9;
                                    iArr12[i33] = iMo3707a * iMin2;
                                    iMax = Math.max(iMax, iArr12[i33]);
                                    jArr10[i33] = ((long) i32) * j8;
                                    iArr13[i33] = 1;
                                    j9 += (long) iArr12[i33];
                                    i32 += iMin2;
                                    i35 -= iMin2;
                                    i33++;
                                    i29 = i29;
                                    iMo3707a = iMo3707a;
                                }
                                i31++;
                                i34 = iMax;
                                jArr9 = jArr110;
                                iArr11 = iArr18;
                            }
                            j4 = j8 * ((long) i32);
                            iArr2 = iArr13;
                            iArr = iArr12;
                            jArrCopyOf2 = jArr10;
                            i13 = i34;
                            c3054m2 = c3054mApply;
                        } else {
                            jArrCopyOf = new long[iMo3708b];
                            iArrCopyOf = new int[iMo3708b];
                            jArrCopyOf2 = new long[iMo3708b];
                            int i411 = iM3103w2;
                            iArrCopyOf2 = new int[iMo3708b];
                            i3 = 0;
                            i4 = 0;
                            iM3103w4 = 0;
                            j2 = 0;
                            j3 = 0;
                            jM3101u = 0;
                            i5 = -1;
                            i6 = iM3103w16;
                            iM3103w5 = iM3103w15;
                            i7 = iM3103w3;
                            i8 = i411;
                            iM3086f = 0;
                            iM3103w6 = 0;
                            int i412 = iM3103w14;
                            i9 = iM3103w;
                            i10 = 0;
                            i11 = 0;
                            while (i10 < iMo3708b) {
                                z7 = true;
                                int i59 = i3;
                                i14 = iMo3708b;
                                iM3103w7 = i59;
                                while (true) {
                                    if (i4 == 0) {
                                        i15 = i7;
                                        break;
                                    }
                                    i15 = i7;
                                    i17 = i5 + 1;
                                    if (i17 == iM3103w12) {
                                        z7 = false;
                                    } else {
                                        if (z4) {
                                            jM3101u = c2757x7.m3104x();
                                        } else {
                                            jM3101u = c2757x7.m3101u();
                                        }
                                        if (i17 == iM3103w7) {
                                            iM3103w4 = c2757x8.m3103w();
                                            c2757x8.m3080F(4);
                                            i46--;
                                            if (i46 > 0) {
                                                iM3103w7 = c2757x8.m3103w() - 1;
                                            } else {
                                                iM3103w7 = -1;
                                            }
                                        }
                                        z7 = true;
                                    }
                                    i5 = i17;
                                    if (z7) {
                                        break;
                                        break;
                                    }
                                    i4 = iM3103w4;
                                    j3 = jM3101u;
                                    i7 = i15;
                                }
                                if (!z7) {
                                    Log.w("AtomParsers", "Unexpected end of chunk data");
                                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i10);
                                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i10);
                                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i10);
                                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i10);
                                    iMo3708b = i10;
                                    break;
                                }
                                if (c2757x11 != null) {
                                    while (iM3103w6 == 0) {
                                        iM3103w6 = c2757x11.m3103w();
                                        iM3086f = c2757x11.m3086f();
                                        i9--;
                                    }
                                    iM3103w6--;
                                }
                                int i510 = iM3086f;
                                jArrCopyOf[i10] = j3;
                                iArrCopyOf[i10] = dVar.mo3709c();
                                if (iArrCopyOf[i10] > i11) {
                                    i11 = iArrCopyOf[i10];
                                }
                                C2757x c2757x13 = c2757x7;
                                boolean z18 = z4;
                                jArrCopyOf2[i10] = j2 + ((long) i510);
                                if (c2757x10 == null) {
                                    i16 = 1;
                                } else {
                                    i16 = 0;
                                }
                                iArrCopyOf2[i10] = i16;
                                iM3103w8 = i15;
                                if (i10 == iM3103w8) {
                                    iArrCopyOf2[i10] = 1;
                                    i8--;
                                    if (i8 > 0) {
                                        Objects.requireNonNull(c2757x10);
                                        iM3103w8 = c2757x10.m3103w() - 1;
                                    }
                                }
                                long[] jArr111 = jArrCopyOf2;
                                int iM3086f15 = i6;
                                int i511 = iM3103w7;
                                j2 += (long) iM3086f15;
                                iM3103w5--;
                                if (iM3103w5 != 0) {
                                }
                                j3 += (long) iArrCopyOf[i10];
                                i4--;
                                i10++;
                                iM3086f = i510;
                                iMo3708b = i14;
                                i3 = i511;
                                jArrCopyOf2 = jArr111;
                                i6 = iM3086f15;
                                z4 = z18;
                                i7 = iM3103w8;
                                c2757x7 = c2757x13;
                            }
                            int i512 = i4;
                            long j18 = j2 + ((long) iM3086f);
                            if (c2757x11 != null) {
                                z6 = true;
                                break;
                            }
                            while (true) {
                                if (i9 > 0) {
                                    z6 = true;
                                    break;
                                }
                                if (c2757x11.m3103w() != 0) {
                                    z6 = false;
                                    break;
                                }
                                c2757x11.m3086f();
                                i9--;
                            }
                            if (i8 != 0) {
                                i12 = iM3103w6;
                                c3054m2 = c3054mApply;
                                int i513 = c3054m2.f8460a;
                                if (z6) {
                                    str = ", ctts invalid";
                                } else {
                                    str = "";
                                }
                                StringBuilder sb4 = new StringBuilder(str.length() + 262);
                                sb4.append("Inconsistent stbl box for track ");
                                sb4.append(i513);
                                sb4.append(": remainingSynchronizationSamples ");
                                sb4.append(i8);
                                sb4.append(", remainingSamplesAtTimestampDelta ");
                                sb4.append(iM3103w5);
                                sb4.append(", remainingSamplesInChunk ");
                                sb4.append(i512);
                                sb4.append(", remainingTimestampDeltaChanges ");
                                sb4.append(i412);
                                sb4.append(", remainingSamplesAtTimestampOffset ");
                                sb4.append(i12);
                                C1643a.m874r0(sb4, str, "AtomParsers");
                            } else {
                                i12 = iM3103w6;
                                c3054m2 = c3054mApply;
                                int i514 = c3054m2.f8460a;
                                if (z6) {
                                    str = ", ctts invalid";
                                } else {
                                    str = "";
                                }
                                StringBuilder sb5 = new StringBuilder(str.length() + 262);
                                sb5.append("Inconsistent stbl box for track ");
                                sb5.append(i514);
                                sb5.append(": remainingSynchronizationSamples ");
                                sb5.append(i8);
                                sb5.append(", remainingSamplesAtTimestampDelta ");
                                sb5.append(iM3103w5);
                                sb5.append(", remainingSamplesInChunk ");
                                sb5.append(i512);
                                sb5.append(", remainingTimestampDeltaChanges ");
                                sb5.append(i412);
                                sb5.append(", remainingSamplesAtTimestampOffset ");
                                sb5.append(i12);
                                C1643a.m874r0(sb5, str, "AtomParsers");
                            }
                            iArr = iArrCopyOf;
                            i13 = i11;
                            jArr = jArrCopyOf;
                            iArr2 = iArrCopyOf2;
                            j4 = j18;
                        }
                        jM2985F = C2738e0.m2985F(j4, 1000000L, c3054m2.f8462c);
                        jArr2 = c3054m2.f8467h;
                        if (jArr2 == null) {
                            C2738e0.m2986G(jArrCopyOf2, 1000000L, c3054m2.f8462c);
                            c3057p = new C3057p(c3054m2, jArr, iArr, i13, jArrCopyOf2, iArr2, jM2985F);
                        } else {
                            if (jArr2.length == 1) {
                                i18 = i13;
                                iArr3 = iArr2;
                                jArr3 = jArr;
                                jArr4 = c3054m2.f8467h;
                                if (jArr4.length == 1) {
                                }
                                if (c3054m2.f8461b == 1) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                iArr4 = new int[jArr4.length];
                                iArr5 = new int[jArr4.length];
                                jArr5 = c3054m2.f8468i;
                                Objects.requireNonNull(jArr5);
                                i19 = 0;
                                z9 = false;
                                i20 = 0;
                                i21 = 0;
                                while (true) {
                                    jArr6 = c3054m2.f8467h;
                                    if (i19 >= jArr6.length) {
                                        break;
                                        break;
                                    }
                                    z12 = z9;
                                    i27 = i20;
                                    j7 = jArr5[i19];
                                    if (j7 != -1) {
                                        iArr10 = iArr5;
                                        long jM2985F7 = C2738e0.m2985F(jArr6[i19], c3054m2.f8462c, c3054m2.f8463d);
                                        iArr4[i19] = C2738e0.m2997e(jArrCopyOf2, j7, true, true);
                                        iArr10[i19] = C2738e0.m2994b(jArrCopyOf2, j7 + jM2985F7, z8, false);
                                        while (iArr4[i19] < iArr10[i19]) {
                                            iArr4[i19] = iArr4[i19] + 1;
                                        }
                                        int i515 = (iArr10[i19] - iArr4[i19]) + i27;
                                        if (i21 != iArr4[i19]) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        i20 = i515;
                                        i21 = iArr10[i19];
                                        z9 = z12 | z13;
                                    } else {
                                        iArr10 = iArr5;
                                        i20 = i27;
                                        z9 = z12;
                                    }
                                    i19++;
                                    iArr5 = iArr10;
                                }
                                iArr6 = iArr5;
                                boolean z19 = z9;
                                if (i20 != iMo3708b) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                z11 = z19 | z10;
                                if (z11) {
                                    jArr7 = new long[i20];
                                } else {
                                    jArr7 = jArr3;
                                }
                                if (z11) {
                                    iArr7 = new int[i20];
                                } else {
                                    iArr7 = iArr;
                                }
                                if (z11) {
                                    i22 = 0;
                                } else {
                                    i22 = i18;
                                }
                                if (z11) {
                                    iArr8 = new int[i20];
                                } else {
                                    iArr8 = iArr3;
                                }
                                jArr8 = new long[i20];
                                i23 = 0;
                                i24 = 0;
                                j5 = 0;
                                while (i23 < c3054m2.f8467h.length) {
                                    j6 = c3054m2.f8468i[i23];
                                    i25 = iArr4[i23];
                                    int[] iArr19 = iArr4;
                                    i26 = iArr6[i23];
                                    if (z11) {
                                        int i516 = i26 - i25;
                                        System.arraycopy(jArr3, i25, jArr7, i24, i516);
                                        System.arraycopy(iArr, i25, iArr7, i24, i516);
                                        iArr9 = iArr3;
                                        System.arraycopy(iArr9, i25, iArr8, i24, i516);
                                    } else {
                                        iArr9 = iArr3;
                                    }
                                    i22 = i22;
                                    while (i25 < i26) {
                                        int[] iArr110 = iArr8;
                                        int i517 = i26;
                                        int[] iArr111 = iArr9;
                                        long[] jArr112 = jArrCopyOf2;
                                        long j19 = j5;
                                        jArr8[i24] = C2738e0.m2985F(j5, 1000000L, c3054m2.f8463d) + C2738e0.m2985F(Math.max(0L, jArrCopyOf2[i25] - j6), 1000000L, c3054m2.f8462c);
                                        if (!z11) {
                                        }
                                        i24++;
                                        i25++;
                                        iArr8 = iArr110;
                                        j5 = j19;
                                        jArrCopyOf2 = jArr112;
                                        iArr9 = iArr111;
                                        i26 = i517;
                                    }
                                    j5 += c3054m2.f8467h[i23];
                                    i23++;
                                    iArr4 = iArr19;
                                    iArr8 = iArr8;
                                    iArr3 = iArr9;
                                    jArr3 = jArr3;
                                }
                                c3057p = new C3057p(c3054m2, jArr7, iArr7, i22, jArr8, iArr8, C2738e0.m2985F(j5, 1000000L, c3054m2.f8463d));
                            } else {
                                i18 = i13;
                                iArr3 = iArr2;
                                jArr3 = jArr;
                                jArr4 = c3054m2.f8467h;
                                if (jArr4.length == 1) {
                                }
                                if (c3054m2.f8461b == 1) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                iArr4 = new int[jArr4.length];
                                iArr5 = new int[jArr4.length];
                                jArr5 = c3054m2.f8468i;
                                Objects.requireNonNull(jArr5);
                                i19 = 0;
                                z9 = false;
                                i20 = 0;
                                i21 = 0;
                                while (true) {
                                    jArr6 = c3054m2.f8467h;
                                    if (i19 >= jArr6.length) {
                                        break;
                                        break;
                                    }
                                    z12 = z9;
                                    i27 = i20;
                                    j7 = jArr5[i19];
                                    if (j7 != -1) {
                                        iArr10 = iArr5;
                                        long jM2985F8 = C2738e0.m2985F(jArr6[i19], c3054m2.f8462c, c3054m2.f8463d);
                                        iArr4[i19] = C2738e0.m2997e(jArrCopyOf2, j7, true, true);
                                        iArr10[i19] = C2738e0.m2994b(jArrCopyOf2, j7 + jM2985F8, z8, false);
                                        while (iArr4[i19] < iArr10[i19]) {
                                            iArr4[i19] = iArr4[i19] + 1;
                                        }
                                        int i518 = (iArr10[i19] - iArr4[i19]) + i27;
                                        if (i21 != iArr4[i19]) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        i20 = i518;
                                        i21 = iArr10[i19];
                                        z9 = z12 | z13;
                                    } else {
                                        iArr10 = iArr5;
                                        i20 = i27;
                                        z9 = z12;
                                    }
                                    i19++;
                                    iArr5 = iArr10;
                                }
                                iArr6 = iArr5;
                                boolean z110 = z9;
                                if (i20 != iMo3708b) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                z11 = z110 | z10;
                                if (z11) {
                                    jArr7 = new long[i20];
                                } else {
                                    jArr7 = jArr3;
                                }
                                if (z11) {
                                    iArr7 = new int[i20];
                                } else {
                                    iArr7 = iArr;
                                }
                                if (z11) {
                                    i22 = 0;
                                } else {
                                    i22 = i18;
                                }
                                if (z11) {
                                    iArr8 = new int[i20];
                                } else {
                                    iArr8 = iArr3;
                                }
                                jArr8 = new long[i20];
                                i23 = 0;
                                i24 = 0;
                                j5 = 0;
                                while (i23 < c3054m2.f8467h.length) {
                                    j6 = c3054m2.f8468i[i23];
                                    i25 = iArr4[i23];
                                    int[] iArr112 = iArr4;
                                    i26 = iArr6[i23];
                                    if (z11) {
                                        int i519 = i26 - i25;
                                        System.arraycopy(jArr3, i25, jArr7, i24, i519);
                                        System.arraycopy(iArr, i25, iArr7, i24, i519);
                                        iArr9 = iArr3;
                                        System.arraycopy(iArr9, i25, iArr8, i24, i519);
                                    } else {
                                        iArr9 = iArr3;
                                    }
                                    i22 = i22;
                                    while (i25 < i26) {
                                        int[] iArr113 = iArr8;
                                        int i5110 = i26;
                                        int[] iArr114 = iArr9;
                                        long[] jArr113 = jArrCopyOf2;
                                        long j110 = j5;
                                        jArr8[i24] = C2738e0.m2985F(j5, 1000000L, c3054m2.f8463d) + C2738e0.m2985F(Math.max(0L, jArrCopyOf2[i25] - j6), 1000000L, c3054m2.f8462c);
                                        if (!z11) {
                                        }
                                        i24++;
                                        i25++;
                                        iArr8 = iArr113;
                                        j5 = j110;
                                        jArrCopyOf2 = jArr113;
                                        iArr9 = iArr114;
                                        i26 = i5110;
                                    }
                                    j5 += c3054m2.f8467h[i23];
                                    i23++;
                                    iArr4 = iArr112;
                                    iArr8 = iArr8;
                                    iArr3 = iArr9;
                                    jArr3 = jArr3;
                                }
                                c3057p = new C3057p(c3054m2, jArr7, iArr7, i22, jArr8, iArr8, C2738e0.m2985F(j5, 1000000L, c3054m2.f8463d));
                            }
                            c3057p = c3057p2;
                        }
                    }
                    arrayList2 = arrayList;
                    arrayList2.add(c3057p);
                }
            }
            i41 = i2 + 1;
            arrayList3 = arrayList2;
        }
        return arrayList3;
    }
}
