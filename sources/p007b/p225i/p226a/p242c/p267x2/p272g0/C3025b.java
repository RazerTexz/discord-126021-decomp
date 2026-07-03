package p007b.p225i.p226a.p242c.p267x2.p272g0;

import java.io.IOException;
import java.util.ArrayDeque;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;

/* JADX INFO: renamed from: b.i.a.c.x2.g0.b */
/* JADX INFO: compiled from: DefaultEbmlReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3025b implements InterfaceC3027d {

    /* JADX INFO: renamed from: a */
    public final byte[] f8181a = new byte[8];

    /* JADX INFO: renamed from: b */
    public final ArrayDeque<b> f8182b = new ArrayDeque<>();

    /* JADX INFO: renamed from: c */
    public final C3030g f8183c = new C3030g();

    /* JADX INFO: renamed from: d */
    public InterfaceC3026c f8184d;

    /* JADX INFO: renamed from: e */
    public int f8185e;

    /* JADX INFO: renamed from: f */
    public int f8186f;

    /* JADX INFO: renamed from: g */
    public long f8187g;

    /* JADX INFO: renamed from: b.i.a.c.x2.g0.b$b */
    /* JADX INFO: compiled from: DefaultEbmlReader.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f8188a;

        /* JADX INFO: renamed from: b */
        public final long f8189b;

        public b(int i, long j, a aVar) {
            this.f8188a = i;
            this.f8189b = j;
        }
    }

    /* JADX INFO: renamed from: a */
    public final long m3670a(InterfaceC3041i interfaceC3041i, int i) throws IOException {
        interfaceC3041i.readFully(this.f8181a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.f8181a[i2] & 255));
        }
        return j;
    }
}
