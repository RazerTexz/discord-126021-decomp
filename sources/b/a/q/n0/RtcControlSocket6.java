package b.a.q.n0;

import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.q.n0.f, reason: use source file name */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcControlSocket6 implements Runnable {
    public final /* synthetic */ Function0 j;

    public RtcControlSocket6(Function0 function0) {
        this.j = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics3.checkNotNullExpressionValue(this.j.invoke(), "invoke(...)");
    }
}
