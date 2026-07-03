package p007b.p225i.p226a.p242c.p267x2.p275j0;

import android.net.Uri;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.d */
/* JADX INFO: compiled from: OggExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C3062d implements InterfaceC3031h {

    /* JADX INFO: renamed from: a */
    public InterfaceC3058j f8522a;

    /* JADX INFO: renamed from: b */
    public AbstractC3067i f8523b;

    /* JADX INFO: renamed from: c */
    public boolean f8524c;

    static {
        C3059a c3059a = new InterfaceC3106l() { // from class: b.i.a.c.x2.j0.a
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3062d()};
            }

            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: b */
            public /* synthetic */ InterfaceC3031h[] mo3631b(Uri uri, Map map) {
                return C3069k.m3748a(this, uri, map);
            }
        };
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    /* JADX INFO: renamed from: a */
    public final boolean m3740a(InterfaceC3041i interfaceC3041i) throws IOException {
        boolean zM550n2;
        boolean zEquals;
        C3064f c3064f = new C3064f();
        if (c3064f.m3743a(interfaceC3041i, true) && (c3064f.f8531b & 2) == 2) {
            int iMin = Math.min(c3064f.f8535f, 8);
            C2757x c2757x = new C2757x(iMin);
            interfaceC3041i.mo3652o(c2757x.f6793a, 0, iMin);
            c2757x.m3079E(0);
            if (c2757x.m3081a() >= 5 && c2757x.m3100t() == 127 && c2757x.m3101u() == 1179402563) {
                this.f8523b = new C3061c();
            } else {
                c2757x.m3079E(0);
                try {
                    zM550n2 = C1460d.m550n2(1, c2757x, true);
                } catch (ParserException unused) {
                    zM550n2 = false;
                }
                if (zM550n2) {
                    this.f8523b = new C3068j();
                } else {
                    c2757x.m3079E(0);
                    int iM3081a = c2757x.m3081a();
                    byte[] bArr = C3066h.f8538n;
                    if (iM3081a < bArr.length) {
                        zEquals = false;
                    } else {
                        byte[] bArr2 = new byte[bArr.length];
                        int length = bArr.length;
                        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr2, 0, length);
                        c2757x.f6794b += length;
                        zEquals = Arrays.equals(bArr2, bArr);
                    }
                    if (zEquals) {
                        this.f8523b = new C3066h();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        try {
            return m3740a(interfaceC3041i);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0180  */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        boolean z2;
        int i;
        C3063e c3063e;
        C2757x c2757x;
        byte[] bArr;
        C1460d.m438H(this.f8522a);
        if (this.f8523b == null) {
            if (!m3740a(interfaceC3041i)) {
                throw ParserException.m8755a("Failed to determine bitstream type", null);
            }
            interfaceC3041i.mo3649k();
        }
        if (!this.f8524c) {
            InterfaceC3122w interfaceC3122wMo2492p = this.f8522a.mo2492p(0, 1);
            this.f8522a.mo2486j();
            AbstractC3067i abstractC3067i = this.f8523b;
            abstractC3067i.f8542c = this.f8522a;
            abstractC3067i.f8541b = interfaceC3122wMo2492p;
            abstractC3067i.mo3739e(true);
            this.f8524c = true;
        }
        AbstractC3067i abstractC3067i2 = this.f8523b;
        C1460d.m438H(abstractC3067i2.f8541b);
        int i2 = C2738e0.f6708a;
        int i3 = abstractC3067i2.f8547h;
        int i4 = 3;
        if (i3 == 0) {
            while (true) {
                if (!abstractC3067i2.f8540a.m3742b(interfaceC3041i)) {
                    abstractC3067i2.f8547h = i4;
                    z2 = false;
                    break;
                }
                long position = interfaceC3041i.getPosition();
                long j = abstractC3067i2.f8545f;
                abstractC3067i2.f8550k = position - j;
                if (!abstractC3067i2.mo3738d(abstractC3067i2.f8540a.f8526b, j, abstractC3067i2.f8549j)) {
                    z2 = true;
                    break;
                }
                abstractC3067i2.f8545f = interfaceC3041i.getPosition();
                i4 = 3;
            }
            if (z2) {
                C2811j1 c2811j1 = abstractC3067i2.f8549j.f8553a;
                abstractC3067i2.f8548i = c2811j1.f7137K;
                if (!abstractC3067i2.f8552m) {
                    abstractC3067i2.f8541b.mo2526e(c2811j1);
                    abstractC3067i2.f8552m = true;
                }
                InterfaceC3065g interfaceC3065g = abstractC3067i2.f8549j.f8554b;
                if (interfaceC3065g == null) {
                    if (interfaceC3041i.mo3642b() == -1) {
                        abstractC3067i2.f8543d = new AbstractC3067i.c(null);
                    } else {
                        C3064f c3064f = abstractC3067i2.f8540a.f8525a;
                        i = 2;
                        abstractC3067i2.f8543d = new C3060b(abstractC3067i2, abstractC3067i2.f8545f, interfaceC3041i.mo3642b(), c3064f.f8534e + c3064f.f8535f, c3064f.f8532c, (c3064f.f8531b & 4) != 0);
                    }
                    abstractC3067i2.f8547h = i;
                    c3063e = abstractC3067i2.f8540a;
                    c2757x = c3063e.f8526b;
                    bArr = c2757x.f6793a;
                    if (bArr.length == 65025) {
                        return 0;
                    }
                    c2757x.m3077C(Arrays.copyOf(bArr, Math.max(65025, c2757x.f6795c)), c3063e.f8526b.f6795c);
                    return 0;
                }
                abstractC3067i2.f8543d = interfaceC3065g;
                i = 2;
                abstractC3067i2.f8547h = i;
                c3063e = abstractC3067i2.f8540a;
                c2757x = c3063e.f8526b;
                bArr = c2757x.f6793a;
                if (bArr.length == 65025) {
                    return 0;
                }
                c2757x.m3077C(Arrays.copyOf(bArr, Math.max(65025, c2757x.f6795c)), c3063e.f8526b.f6795c);
                return 0;
            }
        } else {
            if (i3 == 1) {
                interfaceC3041i.mo3650l((int) abstractC3067i2.f8545f);
                abstractC3067i2.f8547h = 2;
                return 0;
            }
            if (i3 == 2) {
                long jMo3735b = abstractC3067i2.f8543d.mo3735b(interfaceC3041i);
                if (jMo3735b >= 0) {
                    c3118s.f8992a = jMo3735b;
                    return 1;
                }
                if (jMo3735b < -1) {
                    abstractC3067i2.mo3747b(-(jMo3735b + 2));
                }
                if (!abstractC3067i2.f8551l) {
                    InterfaceC3119t interfaceC3119tMo3734a = abstractC3067i2.f8543d.mo3734a();
                    C1460d.m438H(interfaceC3119tMo3734a);
                    abstractC3067i2.f8542c.mo2477a(interfaceC3119tMo3734a);
                    abstractC3067i2.f8551l = true;
                }
                if (abstractC3067i2.f8550k > 0 || abstractC3067i2.f8540a.m3742b(interfaceC3041i)) {
                    abstractC3067i2.f8550k = 0L;
                    C2757x c2757x2 = abstractC3067i2.f8540a.f8526b;
                    long jMo3737c = abstractC3067i2.mo3737c(c2757x2);
                    if (jMo3737c >= 0) {
                        long j2 = abstractC3067i2.f8546g;
                        if (j2 + jMo3737c >= abstractC3067i2.f8544e) {
                            long j3 = (j2 * 1000000) / ((long) abstractC3067i2.f8548i);
                            abstractC3067i2.f8541b.mo2524c(c2757x2, c2757x2.f6795c);
                            abstractC3067i2.f8541b.mo2525d(j3, 1, c2757x2.f6795c, 0, null);
                            abstractC3067i2.f8544e = -1L;
                        }
                    }
                    abstractC3067i2.f8546g += jMo3737c;
                    return 0;
                }
                abstractC3067i2.f8547h = 3;
            } else if (i3 != 3) {
                throw new IllegalStateException();
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8522a = interfaceC3058j;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        AbstractC3067i abstractC3067i = this.f8523b;
        if (abstractC3067i != null) {
            C3063e c3063e = abstractC3067i.f8540a;
            c3063e.f8525a.m3744b();
            c3063e.f8526b.m3075A(0);
            c3063e.f8527c = -1;
            c3063e.f8529e = false;
            if (j == 0) {
                abstractC3067i.mo3739e(!abstractC3067i.f8551l);
                return;
            }
            if (abstractC3067i.f8547h != 0) {
                long j3 = (((long) abstractC3067i.f8548i) * j2) / 1000000;
                abstractC3067i.f8544e = j3;
                InterfaceC3065g interfaceC3065g = abstractC3067i.f8543d;
                int i = C2738e0.f6708a;
                interfaceC3065g.mo3736c(j3);
                abstractC3067i.f8547h = 2;
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}
