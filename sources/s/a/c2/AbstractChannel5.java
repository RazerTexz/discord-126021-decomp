package s.a.c2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import s.a.a.LockFreeLinkedList3;

/* JADX INFO: renamed from: s.a.c2.n, reason: use source file name */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractChannel5<E> extends LockFreeLinkedList3 implements AbstractChannel6<E> {
    @Override // s.a.c2.AbstractChannel6
    public /* bridge */ /* synthetic */ Object b() {
        return AbstractChannel2.f3834b;
    }

    public Function1<Throwable, Unit> q(E e) {
        return null;
    }

    public abstract void r(AbstractChannel4<?> abstractChannel4);
}
