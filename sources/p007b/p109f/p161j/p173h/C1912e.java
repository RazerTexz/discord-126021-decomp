package p007b.p109f.p161j.p173h;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1678a;
import p007b.p109f.p115d.p119d.C1690m;
import p007b.p109f.p115d.p122g.C1699f;
import p007b.p109f.p115d.p122g.InterfaceC1694a;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.h.e */
/* JADX INFO: compiled from: ProgressiveJpegParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1912e {

    /* JADX INFO: renamed from: a */
    public int f3873a;

    /* JADX INFO: renamed from: b */
    public int f3874b;

    /* JADX INFO: renamed from: c */
    public int f3875c;

    /* JADX INFO: renamed from: d */
    public int f3876d;

    /* JADX INFO: renamed from: e */
    public int f3877e;

    /* JADX INFO: renamed from: f */
    public int f3878f;

    /* JADX INFO: renamed from: g */
    public boolean f3879g;

    /* JADX INFO: renamed from: h */
    public final InterfaceC1694a f3880h;

    public C1912e(InterfaceC1694a interfaceC1694a) {
        Objects.requireNonNull(interfaceC1694a);
        this.f3880h = interfaceC1694a;
        this.f3875c = 0;
        this.f3874b = 0;
        this.f3876d = 0;
        this.f3878f = 0;
        this.f3877e = 0;
        this.f3873a = 0;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1326a(InputStream inputStream) throws Throwable {
        int i;
        int i2 = this.f3877e;
        while (true) {
            try {
                boolean z2 = false;
                if (this.f3873a == 6 || (i = inputStream.read()) == -1) {
                    break;
                }
                int i3 = this.f3875c + 1;
                this.f3875c = i3;
                if (this.f3879g) {
                    this.f3873a = 6;
                    this.f3879g = false;
                    return false;
                }
                int i4 = this.f3873a;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 == 4) {
                                    this.f3873a = 5;
                                } else if (i4 != 5) {
                                    C1460d.m419B(false);
                                } else {
                                    int i5 = ((this.f3874b << 8) + i) - 2;
                                    C1460d.m506c2(inputStream, i5);
                                    this.f3875c += i5;
                                    this.f3873a = 2;
                                }
                            } else if (i == 255) {
                                this.f3873a = 3;
                            } else if (i == 0) {
                                this.f3873a = 2;
                            } else if (i == 217) {
                                this.f3879g = true;
                                int i6 = i3 - 2;
                                int i7 = this.f3876d;
                                if (i7 > 0) {
                                    this.f3878f = i6;
                                }
                                this.f3876d = i7 + 1;
                                this.f3877e = i7;
                                this.f3873a = 2;
                            } else {
                                if (i == 218) {
                                    int i8 = i3 - 2;
                                    int i9 = this.f3876d;
                                    if (i9 > 0) {
                                        this.f3878f = i8;
                                    }
                                    this.f3876d = i9 + 1;
                                    this.f3877e = i9;
                                }
                                if (i != 1 && ((i < 208 || i > 215) && i != 217 && i != 216)) {
                                    z2 = true;
                                }
                                if (z2) {
                                    this.f3873a = 4;
                                } else {
                                    this.f3873a = 2;
                                }
                            }
                        } else if (i == 255) {
                            this.f3873a = 3;
                        }
                    } else if (i == 216) {
                        this.f3873a = 2;
                    } else {
                        this.f3873a = 6;
                    }
                } else if (i == 255) {
                    this.f3873a = 1;
                } else {
                    this.f3873a = 6;
                }
                this.f3874b = i;
            } catch (IOException e) {
                C1690m.m972a(e);
                throw new RuntimeException(e);
            }
        }
        return (this.f3873a == 6 || this.f3877e == i2) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m1327b(C1919e c1919e) {
        if (this.f3873a == 6 || c1919e.m1344n() <= this.f3875c) {
            return false;
        }
        C1699f c1699f = new C1699f(c1919e.m1343f(), this.f3880h.get(16384), this.f3880h);
        try {
            try {
                C1460d.m506c2(c1699f, this.f3875c);
                boolean zM1326a = m1326a(c1699f);
                C1678a.m966b(c1699f);
                return zM1326a;
            } catch (IOException e) {
                C1690m.m972a(e);
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            C1678a.m966b(c1699f);
            throw th;
        }
    }
}
