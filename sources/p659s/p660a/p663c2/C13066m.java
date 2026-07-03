package p659s.p660a.p663c2;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.channels.ProducerScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p659s.p660a.C13116h1;

/* JADX INFO: renamed from: s.a.c2.m */
/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13066m<E> implements ProducerScope<E>, InterfaceC13059f {

    /* JADX INFO: renamed from: m */
    public final InterfaceC13059f<E> f27766m;

    public C13066m(CoroutineContext coroutineContext, InterfaceC13059f<E> interfaceC13059f) {
        super(coroutineContext, true);
        this.f27766m = interfaceC13059f;
    }

    /* JADX INFO: renamed from: a */
    public boolean m11237a() {
        return super.mo10910a();
    }

    @Override // p659s.p660a.p663c2.InterfaceC13068o
    /* JADX INFO: renamed from: b */
    public final void mo11199b(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(mo11182B(), null, this);
        }
        m11240x(cancellationException);
    }

    /* JADX INFO: renamed from: g0 */
    public void m11238g0(Throwable th, boolean z2) {
        if (this.f27766m.mo11221j(th) || z2) {
            return;
        }
        C3404f.m4348u0(this.f27714k, th);
    }

    /* JADX INFO: renamed from: h0 */
    public void m11239h0(Object obj) {
        C3404f.m4213I(this.f27766m, null, 1, null);
    }

    @Override // p659s.p660a.p663c2.InterfaceC13068o
    public InterfaceC13060g iterator() {
        return this.f27766m.iterator();
    }

    @Override // p659s.p660a.p663c2.InterfaceC13072s
    /* JADX INFO: renamed from: j */
    public boolean mo11221j(Throwable th) {
        return this.f27766m.mo11221j(th);
    }

    @Override // p659s.p660a.p663c2.InterfaceC13072s
    /* JADX INFO: renamed from: l */
    public void mo11223l(Function1 function1) {
        this.f27766m.mo11223l(function1);
    }

    @Override // p659s.p660a.p663c2.InterfaceC13068o
    /* JADX INFO: renamed from: m */
    public Object mo11200m(Continuation continuation) {
        return this.f27766m.mo11200m(continuation);
    }

    @Override // p659s.p660a.p663c2.InterfaceC13072s
    /* JADX INFO: renamed from: o */
    public Object mo11224o(Object obj, Continuation continuation) {
        return this.f27766m.mo11224o(obj, continuation);
    }

    @Override // p659s.p660a.p663c2.InterfaceC13072s
    public boolean offer(Object obj) {
        return this.f27766m.offer(obj);
    }

    @Override // p659s.p660a.p663c2.InterfaceC13072s
    /* JADX INFO: renamed from: p */
    public boolean mo11225p() {
        return this.f27766m.mo11225p();
    }

    /* JADX INFO: renamed from: x */
    public void m11240x(Throwable th) throws Throwable {
        CancellationException cancellationExceptionM11284b0 = C13116h1.m11284b0(this, th, null, 1, null);
        this.f27766m.mo11199b(cancellationExceptionM11284b0);
        m11306w(cancellationExceptionM11284b0);
    }
}
