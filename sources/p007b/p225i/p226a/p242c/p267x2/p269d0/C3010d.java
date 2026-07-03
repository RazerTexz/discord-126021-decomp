package p007b.p225i.p226a.p242c.p267x2.p269d0;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3112m;
import p007b.p225i.p226a.p242c.p267x2.C3113n;
import p007b.p225i.p226a.p242c.p267x2.C3114o;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p355b.p356a.C4483c;

/* JADX INFO: renamed from: b.i.a.c.x2.d0.d */
/* JADX INFO: compiled from: FlacExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3010d implements InterfaceC3031h {

    /* JADX INFO: renamed from: a */
    public final byte[] f8100a = new byte[42];

    /* JADX INFO: renamed from: b */
    public final C2757x f8101b = new C2757x(new byte[32768], 0);

    /* JADX INFO: renamed from: c */
    public final boolean f8102c;

    /* JADX INFO: renamed from: d */
    public final C3112m.a f8103d;

    /* JADX INFO: renamed from: e */
    public InterfaceC3058j f8104e;

    /* JADX INFO: renamed from: f */
    public InterfaceC3122w f8105f;

    /* JADX INFO: renamed from: g */
    public int f8106g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public Metadata f8107h;

    /* JADX INFO: renamed from: i */
    public C3114o f8108i;

    /* JADX INFO: renamed from: j */
    public int f8109j;

    /* JADX INFO: renamed from: k */
    public int f8110k;

    /* JADX INFO: renamed from: l */
    public C3009c f8111l;

    /* JADX INFO: renamed from: m */
    public int f8112m;

    /* JADX INFO: renamed from: n */
    public long f8113n;

    static {
        C3007a c3007a = new InterfaceC3106l() { // from class: b.i.a.c.x2.d0.a
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3010d(0)};
            }

            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: b */
            public /* synthetic */ InterfaceC3031h[] mo3631b(Uri uri, Map map) {
                return C3069k.m3748a(this, uri, map);
            }
        };
    }

    public C3010d(int i) {
        this.f8102c = (i & 1) != 0;
        this.f8103d = new C3112m.a();
        this.f8106g = 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m3641a() {
        long j = this.f8113n * 1000000;
        C3114o c3114o = this.f8108i;
        int i = C2738e0.f6708a;
        this.f8105f.mo2525d(j / ((long) c3114o.f8974e), 1, this.f8112m, 0, null);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        C1460d.m593y1(interfaceC3041i, false);
        byte[] bArr = new byte[4];
        interfaceC3041i.mo3652o(bArr, 0, 4);
        return (((((((long) bArr[0]) & 255) << 24) | ((((long) bArr[1]) & 255) << 16)) | ((((long) bArr[2]) & 255) << 8)) | (255 & ((long) bArr[3]))) == 1716281667;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean, int] */
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        boolean z2;
        C3114o c3114o;
        InterfaceC3119t bVar;
        long j;
        boolean zM3803b;
        int i = this.f8106g;
        boolean z3 = true;
        ?? r4 = 0;
        if (i == 0) {
            boolean z4 = !this.f8102c;
            interfaceC3041i.mo3649k();
            long jMo3645f = interfaceC3041i.mo3645f();
            Metadata metadataM593y1 = C1460d.m593y1(interfaceC3041i, z4);
            interfaceC3041i.mo3650l((int) (interfaceC3041i.mo3645f() - jMo3645f));
            this.f8107h = metadataM593y1;
            this.f8106g = 1;
            return 0;
        }
        if (i == 1) {
            byte[] bArr = this.f8100a;
            interfaceC3041i.mo3652o(bArr, 0, bArr.length);
            interfaceC3041i.mo3649k();
            this.f8106g = 2;
            return 0;
        }
        int i2 = 4;
        int i3 = 3;
        if (i == 2) {
            byte[] bArr2 = new byte[4];
            interfaceC3041i.readFully(bArr2, 0, 4);
            if ((((((long) bArr2[0]) & 255) << 24) | ((((long) bArr2[1]) & 255) << 16) | ((((long) bArr2[2]) & 255) << 8) | (((long) bArr2[3]) & 255)) != 1716281667) {
                throw ParserException.m8755a("Failed to read FLAC stream marker.", null);
            }
            this.f8106g = 3;
            return 0;
        }
        int i4 = 7;
        if (i == 3) {
            C3114o c3114oM3809b = this.f8108i;
            boolean z5 = false;
            while (!z5) {
                interfaceC3041i.mo3649k();
                C2756w c2756w = new C2756w(new byte[i2]);
                interfaceC3041i.mo3652o(c2756w.f6789a, r4, i2);
                boolean zM3066f = c2756w.m3066f();
                int iM3067g = c2756w.m3067g(i4);
                int iM3067g2 = c2756w.m3067g(24) + i2;
                if (iM3067g == 0) {
                    byte[] bArr3 = new byte[38];
                    interfaceC3041i.readFully(bArr3, r4, 38);
                    c3114oM3809b = new C3114o(bArr3, i2);
                } else {
                    if (c3114oM3809b == null) {
                        throw new IllegalArgumentException();
                    }
                    if (iM3067g == i3) {
                        C2757x c2757x = new C2757x(iM3067g2);
                        interfaceC3041i.readFully(c2757x.f6793a, r4, iM3067g2);
                        c3114oM3809b = c3114oM3809b.m3809b(C1460d.m452L1(c2757x));
                    } else {
                        if (iM3067g == i2) {
                            C2757x c2757x2 = new C2757x(iM3067g2);
                            interfaceC3041i.readFully(c2757x2.f6793a, r4, iM3067g2);
                            c2757x2.m3080F(i2);
                            z2 = zM3066f;
                            c3114o = new C3114o(c3114oM3809b.f8970a, c3114oM3809b.f8971b, c3114oM3809b.f8972c, c3114oM3809b.f8973d, c3114oM3809b.f8974e, c3114oM3809b.f8976g, c3114oM3809b.f8977h, c3114oM3809b.f8979j, c3114oM3809b.f8980k, c3114oM3809b.m3812f(C3114o.m3806a(Arrays.asList(C1460d.m458N1(c2757x2, r4, r4).f9015a), Collections.emptyList())));
                        } else {
                            z2 = zM3066f;
                            if (iM3067g == 6) {
                                C2757x c2757x3 = new C2757x(iM3067g2);
                                interfaceC3041i.readFully(c2757x3.f6793a, 0, iM3067g2);
                                c2757x3.m3080F(i2);
                                int iM3086f = c2757x3.m3086f();
                                String strM3098r = c2757x3.m3098r(c2757x3.m3086f(), C4483c.f11943a);
                                String strM3097q = c2757x3.m3097q(c2757x3.m3086f());
                                int iM3086f2 = c2757x3.m3086f();
                                int iM3086f3 = c2757x3.m3086f();
                                int iM3086f4 = c2757x3.m3086f();
                                int iM3086f5 = c2757x3.m3086f();
                                int iM3086f6 = c2757x3.m3086f();
                                byte[] bArr4 = new byte[iM3086f6];
                                System.arraycopy(c2757x3.f6793a, c2757x3.f6794b, bArr4, 0, iM3086f6);
                                c2757x3.f6794b += iM3086f6;
                                c3114o = new C3114o(c3114oM3809b.f8970a, c3114oM3809b.f8971b, c3114oM3809b.f8972c, c3114oM3809b.f8973d, c3114oM3809b.f8974e, c3114oM3809b.f8976g, c3114oM3809b.f8977h, c3114oM3809b.f8979j, c3114oM3809b.f8980k, c3114oM3809b.m3812f(C3114o.m3806a(Collections.emptyList(), Collections.singletonList(new PictureFrame(iM3086f, strM3098r, strM3097q, iM3086f2, iM3086f3, iM3086f4, iM3086f5, bArr4)))));
                            } else {
                                interfaceC3041i.mo3650l(iM3067g2);
                            }
                        }
                        c3114oM3809b = c3114o;
                    }
                    int i5 = C2738e0.f6708a;
                    this.f8108i = c3114oM3809b;
                    z5 = z2;
                    r4 = 0;
                    i2 = 4;
                    i3 = 3;
                    i4 = 7;
                }
                z2 = zM3066f;
                int i6 = C2738e0.f6708a;
                this.f8108i = c3114oM3809b;
                z5 = z2;
                r4 = 0;
                i2 = 4;
                i3 = 3;
                i4 = 7;
            }
            Objects.requireNonNull(this.f8108i);
            this.f8109j = Math.max(this.f8108i.f8972c, 6);
            InterfaceC3122w interfaceC3122w = this.f8105f;
            int i7 = C2738e0.f6708a;
            interfaceC3122w.mo2526e(this.f8108i.m3811e(this.f8100a, this.f8107h));
            this.f8106g = 4;
            return 0;
        }
        long j2 = 0;
        if (i == 4) {
            interfaceC3041i.mo3649k();
            byte[] bArr5 = new byte[2];
            interfaceC3041i.mo3652o(bArr5, 0, 2);
            int i8 = (bArr5[1] & 255) | ((bArr5[0] & 255) << 8);
            if ((i8 >> 2) != 16382) {
                interfaceC3041i.mo3649k();
                throw ParserException.m8755a("First frame does not start with sync code.", null);
            }
            interfaceC3041i.mo3649k();
            this.f8110k = i8;
            InterfaceC3058j interfaceC3058j = this.f8104e;
            int i9 = C2738e0.f6708a;
            long position = interfaceC3041i.getPosition();
            long jMo3642b = interfaceC3041i.mo3642b();
            Objects.requireNonNull(this.f8108i);
            C3114o c3114o2 = this.f8108i;
            if (c3114o2.f8980k != null) {
                bVar = new C3113n(c3114o2, position);
            } else if (jMo3642b == -1 || c3114o2.f8979j <= 0) {
                bVar = new InterfaceC3119t.b(c3114o2.m3810d(), 0L);
            } else {
                C3009c c3009c = new C3009c(c3114o2, this.f8110k, position, jMo3642b);
                this.f8111l = c3009c;
                bVar = c3009c.f8030a;
            }
            interfaceC3058j.mo2477a(bVar);
            this.f8106g = 5;
            return 0;
        }
        if (i != 5) {
            throw new IllegalStateException();
        }
        Objects.requireNonNull(this.f8105f);
        Objects.requireNonNull(this.f8108i);
        C3009c c3009c2 = this.f8111l;
        if (c3009c2 != null && c3009c2.m3614b()) {
            return this.f8111l.m3613a(interfaceC3041i, c3118s);
        }
        if (this.f8113n == -1) {
            C3114o c3114o3 = this.f8108i;
            interfaceC3041i.mo3649k();
            interfaceC3041i.mo3646g(1);
            byte[] bArr6 = new byte[1];
            interfaceC3041i.mo3652o(bArr6, 0, 1);
            boolean z6 = (bArr6[0] & 1) == 1;
            interfaceC3041i.mo3646g(2);
            i4 = z6 ? 7 : 6;
            C2757x c2757x4 = new C2757x(i4);
            c2757x4.m3078D(C1460d.m597z1(interfaceC3041i, c2757x4.f6793a, 0, i4));
            interfaceC3041i.mo3649k();
            try {
                long jM3106z = c2757x4.m3106z();
                if (!z6) {
                    jM3106z *= (long) c3114o3.f8971b;
                }
                j2 = jM3106z;
            } catch (NumberFormatException unused) {
                z3 = false;
            }
            if (!z3) {
                throw ParserException.m8755a(null, null);
            }
            this.f8113n = j2;
            return 0;
        }
        C2757x c2757x5 = this.f8101b;
        int i10 = c2757x5.f6795c;
        if (i10 < 32768) {
            int i11 = interfaceC3041i.read(c2757x5.f6793a, i10, 32768 - i10);
            z3 = i11 == -1;
            if (!z3) {
                this.f8101b.m3078D(i10 + i11);
            } else if (this.f8101b.m3081a() == 0) {
                m3641a();
                return -1;
            }
        } else {
            z3 = false;
        }
        C2757x c2757x6 = this.f8101b;
        int i12 = c2757x6.f6794b;
        int i13 = this.f8112m;
        int i14 = this.f8109j;
        if (i13 < i14) {
            c2757x6.m3080F(Math.min(i14 - i13, c2757x6.m3081a()));
        }
        C2757x c2757x7 = this.f8101b;
        Objects.requireNonNull(this.f8108i);
        int i15 = c2757x7.f6794b;
        while (true) {
            if (i15 > c2757x7.f6795c - 16) {
                if (z3) {
                    while (true) {
                        int i16 = c2757x7.f6795c;
                        if (i15 <= i16 - this.f8109j) {
                            c2757x7.m3079E(i15);
                            try {
                                zM3803b = C3112m.m3803b(c2757x7, this.f8108i, this.f8110k, this.f8103d);
                            } catch (IndexOutOfBoundsException unused2) {
                                zM3803b = false;
                            }
                            if (c2757x7.f6794b > c2757x7.f6795c) {
                                zM3803b = false;
                            }
                            if (zM3803b) {
                                c2757x7.m3079E(i15);
                                j = this.f8103d.f8967a;
                                break;
                            }
                            i15++;
                        } else {
                            c2757x7.m3079E(i16);
                        }
                    }
                } else {
                    c2757x7.m3079E(i15);
                }
                j = -1;
                break;
            }
            c2757x7.m3079E(i15);
            if (C3112m.m3803b(c2757x7, this.f8108i, this.f8110k, this.f8103d)) {
                c2757x7.m3079E(i15);
                j = this.f8103d.f8967a;
                break;
            }
            i15++;
        }
        C2757x c2757x8 = this.f8101b;
        int i17 = c2757x8.f6794b - i12;
        c2757x8.m3079E(i12);
        this.f8105f.mo2524c(this.f8101b, i17);
        this.f8112m += i17;
        if (j != -1) {
            m3641a();
            this.f8112m = 0;
            this.f8113n = j;
        }
        if (this.f8101b.m3081a() >= 16) {
            return 0;
        }
        int iM3081a = this.f8101b.m3081a();
        C2757x c2757x9 = this.f8101b;
        byte[] bArr7 = c2757x9.f6793a;
        System.arraycopy(bArr7, c2757x9.f6794b, bArr7, 0, iM3081a);
        this.f8101b.m3079E(0);
        this.f8101b.m3078D(iM3081a);
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8104e = interfaceC3058j;
        this.f8105f = interfaceC3058j.mo2492p(0, 1);
        interfaceC3058j.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        if (j == 0) {
            this.f8106g = 0;
        } else {
            C3009c c3009c = this.f8111l;
            if (c3009c != null) {
                c3009c.m3617e(j2);
            }
        }
        this.f8113n = j2 != 0 ? -1L : 0L;
        this.f8112m = 0;
        this.f8101b.m3075A(0);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}
