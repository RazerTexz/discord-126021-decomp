package p659s.p660a.p664d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p659s.p660a.p664d2.p665g.C13089e;

/* JADX INFO: renamed from: s.a.d2.a */
/* JADX INFO: compiled from: Flow.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC13079a<T> implements InterfaceC13082d<T> {

    /* JADX INFO: renamed from: s.a.d2.a$a */
    /* JADX INFO: compiled from: Flow.kt */
    @InterfaceC12188e(m10084c = "kotlinx.coroutines.flow.AbstractFlow", m10085f = "Flow.kt", m10086l = {212}, m10087m = "collect")
    public static final class a extends AbstractC12187d {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AbstractC13079a.this.mo11246a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p659s.p660a.p664d2.InterfaceC13082d
    /* JADX INFO: renamed from: a */
    public final Object mo11246a(InterfaceC13083e<? super T> interfaceC13083e, Continuation<? super Unit> continuation) throws Throwable {
        a aVar;
        Throwable th;
        C13089e c13089e;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.label = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = aVar.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c13089e = (C13089e) aVar.L$2;
            try {
                C12113l.throwOnFailure(obj);
                c13089e.releaseIntercepted();
                return Unit.f27425a;
            } catch (Throwable th2) {
                th = th2;
                c13089e.releaseIntercepted();
                throw th;
            }
        }
        C12113l.throwOnFailure(obj);
        C13089e c13089e2 = new C13089e(interfaceC13083e, aVar.getContext());
        try {
            aVar.L$0 = this;
            aVar.L$1 = interfaceC13083e;
            aVar.L$2 = c13089e2;
            aVar.label = 1;
            if (mo11247b(c13089e2, aVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            c13089e = c13089e2;
            c13089e.releaseIntercepted();
            return Unit.f27425a;
        } catch (Throwable th3) {
            th = th3;
            c13089e = c13089e2;
            c13089e.releaseIntercepted();
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract Object mo11247b(InterfaceC13083e<? super T> interfaceC13083e, Continuation<? super Unit> continuation);
}
