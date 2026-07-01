package s.a;

import b.d.b.a.outline;
import d0.Result2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Job;

/* JADX INFO: renamed from: s.a.d, reason: use source file name */
/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Await<T> {
    public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(Await.class, "notCompletedCount");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deferred<T>[] f3836b;
    public volatile int notCompletedCount;

    /* JADX INFO: renamed from: s.a.d$a */
    /* JADX INFO: compiled from: Await.kt */
    public final class a extends g1<Job> {
        public volatile Object _disposer;
        public Job2 n;
        public final CancellableContinuation<List<? extends T>> o;

        /* JADX WARN: Multi-variable type inference failed */
        public a(CancellableContinuation<? super List<? extends T>> cancellableContinuation, Job job) {
            super(job);
            this.o = cancellableContinuation;
            this._disposer = null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            q(th);
            return Unit.a;
        }

        @Override // s.a.CompletionHandler2
        public void q(Throwable th) {
            if (th != null) {
                Object objG = this.o.g(th);
                if (objG != null) {
                    this.o.r(objG);
                    b bVar = (b) this._disposer;
                    if (bVar != null) {
                        bVar.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (Await.a.decrementAndGet(Await.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.o;
                Deferred<T>[] deferredArr = Await.this.f3836b;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred<T> deferred : deferredArr) {
                    arrayList.add(deferred.d());
                }
                Result2.a aVar = Result2.j;
                cancellableContinuation.resumeWith(Result2.m97constructorimpl(arrayList));
            }
        }
    }

    /* JADX INFO: renamed from: s.a.d$b */
    /* JADX INFO: compiled from: Await.kt */
    public final class b extends CancellableContinuationImpl4 {
        public final Await<T>.a[] j;

        public b(Await await, Await<T>.a[] aVarArr) {
            this.j = aVarArr;
        }

        @Override // s.a.CompletionHandler
        public void a(Throwable th) {
            b();
        }

        public final void b() {
            for (Await<T>.a aVar : this.j) {
                Job2 job2 = aVar.n;
                if (job2 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("handle");
                }
                job2.dispose();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            b();
            return Unit.a;
        }

        public String toString() {
            StringBuilder sbU = outline.U("DisposeHandlersOnCancel[");
            sbU.append(this.j);
            sbU.append(']');
            return sbU.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Await(Deferred<? extends T>[] deferredArr) {
        this.f3836b = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }
}
