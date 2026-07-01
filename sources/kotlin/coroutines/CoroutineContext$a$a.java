package kotlin.coroutines;

import d0.w.c;
import d0.w.d;
import d0.w.d$b;
import d0.w.f;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineContext$a$a extends o implements Function2<CoroutineContext, CoroutineContext$Element, CoroutineContext> {
    public static final CoroutineContext$a$a j = new CoroutineContext$a$a();

    public CoroutineContext$a$a() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext$Element coroutineContext$Element) {
        return invoke2(coroutineContext, coroutineContext$Element);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CoroutineContext invoke2(CoroutineContext coroutineContext, CoroutineContext$Element coroutineContext$Element) {
        c cVar;
        m.checkNotNullParameter(coroutineContext, "acc");
        m.checkNotNullParameter(coroutineContext$Element, "element");
        CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(coroutineContext$Element.getKey());
        f fVar = f.j;
        if (coroutineContextMinusKey == fVar) {
            return coroutineContext$Element;
        }
        int i = d.e;
        d$b d_b = d$b.a;
        d dVar = (d) coroutineContextMinusKey.get(d_b);
        if (dVar == null) {
            cVar = new c(coroutineContextMinusKey, coroutineContext$Element);
        } else {
            CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(d_b);
            if (coroutineContextMinusKey2 == fVar) {
                return new c(coroutineContext$Element, dVar);
            }
            cVar = new c(new c(coroutineContextMinusKey2, coroutineContext$Element), dVar);
        }
        return cVar;
    }
}
