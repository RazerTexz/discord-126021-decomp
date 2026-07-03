package p659s.p660a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12112k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: s.a.d */
/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13076d<T> {

    /* JADX INFO: renamed from: a */
    public static final AtomicIntegerFieldUpdater f27772a = AtomicIntegerFieldUpdater.newUpdater(C13076d.class, "notCompletedCount");

    /* JADX INFO: renamed from: b */
    public final InterfaceC13109f0<T>[] f27773b;
    public volatile int notCompletedCount;

    /* JADX INFO: renamed from: s.a.d$a */
    /* JADX INFO: compiled from: Await.kt */
    public final class a extends AbstractC13113g1<Job> {
        public volatile Object _disposer;

        /* JADX INFO: renamed from: n */
        public InterfaceC13130m0 f27774n;

        /* JADX INFO: renamed from: o */
        public final CancellableContinuation<List<? extends T>> f27775o;

        /* JADX WARN: Multi-variable type inference failed */
        public a(CancellableContinuation<? super List<? extends T>> cancellableContinuation, Job job) {
            super(job);
            this.f27775o = cancellableContinuation;
            this._disposer = null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            mo11198q(th);
            return Unit.f27425a;
        }

        @Override // p659s.p660a.AbstractC13165y
        /* JADX INFO: renamed from: q */
        public void mo11198q(Throwable th) {
            if (th != null) {
                Object objMo10903g = this.f27775o.mo10903g(th);
                if (objMo10903g != null) {
                    this.f27775o.mo10907r(objMo10903g);
                    b bVar = (b) this._disposer;
                    if (bVar != null) {
                        bVar.m11242b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (C13076d.f27772a.decrementAndGet(C13076d.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.f27775o;
                InterfaceC13109f0<T>[] interfaceC13109f0Arr = C13076d.this.f27773b;
                ArrayList arrayList = new ArrayList(interfaceC13109f0Arr.length);
                for (InterfaceC13109f0<T> interfaceC13109f0 : interfaceC13109f0Arr) {
                    arrayList.add(interfaceC13109f0.mo11278d());
                }
                C12112k.a aVar = C12112k.f25169j;
                cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(arrayList));
            }
        }
    }

    /* JADX INFO: renamed from: s.a.d$b */
    /* JADX INFO: compiled from: Await.kt */
    public final class b extends AbstractC13120j {

        /* JADX INFO: renamed from: j */
        public final C13076d<T>.a[] f27777j;

        public b(C13076d c13076d, C13076d<T>.a[] aVarArr) {
            this.f27777j = aVarArr;
        }

        @Override // p659s.p660a.AbstractC13123k
        /* JADX INFO: renamed from: a */
        public void mo11193a(Throwable th) {
            m11242b();
        }

        /* JADX INFO: renamed from: b */
        public final void m11242b() {
            for (C13076d<T>.a aVar : this.f27777j) {
                InterfaceC13130m0 interfaceC13130m0 = aVar.f27774n;
                if (interfaceC13130m0 == null) {
                    C12238m.throwUninitializedPropertyAccessException("handle");
                }
                interfaceC13130m0.dispose();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            m11242b();
            return Unit.f27425a;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("DisposeHandlersOnCancel[");
            sbM833U.append(this.f27777j);
            sbM833U.append(']');
            return sbM833U.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C13076d(InterfaceC13109f0<? extends T>[] interfaceC13109f0Arr) {
        this.f27773b = interfaceC13109f0Arr;
        this.notCompletedCount = interfaceC13109f0Arr.length;
    }
}
