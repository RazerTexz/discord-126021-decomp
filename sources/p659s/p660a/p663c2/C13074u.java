package p659s.p660a.p663c2;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.UndeliveredElementException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: s.a.c2.u */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13074u<E> extends C13073t<E> {

    /* JADX INFO: renamed from: o */
    public final Function1<E, Unit> f27769o;

    /* JADX WARN: Multi-variable type inference failed */
    public C13074u(E e, CancellableContinuation<? super Unit> cancellableContinuation, Function1<? super E, Unit> function1) {
        super(e, cancellableContinuation);
        this.f27769o = function1;
    }

    @Override // p659s.p660a.p661a.C13028k
    /* JADX INFO: renamed from: n */
    public boolean mo11151n() {
        if (!super.mo11151n()) {
            return false;
        }
        mo11241u();
        return true;
    }

    @Override // p659s.p660a.p663c2.AbstractC13071r
    /* JADX INFO: renamed from: u */
    public void mo11241u() {
        Function1<E, Unit> function1 = this.f27769o;
        E e = this.f27767m;
        CoroutineContext context = this.f27768n.getContext();
        UndeliveredElementException undeliveredElementExceptionM4327p = C3404f.m4327p(function1, e, null);
        if (undeliveredElementExceptionM4327p != null) {
            C3404f.m4348u0(context, undeliveredElementExceptionM4327p);
        }
    }
}
