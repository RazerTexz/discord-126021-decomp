package d0.w;

import d0.z.d.m;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a implements Serializable {
    private static final long serialVersionUID = 0;
    private final CoroutineContext[] elements;

    static {
        new c$a$a(null);
    }

    public c$a(CoroutineContext[] coroutineContextArr) {
        m.checkNotNullParameter(coroutineContextArr, "elements");
        this.elements = coroutineContextArr;
    }

    private final Object readResolve() {
        CoroutineContext[] coroutineContextArr = this.elements;
        CoroutineContext coroutineContextPlus = f.j;
        for (CoroutineContext coroutineContext : coroutineContextArr) {
            coroutineContextPlus = coroutineContextPlus.plus(coroutineContext);
        }
        return coroutineContextPlus;
    }
}
