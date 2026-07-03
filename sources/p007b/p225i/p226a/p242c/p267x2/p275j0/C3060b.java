package p007b.p225i.p226a.p242c.p267x2.p275j0;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p267x2.C3120u;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.b */
/* JADX INFO: compiled from: DefaultOggSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3060b implements InterfaceC3065g {

    /* JADX INFO: renamed from: a */
    public final C3064f f8503a;

    /* JADX INFO: renamed from: b */
    public final long f8504b;

    /* JADX INFO: renamed from: c */
    public final long f8505c;

    /* JADX INFO: renamed from: d */
    public final AbstractC3067i f8506d;

    /* JADX INFO: renamed from: e */
    public int f8507e;

    /* JADX INFO: renamed from: f */
    public long f8508f;

    /* JADX INFO: renamed from: g */
    public long f8509g;

    /* JADX INFO: renamed from: h */
    public long f8510h;

    /* JADX INFO: renamed from: i */
    public long f8511i;

    /* JADX INFO: renamed from: j */
    public long f8512j;

    /* JADX INFO: renamed from: k */
    public long f8513k;

    /* JADX INFO: renamed from: l */
    public long f8514l;

    /* JADX INFO: renamed from: b.i.a.c.x2.j0.b$b */
    /* JADX INFO: compiled from: DefaultOggSeeker.java */
    public final class b implements InterfaceC3119t {
        public b(a aVar) {
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: c */
        public boolean mo3619c() {
            return true;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: h */
        public InterfaceC3119t.a mo3620h(long j) {
            C3060b c3060b = C3060b.this;
            long j2 = (((long) c3060b.f8506d.f8548i) * j) / 1000000;
            long j3 = c3060b.f8504b;
            long j4 = c3060b.f8505c;
            return new InterfaceC3119t.a(new C3120u(j, C2738e0.m3001i(((((j4 - j3) * j2) / c3060b.f8508f) + j3) - 30000, j3, j4 - 1)));
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: i */
        public long mo3621i() {
            C3060b c3060b = C3060b.this;
            return (c3060b.f8508f * 1000000) / ((long) c3060b.f8506d.f8548i);
        }
    }

    public C3060b(AbstractC3067i abstractC3067i, long j, long j2, long j3, long j4, boolean z2) {
        C1460d.m531j(j >= 0 && j2 > j);
        this.f8506d = abstractC3067i;
        this.f8504b = j;
        this.f8505c = j2;
        if (j3 == j2 - j || z2) {
            this.f8508f = j4;
            this.f8507e = 4;
        } else {
            this.f8507e = 0;
        }
        this.f8503a = new C3064f();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.InterfaceC3065g
    @Nullable
    /* JADX INFO: renamed from: a */
    public InterfaceC3119t mo3734a() {
        if (this.f8508f != 0) {
            return new b(null);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.InterfaceC3065g
    /* JADX INFO: renamed from: b */
    public long mo3735b(InterfaceC3041i interfaceC3041i) throws IOException {
        boolean z2;
        long jM3001i;
        long j;
        int i = this.f8507e;
        if (i == 0) {
            long position = interfaceC3041i.getPosition();
            this.f8509g = position;
            this.f8507e = 1;
            long j2 = this.f8505c - 65307;
            if (j2 > position) {
                return j2;
            }
        } else if (i != 1) {
            if (i == 2) {
                if (this.f8511i == this.f8512j) {
                    jM3001i = -1;
                } else {
                    long position2 = interfaceC3041i.getPosition();
                    if (this.f8503a.m3745c(interfaceC3041i, this.f8512j)) {
                        this.f8503a.m3743a(interfaceC3041i, false);
                        interfaceC3041i.mo3649k();
                        long j3 = this.f8510h;
                        C3064f c3064f = this.f8503a;
                        long j4 = c3064f.f8532c;
                        long j5 = j3 - j4;
                        int i2 = c3064f.f8534e + c3064f.f8535f;
                        if (0 > j5 || j5 >= 72000) {
                            if (j5 < 0) {
                                this.f8512j = position2;
                                this.f8514l = j4;
                            } else {
                                this.f8511i = interfaceC3041i.getPosition() + ((long) i2);
                                this.f8513k = this.f8503a.f8532c;
                            }
                            long j6 = this.f8512j;
                            long j7 = this.f8511i;
                            if (j6 - j7 < 100000) {
                                this.f8512j = j7;
                                jM3001i = j7;
                            } else {
                                long position3 = interfaceC3041i.getPosition() - (((long) i2) * (j5 <= 0 ? 2L : 1L));
                                long j8 = this.f8512j;
                                long j9 = this.f8511i;
                                jM3001i = C2738e0.m3001i((((j8 - j9) * j5) / (this.f8514l - this.f8513k)) + position3, j9, j8 - 1);
                            }
                        } else {
                            jM3001i = -1;
                        }
                    } else {
                        jM3001i = this.f8511i;
                        if (jM3001i == position2) {
                            throw new IOException("No ogg page can be found.");
                        }
                    }
                }
                j = -1;
                if (jM3001i != -1) {
                    return jM3001i;
                }
                this.f8507e = 3;
            } else {
                if (i != 3) {
                    if (i == 4) {
                        return -1L;
                    }
                    throw new IllegalStateException();
                }
                j = -1;
            }
            while (true) {
                this.f8503a.m3745c(interfaceC3041i, j);
                this.f8503a.m3743a(interfaceC3041i, false);
                C3064f c3064f2 = this.f8503a;
                if (c3064f2.f8532c > this.f8510h) {
                    interfaceC3041i.mo3649k();
                    this.f8507e = 4;
                    return -(this.f8513k + 2);
                }
                interfaceC3041i.mo3650l(c3064f2.f8534e + c3064f2.f8535f);
                this.f8511i = interfaceC3041i.getPosition();
                this.f8513k = this.f8503a.f8532c;
                j = -1;
            }
        }
        this.f8503a.m3744b();
        if (!this.f8503a.m3745c(interfaceC3041i, -1L)) {
            throw new EOFException();
        }
        this.f8503a.m3743a(interfaceC3041i, false);
        C3064f c3064f3 = this.f8503a;
        interfaceC3041i.mo3650l(c3064f3.f8534e + c3064f3.f8535f);
        long j10 = this.f8503a.f8532c;
        while (true) {
            C3064f c3064f4 = this.f8503a;
            if ((c3064f4.f8531b & 4) == 4 || !c3064f4.m3745c(interfaceC3041i, -1L) || interfaceC3041i.getPosition() >= this.f8505c || !this.f8503a.m3743a(interfaceC3041i, true)) {
                break;
            }
            C3064f c3064f5 = this.f8503a;
            try {
                interfaceC3041i.mo3650l(c3064f5.f8534e + c3064f5.f8535f);
                z2 = true;
            } catch (EOFException unused) {
                z2 = false;
            }
            if (!z2) {
                break;
            }
            j10 = this.f8503a.f8532c;
        }
        this.f8508f = j10;
        this.f8507e = 4;
        return this.f8509g;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.InterfaceC3065g
    /* JADX INFO: renamed from: c */
    public void mo3736c(long j) {
        this.f8510h = C2738e0.m3001i(j, 0L, this.f8508f - 1);
        this.f8507e = 2;
        this.f8511i = this.f8504b;
        this.f8512j = this.f8505c;
        this.f8513k = 0L;
        this.f8514l = this.f8508f;
    }
}
