package b.i.a.c.x2.k0;

import b.i.a.c.x2.a$b;

/* JADX INFO: compiled from: PsBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends b.i.a.c.x2.a {
    public z(b.i.a.c.f3.d0 d0Var, long j, long j2) {
        super(new a$b(), new z$b(d0Var, null), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    public static int g(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
