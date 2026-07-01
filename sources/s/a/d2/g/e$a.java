package s.a.d2.g;

import d0.z.d.o;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a extends o implements Function2<Integer, CoroutineContext$Element, Integer> {
    public static final e$a j = new e$a();

    public e$a() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Integer invoke(Integer num, CoroutineContext$Element coroutineContext$Element) {
        return Integer.valueOf(num.intValue() + 1);
    }
}
