package androidx.view;

import d0.k;
import d0.k$a;
import d0.l;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: WithLifecycleState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 implements LifecycleEventObserver {
    public final /* synthetic */ Function0 $block$inlined;
    public final /* synthetic */ CancellableContinuation $co;
    public final /* synthetic */ boolean $dispatchNeeded$inlined;
    public final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher$inlined;
    public final /* synthetic */ Lifecycle$State $state$inlined;
    public final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked$inlined;

    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, Lifecycle lifecycle, Lifecycle$State lifecycle$State, Function0 function0, boolean z2, CoroutineDispatcher coroutineDispatcher) {
        this.$co = cancellableContinuation;
        this.$this_suspendWithStateAtLeastUnchecked$inlined = lifecycle;
        this.$state$inlined = lifecycle$State;
        this.$block$inlined = function0;
        this.$dispatchNeeded$inlined = z2;
        this.$lifecycleDispatcher$inlined = coroutineDispatcher;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle$Event event) {
        Object objM97constructorimpl;
        m.checkNotNullParameter(source, "source");
        m.checkNotNullParameter(event, "event");
        if (event != Lifecycle$Event.upTo(this.$state$inlined)) {
            if (event == Lifecycle$Event.ON_DESTROY) {
                this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this);
                CancellableContinuation cancellableContinuation = this.$co;
                LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
                k$a k_a = k.j;
                cancellableContinuation.resumeWith(k.m97constructorimpl(l.createFailure(lifecycleDestroyedException)));
                return;
            }
            return;
        }
        this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this);
        CancellableContinuation cancellableContinuation2 = this.$co;
        Function0 function0 = this.$block$inlined;
        try {
            k$a k_a2 = k.j;
            objM97constructorimpl = k.m97constructorimpl(function0.invoke());
        } catch (Throwable th) {
            k$a k_a3 = k.j;
            objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
        }
        cancellableContinuation2.resumeWith(objM97constructorimpl);
    }
}
