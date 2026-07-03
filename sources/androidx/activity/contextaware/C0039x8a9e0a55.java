package androidx.activity.contextaware;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: androidx.activity.contextaware.ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 */
/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0039x8a9e0a55 implements OnContextAvailableListener {
    public final /* synthetic */ CancellableContinuation $co;
    public final /* synthetic */ Function1 $onContextAvailable$inlined;
    public final /* synthetic */ ContextAware $this_withContextAvailable$inlined;

    public C0039x8a9e0a55(CancellableContinuation cancellableContinuation, ContextAware contextAware, Function1 function1) {
        this.$co = cancellableContinuation;
        this.$this_withContextAvailable$inlined = contextAware;
        this.$onContextAvailable$inlined = function1;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object objM11474constructorimpl;
        C12238m.checkNotNullParameter(context, "context");
        CancellableContinuation cancellableContinuation = this.$co;
        try {
            C12112k.a aVar = C12112k.f25169j;
            objM11474constructorimpl = C12112k.m11474constructorimpl(this.$onContextAvailable$inlined.invoke(context));
        } catch (Throwable th) {
            C12112k.a aVar2 = C12112k.f25169j;
            objM11474constructorimpl = C12112k.m11474constructorimpl(C12113l.createFailure(th));
        }
        cancellableContinuation.resumeWith(objM11474constructorimpl);
    }
}
