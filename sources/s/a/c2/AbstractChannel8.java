package s.a.c2;

import com.discord.widgets.chat.input.MentionUtils;
import d0.Result2;
import d0.Result3;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import s.a.CancellableContinuationImpl6;
import s.a.a.LockFreeLinkedList3;
import s.a.a.Symbol3;

/* JADX INFO: renamed from: s.a.c2.t, reason: use source file name */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class AbstractChannel8<E> extends AbstractChannel7 {
    public final E m;
    public final CancellableContinuation<Unit> n;

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractChannel8(E e, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.m = e;
        this.n = cancellableContinuation;
    }

    @Override // s.a.c2.AbstractChannel7
    public void q() {
        this.n.r(CancellableContinuationImpl6.a);
    }

    @Override // s.a.c2.AbstractChannel7
    public E r() {
        return this.m;
    }

    @Override // s.a.c2.AbstractChannel7
    public void s(AbstractChannel4<?> abstractChannel4) {
        CancellableContinuation<Unit> cancellableContinuation = this.n;
        Throwable thW = abstractChannel4.w();
        Result2.a aVar = Result2.j;
        cancellableContinuation.resumeWith(Result2.m97constructorimpl(Result3.createFailure(thW)));
    }

    @Override // s.a.c2.AbstractChannel7
    public Symbol3 t(LockFreeLinkedList3.b bVar) {
        if (this.n.c(Unit.a, null) != null) {
            return CancellableContinuationImpl6.a;
        }
        return null;
    }

    @Override // s.a.a.LockFreeLinkedList3
    public String toString() {
        return getClass().getSimpleName() + MentionUtils.MENTIONS_CHAR + b.i.a.f.e.o.f.l0(this) + '(' + this.m + ')';
    }
}
