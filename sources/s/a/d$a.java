package s.a;

import d0.k$a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a extends g1<Job> {
    public volatile Object _disposer;
    public m0 n;
    public final CancellableContinuation<List<? extends T>> o;
    public final /* synthetic */ d p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d$a(d dVar, CancellableContinuation<? super List<? extends T>> cancellableContinuation, Job job) {
        super(job);
        this.p = dVar;
        this.o = cancellableContinuation;
        this._disposer = null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        q(th);
        return Unit.a;
    }

    @Override // s.a.y
    public void q(Throwable th) {
        if (th != null) {
            Object objG = this.o.g(th);
            if (objG != null) {
                this.o.r(objG);
                d$b d_b = (d$b) this._disposer;
                if (d_b != null) {
                    d_b.b();
                    return;
                }
                return;
            }
            return;
        }
        if (d.a.decrementAndGet(this.p) == 0) {
            Continuation continuation = this.o;
            f0[] f0VarArr = this.p.f3836b;
            ArrayList arrayList = new ArrayList(f0VarArr.length);
            for (f0 f0Var : f0VarArr) {
                arrayList.add(f0Var.d());
            }
            k$a k_a = d0.k.j;
            continuation.resumeWith(d0.k.m97constructorimpl(arrayList));
        }
    }
}
