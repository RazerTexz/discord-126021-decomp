package s.a;

import d0.z.d.Lambda;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Executors;

/* JADX INFO: renamed from: s.a.u0, reason: use source file name */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Executors4 extends Lambda implements Function1<CoroutineContext.Element, Executors> {
    public static final Executors4 j = new Executors4();

    public Executors4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Executors invoke(CoroutineContext.Element element) {
        CoroutineContext.Element element2 = element;
        if (!(element2 instanceof Executors)) {
            element2 = null;
        }
        return (Executors) element2;
    }
}
