package androidx.activity.contextaware;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: androidx.activity.contextaware.ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2 */
/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0040x8a9e0a56 extends AbstractC12240o implements Function1<Throwable, Unit> {
    public final /* synthetic */ C0039x8a9e0a55 $listener;
    public final /* synthetic */ Function1 $onContextAvailable$inlined;
    public final /* synthetic */ ContextAware $this_withContextAvailable$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0040x8a9e0a56(C0039x8a9e0a55 c0039x8a9e0a55, ContextAware contextAware, Function1 function1) {
        super(1);
        this.$listener = c0039x8a9e0a55;
        this.$this_withContextAvailable$inlined = contextAware;
        this.$onContextAvailable$inlined = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$this_withContextAvailable$inlined.removeOnContextAvailableListener(this.$listener);
    }
}
