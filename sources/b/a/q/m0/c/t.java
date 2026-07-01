package b.a.q.m0.c;

import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Runnable {
    public final /* synthetic */ Function0 j;

    public t(Function0 function0) {
        this.j = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics3.checkNotNullExpressionValue(this.j.invoke(), "invoke(...)");
    }
}
