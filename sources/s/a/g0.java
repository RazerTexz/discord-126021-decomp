package s.a;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public class g0<T> extends b<T> implements f0<T> {
    public g0(CoroutineContext coroutineContext, boolean z2) {
        super(coroutineContext, z2);
    }

    @Override // s.a.f0
    public T d() throws Throwable {
        Object objM = M();
        if (!(!(objM instanceof z0))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (objM instanceof w) {
            throw ((w) objM).f3846b;
        }
        return (T) i1.a(objM);
    }
}
