package s.a.a;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;
import s.a.v1;

/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b extends d0.z.d.o implements Function2<Object, CoroutineContext$Element, Object> {
    public static final a$b j = new a$b();

    public a$b() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, CoroutineContext$Element coroutineContext$Element) {
        CoroutineContext$Element coroutineContext$Element2 = coroutineContext$Element;
        if (!(coroutineContext$Element2 instanceof v1)) {
            return obj;
        }
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        int iIntValue = num != null ? num.intValue() : 1;
        return iIntValue == 0 ? coroutineContext$Element2 : Integer.valueOf(iIntValue + 1);
    }
}
