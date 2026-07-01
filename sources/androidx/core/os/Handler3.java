package androidx.core.os;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: androidx.core.os.HandlerKt$postAtTime$runnable$1, reason: use source file name */
/* JADX INFO: compiled from: Handler.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Handler3 implements Runnable {
    public final /* synthetic */ Function0<Unit> $action;

    public Handler3(Function0<Unit> function0) {
        this.$action = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
