package b.a.q.m0.c;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {
    public final /* synthetic */ Function0 j;

    public i(Function0 function0) {
        this.j = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        d0.z.d.m.checkNotNullExpressionValue(this.j.invoke(), "invoke(...)");
    }
}
