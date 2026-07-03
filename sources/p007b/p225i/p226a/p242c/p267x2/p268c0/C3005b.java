package p007b.p225i.p226a.p242c.p267x2.p268c0;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p267x2.C3006d;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.c0.b */
/* JADX INFO: compiled from: AmrExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3005b implements InterfaceC3031h {

    /* JADX INFO: renamed from: a */
    public static final int[] f8068a;

    /* JADX INFO: renamed from: b */
    public static final int[] f8069b;

    /* JADX INFO: renamed from: c */
    public static final byte[] f8070c;

    /* JADX INFO: renamed from: d */
    public static final byte[] f8071d;

    /* JADX INFO: renamed from: e */
    public static final int f8072e;

    /* JADX INFO: renamed from: f */
    public final byte[] f8073f;

    /* JADX INFO: renamed from: g */
    public final int f8074g;

    /* JADX INFO: renamed from: h */
    public boolean f8075h;

    /* JADX INFO: renamed from: i */
    public long f8076i;

    /* JADX INFO: renamed from: j */
    public int f8077j;

    /* JADX INFO: renamed from: k */
    public int f8078k;

    /* JADX INFO: renamed from: l */
    public boolean f8079l;

    /* JADX INFO: renamed from: m */
    public long f8080m;

    /* JADX INFO: renamed from: n */
    public int f8081n;

    /* JADX INFO: renamed from: o */
    public int f8082o;

    /* JADX INFO: renamed from: p */
    public long f8083p;

    /* JADX INFO: renamed from: q */
    public InterfaceC3058j f8084q;

    /* JADX INFO: renamed from: r */
    public InterfaceC3122w f8085r;

    /* JADX INFO: renamed from: s */
    public InterfaceC3119t f8086s;

    /* JADX INFO: renamed from: t */
    public boolean f8087t;

    static {
        C3004a c3004a = new InterfaceC3106l() { // from class: b.i.a.c.x2.c0.a
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3005b(0)};
            }

            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: b */
            public /* synthetic */ InterfaceC3031h[] mo3631b(Uri uri, Map map) {
                return C3069k.m3748a(this, uri, map);
            }
        };
        f8068a = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f8069b = iArr;
        f8070c = C2738e0.m3015w("#!AMR\n");
        f8071d = C2738e0.m3015w("#!AMR-WB\n");
        f8072e = iArr[8];
    }

    public C3005b(int i) {
        this.f8074g = (i & 2) != 0 ? i | 1 : i;
        this.f8073f = new byte[1];
        this.f8081n = -1;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003c  */
    /* JADX INFO: renamed from: a */
    public final int m3632a(InterfaceC3041i interfaceC3041i) throws IOException {
        interfaceC3041i.mo3649k();
        boolean z2 = false;
        interfaceC3041i.mo3652o(this.f8073f, 0, 1);
        byte b2 = this.f8073f[0];
        if ((b2 & 131) > 0) {
            throw C1643a.m884w0(42, "Invalid padding bits for frame header ", b2, null);
        }
        int i = (b2 >> 3) & 15;
        if (i >= 0 && i <= 15) {
            boolean z3 = this.f8075h;
            if (z3 && (i < 10 || i > 13)) {
                z2 = true;
            } else {
                if (!z3 && (i < 12 || i > 14)) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            return this.f8075h ? f8069b[i] : f8068a[i];
        }
        String str = this.f8075h ? "WB" : "NB";
        StringBuilder sb = new StringBuilder(str.length() + 35);
        sb.append("Illegal AMR ");
        sb.append(str);
        sb.append(" frame type ");
        sb.append(i);
        throw ParserException.m8755a(sb.toString(), null);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        return m3634c(interfaceC3041i);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m3634c(InterfaceC3041i interfaceC3041i) throws IOException {
        byte[] bArr = f8070c;
        interfaceC3041i.mo3649k();
        byte[] bArr2 = new byte[bArr.length];
        interfaceC3041i.mo3652o(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.f8075h = false;
            interfaceC3041i.mo3650l(bArr.length);
            return true;
        }
        byte[] bArr3 = f8071d;
        interfaceC3041i.mo3649k();
        byte[] bArr4 = new byte[bArr3.length];
        interfaceC3041i.mo3652o(bArr4, 0, bArr3.length);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.f8075h = true;
        interfaceC3041i.mo3650l(bArr3.length);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0088  */
    /* JADX WARN: Code duplicated, block: B:32:0x008a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0092  */
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        int i;
        int i2;
        int iMo2523b;
        int i3;
        C1460d.m438H(this.f8085r);
        if (interfaceC3041i.getPosition() == 0 && !m3634c(interfaceC3041i)) {
            throw ParserException.m8755a("Could not find AMR header.", null);
        }
        if (!this.f8087t) {
            this.f8087t = true;
            boolean z2 = this.f8075h;
            String str = z2 ? "audio/amr-wb" : "audio/3gpp";
            int i4 = z2 ? 16000 : 8000;
            InterfaceC3122w interfaceC3122w = this.f8085r;
            C2811j1.b bVar = new C2811j1.b();
            bVar.f7173k = str;
            bVar.f7174l = f8072e;
            bVar.f7186x = 1;
            bVar.f7187y = i4;
            interfaceC3122w.mo2526e(bVar.m3277a());
        }
        if (this.f8078k == 0) {
            try {
                int iM3632a = m3632a(interfaceC3041i);
                this.f8077j = iM3632a;
                this.f8078k = iM3632a;
                if (this.f8081n == -1) {
                    this.f8080m = interfaceC3041i.getPosition();
                    this.f8081n = this.f8077j;
                }
                if (this.f8081n == this.f8077j) {
                    this.f8082o++;
                }
                iMo2523b = this.f8085r.mo2523b(interfaceC3041i, this.f8078k, true);
                if (iMo2523b == -1) {
                    i = -1;
                } else {
                    i3 = this.f8078k - iMo2523b;
                    this.f8078k = i3;
                    if (i3 <= 0) {
                        this.f8085r.mo2525d(this.f8083p + this.f8076i, 1, this.f8077j, 0, null);
                        this.f8076i += 20000;
                    }
                    i = 0;
                }
            } catch (EOFException unused) {
            }
        } else {
            iMo2523b = this.f8085r.mo2523b(interfaceC3041i, this.f8078k, true);
            if (iMo2523b == -1) {
                i = -1;
            } else {
                i3 = this.f8078k - iMo2523b;
                this.f8078k = i3;
                if (i3 <= 0) {
                    this.f8085r.mo2525d(this.f8083p + this.f8076i, 1, this.f8077j, 0, null);
                    this.f8076i += 20000;
                }
                i = 0;
            }
        }
        long jMo3642b = interfaceC3041i.mo3642b();
        if (!this.f8079l) {
            int i5 = this.f8074g;
            if ((i5 & 1) == 0 || jMo3642b == -1 || !((i2 = this.f8081n) == -1 || i2 == this.f8077j)) {
                InterfaceC3119t.b bVar2 = new InterfaceC3119t.b(-9223372036854775807L, 0L);
                this.f8086s = bVar2;
                this.f8084q.mo2477a(bVar2);
                this.f8079l = true;
            } else if (this.f8082o >= 20 || i == -1) {
                C3006d c3006d = new C3006d(jMo3642b, this.f8080m, (int) ((((long) (i2 * 8)) * 1000000) / 20000), i2, (i5 & 2) != 0);
                this.f8086s = c3006d;
                this.f8084q.mo2477a(c3006d);
                this.f8079l = true;
            }
        }
        return i;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8084q = interfaceC3058j;
        this.f8085r = interfaceC3058j.mo2492p(0, 1);
        interfaceC3058j.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8076i = 0L;
        this.f8077j = 0;
        this.f8078k = 0;
        if (j != 0) {
            InterfaceC3119t interfaceC3119t = this.f8086s;
            if (interfaceC3119t instanceof C3006d) {
                C3006d c3006d = (C3006d) interfaceC3119t;
                this.f8083p = C3006d.m3638e(j, c3006d.f8089b, c3006d.f8092e);
                return;
            }
        }
        this.f8083p = 0L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}
