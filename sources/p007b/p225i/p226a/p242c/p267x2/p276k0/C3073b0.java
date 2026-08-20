package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.net.Uri;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.discord.api.permission.Permission;
import java.io.IOException;
import java.util.Map;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2736d0;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.b0 */
/* JADX INFO: compiled from: PsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3073b0 implements InterfaceC3031h {

    /* JADX INFO: renamed from: e */
    public boolean f8578e;

    /* JADX INFO: renamed from: f */
    public boolean f8579f;

    /* JADX INFO: renamed from: g */
    public boolean f8580g;

    /* JADX INFO: renamed from: h */
    public long f8581h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public C3105z f8582i;

    /* JADX INFO: renamed from: j */
    public InterfaceC3058j f8583j;

    /* JADX INFO: renamed from: k */
    public boolean f8584k;

    /* JADX INFO: renamed from: a */
    public final C2736d0 f8574a = new C2736d0(0);

    /* JADX INFO: renamed from: c */
    public final C2757x f8576c = new C2757x(4096);

    /* JADX INFO: renamed from: b */
    public final SparseArray<a> f8575b = new SparseArray<>();

    /* JADX INFO: renamed from: d */
    public final C3071a0 f8577d = new C3071a0();

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.b0$a */
    /* JADX INFO: compiled from: PsExtractor.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final InterfaceC3094o f8585a;

        /* JADX INFO: renamed from: b */
        public final C2736d0 f8586b;

        /* JADX INFO: renamed from: c */
        public final C2756w f8587c = new C2756w(new byte[64]);

        /* JADX INFO: renamed from: d */
        public boolean f8588d;

        /* JADX INFO: renamed from: e */
        public boolean f8589e;

        /* JADX INFO: renamed from: f */
        public boolean f8590f;

        /* JADX INFO: renamed from: g */
        public int f8591g;

        /* JADX INFO: renamed from: h */
        public long f8592h;

        public a(InterfaceC3094o interfaceC3094o, C2736d0 c2736d0) {
            this.f8585a = interfaceC3094o;
            this.f8586b = c2736d0;
        }
    }

    static {
        C3076d c3076d = new InterfaceC3106l() { // from class: b.i.a.c.x2.k0.d
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3073b0()};
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
        byte[] bArr = new byte[14];
        interfaceC3041i.mo3652o(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        interfaceC3041i.mo3646g(bArr[13] & 7);
        interfaceC3041i.mo3652o(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    /* JADX WARN: Code duplicated, block: B:105:0x021d  */
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        int i;
        InterfaceC3094o c3095p;
        C1460d.m438H(this.f8583j);
        long jMo3642b = interfaceC3041i.mo3642b();
        int i2 = 1;
        long j = -9223372036854775807L;
        if (jMo3642b != -1) {
            C3071a0 c3071a0 = this.f8577d;
            if (!c3071a0.f8567c) {
                if (!c3071a0.f8569e) {
                    long jMo3642b2 = interfaceC3041i.mo3642b();
                    int iMin = (int) Math.min(20000L, jMo3642b2);
                    long j2 = jMo3642b2 - ((long) iMin);
                    if (interfaceC3041i.getPosition() != j2) {
                        c3118s.f8992a = j2;
                    } else {
                        c3071a0.f8566b.m3075A(iMin);
                        interfaceC3041i.mo3649k();
                        interfaceC3041i.mo3652o(c3071a0.f8566b.f6793a, 0, iMin);
                        C2757x c2757x = c3071a0.f8566b;
                        int i3 = c2757x.f6794b;
                        for (int i4 = c2757x.f6795c - 4; i4 >= i3; i4--) {
                            if (c3071a0.m3751b(c2757x.f6793a, i4) == 442) {
                                c2757x.m3079E(i4 + 4);
                                long jM3749c = C3071a0.m3749c(c2757x);
                                if (jM3749c != -9223372036854775807L) {
                                    j = jM3749c;
                                    break;
                                }
                            }
                        }
                        c3071a0.f8571g = j;
                        c3071a0.f8569e = true;
                        i2 = 0;
                    }
                } else {
                    if (c3071a0.f8571g == -9223372036854775807L) {
                        c3071a0.m3750a(interfaceC3041i);
                        return 0;
                    }
                    if (c3071a0.f8568d) {
                        long j3 = c3071a0.f8570f;
                        if (j3 == -9223372036854775807L) {
                            c3071a0.m3750a(interfaceC3041i);
                            return 0;
                        }
                        long jM2973b = c3071a0.f8565a.m2973b(c3071a0.f8571g) - c3071a0.f8565a.m2973b(j3);
                        c3071a0.f8572h = jM2973b;
                        if (jM2973b < 0) {
                            Log.w("PsDurationReader", C1643a.m855i(65, "Invalid duration: ", jM2973b, ". Using TIME_UNSET instead."));
                            c3071a0.f8572h = -9223372036854775807L;
                        }
                        c3071a0.m3750a(interfaceC3041i);
                        return 0;
                    }
                    int iMin2 = (int) Math.min(20000L, interfaceC3041i.mo3642b());
                    long j4 = 0;
                    if (interfaceC3041i.getPosition() != j4) {
                        c3118s.f8992a = j4;
                    } else {
                        c3071a0.f8566b.m3075A(iMin2);
                        interfaceC3041i.mo3649k();
                        interfaceC3041i.mo3652o(c3071a0.f8566b.f6793a, 0, iMin2);
                        C2757x c2757x2 = c3071a0.f8566b;
                        int i5 = c2757x2.f6795c;
                        for (int i6 = c2757x2.f6794b; i6 < i5 - 3; i6++) {
                            if (c3071a0.m3751b(c2757x2.f6793a, i6) == 442) {
                                c2757x2.m3079E(i6 + 4);
                                long jM3749c2 = C3071a0.m3749c(c2757x2);
                                if (jM3749c2 != -9223372036854775807L) {
                                    j = jM3749c2;
                                    break;
                                }
                            }
                        }
                        c3071a0.f8570f = j;
                        c3071a0.f8568d = true;
                        i2 = 0;
                    }
                }
                return i2;
            }
        }
        if (this.f8584k) {
            i = 442;
        } else {
            this.f8584k = true;
            C3071a0 c3071a1 = this.f8577d;
            long j5 = c3071a1.f8572h;
            if (j5 != -9223372036854775807L) {
                C3105z c3105z = new C3105z(c3071a1.f8565a, j5, jMo3642b);
                this.f8582i = c3105z;
                this.f8583j.mo2477a(c3105z.f8030a);
                i = 442;
            } else {
                i = 442;
                this.f8583j.mo2477a(new InterfaceC3119t.b(j5, 0L));
            }
        }
        C3105z c3105z2 = this.f8582i;
        if (c3105z2 != null && c3105z2.m3614b()) {
            return this.f8582i.m3613a(interfaceC3041i, c3118s);
        }
        interfaceC3041i.mo3649k();
        long jMo3645f = jMo3642b != -1 ? jMo3642b - interfaceC3041i.mo3645f() : -1L;
        if ((jMo3645f != -1 && jMo3645f < 4) || !interfaceC3041i.mo3644e(this.f8576c.f6793a, 0, 4, true)) {
            return -1;
        }
        this.f8576c.m3079E(0);
        int iM3086f = this.f8576c.m3086f();
        if (iM3086f == 441) {
            return -1;
        }
        if (iM3086f == i) {
            interfaceC3041i.mo3652o(this.f8576c.f6793a, 0, 10);
            this.f8576c.m3079E(9);
            interfaceC3041i.mo3650l((this.f8576c.m3100t() & 7) + 14);
            return 0;
        }
        if (iM3086f == 443) {
            interfaceC3041i.mo3652o(this.f8576c.f6793a, 0, 2);
            this.f8576c.m3079E(0);
            interfaceC3041i.mo3650l(this.f8576c.m3105y() + 6);
            return 0;
        }
        if (((iM3086f & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            interfaceC3041i.mo3650l(1);
            return 0;
        }
        int i7 = iM3086f & 255;
        a aVar = this.f8575b.get(i7);
        if (!this.f8578e) {
            if (aVar == null) {
                InterfaceC3094o interfaceC3094o = null;
                if (i7 == 189) {
                    c3095p = new C3082g(null);
                    this.f8579f = true;
                    this.f8581h = interfaceC3041i.getPosition();
                } else if ((i7 & 224) == 192) {
                    c3095p = new C3101v(null);
                    this.f8579f = true;
                    this.f8581h = interfaceC3041i.getPosition();
                } else if ((i7 & 240) == 224) {
                    c3095p = new C3095p(null);
                    this.f8580g = true;
                    this.f8581h = interfaceC3041i.getPosition();
                } else if (interfaceC3094o != null) {
                    interfaceC3094o.mo3761e(this.f8583j, new InterfaceC3087i0.d(Integer.MIN_VALUE, i7, 256));
                    aVar = new a(interfaceC3094o, this.f8574a);
                    this.f8575b.put(i7, aVar);
                }
                interfaceC3094o = c3095p;
                if (interfaceC3094o != null) {
                    interfaceC3094o.mo3761e(this.f8583j, new InterfaceC3087i0.d(Integer.MIN_VALUE, i7, 256));
                    aVar = new a(interfaceC3094o, this.f8574a);
                    this.f8575b.put(i7, aVar);
                }
            }
            if (interfaceC3041i.getPosition() > ((this.f8579f && this.f8580g) ? this.f8581h + Permission.MANAGE_MESSAGES : Permission.CONNECT)) {
                this.f8578e = true;
                this.f8583j.mo2486j();
            }
        }
        interfaceC3041i.mo3652o(this.f8576c.f6793a, 0, 2);
        this.f8576c.m3079E(0);
        int iM3105y = this.f8576c.m3105y() + 6;
        if (aVar == null) {
            interfaceC3041i.mo3650l(iM3105y);
            return 0;
        }
        this.f8576c.m3075A(iM3105y);
        interfaceC3041i.readFully(this.f8576c.f6793a, 0, iM3105y);
        this.f8576c.m3079E(6);
        C2757x c2757x3 = this.f8576c;
        c2757x3.m3085e(aVar.f8587c.f6789a, 0, 3);
        aVar.f8587c.m3071k(0);
        aVar.f8587c.m3073m(8);
        aVar.f8588d = aVar.f8587c.m3066f();
        aVar.f8589e = aVar.f8587c.m3066f();
        aVar.f8587c.m3073m(6);
        int iM3067g = aVar.f8587c.m3067g(8);
        aVar.f8591g = iM3067g;
        c2757x3.m3085e(aVar.f8587c.f6789a, 0, iM3067g);
        aVar.f8587c.m3071k(0);
        aVar.f8592h = 0L;
        if (aVar.f8588d) {
            aVar.f8587c.m3073m(4);
            long jM3067g = ((long) aVar.f8587c.m3067g(3)) << 30;
            aVar.f8587c.m3073m(1);
            long jM3067g2 = jM3067g | ((long) (aVar.f8587c.m3067g(15) << 15));
            aVar.f8587c.m3073m(1);
            long jM3067g3 = jM3067g2 | ((long) aVar.f8587c.m3067g(15));
            aVar.f8587c.m3073m(1);
            if (!aVar.f8590f && aVar.f8589e) {
                aVar.f8587c.m3073m(4);
                long jM3067g4 = ((long) aVar.f8587c.m3067g(3)) << 30;
                aVar.f8587c.m3073m(1);
                long jM3067g5 = jM3067g4 | ((long) (aVar.f8587c.m3067g(15) << 15));
                aVar.f8587c.m3073m(1);
                long jM3067g6 = ((long) aVar.f8587c.m3067g(15)) | jM3067g5;
                aVar.f8587c.m3073m(1);
                aVar.f8586b.m2973b(jM3067g6);
                aVar.f8590f = true;
            }
            aVar.f8592h = aVar.f8586b.m2973b(jM3067g3);
        }
        aVar.f8585a.mo3762f(aVar.f8592h, 4);
        aVar.f8585a.mo3758b(c2757x3);
        aVar.f8585a.mo3760d();
        C2757x c2757x4 = this.f8576c;
        c2757x4.m3078D(c2757x4.f6793a.length);
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8583j = interfaceC3058j;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        boolean z2 = this.f8574a.m2975d() == -9223372036854775807L;
        if (!z2) {
            long jM2974c = this.f8574a.m2974c();
            z2 = (jM2974c == -9223372036854775807L || jM2974c == 0 || jM2974c == j2) ? false : true;
        }
        if (z2) {
            this.f8574a.m2976e(j2);
        }
        C3105z c3105z = this.f8582i;
        if (c3105z != null) {
            c3105z.m3617e(j2);
        }
        for (int i = 0; i < this.f8575b.size(); i++) {
            a aVarValueAt = this.f8575b.valueAt(i);
            aVarValueAt.f8590f = false;
            aVarValueAt.f8585a.mo3759c();
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}
