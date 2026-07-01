package b.a.q.n0;

import d0.z.d.m;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {
    public final /* synthetic */ Function0 j;

    public f(Function0 function0) {
        this.j = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        m.checkNotNullExpressionValue(this.j.invoke(), "invoke(...)");
    }
}
