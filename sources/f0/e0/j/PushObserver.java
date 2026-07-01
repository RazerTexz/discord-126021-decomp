package f0.e0.j;

import d0.z.d.Intrinsics3;
import g0.Buffer3;
import g0.BufferedSource;
import java.io.IOException;
import java.util.List;

/* JADX INFO: renamed from: f0.e0.j.q, reason: use source file name */
/* JADX INFO: compiled from: PushObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PushObserver implements PushObserver2 {
    @Override // f0.e0.j.PushObserver2
    public boolean a(int i, List<Header2> list) {
        Intrinsics3.checkParameterIsNotNull(list, "requestHeaders");
        return true;
    }

    @Override // f0.e0.j.PushObserver2
    public boolean b(int i, List<Header2> list, boolean z2) {
        Intrinsics3.checkParameterIsNotNull(list, "responseHeaders");
        return true;
    }

    @Override // f0.e0.j.PushObserver2
    public void c(int i, ErrorCode2 errorCode2) {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
    }

    @Override // f0.e0.j.PushObserver2
    public boolean d(int i, BufferedSource bufferedSource, int i2, boolean z2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        ((Buffer3) bufferedSource).skip(i2);
        return true;
    }
}
