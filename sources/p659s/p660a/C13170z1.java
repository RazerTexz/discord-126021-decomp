package p659s.p660a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p659s.p660a.p661a.C13018a;
import p659s.p660a.p661a.C13035r;

/* JADX INFO: renamed from: s.a.z1 */
/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13170z1<T> extends C13035r<T> {
    public C13170z1(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // p659s.p660a.p661a.C13035r, p659s.p660a.AbstractC13045b
    /* JADX INFO: renamed from: e0 */
    public void mo11172e0(Object obj) {
        Object objM4259X0 = C3404f.m4259X0(obj, this.f27702m);
        CoroutineContext context = this.f27702m.getContext();
        Object objM11141b = C13018a.m11141b(context, null);
        try {
            this.f27702m.resumeWith(objM4259X0);
        } finally {
            C13018a.m11140a(context, objM11141b);
        }
    }
}
