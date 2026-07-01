package b.i.a.c.x2.j0;

import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.x2.t;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: DefaultOggSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements g {
    public final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1234b;
    public final long c;
    public final i d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    public b(i iVar, long j, long j2, long j3, long j4, boolean z2) {
        b.c.a.a0.d.j(j >= 0 && j2 > j);
        this.d = iVar;
        this.f1234b = j;
        this.c = j2;
        if (j3 == j2 - j || z2) {
            this.f = j4;
            this.e = 4;
        } else {
            this.e = 0;
        }
        this.a = new f();
    }

    @Override // b.i.a.c.x2.j0.g
    @Nullable
    public t a() {
        if (this.f != 0) {
            return new b$b(this, null);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    @Override // b.i.a.c.x2.j0.g
    public long b(b.i.a.c.x2.i iVar) throws IOException {
        boolean z2;
        long jI;
        long j;
        int i = this.e;
        if (i == 0) {
            long position = iVar.getPosition();
            this.g = position;
            this.e = 1;
            long j2 = this.c - 65307;
            if (j2 > position) {
                return j2;
            }
        } else if (i != 1) {
            if (i == 2) {
                if (this.i == this.j) {
                    jI = -1;
                } else {
                    long position2 = iVar.getPosition();
                    if (this.a.c(iVar, this.j)) {
                        this.a.a(iVar, false);
                        iVar.k();
                        long j3 = this.h;
                        f fVar = this.a;
                        long j4 = fVar.c;
                        long j5 = j3 - j4;
                        int i2 = fVar.e + fVar.f;
                        if (0 > j5 || j5 >= 72000) {
                            if (j5 < 0) {
                                this.j = position2;
                                this.l = j4;
                            } else {
                                this.i = iVar.getPosition() + ((long) i2);
                                this.k = this.a.c;
                            }
                            long j6 = this.j;
                            long j7 = this.i;
                            if (j6 - j7 < 100000) {
                                this.j = j7;
                                jI = j7;
                            } else {
                                long position3 = iVar.getPosition() - (((long) i2) * (j5 <= 0 ? 2L : 1L));
                                long j8 = this.j;
                                long j9 = this.i;
                                jI = e0.i((((j8 - j9) * j5) / (this.l - this.k)) + position3, j9, j8 - 1);
                            }
                        } else {
                            jI = -1;
                        }
                    } else {
                        jI = this.i;
                        if (jI == position2) {
                            throw new IOException("No ogg page can be found.");
                        }
                    }
                }
                j = -1;
                if (jI != -1) {
                    return jI;
                }
                this.e = 3;
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
                this.a.c(iVar, j);
                this.a.a(iVar, false);
                f fVar2 = this.a;
                if (fVar2.c > this.h) {
                    iVar.k();
                    this.e = 4;
                    return -(this.k + 2);
                }
                iVar.l(fVar2.e + fVar2.f);
                this.i = iVar.getPosition();
                this.k = this.a.c;
                j = -1;
            }
        }
        this.a.b();
        if (!this.a.c(iVar, -1L)) {
            throw new EOFException();
        }
        this.a.a(iVar, false);
        f fVar3 = this.a;
        iVar.l(fVar3.e + fVar3.f);
        long j10 = this.a.c;
        while (true) {
            f fVar4 = this.a;
            if ((fVar4.f1238b & 4) == 4 || !fVar4.c(iVar, -1L) || iVar.getPosition() >= this.c || !this.a.a(iVar, true)) {
                break;
            }
            f fVar5 = this.a;
            try {
                iVar.l(fVar5.e + fVar5.f);
                z2 = true;
            } catch (EOFException unused) {
                z2 = false;
            }
            if (!z2) {
                break;
            }
            j10 = this.a.c;
        }
        this.f = j10;
        this.e = 4;
        return this.g;
    }

    @Override // b.i.a.c.x2.j0.g
    public void c(long j) {
        this.h = e0.i(j, 0L, this.f - 1);
        this.e = 2;
        this.i = this.f1234b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }
}
