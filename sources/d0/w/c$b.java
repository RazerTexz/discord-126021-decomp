package d0.w;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$b extends o implements Function2<String, CoroutineContext$Element, String> {
    public static final c$b j = new c$b();

    public c$b() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ String invoke(String str, CoroutineContext$Element coroutineContext$Element) {
        return invoke2(str, coroutineContext$Element);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str, CoroutineContext$Element coroutineContext$Element) {
        m.checkNotNullParameter(str, "acc");
        m.checkNotNullParameter(coroutineContext$Element, "element");
        if (str.length() == 0) {
            return coroutineContext$Element.toString();
        }
        return str + ", " + coroutineContext$Element;
    }
}
