package g0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a {
    public b$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final b a() throws InterruptedException {
        b bVar = b.g;
        if (bVar == null) {
            d0.z.d.m.throwNpe();
        }
        b bVar2 = bVar.j;
        if (bVar2 == null) {
            long jNanoTime = System.nanoTime();
            b.class.wait(b.e);
            b bVar3 = b.g;
            if (bVar3 == null) {
                d0.z.d.m.throwNpe();
            }
            if (bVar3.j != null || System.nanoTime() - jNanoTime < b.f) {
                return null;
            }
            return b.g;
        }
        long jNanoTime2 = bVar2.k - System.nanoTime();
        if (jNanoTime2 > 0) {
            long j = jNanoTime2 / 1000000;
            b.class.wait(j, (int) (jNanoTime2 - (1000000 * j)));
            return null;
        }
        b bVar4 = b.g;
        if (bVar4 == null) {
            d0.z.d.m.throwNpe();
        }
        bVar4.j = bVar2.j;
        bVar2.j = null;
        return bVar2;
    }
}
