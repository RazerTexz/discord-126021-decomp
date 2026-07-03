package p659s.p660a.p661a;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12112k;
import p507d0.C12113l;
import p659s.p660a.AbstractC13142q0;
import p659s.p660a.C13161w1;
import p659s.p660a.C13162x;

/* JADX INFO: renamed from: s.a.a.h */
/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13025h {

    /* JADX INFO: renamed from: a */
    public static final C13037t f27681a = new C13037t("UNDEFINED");

    /* JADX INFO: renamed from: b */
    public static final C13037t f27682b = new C13037t("REUSABLE_CLAIMED");

    /* JADX INFO: renamed from: a */
    public static final <T> void m11148a(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, Unit> function1) {
        boolean z2;
        if (!(continuation instanceof C13024g)) {
            continuation.resumeWith(obj);
            return;
        }
        C13024g c13024g = (C13024g) continuation;
        Object objM4353v1 = C3404f.m4353v1(obj, function1);
        if (c13024g.f27679q.isDispatchNeeded(c13024g.getContext())) {
            c13024g.f27676n = objM4353v1;
            c13024g.f27864l = 1;
            c13024g.f27679q.dispatch(c13024g.getContext(), c13024g);
            return;
        }
        C13161w1 c13161w1 = C13161w1.f27916b;
        AbstractC13142q0 abstractC13142q0M11353a = C13161w1.m11353a();
        if (abstractC13142q0M11353a.m11338N()) {
            c13024g.f27676n = objM4353v1;
            c13024g.f27864l = 1;
            abstractC13142q0M11353a.m11336J(c13024g);
            return;
        }
        abstractC13142q0M11353a.m11337L(true);
        try {
            Job job = (Job) c13024g.getContext().get(Job.INSTANCE);
            if (job == null || job.mo10910a()) {
                z2 = false;
            } else {
                CancellationException cancellationExceptionMo10914q = job.mo10914q();
                if (objM4353v1 instanceof C13162x) {
                    ((C13162x) objM4353v1).f27918b.invoke(cancellationExceptionMo10914q);
                }
                C12112k.a aVar = C12112k.f25169j;
                c13024g.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(cancellationExceptionMo10914q)));
                z2 = true;
            }
            if (!z2) {
                CoroutineContext context = c13024g.getContext();
                Object objM11141b = C13018a.m11141b(context, c13024g.f27678p);
                try {
                    c13024g.f27680r.resumeWith(obj);
                    C13018a.m11140a(context, objM11141b);
                } catch (Throwable th) {
                    C13018a.m11140a(context, objM11141b);
                    throw th;
                }
            }
            while (abstractC13142q0M11353a.m11340R()) {
            }
        } catch (Throwable th2) {
            try {
                c13024g.m11317l(th2, null);
            } finally {
                abstractC13142q0M11353a.m11334H(true);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ void m11149b(Continuation continuation, Object obj, Function1 function1, int i) {
        int i2 = i & 2;
        m11148a(continuation, obj, null);
    }
}
