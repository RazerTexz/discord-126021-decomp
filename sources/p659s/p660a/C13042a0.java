package p659s.p660a;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: s.a.a0 */
/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13042a0 extends AbstractC12240o implements Function1<CoroutineContext.Element, CoroutineDispatcher> {

    /* JADX INFO: renamed from: j */
    public static final C13042a0 f27711j = new C13042a0();

    public C13042a0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public CoroutineDispatcher invoke(CoroutineContext.Element element) {
        CoroutineContext.Element element2 = element;
        if (!(element2 instanceof CoroutineDispatcher)) {
            element2 = null;
        }
        return (CoroutineDispatcher) element2;
    }
}
