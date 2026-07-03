package p007b.p225i.p226a.p242c.p267x2.p277l0;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.l0.b */
/* JADX INFO: compiled from: WavExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3108b implements InterfaceC3031h {

    /* JADX INFO: renamed from: a */
    public InterfaceC3058j f8926a;

    /* JADX INFO: renamed from: b */
    public InterfaceC3122w f8927b;

    /* JADX INFO: renamed from: d */
    public b f8929d;

    /* JADX INFO: renamed from: c */
    public int f8928c = 0;

    /* JADX INFO: renamed from: e */
    public int f8930e = -1;

    /* JADX INFO: renamed from: f */
    public long f8931f = -1;

    /* JADX INFO: renamed from: b.i.a.c.x2.l0.b$a */
    /* JADX INFO: compiled from: WavExtractor.java */
    public static final class a implements b {

        /* JADX INFO: renamed from: a */
        public static final int[] f8932a = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* JADX INFO: renamed from: b */
        public static final int[] f8933b = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, Opcodes.D2L, 157, Opcodes.LRETURN, Opcodes.ARRAYLENGTH, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* JADX INFO: renamed from: c */
        public final InterfaceC3058j f8934c;

        /* JADX INFO: renamed from: d */
        public final InterfaceC3122w f8935d;

        /* JADX INFO: renamed from: e */
        public final C3109c f8936e;

        /* JADX INFO: renamed from: f */
        public final int f8937f;

        /* JADX INFO: renamed from: g */
        public final byte[] f8938g;

        /* JADX INFO: renamed from: h */
        public final C2757x f8939h;

        /* JADX INFO: renamed from: i */
        public final int f8940i;

        /* JADX INFO: renamed from: j */
        public final C2811j1 f8941j;

        /* JADX INFO: renamed from: k */
        public int f8942k;

        /* JADX INFO: renamed from: l */
        public long f8943l;

        /* JADX INFO: renamed from: m */
        public int f8944m;

        /* JADX INFO: renamed from: n */
        public long f8945n;

        public a(InterfaceC3058j interfaceC3058j, InterfaceC3122w interfaceC3122w, C3109c c3109c) throws ParserException {
            this.f8934c = interfaceC3058j;
            this.f8935d = interfaceC3122w;
            this.f8936e = c3109c;
            int iMax = Math.max(1, c3109c.f8956c / 10);
            this.f8940i = iMax;
            byte[] bArr = c3109c.f8959f;
            int length = bArr.length;
            byte b2 = bArr[0];
            byte b3 = bArr[1];
            int i = ((bArr[3] & 255) << 8) | (bArr[2] & 255);
            this.f8937f = i;
            int i2 = c3109c.f8955b;
            int i3 = (((c3109c.f8957d - (i2 * 4)) * 8) / (c3109c.f8958e * i2)) + 1;
            if (i != i3) {
                throw ParserException.m8755a(C1643a.m853h(56, "Expected frames per block: ", i3, "; got: ", i), null);
            }
            int iM2998f = C2738e0.m2998f(iMax, i);
            this.f8938g = new byte[c3109c.f8957d * iM2998f];
            this.f8939h = new C2757x(i * 2 * i2 * iM2998f);
            int i4 = c3109c.f8956c;
            int i5 = ((c3109c.f8957d * i4) * 8) / i;
            C2811j1.b bVar = new C2811j1.b();
            bVar.f7173k = "audio/raw";
            bVar.f7168f = i5;
            bVar.f7169g = i5;
            bVar.f7174l = iMax * 2 * i2;
            bVar.f7186x = c3109c.f8955b;
            bVar.f7187y = i4;
            bVar.f7188z = 2;
            this.f8941j = bVar.m3277a();
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.C3108b.b
        /* JADX INFO: renamed from: a */
        public void mo3795a(long j) {
            this.f8942k = 0;
            this.f8943l = j;
            this.f8944m = 0;
            this.f8945n = 0L;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.C3108b.b
        /* JADX INFO: renamed from: b */
        public void mo3796b(int i, long j) {
            this.f8934c.mo2477a(new C3111e(this.f8936e, this.f8937f, i, j));
            this.f8935d.mo2526e(this.f8941j);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003f -> B:12:0x0041). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:7:0x0029
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.C3108b.b
        /* JADX INFO: renamed from: c */
        public boolean mo3797c(p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i r19, long r20) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 364
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p225i.p226a.p242c.p267x2.p277l0.C3108b.a.mo3797c(b.i.a.c.x2.i, long):boolean");
        }

        /* JADX INFO: renamed from: d */
        public final int m3798d(int i) {
            return i / (this.f8936e.f8955b * 2);
        }

        /* JADX INFO: renamed from: e */
        public final void m3799e(int i) {
            long jM2985F = this.f8943l + C2738e0.m2985F(this.f8945n, 1000000L, this.f8936e.f8956c);
            int i2 = i * 2 * this.f8936e.f8955b;
            this.f8935d.mo2525d(jM2985F, 1, i2, this.f8944m - i2, null);
            this.f8945n += (long) i;
            this.f8944m -= i2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.l0.b$b */
    /* JADX INFO: compiled from: WavExtractor.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo3795a(long j);

        /* JADX INFO: renamed from: b */
        void mo3796b(int i, long j) throws ParserException;

        /* JADX INFO: renamed from: c */
        boolean mo3797c(InterfaceC3041i interfaceC3041i, long j) throws IOException;
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.l0.b$c */
    /* JADX INFO: compiled from: WavExtractor.java */
    public static final class c implements b {

        /* JADX INFO: renamed from: a */
        public final InterfaceC3058j f8946a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC3122w f8947b;

        /* JADX INFO: renamed from: c */
        public final C3109c f8948c;

        /* JADX INFO: renamed from: d */
        public final C2811j1 f8949d;

        /* JADX INFO: renamed from: e */
        public final int f8950e;

        /* JADX INFO: renamed from: f */
        public long f8951f;

        /* JADX INFO: renamed from: g */
        public int f8952g;

        /* JADX INFO: renamed from: h */
        public long f8953h;

        public c(InterfaceC3058j interfaceC3058j, InterfaceC3122w interfaceC3122w, C3109c c3109c, String str, int i) throws ParserException {
            this.f8946a = interfaceC3058j;
            this.f8947b = interfaceC3122w;
            this.f8948c = c3109c;
            int i2 = (c3109c.f8955b * c3109c.f8958e) / 8;
            int i3 = c3109c.f8957d;
            if (i3 != i2) {
                throw ParserException.m8755a(C1643a.m853h(50, "Expected block size: ", i2, "; got: ", i3), null);
            }
            int i4 = c3109c.f8956c * i2;
            int i5 = i4 * 8;
            int iMax = Math.max(i2, i4 / 10);
            this.f8950e = iMax;
            C2811j1.b bVar = new C2811j1.b();
            bVar.f7173k = str;
            bVar.f7168f = i5;
            bVar.f7169g = i5;
            bVar.f7174l = iMax;
            bVar.f7186x = c3109c.f8955b;
            bVar.f7187y = c3109c.f8956c;
            bVar.f7188z = i;
            this.f8949d = bVar.m3277a();
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.C3108b.b
        /* JADX INFO: renamed from: a */
        public void mo3795a(long j) {
            this.f8951f = j;
            this.f8952g = 0;
            this.f8953h = 0L;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.C3108b.b
        /* JADX INFO: renamed from: b */
        public void mo3796b(int i, long j) {
            this.f8946a.mo2477a(new C3111e(this.f8948c, 1, i, j));
            this.f8947b.mo2526e(this.f8949d);
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.C3108b.b
        /* JADX INFO: renamed from: c */
        public boolean mo3797c(InterfaceC3041i interfaceC3041i, long j) throws IOException {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.f8952g) < (i2 = this.f8950e)) {
                int iMo2523b = this.f8947b.mo2523b(interfaceC3041i, (int) Math.min(i2 - i, j2), true);
                if (iMo2523b == -1) {
                    j2 = 0;
                } else {
                    this.f8952g += iMo2523b;
                    j2 -= (long) iMo2523b;
                }
            }
            C3109c c3109c = this.f8948c;
            int i3 = c3109c.f8957d;
            int i4 = this.f8952g / i3;
            if (i4 > 0) {
                long jM2985F = this.f8951f + C2738e0.m2985F(this.f8953h, 1000000L, c3109c.f8956c);
                int i5 = i4 * i3;
                int i6 = this.f8952g - i5;
                this.f8947b.mo2525d(jM2985F, 1, i5, i6, null);
                this.f8953h += (long) i4;
                this.f8952g = i6;
            }
            return j2 <= 0;
        }
    }

    static {
        C3107a c3107a = new InterfaceC3106l() { // from class: b.i.a.c.x2.l0.a
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3108b()};
            }

            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: b */
            public /* synthetic */ InterfaceC3031h[] mo3631b(Uri uri, Map map) {
                return C3069k.m3748a(this, uri, map);
            }
        };
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        return C1460d.m563r(interfaceC3041i);
    }

    /* JADX WARN: Code duplicated, block: B:65:0x01b8  */
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        byte[] bArr;
        int iM3010r;
        int i;
        C1460d.m438H(this.f8927b);
        int i2 = C2738e0.f6708a;
        int i3 = this.f8928c;
        if (i3 == 0) {
            C1460d.m426D(interfaceC3041i.getPosition() == 0);
            int i4 = this.f8930e;
            if (i4 != -1) {
                interfaceC3041i.mo3650l(i4);
                this.f8928c = 3;
            } else {
                if (!C1460d.m563r(interfaceC3041i)) {
                    throw ParserException.m8755a("Unsupported or unrecognized wav file type.", null);
                }
                interfaceC3041i.mo3650l((int) (interfaceC3041i.mo3645f() - interfaceC3041i.getPosition()));
                this.f8928c = 1;
            }
            return 0;
        }
        if (i3 == 1) {
            C2757x c2757x = new C2757x(16);
            C3110d c3110dM3800a = C3110d.m3800a(interfaceC3041i, c2757x);
            while (c3110dM3800a.f8960a != 1718449184) {
                interfaceC3041i.mo3650l(((int) c3110dM3800a.f8961b) + 8);
                c3110dM3800a = C3110d.m3800a(interfaceC3041i, c2757x);
            }
            C1460d.m426D(c3110dM3800a.f8961b >= 16);
            interfaceC3041i.mo3652o(c2757x.f6793a, 0, 16);
            c2757x.m3079E(0);
            int iM3092l = c2757x.m3092l();
            int iM3092l2 = c2757x.m3092l();
            int iM3091k = c2757x.m3091k();
            int iM3091k2 = c2757x.m3091k();
            int iM3092l3 = c2757x.m3092l();
            int iM3092l4 = c2757x.m3092l();
            int i5 = ((int) c3110dM3800a.f8961b) - 16;
            if (i5 > 0) {
                bArr = new byte[i5];
                interfaceC3041i.mo3652o(bArr, 0, i5);
            } else {
                bArr = C2738e0.f6713f;
            }
            interfaceC3041i.mo3650l((int) (interfaceC3041i.mo3645f() - interfaceC3041i.getPosition()));
            C3109c c3109c = new C3109c(iM3092l, iM3092l2, iM3091k, iM3091k2, iM3092l3, iM3092l4, bArr);
            if (iM3092l == 17) {
                this.f8929d = new a(this.f8926a, this.f8927b, c3109c);
            } else if (iM3092l == 6) {
                this.f8929d = new c(this.f8926a, this.f8927b, c3109c, "audio/g711-alaw", -1);
            } else if (iM3092l == 7) {
                this.f8929d = new c(this.f8926a, this.f8927b, c3109c, "audio/g711-mlaw", -1);
            } else {
                if (iM3092l == 1) {
                    iM3010r = C2738e0.m3010r(iM3092l4);
                    i = iM3010r;
                } else if (iM3092l == 3) {
                    iM3010r = iM3092l4 == 32 ? 4 : 0;
                    i = iM3010r;
                } else if (iM3092l != 65534) {
                    i = 0;
                } else {
                    iM3010r = C2738e0.m3010r(iM3092l4);
                    i = iM3010r;
                }
                if (i == 0) {
                    StringBuilder sb = new StringBuilder(40);
                    sb.append("Unsupported WAV format type: ");
                    sb.append(iM3092l);
                    throw ParserException.m8756b(sb.toString());
                }
                this.f8929d = new c(this.f8926a, this.f8927b, c3109c, "audio/raw", i);
            }
            this.f8928c = 2;
            return 0;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                throw new IllegalStateException();
            }
            C1460d.m426D(this.f8931f != -1);
            long position = this.f8931f - interfaceC3041i.getPosition();
            b bVar = this.f8929d;
            Objects.requireNonNull(bVar);
            return bVar.mo3797c(interfaceC3041i, position) ? -1 : 0;
        }
        interfaceC3041i.mo3649k();
        C2757x c2757x2 = new C2757x(8);
        C3110d c3110dM3800a2 = C3110d.m3800a(interfaceC3041i, c2757x2);
        while (true) {
            int i6 = c3110dM3800a2.f8960a;
            if (i6 == 1684108385) {
                interfaceC3041i.mo3650l(8);
                long position2 = interfaceC3041i.getPosition();
                long j = c3110dM3800a2.f8961b + position2;
                long jMo3642b = interfaceC3041i.mo3642b();
                if (jMo3642b != -1 && j > jMo3642b) {
                    StringBuilder sbM830R = C1643a.m830R(69, "Data exceeds input length: ", j, ", ");
                    sbM830R.append(jMo3642b);
                    Log.w("WavHeaderReader", sbM830R.toString());
                    j = jMo3642b;
                }
                Pair pairCreate = Pair.create(Long.valueOf(position2), Long.valueOf(j));
                this.f8930e = ((Long) pairCreate.first).intValue();
                this.f8931f = ((Long) pairCreate.second).longValue();
                b bVar2 = this.f8929d;
                Objects.requireNonNull(bVar2);
                bVar2.mo3796b(this.f8930e, this.f8931f);
                this.f8928c = 3;
                return 0;
            }
            C1643a.m852g0(39, "Ignoring unknown WAV chunk: ", i6, "WavHeaderReader");
            long j2 = c3110dM3800a2.f8961b + 8;
            if (j2 > 2147483647L) {
                int i7 = c3110dM3800a2.f8960a;
                StringBuilder sb2 = new StringBuilder(51);
                sb2.append("Chunk is too large (~2GB+) to skip; id: ");
                sb2.append(i7);
                throw ParserException.m8756b(sb2.toString());
            }
            interfaceC3041i.mo3650l((int) j2);
            c3110dM3800a2 = C3110d.m3800a(interfaceC3041i, c2757x2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8926a = interfaceC3058j;
        this.f8927b = interfaceC3058j.mo2492p(0, 1);
        interfaceC3058j.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8928c = j == 0 ? 0 : 3;
        b bVar = this.f8929d;
        if (bVar != null) {
            bVar.mo3795a(j2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}
