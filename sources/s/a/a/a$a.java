package s.a.a;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;
import s.a.v1;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class a$a extends d0.z.d.o implements Function2<x, CoroutineContext$Element, x> {
    public static final a$a j = new a$a(0);
    public static final a$a k = new a$a(1);
    public final /* synthetic */ int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$a(int i) {
        super(2);
        this.l = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final x invoke(x xVar, CoroutineContext$Element coroutineContext$Element) {
        int i = this.l;
        if (i == 0) {
            x xVar2 = xVar;
            CoroutineContext$Element coroutineContext$Element2 = coroutineContext$Element;
            if (coroutineContext$Element2 instanceof v1) {
                CoroutineContext coroutineContext = xVar2.c;
                Object[] objArr = xVar2.a;
                int i2 = xVar2.f3832b;
                xVar2.f3832b = i2 + 1;
                ((v1) coroutineContext$Element2).y(coroutineContext, objArr[i2]);
            }
            return xVar2;
        }
        if (i != 1) {
            throw null;
        }
        x xVar3 = xVar;
        CoroutineContext$Element coroutineContext$Element3 = coroutineContext$Element;
        if (coroutineContext$Element3 instanceof v1) {
            Object objC = ((v1) coroutineContext$Element3).C(xVar3.c);
            Object[] objArr2 = xVar3.a;
            int i3 = xVar3.f3832b;
            xVar3.f3832b = i3 + 1;
            objArr2[i3] = objC;
        }
        return xVar3;
    }
}
