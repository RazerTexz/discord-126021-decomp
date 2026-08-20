package androidx.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import p507d0.p584w.C12179f;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3 */
/* JADX INFO: compiled from: WithLifecycleState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0456x3029b3a0 extends AbstractC12240o implements Function1<Throwable, Unit> {
    public final /* synthetic */ Function0 $block$inlined;
    public final /* synthetic */ boolean $dispatchNeeded$inlined;
    public final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher$inlined;
    public final /* synthetic */ C0454x3029b39e $observer;
    public final /* synthetic */ Lifecycle.State $state$inlined;
    public final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0456x3029b3a0(C0454x3029b39e c0454x3029b39e, Lifecycle lifecycle, Lifecycle.State state, Function0 function0, boolean z2, CoroutineDispatcher coroutineDispatcher) {
        super(1);
        this.$observer = c0454x3029b39e;
        this.$this_suspendWithStateAtLeastUnchecked$inlined = lifecycle;
        this.$state$inlined = state;
        this.$block$inlined = function0;
        this.$dispatchNeeded$inlined = z2;
        this.$lifecycleDispatcher$inlined = coroutineDispatcher;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        CoroutineDispatcher coroutineDispatcher = this.$lifecycleDispatcher$inlined;
        C12179f c12179f = C12179f.f25237j;
        if (coroutineDispatcher.isDispatchNeeded(c12179f)) {
            this.$lifecycleDispatcher$inlined.dispatch(c12179f, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3.1
                @Override // java.lang.Runnable
                public final void run() {
                    C0456x3029b3a0 c0456x3029b3a0 = C0456x3029b3a0.this;
                    c0456x3029b3a0.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(c0456x3029b3a0.$observer);
                }
            });
        } else {
            this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this.$observer);
        }
    }
}
