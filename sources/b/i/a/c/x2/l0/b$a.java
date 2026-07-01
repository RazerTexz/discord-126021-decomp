package b.i.a.c.x2.l0;

import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import b.i.a.c.x2.j;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WavExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a implements b$b {
    public static final int[] a = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1286b = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, Opcodes.D2L, 157, Opcodes.LRETURN, Opcodes.ARRAYLENGTH, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    public final j c;
    public final w d;
    public final c e;
    public final int f;
    public final byte[] g;
    public final x h;
    public final int i;
    public final j1 j;
    public int k;
    public long l;
    public int m;
    public long n;

    public b$a(j jVar, w wVar, c cVar) throws ParserException {
        this.c = jVar;
        this.d = wVar;
        this.e = cVar;
        int iMax = Math.max(1, cVar.c / 10);
        this.i = iMax;
        byte[] bArr = cVar.f;
        int length = bArr.length;
        byte b2 = bArr[0];
        byte b3 = bArr[1];
        int i = ((bArr[3] & 255) << 8) | (bArr[2] & 255);
        this.f = i;
        int i2 = cVar.f1288b;
        int i3 = (((cVar.d - (i2 * 4)) * 8) / (cVar.e * i2)) + 1;
        if (i != i3) {
            throw ParserException.a(b.d.b.a.a.h(56, "Expected frames per block: ", i3, "; got: ", i), null);
        }
        int iF = e0.f(iMax, i);
        this.g = new byte[cVar.d * iF];
        this.h = new x(i * 2 * i2 * iF);
        int i4 = cVar.c;
        int i5 = ((cVar.d * i4) * 8) / i;
        j1$b j1_b = new j1$b();
        j1_b.k = "audio/raw";
        j1_b.f = i5;
        j1_b.g = i5;
        j1_b.l = iMax * 2 * i2;
        j1_b.f1023x = cVar.f1288b;
        j1_b.f1024y = i4;
        j1_b.f1025z = 2;
        this.j = j1_b.a();
    }

    @Override // b.i.a.c.x2.l0.b$b
    public void a(long j) {
        this.k = 0;
        this.l = j;
        this.m = 0;
        this.n = 0L;
    }

    @Override // b.i.a.c.x2.l0.b$b
    public void b(int i, long j) {
        this.c.a(new e(this.e, this.f, i, j));
        this.d.e(this.j);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003f -> B:12:0x0041). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:7:0x0029
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // b.i.a.c.x2.l0.b$b
    public boolean c(b.i.a.c.x2.i r19, long r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.c.x2.l0.b$a.c(b.i.a.c.x2.i, long):boolean");
    }

    public final int d(int i) {
        return i / (this.e.f1288b * 2);
    }

    public final void e(int i) {
        long jF = this.l + e0.F(this.n, 1000000L, this.e.c);
        int i2 = i * 2 * this.e.f1288b;
        this.d.d(jF, 1, i2, this.m - i2, null);
        this.n += (long) i;
        this.m -= i2;
    }
}
