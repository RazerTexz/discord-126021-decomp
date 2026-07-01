package s.a.b2;

import android.os.Handler;
import android.os.Looper;
import b.d.b.a.outline;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import s.a.CancellableContinuationImpl5;
import s.a.Delay;
import s.a.Job2;
import s.a.MainCoroutineDispatcher;

/* JADX INFO: renamed from: s.a.b2.a, reason: use source file name */
/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HandlerDispatcher2 extends HandlerDispatcher3 implements Delay {
    public volatile HandlerDispatcher2 _immediate;
    public final HandlerDispatcher2 j;
    public final Handler k;
    public final String l;
    public final boolean m;

    /* JADX INFO: renamed from: s.a.b2.a$a */
    /* JADX INFO: compiled from: HandlerDispatcher.kt */
    public static final class a implements Job2 {
        public final /* synthetic */ Runnable k;

        public a(Runnable runnable) {
            this.k = runnable;
        }

        @Override // s.a.Job2
        public void dispose() {
            HandlerDispatcher2.this.k.removeCallbacks(this.k);
        }
    }

    /* JADX INFO: renamed from: s.a.b2.a$b */
    /* JADX INFO: compiled from: Runnable.kt */
    public static final class b implements Runnable {
        public final /* synthetic */ CancellableContinuation k;

        public b(CancellableContinuation cancellableContinuation) {
            this.k = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.k.i(HandlerDispatcher2.this, Unit.a);
        }
    }

    /* JADX INFO: renamed from: s.a.b2.a$c */
    /* JADX INFO: compiled from: HandlerDispatcher.kt */
    public static final class c extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ Runnable $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Runnable runnable) {
            super(1);
            this.$block = runnable;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            HandlerDispatcher2.this.k.removeCallbacks(this.$block);
            return Unit.a;
        }
    }

    public HandlerDispatcher2(Handler handler, String str, boolean z2) {
        super(null);
        this.k = handler;
        this.l = str;
        this.m = z2;
        this._immediate = z2 ? this : null;
        HandlerDispatcher2 handlerDispatcher2 = this._immediate;
        if (handlerDispatcher2 == null) {
            handlerDispatcher2 = new HandlerDispatcher2(handler, str, true);
            this._immediate = handlerDispatcher2;
        }
        this.j = handlerDispatcher2;
    }

    @Override // s.a.MainCoroutineDispatcher
    public MainCoroutineDispatcher H() {
        return this.j;
    }

    @Override // s.a.Delay
    public void c(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        b bVar = new b(cancellableContinuation);
        this.k.postDelayed(bVar, _Ranges.coerceAtMost(j, 4611686018427387903L));
        ((CancellableContinuationImpl5) cancellableContinuation).f(new c(bVar));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.k.post(runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HandlerDispatcher2) && ((HandlerDispatcher2) obj).k == this.k;
    }

    public int hashCode() {
        return System.identityHashCode(this.k);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return !this.m || (Intrinsics3.areEqual(Looper.myLooper(), this.k.getLooper()) ^ true);
    }

    @Override // s.a.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strI = I();
        if (strI != null) {
            return strI;
        }
        String string = this.l;
        if (string == null) {
            string = this.k.toString();
        }
        return this.m ? outline.w(string, ".immediate") : string;
    }

    @Override // s.a.b2.HandlerDispatcher3, s.a.Delay
    public Job2 x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        this.k.postDelayed(runnable, _Ranges.coerceAtMost(j, 4611686018427387903L));
        return new a(runnable);
    }
}
