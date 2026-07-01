package b.f.j.h;

import b.f.d.d.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: ProgressiveJpegParser.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f589b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public final b.f.d.g.a h;

    public e(b.f.d.g.a aVar) {
        Objects.requireNonNull(aVar);
        this.h = aVar;
        this.c = 0;
        this.f589b = 0;
        this.d = 0;
        this.f = 0;
        this.e = 0;
        this.a = 0;
    }

    public final boolean a(InputStream inputStream) throws Throwable {
        int i;
        int i2 = this.e;
        while (true) {
            try {
                boolean z2 = false;
                if (this.a == 6 || (i = inputStream.read()) == -1) {
                    break;
                }
                int i3 = this.c + 1;
                this.c = i3;
                if (this.g) {
                    this.a = 6;
                    this.g = false;
                    return false;
                }
                int i4 = this.a;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 == 4) {
                                    this.a = 5;
                                } else if (i4 != 5) {
                                    b.c.a.a0.d.B(false);
                                } else {
                                    int i5 = ((this.f589b << 8) + i) - 2;
                                    b.c.a.a0.d.c2(inputStream, i5);
                                    this.c += i5;
                                    this.a = 2;
                                }
                            } else if (i == 255) {
                                this.a = 3;
                            } else if (i == 0) {
                                this.a = 2;
                            } else if (i == 217) {
                                this.g = true;
                                int i6 = i3 - 2;
                                int i7 = this.d;
                                if (i7 > 0) {
                                    this.f = i6;
                                }
                                this.d = i7 + 1;
                                this.e = i7;
                                this.a = 2;
                            } else {
                                if (i == 218) {
                                    int i8 = i3 - 2;
                                    int i9 = this.d;
                                    if (i9 > 0) {
                                        this.f = i8;
                                    }
                                    this.d = i9 + 1;
                                    this.e = i9;
                                }
                                if (i != 1 && ((i < 208 || i > 215) && i != 217 && i != 216)) {
                                    z2 = true;
                                }
                                if (z2) {
                                    this.a = 4;
                                } else {
                                    this.a = 2;
                                }
                            }
                        } else if (i == 255) {
                            this.a = 3;
                        }
                    } else if (i == 216) {
                        this.a = 2;
                    } else {
                        this.a = 6;
                    }
                } else if (i == 255) {
                    this.a = 1;
                } else {
                    this.a = 6;
                }
                this.f589b = i;
            } catch (IOException e) {
                m.a(e);
                throw new RuntimeException(e);
            }
        }
        return (this.a == 6 || this.e == i2) ? false : true;
    }

    public boolean b(b.f.j.j.e eVar) {
        if (this.a == 6 || eVar.n() <= this.c) {
            return false;
        }
        b.f.d.g.f fVar = new b.f.d.g.f(eVar.f(), this.h.get(16384), this.h);
        try {
            try {
                b.c.a.a0.d.c2(fVar, this.c);
                boolean zA = a(fVar);
                b.f.d.d.a.b(fVar);
                return zA;
            } catch (IOException e) {
                m.a(e);
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            b.f.d.d.a.b(fVar);
            throw th;
        }
    }
}
