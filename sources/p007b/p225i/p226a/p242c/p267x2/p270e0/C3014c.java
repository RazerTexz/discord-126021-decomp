package p007b.p225i.p226a.p242c.p267x2.p270e0;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3117r;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;

/* JADX INFO: renamed from: b.i.a.c.x2.e0.c */
/* JADX INFO: compiled from: FlvExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3014c implements InterfaceC3031h {

    /* JADX INFO: renamed from: f */
    public InterfaceC3058j f8131f;

    /* JADX INFO: renamed from: h */
    public boolean f8133h;

    /* JADX INFO: renamed from: i */
    public long f8134i;

    /* JADX INFO: renamed from: j */
    public int f8135j;

    /* JADX INFO: renamed from: k */
    public int f8136k;

    /* JADX INFO: renamed from: l */
    public int f8137l;

    /* JADX INFO: renamed from: m */
    public long f8138m;

    /* JADX INFO: renamed from: n */
    public boolean f8139n;

    /* JADX INFO: renamed from: o */
    public C3013b f8140o;

    /* JADX INFO: renamed from: p */
    public C3016e f8141p;

    /* JADX INFO: renamed from: a */
    public final C2757x f8126a = new C2757x(4);

    /* JADX INFO: renamed from: b */
    public final C2757x f8127b = new C2757x(9);

    /* JADX INFO: renamed from: c */
    public final C2757x f8128c = new C2757x(11);

    /* JADX INFO: renamed from: d */
    public final C2757x f8129d = new C2757x();

    /* JADX INFO: renamed from: e */
    public final C3015d f8130e = new C3015d();

    /* JADX INFO: renamed from: g */
    public int f8132g = 1;

    static {
        C3012a c3012a = new InterfaceC3106l() { // from class: b.i.a.c.x2.e0.a
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3014c()};
            }

            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: b */
            public /* synthetic */ InterfaceC3031h[] mo3631b(Uri uri, Map map) {
                return C3069k.m3748a(this, uri, map);
            }
        };
    }

    @RequiresNonNull({"extractorOutput"})
    /* JADX INFO: renamed from: a */
    public final void m3659a() {
        if (this.f8139n) {
            return;
        }
        this.f8131f.mo2477a(new InterfaceC3119t.b(-9223372036854775807L, 0L));
        this.f8139n = true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        interfaceC3041i.mo3652o(this.f8126a.f6793a, 0, 3);
        this.f8126a.m3079E(0);
        if (this.f8126a.m3102v() != 4607062) {
            return false;
        }
        interfaceC3041i.mo3652o(this.f8126a.f6793a, 0, 2);
        this.f8126a.m3079E(0);
        if ((this.f8126a.m3105y() & 250) != 0) {
            return false;
        }
        interfaceC3041i.mo3652o(this.f8126a.f6793a, 0, 4);
        this.f8126a.m3079E(0);
        int iM3086f = this.f8126a.m3086f();
        interfaceC3041i.mo3649k();
        interfaceC3041i.mo3646g(iM3086f);
        interfaceC3041i.mo3652o(this.f8126a.f6793a, 0, 4);
        this.f8126a.m3079E(0);
        return this.f8126a.m3086f() == 0;
    }

    /* JADX INFO: renamed from: c */
    public final C2757x m3660c(InterfaceC3041i interfaceC3041i) throws IOException {
        int i = this.f8137l;
        C2757x c2757x = this.f8129d;
        byte[] bArr = c2757x.f6793a;
        if (i > bArr.length) {
            c2757x.f6793a = new byte[Math.max(bArr.length * 2, i)];
            c2757x.f6795c = 0;
            c2757x.f6794b = 0;
        } else {
            c2757x.m3079E(0);
        }
        this.f8129d.m3078D(this.f8137l);
        interfaceC3041i.readFully(this.f8129d.f6793a, 0, this.f8137l);
        return this.f8129d;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:79:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0009 A[SYNTHETIC] */
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        long j;
        boolean zM8837a;
        boolean z2;
        long j2;
        C1460d.m438H(this.f8131f);
        while (true) {
            int i = this.f8132g;
            boolean z3 = false;
            if (i == 1) {
                if (interfaceC3041i.mo3643c(this.f8127b.f6793a, 0, 9, true)) {
                    this.f8127b.m3079E(0);
                    this.f8127b.m3080F(4);
                    int iM3100t = this.f8127b.m3100t();
                    boolean z4 = (iM3100t & 4) != 0;
                    z3 = (iM3100t & 1) != 0;
                    if (z4 && this.f8140o == null) {
                        this.f8140o = new C3013b(this.f8131f.mo2492p(8, 1));
                    }
                    if (z3 && this.f8141p == null) {
                        this.f8141p = new C3016e(this.f8131f.mo2492p(9, 2));
                    }
                    this.f8131f.mo2486j();
                    this.f8135j = (this.f8127b.m3086f() - 9) + 4;
                    this.f8132g = 2;
                    z3 = true;
                }
                if (!z3) {
                    return -1;
                }
            } else if (i == 2) {
                interfaceC3041i.mo3650l(this.f8135j);
                this.f8135j = 0;
                this.f8132g = 3;
            } else if (i == 3) {
                if (interfaceC3041i.mo3643c(this.f8128c.f6793a, 0, 11, true)) {
                    this.f8128c.m3079E(0);
                    this.f8136k = this.f8128c.m3100t();
                    this.f8137l = this.f8128c.m3102v();
                    this.f8138m = this.f8128c.m3102v();
                    this.f8138m = (((long) (this.f8128c.m3100t() << 24)) | this.f8138m) * 1000;
                    this.f8128c.m3080F(3);
                    this.f8132g = 4;
                    z3 = true;
                }
                if (!z3) {
                    return -1;
                }
            } else {
                if (i != 4) {
                    throw new IllegalStateException();
                }
                if (this.f8133h) {
                    j = this.f8134i + this.f8138m;
                } else {
                    j = this.f8130e.f8142b == -9223372036854775807L ? 0L : this.f8138m;
                }
                int i2 = this.f8136k;
                if (i2 == 8 && this.f8140o != null) {
                    m3659a();
                    zM8837a = this.f8140o.m8837a(m3660c(interfaceC3041i), j);
                } else if (i2 != 9 || this.f8141p == null) {
                    if (i2 != 18 || this.f8139n) {
                        interfaceC3041i.mo3650l(this.f8137l);
                        zM8837a = false;
                        z2 = false;
                    } else {
                        zM8837a = this.f8130e.m8837a(m3660c(interfaceC3041i), j);
                        C3015d c3015d = this.f8130e;
                        long j3 = c3015d.f8142b;
                        if (j3 != -9223372036854775807L) {
                            this.f8131f.mo2477a(new C3117r(c3015d.f8144d, c3015d.f8143c, j3));
                            this.f8139n = true;
                        }
                    }
                    if (!this.f8133h && zM8837a) {
                        this.f8133h = true;
                        if (this.f8130e.f8142b == -9223372036854775807L) {
                            j2 = -this.f8138m;
                        } else {
                            j2 = 0;
                        }
                        this.f8134i = j2;
                    }
                    this.f8135j = 4;
                    this.f8132g = 2;
                    if (z2) {
                        return 0;
                    }
                } else {
                    m3659a();
                    zM8837a = this.f8141p.m8837a(m3660c(interfaceC3041i), j);
                }
                z2 = true;
                if (!this.f8133h) {
                    this.f8133h = true;
                    if (this.f8130e.f8142b == -9223372036854775807L) {
                        j2 = -this.f8138m;
                    } else {
                        j2 = 0;
                    }
                    this.f8134i = j2;
                }
                this.f8135j = 4;
                this.f8132g = 2;
                if (z2) {
                    return 0;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8131f = interfaceC3058j;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        if (j == 0) {
            this.f8132g = 1;
            this.f8133h = false;
        } else {
            this.f8132g = 3;
        }
        this.f8135j = 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}
