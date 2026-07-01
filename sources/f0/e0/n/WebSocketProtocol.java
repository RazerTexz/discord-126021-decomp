package f0.e0.n;

import d0.z.d.Intrinsics3;
import g0.Buffer3;

/* JADX INFO: renamed from: f0.e0.n.g, reason: use source file name */
/* JADX INFO: compiled from: WebSocketProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketProtocol {
    public static final void a(Buffer3.a aVar, byte[] bArr) {
        long j;
        Intrinsics3.checkParameterIsNotNull(aVar, "cursor");
        Intrinsics3.checkParameterIsNotNull(bArr, "key");
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = aVar.n;
            int i2 = aVar.o;
            int i3 = aVar.p;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
            long j2 = aVar.m;
            Buffer3 buffer3 = aVar.j;
            if (buffer3 == null) {
                Intrinsics3.throwNpe();
            }
            if (!(j2 != buffer3.k)) {
                throw new IllegalStateException("no more bytes".toString());
            }
            j = aVar.m;
        } while (aVar.b(j == -1 ? 0L : j + ((long) (aVar.p - aVar.o))) != -1);
    }
}
