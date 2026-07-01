package f0.e0.j;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: PushObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements r {
    @Override // f0.e0.j.r
    public boolean a(int i, List<b> list) {
        d0.z.d.m.checkParameterIsNotNull(list, "requestHeaders");
        return true;
    }

    @Override // f0.e0.j.r
    public boolean b(int i, List<b> list, boolean z2) {
        d0.z.d.m.checkParameterIsNotNull(list, "responseHeaders");
        return true;
    }

    @Override // f0.e0.j.r
    public void c(int i, a aVar) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
    }

    @Override // f0.e0.j.r
    public boolean d(int i, g0.g gVar, int i2, boolean z2) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        ((g0.e) gVar).skip(i2);
        return true;
    }
}
