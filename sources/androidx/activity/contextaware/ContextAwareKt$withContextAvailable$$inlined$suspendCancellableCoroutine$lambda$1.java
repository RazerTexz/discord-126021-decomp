package androidx.activity.contextaware;

import android.content.Context;
import d0.k;
import d0.k$a;
import d0.l;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 implements OnContextAvailableListener {
    public final /* synthetic */ CancellableContinuation $co;
    public final /* synthetic */ Function1 $onContextAvailable$inlined;
    public final /* synthetic */ ContextAware $this_withContextAvailable$inlined;

    public ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, ContextAware contextAware, Function1 function1) {
        this.$co = cancellableContinuation;
        this.$this_withContextAvailable$inlined = contextAware;
        this.$onContextAvailable$inlined = function1;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object objM97constructorimpl;
        m.checkNotNullParameter(context, "context");
        CancellableContinuation cancellableContinuation = this.$co;
        try {
            k$a k_a = k.j;
            objM97constructorimpl = k.m97constructorimpl(this.$onContextAvailable$inlined.invoke(context));
        } catch (Throwable th) {
            k$a k_a2 = k.j;
            objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
        }
        cancellableContinuation.resumeWith(objM97constructorimpl);
    }
}
