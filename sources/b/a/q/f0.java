package b.a.q;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Runnable {
    public final /* synthetic */ Function0 j;

    public f0(Function0 function0) {
        this.j = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        d0.z.d.m.checkNotNullExpressionValue(this.j.invoke(), "invoke(...)");
    }
}
