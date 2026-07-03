package androidx.view;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13124k0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: PausingDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcher extends CoroutineDispatcher {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext context) {
        C12238m.checkNotNullParameter(context, "context");
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        if (C13031n.f27700b.mo11194H().isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
