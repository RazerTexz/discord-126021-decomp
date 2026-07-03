package androidx.activity.contextaware;

import android.content.Context;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p592z.p594d.C12237l;
import p659s.p660a.C13126l;

/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware contextAware, Function1<? super Context, ? extends R> function1, Continuation<? super R> continuation) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return function1.invoke(contextPeekAvailableContext);
        }
        C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
        c13126l.m11318A();
        C0039x8a9e0a55 c0039x8a9e0a55 = new C0039x8a9e0a55(c13126l, contextAware, function1);
        contextAware.addOnContextAvailableListener(c0039x8a9e0a55);
        c13126l.mo10902f(new C0040x8a9e0a56(c0039x8a9e0a55, contextAware, function1));
        Object objM11326u = c13126l.m11326u();
        if (objM11326u != C12183c.getCOROUTINE_SUSPENDED()) {
            return objM11326u;
        }
        C12190g.probeCoroutineSuspended(continuation);
        return objM11326u;
    }

    private static final Object withContextAvailable$$forInline(ContextAware contextAware, Function1 function1, Continuation continuation) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return function1.invoke(contextPeekAvailableContext);
        }
        C12237l.mark(0);
        C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
        c13126l.m11318A();
        C0039x8a9e0a55 c0039x8a9e0a55 = new C0039x8a9e0a55(c13126l, contextAware, function1);
        contextAware.addOnContextAvailableListener(c0039x8a9e0a55);
        c13126l.mo10902f(new C0040x8a9e0a56(c0039x8a9e0a55, contextAware, function1));
        Object objM11326u = c13126l.m11326u();
        if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        C12237l.mark(1);
        return objM11326u;
    }
}
