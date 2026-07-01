package f0.e0.n;

import d0.z.d.m;
import g0.e$a;

/* JADX INFO: compiled from: WebSocketProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final void a(e$a e_a, byte[] bArr) {
        long j;
        m.checkParameterIsNotNull(e_a, "cursor");
        m.checkParameterIsNotNull(bArr, "key");
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = e_a.n;
            int i2 = e_a.o;
            int i3 = e_a.p;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
            long j2 = e_a.m;
            g0.e eVar = e_a.j;
            if (eVar == null) {
                m.throwNpe();
            }
            if (!(j2 != eVar.k)) {
                throw new IllegalStateException("no more bytes".toString());
            }
            j = e_a.m;
        } while (e_a.b(j == -1 ? 0L : j + ((long) (e_a.p - e_a.o))) != -1);
    }
}
