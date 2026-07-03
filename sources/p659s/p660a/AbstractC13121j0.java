package p659s.p660a;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C11211b;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.p661a.C13018a;
import p659s.p660a.p661a.C13024g;
import p659s.p660a.p666e2.AbstractRunnableC13102h;
import p659s.p660a.p666e2.InterfaceC13103i;

/* JADX INFO: renamed from: s.a.j0 */
/* JADX INFO: compiled from: DispatchedTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC13121j0<T> extends AbstractRunnableC13102h {

    /* JADX INFO: renamed from: l */
    public int f27864l;

    public AbstractC13121j0(int i) {
        this.f27864l = i;
    }

    /* JADX INFO: renamed from: b */
    public void mo11145b(Object obj, Throwable th) {
    }

    /* JADX INFO: renamed from: d */
    public abstract Continuation<T> mo11146d();

    /* JADX INFO: renamed from: e */
    public Throwable mo11315e(Object obj) {
        if (!(obj instanceof C13159w)) {
            obj = null;
        }
        C13159w c13159w = (C13159w) obj;
        if (c13159w != null) {
            return c13159w.f27913b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: j */
    public <T> T mo11316j(Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: l */
    public final void m11317l(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            C11211b.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        C12238m.checkNotNull(th);
        C3404f.m4348u0(mo11146d().getContext(), new C13052c0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    /* JADX INFO: renamed from: m */
    public abstract Object mo11147m();

    @Override // java.lang.Runnable
    public final void run() {
        Object objM11474constructorimpl;
        Object objM11474constructorimpl2;
        InterfaceC13103i interfaceC13103i = this.f27829k;
        try {
            Continuation<T> continuationMo11146d = mo11146d();
            if (continuationMo11146d == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            }
            C13024g c13024g = (C13024g) continuationMo11146d;
            Continuation<T> continuation = c13024g.f27680r;
            CoroutineContext context = continuation.getContext();
            Object objMo11147m = mo11147m();
            Object objM11141b = C13018a.m11141b(context, c13024g.f27678p);
            try {
                Throwable thMo11315e = mo11315e(objMo11147m);
                Job job = (thMo11315e == null && C3404f.m4193B0(this.f27864l)) ? (Job) context.get(Job.INSTANCE) : null;
                if (job != null && !job.mo10910a()) {
                    CancellationException cancellationExceptionMo10914q = job.mo10914q();
                    mo11145b(objMo11147m, cancellationExceptionMo10914q);
                    C12112k.a aVar = C12112k.f25169j;
                    continuation.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(cancellationExceptionMo10914q)));
                } else if (thMo11315e != null) {
                    C12112k.a aVar2 = C12112k.f25169j;
                    continuation.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(thMo11315e)));
                } else {
                    T tMo11316j = mo11316j(objMo11147m);
                    C12112k.a aVar3 = C12112k.f25169j;
                    continuation.resumeWith(C12112k.m11474constructorimpl(tMo11316j));
                }
                Unit unit = Unit.f27425a;
                C13018a.m11140a(context, objM11141b);
                try {
                    C12112k.a aVar4 = C12112k.f25169j;
                    interfaceC13103i.mo11268f();
                    objM11474constructorimpl2 = C12112k.m11474constructorimpl(unit);
                } catch (Throwable th) {
                    C12112k.a aVar5 = C12112k.f25169j;
                    objM11474constructorimpl2 = C12112k.m11474constructorimpl(C12113l.createFailure(th));
                }
                m11317l(null, C12112k.m11476exceptionOrNullimpl(objM11474constructorimpl2));
            } catch (Throwable th2) {
                C13018a.m11140a(context, objM11141b);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                C12112k.a aVar6 = C12112k.f25169j;
                interfaceC13103i.mo11268f();
                objM11474constructorimpl = C12112k.m11474constructorimpl(Unit.f27425a);
            } catch (Throwable th4) {
                C12112k.a aVar7 = C12112k.f25169j;
                objM11474constructorimpl = C12112k.m11474constructorimpl(C12113l.createFailure(th4));
            }
            m11317l(th3, C12112k.m11476exceptionOrNullimpl(objM11474constructorimpl));
        }
    }
}
