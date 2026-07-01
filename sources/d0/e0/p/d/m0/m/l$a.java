package d0.e0.p.d.m0.m;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$a {
    public static final /* synthetic */ l$a a = new l$a();

    public final d simpleLock(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
        return (runnable == null || function1 == null) ? new d(null, 1, null) : new c(runnable, function1);
    }
}
