package p659s.p660a.p662b2;

import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.AbstractC13128l1;
import p659s.p660a.C13126l;
import p659s.p660a.InterfaceC13115h0;
import p659s.p660a.InterfaceC13130m0;

/* JADX INFO: renamed from: s.a.b2.a */
/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13048a extends AbstractC13049b implements InterfaceC13115h0 {
    public volatile C13048a _immediate;

    /* JADX INFO: renamed from: j */
    public final C13048a f27718j;

    /* JADX INFO: renamed from: k */
    public final Handler f27719k;

    /* JADX INFO: renamed from: l */
    public final String f27720l;

    /* JADX INFO: renamed from: m */
    public final boolean f27721m;

    /* JADX INFO: renamed from: s.a.b2.a$a */
    /* JADX INFO: compiled from: HandlerDispatcher.kt */
    public static final class a implements InterfaceC13130m0 {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Runnable f27723k;

        public a(Runnable runnable) {
            this.f27723k = runnable;
        }

        @Override // p659s.p660a.InterfaceC13130m0
        public void dispose() {
            C13048a.this.f27719k.removeCallbacks(this.f27723k);
        }
    }

    /* JADX INFO: renamed from: s.a.b2.a$b */
    /* JADX INFO: compiled from: Runnable.kt */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ CancellableContinuation f27725k;

        public b(CancellableContinuation cancellableContinuation) {
            this.f27725k = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f27725k.mo10905i(C13048a.this, Unit.f27425a);
        }
    }

    /* JADX INFO: renamed from: s.a.b2.a$c */
    /* JADX INFO: compiled from: HandlerDispatcher.kt */
    public static final class c extends AbstractC12240o implements Function1<Throwable, Unit> {
        public final /* synthetic */ Runnable $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Runnable runnable) {
            super(1);
            this.$block = runnable;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            C13048a.this.f27719k.removeCallbacks(this.$block);
            return Unit.f27425a;
        }
    }

    public C13048a(Handler handler, String str, boolean z2) {
        super(null);
        this.f27719k = handler;
        this.f27720l = str;
        this.f27721m = z2;
        this._immediate = z2 ? this : null;
        C13048a c13048a = this._immediate;
        if (c13048a == null) {
            c13048a = new C13048a(handler, str, true);
            this._immediate = c13048a;
        }
        this.f27718j = c13048a;
    }

    @Override // p659s.p660a.AbstractC13128l1
    /* JADX INFO: renamed from: H */
    public AbstractC13128l1 mo11194H() {
        return this.f27718j;
    }

    @Override // p659s.p660a.InterfaceC13115h0
    /* JADX INFO: renamed from: c */
    public void mo11195c(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        b bVar = new b(cancellableContinuation);
        this.f27719k.postDelayed(bVar, C11226f.coerceAtMost(j, 4611686018427387903L));
        ((C13126l) cancellableContinuation).mo10902f(new c(bVar));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.f27719k.post(runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C13048a) && ((C13048a) obj).f27719k == this.f27719k;
    }

    public int hashCode() {
        return System.identityHashCode(this.f27719k);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return !this.f27721m || (C12238m.areEqual(Looper.myLooper(), this.f27719k.getLooper()) ^ true);
    }

    @Override // p659s.p660a.AbstractC13128l1, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strM11332I = m11332I();
        if (strM11332I != null) {
            return strM11332I;
        }
        String string = this.f27720l;
        if (string == null) {
            string = this.f27719k.toString();
        }
        return this.f27721m ? C1643a.m883w(string, ".immediate") : string;
    }

    @Override // p659s.p660a.p662b2.AbstractC13049b, p659s.p660a.InterfaceC13115h0
    /* JADX INFO: renamed from: x */
    public InterfaceC13130m0 mo11196x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        this.f27719k.postDelayed(runnable, C11226f.coerceAtMost(j, 4611686018427387903L));
        return new a(runnable);
    }
}
