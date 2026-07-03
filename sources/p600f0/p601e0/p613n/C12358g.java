package p600f0.p601e0.p613n;

import p507d0.p592z.p594d.C12238m;
import p615g0.C12388e;

/* JADX INFO: renamed from: f0.e0.n.g */
/* JADX INFO: compiled from: WebSocketProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12358g {
    /* JADX INFO: renamed from: a */
    public static final void m10360a(C12388e.a aVar, byte[] bArr) {
        long j;
        C12238m.checkParameterIsNotNull(aVar, "cursor");
        C12238m.checkParameterIsNotNull(bArr, "key");
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = aVar.f26085n;
            int i2 = aVar.f26086o;
            int i3 = aVar.f26087p;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
            long j2 = aVar.f26084m;
            C12388e c12388e = aVar.f26081j;
            if (c12388e == null) {
                C12238m.throwNpe();
            }
            if (!(j2 != c12388e.f26080k)) {
                throw new IllegalStateException("no more bytes".toString());
            }
            j = aVar.f26084m;
        } while (aVar.m10476b(j == -1 ? 0L : j + ((long) (aVar.f26087p - aVar.f26086o))) != -1);
    }
}
