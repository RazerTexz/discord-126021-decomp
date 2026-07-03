package p659s.p660a;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: s.a.u0 */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13154u0 extends AbstractC12240o implements Function1<CoroutineContext.Element, ExecutorCoroutineDispatcher> {

    /* JADX INFO: renamed from: j */
    public static final C13154u0 f27905j = new C13154u0();

    public C13154u0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public ExecutorCoroutineDispatcher invoke(CoroutineContext.Element element) {
        CoroutineContext.Element element2 = element;
        if (!(element2 instanceof ExecutorCoroutineDispatcher)) {
            element2 = null;
        }
        return (ExecutorCoroutineDispatcher) element2;
    }
}
