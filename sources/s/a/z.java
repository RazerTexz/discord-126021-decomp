package s.a;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public static final boolean a;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r0.equals("on") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (r0.equals("") != false) goto L19;
     */
    static {
        boolean z2;
        String strK1 = b.i.a.f.e.o.f.k1("kotlinx.coroutines.scheduler");
        if (strK1 != null) {
            int iHashCode = strK1.hashCode();
            if (iHashCode != 0) {
                if (iHashCode != 3551) {
                    z2 = (iHashCode == 109935 && strK1.equals("off")) ? false : true;
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + strK1 + '\'').toString());
            }
        }
        a = z2;
    }

    public static final CoroutineContext a(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextPlus = coroutineScope.getCoroutineContext().plus(coroutineContext);
        CoroutineDispatcher coroutineDispatcher = k0.a;
        if (coroutineContextPlus == coroutineDispatcher) {
            return coroutineContextPlus;
        }
        int i = d0.w.d.e;
        return coroutineContextPlus.get(d0.w.d$b.a) == null ? coroutineContextPlus.plus(coroutineDispatcher) : coroutineContextPlus;
    }
}
