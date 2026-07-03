package androidx.view;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13116h1;
import p659s.p660a.C13124k0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        C12238m.checkNotNullParameter(lifecycle, "$this$coroutineScope");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.mInternalScopeRef.get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            Job jobM4279d = C3404f.m4279d(null, 1);
            CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, CoroutineContext.Element.C12790a.plus((C13116h1) jobM4279d, C13031n.f27700b.mo11194H()));
        } while (!lifecycle.mInternalScopeRef.compareAndSet(null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }
}
