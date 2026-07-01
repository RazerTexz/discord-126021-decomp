package b.i.a.c.x2.l0;

import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import b.i.a.c.x2.i;
import b.i.a.c.x2.j;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;

/* JADX INFO: compiled from: WavExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$c implements b$b {
    public final j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f1287b;
    public final c c;
    public final j1 d;
    public final int e;
    public long f;
    public int g;
    public long h;

    public b$c(j jVar, w wVar, c cVar, String str, int i) throws ParserException {
        this.a = jVar;
        this.f1287b = wVar;
        this.c = cVar;
        int i2 = (cVar.f1288b * cVar.e) / 8;
        int i3 = cVar.d;
        if (i3 != i2) {
            throw ParserException.a(b.d.b.a.a.h(50, "Expected block size: ", i2, "; got: ", i3), null);
        }
        int i4 = cVar.c * i2;
        int i5 = i4 * 8;
        int iMax = Math.max(i2, i4 / 10);
        this.e = iMax;
        j1$b j1_b = new j1$b();
        j1_b.k = str;
        j1_b.f = i5;
        j1_b.g = i5;
        j1_b.l = iMax;
        j1_b.f1023x = cVar.f1288b;
        j1_b.f1024y = cVar.c;
        j1_b.f1025z = i;
        this.d = j1_b.a();
    }

    @Override // b.i.a.c.x2.l0.b$b
    public void a(long j) {
        this.f = j;
        this.g = 0;
        this.h = 0L;
    }

    @Override // b.i.a.c.x2.l0.b$b
    public void b(int i, long j) {
        this.a.a(new e(this.c, 1, i, j));
        this.f1287b.e(this.d);
    }

    @Override // b.i.a.c.x2.l0.b$b
    public boolean c(i iVar, long j) throws IOException {
        int i;
        int i2;
        long j2 = j;
        while (j2 > 0 && (i = this.g) < (i2 = this.e)) {
            int iB = this.f1287b.b(iVar, (int) Math.min(i2 - i, j2), true);
            if (iB == -1) {
                j2 = 0;
            } else {
                this.g += iB;
                j2 -= (long) iB;
            }
        }
        c cVar = this.c;
        int i3 = cVar.d;
        int i4 = this.g / i3;
        if (i4 > 0) {
            long jF = this.f + e0.F(this.h, 1000000L, cVar.c);
            int i5 = i4 * i3;
            int i6 = this.g - i5;
            this.f1287b.d(jF, 1, i5, i6, null);
            this.h += (long) i4;
            this.g = i6;
        }
        return j2 <= 0;
    }
}
