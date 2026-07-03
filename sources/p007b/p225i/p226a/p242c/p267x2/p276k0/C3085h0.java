package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.net.Uri;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2736d0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.h0 */
/* JADX INFO: compiled from: TsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3085h0 implements InterfaceC3031h {

    /* JADX INFO: renamed from: a */
    public final int f8635a;

    /* JADX INFO: renamed from: b */
    public final int f8636b;

    /* JADX INFO: renamed from: c */
    public final List<C2736d0> f8637c;

    /* JADX INFO: renamed from: d */
    public final C2757x f8638d;

    /* JADX INFO: renamed from: e */
    public final SparseIntArray f8639e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC3087i0.c f8640f;

    /* JADX INFO: renamed from: g */
    public final SparseArray<InterfaceC3087i0> f8641g;

    /* JADX INFO: renamed from: h */
    public final SparseBooleanArray f8642h;

    /* JADX INFO: renamed from: i */
    public final SparseBooleanArray f8643i;

    /* JADX INFO: renamed from: j */
    public final C3083g0 f8644j;

    /* JADX INFO: renamed from: k */
    public C3081f0 f8645k;

    /* JADX INFO: renamed from: l */
    public InterfaceC3058j f8646l;

    /* JADX INFO: renamed from: m */
    public int f8647m;

    /* JADX INFO: renamed from: n */
    public boolean f8648n;

    /* JADX INFO: renamed from: o */
    public boolean f8649o;

    /* JADX INFO: renamed from: p */
    public boolean f8650p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public InterfaceC3087i0 f8651q;

    /* JADX INFO: renamed from: r */
    public int f8652r;

    /* JADX INFO: renamed from: s */
    public int f8653s;

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.h0$a */
    /* JADX INFO: compiled from: TsExtractor.java */
    public class a implements InterfaceC3075c0 {

        /* JADX INFO: renamed from: a */
        public final C2756w f8654a = new C2756w(new byte[4]);

        public a() {
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3075c0
        /* JADX INFO: renamed from: a */
        public void mo3752a(C2736d0 c2736d0, InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3075c0
        /* JADX INFO: renamed from: b */
        public void mo3753b(C2757x c2757x) {
            if (c2757x.m3100t() == 0 && (c2757x.m3100t() & 128) != 0) {
                c2757x.m3080F(6);
                int iM3081a = c2757x.m3081a() / 4;
                for (int i = 0; i < iM3081a; i++) {
                    c2757x.m3084d(this.f8654a, 4);
                    int iM3067g = this.f8654a.m3067g(16);
                    this.f8654a.m3073m(3);
                    if (iM3067g == 0) {
                        this.f8654a.m3073m(13);
                    } else {
                        int iM3067g2 = this.f8654a.m3067g(13);
                        if (C3085h0.this.f8641g.get(iM3067g2) == null) {
                            C3085h0 c3085h0 = C3085h0.this;
                            c3085h0.f8641g.put(iM3067g2, new C3077d0(c3085h0.new b(iM3067g2)));
                            C3085h0.this.f8647m++;
                        }
                    }
                }
                C3085h0 c3085h1 = C3085h0.this;
                if (c3085h1.f8635a != 2) {
                    c3085h1.f8641g.remove(0);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.h0$b */
    /* JADX INFO: compiled from: TsExtractor.java */
    public class b implements InterfaceC3075c0 {

        /* JADX INFO: renamed from: a */
        public final C2756w f8656a = new C2756w(new byte[5]);

        /* JADX INFO: renamed from: b */
        public final SparseArray<InterfaceC3087i0> f8657b = new SparseArray<>();

        /* JADX INFO: renamed from: c */
        public final SparseIntArray f8658c = new SparseIntArray();

        /* JADX INFO: renamed from: d */
        public final int f8659d;

        public b(int i) {
            this.f8659d = i;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3075c0
        /* JADX INFO: renamed from: a */
        public void mo3752a(C2736d0 c2736d0, InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        }

        /* JADX WARN: Code duplicated, block: B:47:0x012c  */
        /* JADX WARN: Code duplicated, block: B:51:0x0134  */
        /* JADX WARN: Code duplicated, block: B:56:0x0141  */
        @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3075c0
        /* JADX INFO: renamed from: b */
        public void mo3753b(C2757x c2757x) {
            C2736d0 c2736d0;
            C2736d0 c2736d1;
            int i;
            int i2;
            int i3;
            C2736d0 c2736d2;
            int i4;
            if (c2757x.m3100t() != 2) {
                return;
            }
            C3085h0 c3085h0 = C3085h0.this;
            int i5 = c3085h0.f8635a;
            if (i5 == 1 || i5 == 2 || c3085h0.f8647m == 1) {
                c2736d0 = c3085h0.f8637c.get(0);
            } else {
                c2736d0 = new C2736d0(c3085h0.f8637c.get(0).m2974c());
                C3085h0.this.f8637c.add(c2736d0);
            }
            if ((c2757x.m3100t() & 128) == 0) {
                return;
            }
            c2757x.m3080F(1);
            int iM3105y = c2757x.m3105y();
            int i6 = 3;
            c2757x.m3080F(3);
            c2757x.m3084d(this.f8656a, 2);
            this.f8656a.m3073m(3);
            int i7 = 13;
            C3085h0.this.f8653s = this.f8656a.m3067g(13);
            c2757x.m3084d(this.f8656a, 2);
            int i8 = 4;
            this.f8656a.m3073m(4);
            int i9 = 12;
            c2757x.m3080F(this.f8656a.m3067g(12));
            C3085h0 c3085h1 = C3085h0.this;
            int i10 = 21;
            if (c3085h1.f8635a == 2 && c3085h1.f8651q == null) {
                InterfaceC3087i0.b bVar = new InterfaceC3087i0.b(21, null, null, C2738e0.f6713f);
                C3085h0 c3085h2 = C3085h0.this;
                c3085h2.f8651q = c3085h2.f8640f.mo3764a(21, bVar);
                C3085h0 c3085h3 = C3085h0.this;
                InterfaceC3087i0 interfaceC3087i0 = c3085h3.f8651q;
                if (interfaceC3087i0 != null) {
                    interfaceC3087i0.mo3754a(c2736d0, c3085h3.f8646l, new InterfaceC3087i0.d(iM3105y, 21, 8192));
                }
            }
            this.f8657b.clear();
            this.f8658c.clear();
            int iM3081a = c2757x.m3081a();
            while (iM3081a > 0) {
                int i11 = 5;
                c2757x.m3084d(this.f8656a, 5);
                int iM3067g = this.f8656a.m3067g(8);
                this.f8656a.m3073m(i6);
                int iM3067g2 = this.f8656a.m3067g(i7);
                this.f8656a.m3073m(i8);
                int iM3067g3 = this.f8656a.m3067g(i9);
                int i12 = c2757x.f6794b;
                int i13 = iM3067g3 + i12;
                int i14 = -1;
                String strTrim = null;
                ArrayList arrayList = null;
                while (c2757x.f6794b < i13) {
                    int iM3100t = c2757x.m3100t();
                    int iM3100t2 = c2757x.f6794b + c2757x.m3100t();
                    if (iM3100t2 > i13) {
                        break;
                    }
                    if (iM3100t == i11) {
                        long jM3101u = c2757x.m3101u();
                        if (jM3101u == 1094921523) {
                            i14 = Opcodes.LOR;
                        } else if (jM3101u == 1161904947) {
                            i14 = Opcodes.I2D;
                        } else if (jM3101u == 1094921524) {
                            i14 = Opcodes.IRETURN;
                        } else if (jM3101u == 1212503619) {
                            i14 = 36;
                        }
                        i3 = iM3105y;
                        c2736d2 = c2736d0;
                        i4 = iM3067g2;
                    } else {
                        if (iM3100t == 106) {
                            i14 = Opcodes.LOR;
                        } else if (iM3100t == 122) {
                            i14 = Opcodes.I2D;
                        } else if (iM3100t == 127) {
                            if (c2757x.m3100t() == i10) {
                                i14 = Opcodes.IRETURN;
                            }
                        } else if (iM3100t == 123) {
                            i14 = Opcodes.L2D;
                        } else if (iM3100t == 10) {
                            strTrim = c2757x.m3097q(3).trim();
                            i3 = iM3105y;
                            c2736d2 = c2736d0;
                            i4 = iM3067g2;
                        } else {
                            int i15 = 3;
                            if (iM3100t == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (c2757x.f6794b < iM3100t2) {
                                    String strTrim2 = c2757x.m3097q(i15).trim();
                                    int iM3100t3 = c2757x.m3100t();
                                    byte[] bArr = new byte[4];
                                    System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, 4);
                                    c2757x.f6794b += 4;
                                    arrayList2.add(new InterfaceC3087i0.a(strTrim2, iM3100t3, bArr));
                                    c2736d0 = c2736d0;
                                    iM3105y = iM3105y;
                                    iM3067g2 = iM3067g2;
                                    i15 = 3;
                                }
                                i3 = iM3105y;
                                c2736d2 = c2736d0;
                                i4 = iM3067g2;
                                arrayList = arrayList2;
                                i14 = 89;
                            } else {
                                i3 = iM3105y;
                                c2736d2 = c2736d0;
                                i4 = iM3067g2;
                                if (iM3100t == 111) {
                                    i14 = 257;
                                }
                            }
                        }
                        i3 = iM3105y;
                        c2736d2 = c2736d0;
                        i4 = iM3067g2;
                    }
                    c2757x.m3080F(iM3100t2 - c2757x.f6794b);
                    c2736d0 = c2736d2;
                    iM3105y = i3;
                    iM3067g2 = i4;
                    i11 = 5;
                    i10 = 21;
                }
                int i16 = iM3105y;
                C2736d0 c2736d3 = c2736d0;
                int i17 = iM3067g2;
                c2757x.m3079E(i13);
                InterfaceC3087i0.b bVar2 = new InterfaceC3087i0.b(i14, strTrim, arrayList, Arrays.copyOfRange(c2757x.f6793a, i12, i13));
                if (iM3067g == 6 || iM3067g == 5) {
                    iM3067g = i14;
                }
                iM3081a -= iM3067g3 + 5;
                C3085h0 c3085h4 = C3085h0.this;
                int i18 = c3085h4.f8635a == 2 ? iM3067g : i17;
                if (!c3085h4.f8642h.get(i18)) {
                    C3085h0 c3085h5 = C3085h0.this;
                    InterfaceC3087i0 interfaceC3087i0Mo3764a = (c3085h5.f8635a == 2 && iM3067g == 21) ? c3085h5.f8651q : c3085h5.f8640f.mo3764a(iM3067g, bVar2);
                    if (C3085h0.this.f8635a == 2) {
                        i2 = i17;
                        if (i2 < this.f8658c.get(i18, 8192)) {
                        }
                    } else {
                        i2 = i17;
                    }
                    this.f8658c.put(i18, i2);
                    this.f8657b.put(i18, interfaceC3087i0Mo3764a);
                }
                c2736d0 = c2736d3;
                iM3105y = i16;
                i6 = 3;
                i8 = 4;
                i7 = 13;
                i9 = 12;
                i10 = 21;
            }
            int i19 = iM3105y;
            C2736d0 c2736d4 = c2736d0;
            int size = this.f8658c.size();
            int i20 = 0;
            while (i20 < size) {
                int iKeyAt = this.f8658c.keyAt(i20);
                int iValueAt = this.f8658c.valueAt(i20);
                C3085h0.this.f8642h.put(iKeyAt, true);
                C3085h0.this.f8643i.put(iValueAt, true);
                InterfaceC3087i0 interfaceC3087i0ValueAt = this.f8657b.valueAt(i20);
                if (interfaceC3087i0ValueAt != null) {
                    C3085h0 c3085h6 = C3085h0.this;
                    if (interfaceC3087i0ValueAt != c3085h6.f8651q) {
                        InterfaceC3058j interfaceC3058j = c3085h6.f8646l;
                        i = i19;
                        InterfaceC3087i0.d dVar = new InterfaceC3087i0.d(i, iKeyAt, 8192);
                        c2736d1 = c2736d4;
                        interfaceC3087i0ValueAt.mo3754a(c2736d1, interfaceC3058j, dVar);
                    } else {
                        c2736d1 = c2736d4;
                        i = i19;
                    }
                    C3085h0.this.f8641g.put(iValueAt, interfaceC3087i0ValueAt);
                } else {
                    c2736d1 = c2736d4;
                    i = i19;
                }
                i20++;
                c2736d4 = c2736d1;
                i19 = i;
            }
            C3085h0 c3085h7 = C3085h0.this;
            if (c3085h7.f8635a == 2) {
                if (c3085h7.f8648n) {
                    return;
                }
                c3085h7.f8646l.mo2486j();
                C3085h0 c3085h8 = C3085h0.this;
                c3085h8.f8647m = 0;
                c3085h8.f8648n = true;
                return;
            }
            c3085h7.f8641g.remove(this.f8659d);
            C3085h0 c3085h9 = C3085h0.this;
            int i21 = c3085h9.f8635a == 1 ? 0 : c3085h9.f8647m - 1;
            c3085h9.f8647m = i21;
            if (i21 == 0) {
                c3085h9.f8646l.mo2486j();
                C3085h0.this.f8648n = true;
            }
        }
    }

    static {
        C3078e c3078e = new InterfaceC3106l() { // from class: b.i.a.c.x2.k0.e
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3085h0(1, 0, 112800)};
            }

            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: b */
            public /* synthetic */ InterfaceC3031h[] mo3631b(Uri uri, Map map) {
                return C3069k.m3748a(this, uri, map);
            }
        };
    }

    public C3085h0(int i, int i2, int i3) {
        C2736d0 c2736d0 = new C2736d0(0L);
        C3091l c3091l = new C3091l(i2);
        this.f8640f = c3091l;
        this.f8636b = i3;
        this.f8635a = i;
        if (i == 1 || i == 2) {
            this.f8637c = Collections.singletonList(c2736d0);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f8637c = arrayList;
            arrayList.add(c2736d0);
        }
        this.f8638d = new C2757x(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.f8642h = sparseBooleanArray;
        this.f8643i = new SparseBooleanArray();
        SparseArray<InterfaceC3087i0> sparseArray = new SparseArray<>();
        this.f8641g = sparseArray;
        this.f8639e = new SparseIntArray();
        this.f8644j = new C3083g0(i3);
        this.f8646l = InterfaceC3058j.f8501d;
        this.f8653s = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray<InterfaceC3087i0> sparseArrayM3775b = c3091l.m3775b();
        int size = sparseArrayM3775b.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f8641g.put(sparseArrayM3775b.keyAt(i4), sparseArrayM3775b.valueAt(i4));
        }
        this.f8641g.put(0, new C3077d0(new a()));
        this.f8651q = null;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        boolean z2;
        byte[] bArr = this.f8638d.f6793a;
        interfaceC3041i.mo3652o(bArr, 0, 940);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z2 = true;
                    break;
                }
                if (bArr[(i2 * Opcodes.NEWARRAY) + i] != 71) {
                    z2 = false;
                    break;
                }
                i2++;
            }
            if (z2) {
                interfaceC3041i.mo3650l(i);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        ?? r0;
        ?? r1;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        long jMo3642b = interfaceC3041i.mo3642b();
        int i2 = 1;
        if (this.f8648n) {
            long j = -9223372036854775807L;
            if ((jMo3642b == -1 || this.f8635a == 2) ? false : true) {
                C3083g0 c3083g0 = this.f8644j;
                if (!c3083g0.f8626d) {
                    int i3 = this.f8653s;
                    if (i3 <= 0) {
                        c3083g0.m3763a(interfaceC3041i);
                        return 0;
                    }
                    if (!c3083g0.f8628f) {
                        long jMo3642b2 = interfaceC3041i.mo3642b();
                        int iMin = (int) Math.min(c3083g0.f8623a, jMo3642b2);
                        long j2 = jMo3642b2 - ((long) iMin);
                        if (interfaceC3041i.getPosition() != j2) {
                            c3118s.f8992a = j2;
                        } else {
                            c3083g0.f8625c.m3075A(iMin);
                            interfaceC3041i.mo3649k();
                            interfaceC3041i.mo3652o(c3083g0.f8625c.f6793a, 0, iMin);
                            C2757x c2757x = c3083g0.f8625c;
                            int i4 = c2757x.f6794b;
                            int i5 = c2757x.f6795c;
                            for (int i6 = i5 - 188; i6 >= i4; i6--) {
                                byte[] bArr = c2757x.f6793a;
                                int i7 = -4;
                                int i8 = 0;
                                while (true) {
                                    if (i7 > 4) {
                                        z4 = false;
                                        break;
                                    }
                                    int i9 = (i7 * Opcodes.NEWARRAY) + i6;
                                    if (i9 >= i4 && i9 < i5 && bArr[i9] == 71) {
                                        i8++;
                                        if (i8 == 5) {
                                            z4 = true;
                                            break;
                                        }
                                    } else {
                                        i8 = 0;
                                    }
                                    i7++;
                                }
                                if (z4) {
                                    long jM449K1 = C1460d.m449K1(c2757x, i6, i3);
                                    if (jM449K1 != -9223372036854775807L) {
                                        j = jM449K1;
                                        break;
                                    }
                                }
                            }
                            c3083g0.f8630h = j;
                            c3083g0.f8628f = true;
                            i2 = 0;
                        }
                    } else {
                        if (c3083g0.f8630h == -9223372036854775807L) {
                            c3083g0.m3763a(interfaceC3041i);
                            return 0;
                        }
                        if (c3083g0.f8627e) {
                            long j3 = c3083g0.f8629g;
                            if (j3 == -9223372036854775807L) {
                                c3083g0.m3763a(interfaceC3041i);
                                return 0;
                            }
                            long jM2973b = c3083g0.f8624b.m2973b(c3083g0.f8630h) - c3083g0.f8624b.m2973b(j3);
                            c3083g0.f8631i = jM2973b;
                            if (jM2973b < 0) {
                                Log.w("TsDurationReader", C1643a.m855i(65, "Invalid duration: ", jM2973b, ". Using TIME_UNSET instead."));
                                c3083g0.f8631i = -9223372036854775807L;
                            }
                            c3083g0.m3763a(interfaceC3041i);
                            return 0;
                        }
                        int iMin2 = (int) Math.min(c3083g0.f8623a, interfaceC3041i.mo3642b());
                        long j4 = 0;
                        if (interfaceC3041i.getPosition() != j4) {
                            c3118s.f8992a = j4;
                        } else {
                            c3083g0.f8625c.m3075A(iMin2);
                            interfaceC3041i.mo3649k();
                            interfaceC3041i.mo3652o(c3083g0.f8625c.f6793a, 0, iMin2);
                            C2757x c2757x2 = c3083g0.f8625c;
                            int i10 = c2757x2.f6795c;
                            for (int i11 = c2757x2.f6794b; i11 < i10; i11++) {
                                if (c2757x2.f6793a[i11] == 71) {
                                    long jM449K2 = C1460d.m449K1(c2757x2, i11, i3);
                                    if (jM449K2 != -9223372036854775807L) {
                                        j = jM449K2;
                                        break;
                                    }
                                }
                            }
                            c3083g0.f8629g = j;
                            c3083g0.f8627e = true;
                            i2 = 0;
                        }
                    }
                    return i2;
                }
            }
            if (!this.f8649o) {
                this.f8649o = true;
                C3083g0 c3083g1 = this.f8644j;
                long j5 = c3083g1.f8631i;
                if (j5 != -9223372036854775807L) {
                    C3081f0 c3081f0 = new C3081f0(c3083g1.f8624b, j5, jMo3642b, this.f8653s, this.f8636b);
                    this.f8645k = c3081f0;
                    this.f8646l.mo2477a(c3081f0.f8030a);
                } else {
                    this.f8646l.mo2477a(new InterfaceC3119t.b(j5, 0L));
                }
            }
            if (this.f8650p) {
                z3 = false;
                this.f8650p = false;
                mo3637g(0L, 0L);
                if (interfaceC3041i.getPosition() != 0) {
                    c3118s.f8992a = 0L;
                    return 1;
                }
            } else {
                z3 = false;
            }
            r1 = 1;
            r1 = 1;
            C3081f0 c3081f1 = this.f8645k;
            r0 = z3;
            if (c3081f1 != null && c3081f1.m3614b()) {
                r0 = z3;
                return this.f8645k.m3613a(interfaceC3041i, c3118s);
            }
        } else {
            r0 = 0;
            r1 = 1;
        }
        r0 = z3;
        C2757x c2757x3 = this.f8638d;
        byte[] bArr2 = c2757x3.f6793a;
        if (9400 - c2757x3.f6794b < 188) {
            int iM3081a = c2757x3.m3081a();
            if (iM3081a > 0) {
                System.arraycopy(bArr2, this.f8638d.f6794b, bArr2, r0, iM3081a);
            }
            this.f8638d.m3077C(bArr2, iM3081a);
        }
        while (true) {
            if (this.f8638d.m3081a() >= 188) {
                z2 = true;
                break;
            }
            int i12 = this.f8638d.f6795c;
            int i13 = interfaceC3041i.read(bArr2, i12, 9400 - i12);
            if (i13 == -1) {
                z2 = false;
                break;
            }
            this.f8638d.m3078D(i12 + i13);
        }
        if (!z2) {
            return -1;
        }
        C2757x c2757x4 = this.f8638d;
        int i14 = c2757x4.f6794b;
        int i15 = c2757x4.f6795c;
        byte[] bArr3 = c2757x4.f6793a;
        int i16 = i14;
        while (i16 < i15 && bArr3[i16] != 71) {
            i16++;
        }
        this.f8638d.m3079E(i16);
        int i17 = i16 + Opcodes.NEWARRAY;
        if (i17 > i15) {
            int i18 = (i16 - i14) + this.f8652r;
            this.f8652r = i18;
            i = 2;
            if (this.f8635a == 2 && i18 > 376) {
                throw ParserException.m8755a("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            i = 2;
            this.f8652r = r0;
        }
        C2757x c2757x5 = this.f8638d;
        int i19 = c2757x5.f6795c;
        if (i17 > i19) {
            return r0;
        }
        int iM3086f = c2757x5.m3086f();
        if ((8388608 & iM3086f) != 0) {
            this.f8638d.m3079E(i17);
            return r0;
        }
        int i20 = ((4194304 & iM3086f) != 0 ? 1 : 0) | 0;
        int i21 = (2096896 & iM3086f) >> 8;
        boolean z5 = (iM3086f & 32) != 0;
        InterfaceC3087i0 interfaceC3087i0 = (iM3086f & 16) != 0 ? this.f8641g.get(i21) : null;
        if (interfaceC3087i0 == null) {
            this.f8638d.m3079E(i17);
            return r0;
        }
        if (this.f8635a != i) {
            int i22 = iM3086f & 15;
            int i23 = this.f8639e.get(i21, i22 - 1);
            this.f8639e.put(i21, i22);
            if (i23 == i22) {
                this.f8638d.m3079E(i17);
                return r0;
            }
            if (i22 != ((i23 + r1) & 15)) {
                interfaceC3087i0.mo3756c();
            }
        }
        if (z5) {
            int iM3100t = this.f8638d.m3100t();
            i20 |= (this.f8638d.m3100t() & 64) != 0 ? 2 : 0;
            this.f8638d.m3080F(iM3100t - r1);
        }
        boolean z6 = this.f8648n;
        if (this.f8635a == i || z6 || !this.f8643i.get(i21, r0)) {
            this.f8638d.m3078D(i17);
            interfaceC3087i0.mo3755b(this.f8638d, i20);
            this.f8638d.m3078D(i19);
        }
        if (this.f8635a != i && !z6 && this.f8648n && jMo3642b != -1) {
            this.f8650p = r1;
        }
        this.f8638d.m3079E(i17);
        return r0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8646l = interfaceC3058j;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        C3081f0 c3081f0;
        C1460d.m426D(this.f8635a != 2);
        int size = this.f8637c.size();
        for (int i = 0; i < size; i++) {
            C2736d0 c2736d0 = this.f8637c.get(i);
            boolean z2 = c2736d0.m2975d() == -9223372036854775807L;
            if (!z2) {
                long jM2974c = c2736d0.m2974c();
                z2 = (jM2974c == -9223372036854775807L || jM2974c == 0 || jM2974c == j2) ? false : true;
            }
            if (z2) {
                c2736d0.m2976e(j2);
            }
        }
        if (j2 != 0 && (c3081f0 = this.f8645k) != null) {
            c3081f0.m3617e(j2);
        }
        this.f8638d.m3075A(0);
        this.f8639e.clear();
        for (int i2 = 0; i2 < this.f8641g.size(); i2++) {
            this.f8641g.valueAt(i2).mo3756c();
        }
        this.f8652r = 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}
